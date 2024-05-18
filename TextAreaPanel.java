package swingspersonalized;

import javax.swing.*;
import java.awt.*;

public class TextAreaPanel extends JPanel {
    
    private JTextArea textArea;

    public TextAreaPanel() {
        
        setLayout(new BorderLayout());

        // Creazione dell'area di testo per i saluti
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFocusable(false);                                     // Imposta il pulsante come non focusabile


        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void appendText(String text){
        textArea.append(text);
    }
    
    public void setText(String text){
        textArea.setText(text);
    }
}
