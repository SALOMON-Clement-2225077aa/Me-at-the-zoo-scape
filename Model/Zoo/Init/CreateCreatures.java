package Model.Zoo.Init;

import java.util.ArrayList;
import Model.Enclosure.Enclosure;

import Model.Creatures.Viviparous.Nymph;
import Model.Creatures.Viviparous.Unicorn;
import Model.Creatures.Viviparous.Lycanthrope;
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
        addMoreDragons(ListEnclosure);
    }

    private static void addRunner(ArrayList<Enclosure> ListEnclosure) {
        // - - - - - - - - - -
        // Création des animaux
        // - - - - - - - - - -
        // Unicorn
        Unicorn unicorn1 = new Unicorn("Unicorn", "male", 75, 3, 35);
        Unicorn unicorn2 = new Unicorn("Unicorn", "female", 80, 3.5, 38);
        Unicorn unicorn3 = new Unicorn("Unicorn", "male", 70, 2.5, 32);
        Unicorn unicorn4 = new Unicorn("Unicorn", "female", 85, 4, 40);
        // Lycanthrope
        Lycanthrope lycanthrope1 = new Lycanthrope("Lycanthrope", "male", 80, 6, 30);
        Lycanthrope lycanthrope2 = new Lycanthrope("Lycanthrope", "female", 85, 6.5, 32);
        Lycanthrope lycanthrope3 = new Lycanthrope("Lycanthrope", "male", 75, 5.5, 28);
        Lycanthrope lycanthrope4 = new Lycanthrope("Lycanthrope", "female", 90, 7, 35);
        // - - - - - - - - - - - - - -
        // Ajout des animaux aux enclos
        // - - - - - - - - - - - - - -
        // Unicorn
        ListEnclosure.get(0).addCreature(unicorn1);
        ListEnclosure.get(0).addCreature(unicorn2);
        ListEnclosure.get(0).addCreature(unicorn3);
        ListEnclosure.get(0).addCreature(unicorn4);
        // Lycanthrope
        ListEnclosure.get(2).addCreature(lycanthrope1);
        ListEnclosure.get(2).addCreature(lycanthrope2);
        ListEnclosure.get(2).addCreature(lycanthrope3);
        ListEnclosure.get(2).addCreature(lycanthrope4);
    }

    private static void addSwimmer(ArrayList<Enclosure> ListEnclosure) {
        // - - - - - - - - - -
        // Création des animaux
        // - - - - - - - - - -
        // Mermaid
        Mermaid mermaid1 = new Mermaid("Mermaid","female",65,5.3,38);
        Mermaid mermaid2 = new Mermaid("Mermaid","male",71,8.2,42);
        Mermaid mermaid3 = new Mermaid("Mermaid","female",33,3.5,15);
        // Kraken
        Kraken kraken1 = new Kraken("Kraken", "male", 1000, 15.0, 150);
        Kraken kraken2 = new Kraken("Kraken", "female", 800, 12.0, 120);
        Kraken kraken3 = new Kraken("Kraken", "female", 900, 14.0, 130);
        // Megalodon
        Megalodon megalodon1 = new Megalodon("Megalodon", "male", 3000, 20.0, 200);
        Megalodon megalodon2 = new Megalodon("Megalodon", "female", 2500, 18.0, 180);
        Megalodon megalodon3 = new Megalodon("Megalodon", "male", 2800, 19.0, 190);
        // - - - - - - - - - - - - - -
        // Ajout des animaux aux enclos
        // - - - - - - - - - - - - - -
        // Mermaids
        ListEnclosure.get(5).addCreature(mermaid1);
        ListEnclosure.get(5).addCreature(mermaid2);
        ListEnclosure.get(5).addCreature(mermaid3);
        // Krakens
        ListEnclosure.get(7).addCreature(kraken1);
        ListEnclosure.get(7).addCreature(kraken2);
        ListEnclosure.get(7).addCreature(kraken3);
        // Megalodons
        ListEnclosure.get(8).addCreature(megalodon1);
        ListEnclosure.get(8).addCreature(megalodon2);
        ListEnclosure.get(8).addCreature(megalodon3);
    }

    private static void addFlyer(ArrayList<Enclosure> ListEnclosure) {
        // - - - - - - - - - -
        // Création des animaux
        // - - - - - - - - - -
        // Dragon
        Dragon dragon1 = new Dragon("Dragon", "male", 120, 10, 40);
        Dragon dragon2 = new Dragon("Dragon", "female", 110, 9, 38);
        Dragon dragon3 = new Dragon("Dragon", "male", 130, 11, 42);
        Dragon dragon4 = new Dragon("Dragon", "female", 115, 9.5, 39);
        // Phoenix
        Phoenix phoenix1 = new Phoenix("Phoenix", "male", 10, 1, 100);
        Phoenix phoenix2 = new Phoenix("Phoenix", "female", 9, 0.9, 98);
        Phoenix phoenix3 = new Phoenix("Phoenix", "male", 12, 1.1, 105);
        Phoenix phoenix4 = new Phoenix("Phoenix", "female", 11, 1, 102);
        // - - - - - - - - - - - - - -
        // Ajout des animaux aux enclos
        // - - - - - - - - - - - - - -
        // Dragons
        ListEnclosure.get(14).addCreature(dragon1);
        ListEnclosure.get(14).addCreature(dragon2);
        ListEnclosure.get(14).addCreature(dragon3);
        ListEnclosure.get(14).addCreature(dragon4);
        // Phoenix
        ListEnclosure.get(13).addCreature(phoenix1);
        ListEnclosure.get(13).addCreature(phoenix2);
        ListEnclosure.get(13).addCreature(phoenix3);
        ListEnclosure.get(13).addCreature(phoenix4);
    }

    private static void addMoreDragons(ArrayList<Enclosure> ListEnclosure) {
        // - - - - - - - - - -
        // Création des animaux
        // - - - - - - - - - -
        Dragon dragon5 = new Dragon("Dragon", "male", 125, 10.5, 41);
        Dragon dragon6 = new Dragon("Dragon", "female", 112, 9.2, 37);
        Dragon dragon7 = new Dragon("Dragon", "male", 135, 11.5, 43);
        Dragon dragon8 = new Dragon("Dragon", "female", 118, 10, 40);
        Dragon dragon9 = new Dragon("Dragon", "male", 130, 10.8, 42);
        Dragon dragon10 = new Dragon("Dragon", "female", 120, 9.8, 39);
        // - - - - - - - - - - - - - -
        // Ajout des animaux aux enclos
        // - - - - - - - - - - - - - -
        // Enclos normaux
        ListEnclosure.get(4).addCreature(dragon5);
        ListEnclosure.get(4).addCreature(dragon6);
        ListEnclosure.get(4).addCreature(dragon7);
        // Aquariums
        ListEnclosure.get(9).addCreature(dragon8);
        ListEnclosure.get(9).addCreature(dragon9);
        ListEnclosure.get(9).addCreature(dragon10);
    }

}
