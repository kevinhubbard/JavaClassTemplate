/**
* This class takes all the subpanel objects and adds them to the main panel. 
* 
* @author Kevin H
* @version 1.0.2
* @since 2022-02-22
*/

package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class TextUI extends JPanel {

	private String text;
	private JTextArea tex = new JTextArea(23,50);

	public TextUI() {
		setPreferredSize(new Dimension(700, 400));
		JScrollPane scroll = new JScrollPane(tex, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scroll);
	}

	public TextUI(String s) {
		tex.setText(s);
		setPreferredSize(new Dimension(700, 400));
		JScrollPane scroll = new JScrollPane(tex, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scroll);
	}

	public void setContent(String t) {
		this.text = t;
	}

	public String getTextContent() {
		return tex.getText();
	}
}