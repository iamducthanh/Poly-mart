package com.polymart.model;

public class KhachHangModel extends AbstractModel {
	private String hoTen;
	private String sdt;
	private String diaChi;
	private Integer tichDiem;

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

	@Override
	public String toString() {
		return "KhachHangModel [ma = " + getId() + ", hoTen=" + hoTen + ", sdt=" + sdt + ", diaChi=" + diaChi
				+ ", tichDiem=" + tichDiem + "]";
	}

}
