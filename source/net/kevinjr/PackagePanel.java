package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
* This class creates a panel for package input. It has a constructor,
* 1 public method and 2 inner class private listeners.
* 
* @author Kevin H
* @version 1.0.1
* @since 2022-01-16
*/

public class PackagePanel extends JPanel {
	private JCheckBox box = new JCheckBox("Package");
	private JLabel label = new JLabel("Name: ");
	private JTextField input = new JTextField(10);

	/**
	* No arg constructor that initally sets input to disabled,
	* sets listeners on the inputs and adds them to the panel.
	*/ 
	public PackagePanel() {
		input.setEnabled(false);
		box.addActionListener(new CheckBoxListener());
		add(box);
		add(label);
		add(input);
	}

	public String getPackageName() {
		String ps = "";
		if (box.isSelected()) {
			ps = input.getText();
		} else {
			ps = "";
		}
		return ps;
	}

	/**
	* The clearFields method disables panel input and sets input text
	* to an empty string.
	*/ 
	public void clearFields() {
		box.setSelected(false);
		input.setText("");
		input.setEnabled(false);
	}

	/**
	* The inner CheckBoxListener class is a private class that enables
	* and disables input whether or not the user has selected to add 
	* package input or not.
	*/
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