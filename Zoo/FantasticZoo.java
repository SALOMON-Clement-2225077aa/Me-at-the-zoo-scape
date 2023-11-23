package Zoo;

import Enclosure.Enclos;

import java.util.ArrayList;

public class FantasticZoo {

    private String name;
    private FantasticZooMaster player;
    private int MaxEnclosure;
    private ArrayList<Enclos> ListeEnclosure;

    public FantasticZoo(String name, FantasticZooMaster player, int maxEnclosure, ArrayList<Enclos> listeEnclosure) {
        this.name = name;
        this.player = player;
        MaxEnclosure = maxEnclosure;
        ListeEnclosure = listeEnclosure;
    }
}
