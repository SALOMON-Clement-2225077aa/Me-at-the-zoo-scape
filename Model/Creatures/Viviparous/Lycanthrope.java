package Model.Creatures.Viviparous;

import Model.Creatures.Type.Runner;

public class Lycanthrope extends Viviparous implements Runner {

    public Lycanthrope(String species, String gender, double weight, double size, int age, int hungerLevel) {
        super(species, gender, weight, size, age, 10, hungerLevel);
    }

    @Override
    public void makeSound() {
        System.out.println(getSpecies() + " *WAF WAF WAOUUUF*");
    }
}
