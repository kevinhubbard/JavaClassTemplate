package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ImportPanel extends JPanel {

	private ArrayList<String> iList = new ArrayList<String>();
	private DefaultListModel listModel = new DefaultListModel();
	private JList jList;

	private InputPanel ip = new InputPanel();
	private ListPanel lp = new ListPanel();

	/**
	* PanelConstructor 
	*/
	public ImportPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(ip);
		add(lp);
	}



	public ArrayList<String> getImportList() {
		return iList;
	}




	public class InputPanel extends JPanel {
		private JCheckBox box = new JCheckBox("Imports");
		private JLabel label = new JLabel("Name: ");
		private JTextField input = new JTextField(5);
		private JButton btn = new JButton("Add");


		public InputPanel() {
			
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

	private class ListPanel extends JPanel {
		private JButton removeBtn = new JButton("Remove");
		private Color c = new Color(98,69,42);
		private JPanel shit = new JPanel();

		public ListPanel() {

			//setBackground(c);
			shit.setPreferredSize(new Dimension(250,75));
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			jList = new JList(listModel);
			removeBtn.addActionListener(new RemoveListener());
			JScrollPane sp = new JScrollPane(jList);
			//sp.setPreferredSize(new Dimension(250,75));
			//jList.setFixedCellWidth(20);

			shit.add(sp);
			add(shit);
			add(Box.createRigidArea(new Dimension(10,10)));
			add(removeBtn);
		}

		private class RemoveListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Something happened");
			}
		}
	}
}