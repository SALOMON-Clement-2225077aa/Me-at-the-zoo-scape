package Model.Zoo.Init;

import java.util.ArrayList;
import java.util.Random;

import Model.Creatures.Viviparous.Lycanthrope.Hound;
import Model.Creatures.Viviparous.Lycanthrope.Pair;
import Model.Enclosure.Enclosure;

import Model.Creatures.Viviparous.Nymph;
import Model.Creatures.Viviparous.Unicorn;
import Model.Creatures.Viviparous.Lycanthrope.Lycanthrope;
import Model.Creatures.Viviparous.Mermaid;
import Model.Creatures.Oviparous.Kraken;
import Model.Creatures.Oviparous.Megalodon;
import Model.Creatures.Oviparous.Phoenix;
import Model.Creatures.Oviparous.Dragon;

public class CreateCreatures {

    public static void addCreatureToTheZoo(ArrayList<Enclosure> ListEnclosure) {
        addRunner(ListEnclosure);
        addSwimmer(ListEnclosure);
        addFlyer(ListEnclosure);
        addNymph(ListEnclosure);
        addMoreDragons(ListEnclosure);
    }

    private static void addRunner(ArrayList<Enclosure> ListEnclosure) {
        int[] randomArray = generateRandomArray(8); // hungerLevel aléatoire
        // - - - - - - - - - -
        // Création des animaux
        // - - - - - - - - - -
        // Unicorn
        Unicorn unicorn1 = new Unicorn("Unicorn", "male", 75, 3, 35,randomArray[0]);
        Unicorn unicorn2 = new Unicorn("Unicorn", "female", 80, 3.5, 38,randomArray[1]);
        Unicorn unicorn3 = new Unicorn("Unicorn", "male", 70, 2.5, 32,randomArray[2]);
        Unicorn unicorn4 = new Unicorn("Unicorn", "female", 85, 4, 40,randomArray[3]);
        // Lycanthrope
        Hound hound = new Hound(null, new ArrayList<Lycanthrope>());
        Lycanthrope lycanthrope1 = new Lycanthrope("Lycanthrope", "male", 80, 6, 30, randomArray[4], 20, 15, 3, 1,10, "Aggressive", hound, "Pierre Garand");
        Lycanthrope lycanthrope2 = new Lycanthrope("Lycanthrope", "female", 85, 6.5, 32, randomArray[5], 22, 18, 4, 2,12, "Fierce", hound, "Charles");
        Lycanthrope lycanthrope3 = new Lycanthrope("Lycanthrope", "male", 75, 5.5, 28, randomArray[6], 18, 12, 2, 3,9, "Bold", hound, "Jean");
        Lycanthrope lycanthrope4 = new Lycanthrope("Lycanthrope", "female", 90, 7, 35, randomArray[7], 25, 20, 5, 4,15, "Wild", hound,"Albert");

        ArrayList<Lycanthrope> setHound = new ArrayList<>();
        setHound.add(lycanthrope1);setHound.add(lycanthrope2);setHound.add(lycanthrope3);setHound.add(lycanthrope4);
        hound.setPair(lycanthrope1);
        hound.setLycanthropesHound(setHound);
        // - - - - - - - - - - - - - -
        // Ajout des animaux aux enclos
        // - - - - - - - - - - - - - -
        // Unicorn
        ListEnclosure.get(0).addCreature(unicorn1);
        unicorn1.setEnclosure(ListEnclosure.get(0));
        ListEnclosure.get(0).addCreature(unicorn2);
        unicorn2.setEnclosure(ListEnclosure.get(0));
        ListEnclosure.get(0).addCreature(unicorn3);
        unicorn3.setEnclosure(ListEnclosure.get(0));
        ListEnclosure.get(0).addCreature(unicorn4);
        unicorn4.setEnclosure(ListEnclosure.get(0));
        // Lycanthrope
        ListEnclosure.get(1).addCreature(lycanthrope1);
        lycanthrope1.setEnclosure(ListEnclosure.get(1));
        ListEnclosure.get(1).addCreature(lycanthrope2);
        lycanthrope2.setEnclosure(ListEnclosure.get(1));
        ListEnclosure.get(1).addCreature(lycanthrope3);
        lycanthrope3.setEnclosure(ListEnclosure.get(1));
        ListEnclosure.get(1).addCreature(lycanthrope4);
        lycanthrope4.setEnclosure(ListEnclosure.get(1));
    }

