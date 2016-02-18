package ua.savchenko.calculatorgui;

import ua.savchenko.calculatorgui.gui.CalculatorFrame;
import java.awt.*;

class Frame {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalculatorFrame();
            }
        });
    }
}
