package Model.Creatures.Oviparous;

import Model.Creatures.Creature;

public abstract class Oviparous extends Creature {

    private int incubationDuration;

    public Oviparous(String species, String gender, double weight, double size, int age, int incubationDuration, int hungerLevel) {
        super(species, gender, weight, size, age, hungerLevel);
        this.incubationDuration = incubationDuration;
    }
}