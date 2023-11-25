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

    public void display(char[] charArray, String[] enclosureInfo){
        System.out.print("\033[H\033[2J"); // Clear
        System.out.println("" +
                "---------------------------------------------------\n" +
                "|         |         |         |         |         |\n" +
                "|         |         |         |         |         |                          o Key symbols :\n" +
                "|    "+charArray[0]+"    |    "+charArray[1]+"    |    "+charArray[2]+"    |    "+charArray[3]+"    |    "+charArray[4]+"    |    => Model.Enclosure\n" +
                "|         |         |         |         |         |                          - X : Player\n" +
                "|         |         |         |         |         |                          - ? : Empty enclosure\n" +
                "---------------------------------------------------                          - ~ : Dirty enclosure\n" +
                "(         (         (         (         (         (                          - ! : Hungry creatures\n" +
                " )         )         )         )         )         )\n" +
                "(    "+charArray[5]+"    (    "+charArray[6]+"    (    "+charArray[7]+"    (    "+charArray[8]+"    (    "+charArray[9]+"    (    => Aquarium\n" +
                " )         )         )         )         )         )\n" +
                "(         (         (         (         (         (\n" +
                "---------------------------------------------------\n" +
                "<         >         <         >         <         >\n" +
                ">         <         >         <         >         <\n" +
                "<    "+charArray[10]+"    >    "+charArray[11]+"    <    "+charArray[12]+"    >    "+charArray[13]+"    <    "+charArray[14]+"    >    => Aviary\n" +
                ">         <         >         <         >         <\n" +
                "<         >         <         >         <         >\n" +
                "---------------------------------------------------\n" +
                "\n" +
                "o Selected enclosure :\n" +
                "- enclosure type : " + enclosureInfo[0] + "\n" +
                "- creatures species: " + enclosureInfo[1] + "\n" +
                "- capacity : " + enclosureInfo[2] + "\n" +
                "- enclosure dirtiness : " + enclosureInfo[3] + "\n" +
                "\n" +
                "o Actions :\n" +
                "- Move (Z,Q,S,D)\n" +
                "- Clean (or C)\n" +
                "- Feed (or F)\n" +
                "\n" +
                "- - - - - - - - - -\n" +
                "*Licorn noises*");
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
        String creatureType = enclosure.creatureSpecies();
        String enclosureCapacity = enclosure.capacity();
        String enclosureDirtiness = enclosure.dirtyness();

        String[] enclosureInfo = {enclosureType,creatureType,enclosureCapacity,enclosureDirtiness};

        // ---------------------------------
        // Display
        display(charArray,enclosureInfo);
    }

}
