package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TemImplementPanel extends JPanel {
	private JCheckBox box = new JCheckBox("Implements");
	private JLabel label = new JLabel("Name: ");
	private JTextField input = new JTextField(5);
	private JButton btn = new JButton("Update");

	public TemImplementPanel() {
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