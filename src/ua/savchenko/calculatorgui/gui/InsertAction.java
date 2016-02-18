package ua.savchenko.calculatorgui.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertAction implements ActionListener {
    private CalculatorFrame frame;

    public InsertAction(CalculatorFrame frame){
        this.frame = frame;
    }

    @Override
    public void actionPerformed(final ActionEvent event) {
        String input = event.getActionCommand();
        if (frame.getStart()) {
            frame.getTextField().setText("");
            frame.setStart(false);
        }
        frame.getTextField().setText(frame.getTextField().getText() + input);
    }
}