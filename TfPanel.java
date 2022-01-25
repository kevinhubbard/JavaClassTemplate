import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class TfPanel extends JPanel {
	JTextField importTf = new JTextField(10);
	JTextField extendTf = new JTextField(10);
	JTextField implementTf = new JTextField(10);
	
	public TfPanel() {
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		add(importTf);
		add(extendTf);
		add(implementTf);

		importTf.setEnabled(false);
		extendTf.setEnabled(false);
		implementTf.setEnabled(false);
	}
}