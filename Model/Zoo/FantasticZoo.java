package Model.Zoo;

import Model.Enclosure.Enclosure;

import java.util.ArrayList;

public class FantasticZoo {

    private String name;
    private FantasticZooMaster player;
    private int MaxEnclosure;
    private ArrayList<Enclosure> ListEnclosure;

    public FantasticZoo(String name, FantasticZooMaster player, int maxEnclosure, ArrayList<Enclosure> listeEnclosure) {
        this.name = name;
        this.player = player;
        MaxEnclosure = maxEnclosure;
        ListEnclosure = listeEnclosure;
    }

    public void everyoneDoSomethingInZoo() {
        for (Enclosure enclosure : ListEnclosure) {
            enclosure.everyoneDoSomething();
        }
    }

    public ArrayList<Enclosure> getListEnclosure() {
        return ListEnclosure;
    }
}
