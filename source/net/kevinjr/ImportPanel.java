package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ImportPanel extends JPanel {

	private ArrayList<String> iList = new ArrayList<String>();
	private DefaultListModel listModel = new DefaultListModel();
	private JList jList;

	private JPanel iop = new JPanel();
	private JPanel ilp = new JPanel();


	private JCheckBox box = new JCheckBox("Imports");
	private JLabel label = new JLabel("Name: ");
	private JTextField input = new JTextField(5);
	private JButton btn = new JButton("Add");
	private JButton rmv = new JButton("Remove");

	private JPanel createOptionPanel() {
		btn.setEnabled(false);
		input.setEnabled(false);
		box.addActionListener(new CheckBoxListener());
		btn.addActionListener(new UpdateListener());
		iop.add(box);
		iop.add(label);
		iop.add(input);
		iop.add(btn);
		return iop;
	}

	private JPanel createListPanel() {
		jList = new JList(listModel);
		JScrollPane sp = new JScrollPane(jList);
		sp.setPreferredSize(new Dimension(150,50));
		rmv.addActionListener(new RemoveListener());
		ilp.add(sp);
		ilp.add(rmv);
		return ilp;
	}


	/**
	* PanelConstructor 
	*/
	public ImportPanel() {
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
		iList.clear();
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
				//iList.add(input.getText());
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
			} else {
				input.setEnabled(false);
				btn.setEnabled(false);
			}
		}
	}

	private class RemoveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int rmvSel = jList.getSelectedIndex();
			String tem = listModel.get(rmvSel).toString();
			String t = "Remove \"" + tem + "\" from import list?";
			int n = JOptionPane.showConfirmDialog(null, t, "Confirm?", JOptionPane.YES_NO_OPTION);
			if (n == 0) {
				//System.out.println("Removing " + rmvSel);
				listModel.removeElementAt(rmvSel);
				ilp.repaint();
			} else {
				System.out.println("aborted.");
			}
		}
	}
}