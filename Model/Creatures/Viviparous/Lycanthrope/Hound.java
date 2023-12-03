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

    public void addLycanthrope(Lycanthrope lycanthrope) {
        lycanthropesHound.add(lycanthrope);
        lycanthrope.joinHound(this);
    }

    public void removeLycanthrope(Lycanthrope lycanthrope) {
        lycanthropesHound.remove(lycanthrope);
        lycanthrope.splitUp();
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

        pairA.getMale().setRank(maleA.getRank());
        maleA.setRank(0);
        pairA.getMale().setDomFactor(pairA.getMale().getDomFactor() - 1);
        pairA.getMale().loseRankByDomFactor();

        pairA = new Pair(maleA, highestLvlFemale);
        pairA.getFemale().setRank(0);
        return "Un nouveau couple Alpha domine la meute.";
    }

    public void decreaseRanks() {
        for (Lycanthrope lycanthrope : lycanthropesHound) {
            lycanthrope.setRank(lycanthrope.getRank() - 1);
        }
    }

    public void initOmega(ArrayList<Lycanthrope> omegaLycanthropes) {
        for (Lycanthrope lycanthrope : omegaLycanthropes) {
            lycanthrope.setRank(23);
        }
    }

    public void generalReproduction() {
        // jsp quoi faire
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
