package Model.Creatures.Oviparous;

import Model.Creatures.Type.Runner;
import Model.Creatures.Type.Swimmer;
import Model.Creatures.Type.Flyer;
import Model.Creatures.Type.Renascent;

import java.util.ArrayList;

/**
 * La classe Dragon représente un dragon, une créature ovipare pouvant courir, nager, voler et ayant la capacité de renaître.
 * Elle hérite de la classe abstraite Oviparous et implémente les interfaces Runner, Swimmer, Flyer et Renascent.
 */
public class Dragon extends Oviparous implements Runner, Swimmer, Flyer, Renascent {

    /**
     * Constructeur de la classe Dragon.
     *
     * @param species      Le nom de l'espèce du dragon.
     * @param gender       Le genre du dragon.
     * @param weight       Le poids du dragon.
     * @param size         La taille du dragon.
     * @param age          L'âge du dragon.
     * @param hungerLevel  Le niveau de faim initial du dragon.
     */
    public Dragon(String species, String gender, double weight, double size, int age, int hungerLevel) {
        super(species, gender, weight, size, age, 20, hungerLevel);
    }

    /**
     * Implémentation de la méthode makeSound spécifique au dragon.
     *
     * @param creatureActionLog La liste des actions de la créature pour le suivi.
     */
    @Override
    public void makeSound(ArrayList<String> creatureActionLog) {
        creatureActionLog.add("\u001B[90m"+getSpecies() + " *AGROUUUUUUUUUUUUU*\u001B[0m");
    }
}