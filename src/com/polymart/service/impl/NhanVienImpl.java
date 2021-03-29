package com.polymart.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.polymart.config.SecurityConfig;
import com.polymart.model.NhanVienModel;
import com.polymart.service.INhanVien;

public class NhanVienImpl implements INhanVien {

	static NhanVienModel USER = null;
	private static Map<Long, NhanVienModel> mapNhanVien = new HashMap<Long, NhanVienModel>();	//Nạp dữ liệu từ SQL
	
	static {
		initNhanVien();
	}

	private static void initNhanVien() {
		NhanVienModel nhanVien = new NhanVienModel();
		nhanVien.setId(Long.valueOf(12345678));
		nhanVien.setMatKhau("12345678");
		nhanVien.setChucVu(SecurityConfig.VAITRO_QUANLY);
		mapNhanVien.put(nhanVien.getId(), nhanVien);
	}

	@Override
	public NhanVienModel findNhanVien(Long id, String password) {
		NhanVienModel nhanVien = mapNhanVien.get(id);
        if (nhanVien != null && nhanVien.getMatKhau().equals(password)) {
        	USER = nhanVien;
            return nhanVien;
        }
        return null;
	}
}
