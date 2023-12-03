package Model.Creatures.Oviparous;

import Model.Creatures.Type.Swimmer;

import java.util.ArrayList;

public class Kraken extends Oviparous implements Swimmer {

    public Kraken(String species, String gender, double weight, double size, int age, int hungerLevel) {
        super(species, gender, weight, size, age, 10, hungerLevel);
    }

    @Override
    public void makeSound(ArrayList<String> creatureActionLog) {
        creatureActionLog.add("\u001B[90m"+getSpecies() + " *OQUFHQIUDFGBQDUGVDQB*\u001B[0m");
    }
}