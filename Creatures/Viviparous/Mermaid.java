package Creatures.Viviparous;

import Creatures.type.Swimmer;

public class Mermaid extends Viviparous implements Swimmer {

    public Mermaid(String species, String gender, double weight, double size, int age) {
        super(species, gender, weight, size, age, 20);
    }

    @Override
    public void makeSound() {
        System.out.println("SPLOUCH");
    }
}
