package Model.Zoo.Init;

import Model.Creatures.Creature;
import Model.Enclosure.Enclosure;
import Model.Enclosure.Aquarium;
import Model.Enclosure.Aviary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CreateEnclosure {

    public static ArrayList<Enclosure> createEmptyEnclosure() {

        int[] randomirtiness = generateRandomArray(15);

        // Création des enclos :
        // Basiques
        Enclosure e0 = new Enclosure("e0",100,10,new ArrayList<Creature>(),randomirtiness[0]);
        Enclosure e1 = new Enclosure("e1",100,10,new ArrayList<Creature>(),randomirtiness[1]);
        Enclosure e2 = new Enclosure("e2",100,10,new ArrayList<Creature>(),randomirtiness[2]);
        Enclosure e3 = new Enclosure("e3",100,10,new ArrayList<Creature>(),randomirtiness[3]);
        Enclosure e4 = new Enclosure("e4",100,10,new ArrayList<Creature>(),randomirtiness[4]);
        // Aquarium
        Aquarium e5 = new Aquarium("e5",100,10,new ArrayList<Creature>(),randomirtiness[5],100,0);
        Aquarium e6 = new Aquarium("e6",100,10,new ArrayList<Creature>(),randomirtiness[6],100,0);
        Aquarium e7 = new Aquarium("e7",100,10,new ArrayList<Creature>(),randomirtiness[7],100,0);
        Aquarium e8 = new Aquarium("e8",100,10,new ArrayList<Creature>(),randomirtiness[8],100,0);
        Aquarium e9 = new Aquarium("e9",100,10,new ArrayList<Creature>(),randomirtiness[9],100,0);
        // Aviary
        Aviary e10 = new Aviary("e10",100,10,new ArrayList<Creature>(),randomirtiness[10],100);
        Aviary e11 = new Aviary("e11",100,10,new ArrayList<Creature>(),randomirtiness[11],100);
        Aviary e12 = new Aviary("e12",100,10,new ArrayList<Creature>(),randomirtiness[12],100);
        Aviary e13 = new Aviary("e13",100,10,new ArrayList<Creature>(),randomirtiness[13],100);
        Aviary e14 = new Aviary("e14",100,10,new ArrayList<Creature>(),randomirtiness[14],100);

        ArrayList<Enclosure> ListEnclosure = new ArrayList<Enclosure>(Arrays.asList(e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14));

        return ListEnclosure;
    }

    public static int[] generateRandomArray(int size) {
        int[] randomArray = new int[size];
        Random rd = new Random();

        for (int i = 0; i < size; i++) {
            randomArray[i] = rd.nextInt(51); // Entre 0 et 50 compris
        }

        return randomArray;
    }

}
