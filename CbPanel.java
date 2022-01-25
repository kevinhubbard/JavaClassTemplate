import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class CbPanel extends JPanel {
	JCheckBox mainCb = new JCheckBox("Is main() class?");
	JCheckBox importCb = new JCheckBox("Imports?");
	JCheckBox extendCb = new JCheckBox("Extends?");
	JCheckBox implementCb = new JCheckBox("Implements?");

	public CbPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		add(mainCb);
		add(importCb);
		add(extendCb);
		add(implementCb);

		importCb.addActionListener(new ImportsListener());
		//extendCb.addActionListener(new ExtendsListener());
		//implementCb.addActionListener(new ImplementsListener());
	}

	public class ImportsListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (importCb.isSelected()) {
				TfPanel.importTf.setEnabled(true);
			} else {
				TfPanel.importTf.setEnabled(false);
			}
		}
	}

/*	public class ExtendsListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (extendCb.isSelected()) {
				extendTf.setEnabled(true);
			} else {
				extendTf.setEnabled(false);
			}
		}
	}*/

/*	public class ImplementsListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (implementCb.isSelected()) {
				implementTf.setEnabled(true);
			} else {
				implementTf.setEnabled(false);
			}
		}
	}*/
}