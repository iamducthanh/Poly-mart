package com.polymart.entity;

import java.awt.Component;

import javax.swing.JOptionPane;

public class EntityMessage {

	// tiêu đề của phần mềm
	public static String title = "Phần mềm quản lý bán hàng";

	public static void show(Component component, String text) {
		JOptionPane.showMessageDialog(component, text, title, JOptionPane.INFORMATION_MESSAGE);
	}

	// hàm hiển thị xác nhận của người dùng
	public static boolean confirm(Component component, String text) {
		return JOptionPane.showConfirmDialog(component, text, title,
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
	}
}
