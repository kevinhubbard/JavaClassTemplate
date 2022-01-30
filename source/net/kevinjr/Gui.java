package net.kevinjr;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Gui {
	String className, extendString;
	boolean mainClass;
	JFrame frame = new JFrame("Create a Class");
	JPanel panel = new JPanel();
	NamePanel classNamePanel = new NamePanel();
	CbPanel checkBoxPanel = new CbPanel();
	TfPanel textFieldPanel = new TfPanel();
	BtnPanel addBtnPanel = new BtnPanel();
	ClassConstructor cc = new ClassConstructor();

	public Gui() {
		panel.add(classNamePanel);
		panel.add(checkBoxPanel);
		panel.add(textFieldPanel);
		panel.add(addBtnPanel);
		JButton create = new JButton("Create");
		panel.add(create);
		addBtnPanel.importBtn.addActionListener(new AddImport());
		addBtnPanel.extendBtn.addActionListener(new AddExtend());
		addBtnPanel.implementBtn.addActionListener(new AddImplement());
		checkBoxPanel.importCb.addActionListener(new ImportCbListener());
		checkBoxPanel.extendCb.addActionListener(new ExtendCbListener());
		checkBoxPanel.implementCb.addActionListener(new ImplementCbListener());
		create.addActionListener(new SubmitListener());
		panel.setBackground(Color.GRAY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(330, 225);
		frame.setResizable(false);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((dim.width/2)-(frame.getWidth()/2), (dim.height/2)-(frame.getHeight()/2));
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
		mainClass = false;
		extendString = null;
		textFieldPanel.importTf.setEnabled(false);
		addBtnPanel.importBtn.setEnabled(false);
		textFieldPanel.implementTf.setEnabled(false);
		addBtnPanel.implementBtn.setEnabled(false);
	}

//CHECKBOX LISTENERS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public class ImportCbListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (checkBoxPanel.importCb.isSelected()) {
				textFieldPanel.importTf.setEnabled(true);
				addBtnPanel.importBtn.setEnabled(true);
			} else {
				textFieldPanel.importTf.setEnabled(false);
				addBtnPanel.importBtn.setEnabled(false);
			}
		}
	}

	public class ExtendCbListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (checkBoxPanel.extendCb.isSelected()) {
				textFieldPanel.extendTf.setEnabled(true);
				addBtnPanel.extendBtn.setEnabled(true);
			} else {
				textFieldPanel.extendTf.setEnabled(false);
				addBtnPanel.extendBtn.setEnabled(false);
			}
		}
	}

	public class ImplementCbListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (checkBoxPanel.implementCb.isSelected()) {
				textFieldPanel.implementTf.setEnabled(true);
				addBtnPanel.implementBtn.setEnabled(true);
			} else {
				textFieldPanel.implementTf.setEnabled(false);
				addBtnPanel.implementBtn.setEnabled(false);
			}
		}
	}
//ADD BUTTON LISTENERS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public class AddImport implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String testImport = textFieldPanel.importTf.getText();
			//~~~VALIDATE INPUT~~~~//
			if (cc.validImport(testImport) == false) {
				JOptionPane.showMessageDialog(frame, "Invalid Import name.");
				textFieldPanel.importTf.setText("");
			} else {
				System.out.println(testImport + " was valid.");
				textFieldPanel.importTf.setText("");
			}
		}
	}

	public class AddExtend implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String testExtend = textFieldPanel.extendTf.getText();
			//~~~VALIDATE INPUT~~~~//
			if (cc.validExtend(testExtend) == false ) {
				JOptionPane.showMessageDialog(frame, "Invalid Extend name.");
				textFieldPanel.extendTf.setText(extendString);
				checkBoxPanel.extendCb.setSelected(false);
			} else {
				System.out.println(testExtend + " was valid.");
				extendString = textFieldPanel.extendTf.getText();
			}
			textFieldPanel.extendTf.setEnabled(false);
			addBtnPanel.extendBtn.setEnabled(false);
		}
	}

	public class AddImplement implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String testImplement = textFieldPanel.implementTf.getText();
			//~~~VALIDATE INPUT~~~~//
			if (cc.validImplement(testImplement) == false) {
				JOptionPane.showMessageDialog(frame, "Invalid Implement name.");
			} else {
				System.out.println(testImplement + " was valid.");
				textFieldPanel.implementTf.setText("");
			}
		}
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	public class SubmitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String testClass = classNamePanel.classNameTf.getText();
			if (cc.validClassName(testClass) == false) {
				JOptionPane.showMessageDialog(frame, "Invalid Class Name.");
			} else {
				cc.isMainClass(checkBoxPanel.mainCb.isSelected());
				cc.showInfo();
				clearScreen();
			}
		}
	}
}



