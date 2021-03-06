package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
* This program takes user input and creates the framework of a java file.
* 
* @author Kevin H
* @version 1.0.1
* @since 2022-01-16
*/


public class OptionPanel extends JPanel {

	private JCheckBox privBox = new JCheckBox("Private");	
	private JCheckBox mainBox = new JCheckBox("main()");
	private JCheckBox consBox = new JCheckBox("Constructor");	
	private JCheckBox projBox = new JCheckBox("Project Dir");

	public OptionPanel() {
		setPreferredSize(new Dimension(200, 65));
		add(privBox);
		add(mainBox);
		add(consBox);
		add(projBox);
	}

	public void clearFields() {
		privBox.setSelected(false);
		mainBox.setSelected(false);
		consBox.setSelected(false);
		projBox.setSelected(false);
	}

	public boolean returnMain() {
		return mainBox.isSelected();
	}

	public boolean returnPriv() {
		return privBox.isSelected();
	}

	public boolean returnCons() {
		return consBox.isSelected();
	}

	public boolean returnDir() {
		return projBox.isSelected();
	}	

}