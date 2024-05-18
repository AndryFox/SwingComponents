package swingspersonalized;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingComponents extends JFrame {
    
    private final JTextField textField;
    private final TextAreaPanel textAreaPanel;
    private final JButton removeButton;

    public SwingComponents() {
        
        setTitle("Microsoft");
        setSize(400, 300);
        
        setLayout(new GridLayout(2, 1));
        
        // Creazione del campo per l'inserimento del nome
        textField = new JTextField();
        textField.setText("");
        add(textField);
        
        // Creazione del bottone "Inserisci"
        removeButton = new JButton("Rimuovi");
        removeButton.setFocusable(false);                               // Imposta il pulsante come non focusabile
        removeButton.addActionListener(new SwingComponents.RemoveListener());
        add(removeButton);

        // Creazione del pannello per l'area di testo dei saluti
        textAreaPanel = new TextAreaPanel();
        add(textAreaPanel, BorderLayout.WEST);
        
        // Creazione del pannello per i bottoni
        SwingToolbar buttonPanel = new SwingToolbar(textField, textAreaPanel);
        add(buttonPanel, BorderLayout.EAST);
        
        setLocationRelativeTo(null);                                          // Centra la finestra sullo schermo
        setResizable(true);                                             // Impedisce il ridimensionamento della finestra
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    // Listener per il bottone "Inserisci"
    private class RemoveListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            // Cancella il contenuto della JTextField
            textField.setText("");
            
        }
    }
    
}