    private static void addSwimmer(ArrayList<Enclosure> ListEnclosure) {
        int[] randomArray = generateRandomArray(9); // hungerLevel aléatoire
        // - - - - - - - - - -
        // Création des animaux
        // - - - - - - - - - -
        // Mermaid
        Mermaid mermaid1 = new Mermaid("Mermaid","female",65,5.3,38,randomArray[0]);
        Mermaid mermaid2 = new Mermaid("Mermaid","male",71,8.2,42,randomArray[1]);
        Mermaid mermaid3 = new Mermaid("Mermaid","female",33,3.5,15,randomArray[2]);
        // Kraken
        Kraken kraken1 = new Kraken("Kraken", "male", 1000, 15.0, 150,randomArray[3]);
        Kraken kraken2 = new Kraken("Kraken", "female", 800, 12.0, 120,randomArray[4]);
        Kraken kraken3 = new Kraken("Kraken", "female", 900, 14.0, 130,randomArray[5]);
        // Megalodon
        Megalodon megalodon1 = new Megalodon("Megalodon", "male", 3000, 20.0, 200,randomArray[6]);
        Megalodon megalodon2 = new Megalodon("Megalodon", "female", 2500, 18.0, 180,randomArray[7]);
        Megalodon megalodon3 = new Megalodon("Megalodon", "male", 2800, 19.0, 190,randomArray[8]);
        // - - - - - - - - - - - - - -
        // Ajout des animaux aux enclos
        // - - - - - - - - - - - - - -
        // Mermaids
        ListEnclosure.get(5).addCreature(mermaid1);
        mermaid1.setEnclosure(ListEnclosure.get(5));
        ListEnclosure.get(5).addCreature(mermaid2);
        mermaid2.setEnclosure(ListEnclosure.get(5));
        ListEnclosure.get(5).addCreature(mermaid3);
        mermaid3.setEnclosure(ListEnclosure.get(5));
        // Krakens
        ListEnclosure.get(6).addCreature(kraken1);
        kraken1.setEnclosure(ListEnclosure.get(6));
        ListEnclosure.get(6).addCreature(kraken2);
        kraken2.setEnclosure(ListEnclosure.get(6));
        ListEnclosure.get(6).addCreature(kraken3);
        kraken3.setEnclosure(ListEnclosure.get(6));
        // Megalodons
        ListEnclosure.get(7).addCreature(megalodon1);
        megalodon1.setEnclosure(ListEnclosure.get(7));
        ListEnclosure.get(7).addCreature(megalodon2);
        megalodon2.setEnclosure(ListEnclosure.get(7));
        ListEnclosure.get(7).addCreature(megalodon3);
        megalodon3.setEnclosure(ListEnclosure.get(7));
    }

    private static void addFlyer(ArrayList<Enclosure> ListEnclosure) {
        int[] randomArray = generateRandomArray(8); // hungerLevel aléatoire
        // - - - - - - - - - -
        // Création des animaux
        // - - - - - - - - - -
        // Dragon
        Dragon dragon1 = new Dragon("Dragon", "male", 120, 10, 40,randomArray[0]);
        Dragon dragon2 = new Dragon("Dragon", "female", 110, 9, 38,randomArray[1]);
        Dragon dragon3 = new Dragon("Dragon", "male", 130, 11, 42,randomArray[2]);
        Dragon dragon4 = new Dragon("Dragon", "female", 115, 9.5, 39,randomArray[3]);
        // Phoenix
        Phoenix phoenix1 = new Phoenix("Phoenix", "male", 10, 1, 100,randomArray[4]);
        Phoenix phoenix2 = new Phoenix("Phoenix", "female", 9, 0.9, 98,randomArray[5]);
        Phoenix phoenix3 = new Phoenix("Phoenix", "male", 12, 1.1, 105,randomArray[6]);
        Phoenix phoenix4 = new Phoenix("Phoenix", "female", 11, 1, 102,randomArray[7]);
        // - - - - - - - - - - - - - -
        // Ajout des animaux aux enclos
        // - - - - - - - - - - - - - -
        // Dragons
        ListEnclosure.get(14).addCreature(dragon1);
        dragon1.setEnclosure(ListEnclosure.get(14));
        ListEnclosure.get(14).addCreature(dragon2);
        dragon2.setEnclosure(ListEnclosure.get(14));
        ListEnclosure.get(14).addCreature(dragon3);
        dragon3.setEnclosure(ListEnclosure.get(14));
        ListEnclosure.get(14).addCreature(dragon4);
        dragon4.setEnclosure(ListEnclosure.get(14));
        // Phoenix
        ListEnclosure.get(13).addCreature(phoenix1);
        phoenix1.setEnclosure(ListEnclosure.get(13));
        ListEnclosure.get(13).addCreature(phoenix2);
        phoenix2.setEnclosure(ListEnclosure.get(13));
        ListEnclosure.get(13).addCreature(phoenix3);
        phoenix3.setEnclosure(ListEnclosure.get(13));
        ListEnclosure.get(13).addCreature(phoenix4);
        phoenix4.setEnclosure(ListEnclosure.get(13));
    }

