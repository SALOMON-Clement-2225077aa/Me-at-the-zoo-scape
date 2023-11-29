package Model.Creatures.Oviparous;

import Model.Creatures.Type.Swimmer;

public class Kraken extends Oviparous implements Swimmer {

    public Kraken(String species, String gender, double weight, double size, int age, int hungerLevel) {
        super(species, gender, weight, size, age, 10, hungerLevel);
    }

    @Override
    public void makeSound() {
        System.out.println(getSpecies() + " *OQUFHQIUDFGBQDUGVDQB*");
    }
}