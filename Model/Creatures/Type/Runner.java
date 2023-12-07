package Model.Creatures.Type;

/**
 * L'interface Runner définit le comportement des créatures capables de courir.
 */
public interface Runner {

    /**
     * Méthode par défaut permettant à la créature de courir.
     * Cette méthode affiche un message indiquant que la créature est en train de courir.
     */
    default void run() {
        System.out.println("The creature is running");
    }
}
