package net.kevinjr;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CbPanel extends JPanel {
	JCheckBox mainCb = new JCheckBox("Is main() class?");
	JCheckBox importCb = new JCheckBox("Imports?");
	JCheckBox extendCb = new JCheckBox("Extends?");
	JCheckBox implementCb = new JCheckBox("Implements?");

	public CbPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(mainCb);
		add(importCb);
		add(extendCb);
		add(implementCb);
	}
}