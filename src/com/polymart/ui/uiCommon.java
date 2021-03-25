package com.polymart.ui;

import java.awt.Color;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class uiCommon {
	private JPanel panelOption;

	public uiCommon(JPanel panelOption) {
		super();
		this.panelOption = panelOption;
	}
	
	public void addCheckBox(JCheckBox checkBox, int x, int y, int w) {
		checkBox.setBackground(Color.WHITE);
		checkBox.setBounds(x, y, w, 23);
		panelOption.add(checkBox);
	}
	
	public void u() {
		
	}

}
