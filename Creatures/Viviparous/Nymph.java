package Creatures.Viviparous;

import Creatures.type.Renascent;

public class Nymph extends Viviparous implements Renascent {

    public Nymph(String species, String gender, double weight, double size, int age) {
        super(species, gender, weight, size, age);
    }

    @Override
    public void makeSound() {
        System.out.println("YOUUUUUUUUUUUUUUU");
    }
}
