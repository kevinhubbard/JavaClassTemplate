package net.kevinjr;

import java.awt.*;
import javax.swing.*;

/**
* This program takes user input and creates the framework of a java file.
* 
* @author Kevin H
* @version 1.0.1
* @since 2022-01-16
*/

public class Main extends JFrame {
	/**
	* This method creates a new JFrame and gives it some default settings.
	*/

	public void createFrame() {
		setTitle("Create A Class");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(330, 510);
		setResizable(false);
		setJMenuBar(new OptionMenu());
		getContentPane().add(BorderLayout.CENTER, new Gui());
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((dim.width/2)-(getWidth()/2), (dim.height/2)-(getHeight()/2));
		setVisible(true);	
	}
	
	public static void main(String[] args) {
		new Main().createFrame();
	}
}