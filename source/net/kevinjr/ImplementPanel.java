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


public class ImplementPanel extends JPanel {
	private JCheckBox box = new JCheckBox("Implements:");
	private JTextField input = new JTextField(8);
	private JButton btn = new JButton("Add");
	private JButton rmv = new JButton("Remove");
	private ArrayList<String> implementList = new ArrayList<String>();
	private DefaultListModel iListModel = new DefaultListModel();
	private JList jList;
	private JPanel iop = new JPanel();
	private JPanel ilp = new JPanel();

	/**
	* Constructor
	*/
	public ImplementPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(createOptionPanel());
		add(createListPanel());
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
		iListModel.clear();
		implementList.clear();
	}

	public ArrayList<String> getImplementList() {
		for (int i = 0; i < iListModel.size(); i++) {
			implementList.add(iListModel.get(i).toString());
		}
		return implementList;
	}

	private JPanel createOptionPanel() {
		btn.setEnabled(false);
		input.setEnabled(false);
		box.addActionListener(new CheckBoxListener());
		btn.addActionListener(new AddListener());
		iop.add(box);
		iop.add(input);
		iop.add(btn);
		return iop;
	}

	private JPanel createListPanel() {
		rmv.setEnabled(false);
		jList = new JList(iListModel);
		JScrollPane sp = new JScrollPane(jList);
		sp.setPreferredSize(new Dimension(150, 57));
		rmv.addActionListener(new RemoveListener());
		ilp.add(sp);
		ilp.add(rmv);
		return ilp;
	}

	private class AddListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (input.getText() == null || input.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Invalid Implement");
			} else {
				iListModel.addElement(input.getText());
				input.setText("");
				ilp.repaint();
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
			int index = jList.getSelectedIndex();
			String impStr = "Remove " + iListModel.get(index) + " from list?";
			int res = JOptionPane.showConfirmDialog(null, impStr, "Confirm?", JOptionPane.YES_NO_OPTION);
			if (res == 0) {
				iListModel.remove(index);
			}
			ilp.repaint();
		}
	}
}