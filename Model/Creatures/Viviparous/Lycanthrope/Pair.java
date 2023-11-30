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
    }
    @Override
    public String toString() {
        return "a implementer";
    }
}
