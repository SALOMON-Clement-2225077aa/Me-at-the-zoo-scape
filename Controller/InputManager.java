package Controller;

import Model.Enclosure.Enclosure;
import View.UI;

import java.util.*;

public class InputManager {

    // Comandes possibles :
    private static Set<String> validWalk = new HashSet<>(Arrays.asList("Z", "z", "Q", "q", "S", "s", "D", "d"));
    private static Set<String> validClean = new HashSet<>(Arrays.asList("CLEAN", "Clean", "clean", "C", "c"));
    private static Set<String> validFeed = new HashSet<>(Arrays.asList("FEED", "Feed", "feed", "F", "f"));
    private static Set<String> validMoveCreatures = new HashSet<>(Arrays.asList("MOVECREATURES", "MoveCreatures", "movecreatures", "M", "m"));


    public static String executeInput(UI ui, ArrayList<Enclosure> ListEnclosure, String userInput) {
        String infoInput = "";
        if(validWalk.contains(userInput)) {
            infoInput = WalkInput.move(ui,ListEnclosure,userInput);
        } else if (Objects.equals(userInput, "walk") || Objects.equals(userInput, "w")) {
            infoInput = "You have to type 'z', 'q', 's' or 'd' to move";
        } else if (validClean.contains(userInput)) {
            infoInput = ListEnclosure.get(ui.getPosition()).cleanEnclosure();
        } else if (validFeed.contains(userInput)) {
            infoInput = FeedInput.feed(ui,ListEnclosure);
        } else if (validMoveCreatures.contains(userInput) && ListEnclosure.get(ui.getPosition()).currentCapacity!=0) {
            infoInput = MoveCreaInput.deplacer(ui,ListEnclosure);
        }
        else {
            infoInput = "Invalid input...";
        }
        return infoInput;
    }

}
