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
        return result;
    }
}
