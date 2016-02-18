package ua.savchenko.calculatorgui.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandAction implements ActionListener {
    private CalculatorFrame frame;

    public CommandAction(CalculatorFrame frame){
        this.frame = frame;
    }

    @Override
    public void actionPerformed(final ActionEvent event) {
        String command = event.getActionCommand();
        if (frame.getStart()) {
            if ("C".equals(command)) {
                frame.getTextField().setText("");
                frame.setLastCommand("=");
                frame.setResult(0);
                frame.setStart(false);
            } else {
                frame.setLastCommand(command);
            }
        } else {
            if ("C".equals(command)) {
                frame.getTextField().setText("");
                frame.setLastCommand("=");
                frame.setResult(0);
                frame.setStart(false);
            }else {
                if(!frame.getTextField().getText().equals("")){
                    frame.getCalculator().calculate(Double.parseDouble(frame.getTextField().getText()));
                    frame.setLastCommand(command);
                    frame.setStart(true);
                }else{
                    frame.getTextField().setText("0");
                }
            }
        }
    }
}
