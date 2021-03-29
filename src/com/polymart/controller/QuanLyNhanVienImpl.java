package com.polymart.controller;

import java.util.ArrayList;
import java.util.List;

import com.polymart.model.NhanVienModel;

public class QuanLyNhanVienImpl implements QuanLyNhanVien {

	List<NhanVienModel> _lstNhanVien;

	public QuanLyNhanVienImpl() {
		_lstNhanVien = new ArrayList<NhanVienModel>();
		NhanVienModel nhanVienModel = new NhanVienModel();
		nhanVienModel.setId(Long.valueOf(12345678));
		nhanVienModel.setMatKhau("12345678");
		_lstNhanVien.add(nhanVienModel);
	}

	@Override
	public NhanVienModel getLogin(String username, String password) {
		if (username.isBlank() || username.isEmpty() || password.isBlank() || password.isEmpty()) {
			return null;
		}
		for (NhanVienModel x : _lstNhanVien) {
			if (Long.parseLong(username) == x.getId() && x.getMatKhau().equals(password)) {
				return x;
			}
		}
		return null;
	}

}
