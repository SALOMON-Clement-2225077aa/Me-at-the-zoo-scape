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
        if(isSleeping = false){
            if(hungerLevel >= 95){
                System.out.println("the creature isn't hungry");
            }
            else{
                hungerLevel += 5;
                System.out.println("you feed the creature");
            }
        }
        else{
            System.out.println("you can't feed a creature while it's asleep");
        }
    }

    public abstract void makeSound();

    public void heal() {
        if(health == 100){
            System.out.println("the creature is already full health");
        }
        else{
            health = 100;
            System.out.println("you heal the creature");
        }
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
