package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ImplementPanel extends JPanel {
	private JCheckBox box = new JCheckBox("Implements");
	private JLabel label = new JLabel("Name: ");
	private JTextField input = new JTextField(5);
	private JButton btn = new JButton("Add");
	private ArrayList<String> implementList = new ArrayList<String>();

	public ImplementPanel() {
		btn.setEnabled(false);
		input.setEnabled(false);
		box.addActionListener(new CheckBoxListener());
		btn.addActionListener(new AddListener());
		add(box);
		add(label);
		add(input);
		add(btn);
	}

	public boolean isSelected() {
		boolean selected = false;

		if (box.isSelected()) {
			selected = true;
		}
		return selected;
	}

	public void clearFields() {
		box.setSelected(false);
		input.setText("");
		input.setEnabled(false);
		btn.setEnabled(false);
		implementList.clear();
	}

	public ArrayList<String> getImplementList() {
		return implementList;
	}

	private class AddListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (input.getText() == null || input.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Invalid Implement");
			} else {
				implementList.add(input.getText());
				input.setText("");
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