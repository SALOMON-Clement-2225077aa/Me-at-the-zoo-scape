package Model.Creatures.Oviparous;

import Model.Creatures.Type.Flyer;
import Model.Creatures.Type.Renascent;

import java.util.ArrayList;

public class Phoenix extends Oviparous implements Flyer, Renascent {

    public Phoenix(String species, String gender, double weight, double size, int age, int hungerLevel) {
        super(species, gender, weight, size, age, 40, hungerLevel);
    }

    @Override
    public void makeSound(ArrayList<String> creatureActionLog) {
        creatureActionLog.add("\u001B[90m"+getSpecies() + " *PIOU-PIOOOUUUU*\u001B[0m");
    }
}
