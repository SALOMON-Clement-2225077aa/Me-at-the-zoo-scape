package Creatures;

public abstract class Creature {

    // Variables
    String species;
    String gender;
    double weight;
    double size;
    int age;
    int hungerLevel;
    int health;
    boolean isSleeping;

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
        if(health == 100){
            System.out.println("The " + species + " is already full health");
        }
        else{
            health = 100;
            System.out.println("You heal the " + species);
        }
    }

    void sleep() {
        if(isSleeping){
            System.out.println("The " + species + " creature is already asleep");
        }
        else {
            isSleeping = true;
            System.out.println("The " + species + " is now asleep");
        }
    }

    void wakeup() {
        if(isSleeping) {
            isSleeping = false;
            System.out.println("The " + species + " creature is now awake");
        }
        else {
            System.out.println("The " + species + " creature is already awake");
        }
    }

    void age() {
        age += 1;
    }

    // Constructeur
    public Creature(String species, String gender, double weight, double size, int age) {
        this.species = species;
        this.gender = gender;
        this.weight = weight;
        this.size = size;
        this.age = age;
        this.hungerLevel = 100; // 100 = rassasié
        this.health = 100;
        this.isSleeping = false;
    }
}
