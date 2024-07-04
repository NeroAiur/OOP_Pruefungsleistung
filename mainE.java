import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;

import static javax.swing.JOptionPane.showMessageDialog;


public class mainE {
	

	public static void main(String[] args) {
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

		try {
			File file = new File("saved_list.txt");
			if (file.createNewFile()) {
				System.out.println("File created: " + file.getName());
			} else {
				System.out.println("File already exists");
			}

			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				String data = scanner.nextLine();
				internalList.addElement(data);
			}
			scanner.close();

		} catch(IOException e) {
			System.out.println("An IO Exception occured");
			e.printStackTrace();
		}

		

			Frame.addWindowListener(new java.awt.event.WindowAdapter() {
				@Override
				public void windowClosing(java.awt.event.WindowEvent windowEvent) {
					try {
						FileWriter fileWriter = new FileWriter("saved_list.txt");
						if (JOptionPane.showConfirmDialog(Frame, "Willst du die Liste speichern?",
														"Liste speichern?", JOptionPane.YES_NO_OPTION,
														JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
							String elementTempString = internalList.toString();
							String[] elementArray = elementTempString.split("(\\[|\\]|\\,\\s)");
							for (String element : elementArray) {
								fileWriter.write(element + "\n");
							}
						}
						fileWriter.close();
					} catch(IOException e) {
						System.out.println("An IO Exception occured");
						e.printStackTrace();
					}
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
