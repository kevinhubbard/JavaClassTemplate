import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Gui {
	JFrame frame = new JFrame("Create a Class");
	JPanel panel = new JPanel();
	
	JCheckBox mainCb = new JCheckBox("Is main() class?");
	JCheckBox importCb = new JCheckBox("Imports?");
	JCheckBox extendCb = new JCheckBox("Extends?");
	JCheckBox implementCb = new JCheckBox("Implements?");

	JTextField classNameTf = new JTextField(10);
	JTextField importTf = new JTextField(10);
	JTextField extendTf = new JTextField(10);
	JTextField implementTf = new JTextField(10);

	JLabel classLbl = new JLabel("Class Name:");
	JButton create = new JButton("Create");
	String importString;
	String extendString;
	String implementString;

	public Gui() {
		panel.setBackground(Color.GRAY);

		panel.add(classLbl);
		panel.add(classNameTf);
		panel.add(mainCb);
		panel.add(importCb);
		panel.add(importTf);
		panel.add(extendCb);
		panel.add(extendTf);
		panel.add(implementCb);
		panel.add(implementTf);
		panel.add(create);

		importTf.setEnabled(false);
		extendTf.setEnabled(false);
		implementTf.setEnabled(false);

		importCb.addActionListener(new ImportsListener());
		extendCb.addActionListener(new ExtendsListener());
		implementCb.addActionListener(new ImplementsListener());
		create.addActionListener(new SubmitListener());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350, 200);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setVisible(true);
	}

	public class SubmitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String className = classNameTf.getText();
			boolean mainClass = mainCb.isSelected();

			if (importCb.isSelected()) {
				importString = importTf.getText();
			}
			if (extendCb.isSelected()) {
				extendString = extendTf.getText();
			}
			if (implementCb.isSelected()) {
				implementString = implementTf.getText();
			}
			ClassConstructor testClass = new ClassConstructor(className, mainClass);
			//System.out.println("class name was: " + className + "\nisMain() = " + mainClass + "\nimports: " + importString + "\nextends: " + extendString + "\nimplements: " + implementString);
		}
	}

	public class ImportsListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (importCb.isSelected()) {
				importTf.setEnabled(true);
			} else {
				importTf.setEnabled(false);
			}
		}
	}

	public class ExtendsListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (extendCb.isSelected()) {
				extendTf.setEnabled(true);
			} else {
				extendTf.setEnabled(false);
			}
		}
	}

	public class ImplementsListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (implementCb.isSelected()) {
				implementTf.setEnabled(true);
			} else {
				implementTf.setEnabled(false);
			}
		}
	}
}