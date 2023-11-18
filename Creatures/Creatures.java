package Creatures;

abstract class Creatures {

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
    abstract void eat();
    abstract void makeSound();
    abstract void heal();
    abstract void sleep();
    abstract void age();
}
