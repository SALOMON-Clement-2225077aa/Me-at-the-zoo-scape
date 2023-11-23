package Enclosure;

import Creatures.*;
import java.util.ArrayList;

public class Enclosure {
    // Pas besoin d'abstract ça sera l'enclos de base
    // On fera des extends de celui là pour les 2 autres

    // Variables
    String name;
    double area;
    int maxCapacity;
    int currentCapacity;
    ArrayList<Creature> creatures;
    boolean isDirty;

    public Enclosure(String name, double area, int maxCapacity, int currentCapacity, ArrayList<Creature> creatures, boolean isDirty) {
        this.name = name;
        this.area = area;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
        this.creatures = creatures;
        this.isDirty = isDirty;
    }

    // Méthodes
    void displayInfo() {
        // Afficher les caractéristiques de l'enclos et des créatures qu'il contient
    }

    void addCreature(Creature creature) {
        // Ajouter une créature à l'enclos
    }

    void removeCreature(Creature creature) {
        // Enlever une créature de l'enclos
    }

    void feedCreatures() {
        // Nourrir les créatures de l'enclos
    }

    void cleanEnclosure() {
        // Nettoyer l'enclos
    }

}