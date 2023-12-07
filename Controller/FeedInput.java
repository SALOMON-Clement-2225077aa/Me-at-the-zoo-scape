package Controller;

import Model.Creatures.Creature;
import Model.Enclosure.Enclosure;
import View.UI;

import java.util.ArrayList;

/**
 * La classe FeedInput gère l'action de nourrir les créatures dans un enclos.
 */
public class FeedInput {

    /**
     * Nourrit les créatures dans l'enclos actuel.
     *
     * @param ui            L'interface utilisateur utilisée pour l'affichage.
     * @param ListEnclosure La liste des enclos du zoo.
     * @return              Une String d'informations sur l'action effectuée.
     */
    public static String feed(UI ui, ArrayList<Enclosure> ListEnclosure) {
        String infoInput = "";

        Enclosure currentEnclosure = ListEnclosure.get(ui.getPosition());
        ArrayList<Creature> currentEnclosureCreatures = currentEnclosure.getCreatures();
        int nbOfCreatureFed = 0;
        boolean isThereSleepyCreature = false;

        for (Creature creature : currentEnclosureCreatures) {
            if (creature.hungerLevel < 90 && !creature.isSleeping) {
                creature.hungerLevel += 50;
                nbOfCreatureFed += 1;
            }
            if (creature.hungerLevel > 100) {
                creature.hungerLevel = 100;
            }
            if (creature.isSleeping) {
                isThereSleepyCreature = true;
            }
        }

        if (!(currentEnclosureCreatures.size() == 0)) {
            if (nbOfCreatureFed == 0 && isThereSleepyCreature) {
                infoInput = "The " + currentEnclosureCreatures.get(0).getSpecies() + "s are not hungry or sleeping";
            }
            if (nbOfCreatureFed == 0 && !isThereSleepyCreature) {
                infoInput = "The " + currentEnclosureCreatures.get(0).getSpecies() + "s are not hungry";
            } else {
                if (isThereSleepyCreature) {
                    infoInput = "You fed some " + currentEnclosureCreatures.get(0).getSpecies() + "s but some of them were sleeping";
                } else {
                    infoInput = "You fed all the " + currentEnclosureCreatures.get(0).getSpecies() + "s";
                }
            }
        } else {
            infoInput = "There are no creatures here.";
        }

        return infoInput;
    }
}
