package Model.Creatures.Viviparous.Lycanthrope;

import java.util.ArrayList;

public class Hound {

    private Pair pairA;
    private ArrayList<Lycanthrope> lycanthopesHound;

    public Hound(Pair pairA, ArrayList<Lycanthrope> lycanthopesHound) {
        this.pairA = pairA;
        this.lycanthopesHound = lycanthopesHound;
    }

    public Pair getPairA() {
        return pairA;
    }

    public String setPair(Lycanthrope maleA, Lycanthrope femaleA) {
        if (getPairA() == null) {
            pairA = new Pair(maleA, femaleA);
            return "Un couple Alpha est né";
        }
        pairA.getFemale().setLvl(pairA.getMale().getRank());
        // isDominate(pairA.getMale());
        // pairA = new Pair(maleA, getHighestLvlFemale());
        return "Un nouveau couple Alpha domine la meute.";
    }

    @Override
    public String toString() {
        return "Hound{" +
                "pairA=" + pairA +
                ", lycanthopesHound=" + lycanthopesHound +
                '}';
    }

    public String toStringLycanthropes() {
        return "les loups";
    }
}
