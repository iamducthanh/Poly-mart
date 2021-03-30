package com.polymart.model;

public class NguonHangModel extends AbstractModel {
	private String tenNguonHang;
	private String diaChi;
	private String sdt;

	public NguonHangModel() {
	}

	public NguonHangModel(String tenNguonHang, String diaChi, String sdt) {
		this.tenNguonHang = tenNguonHang;
		this.diaChi = diaChi;
		this.sdt = sdt;
	}

	public String getTenNguonHang() {
		return tenNguonHang;
	}

	public void setTenNguonHang(String tenNguonHang) {
		this.tenNguonHang = tenNguonHang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

}
