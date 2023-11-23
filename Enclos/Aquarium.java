package Enclos;

import Creatures.Creature;

import java.util.ArrayList;

public class Aquarium extends Enclos {

    int depth;
    int String;

    public Aquarium(java.lang.String name, double area, int maxCapacity, int currentCapacity, ArrayList<Creature> creatures, boolean isDirty, int depth, int string) {
        super(name, area, maxCapacity, currentCapacity, creatures, isDirty);
        this.depth = depth;
        String = string;
    }

}