package Model.Creatures.Viviparous;

import Model.Creatures.Type.Runner;

public class Lycanthrope extends Viviparous implements Runner {

    public Lycanthrope(String species, String gender, double weight, double size, int age) {
        super(species, gender, weight, size, age, 10);
    }

    @Override
    public void makeSound() {
        System.out.println("WAF WAF WAOUUUF");
    }
}
