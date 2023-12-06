package Model.Zoo;

import Model.Creatures.Creature;
import Model.Creatures.Viviparous.Lycanthrope.Hound;
import Model.Creatures.Viviparous.Lycanthrope.Lycanthrope;
import Model.Creatures.Viviparous.Lycanthrope.Pair;
import Model.Enclosure.Enclosure;

import java.util.ArrayList;
import java.util.Objects;

public class FantasticZoo {

    private String name;
    private FantasticZooMaster player;
    private int MaxEnclosure;
    private ArrayList<Enclosure> ListEnclosure;

    private int nbDay;

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
        newHound();
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
            if (enclosure.getCreatures().get(0) instanceof Lycanthrope) {
                // faut que je rajoute ca
            }
            else {
                enclosure.reproduce(creatureActionLog);
                enclosure.updateBirth(creatureActionLog);
            }
        }
    }

    private void newHound() { // créer une nouvelle meute si il y a deux lycanthropes solitaires
        for (Enclosure enclosure : ListEnclosure) {
            boolean isMaleA = false;
            boolean isFemaleA = false;
            boolean isHound = false;
            Lycanthrope maleA = null;
            Lycanthrope femaleA = null;
            Hound hound = null;
            for (int i = 0; i < enclosure.currentCapacity; ++i)  {
                Lycanthrope lycanthrope = (Lycanthrope) enclosure.getCreatures().get(i);
                if (lycanthrope.getHound() != null) {
                    break;
                }
                else if (Objects.equals(lycanthrope.getGender(), "male")
                         && !isMaleA) {
                    maleA = lycanthrope;
                    isMaleA = true;
                }
                else if (Objects.equals(lycanthrope.getGender(), "female")
                        && !isFemaleA) {
                    femaleA = lycanthrope;
                    isFemaleA = true;
                }
                else if (isMaleA && isFemaleA) {
                    hound = new Hound(new Pair(maleA, femaleA));
                    isHound = true;
                }
                else if (isHound) {
                    lycanthrope.joinHound(hound);
                }
            }
        }
    }
}
