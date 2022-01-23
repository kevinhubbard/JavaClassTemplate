import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Gui {
	JFrame frame = new JFrame("Create a Class");
	JPanel panel = new JPanel();

	public Gui() {
		JLabel classLbl = new JLabel("Class Name:");
		JTextField className = new JTextField(10);

		JLabel mainLbl = new JLabel("Is main() class?");
		JCheckBox mainCb = new JCheckBox("Is main() class?");

		JLabel importLbl = new JLabel("Imports?");
		JCheckBox importCb = new JCheckBox("Imports?");
		JTextField importTf = new JTextField(10);

		JLabel extendLbl = new JLabel("Extends?");
		JCheckBox extendsCb = new JCheckBox("Extends?");
		JTextField extendTf = new JTextField(10);

		JLabel implementLbl = new JLabel("Implements?");
		JCheckBox implementCb = new JCheckBox("Implements?");
		JTextField implementTf = new JTextField(10);

		JButton create = new JButton("Create");
		create.addActionListener(new SubmitListener());

		panel.setBackground(Color.GRAY);
		panel.add(classLbl);
		panel.add(className);

		panel.add(mainLbl);
		panel.add(mainCb);

		panel.add(importLbl);
		panel.add(importCb);
		panel.add(importTf);

		panel.add(extendLbl);
		panel.add(extendsCb);
		panel.add(extendTf);

		panel.add(implementLbl);
		panel.add(implementCb);
		panel.add(implementTf);

		panel.add(create);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350, 200);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setVisible(true);
	}

	public class SubmitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("submit was clicked.");
		}
	}
}