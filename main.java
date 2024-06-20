import javax.swing.*;
import static javax.swing.JOptionPane.showMessageDialog;

JButton addButton = new JButton("Hinzufügen");
addButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        input = toString(inputField.getText());
        if (input.isEmpty()) {
            showMessageDialog(null, "Eingabefeld ist leer, bitte etwas hinein schreiben");
        } else {
            // add input text to mainframe
        }
    }
})


JButton markButton = new JButton("Erledigt");
markButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // ausgewähltes Feld bekommt ein " *" hinter den vorhandenen text
        // objekt dann flaggen als "done"
    }
})


JButton removeButton = new JButton("Liste löschen");
removeButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // alle Felder werden entfernt
    }
})


public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        input = toString(inputField.getText());
        if (input.isEmpty()) {
            showMessageDialog(null, "Eingabefeld ist leer, bitte etwas hinein schreiben");
        } else {
            // add input text to mainframe
        }
    }

    if (e.getKeyCode() == KeyEvent.VK_DELETE) {
        // do shit, same as "erledigt" buttons
    }
}

public void windowClosing(WindowEvent e) {
    // quasi zweite Swing-Application
    // zwei buttons
    // einer "ja save" -> response = true
    // einer "nein no save" -> response = false

    if (!response) {
        // exit und gut
    } else {
        // save shit, dann exit
    }
}