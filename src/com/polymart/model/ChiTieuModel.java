package com.polymart.model;

import java.sql.Timestamp;

public class ChiTieuModel {
	private String mucDichChiTieu;
	private Long soTien;
	private String ghiChu;
	private Long idNhanVien;
	private Timestamp ngayChiTieu;

	public ChiTieuModel() {
		super();
	}

	public ChiTieuModel(String mucDichChiTieu, Long soTien, String ghiChu, Long idNhanVien, Timestamp ngayChiTieu) {
		super();
		this.mucDichChiTieu = mucDichChiTieu;
		this.soTien = soTien;
		this.ghiChu = ghiChu;
		this.idNhanVien = idNhanVien;
		this.ngayChiTieu = ngayChiTieu;
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

	public Long getIdNhanVien() {
		return idNhanVien;
	}

	public void setIdNhanVien(Long idNhanVien) {
		this.idNhanVien = idNhanVien;
	}

	public Timestamp getNgayChiTieu() {
		return ngayChiTieu;
	}

	public void setNgayChiTieu(Timestamp ngayChiTieu) {
		this.ngayChiTieu = ngayChiTieu;
	}

}
