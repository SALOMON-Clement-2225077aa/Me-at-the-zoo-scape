import View.UI;
import Model.Zoo.CreateZoo;
import Model.Zoo.FantasticZoo;

import java.util.Scanner;

// Classe Main pour l'exécution de la simulation
public class Main {

    public static void main(String[] args) {
        System.out.println("--- Welcome to Me at The zoo-scape ! ---");

        // Création du Model.Zoo :
        FantasticZoo zoo = CreateZoo.createZoo();

        // Affiche le Model.Zoo :
        UI ui = new UI();
        ui.display(' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ');

        Scanner readInput = new Scanner(System.in);

        // Déplacement test
        ui.move("Z");
        ui.move("Z");
        ui.move("Q");
        ui.move("Q");
        ui.move("Q");
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