package Creatures.Oviparous;

import Creatures.type.Runner;
import Creatures.type.Swimmer;
import Creatures.type.Flyer;
import Creatures.type.Renascent;

public class Dragon extends Oviparous implements Runner, Swimmer, Flyer, Renascent {

    public Dragon(String species, String gender, double weight, double size, int age) {
        super(species, gender, weight, size, age);
    }

    @Override
    public void makeSound() {
        System.out.println("AGROUUUUUUUUUUUUU");
    }
}