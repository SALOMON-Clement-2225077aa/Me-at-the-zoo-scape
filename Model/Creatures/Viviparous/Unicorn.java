package Model.Creatures.Viviparous;

import Model.Creatures.Type.Runner;

import java.util.ArrayList;

/**
 * La classe Unicorn représente une licorne, une créature vivipare ayant la capacité de courir rapidement.
 * Elle hérite de la classe abstraite Viviparous et implémente l'interface Runner.
 */
public class Unicorn extends Viviparous implements Runner {

    /**
     * Constructeur de la classe Unicorn.
     *
     * @param species      Le nom de l'espèce de la licorne.
     * @param gender       Le genre de la licorne.
     * @param weight       Le poids de la licorne.
     * @param size         La taille de la licorne.
     * @param age          L'âge de la licorne.
     * @param hungerLevel  Le niveau de faim initial de la licorne.
     */
    public Unicorn(String species, String gender, double weight, double size, int age, int hungerLevel) {
        super(species, gender, weight, size, age, 40,hungerLevel);
    }

    /**
     * Implémentation de la méthode makeSound spécifique à la licorne.
     *
     * @param creatureActionLog La liste des actions de la créature pour le suivi.
     */
    @Override
    public void makeSound(ArrayList<String> creatureActionLog) {
        creatureActionLog.add("\u001B[90m"+getSpecies() + " *HIAN HIAN*\u001B[0m");
    }
}
