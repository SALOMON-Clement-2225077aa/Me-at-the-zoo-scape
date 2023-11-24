package Model.Creatures.Oviparous;

import Model.Creatures.Creature;

public abstract class Oviparous extends Creature {

    private int incubationDuration;

    public Oviparous(String species, String gender, double weight, double size, int age, int incubationDuration) {
        super(species, gender, weight, size, age);
        this.incubationDuration = incubationDuration;
    }

    // Méthode supplémentaire
    void lay() { // (pondre un oeuf)

    }
}
