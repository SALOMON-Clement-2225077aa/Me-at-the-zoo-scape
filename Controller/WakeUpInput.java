package Controller;

import Model.Creatures.Creature;
import Model.Enclosure.Enclosure;
import View.UI;

import java.util.ArrayList;

/**
 * La classe WakeUpInput gère l'action de réveiller les créatures endormies dans un enclos.
 */
public class WakeUpInput {

    /**
     * Réveille les créatures endormies dans l'enclos actuel.
     *
     * @param ui            L'interface utilisateur utilisée pour l'affichage.
     * @param ListEnclosure La liste des enclos du zoo.
     * @return              Une String d'informations sur l'action effectuée.
     */
    public static String wakeCreatureUp(UI ui, ArrayList<Enclosure> ListEnclosure) {

        Enclosure currentEnclosure = ListEnclosure.get(ui.getPosition());
        ArrayList<Creature> currentEnclosureCreatures = currentEnclosure.getCreatures();
        int nbCreatureAwaken = 0;

        for (Creature creature : currentEnclosureCreatures) {
            if (creature.isSleeping) {
                creature.isSleeping = false;
                nbCreatureAwaken += 1;
            }
        }

        if (nbCreatureAwaken == 0) {
            return "None of the " + currentEnclosureCreatures.get(0).species + "s are sleeping";
        }
        if (nbCreatureAwaken == 1) {
            return "A creature has been awakened";
        } else {
            return "Everyone has been awakened!";
        }
    }
}
