package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
* This class is the class name panel. It has a constructor and 3 public
* methods.
* 
* @author Kevin H
* @version 1.0.1
* @since 2022-01-16
*/

public class ClassPanel extends JPanel {
	private JLabel label = new JLabel("Class Name");
	private JTextField input = new JTextField(5);

	/**
	* Class constructor adds label and textfield to panel. 
	*/
	public ClassPanel() {
		add(label);
		add(input);
	}

	/**
	* The clearFields method sets this panel text input to an empty string.
	*/
	public void clearFields() {
		input.setText("");
	}

	/**
	* The returnClassName is a getter method which returns a string 
	* of the currently entered class name.
	*/
	public String returnClassName() {
		return input.getText();
	}

	/**
	* The focus method sets the mouse cursor to the current text input box.
	*/ 
	public void focus() {
		input.requestFocus();
	}
}