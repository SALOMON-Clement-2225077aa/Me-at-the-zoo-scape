package Controller;

import Model.Enclosure.Enclosure;
import View.UI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputManager {

    // Comandes possibles :
    private static Set<String> validMovements = new HashSet<>(Arrays.asList("Z", "z", "Q", "q", "S", "s", "D", "d"));
    private static Set<String> validClean = new HashSet<>(Arrays.asList("CLEAN", "Clean", "clean", "C", "c"));
    private static Set<String> validFeed = new HashSet<>(Arrays.asList("FEED", "Feed", "feed", "F", "f"));


    public static void executeInput(UI ui, ArrayList<Enclosure> ListEnclosure, String userInput) {

        if(validMovements.contains(userInput)) {
            MovementInput.move(ui,ListEnclosure,userInput);
        } else if (validClean.contains(userInput)) {
            System.out.println("Nettoayge");
        } else if (validFeed.contains(userInput)) {
            FeedInput.feed(ui,ListEnclosure);
        }

    }

}
