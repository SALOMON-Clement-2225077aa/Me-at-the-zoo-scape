package Model.Creatures.Viviparous.Lycanthrope;

import Model.Creatures.Type.Runner;
import Model.Creatures.Viviparous.Viviparous;
import Model.Zoo.FantasticZooMaster;

import java.util.ArrayList;
import java.util.Random;

public class Lycanthrope extends Viviparous implements Runner {

    private int strength;
    private int domFactor;
    private int rank;
    private int lvl;
    private String impetuosity;
    private Hound hound;
    private boolean isHuman = false;
    private final FantasticZooMaster humanForm;

    public Lycanthrope(String species, String gender, double weight, double size, int age, int gestationDuration, int hungerLevel, int strength, int domFactor, int rank, String impetuosity, String name) {
        super(species, gender, weight, size, age, gestationDuration, hungerLevel);
        this.strength = strength;
        this.domFactor = domFactor;
        this.rank = rank;
        lvlCalculation();
        this.impetuosity = impetuosity;
        this.hound = null;
        humanForm = new FantasticZooMaster(name, gender, age);
    }

    public FantasticZooMaster getHumanForm() {
        return humanForm;
    }

    public int getStrength() {
        return strength;
    }

    public int getDomFactor() {
        return domFactor;
    }

    public void setDomFactor(int domFactor) {
        this.domFactor = domFactor;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public String getImpetuosity() {
        return impetuosity;
    }

    public Hound getHound() {
        return hound;
    }

    public void joinHound(Hound toJoinHound) {
        hound = toJoinHound;
    }

    public void lvlCalculation() {
        lvl = strength;

        if (age < 30) {
            lvl += 5;
        }
        else if (age < 60) {
            lvl += 10;
        }
        else {
            lvl += 3;
        }

        lvl += domFactor/2;

        lvl += 22 - rank;
    }

    public void loseRankByDomFactor() { // si le facteur de domination est trop bas le loup garou perd un rang
        ArrayList<Lycanthrope> lycanthropesByRank = new ArrayList<Lycanthrope>();
        for (Lycanthrope lycanthrope : hound.getLycanthropesHound()) {
            if (lycanthrope.getRank() == rank) {
                lycanthropesByRank.add(lycanthrope);
            }
        }
        if (domFactor < 10 && lycanthropesByRank.size() > 1) {
            rank -= 1;
        }
    }

    public void domination(ArrayList<String> creatureActionLog) {
        if (hound != null
            && !isSleeping
            && !isHuman) {
            Random random = new Random();
            ArrayList<Lycanthrope> subjugable = new ArrayList<Lycanthrope>(); //arraylist des lycanthropes pouvant être dominés

            int lowestAge = 100;
            int biggestAge = 100;
            int strengthLimit = 100;

            switch (impetuosity) {
                case "calm":
                    lowestAge = 30;
                    biggestAge = 60;
                    strengthLimit = 10;
                    break;

                case "moderate":
                    lowestAge = 30;
                    strengthLimit = 5;
                    break;

                case "aggressive":
                    lowestAge = 0;
                    biggestAge = 0;
                    strengthLimit = 0;
                    break;

                default:
                    makeSound(creatureActionLog);
            }
            for (Lycanthrope lycanthrope : hound.getLycanthropesHound()) {
                if (lycanthrope != hound.getPairA().getFemale()
                        && lycanthrope.canHear()
                        && !lycanthrope.isSleeping
                        && age >= lowestAge && age <= biggestAge
                        && lycanthrope.getStrength() <= strength - strengthLimit) {
                    subjugable.add(lycanthrope);
                }
            }
            if (!subjugable.isEmpty()) {
                superiorityHowl(creatureActionLog);
                int rdNb = random.nextInt(subjugable.size()); //Nb entre 0 et le nombres de lycanthropes dans la liste
                int tie = random.nextInt(2); //déterminer le gagnant en cas de niveau égal
                Lycanthrope targetedLycanthrope = subjugable.get(rdNb);
                if (lvl > targetedLycanthrope.getLvl()
                        || targetedLycanthrope.getRank() == 23
                        || (lvl == targetedLycanthrope.getLvl() && tie == 1)) {
                    domFactor += 1;
                    if (targetedLycanthrope.getRank() > rank) {
                        int newRank = targetedLycanthrope.getRank();
                        targetedLycanthrope.setRank(rank);
                        setRank(newRank);
                    }
                    targetedLycanthrope.submissionHowl(creatureActionLog);
                } else {
                    targetedLycanthrope.aggressivenessHowl(creatureActionLog);
                }
                targetedLycanthrope.setDomFactor(targetedLycanthrope.getDomFactor() - 1);

                loseRankByDomFactor();
                targetedLycanthrope.loseRankByDomFactor();
                }
            }
    }

    public void affiliationsHowl(ArrayList<String> creatureActionLog) {
        if (hound != null) {
            creatureActionLog.add("\u001B[90mLycanthrope de la meute de l'enclos " + getEnclosure().getName() + ": *WAF WAF WAOUUUF*\u001B[0m");
            for (Lycanthrope lycanthrope : hound.getLycanthropesHound()) {
                if (lycanthrope.canHear() && lycanthrope != this) {
                    creatureActionLog.add("\u001B[38;5;239mLycanthrope de la meute de l'enclos " + getEnclosure().getName() + ": *WAF WAF WAOUUUF*\u001B[0m");
                }
            }
        }
        else {
            makeSound(creatureActionLog);
        }
    }

    public void superiorityHowl(ArrayList<String> creatureActionLog) {
        creatureActionLog.add("\u001B[90m"+species + "*AOU AOU AOUUUUUUUUU*\u001B[0m");
    }

    public void submissionHowl(ArrayList<String> creatureActionLog) {
        creatureActionLog.add("\u001B[90m"+species + "*ouu ouu ouu* :'(\u001B[0m");
    }

    public void aggressivenessHowl(ArrayList<String> creatureActionLog) {
        creatureActionLog.add("\u001B[90m"+species + "*GRRRRRRRRRRRRR*\u001B[0m");
    }

    public boolean canHear() {
        return !isSleeping && !isIll;
    }

    public void splitUp () {
        hound.removeLycanthrope(this);
        hound = null;
        rank = -1;
    }

    public void shift(ArrayList<String> creatureActionLog) {
        if (!isHuman) {
            isHuman = true;
            Random rd = new Random();
            int rdNb = rd.nextInt(3);
            creatureActionLog.add(humanForm.getName() + " snap out of it, he/she's not a lycanthrope anymore");
            if (rdNb == 1) {
                getEnclosure().removeCreature(this);
                creatureActionLog.add(humanForm.getName() + " managed to escape from his enclosure.");
                if(hound != null) {
                    hound.removeLycanthrope(this);
                }
            }
        }
        else {
            isHuman = false;
            creatureActionLog.add(humanForm.getName() + " : I became the monster I always was");
        }
    }

    private String greekSwitch (int position){
        String[] greekLetters = {
                "α", "β", "γ", "δ", "ε", "ζ", "η", "θ", "ι", "κ", "λ", "μ", "ν", "ξ",
                "ο", "π", "ρ", "σ", "τ", "υ", "φ", "χ", "ψ", "ω"
        };

        if (position >= 0 && position < greekLetters.length) {
            return greekLetters[position];
        }
        return "";
    }

    public String toStringLycanthrope() {
        if (rank == -1) {
            return toString();
        }

        String color = "";

        if(hungerLevel<=10) {
            color = "\u001b[31;1m"; // bright red
        }
        if (hungerLevel<=20) {
            color = "\u001B[31m"; //red
        }
        if(isSleeping) {
            color = "\u001B[94m"; //light blue
        }

        return this + color + ", " + greekSwitch(rank) + "\u001B[0m";
    }

    @Override
    public void makeSound(ArrayList<String> creatureActionLog) {
        creatureActionLog.add("\u001B[90m"+getSpecies() + " *WAF WAF WAOUUUF*\u001B[0m");
    }
}