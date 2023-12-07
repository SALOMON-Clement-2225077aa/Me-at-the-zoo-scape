package Model.Zoo;

import Model.Enclosure.Enclosure;

import java.util.ArrayList;

/**
 * La classe FantasticZoo représente un zoo fantastique.
 */
public class FantasticZoo {

    /** Le nom du zoo. */
    private String name;
    /** Le maître du zoo. */
    private FantasticZooMaster player;
    /** Le nombre maximal d'enclos dans le zoo. */
    private int maxEnclosure;
    /** La liste des enclos du zoo. */
    private ArrayList<Enclosure> listEnclosure;
    /** Le nombre total de vies disponibles pour toutes les créatures du zoo. */
    public static int nbOfLife;

    /**
     * Constructeur de la classe FantasticZoo.
     * @param name Le nom du zoo.
     * @param player Le maître du zoo.
     * @param maxEnclosure Le nombre maximal d'enclos dans le zoo.
     * @param listEnclosure La liste des enclos du zoo.
     * @param nbOfLife Le nombre total de vies disponibles pour toutes les créatures du zoo.
     */
    public FantasticZoo(String name, FantasticZooMaster player, int maxEnclosure, ArrayList<Enclosure> listEnclosure, int nbOfLife) {
        this.name = name;
        this.player = player;
        this.maxEnclosure = maxEnclosure;
        this.listEnclosure = listEnclosure;
        FantasticZoo.nbOfLife = nbOfLife;
    }

    /**
     * Effectue une action pour chaque créature dans le zoo !!
     * @param creatureActionLog Une liste pour enregistrer les actions des créatures.
     * @return La liste des actions des créatures.
     */
    public ArrayList<String> everyoneDoSomethingInZoo(ArrayList<String> creatureActionLog) {
        creatureTurn(creatureActionLog);
        creatureReproduction(creatureActionLog);
        everyoneRemoveDead();
        return creatureActionLog;
    }

    /**
     * Effectue le tour de chaque créature dans les enclos du zoo !
     * @param creatureActionLog Une liste pour enregistrer les actions des créatures.
     */
    private void creatureTurn(ArrayList<String> creatureActionLog) {
        for (Enclosure enclosure : listEnclosure) {
            enclosure.everyoneDoSomething(creatureActionLog);
        }
    }

    /**
     * Supprime les créatures mortes de chaque enclos du zoo ;(.
     */
    private void everyoneRemoveDead() {
        for (Enclosure enclosure : listEnclosure) {
            enclosure.removeDead();
        }
    }

    /**
     * Gère la reproduction des créatures dans chaque enclos du zoo <3.
     * @param creatureActionLog Une liste pour enregistrer les actions des créatures.
     */
    private void creatureReproduction(ArrayList<String> creatureActionLog) {
        for (Enclosure enclosure : listEnclosure) {
            enclosure.reproduce(creatureActionLog);
            enclosure.updateBirth(creatureActionLog);
        }
    }
}
