JButton addButton = new JButton("Hinzufügen");
addButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // do shit
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