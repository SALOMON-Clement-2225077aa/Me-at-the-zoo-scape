package Model.Creatures.Oviparous;

import Model.Creatures.Type.Flyer;
import Model.Creatures.Type.Renascent;

import java.util.ArrayList;

/**
 * La classe Phoenix représente un phénix, une créature ovipare ayant la capacité de voler et la capacité de renaître.
 * Elle hérite de la classe abstraite Oviparous et implémente les interfaces Flyer et Renascent.
 */
public class Phoenix extends Oviparous implements Flyer, Renascent {

    /**
     * Constructeur de la classe Phoenix.
     *
     * @param species      Le nom de l'espèce du phénix.
     * @param gender       Le genre du phénix.
     * @param weight       Le poids du phénix.
     * @param size         La taille du phénix.
     * @param age          L'âge du phénix.
     * @param hungerLevel  Le niveau de faim initial du phénix.
     */
    public Phoenix(String species, String gender, double weight, double size, int age, int hungerLevel) {
        super(species, gender, weight, size, age, 40, hungerLevel);
    }

    /**
     * Implémentation de la méthode makeSound spécifique au phénix.
     *
     * @param creatureActionLog La liste des actions de la créature pour le suivi.
     */
    @Override
    public void makeSound(ArrayList<String> creatureActionLog) {
        creatureActionLog.add("\u001B[90m"+getSpecies() + " *PIOU-PIOOOUUUU*\u001B[0m");
    }
}
