package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class ActionPanel extends JPanel {

	private JButton clearBtn = new JButton("Clear");
	private JButton saveBtn = new JButton("Save");

	public ActionPanel() {
		setPreferredSize(new Dimension(250, 40));
		clearBtn.addActionListener(new ClearListener());
		saveBtn.addActionListener(new SaveListener());
		add(clearBtn);
		add(saveBtn);
	}

	private class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ClassPanel.clearFields();
			PackagePanel.clearFields();
			ImportPanel.clearFields();
			ExtendPanel.clearFields();
			ImplementPanel.clearFields();
			OptionPanel.clearFields();
		}
	}

	private class SaveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String test = ClassPanel.returnClassName();
			if (ClassConstructor.validName(test) == false) {
				JOptionPane.showMessageDialog(null, "Invalid name");
				ClassPanel.clearFields();
				ClassPanel.focus();
			} else {
				JFileChooser file = new JFileChooser();
				file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				int returnVal = file.showSaveDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File saveLoc = file.getSelectedFile();
					String locationString = saveLoc.getAbsolutePath();
					ClassConstructor.setSaveLocation(locationString);
					ClassConstructor.setupBools(OptionPanel.returnMain(), OptionPanel.returnPriv(), OptionPanel.returnCons(), OptionPanel.returnDir());
					ClassConstructor.createFile();

					//CLEAR USER INPUT
					ClassPanel.clearFields();
					PackagePanel.clearFields();
					ImportPanel.clearFields();
					ExtendPanel.clearFields();
					ImplementPanel.clearFields();
					OptionPanel.clearFields();

					//ASK USER IF THEY WANT TO ADD ANOTHER CLASS OR QUIT
					int option = JOptionPane.showConfirmDialog(null, "File successfully created!\nAdd another class?", "Create a Class", JOptionPane.YES_NO_OPTION);
					if (option != 0) {
						System.exit(0);
					}
				} else {
					System.out.println("Save canceled.");
				}
			}
		}
	}
}