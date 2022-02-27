package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ImportListPanel extends JPanel {
	private ArrayList<String> tList = new ArrayList<String>();
	private JLabel label = new JLabel("Import List");
	private JList list;
	private JButton btn = new JButton("Remove");

	public ImportListPanel() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setPreferredSize(new Dimension(250, 100));
		tList.add("a");
		tList.add("b");
		tList.add("c");

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