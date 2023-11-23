package Creatures.Oviparous;

import Creatures.type.Flyer;
import Creatures.type.Renascent;

public class Phoenix extends Oviparous implements Flyer, Renascent {

    public Phoenix(String species, String gender, double weight, double size, int age) {
        super(species, gender, weight, size, age, 40);
    }

    @Override
    public void makeSound() {
        System.out.println("PIOU PIOU");
    }
}
