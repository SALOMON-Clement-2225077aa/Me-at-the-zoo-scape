package Model.Creatures.Type;

/**
 * L'interface Swimmer définit le comportement des créatures capables de nager.
 */
public interface Swimmer {

    /**
     * Méthode par défaut permettant à la créature de nager.
     * Cette méthode affiche un message indiquant que la créature est en train de nager.
     */
    default void swim() {
        System.out.println("The creature is swimming");
    }
}
