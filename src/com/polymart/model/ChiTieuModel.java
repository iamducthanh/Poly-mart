package com.polymart.model;

import java.sql.Timestamp;

public class ChiTieuModel {

	private int MaCT;
	private String mucDichChiTieu;
	private String hoTen;
	private Long soTien;
	private String ghiChu;
	private Integer idNhanVien;
	private Timestamp ngayChiTieu;

	public ChiTieuModel() {

	}



	public ChiTieuModel(int maCT, String mucDichChiTieu, String hoTen, Long soTien, String ghiChu, Integer idNhanVien,
			Timestamp ngayChiTieu) {
		MaCT = maCT;
		this.mucDichChiTieu = mucDichChiTieu;
		this.hoTen = hoTen;
		this.soTien = soTien;
		this.ghiChu = ghiChu;
		this.idNhanVien = idNhanVien;
		this.ngayChiTieu = ngayChiTieu;
	}



	public String getHoTen() {
		return hoTen;
	}


	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getMaCT() {
		return MaCT;
	}

	public void setMaCT(int maCT) {
		MaCT = maCT;
	}

	public String getMucDichChiTieu() {
		return mucDichChiTieu;
	}

	public void setMucDichChiTieu(String mucDichChiTieu) {
		this.mucDichChiTieu = mucDichChiTieu;
	}

	public Long getSoTien() {
		return soTien;
	}

	public void setSoTien(Long soTien) {
		this.soTien = soTien;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public Integer getIdNhanVien() {
		return idNhanVien;
	}

	public void setIdNhanVien(Integer idNhanVien) {
		this.idNhanVien = idNhanVien;
	}

	public Timestamp getNgayChiTieu() {
		return ngayChiTieu;
	}

	public void setNgayChiTieu(Timestamp ngayChiTieu) {
		this.ngayChiTieu = ngayChiTieu;
	}

}
