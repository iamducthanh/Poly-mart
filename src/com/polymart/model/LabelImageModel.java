package com.polymart.model;

import javax.swing.JLabel;

public class LabelImageModel {
	JLabel lblImage;
	String name;

	public JLabel getLblImage() {
		return lblImage;
	}

	public LabelImageModel(JLabel lblImage, String name) {
		super();
		this.lblImage = lblImage;
		this.name = name;
	}

	public void setLblImage(JLabel lblImage) {
		this.lblImage = lblImage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
