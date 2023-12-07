package Model.Creatures.Viviparous;

import Model.Creatures.Creature;

/**
 * La classe abstraite Viviparous représente une créature vivipare, c'est-à-dire une créature qui se reproduit par des naissances vivantes.
 * Elle étend la classe abstraite Creature et introduit des caractéristiques spécifiques aux créatures vivipares.
 */
public abstract class Viviparous extends Creature {

    private int gestationDuration;

    /**
     * Constructeur de la classe Viviparous.
     *
     * @param species           Le nom de l'espèce de la créature vivipare.
     * @param gender            Le genre de la créature vivipare.
     * @param weight            Le poids de la créature vivipare.
     * @param size              La taille de la créature vivipare.
     * @param age               L'âge de la créature vivipare.
     * @param gestationDuration La durée de gestation de la créature vivipare.
     * @param hungerLevel       Le niveau de faim initial de la créature vivipare.
     */
    public Viviparous(String species, String gender, double weight, double size, int age, int gestationDuration, int hungerLevel) {
        super(species, gender, weight, size, age, hungerLevel);
        this.gestationDuration = gestationDuration;
    }
}