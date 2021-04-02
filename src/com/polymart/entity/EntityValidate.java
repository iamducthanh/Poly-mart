package com.polymart.entity;

import java.awt.*;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.toedter.calendar.JDateChooser;

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
        if (oldPassword.equals(EntityAuthorization.USER.getMatKhau()))
            return true;
        EntityMessage.show(component, "Mật khẩu cũ không chính xác");
        return false;
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
        if (!number.matches(regex) || Integer.parseInt(number) <= 0) {
            EntityMessage.show(component, "Nhập số nguyên dương");
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

    public static boolean checkNgaySinh(JDateChooser date) {
        return date.getDate().after(new Date());
    }
}
