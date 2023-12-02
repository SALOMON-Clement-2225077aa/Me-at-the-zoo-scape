package Controller;

import Model.Creatures.Creature;
import Model.Creatures.Type.Flyer;
import Model.Creatures.Type.Runner;
import Model.Creatures.Type.Swimmer;
import Model.Enclosure.Aquarium;
import Model.Enclosure.Aviary;
import Model.Enclosure.Enclosure;
import View.UI;

import java.util.ArrayList;

public class MoveCreaInput {

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
                        if (moveCreature instanceof Runner) {
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



}
