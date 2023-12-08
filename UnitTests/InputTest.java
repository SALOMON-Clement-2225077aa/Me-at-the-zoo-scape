package UnitTests;

import Controller.FeedInput;
import Model.Creatures.Creature;
import Model.Creatures.Viviparous.Unicorn;
import Model.Enclosure.Enclosure;
import Controller.WalkInput;
import Model.Zoo.FantasticZoo;
import Model.Zoo.FantasticZooMaster;
import Model.Zoo.Init.CreateCreatures;
import View.UI;
import junit.framework.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static Model.Zoo.Init.CreateEnclosure.createEmptyEnclosure;
import static junit.framework.TestCase.assertEquals;

public class InputTest {
    private UI ui;
    private ArrayList<Enclosure> ListEnclosure;

    @Before
    public void setUp() {
        ui = new UI();
        FantasticZooMaster zooMaster = new FantasticZooMaster("Tester","Man",1600);
        ArrayList<Enclosure> ListEnclosure = createEmptyEnclosure();
        FantasticZoo zoo = new FantasticZoo("First Zoo : The Zoo-Scape",zooMaster,15,ListEnclosure,3);
        //
    }

    @Test
    public void testMoveUp() {
        assertEquals("You moved UP", WalkInput.move(ui, ListEnclosure, "Z"));
        // On vérifie ici si la position de l'UI a été mise à jour correctement.
    }

    @Test
    public void testMoveLeft() {
        assertEquals("You moved to the LEFT", WalkInput.move(ui, ListEnclosure, "Q"));
        // On vérifie ici si la position de l'UI a été mise à jour correctement.
    }

    @Test
    public void testMoveDown() {
        assertEquals("You moved DOWN", WalkInput.move(ui, ListEnclosure, "S"));
        // On vérifie ici si la position de l'UI a été mise à jour correctement.
    }

    @Test
    public void testMoveRight() {
        assertEquals("You moved to the RIGHT", WalkInput.move(ui, ListEnclosure, "D"));
        // On vérifie ici si la position de l'UI a été mise à jour correctement.
    }

    @Test
    public void testFeedNoCreatures() {
        ArrayList<Enclosure> ListEnclosure = createEmptyEnclosure();
        assertEquals("There are no creatures here.", FeedInput.feed(ui, ListEnclosure));
        // Vérifiez ici si le message est correct lorsque l'enclos est vide.
    }

}
