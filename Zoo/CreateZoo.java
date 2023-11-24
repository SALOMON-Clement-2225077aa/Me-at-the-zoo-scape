package Zoo;

import Creatures.Creature;
import Creatures.Viviparous.Unicorn;
import Enclosure.Enclosure;
import Enclosure.Aquarium;
import Enclosure.Aviary;

import java.util.ArrayList;
import java.util.Arrays;

public class CreateZoo {

    public static FantasticZoo createZoo() {

        // Création du Maître fantastique :
        FantasticZooMaster zooMaster = new FantasticZooMaster("playerName","Man",19);

        // Création des enclos :
        ArrayList<Creature> creatures = new ArrayList<Creature>();
        // Basiques
        Enclosure e0 = new Enclosure("e0",100,10,0,creatures,false);
        Enclosure e1 = new Enclosure("e1",100,10,0,creatures,false);
        Enclosure e2 = new Enclosure("e2",100,10,0,creatures,false);
        Enclosure e3 = new Enclosure("e3",100,10,0,creatures,false);
        Enclosure e4 = new Enclosure("e4",100,10,0,creatures,false);
        // Aquarium
        Aquarium e5 = new Aquarium("e5",100,10,0,creatures,false,100,0);
        Aquarium e6 = new Aquarium("e6",100,10,0,creatures,false,100,0);
        Aquarium e7 = new Aquarium("e7",100,10,0,creatures,false,100,0);
        Aquarium e8 = new Aquarium("e8",100,10,0,creatures,false,100,0);
        Aquarium e9 = new Aquarium("e9",100,10,0,creatures,false,100,0);
        // Aviary
        Aviary e10 = new Aviary("e10",100,10,0,creatures,false,100);
        Aviary e11 = new Aviary("e11",100,10,0,creatures,false,100);
        Aviary e12 = new Aviary("e12",100,10,0,creatures,false,100);
        Aviary e13 = new Aviary("e13",100,10,0,creatures,false,100);
        Aviary e14 = new Aviary("e14",100,10,0,creatures,false,100);

        // Animaux
        Unicorn U1 = new Unicorn("Unicorn","Male",60,10,0);
        e1.addCreature(U1);

        ArrayList<Enclosure> ListEnclosure = new ArrayList<Enclosure>(Arrays.asList(e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14));

        // Création du Zoo fantastique
        FantasticZoo zoo = new FantasticZoo("First Zoo",zooMaster,15,ListEnclosure);

        return zoo;
    }

}
