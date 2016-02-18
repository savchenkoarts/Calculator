package ua.savchenko.calculatorgui.gui;

import ua.savchenko.calculatorgui.service.Calculator;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CalculatorFrame extends JFrame{
    private String lastCommand = "=";
    private double result = 0;
    private boolean start = true;

    private JTextArea textArea;
    private JTextField textField;

    private JPanel panelNumber;
    private JPanel operation;

    private InsertAction insertAction = new InsertAction(this);
    private CommandAction commandAction = new CommandAction(this);
    private Calculator calculator = new Calculator(this);
    private Key key = new Key(this);

    public CalculatorFrame(){
        setTitle("Калькулятор");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        textArea = new JTextArea(7, 20);
        textArea.setBorder(new TitledBorder("Дисплей"));
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        textField = new JTextField("0", 15);
        textField.setPreferredSize(new Dimension(250, 40));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        Font font = new Font("Verdana", Font.BOLD, 15);
        textField.setFont(font);
        textField.setForeground(Color.blue);

        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.add(scroll, BorderLayout.PAGE_START);
        textPanel.add(textField, BorderLayout.PAGE_END);

        textArea.addKeyListener(key.keyAdapter);

        add(textPanel, BorderLayout.PAGE_START);
        add(panelNumber(), BorderLayout.CENTER);
        add(panelOperation(), BorderLayout.LINE_END);


        setVisible(true);
        pack();
    }

    public JTextField getTextField() {
        return textField;
    }

    public JTextArea getTextArea(){
        return textArea;
    }

    public String getLastCommand() {
        return lastCommand;
    }

    public void setLastCommand(String lastCommand) {
        this.lastCommand = lastCommand;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public boolean getStart() {
        return start;
    }

    public Calculator getCalculator() {
        return calculator;
    }

    JPanel panelNumber(){
        panelNumber = new JPanel(new GridBagLayout());

        String[] operations = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "."};
        JButton [] button = new JButton[operations.length];
        for (int i = 0; i < button.length; i++){
            button[i] = new JButton(new String(operations[i]));
            button[i].addActionListener(insertAction);

            switch (operations[i]){
                case "0":{
                    panelNumber.add(button[i], new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                    break;
                }
                case "1":{
                    panelNumber.add(button[i], new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                    break;
                }
                case "2":{
                    panelNumber.add(button[i], new GridBagConstraints(1, 2, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                    break;
                }
                case "3":{
                    panelNumber.add(button[i], new GridBagConstraints(2, 2, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                    break;
                }
                case "4":{
                    panelNumber.add(button[i], new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                    break;
                }
                case "5":{
                    panelNumber.add(button[i], new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                    break;
                }
                case "6":{
                    panelNumber.add(button[i], new GridBagConstraints(2, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                    break;
                }
                case "7":{
                    panelNumber.add(button[i], new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                    break;
                }
                case "8":{
                    panelNumber.add(button[i], new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                    break;
                }
                case "9":{
                    panelNumber.add(button[i], new GridBagConstraints(2, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                    break;
                }
                case ".":{
                    panelNumber.add(button[i], new GridBagConstraints(1, 3, 2, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                    break;
                }
            }
        }
        return panelNumber;
    }

    JPanel panelOperation(){
        operation = new JPanel(new GridBagLayout());

        String[] operations = {"/", "*", "-", "+", "C", "="};
        JButton[] button = new JButton[operations.length];
        for(int i = 0; i < operations.length; i++){
            button[i] = new JButton(new String(operations[i]));
            button[i].addActionListener(commandAction);

            switch (operations[i]){
                case "/":
                {
                    operation.add(button[i], new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                    break;
                }
                case "*":{
                    operation.add(button[i], new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                    break;
                }
                case "-":{
                    operation.add(button[i], new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                    break;
                }
                case "+":{
                    operation.add(button[i], new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL  , new Insets(2, 2, 2, 2), 0, 0));
                    break;
                }
                case "C":{
                    operation.add(button[i], new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                    break;
                }
                case "=":{
                    operation.add(button[i], new GridBagConstraints(1, 1, 1, 3, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.VERTICAL, new Insets(2, 2, 2, 2), 0, 0));
                    break;
                }
            }
        }
        return operation;
    }
}