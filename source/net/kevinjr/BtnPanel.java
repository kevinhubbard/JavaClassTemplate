package net.kevinjr;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BtnPanel extends JPanel {
	JButton importBtn = new JButton("Add");
	JButton extendBtn = new JButton("Add");
	JButton implementBtn = new JButton("Add");

	public BtnPanel() {
		setBorder(BorderFactory.createEmptyBorder(22, 0, 0, 0));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(importBtn);
		add(Box.createRigidArea(new Dimension(0, 2)));
		add(extendBtn);
		add(Box.createRigidArea(new Dimension(0, 2)));
		add(implementBtn);
		setBackground(Color.GRAY);
		importBtn.setEnabled(false);
		extendBtn.setEnabled(false);
		implementBtn.setEnabled(false);
	}
}