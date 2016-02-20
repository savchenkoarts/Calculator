package ua.savchenko.calculatorgui.service;

public class Calculator {

    public static double calculate(double x, String lastCommand, double result) {
        switch (lastCommand) {
            case "+":
                result += x;
                break;
            case "-":
                result -= x;
                break;
            case "*":
                result *= x;
                break;
            case "/":
                result /= x;
                break;
            case "=":
                result = x;
                break;
        }
<<<<<<< HEAD
        return result;
=======

        frame.getTextField().setText("" + frame.getResult());
        if(!frame.getLastCommand().equals("=")){
            frame.getTextArea().setText(frame.getTextArea().getText() + " " + resultFirst + " " + frame.getLastCommand() + " " + x + " = " + frame.getResult() + "\n");
        }
>>>>>>> 4e788b5ba7c5273bc391b62544cda9141cd11c51
    }
}
