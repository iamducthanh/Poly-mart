package com.polymart.model;

public class BangLuongModel {
	private Integer maNhanVien;
	private String hoTen;
	private int soNgayDiLam;
	private int soNgayDiMuon;
	private int soNgayVeSom;

	private Long luong;

	public Long getLuong() {
		return luong;
	}

	public int getSoNgayVeSom() {
		return soNgayVeSom;
	}

	public void setSoNgayVeSom(int soNgayVeSom) {
		this.soNgayVeSom = soNgayVeSom;
	}

	public void setLuong(long luong) {
		this.luong = luong;
	}

	public BangLuongModel() {
	}

	public Integer getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(Integer maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getSoNgayDiLam() {
		return soNgayDiLam;
	}

	public void setSoNgayDiLam(int soNgayDiLam) {
		this.soNgayDiLam = soNgayDiLam;
	}

	public int getSoNgayDiMuon() {
		return soNgayDiMuon;
	}

	public void setSoNgayDiMuon(int soNgayDiMuon) {
		this.soNgayDiMuon = soNgayDiMuon;
	}

}
