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

    public ArrayList<String> everyoneDoSomethingInZoo(ArrayList<String> creatureActionLog) {
        creatureTurn(creatureActionLog);
        creatureReproduction(creatureActionLog);
        everyoneRemoveDead();
        return creatureActionLog;
    }

    private void creatureTurn(ArrayList<String> creatureActionLog) {
        for (Enclosure enclosure : ListEnclosure) {
            enclosure.everyoneDoSomething(creatureActionLog);
        }
    }

    private void everyoneRemoveDead() {
        for (Enclosure enclosure : ListEnclosure) {
            enclosure.removeDead();
        }
    }

    private void creatureReproduction(ArrayList<String> creatureActionLog) {
        for (Enclosure enclosure : ListEnclosure) {
            enclosure.reproduce(creatureActionLog);
            enclosure.updateBirth(creatureActionLog);
        }
    }

}
