package com.polymart.emtity;

import java.awt.Component;

import javax.swing.JOptionPane;

public class EmtityMessage {

	private static String title = "Phần mềm quản lý bán hàng";

	public static void msgThongBao(Component component, String text) {
		JOptionPane.showMessageDialog(component, text, title, JOptionPane.INFORMATION_MESSAGE);
	}

	public static boolean confirm(Component component, String text) {
		return JOptionPane.showConfirmDialog(component, text, title,
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
	}
}