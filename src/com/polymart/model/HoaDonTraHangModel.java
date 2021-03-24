package com.polymart.model;

import java.sql.Timestamp;

public class HoaDonTraHangModel extends AbstractModel{
	private Long idNhanVien;
	private Timestamp ngayTraHang;
	private String ghiChu;
	
	Long getIdNhanVien() {
		return idNhanVien;
	}
	void setIdNhanVien(Long idNhanVien) {
		this.idNhanVien = idNhanVien;
	}
	Timestamp getNgayTraHang() {
		return ngayTraHang;
	}
	void setNgayTraHang(Timestamp ngayTraHang) {
		this.ngayTraHang = ngayTraHang;
	}
	String getGhiChu() {
		return ghiChu;
	}
	void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
}