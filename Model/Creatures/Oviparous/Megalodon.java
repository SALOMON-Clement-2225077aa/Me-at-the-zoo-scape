package Model.Creatures.Oviparous;

import Model.Creatures.Type.Swimmer;

import java.util.ArrayList;

/**
 * La classe Megalodon représente un megalodon, une créature ovipare ayant la capacité de nager.
 * Elle hérite de la classe abstraite Oviparous et implémente l'interface Swimmer.
 */
public class Megalodon extends Oviparous implements Swimmer {

    /**
     * Constructeur de la classe Megalodon.
     *
     * @param species      Le nom de l'espèce du megalodon.
     * @param gender       Le genre du megalodon.
     * @param weight       Le poids du megalodon.
     * @param size         La taille du megalodon.
     * @param age          L'âge du megalodon.
     * @param hungerLevel  Le niveau de faim initial du megalodon.
     */
    public Megalodon(String species, String gender, double weight, double size, int age, int hungerLevel) {
        super(species, gender, weight, size, age, 30, hungerLevel);
    }

    /**
     * Implémentation de la méthode makeSound spécifique au megalodon.
     *
     * @param creatureActionLog La liste des actions de la créature pour le suivi.
     */
    @Override
    public void makeSound(ArrayList<String> creatureActionLog) {
        creatureActionLog.add("\u001B[90m"+getSpecies() + " *GLOUGLOUGLOUGLGOU*\u001B[0m");
    }
}
