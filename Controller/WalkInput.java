package Controller;

import Model.Enclosure.Enclosure;
import View.UI;

import java.util.ArrayList;
import java.util.Objects;

/**
 * La classe WalkInput gère les actions de déplacement du joueur dans le zoo.
 */
public class WalkInput {

    static String infoInput = "";

    /**
     * Déplace le joueur dans le zoo en fonction de la direction spécifiée.
     *
     * @param ui            L'interface utilisateur utilisée pour l'affichage.
     * @param ListEnclosure La liste des enclos du zoo.
     * @param playerInput   La direction de déplacement spécifiée par le joueur.
     * @return              Une String d'informations sur l'action effectuée.
     */
    public static String move(UI ui, ArrayList<Enclosure> ListEnclosure, String playerInput) {
        if (Objects.equals(playerInput, "Z") || Objects.equals(playerInput, "z")) {
            infoInput = "You moved UP";
            if (ui.getPosition() >= 0 && ui.getPosition() <= 4) {
                ui.setPosition(ui.getPosition() + 10);
            } else {
                ui.setPosition(ui.getPosition() - 5);
            }
        }
        if (Objects.equals(playerInput, "Q") || Objects.equals(playerInput, "q")) {
            infoInput = "You moved to the LEFT";
            if (ui.getPosition() == 0 || ui.getPosition() == 5 || ui.getPosition() == 10) {
                ui.setPosition(ui.getPosition() + 4);
            } else {
                ui.setPosition(ui.getPosition() - 1);
            }
        }
        if (Objects.equals(playerInput, "S") || Objects.equals(playerInput, "s")) {
            infoInput = "You moved DOWN";
            if (ui.getPosition() >= 10 && ui.getPosition() <= 14) {
                ui.setPosition(ui.getPosition() - 10);
            } else {
                ui.setPosition(ui.getPosition() + 5);
            }
        }
        if (Objects.equals(playerInput, "D") || Objects.equals(playerInput, "d")) {
            infoInput = "You moved to the RIGHT";
            if (ui.getPosition() == 4 || ui.getPosition() == 9 || ui.getPosition() == 14) {
                ui.setPosition(ui.getPosition() - 4);
            } else {
                ui.setPosition(ui.getPosition() + 1);
            }
        }
        return infoInput;
    }
}
