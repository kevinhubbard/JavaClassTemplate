package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TemImportListPanel extends JPanel {
	private ArrayList<String> tList = new ArrayList<String>();
	private JLabel label = new JLabel("Import List");
	private JList list;
	private JButton btn = new JButton("Remove");

	public TemImportListPanel() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		tList.add("Sht");
		tList.add("fck");
		tList.add("lofi");

		list = new JList(tList.toArray());

		btn.addActionListener(new RemoveListener());
		add(label);
		add(list);
		add(btn);
	}

	private class RemoveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Removed.");
		}
	}
}