    private static void addNymph(ArrayList<Enclosure> ListEnclosure) {
    // C'est pas marqué mais j'imagine qu'elles vont dans les enclos de bases ?
        int[] randomArray = generateRandomArray(5); // hungerLevel aléatoire
        // - - - - - - - - - -
        // Création des animaux
        // - - - - - - - - - -
        Nymph nymph1 = new Nymph("Nymph", "female", 50, 4.5, 25,randomArray[0]);
        Nymph nymph2 = new Nymph("Nymph", "male", 55, 5.0, 27,randomArray[1]);
        Nymph nymph3 = new Nymph("Nymph", "female", 45, 4.0, 23,randomArray[2]);
        Nymph nymph4 = new Nymph("Nymph", "male", 60, 5.5, 30,randomArray[3]);
        Nymph nymph5 = new Nymph("Nymph", "female", 52, 4.8, 28,randomArray[4]);
        // - - - - - - - - - - - - - -
        // Ajout des animaux aux enclos
        // - - - - - - - - - - - - - -
        // Nymphs
        ListEnclosure.get(3).addCreature(nymph1);
        nymph1.setEnclosure(ListEnclosure.get(3));
        ListEnclosure.get(3).addCreature(nymph2);
        nymph2.setEnclosure(ListEnclosure.get(3));
        ListEnclosure.get(3).addCreature(nymph3);
        nymph3.setEnclosure(ListEnclosure.get(3));
        ListEnclosure.get(3).addCreature(nymph4);
        nymph4.setEnclosure(ListEnclosure.get(3));
        ListEnclosure.get(3).addCreature(nymph5);
        nymph5.setEnclosure(ListEnclosure.get(3));
    }

    private static void addMoreDragons(ArrayList<Enclosure> ListEnclosure) {
        int[] randomArray = generateRandomArray(6); // hungerLevel aléatoire
        // - - - - - - - - - -
        // Création des animaux
        // - - - - - - - - - -
        Dragon dragon5 = new Dragon("Dragon", "male", 125, 10.5, 41,randomArray[0]);
        Dragon dragon6 = new Dragon("Dragon", "female", 112, 9.2, 37,randomArray[1]);
        Dragon dragon7 = new Dragon("Dragon", "male", 135, 11.5, 43,randomArray[2]);
        Dragon dragon8 = new Dragon("Dragon", "female", 118, 10, 40,randomArray[3]);
        Dragon dragon9 = new Dragon("Dragon", "male", 130, 10.8, 42,randomArray[4]);
        Dragon dragon10 = new Dragon("Dragon", "female", 120, 9.8, 39,randomArray[5]);
        // - - - - - - - - - - - - - -
        // Ajout des animaux aux enclos
        // - - - - - - - - - - - - - -
        // Normal Enclosures
        ListEnclosure.get(4).addCreature(dragon5);
        dragon5.setEnclosure(ListEnclosure.get(4));
        ListEnclosure.get(4).addCreature(dragon6);
        dragon6.setEnclosure(ListEnclosure.get(4));
        ListEnclosure.get(4).addCreature(dragon7);
        dragon7.setEnclosure(ListEnclosure.get(4));
        // Aquariums
        ListEnclosure.get(9).addCreature(dragon8);
        dragon8.setEnclosure(ListEnclosure.get(9));
        ListEnclosure.get(9).addCreature(dragon9);
        dragon9.setEnclosure(ListEnclosure.get(9));
        ListEnclosure.get(9).addCreature(dragon10);
        dragon10.setEnclosure(ListEnclosure.get(9));
    }

    public static int[] generateRandomArray(int size) {
        int[] randomArray = new int[size];
        Random rd = new Random();

        for (int i = 0; i < size; i++) {
            randomArray[i] = rd.nextInt(81) + 20; // Entre 20 et 100 compris
        }

        return randomArray;
    }


}
