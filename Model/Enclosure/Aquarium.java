package Model.Enclosure;

import Model.Creatures.Creature;

import java.util.ArrayList;

/**
 * La classe Aquarium représente un type d'enclos spécifique, adapté pour les créatures aquatiques.
 * Elle étend la classe abstraite Enclosure.
 */
public class Aquarium extends Enclosure {

    /** La profondeur de l'aquarium. */
    private int depth;

    /** La salinité de l'aquarium. */
    private int salinity;

    /**
     * Constructeur de la classe Aquarium.
     * @param name Le nom de l'aquarium.
     * @param area La superficie de l'aquarium.
     * @param maxCapacity La capacité maximale d'accueil d'aquarium.
     * @param creatures La liste des créatures actuellement dans l'aquarium.
     * @param enclosureDirtiness Le niveau de saleté de l'aquarium.
     * @param depth La profondeur de l'aquarium.
     * @param salinity La salinité de l'aquarium.
     */
    public Aquarium(String name, double area, int maxCapacity, ArrayList<Creature> creatures, int enclosureDirtiness, int depth, int salinity) {
        super(name, area, maxCapacity, creatures, enclosureDirtiness);
        this.depth = depth;
        this.salinity = salinity;
    }

    /**
     * Renvoie le type de l'enclos.
     * @return Le type de l'enclos, ici "Aquarium".
     */
    public String type() {
        return "Aquarium";
    }
}
