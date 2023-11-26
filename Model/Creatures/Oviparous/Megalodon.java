package Model.Creatures.Oviparous;

import Model.Creatures.Type.Swimmer;

public class Megalodon extends Oviparous implements Swimmer {

    public Megalodon(String species, String gender, double weight, double size, int age, int hungerLevel) {
        super(species, gender, weight, size, age, 30, hungerLevel);
    }

    @Override
    public void makeSound() {
        System.out.println("GLOUGLOUGLOUGLGOU");
    }
}
