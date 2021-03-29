package com.polymart.model;

public class ChiTietHoaDonNhapHangModel {
	private Long idHoaDonNhapHang;
	private Long idChiTietSanPham;
	private Long giaNhap;
	private Integer soLuong;

	public ChiTietHoaDonNhapHangModel() {
	}

	public ChiTietHoaDonNhapHangModel(Long idHoaDonNhapHang, Long idChiTietSanPham, Long giaNhap, Integer soLuong) {
		this.idHoaDonNhapHang = idHoaDonNhapHang;
		this.idChiTietSanPham = idChiTietSanPham;
		this.giaNhap = giaNhap;
		this.soLuong = soLuong;
	}

	public Long getIdHoaDonNhapHang() {
		return idHoaDonNhapHang;
	}

	public void setIdHoaDonNhapHang(Long idHoaDonNhapHang) {
		this.idHoaDonNhapHang = idHoaDonNhapHang;
	}

	public Long getIdChiTietSanPham() {
		return idChiTietSanPham;
	}

	public void setIdChiTietSanPham(Long idChiTietSanPham) {
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
