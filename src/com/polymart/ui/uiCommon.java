package com.polymart.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class uiCommon {
	private JPanel panelOption;
	static Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	static int width = (int) dimension.getWidth();
	static int height = (int) dimension.getHeight();

	public uiCommon(JPanel panelOption) {
		super();
		this.panelOption = panelOption;
	}
	
	public void addCheckBox(JCheckBox checkBox, int x, int y, int w) {
		checkBox.setBackground(Color.WHITE);
		checkBox.setBounds(x, y, w, 23);
		panelOption.add(checkBox);
	}

}
