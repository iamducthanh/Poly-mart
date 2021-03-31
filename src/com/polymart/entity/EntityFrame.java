package com.polymart.entity;

import com.polymart.ui.DD;
import com.polymart.ui.PolyMartMain;
import com.polymart.ui.hanghoa.ThemHangHoaFrame;
import com.polymart.ui.nhanvien.ChiTietNhanVienFrame;
import com.polymart.ui.taikhoan.LoginJFrame;

public class EntityFrame {
    public static ChiTietNhanVienFrame CHITIETNHANVIEN = null;
    public static DD DD = null;
    public static LoginJFrame LOGIN = null;
    public static PolyMartMain POLYMARTMAIN = null;
    public static ThemHangHoaFrame THEMHANGHOA = null;

    // form reset lại tất cả các form khi đăng xuất đăng nhập lại
    public static void resetFrame() {
        CHITIETNHANVIEN = new ChiTietNhanVienFrame();
        DD = new DD();
        LOGIN = new LoginJFrame();
        POLYMARTMAIN = new PolyMartMain();
        THEMHANGHOA = new ThemHangHoaFrame();
    }

}
