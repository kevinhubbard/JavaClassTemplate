import java.awt.*;
import javax.swing.*;

public class Gui {
	public Gui() {
		JFrame frame = new JFrame("Create a Class");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 500);
		JLabel lbl = new JLabel("Create a Class");
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.add(lbl);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setVisible(true);
	}
}