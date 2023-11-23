package Creatures.Ovipares;

import Creatures.Creature;

public abstract class Ovipare extends Creature {

    public Ovipare(String species, String gender, double weight, double size, int age) {
        super(species, gender, weight, size, age);
    }

    // Méthode supplémentaire
    void Lay() { // (pondre un oeuf)

    }
}
