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

    public int[] createPossibleAction() {
        // 0 = do nothing                     => 20%
        // 1 = -1 hunger                      => 35%
        // 2 = +1 age                         => 20%
        // 3 = poop (+1 enclosure dirtiness)  => 15%
        // 4 = make sound                     => 5%
        // 5 = sleep/wakeUp                   => 5%

        int[] possibleAction = new int[100];;
        int index = 0;

        for (int i = 0; i < 20; i++) {
            possibleAction[index++] = 0; // "do nothing"
        }
        for (int i = 0; i < 35; i++) {
            possibleAction[index++] = 1; // "-1 hunger"
        }
        for (int i = 0; i < 20; i++) {
            possibleAction[index++] = 2; // "+1 age"
        }
        for (int i = 0; i < 15; i++) {
            possibleAction[index++] = 3; // "make sound"
        }
        for (int i = 0; i < 5; i++) {
            possibleAction[index++] = 4; // "poop"
        }
        for (int i = 0; i < 5; i++) {
            possibleAction[index++] = 5; // "sleep/wakeUp"
        }
        return possibleAction;
    }

    public void doSomething() {
        Random random = new Random();
        int rdNb = random.nextInt(100); //Nb entre 0 et 99
        int selectedAction = possibleAction[rdNb];

        switch (selectedAction) {
            case 0:
                break;
            case 1:
                hungerLevel -= 1;
                break;
            case 2:
                age();
                break;
            case 3:
                makeSound();
                break;
            case 4:
                poop();
                break;
            case 5:
                sleepOrWakeUp();
                break;
            default:
                System.out.println("Invalid action");
                break;
        }
    }

    public String getSpecies() {
        return species;
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

    public void heal() {
        if(health == 30){
            System.out.println("The " + species + " is already full health");
        }
        else{
            health = 30;
            System.out.println("You heal the " + species);
        }
    }

    public void sleepOrWakeUp() {
        if(isSleeping){
            isSleeping = false;
            System.out.println("The " + species + " is now awake");
        }
        else {
            isSleeping = true;
            System.out.println("The " + species + " is now asleep");
        }
    }

    public void age() {
        age += 1;
        if (age >= 100) {
            die();
        }
    }

    public void poop() {
        if (enclosure != null) {
            enclosure.poopInside();
        }
    }

    public void ill() {
        health -= 1;
        if (health == 0) {
            die();
        }
    }

    public void die () {
        System.out.println("Oh no, a " + species + " died :(");
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    @Override
    public String toString() {
        String color = "";
        if(hungerLevel<=25) {
            color = "\u001B[31m"; //red
        } else if(isSleeping) {
            color = "\u001B[94m"; //light blue
        }
        return color+species + " : " +
                color +
                ", " + weight + "kg"+
                ", "+ size + "m" +
                ", " + age + "yo" +
                ", " + health + "hp" +
                ", asleep=" + isSleeping +
                ", hungerlvl=" + hungerLevel +
                "}\u001B[0m";
    }
}
