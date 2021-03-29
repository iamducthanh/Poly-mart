package com.polymart.entity;

public class EntityLogin {
	// hàm kiểm tra tên đăng nhập form login
	public static String checkUsernameLogin(String inputUsername) {
		if (inputUsername.isBlank())
			return "Chưa nhập tên đăng nhập";
		if (!inputUsername.matches("[a-zA-Z0-9]+"))
			return "Tên đăng nhập không được chứa các ký tự đặc biệt";
		return "";
	}
	
	// hàm kiểm tra mật khẩu đăng nhập form login
	public static String checkPasswordLogin(String inputPassword) {
		if (inputPassword.length() == 0)
			return "Chưa nhập mật khẩu";
		if (inputPassword.length() < 8 || inputPassword.length() > 50)
			return "Mật khẩu phải có độ dài từ 8 - 50 ký tự";
		return "";
	}

	// hàm kiểm tra mật khẩu cũ forrm đổi mật khẩu người dùng
	public static String checkOldPasswordChange(String oldPassword) {
		if (oldPassword.length() == 0)
			return "Chưa nhập mật khẩu cũ";
		if (oldPassword.equals(EntityAthur._nhanVienModelLogin.getMatKhau()))
			return "";
		return "Mật khẩu cũ không chính xác";
	}

	// hàm kiểm tra mật khẩu mới form đổi mật khẩu
	public static String checkNewPasswordChange(String newPassword) {
		if (newPassword.length() == 0)
			return "Chưa nhập mật khẩu mới";
		if (newPassword.length() < 8 || newPassword.length() > 50)
			return "Mật khẩu phải có độ dài từ 8 - 50 ký tự";
		return "";
	}

	// hàm kiểm tra xác nhận mật khẩu form đổi mật khẩu
	public static String checkConfirmNewPasswordChange(String confirmNewPassword) {
		if (confirmNewPassword.length() == 0)
			return "Chưa nhập xác nhận mật khẩu mới";
		return "";
	}

}
