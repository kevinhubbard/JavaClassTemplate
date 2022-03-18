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

	
	//private JPanel listPanel = new JPanel();
	private DefaultListModel listModel = new DefaultListModel();
	private ListPanel lp = new ListPanel();
	private JList jList;

	/**
	* PanelConstructor 
	*/
	public ImportPanel() {
		setPreferredSize(new Dimension(300,100));
		btn.setEnabled(false);
		input.setEnabled(false);
		box.addActionListener(new CheckBoxListener());
		btn.addActionListener(new UpdateListener());
		add(box);
		add(label);
		add(input);
		add(btn);
		add(lp);
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

	private class ListPanel extends JPanel {
		public ListPanel() {
			setSize(250,100);
			jList = new JList(listModel);
			jList.setFixedCellWidth(25);
			add(jList);
		}
	}

	private class UpdateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if (input.getText().equals("") || input.getText() == null) {
				JOptionPane.showMessageDialog(null, "Invalid Import.");
			} else {
				iList.add(input.getText());
				listModel.addElement(input.getText());
				input.setText("");
				lp.repaint();
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