package com.polymart.entity;

import com.polymart.ui.BaoCaoJInternalFrame;
import com.polymart.ui.ChiTietNhanVienFrame;
import com.polymart.ui.DD;
import com.polymart.ui.LoginJFrame;
import com.polymart.ui.PolyMartMain;
import com.polymart.ui.ThemHangHoaFrame;

public class EntityFrame {
	public static BaoCaoJInternalFrame BAOCAO = new BaoCaoJInternalFrame();
	public static ChiTietNhanVienFrame CHITIETNHANVIEN = new ChiTietNhanVienFrame();
	public static DD DD = new DD();
	public static LoginJFrame LOGIN = new LoginJFrame();
	public static PolyMartMain POLYMARTMAIN = new PolyMartMain();
	public static ThemHangHoaFrame HANGHOA = new ThemHangHoaFrame();

	public static void resetFrame() {
		BAOCAO = new BaoCaoJInternalFrame();
		CHITIETNHANVIEN = new ChiTietNhanVienFrame();
		DD = new DD();
		LOGIN = new LoginJFrame();
		POLYMARTMAIN = new PolyMartMain();
		HANGHOA = new ThemHangHoaFrame();
	}

}
