package Controller;

import Model.Enclosure.Enclosure;
import Model.Zoo.FantasticZoo;
import View.*;
import java.util.*;

/**
 * La classe InputManager gère les entrées de l'utilisateur et exécute les actions correspondantes.
 */
public class InputManager {

    // Commandes possibles :
    private static String validMove = "dsqqsdz";
    private static Set<String> validWalk = new HashSet<>(Arrays.asList("Z", "z", "Q", "q", "S", "s", "D", "d"));
    private static Set<String> validClean = new HashSet<>(Arrays.asList("CLEAN", "Clean", "clean", "C", "c"));
    private static Set<String> validFeed = new HashSet<>(Arrays.asList("FEED", "Feed", "feed", "F", "f"));
    private static Set<String> validWakeUp = new HashSet<>(Arrays.asList("WAKE", "WAKEUP", "WakeUp", "Wakeup", "wakeup", "WAKE UP", "Wake Up", "Wake up", "wake up", "W", "w", "WU", "wu", "Wu", "wU"));
    private static Set<String> validMoveCreatures = new HashSet<>(Arrays.asList("MOVECREATURES", "MoveCreatures", "movecreatures", "M", "m"));
    private static String GoldenPath = "";

    /**
     * Exécute l'action correspondant à l'entrée de l'utilisateur.
     *
     * @param ui          L'interface utilisateur utilisée pour l'affichage.
     * @param ListEnclosure La liste des enclos du zoo.
     * @param userInput   L'entrée de l'utilisateur à traiter.
     * @return             Une String d'informations sur l'action effectuée.
     */
    public static String executeInput(UI ui, ArrayList<Enclosure> ListEnclosure, String userInput) {
        String infoInput = "";

        if (validWalk.contains(userInput)) {
            infoInput = WalkInput.move(ui, ListEnclosure, userInput);
            if (userInput.equals("z") || userInput.equals("Z")) {
                GoldenPath += "z";
            }
            if (userInput.equals("q") || userInput.equals("Q")) {
                GoldenPath += "q";
            }
            if (userInput.equals("s") || userInput.equals("S")) {
                GoldenPath += "s";
            }
            if (userInput.equals("d") || userInput.equals("D")) {
                GoldenPath += "d";
            }
        } else if (Objects.equals(userInput, "Walk") || Objects.equals(userInput, "walk")) {
            infoInput = "You have to type 'z', 'q', 's' or 'd' to move";
        } else if (validClean.contains(userInput)) {
            infoInput = ListEnclosure.get(ui.getPosition()).cleanEnclosure();
        } else if (validFeed.contains(userInput)) {
            infoInput = FeedInput.feed(ui, ListEnclosure);
        } else if (validWakeUp.contains(userInput)) {
            infoInput = WakeUpInput.wakeCreatureUp(ui, ListEnclosure);
        } else if (validMoveCreatures.contains(userInput) && ListEnclosure.get(ui.getPosition()).currentCapacity != 0) {
            infoInput = MoveCreatureInput.deplacer(ui, ListEnclosure);
        } else {
            infoInput = "Invalid input...";
        }

        if (!(validWalk.contains(userInput))) {
            GoldenPath = "";
        }

        if (ui.getPosition() == 7) {
            if (GoldenPath.length() >= 7) {
                String test = GoldenPath.substring(GoldenPath.length() - 7);
                if (test.equals(validMove)) {
                    FantasticZoo.nbOfLife = 666;
                }
            }
        }

        return infoInput;
    }
}
