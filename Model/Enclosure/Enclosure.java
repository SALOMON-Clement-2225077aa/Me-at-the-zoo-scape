package Model.Enclosure;

import Model.Creatures.*;
import Model.Creatures.Oviparous.Oviparous;
import Model.Creatures.Viviparous.Viviparous;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * La classe Enclosure représente un enclos de base capable d'accueillir différentes créatures.
 * Les enclos spécialisés (Aquarium et Aviary) étendent cette classe.
 */
public class Enclosure {

    /** Le nom de l'enclos. */
    public String name;
    /** La superficie de l'enclos. */
    public double area;
    /** La capacité maximale d'accueil de l'enclos. */
    public int maxCapacity;
    /** Le nombre actuel de créatures dans l'enclos. */
    public int currentCapacity;
    /** La liste des créatures présentes dans l'enclos. */
    public ArrayList<Creature> creatures;
    /** Le niveau de saleté de l'enclos. */
    public int enclosureDirtiness;
    /** Le temps restant avant la naissance d'une nouvelle créature. */
    public int timeUntilBirth = -1;

    /**
     * Constructeur de la classe Enclosure.
     * @param name Le nom de l'enclos.
     * @param area La superficie de l'enclos.
     * @param maxCapacity La capacité maximale d'accueil de l'enclos.
     * @param creatures La liste des créatures actuellement dans l'enclos.
     * @param enclosureDirtiness Le niveau de saleté de l'enclos.
     */
    public Enclosure(String name, double area, int maxCapacity, ArrayList<Creature> creatures, int enclosureDirtiness) {
        this.name = name;
        this.area = area;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = creatures.size();
        this.creatures = creatures;
        this.enclosureDirtiness = enclosureDirtiness;
    }

    /**
     * Renvoie le nom de l'enclos.
     * @return Le nom de l'enclos.
     */
    public String getName() {
        return name;
    }

    /**
     * Ajoute une créature à l'enclos.
     * @param creature La créature à ajouter.
     */
    public void addCreature(Creature creature) {
        creatures.add(creature);
        currentCapacity += 1;
    }

    /**
     * Supprime une créature de l'enclos.
     * @param creature La créature à supprimer.
     */
    public void removeCreature(Creature creature) {
        creatures.remove(creature);
        currentCapacity -= 1;
    }

    /**
     * Vérifie s'il y a une créature affamée dans l'enclos.
     * @return True s'il y a une créature affamée, sinon False.
     */
    public boolean isThereHungryCreature() {
        for (Creature creature : creatures) {
            if (creature.hungerLevel <= 20) {
                return true;
            }
        }
        return false;
    }

    /**
     * Nettoie l'enclos.
     * @return Un message indiquant le résultat du nettoyage.
     */
    public String cleanEnclosure() {
        if (currentCapacity == 0) {
            enclosureDirtiness = 0;
            return "The enclosure has been cleared!";
        } else {
            return "The enclosure has to be empty :(";
        }
    }

    /**
     * Renvoie la liste des créatures dans l'enclos.
     * @return La liste des créatures dans l'enclos.
     */
    public ArrayList<Creature> getCreatures() {
        return creatures;
    }

    /**
     * Fait agir chaque créature dans l'enclos.
     * @param creatureActionLog La liste des actions effectuées par les créatures.
     */
    public void everyoneDoSomething(ArrayList<String> creatureActionLog) {
        List<Creature> creaturesCopy = new ArrayList<>(creatures);
        for (Creature creature : creaturesCopy) {
            creature.doSomething(creatureActionLog);
        }
    }

    /**
     * Supprime les créatures mortes de l'enclos.
     */
    public void removeDead() {
        ArrayList<Creature> deadCreatures = new ArrayList<>();

        for (Creature creature : creatures) {
            if (creature.isDead) {
                deadCreatures.add(creature);
            }
        }

        for (Creature deadCreature : deadCreatures) {
            this.removeCreature(deadCreature);
        }
    }

