package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PackagePanel extends JPanel {
	private static JCheckBox box = new JCheckBox("Package");
	private JLabel label = new JLabel("Name: ");
	private static JTextField input = new JTextField(5);
	private static JButton btn = new JButton("Update");

	public PackagePanel() {
		btn.setEnabled(false);
		input.setEnabled(false);
		box.addActionListener(new CheckBoxListener());
		btn.addActionListener(new UpdateListener());
		add(box);
		add(label);
		add(input);
		add(btn);
	}

	public static void clearFields() {
		box.setSelected(false);
		input.setText("");
		input.setEnabled(false);
		btn.setEnabled(false);
	}

	private class CheckBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (box.isSelected()) {
				input.setEnabled(true);
				btn.setEnabled(true);
			} else {
				input.setEnabled(false);
				btn.setEnabled(false);
			}
		}
	}

	private class UpdateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println(input.getText());
			System.out.println(box.isSelected());
		}
	}
}