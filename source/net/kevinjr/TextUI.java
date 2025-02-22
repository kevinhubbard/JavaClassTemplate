package net.kevinjr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class TextUI extends JPanel {
	//private TextPanel tp = new TextPanel();

	private String text;

	public TextUI() {
		JTextArea tex = new JTextArea(50, 30);
		tex.setText(text);
			setPreferredSize(new Dimension(500, 400));
			add(tex);
	}

	public TextUI(String s) {
		JTextArea tex = new JTextArea(50, 30);
		tex.setText(s);
			setPreferredSize(new Dimension(500, 400));
			add(tex);
	}

	public void setContent(String t) {
		this.text = t;
	}
}