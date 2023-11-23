package Creatures.Vivipares;

import Creatures.type.coureur;

public class lycanthrope extends Vivipare implements coureur {

    public lycanthrope(String species, String gender, double weight, double size, int age) {
        super(species, gender, weight, size, age);
    }

    @Override
    public void makeSound() {

    }

}
