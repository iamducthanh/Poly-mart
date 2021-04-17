package com.polymart.model;

public class LoaiSanPhamModel extends AbstractModel {
	private String tenLoaiSP;

	public String getTenLoaiSP() {
		return tenLoaiSP;
	}

	public void setTenLoaiSP(String tenLoaiSP) {
		this.tenLoaiSP = tenLoaiSP;
	}

	@Override
	public String toString() {
		return "LoaiSanPhamModel [tenLoaiSP=" + tenLoaiSP + "]";
	}

}
