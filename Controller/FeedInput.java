package Controller;

import Model.Creatures.Creature;
import Model.Enclosure.Enclosure;
import View.UI;

import java.util.ArrayList;

public class FeedInput {

    public static String feed(UI ui, ArrayList<Enclosure> ListEnclosure) {
        String infoInput = "";

        Enclosure currentEnclosure = ListEnclosure.get(ui.getPosition());
        ArrayList<Creature> currentEnclosureCreatures = currentEnclosure.getCreatures();
        int nbOfCreatureFed = 0;

        for (Creature creature : currentEnclosureCreatures) {
            if(creature.hungerLevel<80) {
                creature.hungerLevel += 50;
                nbOfCreatureFed += 1;
            }
            if(creature.hungerLevel>100) {
                creature.hungerLevel=100;
            }
        }
        if(!(currentEnclosureCreatures.size()==0)) {
            if(nbOfCreatureFed == 0) {
                infoInput = "The " + currentEnclosureCreatures.get(0).getSpecies() + " are not hungry";
            }
            else {
                infoInput = "The " + currentEnclosureCreatures.get(0).getSpecies() + " have been fed";
            }
        }
        else {
            infoInput = "There are no creature here.";
        }
        return infoInput;
    }

}
