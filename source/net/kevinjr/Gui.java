package net.kevinjr;

import java.awt.*;
import javax.swing.*;

/**
* This class takes all the subpanel objects and adds them to the main panel. 
* 
* @author Kevin H
* @version 1.0.1
* @since 2022-01-16
*/

public class Gui extends JPanel {

	private ClassPanel classPanel = new ClassPanel();
	private PackagePanel packPanel = new PackagePanel();
	private ImportPanel importPanel = new ImportPanel();
	private ExtendPanel extendPanel = new ExtendPanel();
	private ImplementPanel implementPanel = new ImplementPanel();
	private ImportListPanel importListPanel = new ImportListPanel();
	private OptionPanel optionPanel = new OptionPanel();
	private ActionPanel actionPanel = new ActionPanel();

	/**
	* No arg constructor that adds all panels together.
	*/

	public Gui() {
		add(classPanel);
		add(packPanel);
		add(importPanel);
		add(extendPanel);
		add(implementPanel);
		add(importListPanel);
		add(optionPanel);
		add(actionPanel);
		setBackground(Color.GRAY);
	}
}