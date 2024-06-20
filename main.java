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
        // do shit
    }
})


JButton removeButton = new JButton("Liste löschen");
removeButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // do shit
    }
})


public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        // do shit, same shit as "hinzufügen" button
    }

    if (e.getKeyCode() == KeyEvent.VK_DELETE) {
        // do shit, same as "erledigt" buttons
    }
}