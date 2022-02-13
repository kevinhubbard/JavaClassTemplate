package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OptionPanel extends JPanel {

	private static JCheckBox privBox = new JCheckBox("Private");	
	private static JCheckBox mainBox = new JCheckBox("main()");
	private static JCheckBox consBox = new JCheckBox("Constructor");	
	private static JCheckBox projBox = new JCheckBox("Project Dir");

	public OptionPanel() {
		setPreferredSize(new Dimension(200, 65));
		add(privBox);
		add(mainBox);
		add(consBox);
		add(projBox);
	}

	public static void clearFields() {
		privBox.setSelected(false);
		mainBox.setSelected(false);
		consBox.setSelected(false);
		projBox.setSelected(false);
	}

	public static boolean returnMain() {
		return mainBox.isSelected();
	}
}