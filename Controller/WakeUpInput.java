package Controller;

import Model.Creatures.Creature;
import Model.Enclosure.Enclosure;
import View.UI;

import java.util.ArrayList;

public class WakeUpInput {

    public static String wakeCreatureUp(UI ui, ArrayList<Enclosure> ListEnclosure) {

        Enclosure currentEnclosure = ListEnclosure.get(ui.getPosition());
        ArrayList<Creature> currentEnclosureCreatures = currentEnclosure.getCreatures();
        int nbCreatureAwaken = 0;

        for (Creature creature : currentEnclosureCreatures) {
            if(creature.isSleeping) {
                creature.isSleeping = false;
                nbCreatureAwaken += 1;
            }
        }

        if(nbCreatureAwaken == 0) {
            return "None of the "+currentEnclosureCreatures.get(0).species+"s are sleeping";
        }
        if(nbCreatureAwaken == 1) {
            return "A creature have been awaken";
        }
        else {
            return "Everyone has been awaken !";
        }
    }
}
