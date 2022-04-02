package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
* This program takes user input and creates the framework of a java file.
* 
* @author Kevin H
* @version 1.0.1
* @since 2022-01-16
*/

public class ExtendPanel extends JPanel {
	private JCheckBox box = new JCheckBox("Extends:");
	//private JLabel label = new JLabel("Name: ");
	private JTextField input = new JTextField(10);

	public ExtendPanel() {
		input.setEnabled(false);
		box.addActionListener(new CheckBoxListener());
		add(box);
		//add(label);
		add(input);
	}

	public void clearFields() {
		box.setSelected(false);
		input.setText("");
		input.setEnabled(false);
	}

	public String getExtendName() {
		String returnString;
		
		if (box.isSelected() == true) {
			returnString = input.getText();
		} else {
			returnString = "";
		}
		
		return returnString;
	}

	public boolean isSelected() {
		boolean selected = false;

		if (box.isSelected()) {
			selected = true;
		}
		return selected;
	}


	/**
	* The focus method sets the mouse cursor to the current text input box.
	*/ 
	public void focus() {
		input.requestFocus();
	}

	private class CheckBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (box.isSelected()) {
				input.setEnabled(true);
			} else {
				input.setEnabled(false);
			}
		}
	}
}