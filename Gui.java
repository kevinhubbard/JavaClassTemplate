import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Gui {
	String className, importString, extendString, implementString;
	boolean mainClass;
	JFrame frame = new JFrame("Create a Class");
	JPanel panel = new JPanel();
	NamePanel classNamePanel = new NamePanel();
	CbPanel checkBoxPanel = new CbPanel();
	TfPanel textFieldPanel = new TfPanel();

	public Gui() {
		panel.add(classNamePanel);
		panel.add(checkBoxPanel);
		panel.add(textFieldPanel);

		JButton create = new JButton("Create");
		panel.add(create);
		create.addActionListener(new SubmitListener());

		panel.setBackground(Color.GRAY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 250);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setVisible(true);
	}

	public void clearScreen() {
		classNamePanel.classNameTf.setText("");
		textFieldPanel.importTf.setText("");
		textFieldPanel.extendTf.setText("");
		textFieldPanel.implementTf.setText("");
		checkBoxPanel.mainCb.setSelected(false);
		checkBoxPanel.importCb.setSelected(false);
		checkBoxPanel.extendCb.setSelected(false);
		checkBoxPanel.implementCb.setSelected(false);

		className = null;
		importString = null;
		extendString = null;
		implementString = null;
		mainClass = false;
	}

	public class SubmitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			className = classNamePanel.classNameTf.getText();
			mainClass = checkBoxPanel.mainCb.isSelected();

			if (checkBoxPanel.importCb.isSelected()) {
				importString = textFieldPanel.importTf.getText();
			}
			if (checkBoxPanel.extendCb.isSelected()) {
				extendString = textFieldPanel.extendTf.getText();
			}
			if (checkBoxPanel.implementCb.isSelected()) {
				implementString = textFieldPanel.implementTf.getText();
			}
			
			new ClassConstructor(className, mainClass, importString, extendString, implementString);
			clearScreen();
		}
	}


}