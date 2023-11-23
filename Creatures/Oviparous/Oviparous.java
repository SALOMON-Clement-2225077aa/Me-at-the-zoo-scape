package Creatures.Oviparous;

import Creatures.Creature;

public abstract class Oviparous extends Creature {

    public Oviparous(String species, String gender, double weight, double size, int age) {
        super(species, gender, weight, size, age);
    }

    // Méthode supplémentaire
    void Lay() { // (pondre un oeuf)

    }
}
