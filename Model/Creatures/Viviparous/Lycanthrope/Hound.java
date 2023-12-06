package Model.Creatures.Viviparous.Lycanthrope;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hound {

    private Pair pairA;
    private ArrayList<Lycanthrope> lycanthropesHound;

    public Hound(Pair pairA, ArrayList<Lycanthrope> lycanthropesHound) {
        this.pairA.getMale().setRank(0);
        this.pairA.getMale().joinHound(this);
        this.pairA.getFemale().setRank(0);
        this.pairA.getFemale().joinHound(this);

        for (Lycanthrope lycanthrope : lycanthropesHound) {
            lycanthrope.joinHound(this);
        }
    }

    public Hound(Pair pairA) {
        this.pairA = pairA;

        this.pairA.getMale().setRank(0);
        this.pairA.getMale().joinHound(this);
        this.pairA.getFemale().setRank(0);
        this.pairA.getFemale().joinHound(this);
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

    public int getLowestRank(){
        int lowestRank = 1;
        for (Lycanthrope lycanthrope : lycanthropesHound) {
            if (lycanthrope.getRank() < lowestRank) {
                lowestRank = lycanthrope.getRank();
            }
        }
        return lowestRank;
    }

    public void initOmega() {
        if (getLowestRank() != 23) {
            for (Lycanthrope lycanthrope : lycanthropesHound) {
                if (lycanthrope.getRank() == getLowestRank()) {
                    lycanthrope.setRank(23);
                }
            }
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
