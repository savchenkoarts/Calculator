package ua.savchenko.calculatorgui.gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Key {
    private CalculatorFrame frame;
    public Key(CalculatorFrame frame){
        this.frame = frame;
    }
    KeyAdapter keyAdapter = new KeyAdapter() {
        @Override
        public void keyPressed (KeyEvent e){
            try {
                int[] panelNumber = {e.VK_0, e.VK_1, e.VK_2, e.VK_3, e.VK_4, e.VK_5, e.VK_6, e.VK_7, e.VK_8, e.VK_9, e.VK_DECIMAL};
                for (int i = 0; i < panelNumber.length; i++) {
                    if ((e.getKeyCode()) == panelNumber[i]) {
                        if (frame.getStart()) {
                            frame.getTextField().setText("");
                            frame.setStart(false);
                        }
                        frame.getTextField().setText(frame.getTextField().getText() + e.getKeyChar());
                    }
                }

                int[] panelOperation = {e.VK_ADD, e.VK_SUBTRACT, e.VK_MULTIPLY, e.VK_DIVIDE, e.VK_ENTER, e.VK_BACK_SPACE};
                String[] panelOperationKey = {"+", "-", "*", "/", "=", "C"};
                for (int i = 0; i < panelOperation.length; i++) {
                    if ((e.getKeyCode()) == panelOperation[i]) {
                        if (frame.getStart()) {
                            if (panelOperationKey[i] == "C") {
                                frame.clean();
                            }
                            if(panelOperationKey[i] != "C"){
                                frame.setLastCommand(panelOperationKey[i]);
                            }
                        } else {
                            if (panelOperationKey[i] == "C") {
                                frame.clean();
                            }
                            if(panelOperationKey[i] != "C"){
                                if(!frame.getTextField().getText().equals("")){
                                    frame.getCalculator().calculate(Double.parseDouble(frame.getTextField().getText()));
                                    frame.setLastCommand(panelOperationKey[i]);
                                    frame.setStart(true);
                                }else{
                                    frame.getTextField().setText("0");
                                }
                            }
                        }
                    }
                }
            }catch (NumberFormatException exception){
                frame.createErrorPanel();
            }
        }
    };

}
