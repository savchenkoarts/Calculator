package ua.savchenko.calculatorgui.service;

import ua.savchenko.calculatorgui.gui.CalculatorFrame;
import java.awt.event.KeyEvent;

public class Calculator {
    private static CalculatorFrame frame;
    private double resultFirst;
    private KeyEvent e;

    public Calculator(CalculatorFrame frame){
        this.frame = frame;
    }

    public void calculate(double x) {
        resultFirst = frame.getResult();
        switch (frame.getLastCommand()) {
            case "+":
                frame.setResult(frame.getResult() + x);
                break;
            case "-":
                frame.setResult(frame.getResult() - x);
                break;
            case "*":
                frame.setResult(frame.getResult() * x);
                break;
            case "/":
                frame.setResult(frame.getResult() / x);
                break;
            case "=":
                frame.setResult(x);
                break;
        }
        frame.getTextField().setText("" + frame.getResult());
        if(!frame.getLastCommand().equals("=")){
            frame.getTextArea().setText(frame.getTextArea().getText() + " " + resultFirst + " " + frame.getLastCommand() + " " + x + " = " + frame.getResult() + "\n");
        }
    }
}
