package Model.Creatures.Viviparous;

import Model.Creatures.Type.Renascent;

import java.util.ArrayList;

/**
 * La classe Nymph représente une nymphe, une créature vivipare ayant la capacité de renaître.
 * Elle hérite de la classe abstraite Viviparous et implémente l'interface Renascent.
 */
public class Nymph extends Viviparous implements Renascent {

    /**
     * Constructeur de la classe Nymph.
     *
     * @param species      Le nom de l'espèce de la nymphe.
     * @param gender       Le genre de la nymphe.
     * @param weight       Le poids de la nymphe.
     * @param size         La taille de la nymphe.
     * @param age          L'âge de la nymphe.
     * @param hungerLevel  Le niveau de faim initial de la nymphe.
     */
    public Nymph(String species, String gender, double weight, double size, int age, int hungerLevel) {
        super(species, gender, weight, size, age, 30, hungerLevel);
    }

    /**
     * Implémentation de la méthode makeSound spécifique à la nymphe.
     *
     * @param creatureActionLog La liste des actions de la créature pour le suivi.
     */
    @Override
    public void makeSound(ArrayList<String> creatureActionLog) {
        creatureActionLog.add("\u001B[90m"+getSpecies() + " *YOUUUUUUUUUUUUUUU*\u001B[0m");
    }
}
