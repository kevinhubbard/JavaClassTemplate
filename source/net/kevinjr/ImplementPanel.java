package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ImplementPanel extends JPanel {
	private JCheckBox box = new JCheckBox("Implements");
	private JLabel label = new JLabel("Name: ");
	private JTextField input = new JTextField(5);
	private ArrayList<String> implementList = new ArrayList<String>();

	public ImplementPanel() {
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

	public ArrayList<String> getImplementList() {
		return implementList;
	}

	private class UpdateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (input.getText() == null || input.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Invalid Implement");
			} else {
				implementList.add(input.getText());
			}
		}
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