package Creatures.Vivipares;

import Creatures.Creature;

public abstract class Vivipare extends Creature {

    public Vivipare(String species, String gender, double weight, double size, int age, int hungerLevel, int health, boolean isSleeping) {
        super(species, gender, weight, size, age, hungerLevel, health, isSleeping);
    }

    // Méthode supplémentaire
    void giveBirth() { // (mettre bas)

    }

}
