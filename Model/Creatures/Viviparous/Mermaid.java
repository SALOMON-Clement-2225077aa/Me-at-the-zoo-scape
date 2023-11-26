package Model.Creatures.Viviparous;

import Model.Creatures.Type.Swimmer;

public class Mermaid extends Viviparous implements Swimmer {

    public Mermaid(String species, String gender, double weight, double size, int age, int hungerLevel) {
        super(species, gender, weight, size, age, 20, hungerLevel);
    }

    @Override
    public void makeSound() {
        System.out.println("SPLOUCH");
    }
}
