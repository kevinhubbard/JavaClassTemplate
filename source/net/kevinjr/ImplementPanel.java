package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ImplementPanel extends JPanel {
	private JCheckBox box = new JCheckBox("Implements");
	private JLabel label = new JLabel("Name: ");
	private JTextField input = new JTextField(5);
	private JButton btn = new JButton("Update");
	private ClassConstructor cc = new ClassConstructor();

	public ImplementPanel() {
		btn.setEnabled(false);
		input.setEnabled(false);
		box.addActionListener(new CheckBoxListener());
		btn.addActionListener(new UpdateListener());
		add(box);
		add(label);
		add(input);
		add(btn);
	}

	public void clearFields() {
		box.setSelected(false);
		input.setText("");
		input.setEnabled(false);
		btn.setEnabled(false);
	}

	private class UpdateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String testImplement = input.getText();
			//~~~VALIDATE INPUT~~~~//
			if (cc.validImplement(testImplement) == false) {
				JOptionPane.showMessageDialog(null, "Invalid Implement name.");
				input.setText("");
				input.requestFocus();
			} else {
				System.out.println(testImplement + " was valid.");
				input.setText("");
				input.requestFocus();
			}
		}
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
}