package Model.Creatures.Viviparous;

import Model.Creatures.Type.Swimmer;

import java.util.ArrayList;

/**
 * La classe Mermaid représente une sirène, une créature vivipare ayant la capacité de nager.
 * Elle hérite de la classe abstraite Viviparous et implémente l'interface Swimmer.
 */
public class Mermaid extends Viviparous implements Swimmer {

    /**
     * Constructeur de la classe Mermaid.
     *
     * @param species      Le nom de l'espèce de la sirène.
     * @param gender       Le genre de la sirène.
     * @param weight       Le poids de la sirène.
     * @param size         La taille de la sirène.
     * @param age          L'âge de la sirène.
     * @param hungerLevel  Le niveau de faim initial de la sirène.
     */
    public Mermaid(String species, String gender, double weight, double size, int age, int hungerLevel) {
        super(species, gender, weight, size, age, 20, hungerLevel);
    }

    /**
     * Implémentation de la méthode makeSound spécifique à la sirène.
     *
     * @param creatureActionLog La liste des actions de la créature pour le suivi.
     */
    @Override
    public void makeSound(ArrayList<String> creatureActionLog) {
        creatureActionLog.add("\u001B[90m"+getSpecies() + " *SPLOUCHH*\u001B[0m");
    }
}
