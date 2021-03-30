package com.polymart.model;

public class NguonHangModel extends AbstractModel{
	private String tenNguonHang;
	private String diaChi;
	private String sdt;
	
	String getTenNguonHang() {
		return tenNguonHang;
	}
	void setTenNguonHang(String tenNguonHang) {
		this.tenNguonHang = tenNguonHang;
	}
	String getDiaChi() {
		return diaChi;
	}
	void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	String getSdt() {
		return sdt;
	}
	void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	
}
