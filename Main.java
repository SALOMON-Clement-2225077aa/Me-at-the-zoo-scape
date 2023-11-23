import Creatures.Creature;
import Enclosure.Enclosure;
import Enclosure.Aquarium;
import Enclosure.Aviary;
import UI.UI;
import Zoo.FantasticZoo;
import Zoo.FantasticZooMaster;

import java.util.ArrayList;
import java.util.Arrays;

// Classe Main pour l'exécution de la simulation
public class Main {

    public static void main(String[] args) {
        System.out.println("--- Welcome to Me at The zoo-scape ! ---");

        // Création du Maître fantastique :
        FantasticZooMaster zooMaster = new FantasticZooMaster("playerName","Man",19);

        // Création des enclos :
        ArrayList<Creature> creatures = new ArrayList<Creature>();
            // Basiques
        Enclosure e0 = new Enclosure("e0",100,10,0,creatures,false);
        Enclosure e1 = new Enclosure("e1",100,10,0,creatures,false);
        Enclosure e2 = new Enclosure("e2",100,10,0,creatures,false);
        Enclosure e3 = new Enclosure("e3",100,10,0,creatures,false);
        Enclosure e4 = new Enclosure("e4",100,10,0,creatures,false);
            // Aquarium
        Aquarium e5 = new Aquarium("e5",100,10,0,creatures,false,100,0);
        Aquarium e6 = new Aquarium("e6",100,10,0,creatures,false,100,0);
        Aquarium e7 = new Aquarium("e7",100,10,0,creatures,false,100,0);
        Aquarium e8 = new Aquarium("e8",100,10,0,creatures,false,100,0);
        Aquarium e9 = new Aquarium("e9",100,10,0,creatures,false,100,0);
            // Aviary
        Aviary e10 = new Aviary("e10",100,10,0,creatures,false,100);
        Aviary e11 = new Aviary("e11",100,10,0,creatures,false,100);
        Aviary e12 = new Aviary("e12",100,10,0,creatures,false,100);
        Aviary e13 = new Aviary("e13",100,10,0,creatures,false,100);
        Aviary e14 = new Aviary("e14",100,10,0,creatures,false,100);

        ArrayList<Enclosure> ListEnclosure = new ArrayList<Enclosure>(Arrays.asList(e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14));

        // Création du Zoo fantastique
        FantasticZoo zoo = new FantasticZoo("First Zoo",zooMaster,15,ListEnclosure);

        // Affiche le Zoo :
        UI ui = new UI();
        ui.display(' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ');

        // Déplacement test
        ui.move('Z');
        ui.move('Z');
        ui.move('Q');
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