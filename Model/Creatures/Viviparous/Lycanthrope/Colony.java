package Model.Creatures.Viviparous.Lycanthrope;

import Model.Creatures.Creature;
import Model.Enclosure.Enclosure;

import java.util.ArrayList;
import java.util.Objects;

public class Colony {

    ArrayList<Hound> colonyHounds ;

    public Colony(ArrayList<Hound> colonyHounds) {
        this.colonyHounds = colonyHounds;
    }

    public void addHound(Hound hound) {
        colonyHounds.add(hound);
    }
}
