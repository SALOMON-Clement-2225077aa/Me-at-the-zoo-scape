package Model.Creatures.Viviparous.Lycanthrope;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hound {

    private Pair pairA;
    private ArrayList<Lycanthrope> lycanthropesHound;

    public Hound(Pair pairA, ArrayList<Lycanthrope> lycanthropesHound) {
        this.pairA = pairA;
        this.lycanthropesHound = lycanthropesHound;
    }

    public ArrayList<Lycanthrope> getLycanthropesHound() {
        return lycanthropesHound;
    }

    public void setLycanthropesHound(ArrayList<Lycanthrope> lycanthropesHound) {
        this.lycanthropesHound = lycanthropesHound;
    }

    public Pair getPairA() {
        return pairA;
    }

    public String setPair(Lycanthrope maleA) {
        ArrayList<Lycanthrope> females = new ArrayList<>();
        for (Lycanthrope lycanthrope : lycanthropesHound) {
            if ("female".equals(lycanthrope.getGender())) {
                females.add(lycanthrope);
            }
        }
        if (females.isEmpty()) {
            return null;
        }
        Lycanthrope highestLvlFemale = Collections.max(females, Comparator.comparingInt(Lycanthrope::getLvl));

        if (getPairA() == null) {
            pairA = new Pair(maleA, highestLvlFemale);
            return "Un couple Alpha est né";
        }
        pairA.getFemale().setLvl(pairA.getMale().getRank());
        // isDominate(pairA.getMale());
        pairA = new Pair(maleA, highestLvlFemale);
        return "Un nouveau couple Alpha domine la meute.";
    }

    @Override
    public String toString() {
        return "Hound{" +
                "pairA=" + pairA +
                ", lycanthopesHound=" + lycanthropesHound +
                '}';
    }

    public String toStringLycanthropes() {
        return "les loups";
    }
}
