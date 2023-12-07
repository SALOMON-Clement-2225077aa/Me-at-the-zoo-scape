package Controller;

import static Model.Zoo.Init.CreateEnclosure.createEmptyEnclosure;
import Model.Enclosure.Enclosure;
import Model.Zoo.FantasticZooMaster;
import Model.Zoo.FantasticZoo;
import Model.Zoo.Init.CreateCreatures;
import View.EasterEgg;
import View.EndScreen;
import View.UI;

import java.util.*;

/**
 * La classe principale qui gère l'exécution de la simulation du zoo fantastique.
 * Elle initialise le maître du zoo, le zoo, les enclos et les créatures.
 * La boucle de jeu est gérée ici, avec les actions du joueur et des créatures.
 */
public class Main {

    /**
     * La méthode principale qui démarre la simulation du zoo fantastique.
     *
     * @param args (non utilisé).
     */
    public static void main(String[] args) {
        System.out.println("--- Welcome to Me at The zoo-scape ! ---");

        // Création du Maître et du Zoo fantastique :
        FantasticZooMaster zooMaster = new FantasticZooMaster("Victir","Man",19);
        ArrayList<Enclosure> ListEnclosure = createEmptyEnclosure();
        FantasticZoo zoo = new FantasticZoo("First Zoo : The Zoo-Scape",zooMaster,15,ListEnclosure,3);

        // Ajout des créatures au zoo :
        CreateCreatures.addCreatureToTheZoo(ListEnclosure);

        // Affiche le Zoo en position initiale :
        UI ui = new UI();
        ui.updateEnclosure(ListEnclosure, ListEnclosure.get(ui.getPosition()),0);

        // nombre de jours écoulés
        int nbDay = 1;

        // -----------------
        // | Boucle de jeu :
        // -----------------
        while (true) {
            if(FantasticZoo.nbOfLife<=0 || FantasticZoo.nbOfLife>=666){break;}
            Scanner scanner = new Scanner(System.in); // Création scanner pour récup input
            String userInput = scanner.nextLine(); // récupération de l'input du joueur

            // L'input manager regarde si l'input est correcte et effectue l'action du joueur :
            String returnInfoInput = InputManager.executeInput(ui, ListEnclosure, userInput);

            // Actions des créatures :
            ArrayList<String> creatureActionLog = new ArrayList<>();
            creatureActionLog = zoo.everyoneDoSomethingInZoo(creatureActionLog);

            // Actualise et affiche le Zoo :
            ui.updateEnclosure(ListEnclosure, ListEnclosure.get(ui.getPosition()),nbDay);
            System.out.println(returnInfoInput); // Affiche l'action du joueur
            System.out.println("- - - - - - - - - -");

            // Affichage des actions des créatures :
            for (String uneAction : creatureActionLog) {
                System.out.println(uneAction);
            }

            if (nbDay % 30 == 0) {}
            ++nbDay;
        }
        if(FantasticZoo.nbOfLife<=0) {
            EndScreen.displayEndScreen(nbDay);
        }
        else{
            EasterEgg.displayEasterEgg();
        }
    }
}