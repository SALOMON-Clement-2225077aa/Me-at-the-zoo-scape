package Creatures.Ovipares;

import Creatures.type.renaissant;
import Creatures.type.volant;

public class phenix extends Ovipare implements volant, renaissant {

    public phenix(String species, String gender, double weight, double size, int age) {
        super(species, gender, weight, size, age);
    }

    @Override
    public void makeSound() {

    }
}
