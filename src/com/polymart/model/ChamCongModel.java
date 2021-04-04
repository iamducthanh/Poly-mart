package com.polymart.model;

import java.sql.Timestamp;

public class ChamCongModel {
	private Integer idNhanVien;
	private Timestamp ngayChamCong;
	private String hoTen;

	public ChamCongModel() {
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public ChamCongModel(Integer idNhanVien, Timestamp ngayChamCong) {
		this.idNhanVien = idNhanVien;
		this.ngayChamCong = ngayChamCong;
	}

	public Integer getIdNhanVien() {
		return idNhanVien;
	}

	public void setIdNhanVien(Integer idNhanVien) {
		this.idNhanVien = idNhanVien;
	}

	public Timestamp getNgayChamCong() {
		return ngayChamCong;
	}

	public void setNgayChamCong(Timestamp ngayChamCong) {
		this.ngayChamCong = ngayChamCong;
	}

}
