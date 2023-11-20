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
    void eat() {

    }

    void makeSound() {

    }

    void heal() {

    }

    void sleep() {

    }

    void age() {

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
