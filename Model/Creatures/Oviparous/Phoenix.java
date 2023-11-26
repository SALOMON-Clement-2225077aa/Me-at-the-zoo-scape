package Model.Creatures.Oviparous;

import Model.Creatures.Type.Flyer;
import Model.Creatures.Type.Renascent;

public class Phoenix extends Oviparous implements Flyer, Renascent {

    public Phoenix(String species, String gender, double weight, double size, int age, int hungerLevel) {
        super(species, gender, weight, size, age, 40, hungerLevel);
    }

    @Override
    public void makeSound() {
        System.out.println("PIOU PIOU");
    }
}