package Controller;

import Model.Enclosure.Enclosure;
import View.UI;

import java.util.ArrayList;
import java.util.Objects;

public class MovementInput {

    static String infoInput = "";

    public static String move(UI ui, ArrayList<Enclosure> ListEnclosure, String playerInput) {
        if (Objects.equals(playerInput, "Z") || Objects.equals(playerInput, "z")) {
            infoInput = "Déplacement vers le haut";
            if(ui.getPosition() >= 0 && ui.getPosition() <= 4) {
                ui.setPosition(ui.getPosition()+10);
            }
            else {
                ui.setPosition(ui.getPosition()-5);
            }
        }
        if (Objects.equals(playerInput, "Q") || Objects.equals(playerInput, "q")) {
            infoInput = "Déplacement vers la gauche";
            if(ui.getPosition() == 0 || ui.getPosition() == 5 || ui.getPosition() == 10) {
                ui.setPosition(ui.getPosition()+4);
            }
            else {
                ui.setPosition(ui.getPosition()-1);
            }
        }
        if (Objects.equals(playerInput, "S") || Objects.equals(playerInput, "s")) {
            infoInput = "Déplacement vers le bas";
            if(ui.getPosition() >= 10 && ui.getPosition() <= 14) {
                ui.setPosition(ui.getPosition()-10);
            }
            else {
                ui.setPosition(ui.getPosition()+5);
            }
        }
        if (Objects.equals(playerInput, "D") || Objects.equals(playerInput, "d")) {
            infoInput = "Déplacement vers la droite";
            if(ui.getPosition() == 4 || ui.getPosition() == 9 || ui.getPosition() == 14) {
                ui.setPosition(ui.getPosition()-4);
            }
            else {
                ui.setPosition(ui.getPosition()+1);
            }
        }
        return infoInput;
    }

}
