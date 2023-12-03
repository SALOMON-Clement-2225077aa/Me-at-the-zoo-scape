package Model.Creatures.Viviparous;

import Model.Creatures.Type.Runner;

import java.util.ArrayList;

public class Unicorn extends Viviparous implements Runner {

    public Unicorn(String species, String gender, double weight, double size, int age, int hungerLevel) {
        super(species, gender, weight, size, age, 40,hungerLevel);
    }

    @Override
    public void makeSound(ArrayList<String> creatureActionLog) {
        creatureActionLog.add("\u001B[90m"+getSpecies() + " *HIAN HIAN*\u001B[0m");
    }
}
