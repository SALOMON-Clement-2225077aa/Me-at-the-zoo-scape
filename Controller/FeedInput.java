package Controller;

import Model.Creatures.Creature;
import Model.Enclosure.Enclosure;
import View.UI;

import java.util.ArrayList;

public class FeedInput {

    public static void feed(UI ui, ArrayList<Enclosure> ListEnclosure) {

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
        if(nbOfCreatureFed == 0) {
            System.out.println("The " + currentEnclosureCreatures.get(0).getSpecies() + " are not hungry");
        }
        else {
            System.out.println("The " + currentEnclosureCreatures.get(0).getSpecies() + " have been fed");
        }

    }

}
