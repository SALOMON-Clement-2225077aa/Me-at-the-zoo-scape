package Model.Enclosure;

import Model.Creatures.Creature;

import java.util.ArrayList;

/**
 * La classe Aviary représente un type d'enclos spécifique, adapté pour les créatures volantes.
 * Elle étend la classe abstraite Enclosure.
 */
public class Aviary extends Enclosure {

    /** La hauteur de la volière. */
    private int height;

    /**
     * Constructeur de la classe Aviary.
     * @param name Le nom de la volière.
     * @param area La superficie de la volière.
     * @param maxCapacity La capacité maximale d'accueil de la volière.
     * @param creatures La liste des créatures actuellement dans la volière.
     * @param enclosureDirtiness Le niveau de saleté de la volière.
     * @param height La hauteur de la volière.
     */
    public Aviary(String name, double area, int maxCapacity, ArrayList<Creature> creatures, int enclosureDirtiness, int height) {
        super(name, area, maxCapacity, creatures, enclosureDirtiness);
        this.height = height;
    }

    /**
     * Renvoie le type de l'enclos.
     * @return Le type de l'enclos, ici "Aviary".
     */
    public String type() {
        return "Aviary";
    }
}
