package Model.Creatures;

import Model.Enclosure.Enclosure;

import java.util.Random;

public abstract class Creature {

    // Variables
    public String species;
    public String gender;
    public double weight;
    public double size;
    public int age;
    public int hungerLevel;
    public int health;
    public boolean isSleeping;
    public int[] possibleAction;
    public Enclosure enclosure;
    public boolean isDead = false;
    public boolean wantToReproduce = false;

    // Constructeur
    public Creature(String species, String gender, double weight, double size, int age,int hungerLevel) {
        this.species = species;
        this.gender = gender;
        this.weight = weight;
        this.size = size;
        this.age = age;
        this.hungerLevel = hungerLevel;
        this.health = 30;
        this.isSleeping = false;
        this.possibleAction = createPossibleAction();
    }

    public String getGender() {
        return gender;
    }

    public int[] createPossibleAction() {
        // 0 = do nothing                     => 10%
        // 1 = -1 hunger                      => 35%
        // 2 = +1 age                         => 20%
        // 3 = poop (+1 enclosure dirtiness)  => 15%
        // 4 = make sound                     => 5%
        // 5 = sleep/wakeUp                   => 5%
        // 6  = want to reproduce state       => 10%

        int[] possibleAction = new int[100];;
        int index = 0;

        for (int i = 0; i < 10; i++) {
            possibleAction[index++] = 0; // "do nothing"
        }
        for (int i = 0; i < 35; i++) {
            possibleAction[index++] = 1; // "-1 hunger"
        }
        for (int i = 0; i < 20; i++) {
            possibleAction[index++] = 2; // "+1 age"
        }
        for (int i = 0; i < 15; i++) {
            possibleAction[index++] = 3; // "poop"
        }
        for (int i = 0; i < 5; i++) {
            possibleAction[index++] = 4; // "make sound"
        }
        for (int i = 0; i < 5; i++) {
            possibleAction[index++] = 5; // "sleep/wakeUp"
        }
        for (int i = 0; i < 10; i++) {
            possibleAction[index++] = 6; // "reproduce state"
        }
        return possibleAction;
    }

    public void doSomething() {
        Random random = new Random();
        int rdNb = random.nextInt(100); //Nb entre 0 et 99
        int selectedAction = possibleAction[rdNb];
        int zeroOrOne = random.nextInt(2); //Nb entre 0 et 1 compris

        // Si l'enclos est sale la créature à 1/2 chance de perdre de la vie
        if(enclosure.enclosureDirtiness >= 95 && zeroOrOne == 1) {
            ill();
        }
        // Sinon elle fait une action au hasard selon les probas définies plus haut
        else {
            switch (selectedAction) {
                case 0:
                    break;
                case 1:
                    hunger();
                    break;
                case 2:
                    age();
                    break;
                case 3:
                    poop();
                    break;
                case 4:
                    makeSound();
                    break;
                case 5:
                    sleepOrWakeUp();
                    break;
                case 6 :
                    reproduceState();
                default:
                    System.out.println("Invalid action");
                    break;
            }
        }
    }

    public String getSpecies() {
        return species;
    }

    public void hunger() {
        hungerLevel -= 1;
        if(hungerLevel <= 5) {
            starve();
        }
        if(hungerLevel <= 3) {
            starve();
        }
        if(hungerLevel<0) {
            hungerLevel = 0;
            starve();
        }
    }

    public void eat(){
        if(!isSleeping){
            if(hungerLevel >= 95){
                System.out.println("The " + species + " isn't hungry");
            }
            else{
                hungerLevel += 5;
                System.out.println("You fed the " + species);
            }
        }
        else{
            System.out.println("You can't feed a creature while it's asleep");
        }
    }

    public abstract void makeSound();

    public String heal() {
        if(health == 30){
            return "The " + species + " is already full health";
        }
        else{
            health += 15;
            if(health>30) {
                health = 30;
            }
            return "You heal the " + species;
        }
    }

    public void sleepOrWakeUp() {
        if(isSleeping){
            isSleeping = false;
            System.out.println("The " + species + " is now awake");
        }
        else {
            isSleeping = true;
            System.out.println("\u001B[94mThe " + species + " is now asleep\u001B[0m");
        }
    }

    public void age() {
        age += 1;
        if (age%100==0) {
            die("old age");
        }
    }

    public void reproduceState() {
        wantToReproduce = true;
    }

    public void poop() {
        if (enclosure != null) {
            enclosure.poopInside();
        }
        if(enclosure.enclosureDirtiness > 100) {
            enclosure.enclosureDirtiness = 100;
            ill();
        }
    }

    public void ill() {
        health -= 1;
        if (health == 0) {
            die("illness");
        }
    }

    public void starve() {
        health -= 1;
        if (health == 0) {
            die("starvation");
        }
    }

    public void die (String causeOfDeath) {
        System.out.println("\u001B[31mOh no, a " + species + " died of " + causeOfDeath + " :(\u001B[0m");
        isDead = true;
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    @Override
    public String toString() {
        String color = "";
        String asleepOrAwake = "awake";
        String hunger = "fed up";
        String showHealth = ""+health;

        if(health <= 20){
            showHealth = "\u001B[31m" + health;
        }
        if(hungerLevel<=10) {
            color = "\u001b[31;1m"; // bright red
            hunger = "starving";
        } else if (hungerLevel<=25) {
            color = "\u001B[31m"; //red
            hunger = "hungry";
        } else if(isSleeping) {
            color = "\u001B[94m"; //light blue
            asleepOrAwake = "asleep";
        }
        return color+species + " : " +
                color +
                weight + "kg"+
                ", "+ size + "m" +
                ", " + age + "yo" +
                ", " + asleepOrAwake +
                ", " + hunger +
                ", " + showHealth + "hp" +
                "\u001B[0m";
    }
}
