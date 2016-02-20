package ua.savchenko.calculatorgui.gui;

import ua.savchenko.calculatorgui.service.Calculator;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CalculatorFrame extends JFrame{
    private String lastCommand = "=";
    private double result = 0;
    private boolean start = true;
    private double resultFirst;
    private double resultSecond;

    private JTextArea textArea;
    private JTextField textField;

    private JPanel panelNumber;
    private JPanel operation;

    private InsertAction insertAction = new InsertAction(this);
    private CommandAction commandAction = new CommandAction(this);
    private Key key = new Key(this);

    public CalculatorFrame(){
        setTitle("Калькулятор");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        add(createTextPanel(), BorderLayout.PAGE_START);
        add(panelNumber(), BorderLayout.CENTER);
        add(panelOperation(), BorderLayout.LINE_END);

        setVisible(true);
        pack();
    }

    private JTextArea createTextArea(){
        textArea = new JTextArea(7, 20);
        textArea.setBorder(new TitledBorder("Дисплей"));
        textArea.setEditable(false);
        textArea.addKeyListener(key.keyAdapter);
        return textArea;
    }

    private JScrollPane scroll(){
        JScrollPane scroll = new JScrollPane(createTextArea());
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        return scroll;
    }

    private JTextField createTextField(){
        textField = new JTextField("0", 15);
        textField.setPreferredSize(new Dimension(250, 40));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        Font font = new Font("Verdana", Font.BOLD, 15);
        textField.setFont(font);
        textField.setForeground(Color.blue);
        return textField;
    }

    private JPanel createTextPanel(){
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.add(scroll(), BorderLayout.PAGE_START);
        textPanel.add(createTextField(), BorderLayout.PAGE_END);
        return textPanel;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setLastCommand(String lastCommand) {
        this.lastCommand = lastCommand;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public boolean getStart() {
        return start;
    }

    public void clean(){
        textField.setText("");
        lastCommand = "=";
        result = 0;
        start = false;
    }

    public void toCalculator(){
        resultFirst = result;
        resultSecond = Double.parseDouble(textField.getText());
        result = Calculator.calculate(Double.parseDouble(textField.getText()), lastCommand, result);
        textField.setText("" + result);
        if(!lastCommand.equals("=")){
            textArea.setText(textArea.getText() + " " + resultFirst + " " + lastCommand + " " + resultSecond + " = " + result + "\n");
        }
        start = true;
    }

    public JOptionPane createErrorPanel(){
        JOptionPane errorPane = new JOptionPane();
        errorPane.showMessageDialog(null,"Not supported operation", "Error!", JOptionPane.ERROR_MESSAGE);
        return errorPane;
    }

    private JPanel panelNumber(){
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

    private JPanel panelOperation(){
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