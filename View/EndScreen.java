package View;

/**
 * La classe EndScreen est responsable de l'affichage de l'écran de fin de jeu en cas d'échec.
 */
public class EndScreen {

    /**
     * Affiche l'écran de fin de jeu en cas de défaite.
     *
     * @param nbDay Le nombre total de jours que le joueur a réussi à maintenir le zoo avant l'échec.
     */
    public static void displayEndScreen(int nbDay) {

        for(int i = 0; i <50; i++) {
            System.out.println();
        }

        System.out.println(
                "                                       -----------------------------------------------------\n" +
                "                                       |               Game Over: You Are Fired!           |\n" +
                "                                       -----------------------------------------------------\n" +
                "\n" +
                "                            Unfortunately, due to your negligence, the creatures in the zoo have perished.\n" +
                "                              Your inability to properly care for them has resulted in a tragic end.\n" +
                "                               As a result, you have been relieved of your duties as the zookeeper.\n" +
                "\n" +
                "          Take this as a lesson and remember that the well-being of the creatures should always be your top priority.\n" +
                "          Perhaps, in the future, you can redeem yourself as a responsible and caring zookeeper.\n\n\n" +
                "                                               You held the zoo for a total of "+ nbDay + " days.\n"+
                "                                                       Better luck next time !"+
                "\n"
        );
        for(int i = 0; i <10; i++) {
            System.out.println();
        }
    }
}
