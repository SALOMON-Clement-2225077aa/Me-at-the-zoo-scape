package Model.Creatures.Viviparous.Lycanthrope;

import Model.Creatures.Type.Runner;
import Model.Creatures.Viviparous.Viviparous;
import Model.Zoo.FantasticZooMaster;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Lycanthrope extends Viviparous implements Runner {

    private int strength;
    private int domFactor;
    private int rank;
    private int lvl;
    private String impetuosity;
    private Hound hound;
    private boolean isHuman = false;
    private FantasticZooMaster humanForm;

    public Lycanthrope(String species, String gender, double weight, double size, int age, int gestationDuration, int hungerLevel, int strength, int domFactor, int rank, int lvl, String impetuosity, Hound hound, String name) {
        super(species, gender, weight, size, age, gestationDuration, hungerLevel);
        this.strength = strength;
        this.domFactor = domFactor;
        this.rank = rank;
        this.lvl = lvl;
        this.impetuosity = impetuosity;
        this.hound = hound;
        humanForm = new FantasticZooMaster(name, gender, age);
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
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

    public void setImpetuosity(String impetuosity) {
        this.impetuosity = impetuosity;
    }

    public Hound getHound() {
        return hound;
    }

    public void setHound(Hound hound) {
        this.hound = hound;
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

    public void domination() {
        Random random = new Random();
        ArrayList<Lycanthrope> subjugable = new ArrayList<Lycanthrope>(); //arraylist des lycanthropes pouvant être dominés

        int lowestAge = 100;
        int biggestAge = 100;
        int strengthLimit = 100;

        switch (impetuosity) {
            case "calm" :
                lowestAge = 30;
                biggestAge = 60;
                strengthLimit = 10;
                break;

            case "moderate" :
                lowestAge = 30;
                strengthLimit = 5;
                break;

            case "lively" :
                lowestAge = 0;
                biggestAge = 0;
                strengthLimit = 0;
                break;

            default:
                makeSound();
        }
        for (Lycanthrope lycanthrope : hound.getLycanthropesHound()) {
            if (age >= lowestAge && age <= biggestAge
                    && lycanthrope.getStrength() <= strength - strengthLimit
                    && !lycanthrope.isSleeping
                    && lycanthrope != hound.getPairA().getFemale()) {
                subjugable.add(lycanthrope);
            }
            if (!subjugable.isEmpty()) {
                int rdNb = random.nextInt(subjugable.size()); //Nb entre 0 et le nombres de lycanthropes dans la liste
                int tie = random.nextInt(subjugable.size()); //déterminer le gagnant en ca de niveau égal
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
                    superiorityHowl();
                    targetedLycanthrope.submissionHowl();
                }
                else {
                    aggressivenessHowl();
                }
                targetedLycanthrope.setDomFactor(targetedLycanthrope.getDomFactor() - 1);

                loseRankByDomFactor();
                targetedLycanthrope.loseRankByDomFactor();
            }
        }
    }

    public void affiliationsHowl() {
        System.out.println(species + " *WAF WAF WAOUUUF*");
    }

    public void superiorityHowl() {
        System.out.println(species + "*AOU AOU AOUUUUUUUUU*");
    }

    public void submissionHowl() {
        System.out.println(species + "*ouu ouu ouu* :'(");
    }

    public void aggressivenessHowl() {
        System.out.println(species + "*GRRRRRRRRRRRRR*");
    }

    public boolean canHear() {
        return !isSleeping && !isIll;
    }

    public void splitUp () {
        hound.removeLycanthrope(this);
    }

    public void shift() {
        if (!isHuman) {
            isHuman = true;
            System.out.println(humanForm.getName() + " reprend ses esprits, il/elle n'est plus un lycanthrope");
        }
        else {
            isHuman = false;
            System.out.println(humanForm.getName() + " : Je suis devenu le monstre que j'ai toujours été (ref à Warwick)");
        }
    }

    @Override
    public void makeSound() {
        System.out.println(getSpecies() + " *WAF WAF WAOUUUF*");
    }
}