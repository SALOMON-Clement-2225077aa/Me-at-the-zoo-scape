package View;

import Model.Enclosure.*;

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
                "|         |         |         |         |         |                                      - ? : Empty enclosure\n" +
                "|    "+charArray[0]+"    |    "+charArray[1]+"    |    "+charArray[2]+"    |    "+charArray[3]+"    |    "+charArray[4]+"    |    => Basic Enclosure                - ~ : Dirty enclosure\n" +
                "|         |         |         |         |         |                                      - ! : Hungry creatures\n" +
                "|         |         |         |         |         |\n" +
                "---------------------------------------------------\n" +
                "(         (         (         (         (         (                                    o Creatures (" + enclosureInfo[2] + ") :\n" +
                " )         )         )         )         )         )                                     -"+ creatureInfo[0] +"\n" +
                "(    "+charArray[5]+"    (    "+charArray[6]+"    (    "+charArray[7]+"    (    "+charArray[8]+"    (    "+charArray[9]+"    (    => Aquarium                       -"+ creatureInfo[1] +"\n" +
                " )         )         )         )         )         )                                     -"+ creatureInfo[2] +"\n" +
                "(         (         (         (         (         (                                      -"+ creatureInfo[3] +"\n" +
                "---------------------------------------------------                                      -"+ creatureInfo[4] +"\n" +
                "<         >         <         >         <         >                                      -"+ creatureInfo[5] +"\n" +
                ">         <         >         <         >         <                                      -"+ creatureInfo[6] +"\n" +
                "<    "+charArray[10]+"    >    "+charArray[11]+"    <    "+charArray[12]+"    >    "+charArray[13]+"    <    "+charArray[14]+"    >    => Aviary                         -"+ creatureInfo[7] +"\n" +
                ">         <         >         <         >         <                                      -"+ creatureInfo[7] +"\n" +
                "<         >         <         >         <         >                                      -"+ creatureInfo[8] +"\n" +
                "---------------------------------------------------\n" +
                "\n" +
                "o Selected enclosure :\n" +
                "  - enclosure type : " + enclosureInfo[0] + "\n" +
                "  - creatures species: " + enclosureInfo[1] + "\n" +
                "  - capacity : " + enclosureInfo[2] + "\n" +
                "  - enclosure dirtiness : " + enclosureInfo[3] + "\n" +
                "\n" +
                "o Actions :\n" +
                "  - Move (Z,Q,S,D)\n" +
                "  - Clean (or C)\n" +
                "  - Feed (or F)\n" +
                "\n" +
                "- - - - - - - - - -\n");
    }

    public void updateEnclosure(Enclosure enclosure) {

        // ---------------------------------
        // charArray
        char[] charArray = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

        // Player position
        charArray[cursorPosition] = 'X';

        // ---------------------------------
        // Enclosure Info
        String enclosureType = enclosure.type();
        String creatureSpecies = enclosure.creatureSpecies();
        String enclosureCapacity = enclosure.capacity();
        String enclosureDirtiness = enclosure.dirtyness();

        String[] enclosureInfo = {enclosureType,creatureSpecies,enclosureCapacity,enclosureDirtiness};

        // ---------------------------------
        // Creature Info
        String[] creatureInfo = new String[enclosure.maxCapacity];

        for (int i = 0; i < enclosure.creatures.size(); i++) {
            creatureInfo[i] = enclosure.creatures.get(i).toString();
        }
        for (int i = enclosure.creatures.size(); i < enclosure.maxCapacity; i++) {
            creatureInfo[i] = "";
        }

        // ---------------------------------
        // Display
        display(charArray,enclosureInfo,creatureInfo);
    }

}
