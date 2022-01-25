import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class NamePanel extends JPanel {
	JTextField classNameTf = new JTextField(10);
	
	public NamePanel() {
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JLabel classLbl = new JLabel("Class Name:");
		
		add(classLbl);
		add(classNameTf);
	}
}