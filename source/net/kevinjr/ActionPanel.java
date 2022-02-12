package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
			System.out.println("save listener");
		}
	}
}


/*	
	private class SubmitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String testName = classNamePanel.classNameTf.getText();
			if (cc.validName(testName) == false) {
				JOptionPane.showMessageDialog(null, "Invalid Class Name.");
				classNamePanel.classNameTf.setText("");
				classNamePanel.classNameTf.requestFocus();
			} else {
				JFileChooser f = new JFileChooser();
				f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				f.setCurrentDirectory(new File(System.getProperty("user.home")));
				int returnVal = f.showSaveDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					System.out.println("Save approved.");
					File saveLoc = f.getSelectedFile();
					String locationString = saveLoc.getAbsolutePath();
					cc.setSaveLocation(locationString);
					cc.isMainClass(checkBoxPanel.mainCb.isSelected());
					cc.createFile();
					clearScreen();
					//ASK USER IF THEY WANT TO CREATE ANOTHER CLASS OR EXIT
					int option = JOptionPane.showConfirmDialog(null, "File successfully created!\nAdd another file?", "Create a Class", JOptionPane.YES_NO_OPTION);
					if (option != 0) {
						System.exit(0);
					}
				} else {
					System.out.println("Save selection canceled.");
				}	
			}
		}
	}*/