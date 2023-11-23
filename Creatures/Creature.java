package Creatures;

public abstract class Creature {

    // Variables
    private String species;
    private String gender;
    private double weight;
    private double size;
    private int age;
    private int hungerLevel;
    private int slumberLevel;
    private int health;
    private boolean isSleeping;

        // Constructeur
    public Creature(String species, String gender, double weight, double size, int age) {
        this.species = species;
        this.gender = gender;
        this.weight = weight;
        this.size = size;
        this.age = age;
        this.hungerLevel = 100; // 100 = rassasié
        this.slumberLevel = 100; // 100 = en pleine forme
        this.health = 30;
        this.isSleeping = false;
    }

    public String getSpecies() {
        return species;
    }

    // Méthodes
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

    public void sleep() {
        if(isSleeping){
            System.out.println("The " + species + " creature is already asleep");
        }
        else {
            isSleeping = true;
            System.out.println("The " + species + " is now asleep");
        }
    }

    public void wakeup() {
        if(isSleeping) {
            isSleeping = false;
            System.out.println("The " + species + " creature is now awake");
        }
        else {
            System.out.println("The " + species + " creature is already awake");
        }
    }

    public void age() {
        age += 1;
        if (age >= 100) {
            die();
        }
    }

    public void ill () {
        health -= 1;
        if (health == 0) {
            die();
        }
    }

    void die () {
    }
}
