package View;

import Model.Creatures.Viviparous.Lycanthrope.Lycanthrope;
import Model.Enclosure.*;
import Model.Zoo.FantasticZoo;

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

    public void display(String[] symbolArray, String[] enclosureInfo, String[] creatureInfo, String[] life){
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
                "  -  walk ('z','q','s' or 'd')                           "+life[0]+"                 - enclosure type : " + enclosureInfo[0] + "\n" +
                "  - 'clean' (or 'c')                                     "+life[1]+"                 - creatures species: " + enclosureInfo[1] + "\n" +
                "  - 'feed' (or 'f')                                      "+life[2]+"                 - " + enclosureInfo[4] + "enclosure dirtiness : " + enclosureInfo[3] + "\u001B[0m\n" +
                "  - 'WakeUp' the creatures (or 'w')\n"+
                "  - 'moveCreatures' 'or ('m')\n"+
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
        String dirtinessWarning = "";
        if(currentEnclosure.enclosureDirtiness>=75){
            dirtinessWarning = "\u001B[35m";
        }

        String[] enclosureInfo = {enclosureType,creatureSpecies,enclosureCapacity,enclosureDirtiness,dirtinessWarning};

        // ---------------------------------
        // Creature Info
        String[] creatureInfo = new String[currentEnclosure.maxCapacity];
        if (!currentEnclosure.creatures.isEmpty() && currentEnclosure.creatures.get(0) instanceof Lycanthrope) {
            ((Lycanthrope) currentEnclosure.creatures.get(0)).getHound().lycanthropesDisplay(creatureInfo);
        }
        else {
            for (int i = 0; i < currentEnclosure.creatures.size(); i++) {
                creatureInfo[i] = currentEnclosure.creatures.get(i).toString();
            }
            for (int i = currentEnclosure.creatures.size(); i < currentEnclosure.maxCapacity; i++) {
                creatureInfo[i] = "";
            }
        }
        // ---------------------------------
        // Nb of Life
        String[] life = new String[3];
        if(FantasticZoo.nbOfLife == 3) {
            life[0] = "/\\/\\  /\\/\\  /\\/\\  ";
            life[1] = "\\  /  \\  /  \\  /  ";
            life[2] = " \\/    \\/    \\/ㅤ  ";
        }
        if(FantasticZoo.nbOfLife == 2) {
            life[0] = "/\\/\\  /\\/\\      ";
            life[1] = "\\  /  \\  /      ";
            life[2] = " \\/    \\/    ㅤ  ";
        }
        if(FantasticZoo.nbOfLife == 1) {
            life[0] = "/\\/\\            ";
            life[1] = "\\  /            ";
            life[2] = " \\/         ㅤ  ";
        }
        if(FantasticZoo.nbOfLife <= 0) {
            life[0] = "                ";
            life[1] = "                ";
            life[2] = "                ";
        }

        // ---------------------------------
        // Display
        display(symbolArray,enclosureInfo,creatureInfo,life);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        for(int i = 0; i <50; i++) {
            System.out.println();
        }
    }


    public void displayPlacementMap(ArrayList<Integer> possible){
        // Met en rouge les déplacements impossible et en vert ceux possibles.
        String[] positionArray = new String[15];
        for(int i = 0; i < 15; i++) {
            if(i<10) {
                positionArray[i] = "\u001B[31m " + i + " \u001B[0m";
            }
            else {
                positionArray[i] = "\u001B[31m" + i + " \u001B[0m";
            }
        }
        for (Integer integer : possible) {
            if(integer<10) {
                positionArray[integer] = "\u001B[32m " + integer + " \u001B[0m";
            }
            else {
                positionArray[integer] = "\u001B[32m" + integer + " \u001B[0m";
            }
        }
        positionArray[cursorPosition] = "\u001B[36m X \u001B[0m";
        System.out.println("---------------------------------------------------\n" +
                "|         |         |         |         |         | \n" +
                "|         |         |         |         |         | \n" +
                "|   "+positionArray[0]+"   |   "+positionArray[1]+"   |   "+positionArray[2]+"   |   "+positionArray[3]+"   |   "+positionArray[4]+"   | \n" +
                "|         |         |         |         |         | \n" +
                "|         |         |         |         |         | \n" +
                "--------------------------------------------------- \n" +
                "(         (         (         (         (         ( \n" +
                " )         )         )         )         )         )\n" +
                "(   "+positionArray[5]+"   (   "+positionArray[6]+"   (   "+positionArray[7]+"   (   "+positionArray[8]+"   (   "+positionArray[9]+"   ( \n" +
                " )         )         )         )         )         )\n" +
                "(         (         (         (         (         (\n" +
                "---------------------------------------------------\n" +
                "<         >         <         >         <         >\n" +
                ">         <         >         <         >         <\n" +
                "<   "+positionArray[10]+"   >   "+positionArray[11]+"   <   "+positionArray[12]+"   >   "+positionArray[13]+"   <   "+positionArray[14]+"   >\n" +
                ">         <         >         <         >         <\n" +
                "<         >         <         >         <         >\n" +
                "---------------------------------------------------\n" +
                "\n");
    }

}