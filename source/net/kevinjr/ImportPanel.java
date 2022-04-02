package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
* This program takes user input and creates the framework of a java file.
* 
* @author Kevin H
* @version 1.0.1
* @since 2022-01-16
*/

public class ImportPanel extends JPanel {

	private ArrayList<String> iList = new ArrayList<String>();
	private DefaultListModel listModel = new DefaultListModel();
	private JList jList;
	private JPanel iop = new JPanel();
	private JPanel ilp = new JPanel();
	private JCheckBox box = new JCheckBox("Imports:");
	private JTextField input = new JTextField(8);
	private JButton btn = new JButton("Add");
	private JButton rmv = new JButton("Remove");

	/**
	* PanelConstructor 
	*/
	public ImportPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(createOptionPanel());
		add(createListPanel());
	}

	private JPanel createOptionPanel() {
		btn.setEnabled(false);
		input.setEnabled(false);
		box.addActionListener(new CheckBoxListener());
		btn.addActionListener(new UpdateListener());
		iop.add(box);
		iop.add(input);
		iop.add(btn);
		return iop;
	}

	private JPanel createListPanel() {
		rmv.setEnabled(false);
		jList = new JList(listModel);
		JScrollPane sp = new JScrollPane(jList);
		sp.setPreferredSize(new Dimension(150,57));
		rmv.addActionListener(new RemoveListener());
		ilp.add(sp);
		ilp.add(rmv);
		return ilp;
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
		listModel.clear();
		ilp.repaint();
	}

	public ArrayList<String> getImportList() {
		for (int i = 0; i < listModel.getSize(); i++) {
			iList.add(listModel.get(i).toString());
		}
		return iList;
	}

	private class UpdateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (input.getText().equals("") || input.getText() == null) {
				JOptionPane.showMessageDialog(null, "Invalid Import.");
			} else {
				listModel.addElement(input.getText());
				input.setText("");
			}
		}
	}

	private class CheckBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (box.isSelected()) {
				input.setEnabled(true);
				btn.setEnabled(true);
				rmv.setEnabled(true);
			} else {
				input.setEnabled(false);
				btn.setEnabled(false);
				rmv.setEnabled(false);
			}
		}
	}

	private class RemoveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int rmvSel = jList.getSelectedIndex();
			String item = listModel.get(rmvSel).toString();
			String msg = "Remove \"" + item + "\" from import list?";
			int n = JOptionPane.showConfirmDialog(null, msg, "Confirm?", JOptionPane.YES_NO_OPTION);
			if (n == 0) {
				listModel.removeElementAt(rmvSel);
				ilp.repaint();
			}
		}
	}
}