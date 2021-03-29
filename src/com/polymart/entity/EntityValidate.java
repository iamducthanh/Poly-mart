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
		return true;
	}
}
