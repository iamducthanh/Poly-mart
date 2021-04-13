package com.polymart.model;

import java.sql.Timestamp;

public class ChamCongModel {
	private Integer idNhanVien;
	private Timestamp ngayChamCong;
	private Timestamp gioRa;
	public Timestamp getGioRa() {
		return gioRa;
	}

	public void setGioRa(Timestamp gioRa) {
		this.gioRa = gioRa;
	}

	private String hoTen;

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
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
