package Model.Creatures.Viviparous.Lycanthrope;

public class Pair {

    private Lycanthrope male;
    private Lycanthrope female;

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

    public void giveBirth() {
        // portée compte d’un à sept « jeunes »
        // lycanthropes rang 2 (ou 1 s’il n’y a pas déjà dans la meute)
    }
    @Override
    public String toString() {
        return "a implementer";
    }
}
