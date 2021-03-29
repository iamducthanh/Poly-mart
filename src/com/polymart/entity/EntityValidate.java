package com.polymart.entity;

public class EntityValidate {
	public static boolean checkUsername(String username) {
		if(username.isBlank()) {
			EntityMessage.show(EntityFrame.LOGIN, "Mã đăng nhập không được để trống");
			return false;
		}
		if (!username.matches("\\d+")) { // regex contains only digits
			EntityMessage.show(EntityFrame.LOGIN, "Mã đăng nhập chỉ chứa ký tự số");
			return false;
		}
		return true;
	}

	public static boolean checkPassword(String password) {
		if (password.isBlank()) {
			EntityMessage.show(EntityFrame.LOGIN, "Mật khẩu không được để trống");
			return false;
		}
		if (password.length() < 8 || password.length() > 50) {
			EntityMessage.show(EntityFrame.LOGIN, "Mật khẩu phải có độ dài từ 8 - 50 ký tự");
			return false;
		}
		return true;
	}
}
