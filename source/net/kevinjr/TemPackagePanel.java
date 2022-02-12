package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TemPackagePanel extends JPanel {
	private JCheckBox box = new JCheckBox("Package");
	private JLabel label = new JLabel("Name: ");
	private JTextField input = new JTextField(5);
	private JButton btn = new JButton("Update");

	public TemPackagePanel() {
		btn.addActionListener(new UpdateListener());
		add(box);
		add(label);
		add(input);
		add(btn);
	}

	private class UpdateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println(input.getText());
			System.out.println(box.isSelected());
		}
	}
}