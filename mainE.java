import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.*;

import static javax.swing.JOptionPane.showMessageDialog;


public class mainE {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame Frame= new JFrame();
		
		JTextField TextField = new JTextField();

		DefaultListModel internalList = new DefaultListModel<>();
		JList list = new JList();
		list.setModel(internalList);

		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				List<String> selected = list.getSelectedValuesList();
			}
		});

		JButton addButton = new JButton("Hinzu");
		addButton.addActionListener((ActionListener) new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
				String input = TextField.getText();
				if (input.isEmpty()) {
					showMessageDialog(null, "Eingabefeld ist leer, bitte etwas hinein schreiben");
				} else {
					internalList.addElement(input);
					list.setModel(internalList);
					TextField.setText("");
				}
		    }
		});
		
		JButton markButton = new JButton("Erledigt");
		markButton.addActionListener((ActionListener) new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
				int[] indices = list.getSelectedIndices();
				System.out.println(indices);
				List<String> values = list.getSelectedValuesList();
				for (int index : indices) {
					String value = values.get(index);
					internalList.setElementAt("* " + value, index);
				}
		    }
		});
		
		JButton removeButton = new JButton("Liste Löschen");
		removeButton.addActionListener((ActionListener) new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
				internalList.clear();
				list.setModel(internalList);
		    }
		});
		
		TextField.setBounds(10, 10, 380, 20);
		list.setBounds(10, 40, 380, 380);
		addButton.setBounds(290, 430, 100, 25);
		markButton.setBounds(190, 430, 80, 25);
		removeButton.setBounds(10, 430, 120, 25);
		
		Frame.add(TextField);
		Frame.add(list);
		Frame.add(addButton);
		Frame.add(markButton);
		Frame.add(removeButton);
		Frame.setSize(415, 505);
		Frame.setLayout(null);
		Frame.setVisible(true);
		Frame.setResizable(false);
	}

}
