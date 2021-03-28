package com.polymart.emtity;

public class EmtityLogin {
	public static String checkUsername(String inputUsername) {
		if(inputUsername.isBlank() || inputUsername.isEmpty()) {
			return "Tên đăng nhập không được để trống";
		}
		if(!inputUsername.matches("[a-zA-Z0-9]+")) {
			return "Tên đăng nhập không được chứa các ký tự đặc biệt";
		}
		return "";
	}
	
	public static String checkPassword(String inputPassword) {
		if(inputPassword.isBlank() || inputPassword.isEmpty()) {
			return "Mật khẩu không được để trống";
		}
		if(inputPassword.length() < 8 || inputPassword.length()>50) {
			return "Mật khẩu phải có độ dài từ 8 - 50 ký tự";
		}
		return "";
	}
}