    /**
     * Lance le processus de reproduction dans l'enclos.
     * @param creatureActionLog La liste des actions effectuées par les créatures.
     */
    public void reproduce(ArrayList<String> creatureActionLog) {
        boolean alreadyMale = false;
        boolean alreadyFemale = false;
        ArrayList<Creature> couple = new ArrayList<>();

        for (Creature creature : creatures) {
            if (creature.wantToReproduce) {
                if (Objects.equals(creature.gender, "female") && !alreadyFemale) {
                    alreadyFemale = true;
                    couple.add(creature);
                } else if (Objects.equals(creature.gender, "male") && !alreadyMale) {
                    alreadyMale = true;
                    couple.add(creature);
                }
            }
        }

        if (couple.size() == 2) {
            giveBirth(couple, creatureActionLog);
            couple.get(0).wantToReproduce = false;
            couple.get(1).wantToReproduce = false;
        }
    }

    /**
     * Lance le processus de naissance dans l'enclos.
     * @param creaturesThatWantToReproduce La liste des créatures qui veulent se reproduire.
     * @param creatureActionLog La liste des actions effectuées par les créatures.
     */
    private void giveBirth(ArrayList<Creature> creaturesThatWantToReproduce, ArrayList<String> creatureActionLog) {
        if (creaturesThatWantToReproduce.get(0) instanceof Viviparous) {
            timeUntilBirth = 15;
            creatureActionLog.add("\u001B[32m" + creaturesThatWantToReproduce.get(0).getSpecies() + "s reproduced! The baby-" + creaturesThatWantToReproduce.get(0).getSpecies() + " will be born in 15 turns.\u001B[0m");
        } else if (creaturesThatWantToReproduce.get(0) instanceof Oviparous) {
            timeUntilBirth = 10;
            creatureActionLog.add("\u001B[32m" + creaturesThatWantToReproduce.get(0).getSpecies() + "s reproduced! The egg will hatch in 10 turns.\u001B[0m");
        }
    }

    /**
     * Met à jour le processus de naissance dans l'enclos.
     * @param creatureActionLog La liste des actions effectuées par les créatures.
     */
    public void updateBirth(ArrayList<String> creatureActionLog) {
        if (timeUntilBirth == 0) {
            if (currentCapacity < maxCapacity && currentCapacity > 0) {
                creatureActionLog.add("\u001B[32mA " + creatures.get(0).getSpecies() + " is born!\u001B[0m");
                Random rd = new Random();
                creatures.get(0).createNewCreature(creatures.get(rd.nextInt(creatures.size())));
            }
        }
        timeUntilBirth -= 1;
    }

    /**
     * Simule le processus de défécation dans l'enclos.
     * @param creatureActionLog La liste des actions effectuées par les créatures.
     */
    public void poopInside(ArrayList<String> creatureActionLog) {
        enclosureDirtiness += 1;
        if (enclosureDirtiness == 75) {
            creatureActionLog.add("\u001B[35mThe " + this.getCreatures().get(0).getSpecies() + " enclosure is dirty!\u001B[0m");
        }
    }

    /**
     * Renvoie le type de l'enclos.
     * @return Le type de l'enclos, ici "Basic enclosure".
     */
    public String type() {
        return "Basic enclosure";
    }

    /**
     * Renvoie l'espèce de la première créature dans l'enclos, ou "None" s'il n'y a pas de créature.
     * @return L'espèce de la première créature dans l'enclos, ou "None".
     */
    public String creatureSpecies() {
        if (creatures.isEmpty()) {
            return "None";
        } else {
            return creatures.get(0).getSpecies();
        }
    }

    /**
     * Renvoie la capacité actuelle et maximale de l'enclos sous forme de chaîne de caractères.
     * @return La capacité actuelle et maximale de l'enclos.
     */
    public String capacity() {
        return currentCapacity + "/" + maxCapacity;
    }

    /**
     * Renvoie le niveau de saleté de l'enclos sous forme de chaîne de caractères.
     * @return Le niveau de saleté de l'enclos.
     */
    public String dirtiness() {
        return "" + enclosureDirtiness;
    }

    /**
     * Renvoie une représentation textuelle des caractéristiques de l'enclos et des créatures qu'il contient.
     * @return La représentation textuelle de l'enclos.
     */
    public String displayInfo() {
        return "Enclosure{" +
                "name='" + name + '\'' +
                ", area=" + area +
                ", maxCapacity=" + maxCapacity +
                ", currentCapacity=" + currentCapacity +
                ", creatures=" + creatures +
                ", isDirty=" + enclosureDirtiness +
                '}';
    }
}