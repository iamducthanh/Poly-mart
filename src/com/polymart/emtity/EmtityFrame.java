package com.polymart.emtity;

import com.polymart.ui.BaoCaoJInternalFrame;
import com.polymart.ui.ChiTietNhanVienFrame;
import com.polymart.ui.DD;
import com.polymart.ui.LoginJFrame;
import com.polymart.ui.PolyMartMain;
import com.polymart.ui.ThemHangHoaFrame;
import com.polymart.ui.ThietLapGiaJInternalFrame;
import com.polymart.ui.uiCommon;

public class EmtityFrame {
	public static BaoCaoJInternalFrame frameBaoCao = new BaoCaoJInternalFrame();
	public static ChiTietNhanVienFrame frameChiTietNhanVien = new ChiTietNhanVienFrame();
	public static DD frameDd = new DD();
	public static LoginJFrame frameLogin = new LoginJFrame();
	public static PolyMartMain framePolyMartMain = new PolyMartMain();
	public static ThemHangHoaFrame frameHangHoa = new ThemHangHoaFrame();

	public static void resetFrame() {
		frameBaoCao = new BaoCaoJInternalFrame();
		frameChiTietNhanVien = new ChiTietNhanVienFrame();
		frameDd = new DD();
		frameLogin = new LoginJFrame();
		framePolyMartMain = new PolyMartMain();
		frameHangHoa = new ThemHangHoaFrame();
	}

}
