package swingspersonalized;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingToolbar extends JPanel {
    
    private final JButton bottoneGiorno;
    private final JButton bottoneNotte;
    private final JTextField textField;
    private final TextAreaPanel textAreaPanel;

    public SwingToolbar(JTextField textField, TextAreaPanel textAreaPanel) {
        
        this.textField = textField;
        this.textAreaPanel = textAreaPanel;

        setLayout(new GridLayout(2, 1));

        // Creazione dei bottoni
        bottoneGiorno = new JButton("Bottone Buongiorno");                  // Bottone del buongiorno
        bottoneGiorno.setFocusable(false);                              // Imposta il pulsante come non focusabile
        bottoneNotte = new JButton("Bottone Buonanotte");                   // Bottone della buonanotte
        bottoneNotte.setFocusable(false);                               // Imposta il pulsante come non focusabile

        // Aggiunta degli ActionCommand per distinguere i bottoni
        bottoneGiorno.setActionCommand("giorno");
        bottoneNotte.setActionCommand("notte");
        
        // Aggiunta dei listener ai bottoni
        bottoneGiorno.addActionListener(new SalutaListener());
        bottoneNotte.addActionListener(new SalutaListener());

        // Aggiunta dei bottoni al pannello
        add(bottoneGiorno);
        add(bottoneNotte);
    }
    
    // Listener per i bottoni
    private class SalutaListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            String nome = textField.getText();
            // Controlla se il campo di testo è vuoto
            if (nome.length() < 2) {
                return; // Esce dal metodo senza eseguire ulteriori azioni
            }
            
            String saluto = "";

            // Determina il tipo di saluto in base al comando dell'azione
            if ("giorno".equals(e.getActionCommand())) {
                saluto = ("Buongiorno tesorino " + nome + "! " + "Svegliato bene?\n");
            } else if ("notte".equals(e.getActionCommand())) {
                saluto = ("Buonanotte " + nome + "! " + "Fai bei sogni!\n");
            }
            // Aggiunge il saluto all'area di testo
            textAreaPanel.appendText(saluto);
            
        }
    }
}
