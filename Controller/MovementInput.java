package Controller;

import Model.Enclosure.Enclosure;
import View.UI;

import java.util.ArrayList;
import java.util.Objects;

public class MovementInput {

    public static void move(UI ui, ArrayList<Enclosure> ListEnclosure, String playerInput) {
        if (Objects.equals(playerInput, "Z") || Objects.equals(playerInput, "z")) {
            if(ui.getPosition() >= 0 && ui.getPosition() <= 4) {
                ui.setPosition(ui.getPosition()+10);
            }
            else {
                ui.setPosition(ui.getPosition()-5);
            }
        }
        if (Objects.equals(playerInput, "Q") || Objects.equals(playerInput, "q")) {
            if(ui.getPosition() == 0 || ui.getPosition() == 5 || ui.getPosition() == 10) {
                ui.setPosition(ui.getPosition()+4);
            }
            else {
                ui.setPosition(ui.getPosition()-1);
            }
        }
        if (Objects.equals(playerInput, "S") || Objects.equals(playerInput, "s")) {
            if(ui.getPosition() >= 10 && ui.getPosition() <= 14) {
                ui.setPosition(ui.getPosition()-10);
            }
            else {
                ui.setPosition(ui.getPosition()+5);
            }
        }
        if (Objects.equals(playerInput, "D") || Objects.equals(playerInput, "d")) {
            if(ui.getPosition() == 4 || ui.getPosition() == 9 || ui.getPosition() == 14) {
                ui.setPosition(ui.getPosition()-4);
            }
            else {
                ui.setPosition(ui.getPosition()+1);
            }
        }
    }

}
