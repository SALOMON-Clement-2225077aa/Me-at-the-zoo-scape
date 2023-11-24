package Model.Creatures.Viviparous;

import Model.Creatures.Type.Runner;

public class Unicorn extends Viviparous implements Runner {

    public Unicorn(String species, String gender, double weight, double size, int age) {
        super(species, gender, weight, size, age, 40);
    }

    @Override
    public void makeSound() {
        System.out.println("HIAN HIAN");
    }
}
