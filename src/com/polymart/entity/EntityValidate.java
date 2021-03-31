package com.polymart.entity;

import java.awt.Component;

public class EntityValidate {
    public static boolean checkUsername(String username, Component component) {
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

    public static boolean checkPassword(String password, Component component) {
        if (password.isBlank()) {
            EntityMessage.show(component, "Mật khẩu không được để trống");
            return false;
        }
        return true;
    }

    // hàm kiểm tra mật khẩu cũ forrm đổi mật khẩu người dùng
    public static boolean checkOldPasswordChange(String oldPassword, Component component) {
        if (oldPassword.length() == 0) {
            EntityMessage.show(component, "Chưa nhập mật khẩu cũ");
            return false;
        }
        if (oldPassword.equals(EntityAuthorization.USER.getMatKhau()))
            return true;
        EntityMessage.show(component, "Mật khẩu cũ không chính xác");
        return false;
    }

    // hàm kiểm tra mật khẩu mới form đổi mật khẩu
    public static boolean checkNewPasswordChange(String newPassword, Component component) {
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
    public static boolean checkConfirmNewPasswordChange(String confirmNewPassword, Component component) {
        if (confirmNewPassword.length() == 0) {
            EntityMessage.show(component, "Chưa nhập xác nhận mật khẩu mới");
            return false;
        }
        return true;
    }
}
