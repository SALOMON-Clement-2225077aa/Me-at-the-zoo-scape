package Creatures.Oviparous;

import Creatures.type.Swimmer;

public class Megalodon extends Oviparous implements Swimmer {

    public Megalodon(String species, String gender, double weight, double size, int age) {
        super(species, gender, weight, size, age, 30);
    }

    @Override
    public void makeSound() {
        System.out.println("GLOUGLOUGLOUGLGOU");
    }
}
