package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TemActionPanel extends JPanel {
	private JCheckBox box = new JCheckBox("Project Directory");
	private JButton clearBtn = new JButton("Clear");
	private JButton saveBtn = new JButton("Save");

	public TemActionPanel() {
		clearBtn.addActionListener(new ClearListener());
		saveBtn.addActionListener(new SaveListener());
		add(box);
		add(clearBtn);
		add(saveBtn);
	}

	private class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("clear listener");
		}
	}

	private class SaveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("save listener");
		}
	}
}