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
        try {
            String command = event.getActionCommand();
            if (frame.getStart()) {
                if ("C".equals(command)) {
                    frame.clean();
                } else {
                    frame.setLastCommand(command);
                }
            } else {
                if ("C".equals(command)) {
                    frame.clean();
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
        }catch (NumberFormatException exception){
            frame.createErrorPanel();
        }
    }
}
