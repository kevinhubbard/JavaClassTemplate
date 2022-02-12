package net.kevinjr;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Gui extends JPanel{
	private String className, extendString;
	private boolean mainClass;
	private ClassConstructor cc = new ClassConstructor();

	private TemClassPanel classPanel = new TemClassPanel();
	private TemPackagePanel packPanel = new TemPackagePanel();
	private TemImportPanel importPanel = new TemImportPanel();
	private TemExtendPanel extendPanel = new TemExtendPanel();
	private TemImplementPanel implementPanel = new TemImplementPanel();
	private TemActionPanel actionPanel = new TemActionPanel();
	private TemImportListPanel importListPanel = new TemImportListPanel();
	private TemImplementListPanel implementListPanel = new TemImplementListPanel();

	public Gui() {
		add(classPanel);
		add(packPanel);
		add(importPanel);
		add(importListPanel);
		add(extendPanel);
		add(implementPanel);
		add(implementListPanel);
		add(actionPanel);
		setBackground(Color.GRAY);
	}
}