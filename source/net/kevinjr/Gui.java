/**
* This class takes all the subpanel objects and adds them to the main panel. 
* 
* @author Kevin H
* @version 1.0.2
* @since 2022-02-22
*/

package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Gui extends JPanel {

	private ClassPanel classPanel = new ClassPanel();
	private PackagePanel packPanel = new PackagePanel();
	private ImportPanel importPanel = new ImportPanel();
	private ExtendPanel extendPanel = new ExtendPanel();
	private ImplementPanel implementPanel = new ImplementPanel();
	private OptionPanel optionPanel = new OptionPanel();
	private JPanel actionPanel = new JPanel();
	private ClassConstructor cc = new ClassConstructor();
	private TextUI tpan = new TextUI();
	private JButton savebtn = new JButton("Save");
	private JButton clearbtn = new JButton("Clear");
	private JButton generatePreviewBtn = new JButton("Generate");

	/**
	* No arg constructor that adds all panels together.
	*/
	public Gui() {
		
		actionPanel.setPreferredSize(new Dimension(250, 40));
		actionPanel.add(clearbtn);
		actionPanel.add(savebtn);
		actionPanel.add(generatePreviewBtn);

		savebtn.addActionListener(new SaveListener());
		clearbtn.addActionListener(new ClearListener());
		generatePreviewBtn.addActionListener(new GenerateListener());
		
		add(classPanel);
		add(packPanel);
		add(importPanel);
		add(extendPanel);
		add(implementPanel);
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
		private void save() {
			cc.createFile(tpan.getTextContent());
		}

		public void actionPerformed(ActionEvent e) {
			// CHOOSE DIRECTORY LOCATION UPON SUCCESSFUL VALIDATION
			JFileChooser file = new JFileChooser();
			file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			file.setCurrentDirectory(new File(System.getProperty("user.home")));
			int returnVal = file.showSaveDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File saveLoc = file.getSelectedFile();
				String locationString = saveLoc.getAbsolutePath();
				cc.setSaveLocation(locationString);

				if (!cc.fileExists()) {
					save();
				} else {
					int overwriteOption = JOptionPane.showConfirmDialog(null, "File already exists.\nOverwrite?", "Overwrite", JOptionPane.YES_NO_OPTION);
					if (overwriteOption == 0) {
						save();
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
			}
		}
	}
	private class GenerateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cc.setClassName(classPanel.getClassName());
			if (packPanel.isSelected() == true) {
				cc.validatePackage(packPanel.getPackageName());
			} else {
				cc.validatePackage("");
			}

			if (importPanel.isSelected() == true) {
				cc.setImportString(importPanel.getImportList());
			}
	 
			if (extendPanel.isSelected() == true) {
				cc.validateExtend(extendPanel.getExtendName());
			} else {
				cc.validateExtend("");
			}

			if (implementPanel.isSelected() == true) {
				cc.setImplementString(implementPanel.getImplementList());
			}

			cc.setupBools(optionPanel.returnMain(), optionPanel.returnPriv(), optionPanel.returnCons(), optionPanel.returnDir());
			
			String strOfData = cc.generateTempFile();
			remove(tpan);
			tpan = 	new TextUI(strOfData);
			add(tpan);
			revalidate();
			repaint();		
		}
	}
}