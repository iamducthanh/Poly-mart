package com.polymart.entity;

import java.awt.*;

public class EntityValidate {

    // kiểm tra tài khoản đăng nhập
    public static boolean checkUsername(Component component, String username) {
        if (username.isBlank()) {
            EntityMessage.show(EntityFrame.LOGIN, "Mã đăng nhập không được để trống");
            return false;
        }
        if (!username.matches("\\d+")) { // regex contains only digits
            EntityMessage.show(EntityFrame.LOGIN, "Mã đăng nhập chỉ chứa ký tự số");
            return false;
        }
        return true;
    }

    // kiểm tra mật khẩu đăng nhập
    public static boolean checkPassword(Component component, String password) {
        if (password.isBlank()) {
            EntityMessage.show(EntityFrame.LOGIN, "Mật khẩu không được để trống");
            return false;
        }
        return true;
    }

    // hàm kiểm tra mật khẩu cũ forrm đổi mật khẩu người dùng
    public static boolean checkOldPasswordChange(Component component, String oldPassword) {
        if (oldPassword.length() == 0) {
            EntityMessage.show(EntityFrame.LOGIN, "Chưa nhập mật khẩu cũ");
            return false;
        }
        if (oldPassword.equals(EntityAuthorization.USER.getMatKhau()))
            return true;
        EntityMessage.show(EntityFrame.LOGIN, "Mật khẩu cũ không chính xác");
        return false;
    }

    // hàm kiểm tra mật khẩu mới form đổi mật khẩu
    public static boolean checkNewPasswordChange(Component component, String newPassword) {
        if (newPassword.length() == 0) {
            EntityMessage.show(EntityFrame.LOGIN, "Chưa nhập mật khẩu mới");
            return false;
        }
        if (newPassword.length() < 8 || newPassword.length() > 50) {
            EntityMessage.show(EntityFrame.LOGIN, "Mật khẩu phải có độ dài từ 8 - 50 ký tự");
            return false;
        }
        return true;
    }

    // hàm kiểm tra xác nhận mật khẩu form đổi mật khẩu
    public static boolean checkConfirmNewPasswordChange(Component component, String confirmNewPassword) {
        if (confirmNewPassword.length() == 0) {
            EntityMessage.show(EntityFrame.LOGIN, "Chưa nhập xác nhận mật khẩu mới");
            return false;
        }
        return true;
    }

    // kiểm tra số nguyên
    public static boolean checkInt(Component component, String inputInt) {
        try {
            Integer.parseInt(inputInt);
            return true;
        } catch (Exception e) {
            EntityMessage.show(component, inputInt + " không phải một số nguyên.");
            return false;
        }
    }

    // kiểm tra số nguyên dương
    public static boolean checkIntDuong(Component component, String inputIntDuong) {
        if (!checkInt(component, inputIntDuong)) {
            return true;
        }
        EntityMessage.show(component, inputIntDuong + " không phải một số nguyên dương.");
        return false;
    }
}
