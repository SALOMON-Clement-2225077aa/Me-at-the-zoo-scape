package View;

import Model.Enclosure.*;

import java.util.ArrayList;

public class UI {

    int cursorPosition;

    public UI() {
        cursorPosition = 7;
    }

    // Get and Set position
    public int getPosition() {
        return cursorPosition;
    }
    public void setPosition(int position) {
        this.cursorPosition = position;
    }

    public void display(String[] symbolArray, String[] enclosureInfo, String[] creatureInfo){
        clearScreen();
        System.out.println(
                "---------------------------------------------------                                    o Key symbols :\n" +
                "|         |         |         |         |         |                                      - \u001B[36mX\u001B[0m : Player\n" +
                "|         |         |         |         |         |                                      - \u001B[31m!\u001B[0m : Hungry creatures\n" +
                "|   "+symbolArray[0]+"   |   "+symbolArray[1]+"   |   "+symbolArray[2]+"   |   "+symbolArray[3]+"   |   "+symbolArray[4]+"   |    => Basic Enclosure                - \u001B[35m~\u001B[0m : Dirty enclosure\n" +
                "|         |         |         |         |         |                                      - \u001B[90m?\u001B[0m : Empty enclosure\n" +
                "|         |         |         |         |         |\n" +
                "---------------------------------------------------\n" +
                "(         (         (         (         (         (                          o Creatures (" + enclosureInfo[2] + ") :\n" +
                " )         )         )         )         )         )                           - "+ creatureInfo[0] +"\n" +
                "(   "+symbolArray[5]+"   (   "+symbolArray[6]+"   (   "+symbolArray[7]+"   (   "+symbolArray[8]+"   (   "+symbolArray[9]+"   (    => Aquarium             - "+ creatureInfo[1] +"\n" +
                " )         )         )         )         )         )                           - "+ creatureInfo[2] +"\n" +
                "(         (         (         (         (         (                            - "+ creatureInfo[3] +"\n" +
                "---------------------------------------------------                            - "+ creatureInfo[4] +"\n" +
                "<         >         <         >         <         >                            - "+ creatureInfo[5] +"\n" +
                ">         <         >         <         >         <                            - "+ creatureInfo[6] +"\n" +
                "<   "+symbolArray[10]+"   >   "+symbolArray[11]+"   <   "+symbolArray[12]+"   >   "+symbolArray[13]+"   <   "+symbolArray[14]+"   >    => Aviary               - "+ creatureInfo[7] +"\n" +
                ">         <         >         <         >         <                            - "+ creatureInfo[7] +"\n" +
                "<         >         <         >         <         >                            - "+ creatureInfo[8] +"\n" +
                "---------------------------------------------------\n" +
                "\n" +
                "o Actions :                                                                            o Selected enclosure :\n" +
                "  - Move ('z','q','s' or 'd')                                                            - enclosure type : " + enclosureInfo[0] + "\n" +
                "  - 'clean' (or 'c')                                                                     - creatures species: " + enclosureInfo[1] + "\n" +
                "  - 'feed' (or 'f')                                                                      - enclosure dirtiness : " + enclosureInfo[3] + "\n" +
                "- - - - - - - - - -");
    }

    public void updateEnclosure(ArrayList<Enclosure> ListEnclosure, Enclosure currentEnclosure) {

        // ---------------------------------
        // charArray
        String[] symbolArray = new String[ListEnclosure.size()];

        for (int i = 0; i < ListEnclosure.size(); i++) {
            if (ListEnclosure.get(i).isThereHungryCreature()) {
                symbolArray[i] = "\u001B[31m ! \u001B[0m";
            } else if (ListEnclosure.get(i).enclosureDirtiness >= 75) {
                symbolArray[i] = "\u001B[35m ~ \u001B[0m";
            } else if (ListEnclosure.get(i).currentCapacity == 0) {
                symbolArray[i] = "\u001B[90m ? \u001B[0m";
            } else {
                symbolArray[i] = "   ";
            }
        }
        // Player position
        // (priorité max donc écrase potentiellement une info)
        symbolArray[cursorPosition] = "\u001B[36m X \u001B[0m";

        // ---------------------------------
        // Enclosure Info
        String enclosureType = currentEnclosure.type();
        String creatureSpecies = currentEnclosure.creatureSpecies();
        String enclosureCapacity = currentEnclosure.capacity();
        String enclosureDirtiness = currentEnclosure.dirtiness();

        String[] enclosureInfo = {enclosureType,creatureSpecies,enclosureCapacity,enclosureDirtiness};

        // ---------------------------------
        // Creature Info
        String[] creatureInfo = new String[currentEnclosure.maxCapacity];

        for (int i = 0; i < currentEnclosure.creatures.size(); i++) {
            creatureInfo[i] = currentEnclosure.creatures.get(i).toString();
        }
        for (int i = currentEnclosure.creatures.size(); i < currentEnclosure.maxCapacity; i++) {
            creatureInfo[i] = "";
        }

        // ---------------------------------
        // Display
        display(symbolArray,enclosureInfo,creatureInfo);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        for(int i = 0; i <50; i++) {
            System.out.println();
        }
    }
}
