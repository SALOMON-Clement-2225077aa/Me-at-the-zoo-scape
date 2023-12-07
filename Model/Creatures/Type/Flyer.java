package Model.Creatures.Type;

/**
 * L'interface Flyer définit le comportement des créatures capables de voler.
 */
public interface Flyer {

    /**
     * Méthode par défaut permettant à la créature de voler.
     * Cette méthode affiche un message indiquant que la créature vole.
     */
    default void fly() {
        System.out.println("The creature is flying");
    }
}
