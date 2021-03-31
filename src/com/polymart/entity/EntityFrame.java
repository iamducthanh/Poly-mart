package com.polymart.entity;

import com.polymart.ui.DD;
import com.polymart.ui.PolyMartMain;
import com.polymart.ui.hanghoa.ThemHangHoaFrame;
import com.polymart.ui.nhanvien.ChiTietNhanVienFrame;
import com.polymart.ui.taikhoan.LoginJFrame;

public class EntityFrame {
    public static ChiTietNhanVienFrame CHITIETNHANVIEN = new ChiTietNhanVienFrame();
    public static DD DD = new DD();
    public static LoginJFrame LOGIN = new LoginJFrame();
    public static PolyMartMain POLYMARTMAIN = new PolyMartMain();
    public static ThemHangHoaFrame THEMHANGHOA = new ThemHangHoaFrame();

    // form reset lại tất cả các form khi đăng xuất đăng nhập lại
    public static void resetFrame() {
        CHITIETNHANVIEN = new ChiTietNhanVienFrame();
        DD = new DD();
        LOGIN = new LoginJFrame();
        POLYMARTMAIN = new PolyMartMain();
        THEMHANGHOA = new ThemHangHoaFrame();
    }

}
