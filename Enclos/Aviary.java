package Enclos;

import Creatures.Creature;

import java.util.ArrayList;

public class Aviary extends Enclos{
    int height;

    public Aviary(String name, double area, int maxCapacity, int currentCapacity, ArrayList<Creature> creatures, boolean isDirty, int height) {
        super(name, area, maxCapacity, currentCapacity, creatures, isDirty);
        this.height = height;
    }

}
