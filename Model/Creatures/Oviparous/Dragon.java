package Model.Creatures.Oviparous;

import Model.Creatures.Type.Runner;
import Model.Creatures.Type.Swimmer;
import Model.Creatures.Type.Flyer;
import Model.Creatures.Type.Renascent;

public class Dragon extends Oviparous implements Runner, Swimmer, Flyer, Renascent {

    public Dragon(String species, String gender, double weight, double size, int age, int hungerLevel) {
        super(species, gender, weight, size, age, 20, hungerLevel);
    }

    @Override
    public void makeSound() {
        System.out.println(getSpecies() + " *AGROUUUUUUUUUUUUU*");
    }
}