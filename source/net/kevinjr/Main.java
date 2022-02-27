package net.kevinjr;

import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {

	public void createFrame() {
		setTitle("Create A Class");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(330, 475);
		setResizable(false);
		getContentPane().add(BorderLayout.CENTER, new Gui());
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((dim.width/2)-(getWidth()/2), (dim.height/2)-(getHeight()/2));
		setVisible(true);	
	}
	
	public static void main(String[] args) {
		new Main().createFrame();
	}
}