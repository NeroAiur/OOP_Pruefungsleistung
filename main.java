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
            DefaultListModel tempList = new DefaultListModel();
            tempList.addElement(input);

            toDoList.setModel(tempList);
        }
    }
})


JButton markButton = new JButton("Erledigt");
markButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int index = list.getSelectedIndex();

        DefaultListModel tempList = new DefaultListModel();
        JList toDoList = new JList(tempList);
        content = getElementAt(index);

        tempList.setElementAt("* " + content);
    }
})


JButton removeButton = new JButton("Liste löschen");
removeButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultListModel tempList = new DefaultListModel();
        JList toDoList = new JList(tempList);

        tempList.clear();
    }
})


public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        input = toString(inputField.getText());
        if (input.isEmpty()) {
            showMessageDialog(null, "Eingabefeld ist leer, bitte etwas hinein schreiben");
        } else {
            toDoList.addElement(input);
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