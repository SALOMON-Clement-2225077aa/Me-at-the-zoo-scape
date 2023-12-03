package Model.Creatures.Viviparous;

import Model.Creatures.Type.Renascent;

import java.util.ArrayList;

public class Nymph extends Viviparous implements Renascent {

    public Nymph(String species, String gender, double weight, double size, int age, int hungerLevel) {
        super(species, gender, weight, size, age, 30, hungerLevel);
    }

    @Override
    public void makeSound(ArrayList<String> creatureActionLog) {
        creatureActionLog.add("\u001B[90m"+getSpecies() + " *YOUUUUUUUUUUUUUUU*\u001B[0m");
    }
}
