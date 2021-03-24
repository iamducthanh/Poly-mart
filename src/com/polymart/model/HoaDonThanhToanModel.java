package com.polymart.model;

import java.sql.Timestamp;

public class HoaDonThanhToanModel extends AbstractModel{
	private Long idKhachHang;
	private Long idNhanVien;
	private Integer diemDaDoi;
	private Timestamp ngayThanhToan;
	private String ghiChu;
	
	public Long getIdKhachHang() {
		return idKhachHang;
	}
	public void setIdKhachHang(Long idKhachHang) {
		this.idKhachHang = idKhachHang;
	}
	public Long getIdNhanVien() {
		return idNhanVien;
	}
	public void setIdNhanVien(Long idNhanVien) {
		this.idNhanVien = idNhanVien;
	}
	public Integer getDiemDaDoi() {
		return diemDaDoi;
	}
	public void setDiemDaDoi(Integer diemDaDoi) {
		this.diemDaDoi = diemDaDoi;
	}
	public Timestamp getNgayThanhToan() {
		return ngayThanhToan;
	}
	public void setNgayThanhToan(Timestamp ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	
}
