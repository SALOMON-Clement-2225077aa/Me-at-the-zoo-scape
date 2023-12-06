package Model.Enclosure;

import Model.Creatures.*;
import Model.Creatures.Oviparous.Oviparous;
import Model.Creatures.Viviparous.Lycanthrope.Hound;
import Model.Creatures.Viviparous.Lycanthrope.Lycanthrope;
import Model.Creatures.Viviparous.Viviparous;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Enclosure {
    // Pas besoin d'abstract c'est l'enclos de base
    // les 2 autres sont des extends de celui là

    // Variables
    public String name;
    public double area;
    public int maxCapacity;
    public int currentCapacity;
    public ArrayList<Creature> creatures;
    public int enclosureDirtiness;
    public int timeUntilBirth = -1;

    // Constructeur
    public Enclosure(String name, double area, int maxCapacity, ArrayList<Creature> creatures, int enclosureDirtiness) {
        this.name = name;
        this.area = area;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = creatures.size();
        this.creatures = creatures;
        this.enclosureDirtiness = enclosureDirtiness;
    }

    public String getName() { return name; }

    // Méthodes
    public void addCreature(Creature creature) {
        creatures.add(creature);
        currentCapacity += 1;
    }
    public void removeCreature(Creature creature) {
        creatures.remove(creature);
        currentCapacity -= 1;
    }
    public boolean isThereHungryCreature() {
        for (Creature creature : creatures) {
            if (creature.hungerLevel <= 20) {
                return true;
            }
        }
        return false;
    }

    public String cleanEnclosure() {
        if(currentCapacity == 0) {
            enclosureDirtiness = 0;
            return "The enclosure has been cleared !";
        }
        else {
            return "The enclosure has to be empty :(";
        }
    }
    public ArrayList<Creature> getCreatures() {
        return creatures;
    }

    public void everyoneDoSomething(ArrayList<String> creatureActionLog) {
        for (Creature creature : creatures) {
            creature.doSomething(creatureActionLog);
        }
    }
    public void removeDead() {
        ArrayList<Creature> deadCreatures = new ArrayList<>();

        for (Creature creature : creatures) {
            if(creature.isDead) {
                deadCreatures.add(creature);
            }
        }
        for (Creature Dcreature : deadCreatures) {
            this.removeCreature(Dcreature);
        }
    }

    public void reproduce(ArrayList<String> creatureActionLog) {
        boolean alreadyMale = false;
        boolean alreadyFemale = false;
        ArrayList<Creature> couple = new ArrayList<>();
        for (Creature creature : creatures) {
            if (creature.wantToReproduce) {
                if(Objects.equals(creature.gender, "female") && !alreadyFemale) {
                    alreadyFemale = true;
                    couple.add(creature);
                } else if (Objects.equals(creature.gender, "male") && !alreadyMale){
                    alreadyMale = true;
                    couple.add(creature);
                }
            }
        }
        if(couple.size() == 2) {
            giveBirth(couple,creatureActionLog);
            couple.get(0).wantToReproduce = false;
            couple.get(1).wantToReproduce = false;
        }
    }

    private void giveBirth(ArrayList<Creature> creaturesThatWantToReproduce, ArrayList<String> creatureActionLog) {
        if (creaturesThatWantToReproduce.get(0) instanceof Viviparous) {
            timeUntilBirth = 15;
            creatureActionLog.add("\u001B[32m" + creaturesThatWantToReproduce.get(0).getSpecies() + "s reproduced ! The baby-" + creaturesThatWantToReproduce.get(0).getSpecies() + " will be born in 15 turns.\u001B[0m");
        } else if (creaturesThatWantToReproduce.get(0) instanceof Oviparous) {
            timeUntilBirth = 10;
            creatureActionLog.add("\u001B[32m" + creaturesThatWantToReproduce.get(0).getSpecies() + "s reproduced ! The egg will hatch in 10 turns.\u001B[0m");
        }
    }

        public void updateBirth(ArrayList<String> creatureActionLog) {
        if(timeUntilBirth == 0) {
            if(currentCapacity<maxCapacity && currentCapacity>0) {
                creatureActionLog.add("\u001B[32mA "+creatures.get(0).getSpecies() + " is born !\u001B[0m");
                Random rd = new Random();
                creatures.get(0).createNewCreature(creatures.get(rd.nextInt(creatures.size())));
            }
        }
        timeUntilBirth -= 1;
    }

    public void poopInside(ArrayList<String> creatureActionLog) {
        enclosureDirtiness += 1;
        if(enclosureDirtiness==75){
            creatureActionLog.add("\u001B[35mThe "+this.getCreatures().get(0).getSpecies()+" enclosure is dirty !\u001B[0m");
        }
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
    public String dirtiness() {
        return ""+enclosureDirtiness;
    }

    public String displayInfo() {
        // Afficher les caractéristiques de l'enclos et des créatures qu'il contient
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