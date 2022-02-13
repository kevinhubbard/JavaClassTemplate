package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExtendPanel extends JPanel {
	private static JCheckBox box = new JCheckBox("Extends");
	private JLabel label = new JLabel("Name: ");
	private static JTextField input = new JTextField(5);
	private static JButton btn = new JButton("Update");
	private ClassConstructor cc = new ClassConstructor();

	public ExtendPanel() {
		btn.setEnabled(false);
		input.setEnabled(false);
		btn.addActionListener(new UpdateListener());
		box.addActionListener(new CheckBoxListener());
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

	private class UpdateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String testExtend = input.getText();
			//~~~VALIDATE INPUT~~~~//
			if (cc.validExtend(testExtend) == false ) {
				JOptionPane.showMessageDialog(null, "Invalid Extend name.");
				input.setText("");
				box.setSelected(false);
			} else {
				System.out.println(testExtend + " was valid.");
				//extendString = textFieldPanel.extendTf.getText();
			}
			input.setEnabled(false);
			btn.setEnabled(false);
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