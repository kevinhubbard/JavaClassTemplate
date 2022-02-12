package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TemImportPanel extends JPanel {
	private JCheckBox box = new JCheckBox("Imports");
	private JLabel label = new JLabel("Name: ");
	private JTextField input = new JTextField(5);
	private JButton btn = new JButton("Update");

	public TemImportPanel() {
		btn.addActionListener(new UpdateListener());
		add(box);
		add(label);
		add(input);
		add(btn);
	}

	private class UpdateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("good stuff");
		}
	}
}