package Model.Creatures;

import Model.Creatures.Oviparous.Dragon;
import Model.Creatures.Oviparous.Kraken;
import Model.Creatures.Oviparous.Megalodon;
import Model.Creatures.Oviparous.Phoenix;
import Model.Creatures.Viviparous.Lycanthrope.Lycanthrope;
import Model.Creatures.Viviparous.Mermaid;
import Model.Creatures.Viviparous.Nymph;
import Model.Creatures.Viviparous.Unicorn;
import Model.Enclosure.Enclosure;

import java.util.Objects;
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
    public boolean isIll = false;
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
        // 0 = do nothing                     => 19%
        // 1 = -1 hunger                      => 35%
        // 2 = +1 age                         => 20%
        // 3 = poop (+1 enclosure dirtiness)  => 15%
        // 4 = make sound                     => 5%
        // 5 = sleep/wakeUp                   => 5%
        // 6 = change reproduce state         => 1%

        int[] possibleAction = new int[100];;
        int index = 0;

        for (int i = 0; i < 19; i++) {
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
        for (int i = 0; i < 1; i++) {
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
                    changeReproduceState();
                    break;
                default:
                    System.out.println("Invalid action : " + selectedAction);
                    break;
            }
        }
    }

    public String getSpecies() {
        return species;
    }

    public void hunger() {
        hungerLevel -= 1;
        if(hungerLevel == 20) {
            System.out.println("\u001b[31mA" + this.getSpecies() + " is hungry\u001b[0m");
        }
        if(hungerLevel == 10) {
            System.out.println("\u001b[31;1mA" + this.getSpecies() + "is starving !\u001b[0m");
        }
        if(hungerLevel <= 10) {
            starve();
        }
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
                System.out.println("The " + species + "s aren't hungry");
            }
            else{
                hungerLevel += 5;
                System.out.println("You fed the " + species + "s");
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
        }
        else {
            isSleeping = true;
        }
    }

    public void age() {
        age += 1;
        if (age%100==0) {
            die("old age");
        }
    }

    public void changeReproduceState() {
        if(wantToReproduce) {
            wantToReproduce = false;
        }
        else {
            wantToReproduce = true;
        }
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
        } else if (hungerLevel<=20) {
            color = "\u001B[31m"; //red
            hunger = "hungry";
        } else if(isSleeping) {
            color = "\u001B[94m"; //light blue
            asleepOrAwake = "asleep";
        }
        return color+species + " : " +
                color +
                gender + ", " +
                weight + "kg"+
                ", "+ size + "m" +
                ", " + age + "yo" +
                ", " + asleepOrAwake +
                ", " + hunger +
                ", " + showHealth + "hp" +
                "\u001B[0m";
    }

    public Creature createNewCreature(Creature c) {
        String species = c.getSpecies();
        if (Objects.equals(species, "Unicorn")) {
            Unicorn babyUnicorn = new Unicorn("Unicorn", c.getGender(), c.weight / 2, c.size / 2, 1, 100);
            c.enclosure.addCreature(babyUnicorn);
            babyUnicorn.setEnclosure(c.enclosure);
            return babyUnicorn;
        }
        if (Objects.equals(species, "Mermaid")) {
            Mermaid babyMermaid = new Mermaid("Mermaid", c.getGender(), c.weight / 2, c.size / 2, 1, 100);
            c.enclosure.addCreature(babyMermaid);
            babyMermaid.setEnclosure(c.enclosure);
            return babyMermaid;
        }
        if (Objects.equals(species, "Nymph")) {
            Nymph babyNymph = new Nymph("Nymph", c.getGender(), c.weight / 2, c.size / 2, 1, 100);
            c.enclosure.addCreature(babyNymph);
            babyNymph.setEnclosure(c.enclosure);
            return babyNymph;
        }
        if (Objects.equals(species, "Lycanthrope")) {
            Lycanthrope babyLycanthrope = new Lycanthrope("Lycanthrope", c.getGender(), c.weight / 2, c.size / 2, 1, 0, 100, 0, 0, 0, 0, "",null,"");
            c.enclosure.addCreature(babyLycanthrope);
            babyLycanthrope.setEnclosure(c.enclosure);
            return babyLycanthrope;
        }
        if (Objects.equals(species, "Dragon")) {
            Dragon babyDragon = new Dragon("Dragon", c.getGender(), c.weight / 2, c.size / 2, 1, 100);
            c.enclosure.addCreature(babyDragon);
            babyDragon.setEnclosure(c.enclosure);
            return babyDragon;
        }
        if (Objects.equals(species, "Megalodon")) {
            Megalodon babyMegalodon = new Megalodon("Megalodon", c.getGender(), c.weight / 2, c.size / 2, 1, 100);
            c.enclosure.addCreature(babyMegalodon);
            babyMegalodon.setEnclosure(c.enclosure);
            return babyMegalodon;
        }
        if (Objects.equals(species, "Kraken")) {
            Kraken babyKraken = new Kraken("Kraken", c.getGender(), c.weight / 2, c.size / 2, 1, 100);
            c.enclosure.addCreature(babyKraken);
            babyKraken.setEnclosure(c.enclosure);
            return babyKraken;
        }
        if (Objects.equals(species, "Phoenix")) {
            Phoenix babyPhoenix = new Phoenix("Phoenix", c.getGender(), c.weight / 2, c.size/ 2, 1, 100);
            c.enclosure.addCreature(babyPhoenix);
            babyPhoenix.setEnclosure(c.enclosure);
            return babyPhoenix;
        }
        return null;
    }
}
