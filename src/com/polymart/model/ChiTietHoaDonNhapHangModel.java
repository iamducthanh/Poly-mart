package com.polymart.model;

public class ChiTietHoaDonNhapHangModel {
	private Integer idHoaDonNhapHang;
	private Integer idChiTietSanPham;
	private Long giaNhap;
	private Integer soLuong;

	public Integer getIdHoaDonNhapHang() {
		return idHoaDonNhapHang;
	}

	public void setIdHoaDonNhapHang(Integer idHoaDonNhapHang) {
		this.idHoaDonNhapHang = idHoaDonNhapHang;
	}

	public Integer getIdChiTietSanPham() {
		return idChiTietSanPham;
	}

	public void setIdChiTietSanPham(Integer idChiTietSanPham) {
		this.idChiTietSanPham = idChiTietSanPham;
	}

	public Long getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(Long giaNhap) {
		this.giaNhap = giaNhap;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

}
