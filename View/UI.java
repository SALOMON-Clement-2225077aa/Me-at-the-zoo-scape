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

    public void display(char[] charArray, String[] enclosureInfo, String[] creatureInfo){
        System.out.print("\033[H\033[2J"); // Clear
        System.out.println("" +
                "---------------------------------------------------                                    o Key symbols :\n" +
                "|         |         |         |         |         |                                      - X : Player\n" +
                "|         |         |         |         |         |                                      - ! : Hungry creatures\n" +
                "|    "+charArray[0]+"    |    "+charArray[1]+"    |    "+charArray[2]+"    |    "+charArray[3]+"    |    "+charArray[4]+"    |    => Basic Enclosure                - ~ : Dirty enclosure\n" +
                "|         |         |         |         |         |                                      - ? : Empty enclosure\n" +
                "|         |         |         |         |         |\n" +
                "---------------------------------------------------\n" +
                "(         (         (         (         (         (                          o Creatures (" + enclosureInfo[2] + ") :\n" +
                " )         )         )         )         )         )                           -"+ creatureInfo[0] +"\n" +
                "(    "+charArray[5]+"    (    "+charArray[6]+"    (    "+charArray[7]+"    (    "+charArray[8]+"    (    "+charArray[9]+"    (    => Aquarium             -"+ creatureInfo[1] +"\n" +
                " )         )         )         )         )         )                           -"+ creatureInfo[2] +"\n" +
                "(         (         (         (         (         (                            -"+ creatureInfo[3] +"\n" +
                "---------------------------------------------------                            -"+ creatureInfo[4] +"\n" +
                "<         >         <         >         <         >                            -"+ creatureInfo[5] +"\n" +
                ">         <         >         <         >         <                            -"+ creatureInfo[6] +"\n" +
                "<    "+charArray[10]+"    >    "+charArray[11]+"    <    "+charArray[12]+"    >    "+charArray[13]+"    <    "+charArray[14]+"    >    => Aviary               -"+ creatureInfo[7] +"\n" +
                ">         <         >         <         >         <                            -"+ creatureInfo[7] +"\n" +
                "<         >         <         >         <         >                            -"+ creatureInfo[8] +"\n" +
                "---------------------------------------------------\n" +
                "\n" +
                "o Actions :                                                                            o Selected enclosure :\n" +
                "  - Move (Z,Q,S,D)                                                                       - enclosure type : " + enclosureInfo[0] + "\n" +
                "  - Clean (or C)                                                                         - creatures species: " + enclosureInfo[1] + "\n" +
                "  - Feed (or F)                                                                          - capacity : " + enclosureInfo[2] + "\n" +
                "                                                                                         - enclosure dirtiness : " + enclosureInfo[3] + "\n" +
                "- - - - - - - - - -\n");
    }

    public void updateEnclosure(ArrayList<Enclosure> ListEnclosure, Enclosure currentEnclosure) {

        // ---------------------------------
        // charArray
        char[] charArray = new char[ListEnclosure.size()];

        for (int i = 0; i < ListEnclosure.size(); i++) {
            if (ListEnclosure.get(i).isThereHungryCreature()) {
                charArray[i] = '!';
            } else if (ListEnclosure.get(i).enclosureDirtiness > 75) {
                charArray[i] = '~';
            } else if (ListEnclosure.get(i).currentCapacity == 0) {
                charArray[i] = '?';
            } else {
                charArray[i] = ' ';
            }
        }
        // Player position
        // (priorité max donc écrase potentiellement une info)
        charArray[cursorPosition] = 'X';

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
        display(charArray,enclosureInfo,creatureInfo);
    }

}
