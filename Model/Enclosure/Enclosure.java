package Model.Enclosure;

import Model.Creatures.*;
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
    public String displayInfo() {
        // Afficher les caractéristiques de l'enclos et des créatures qu'il contient
        return "Model.Enclosure{" +
                "name='" + name + '\'' +
                ", area=" + area +
                ", maxCapacity=" + maxCapacity +
                ", currentCapacity=" + currentCapacity +
                ", creatures=" + creatures +
                ", isDirty=" + isDirty +
                '}';
    }

    public String displayCreatures() {
        // Afficher les caractéristiques de l'enclos et des créatures qu'il contient
        return ""+creatures;
    }

    public void addCreature(Creature creature) {
        creatures.add(creature);
    }

    public void removeCreature(Creature creature) {
        creatures.remove(creature);
    }

    public void feedCreatures() {
        // Nourrir les créatures de l'enclos
    }

    public void cleanEnclosure() {
        // Nettoyer l'enclos
    }

}