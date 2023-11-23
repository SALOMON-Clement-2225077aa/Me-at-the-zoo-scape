package Creatures.Oviparous;

import Creatures.Type.Swimmer;

public class Kraken extends Oviparous implements Swimmer {

    public Kraken(String species, String gender, double weight, double size, int age) {
        super(species, gender, weight, size, age, 10);
    }

    @Override
    public void makeSound() {
        System.out.println("OQUFHQIUDFGBQDUGVDQB");
    }
}