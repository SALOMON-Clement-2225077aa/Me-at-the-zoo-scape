package Controller;

import static Model.Zoo.CreateEnclosure.createEmptyEnclosure;

import Model.Creatures.Creature;
import Model.Creatures.Oviparous.Dragon;
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
        Unicorn unicorn1 = new Unicorn("Unicorn","male",75,3,35);
        ListEnclosure.get(4).addCreature(unicorn1);

        ListEnclosure.get(6).addCreature(new Mermaid("Mermaid","female",60,6,35));
        ListEnclosure.get(7).addCreature(new Mermaid("Mermaid","female",40,4.1,27));
        ListEnclosure.get(7).addCreature(new Mermaid("Mermaid","female",65,5.3,38));
        ListEnclosure.get(7).addCreature(new Mermaid("Mermaid","male",71,8.2,40));
        ListEnclosure.get(7).addCreature(new Mermaid("Mermaid","female",33,3.5,15));

        Dragon dragon1 = new Dragon("Dragon","male", 120,10,40);
        ListEnclosure.get(14).addCreature(dragon1);

        // Un animal à faim et un enclos est sale
        dragon1.hungerLevel = 20;
        ListEnclosure.get(10).enclosureDirtiness = 80;

        // Affiche le Zoo :
        UI ui = new UI();
        ui.updateEnclosure(ListEnclosure, ListEnclosure.get(ui.getPosition()));

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();

            MovementInput.move(ui,ListEnclosure,userInput);
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