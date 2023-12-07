package Model.Creatures.Viviparous.Lycanthrope;

import Model.Creatures.Oviparous.Oviparous;
import Model.Creatures.Viviparous.Viviparous;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Pair {

    private Lycanthrope male;
    private Lycanthrope female;
    public int timeUntilBirth = -1;

    public Pair(Lycanthrope male, Lycanthrope female) {
        this.male = male;
        this.female = female;
    }

    public Lycanthrope getMale() {
        return male;
    }

    public Lycanthrope getFemale() {
        return female;
    }

    public void setMale(Lycanthrope male) {
        this.male = male;
    }

    public void setFemale(Lycanthrope female) {
        this.female = female;
    }

    public void giveBirth(ArrayList<String> creatureActionLog) {
        timeUntilBirth = 15;
        creatureActionLog.add("\u001B[32m" + "Lycanthropes reproduced ! A litter of baby-lycanthropes will be born in 15 turns.\u001B[0m");
    }

    public void updateBirth(ArrayList<String> creatureActionLog) {
        if(timeUntilBirth == 0) {
            Random rd = new Random();
            int nbRd = rd.nextInt(7);
            if(male.getEnclosure().currentCapacity + nbRd <male.getEnclosure().maxCapacity
                    && male.getEnclosure().currentCapacity>0) {
                creatureActionLog.add("\u001B[32mA "+"A lycanthopes litter is born !\u001B[0m");
                for (int i = 0; i < nbRd; ++i) {
                    int rdm = rd.nextInt(2);
                    Lycanthrope l = (rdm == 0) ? male : female;
                    Lycanthrope babyLycanthrope = new Lycanthrope("Lycanthrope", l.getGender(), l.weight / 2, l.size / 2, 1, 0, 100, l.getStrength() - 5, 10, (l.getHound().getLycanthropesHound().size() == 0) ? 1 : 2, l.getImpetuosity(), l.getHumanForm().getName() + "Jr.");
                    l.enclosure.addCreature(babyLycanthrope);
                    babyLycanthrope.setEnclosure(l.enclosure);
                }
            }
        }
        timeUntilBirth -= 1;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "male=" + male +
                ", female=" + female +
                '}';
    }
}
