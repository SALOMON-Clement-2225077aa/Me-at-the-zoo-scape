package Model.Creatures.Viviparous.Lycanthrope;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Hound {

    private Pair pairA;
    private ArrayList<Lycanthrope> lycanthropesHound = new ArrayList<Lycanthrope>();

    public Hound(Pair pairA, ArrayList<Lycanthrope> lycanthropesHound) {
        this.pairA.getMale().setRank(0);
        addLycanthrope(this.pairA.getMale());
        this.pairA.getFemale().setRank(0);
        addLycanthrope(this.pairA.getFemale());

        for (Lycanthrope lycanthrope : lycanthropesHound) {
            lycanthrope.joinHound(this);
        }
    }

    public Hound(Pair pairA) {
        this.pairA = pairA;

        this.pairA.getMale().setRank(0);
        addLycanthrope(this.pairA.getMale());
        this.pairA.getFemale().setRank(0);
        addLycanthrope(this.pairA.getFemale());
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
    }

    public Pair getPairA() {
        return pairA;
    }

    public void setPair(Lycanthrope maleA, ArrayList<String> creatureActionLog) {
        ArrayList<Lycanthrope> females = new ArrayList<>();
        for (Lycanthrope lycanthrope : lycanthropesHound) {
            if ("female".equals(lycanthrope.getGender())) {
                females.add(lycanthrope);
            }
        }
        if (females.isEmpty()) {
            return;
        }
        Lycanthrope highestLvlFemale = Collections.max(females, Comparator.comparingInt(Lycanthrope::getLvl));

        if (getPairA() == null) {
            pairA = new Pair(maleA, highestLvlFemale);
            creatureActionLog.add("An Alpha pair is born");
        }
        pairA.getFemale().setLvl(pairA.getMale().getRank());

        pairA.getMale().setRank(maleA.getRank());
        maleA.setRank(0);
        pairA.getMale().setDomFactor(pairA.getMale().getDomFactor() - 1);
        pairA.getMale().loseRankByDomFactor();

        pairA = new Pair(maleA, highestLvlFemale);
        pairA.getFemale().setRank(0);
        creatureActionLog.add("A new Alpha pair dominate the hound");
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

    public void strongestToWeakest() {
        lycanthropesHound.sort(Comparator.comparingInt(Lycanthrope::getRank));
    }

    public void lycanthropesDisplay(String[] creatureInfo) {
        strongestToWeakest();
        int minSize = Math.min(lycanthropesHound.size(), lycanthropesHound.get(0).getEnclosure().creatures.size());
        for (int i = 0; i < minSize; i++) {
            creatureInfo[i] = lycanthropesHound.get(i).toStringLycanthrope();
        }
        for (int i = lycanthropesHound.get(0).getEnclosure().creatures.size(); i < lycanthropesHound.get(0).getEnclosure().maxCapacity; i++) {
            creatureInfo[i] = "";
        }
    }

    @Override
    public String toString() {
        return "Hound{" +
                "pairA=" + pairA +
                ", lycanthopesHound=" + lycanthropesHound +
                '}';
    }
}
