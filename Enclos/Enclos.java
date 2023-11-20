package Enclos;

import Creatures.*;
import java.util.ArrayList;

public class Enclos {
    // Pas besoin d'abstract ça sera l'enclos de base
    // On fera des extends de celui là pour les 2 autres


    // Variables
    String name;
    double area;
    int maxCapacity;
    int currentCapacity;
    ArrayList<Creatures> creatures;
    boolean isDirty;



    // Méthodes
    void displayInfo() {
        // Afficher les caractéristiques de l'enclos et des créatures qu'il contient
    }

    void addCreature(Creatures creature) {
        // Ajouter une créature à l'enclos
    }

    void removeCreature(Creatures creature) {
        // Enlever une créature de l'enclos
    }

    void feedCreatures() {
        // Nourrir les créatures de l'enclos
    }

    void cleanEnclosure() {
        // Nettoyer l'enclos
    }

}