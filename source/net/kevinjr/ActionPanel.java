package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class ActionPanel extends JPanel {

	private JButton clearBtn = new JButton("Clear");
	private JButton saveBtn = new JButton("Save");

	private ClassPanel cp = new ClassPanel();
	private PackagePanel pp = new PackagePanel();
	private ImportPanel ip = new ImportPanel();
	private ExtendPanel ep = new ExtendPanel();
	private ImplementPanel mp = new ImplementPanel();
	private OptionPanel op = new OptionPanel();
	private ClassConstructor cc = new ClassConstructor();

	public ActionPanel() {
		setPreferredSize(new Dimension(250, 40));
		clearBtn.addActionListener(new ClearListener());
		saveBtn.addActionListener(new SaveListener());
		add(clearBtn);
		add(saveBtn);
	}

	private class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cp.clearFields();
			pp.clearFields();
			ip.clearFields();
			ep.clearFields();
			mp.clearFields();
			op.clearFields();
		}
	}

	private class SaveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String test = cp.returnClassName();
			if (cc.validName(test) == false) {
				JOptionPane.showMessageDialog(null, "Invalid name");
				cp.clearFields();
				cp.focus();
			} else {
				JFileChooser file = new JFileChooser();
				file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				int returnVal = file.showSaveDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File saveLoc = file.getSelectedFile();
					String locationString = saveLoc.getAbsolutePath();
					cc.setSaveLocation(locationString);
					cc.setupBools(op.returnMain(), op.returnPriv(), op.returnCons(), op.returnDir());
					cc.createFile();

					//CLEAR USER INPUT
					cp.clearFields();
					pp.clearFields();
					ip.clearFields();
					ep.clearFields();
					mp.clearFields();
					op.clearFields();

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