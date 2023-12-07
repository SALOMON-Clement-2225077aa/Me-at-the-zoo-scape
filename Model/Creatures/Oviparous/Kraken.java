package Model.Creatures.Oviparous;

import Model.Creatures.Type.Swimmer;

import java.util.ArrayList;

/**
 * La classe Kraken représente un kraken, une créature ovipare ayant la capacité de nager.
 * Elle hérite de la classe abstraite Oviparous et implémente l'interface Swimmer.
 */
public class Kraken extends Oviparous implements Swimmer {

    /**
     * Constructeur de la classe Kraken.
     *
     * @param species      Le nom de l'espèce du kraken.
     * @param gender       Le genre du kraken.
     * @param weight       Le poids du kraken.
     * @param size         La taille du kraken.
     * @param age          L'âge du kraken.
     * @param hungerLevel  Le niveau de faim initial du kraken.
     */
    public Kraken(String species, String gender, double weight, double size, int age, int hungerLevel) {
        super(species, gender, weight, size, age, 10, hungerLevel);
    }

    /**
     * Implémentation de la méthode makeSound spécifique au kraken.
     *
     * @param creatureActionLog La liste des actions de la créature pour le suivi.
     */
    @Override
    public void makeSound(ArrayList<String> creatureActionLog) {
        creatureActionLog.add("\u001B[90m"+getSpecies() + " *OQUFHQIUDFGBQDUGVDQB*\u001B[0m");
    }
}