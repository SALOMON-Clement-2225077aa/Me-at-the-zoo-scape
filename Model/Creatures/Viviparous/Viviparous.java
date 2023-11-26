package Model.Creatures.Viviparous;

import Model.Creatures.Creature;

public abstract class Viviparous extends Creature {

    private int gestationDuration;

    public Viviparous(String species, String gender, double weight, double size, int age, int gestationDuration, int hungerLevel) {
        super(species, gender, weight, size, age, hungerLevel);
        this.gestationDuration = gestationDuration;
    }

    // Méthode supplémentaire
    void giveBirth() { // (mettre bas)

    }
}