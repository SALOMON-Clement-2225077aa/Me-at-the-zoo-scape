package Model.Creatures.Oviparous;

import Model.Creatures.Creature;

/**
 * La classe abstraite Oviparous représente une créature ovipare, c'est-à-dire une créature qui se reproduit par des œufs.
 * Elle étend la classe abstraite Creature et introduit des caractéristiques spécifiques aux créatures ovipares.
 */
public abstract class Oviparous extends Creature {

    private int incubationDuration;

    /**
     * Constructeur de la classe Oviparous.
     *
     * @param species            Le nom de l'espèce de la créature ovipare.
     * @param gender             Le genre de la créature ovipare.
     * @param weight             Le poids de la créature ovipare.
     * @param size               La taille de la créature ovipare.
     * @param age                L'âge de la créature ovipare.
     * @param incubationDuration La durée d'incubation des œufs de la créature ovipare.
     * @param hungerLevel        Le niveau de faim initial de la créature ovipare.
     */
    public Oviparous(String species, String gender, double weight, double size, int age, int incubationDuration, int hungerLevel) {
        super(species, gender, weight, size, age, hungerLevel);
        this.incubationDuration = incubationDuration;
    }
}


