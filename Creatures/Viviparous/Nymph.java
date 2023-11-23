package Creatures.Viviparous;

import Creatures.Type.Renascent;

public class Nymph extends Viviparous implements Renascent {

    public Nymph(String species, String gender, double weight, double size, int age) {
        super(species, gender, weight, size, age, 30);
    }

    @Override
    public void makeSound() {
        System.out.println("YOUUUUUUUUUUUUUUU");
    }
}
