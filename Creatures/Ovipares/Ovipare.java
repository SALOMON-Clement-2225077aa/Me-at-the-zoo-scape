package Creatures.Ovipares;

import Creatures.Creature;

public abstract class Ovipare extends Creature {

    public Ovipare(String species, String gender, double weight, double size, int age, int hungerLevel, int health, boolean isSleeping) {
        super(species, gender, weight, size, age, hungerLevel, health, isSleeping);
    }

    // Méthode supplémentaire
    void Lay() { // (pondre un oeuf)

    }
}
