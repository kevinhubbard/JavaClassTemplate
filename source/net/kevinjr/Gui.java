package net.kevinjr;

import java.awt.*;
import javax.swing.*;

public class Gui extends JPanel {

	private ClassPanel classPanel = new ClassPanel();
	private PackagePanel packPanel = new PackagePanel();
	private ImportPanel importPanel = new ImportPanel();
	private ExtendPanel extendPanel = new ExtendPanel();
	private ImplementPanel implementPanel = new ImplementPanel();
	private ImportListPanel importListPanel = new ImportListPanel();
	//private ImplementListPanel implementListPanel = new ImplementListPanel();
	private OptionPanel optionPanel = new OptionPanel();
	private ActionPanel actionPanel = new ActionPanel();

	public Gui() {
		add(classPanel);
		add(packPanel);
		add(importPanel);
		add(extendPanel);
		add(implementPanel);
		add(importListPanel);
		//add(implementListPanel);
		add(optionPanel);
		add(actionPanel);
		setBackground(Color.GRAY);
	}
}