package net.kevinjr;

import javax.swing.*;
import java.awt.event.*;

public class OptionMenu extends JMenuBar {

	public OptionMenu() {
		JMenu fMenu = new JMenu("File");
		JMenu hMenu = new JMenu("Help");
		JMenuItem jmi = new JMenuItem("Exit");
		JMenuItem jmh = new JMenuItem("Help");
		JMenuItem jma = new JMenuItem("About");

		jmi.addActionListener(new ExitListener());
		fMenu.add(jmi);
		hMenu.add(jmh);
		hMenu.add(jma);
		add(fMenu);
		add(hMenu);
	}

	private class ExitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}

		
		