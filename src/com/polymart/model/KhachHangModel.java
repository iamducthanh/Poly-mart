package com.polymart.model;

public class KhachHangModel extends AbstractModel {
	private String hoTen;
	private String sdt;
	private String diaChi;
	private Integer tichDiem;

	public KhachHangModel() {
	}

	public KhachHangModel(String hoTen, String sdt, String diaChi, Integer tichDiem) {
		this.hoTen = hoTen;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.tichDiem = tichDiem;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public Integer getTichDiem() {
		return tichDiem;
	}

	public void setTichDiem(Integer tichDiem) {
		this.tichDiem = tichDiem;
	}
}
