package Creatures.Ovipares;

import Creatures.type.coureur;
import Creatures.type.nageant;
import Creatures.type.renaissant;
import Creatures.type.volant;

public class dragon extends Ovipare implements coureur, nageant, volant, renaissant {

    public dragon(String species, String gender, double weight, double size, int age) {
        super(species, gender, weight, size, age);
    }

    @Override
    public void makeSound() {

    }
}
