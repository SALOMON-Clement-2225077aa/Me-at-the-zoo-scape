package Controller;

import static Model.Zoo.Init.CreateEnclosure.createEmptyEnclosure;

import Model.Enclosure.Enclosure;
import Model.Zoo.FantasticZooMaster;
import View.UI;
import Model.Zoo.FantasticZoo;
import Model.Zoo.Init.CreateCreatures;

import java.util.*;


// Classe Controller pour l'exécution de la simulation
public class Main {

    public static void main(String[] args) {
        System.out.println("--- Welcome to Me at The zoo-scape ! ---");

        // Création du Maître et du Zoo fantastique :
        FantasticZooMaster zooMaster = new FantasticZooMaster("Victir","Man",19);
        ArrayList<Enclosure> ListEnclosure = createEmptyEnclosure();
        FantasticZoo zoo = new FantasticZoo("First Zoo : The Zoo-Scape",zooMaster,15,ListEnclosure);

        // Ajout des créatures :
        CreateCreatures.addCreatureToTheZoo(ListEnclosure);

        // Affiche le Zoo :
        UI ui = new UI();
        ui.updateEnclosure(ListEnclosure, ListEnclosure.get(ui.getPosition()));

        // Boucle de jeu
        while (true) {
            // Récup input
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            String returnInfoInput = InputManager.executeInput(ui, ListEnclosure, userInput);
            // Actualise et affiche le Zoo
            ui.updateEnclosure(ListEnclosure, ListEnclosure.get(ui.getPosition()));
            System.out.println(returnInfoInput+"\n- - - - - - - - - -");
            // Actions des créatures
            zoo.everyoneDoSomethingInZoo();
            zoo.everyoneRemoveDead();
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