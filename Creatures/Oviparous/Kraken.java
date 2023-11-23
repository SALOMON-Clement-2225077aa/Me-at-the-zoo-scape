package Creatures.Oviparous;

import Creatures.type.Swimmer;

public class Kraken extends Oviparous implements Swimmer {

    public Kraken(String species, String gender, double weight, double size, int age) {
        super(species, gender, weight, size, age);
    }

    @Override
    public void makeSound() {
        System.out.println("OQUFHQIUDFGBQDUGVDQB");
    }
}