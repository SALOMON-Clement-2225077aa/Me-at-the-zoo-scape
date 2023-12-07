package Model.Zoo.Init;

import Model.Creatures.Creature;
import Model.Enclosure.Enclosure;
import Model.Enclosure.Aquarium;
import Model.Enclosure.Aviary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Classe utilitaire pour la création d'enclos dans le zoo.
 */
public class CreateEnclosure {

    /**
     * Crée une liste d'enclos vides avec des caractéristiques aléatoires.
     *
     * @return Une liste d'enclos initialisés.
     */
    public static ArrayList<Enclosure> createEmptyEnclosure() {

        // Génère des niveaux de saleté aléatoires pour chaque enclos
        int[] randomDirtiness = generateRandomArray(15);

        // Création des enclos de base
        Enclosure e0 = new Enclosure("e0", 100, 10, new ArrayList<Creature>(), randomDirtiness[0]);
        Enclosure e1 = new Enclosure("e1", 100, 10, new ArrayList<Creature>(), randomDirtiness[1]);
        Enclosure e2 = new Enclosure("e2", 100, 10, new ArrayList<Creature>(), randomDirtiness[2]);
        Enclosure e3 = new Enclosure("e3", 100, 10, new ArrayList<Creature>(), randomDirtiness[3]);
        Enclosure e4 = new Enclosure("e4", 100, 10, new ArrayList<Creature>(), randomDirtiness[4]);

        // Création des aquariums
        Aquarium e5 = new Aquarium("e5", 100, 10, new ArrayList<Creature>(), randomDirtiness[5], 100, 0);
        Aquarium e6 = new Aquarium("e6", 100, 10, new ArrayList<Creature>(), randomDirtiness[6], 100, 0);
        Aquarium e7 = new Aquarium("e7", 100, 10, new ArrayList<Creature>(), randomDirtiness[7], 100, 0);
        Aquarium e8 = new Aquarium("e8", 100, 10, new ArrayList<Creature>(), randomDirtiness[8], 100, 0);
        Aquarium e9 = new Aquarium("e9", 100, 10, new ArrayList<Creature>(), randomDirtiness[9], 100, 0);

        // Création des volières
        Aviary e10 = new Aviary("e10", 100, 10, new ArrayList<Creature>(), randomDirtiness[10], 100);
        Aviary e11 = new Aviary("e11", 100, 10, new ArrayList<Creature>(), randomDirtiness[11], 100);
        Aviary e12 = new Aviary("e12", 100, 10, new ArrayList<Creature>(), randomDirtiness[12], 100);
        Aviary e13 = new Aviary("e13", 100, 10, new ArrayList<Creature>(), randomDirtiness[13], 100);
        Aviary e14 = new Aviary("e14", 100, 10, new ArrayList<Creature>(), randomDirtiness[14], 100);

        // Ajout des enclos à la liste
        ArrayList<Enclosure> ListEnclosure = new ArrayList<>(
                Arrays.asList(e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14));

        return ListEnclosure;
    }

    /**
     * Génère un tableau d'entiers aléatoires dans la plage de 0 à 50 inclus.
     *
     * @param size La taille du tableau.
     * @return Un tableau d'entiers aléatoires.
     */
    public static int[] generateRandomArray(int size) {
        int[] randomArray = new int[size];
        Random rd = new Random();

        for (int i = 0; i < size; i++) {
            randomArray[i] = rd.nextInt(51); // Entre 0 et 50 compris
        }

        return randomArray;
    }
}
