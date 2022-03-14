package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ImportPanel extends JPanel {
	private JCheckBox box = new JCheckBox("Imports");
	private JLabel label = new JLabel("Name: ");
	private JTextField input = new JTextField(5);
	private JButton btn = new JButton("Add");
	private ArrayList<String> iList = new ArrayList<String>();

	/**
	* PanelConstructor 
	*/
	public ImportPanel() {
		btn.setEnabled(false);
		input.setEnabled(false);
		box.addActionListener(new CheckBoxListener());
		btn.addActionListener(new UpdateListener());
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
		iList.clear();
	}

	public ArrayList<String> getImportList() {
		return iList;
	}

	private class UpdateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if (input.getText().equals("") || input.getText() == null) {
				JOptionPane.showMessageDialog(null, "Invalid Import.");
			} else {
				iList.add(input.getText());
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