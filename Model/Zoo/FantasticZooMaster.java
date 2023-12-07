package Model.Zoo;

/**
 * La classe FantasticZooMaster représente le maître fantastique du zoo.
 */
public class FantasticZooMaster {

    /** Le nom du maître fantastique. */
    private String name;
    /** Le sexe du maître fantastique. */
    private String sex;
    /** L'âge du maître fantastique. */
    private int age;

    /**
     * Constructeur de la classe FantasticZooMaster.
     * @param name Le nom du maître fantastique.
     * @param sex Le sexe du maître fantastique.
     * @param age L'âge du maître fantastique.
     */
    public FantasticZooMaster(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    /**
     * Renvoie le nom du maître fantastique.
     * @return Le nom du maître fantastique.
     */
    public String getName() {
        return name;
    }
}