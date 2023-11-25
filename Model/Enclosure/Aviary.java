package Model.Enclosure;

import Model.Creatures.Creature;

import java.util.ArrayList;

public class Aviary extends Enclosure {
    int height;

    public Aviary(String name, double area, int maxCapacity, ArrayList<Creature> creatures, int enclosureDirtiness, int height) {
        super(name, area, maxCapacity, creatures, enclosureDirtiness);
        this.height = height;
    }




    // ---------------------------------
    // Enclosure Info
    public String type() {
        return "Aviary";
    }

}
