package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

/**
* This class takes all the subpanel objects and adds them to the main panel. 
* 
* @author Kevin H
* @version 1.0.1
* @since 2022-01-16
*/

public class Gui extends JPanel {

	private ClassPanel classPanel = new ClassPanel();
	private PackagePanel packPanel = new PackagePanel();
	private ImportPanel importPanel = new ImportPanel();
	private ExtendPanel extendPanel = new ExtendPanel();
	private ImplementPanel implementPanel = new ImplementPanel();
	private ImportListPanel importListPanel = new ImportListPanel();
	private OptionPanel optionPanel = new OptionPanel();
	private JPanel actionPanel = new JPanel();
	private ClassConstructor cc = new ClassConstructor();

	private JButton savebtn = new JButton("Save");
	private JButton clearbtn = new JButton("Clear");

	/**
	* No arg constructor that adds all panels together.
	*/
	public Gui() {
		actionPanel.setPreferredSize(new Dimension(250, 40));
		actionPanel.add(clearbtn);
		actionPanel.add(savebtn);
		savebtn.addActionListener(new SaveListener());
		clearbtn.addActionListener(new ClearListener());

		add(classPanel);
		add(packPanel);
		add(importPanel);
		add(extendPanel);
		add(implementPanel);
		add(importListPanel);
		add(optionPanel);
		add(actionPanel);
		setBackground(Color.GRAY);
	}

	/**
	* ClearListener is a private action listener which calls the
	* clearFields method of each class to remove all user input.
	*/
	private class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			classPanel.clearFields();
			packPanel.clearFields();
			importPanel.clearFields();
			extendPanel.clearFields();
			implementPanel.clearFields();
			optionPanel.clearFields();
		}
	}

	/**
	* SaveListener is a private action listener which saves the user
	* input and creates the requested java file. It first checks that 
	* the class name input is valid. If it is, it lets the user select
	* which directory they would like to save to save the file to. 
	* It clears the input fields if input is successfully saved and asks
	* user if they would like to create another file.
	*/
	private class SaveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (packPanel.isSelected() == true) {
				cc.validatePackage(packPanel.getPackageName());
			}

			if (importPanel.isSelected() == true) {
				cc.setImportString(importPanel.getImportList());
			}

			if (extendPanel.isSelected() == true) {
				cc.validateExtend(extendPanel.getExtendName());
			}

			if (implementPanel.isSelected() == true) {
				cc.setImplementString(implementPanel.getImplementList());
			}

			// VALIDATE CLASS NAME INPUT
			if (cc.validateName(classPanel.getClassName()) == false) {
				JOptionPane.showMessageDialog(null, "Invalid Class Name");
				classPanel.clearFields();
				classPanel.focus();
			} else {
				// CHOOSE DIRECTORY LOCATION UPON SUCCESSFUL VALIDATION
				JFileChooser file = new JFileChooser();
				file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				int returnVal = file.showSaveDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File saveLoc = file.getSelectedFile();
					String locationString = saveLoc.getAbsolutePath();
					cc.setSaveLocation(locationString);

					if (cc.checkFile() == false) {
						cc.setupBools(optionPanel.returnMain(), optionPanel.returnPriv(), optionPanel.returnCons(), optionPanel.returnDir());
						cc.createFile();
						// ASK USER IF THEY WANT TO ADD ANOTHER CLASS OR QUIT
						int option = JOptionPane.showConfirmDialog(null, "File successfully created!\nAdd another class?", "Create a Class", JOptionPane.YES_NO_OPTION);
						if (option != 0) {
							System.exit(0);
						}

					} else {
						int exts = JOptionPane.showConfirmDialog(null, "File already exists.\nOverwrite?", "Overwrite", JOptionPane.YES_NO_OPTION);
						if (exts == 0) {
							cc.setupBools(optionPanel.returnMain(), optionPanel.returnPriv(), optionPanel.returnCons(), optionPanel.returnDir());
							cc.createFile();
							// ASK USER IF THEY WANT TO ADD ANOTHER CLASS OR QUIT
						int option = JOptionPane.showConfirmDialog(null, "File successfully created!\nAdd another class?", "Create a Class", JOptionPane.YES_NO_OPTION);
						if (option != 0) {
							System.exit(0);
						}

						} else {
							JOptionPane.showMessageDialog(null, "Save aborted.");
						}
					}



					// CLEAR USER INPUT
					classPanel.clearFields();
					packPanel.clearFields();
					importPanel.clearFields();
					extendPanel.clearFields();
					implementPanel.clearFields();
					optionPanel.clearFields();

				} else {
					System.out.println("Save canceled.");
				}
			}
		}
	}
}