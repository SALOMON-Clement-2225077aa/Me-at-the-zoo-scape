package Controller;

import Model.Creatures.Creature;
import Model.Creatures.Type.Flyer;
import Model.Creatures.Type.Runner;
import Model.Creatures.Type.Swimmer;
import Model.Creatures.Viviparous.Nymph;
import Model.Enclosure.Aquarium;
import Model.Enclosure.Aviary;
import Model.Enclosure.Enclosure;
import View.UI;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class MoveCreatureInput {

    public static String deplacer(UI ui, ArrayList<Enclosure> ListEnclosure) {

        ArrayList<Integer> possible = validPlacement(ui,ListEnclosure);
        if(!possible.isEmpty()) {
            ui.displayPlacementMap(possible);
            int choix = choicePlacement(possible);
            moveEveryone(ui, ListEnclosure, choix);
            return "The creatures have been moved to enclosure n°"+choix;
        }
        else {
            return "You cannot move those creatures...";
        }
    }



    public static ArrayList<Integer> validPlacement(UI ui, ArrayList<Enclosure> ListEnclosure) {

        // l'enclos en cours, le type de créatures et leurs nombre
        Enclosure currentEnclosure = ListEnclosure.get(ui.getPosition());
        int moveCapacity = currentEnclosure.currentCapacity;
        Creature moveCreature = currentEnclosure.getCreatures().get(0);

        // Liste des possibles :
        ArrayList<Integer> possibleMoves = new ArrayList<>();

        // Vérif de chaque enclos si c'est possible
        for (int i = 0; i < ListEnclosure.size(); i++) {
            boolean addOrNot = false;
            // Est-ce qu'il y a la place de mettre toutes les créatures dedans ?
            if (ListEnclosure.get(i).currentCapacity + moveCapacity <= ListEnclosure.get(i).maxCapacity) {
                if (ListEnclosure.get(i).getCreatures().isEmpty()){
                    // Si c'est vide et que y'a la place on vérifie le type d'enclos
                    if(ListEnclosure.get(i) instanceof Aquarium) {
                        if(moveCreature instanceof Swimmer) {
                            addOrNot = true;
                        }
                    } else if (ListEnclosure.get(i) instanceof Aviary) {
                        if(moveCreature instanceof Flyer) {
                            addOrNot = true;
                        }
                    } else {
                        if (moveCreature instanceof Runner || moveCreature instanceof Nymph) {
                            addOrNot = true;
                        }
                    }
                } else if (ListEnclosure.get(i).getCreatures().get(0).getSpecies().equals(moveCreature.getSpecies())) {
                    // Si ils sont de la même espèce et que ya la place
                    addOrNot = true;
                }
            }
            if(addOrNot && i != ui.getPosition()){
                possibleMoves.add(i);
            }
        }
        return possibleMoves;
    }

    public static int choicePlacement(ArrayList<Integer> possibleMoves) {

        while(true) {
            if(possibleMoves.isEmpty()){
                System.out.println("You cannot move those creatures...");
                return -1;
            }
            else {
                System.out.println("Where do you want to place them ? The possible position are :");
                System.out.println(possibleMoves.toString());
                // Récup input
                Scanner scanner = new Scanner(System.in);
                String userInput = scanner.nextLine();
                for (Integer possibleMove : possibleMoves) {
                    if (Objects.equals(userInput, possibleMove.toString())) {
                        return possibleMove;
                    }
                }
            }
            System.out.println("Not Valid Input");
        }
    }

    public static void moveEveryone(UI ui, ArrayList<Enclosure> ListEnclosure, int choix) {

        Enclosure currentEnclosure = ListEnclosure.get(ui.getPosition());
        ArrayList<Creature> creaturesToMove = new ArrayList<>(currentEnclosure.getCreatures());

        // Move each creature to the chosen enclosure
        for (Creature creature : creaturesToMove) {
            // Remove the creature from the current enclosure
            currentEnclosure.removeCreature(creature);
            ListEnclosure.get(choix).addCreature(creature);
            // Update the creature enclosure reference
            creature.setEnclosure(ListEnclosure.get(choix));
        }
    }


}
