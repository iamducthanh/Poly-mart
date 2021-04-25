package com.polymart.entity;

import java.awt.Component;

import javax.swing.JOptionPane;

public class EntityMessage {

	// tiêu đề của phần mềm
	public static String TITLE = "Thông báo";

	public static void show(Component component, String text) {
		JOptionPane.showMessageDialog(component, text, TITLE, JOptionPane.INFORMATION_MESSAGE);
	}

	// hàm hiển thị xác nhận của người dùng
	public static boolean confirm(Component component, String text) {
		return JOptionPane.showConfirmDialog(component, text, TITLE,
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
	}
	
	public static void showWarring() {
		JOptionPane.showMessageDialog(null, "Bạn không có quyền quy cập mục này!","Cảnh báo",JOptionPane.WARNING_MESSAGE);
	}

	// hàm hiển cho phép người dùng nhập dữ liệu vào
	public static String porm(Component component, String text) {
		return JOptionPane.showInputDialog(component, text, TITLE, JOptionPane.INFORMATION_MESSAGE);
	}
}
