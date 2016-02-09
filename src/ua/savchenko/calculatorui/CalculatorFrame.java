package ua.savchenko.calculatorui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CalculatorFrame extends Frame{
    private String lastCommand;
    private double result;
    private boolean start;

    private JTextArea textArea;
    private JTextField textField;

    private JPanel panelNumber;
    private JPanel operation;

    CalculatorFrame(){
        setTitle("Калькулятор");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        result = 0;
        lastCommand = "=";
        start = true;

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

        add(textPanel, BorderLayout.PAGE_START);
        add(panelNumber(), BorderLayout.CENTER);
        add(operation(), BorderLayout.LINE_END);

        setVisible(true);
        pack();
    }

    JPanel panelNumber(){
        panelNumber = new JPanel(new GridBagLayout());

        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton button0 = new JButton("0");
        JButton buttonDot = new JButton(".");

        panelNumber.add(button7, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelNumber.add(button8 , new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelNumber.add(button9, new GridBagConstraints(2, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelNumber.add(button4, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelNumber.add(button5, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelNumber.add(button6, new GridBagConstraints(2, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelNumber.add(button1, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelNumber.add(button2, new GridBagConstraints(1, 2, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelNumber.add(button3, new GridBagConstraints(2, 2, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelNumber.add(button0, new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panelNumber.add(buttonDot, new GridBagConstraints(1, 3, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        button1.addActionListener(new InsertAction());
        button2.addActionListener(new InsertAction());
        button3.addActionListener(new InsertAction());
        button4.addActionListener(new InsertAction());
        button5.addActionListener(new InsertAction());
        button6.addActionListener(new InsertAction());
        button7.addActionListener(new InsertAction());
        button8.addActionListener(new InsertAction());
        button9.addActionListener(new InsertAction());
        button0.addActionListener(new InsertAction());
        buttonDot.addActionListener(new InsertAction());

        return panelNumber;
    }

    JPanel operation(){
        operation = new JPanel(new GridBagLayout());

        JButton dividedBy = new JButton("/");
        JButton multipliedBy = new JButton("*");
        JButton minus = new JButton("-");
        JButton plus = new JButton("+");
        JButton cleaned = new JButton("C");
        JButton equalTo = new JButton("=");

        operation.add(dividedBy, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        operation.add(multipliedBy, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        operation.add(minus, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        operation.add(plus, new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL  ,
                new Insets(2, 2, 2, 2), 0, 0));
        operation.add(cleaned, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        operation.add(equalTo, new GridBagConstraints(1, 1, 1, 3, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.VERTICAL,
                new Insets(2, 2, 2, 2), 0, 0));

        dividedBy.addActionListener(new CommandAction());
        multipliedBy.addActionListener(new CommandAction());
        minus.addActionListener(new CommandAction());
        plus.addActionListener(new CommandAction());
        cleaned.addActionListener(new CommandAction());
        equalTo.addActionListener(new CommandAction());

        return operation;
    }

    private class InsertAction implements ActionListener {
        @Override
        public void actionPerformed(final ActionEvent event) {
            String input = event.getActionCommand();
            if (start) {
                textField.setText("");
                start = false;
            }
            textField.setText(textField.getText() + input);
        }
    }

    private class CommandAction implements ActionListener {
        @Override
        public void actionPerformed(final ActionEvent event) {
            String command = event.getActionCommand();

            if (start) {
                if ("C".equals(command)) {
                    textField.setText("");
                    lastCommand = "=";
                    result = 0;
                    start = false;
                } else {
                    lastCommand = command;
                }
            } else {
                calculate(Double.parseDouble(textField.getText()));
                lastCommand = command;
                start = true;
            }
        }
    }

    void calculate(double x) {
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
        textField.setText("" + result);
        textArea.setText("Последний результат: \n" + textField.getText());
    }
}