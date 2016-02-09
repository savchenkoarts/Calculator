package ua.savchenko.calculatorui;

import javax.swing.*;
import java.awt.*;

class Frame extends JFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalculatorFrame();
            }
        });
    }
}
