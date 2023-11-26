package Controller;

import static Model.Zoo.Init.CreateEnclosure.createEmptyEnclosure;

import Model.Enclosure.Enclosure;
import Model.Zoo.FantasticZooMaster;
import View.UI;
import Model.Zoo.FantasticZoo;
import Model.Zoo.Init.CreateCreatures;

import java.util.*;


// Classe Controller.Main pour l'exécution de la simulation
public class Main {

    public static void main(String[] args) {
        System.out.println("--- Welcome to Me at The zoo-scape ! ---");

        // Création du Maître et du Zoo fantastique :
        FantasticZooMaster zooMaster = new FantasticZooMaster("playerName","Man",19);
        ArrayList<Enclosure> ListEnclosure = createEmptyEnclosure();
        FantasticZoo zoo = new FantasticZoo("First Zoo",zooMaster,15,ListEnclosure);

        // Ajout de créature :
        CreateCreatures.addCreatureToTheZoo(ListEnclosure);

        // Affiche le Zoo :
        UI ui = new UI();
        ui.updateEnclosure(ListEnclosure, ListEnclosure.get(ui.getPosition()));

        // Comandes possibles :
        Set<String> validMovements = new HashSet<>(Arrays.asList("Z", "z", "Q", "q", "S", "s", "D", "d"));
        Set<String> validClean = new HashSet<>(Arrays.asList("CLEAN", "Clean", "clean", "C", "c"));
        Set<String> validFeed = new HashSet<>(Arrays.asList("FEED", "Feed", "feed", "F", "f"));

        // Boucle de jeu
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            if(validMovements.contains(userInput)) {
                MovementInput.move(ui,ListEnclosure,userInput);
            } else if (validClean.contains(userInput)) {
                System.out.println("Nettoayge");
            } else if (validFeed.contains(userInput)) {
                FeedInput.feed(ui,ListEnclosure);
            }
            // Actualise et affiche le Zoo
            ui.updateEnclosure(ListEnclosure, ListEnclosure.get(ui.getPosition()));
            // Actions des créatures
            zoo.everyoneDoSomethingInZoo();
        }

    }
}




// Victor's cooking process :
//import com.googlecode.lanterna.TerminalSize;
//import com.googlecode.lanterna.TextColor;
//import com.googlecode.lanterna.gui2.*;
//import com.googlecode.lanterna.screen.Screen;
//import com.googlecode.lanterna.screen.TerminalScreen;
//import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
//import com.googlecode.lanterna.terminal.Terminal;
//import java.io.IOException;
//    public static void main(String[] args) throws IOException {
//        // Setup terminal and screen layers
//        Terminal terminal = new DefaultTerminalFactory().createTerminal();
//        Screen screen = new TerminalScreen(terminal);
//        screen.startScreen();
//
//        // Create window to hold the panel
//        BasicWindow window = new BasicWindow();
//
//        // Create gui and start gui
//        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLACK));
//        gui.addWindowAndWait(window);