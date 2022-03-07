package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExtendPanel extends JPanel {
	private JCheckBox box = new JCheckBox("Extends");
	private JLabel label = new JLabel("Name: ");
	private JTextField input = new JTextField(10);

	public ExtendPanel() {
		input.setEnabled(false);
		box.addActionListener(new CheckBoxListener());
		add(box);
		add(label);
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