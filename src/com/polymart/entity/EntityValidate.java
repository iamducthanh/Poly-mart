package com.polymart.entity;

public class EntityValidate {
    public static boolean checkUsername(String username) {
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

    public static boolean checkPassword(String password) {
        if (password.isBlank()) {
            EntityMessage.show(EntityFrame.LOGIN, "Mật khẩu không được để trống");
            return false;
        }
        return true;
    }

    // hàm kiểm tra mật khẩu cũ forrm đổi mật khẩu người dùng
    public static String checkOldPasswordChange(String oldPassword) {
        if (oldPassword.length() == 0)
            return "Chưa nhập mật khẩu cũ";
        if (oldPassword.equals(EntityAuthorization.USER.getMatKhau()))
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
