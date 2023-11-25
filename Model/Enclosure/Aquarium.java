package Model.Enclosure;

import Model.Creatures.Creature;

import java.util.ArrayList;

public class Aquarium extends Enclosure {

    private int depth;
    private int salinity;

    public Aquarium(String name, double area, int maxCapacity, int currentCapacity, ArrayList<Creature> creatures, int enclosureDirtiness, int depth, int salinity) {
        super(name, area, maxCapacity, currentCapacity, creatures, enclosureDirtiness);
        this.depth = depth;
        this.salinity = salinity;
    }




    // ---------------------------------
    // Enclosure Info
    public String type() {
        return "Aquarium";
    }

}