package Controller;

import Model.Enclosure.Enclosure;
import View.UI;

import java.util.ArrayList;

public class MovementInput {

    public static void move(UI ui, ArrayList<Enclosure> ListEnclosure, String playerInput) {
        if (playerInput == "Z" || playerInput == "z") {
            if(ui.getPosition() >= 0 && ui.getPosition() <= 4) {
                ui.setPosition(ui.getPosition()+10);
            }
            else {
                ui.setPosition(ui.getPosition()-5);
            }
        }
        if (playerInput == "Q" || playerInput == "q") {
            if(ui.getPosition() == 0 || ui.getPosition() == 5 || ui.getPosition() == 10) {
                ui.setPosition(ui.getPosition()+4);
            }
            else {
                ui.setPosition(ui.getPosition()-1);
            }
        }
        if (playerInput == "S" || playerInput == "s") {
            if(ui.getPosition() >= 10 && ui.getPosition() <= 14) {
                ui.setPosition(ui.getPosition()-10);
            }
            else {
                ui.setPosition(ui.getPosition()+5);
            }
        }
        if (playerInput == "D" || playerInput == "d") {
            if(ui.getPosition() == 4 || ui.getPosition() == 9 || ui.getPosition() == 14) {
                ui.setPosition(ui.getPosition()-4);
            }
            else {
                ui.setPosition(ui.getPosition()+1);
            }
        }
        ui.updateEnclosure(ListEnclosure.get(ui.getPosition()));
    }

}
