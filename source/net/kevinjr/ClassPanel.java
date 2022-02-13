package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClassPanel extends JPanel {
	private JLabel label = new JLabel("Class Name");
	private static JTextField input = new JTextField(5);

	public ClassPanel() {
		add(label);
		add(input);
	}

	public static void clearFields() {
		input.setText("");
	}

	public static String returnClassName() {
		return input.getText();
	}

	public static void focus() {
		input.requestFocus();
	}
}