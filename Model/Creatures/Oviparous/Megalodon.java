package Model.Creatures.Oviparous;

import Model.Creatures.Type.Swimmer;

import java.util.ArrayList;

public class Megalodon extends Oviparous implements Swimmer {

    public Megalodon(String species, String gender, double weight, double size, int age, int hungerLevel) {
        super(species, gender, weight, size, age, 30, hungerLevel);
    }

    @Override
    public void makeSound(ArrayList<String> creatureActionLog) {
        creatureActionLog.add("\u001B[90m"+getSpecies() + " *GLOUGLOUGLOUGLGOU*\u001B[0m");
    }
}
