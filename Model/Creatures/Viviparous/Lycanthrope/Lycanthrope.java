package Model.Creatures.Viviparous.Lycanthrope;

import Model.Creatures.Type.Runner;
import Model.Creatures.Viviparous.Viviparous;

public class Lycanthrope extends Viviparous implements Runner {

    private int strenght;
    private int domFactor;
    private int rank;
    private int lvl;
    private String impetuosity;

    private Hound hound;


    public Lycanthrope(String species, String gender, double weight, double size, int age, int gestationDuration, int hungerLevel, int strenght, int domFactor, int rank, int lvl, String impetuosity, Hound hound) {
        super(species, gender, weight, size, age, gestationDuration, hungerLevel);
        this.strenght = strenght;
        this.domFactor = domFactor;
        this.rank = rank;
        this.lvl = lvl;
        this.impetuosity = impetuosity;
        this.hound = hound;
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
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

    @Override
    public void makeSound() {
        System.out.println(getSpecies() + " *WAF WAF WAOUUUF*");
    }
}
