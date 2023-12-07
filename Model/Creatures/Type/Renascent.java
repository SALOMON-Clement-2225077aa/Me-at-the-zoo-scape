package Model.Creatures.Type;

/**
 * L'interface Renascent définit le comportement des créatures capables de renaître.
 */
public interface Renascent {

    /**
     * Méthode par défaut permettant à la créature de renaître.
     * Cette méthode affiche un message indiquant que la créature renaît.
     */
    default void rebirth() {
        System.out.println("The creature rebirths!");
    }
}
