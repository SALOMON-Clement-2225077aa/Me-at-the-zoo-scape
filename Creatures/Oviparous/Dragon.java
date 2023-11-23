package Creatures.Oviparous;

import Creatures.Type.Runner;
import Creatures.Type.Swimmer;
import Creatures.Type.Flyer;
import Creatures.Type.Renascent;

public class Dragon extends Oviparous implements Runner, Swimmer, Flyer, Renascent {

    public Dragon(String species, String gender, double weight, double size, int age) {
        super(species, gender, weight, size, age, 20);
    }

    @Override
    public void makeSound() {
        System.out.println("AGROUUUUUUUUUUUUU");
    }
}