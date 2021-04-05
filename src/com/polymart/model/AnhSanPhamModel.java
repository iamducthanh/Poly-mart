package com.polymart.model;

public class AnhSanPhamModel {
	private Integer idSanPham;
	private String tenAnh;

	public AnhSanPhamModel() {
	}

	public AnhSanPhamModel(Integer idSanPham, String tenAnh) {
		this.idSanPham = idSanPham;
		this.tenAnh = tenAnh;
	}

	public Integer getIdSanPham() {
		return idSanPham;
	}

	public void setIdSanPham(Integer idSanPham) {
		this.idSanPham = idSanPham;
	}

	public String getTenAnh() {
		return tenAnh;
	}

	public void setTenAnh(String tenAnh) {
		this.tenAnh = tenAnh;
	}

}
