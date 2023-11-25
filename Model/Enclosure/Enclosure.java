package Model.Enclosure;

import Model.Creatures.*;
import java.util.ArrayList;

public class Enclosure {
    // Pas besoin d'abstract ça sera l'enclos de base
    // On fera des extends de celui là pour les 2 autres

    // Variables
    public String name;
    public double area;
    public int maxCapacity;
    public int currentCapacity;
    public ArrayList<Creature> creatures;
    public int enclosureDirtiness;

    public Enclosure(String name, double area, int maxCapacity, int currentCapacity, ArrayList<Creature> creatures, int enclosureDirtiness) {
        this.name = name;
        this.area = area;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
        this.creatures = creatures;
        this.enclosureDirtiness = enclosureDirtiness;
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
                ", isDirty=" + enclosureDirtiness +
                '}';
    }

    public String displayCreatures() {
        // Afficher les créatures qu'il contient
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
        enclosureDirtiness = 0;
    }



    // ---------------------------------
    // Enclosure Info
    public String type() {
        return "Basic enclosure";
    }
    public String creatureSpecies() {
        if(creatures.isEmpty()) {
            return "None";
        }
        else {
            return creatures.get(0).getSpecies();
        }
    }
    public String capacity() {
        return currentCapacity+"/"+maxCapacity;
    }
    public String dirtyness() {
        return ""+enclosureDirtiness;
    }
}