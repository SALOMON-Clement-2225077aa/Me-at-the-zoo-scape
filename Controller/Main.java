package Controller;

import static Model.Zoo.CreateEnclosure.createEmptyEnclosure;

import Model.Creatures.Creature;
import Model.Creatures.Viviparous.Mermaid;
import Model.Creatures.Viviparous.Unicorn;
import Model.Enclosure.Enclosure;
import Model.Zoo.FantasticZooMaster;
import View.UI;
import Model.Zoo.FantasticZoo;

import java.util.ArrayList;
import java.util.Scanner;


// Classe Controller.Main pour l'exécution de la simulation
public class Main {

    public static void main(String[] args) {
        System.out.println("--- Welcome to Me at The zoo-scape ! ---");

        // Création du Maître et du Zoo fantastique :
        FantasticZooMaster zooMaster = new FantasticZooMaster("playerName","Man",19);
        ArrayList<Enclosure> ListEnclosure = createEmptyEnclosure();
        FantasticZoo zoo = new FantasticZoo("First Zoo",zooMaster,15,ListEnclosure);

        // Ajout de créature :
        Unicorn unicorn1 = new Unicorn("Unicorn","male",75,100,35);
        ListEnclosure.get(2).addCreature(unicorn1);

        Mermaid mermaid1 = new Mermaid("Mermaid","female",60,90,25);
        ListEnclosure.get(7).addCreature(mermaid1);

        // Affiche le Zoo :
        UI ui = new UI();
        ui.updateEnclosure(ListEnclosure.get(ui.getPosition()));

        Scanner readInput = new Scanner(System.in);

        // Déplacement test
        MovementInput.move(ui,ListEnclosure,"Z");
        MovementInput.move(ui,ListEnclosure,"Z");
        MovementInput.move(ui,ListEnclosure,"Q");
        MovementInput.move(ui,ListEnclosure,"Q");
        MovementInput.move(ui,ListEnclosure,"Q");

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