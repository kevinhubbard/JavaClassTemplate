package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClassPanel extends JPanel {
	private JLabel label = new JLabel("Class Name");
	private JTextField input = new JTextField(5);

	public ClassPanel() {
		add(label);
		add(input);
	}

	public void clearFields() {
		input.setText("");
	}

	public String returnClassName() {
		return input.getText();
	}

	public void focus() {
		input.requestFocus();
	}
}