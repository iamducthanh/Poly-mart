package com.polymart.controller;

import java.util.ArrayList;
import java.util.List;

import com.polymart.model.NhanVienModel;

public class QuanLyNhanVienImpl implements QuanLyNhanVien {

	private NhanVienModel user;
	private List<NhanVienModel> listNhanVien;

	public QuanLyNhanVienImpl() {
		listNhanVien = new ArrayList<NhanVienModel>(); // SQL
		NhanVienModel nhanVienModel = new NhanVienModel();
		nhanVienModel.setId(Long.valueOf(123));
		nhanVienModel.setMatKhau("123");

		listNhanVien.add(nhanVienModel);
	}

	@Override
	public void setLogin(String username, String password) {
		user.setId(Long.parseLong(username));
		user.setMatKhau(password);
	}

	@Override
	public NhanVienModel getLogin() {
		return user;
	}

	@Override
	public boolean isContainsNhanVien(String username, String password) {
		for (NhanVienModel x : listNhanVien) {
			if (Long.parseLong(username) == x.getId() && x.getMatKhau().equals(password)) {
				return true;
			}
		}
		return false;
	}
}
