package com.polymart.entity;

import java.awt.Component;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EntityValidate {

	// kiểm tra tài khoản đăng nhập
	public static boolean checkUsername(Component component, String username) {
		if (username.isBlank()) {
			EntityMessage.show(component, "Mã đăng nhập không được để trống");
			return false;
		}
		if (!username.matches("\\d+")) { // regex contains only digits
			EntityMessage.show(component, "Mã đăng nhập chỉ chứa ký tự số");
			return false;
		}
		return true;
	}

	// kiểm tra mật khẩu đăng nhập
	public static boolean checkPassword(Component component, String password) {
		if (password.isBlank()) {
			EntityMessage.show(component, "Mật khẩu không được để trống");
			return false;
		}
		if (password.length() < 8 || password.length() > 50) {
			EntityMessage.show(component, "Mật khẩu phải có độ dài từ 8 đến 50 ký tự");
			return false;
		}
		return true;
	}

	// hàm kiểm tra mật khẩu cũ forrm đổi mật khẩu người dùng
	public static boolean checkOldPasswordChange(Component component, String oldPassword) {
		if (oldPassword.isBlank()) {
			EntityMessage.show(component, "Chưa nhập mật khẩu cũ");
			return false;
		}
		if (!oldPassword.equals(EntityAuthorization.USER.getMatKhau())) {
			EntityMessage.show(component, "Mật khẩu cũ không chính xác");
			return false;
		}
		return true;
	}

	// hàm kiểm tra mật khẩu mới form đổi mật khẩu
	public static boolean checkNewPasswordChange(Component component, String newPassword) {
		if (newPassword.length() == 0) {
			EntityMessage.show(component, "Chưa nhập mật khẩu mới");
			return false;
		}
		if (newPassword.length() < 8 || newPassword.length() > 50) {
			EntityMessage.show(component, "Mật khẩu phải có độ dài từ 8 - 50 ký tự");
			return false;
		}
		return true;
	}

	// hàm kiểm tra xác nhận mật khẩu form đổi mật khẩu
	public static boolean checkConfirmNewPasswordChange(Component component, String confirmNewPassword) {
		if (confirmNewPassword.length() == 0) {
			EntityMessage.show(component, "Chưa nhập xác nhận mật khẩu mới");
			return false;
		}
		return true;
	}

	// kiểm tra số nguyên dương
	public static boolean checkPositiveNumber(Component component, String number) {
		String regex = "\\d+";
		if (number.isBlank()) {
			EntityMessage.show(component, "Vui lòng nhập số lượng");
			return false;
		}
		try {
			if (!number.matches(regex) || Integer.parseInt(number) <= 0) {
				EntityMessage.show(component, "Nhập số nguyên dương");
				return false;
			}
		} catch (Exception e) {
			EntityMessage.show(component, "Nhập số nguyên dương");
			return false;
		}
		return true;
	}

	// kiểm mã hóa đơn
	public static boolean checkIdNumber(Component component, String idNumber) {
		String regex = "\\d+";
		if (idNumber.isBlank()) {
			EntityMessage.show(component, "Vui lòng nhập một số");
			return false;
		}
		try {
			if (!idNumber.matches(regex) || Integer.parseInt(idNumber) <= 0) {
				EntityMessage.show(component, "Nhập số nguyên dương");
				return false;
			}
		} catch (Exception e) {
			EntityMessage.show(component, "Nhập số nguyên dương");
			return false;
		}
		return true;
	}

	// check tên tiếng việt
	public static boolean checkName(Component component, String name) {
		if (name.isBlank()) {
			EntityMessage.show(component, "Họ tên không được để trống");
			return false;
		}
		String regx = "^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\s]+$";
		Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(name);
		if (!matcher.find()) {
			EntityMessage.show(component, "Họ tên không hợp lệ");
			return false;
		}
		return true;
	}

	// kiểm tra số điện thoại
	public static boolean checkPhoneNumber(Component component, String phoneNumber) {
		String regex = "(84|0)+([0-9]{9})\\b";
		if (phoneNumber.isBlank()) {
			EntityMessage.show(component, "Số điện thoại không được để trống");
			return false;
		}
		if (!phoneNumber.matches(regex)) {
			EntityMessage.show(component, "Số điện thoại không hợp lệ");
			return false;
		}
		return true;
	}

	// kiểm tra số tiền
	public static boolean checkMoney(Component component, String money) {
		String regex = "^[0-9]+(\\.[0-9]{1,2})?$";
		if (money.isBlank()) {
			EntityMessage.show(component, "Số tiền không được để trống");
			return false;
		}
		if (!money.matches(regex)) {
			EntityMessage.show(component, "Số tiền không hợp lệ");
			return false;
		}
		return true;
	}

	// check birth of date > 18 years old
	public static boolean checkNgaySinh(Component component, Date date) {
		if (date == null) {
			EntityMessage.show(component, "Ngày sinh trống");
			return false;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int yearOfBirth = calendar.get(Calendar.YEAR);
		calendar.setTime(new Date());
		int yearNow = calendar.get(Calendar.YEAR);
		if (yearNow - yearOfBirth <= 18) {
			EntityMessage.show(component, "Ngày sinh phải trên 18 tuổi");
			return false;

		}
		return true;

	}

	// validate email
	public static boolean checkEmail(Component component, String email) {
		String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
		if (email.isBlank()) {
			EntityMessage.show(component, "Email trống");
			return false;
		}
		if (!email.matches(regexEmail)) {
			EntityMessage.show(component, "Email không hợp lệ");
			return false;
		}
		return true;
	}
}
