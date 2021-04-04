package com.polymart.model;

public class ChiTietHoaDonTraHangModel {
	private Integer idHoaDonTraHang;
	private Integer idHoaDonThanhToanChiTiet;
	private Integer soLuong;

	public ChiTietHoaDonTraHangModel() {
	}

	public ChiTietHoaDonTraHangModel(Integer idHoaDonTraHang, Integer idHoaDonThanhToanChiTiet, Integer soLuong) {
		this.idHoaDonTraHang = idHoaDonTraHang;
		this.idHoaDonThanhToanChiTiet = idHoaDonThanhToanChiTiet;
		this.soLuong = soLuong;
	}

	public Integer getIdHoaDonTraHang() {
		return idHoaDonTraHang;
	}

	public void setIdHoaDonTraHang(Integer idHoaDonTraHang) {
		this.idHoaDonTraHang = idHoaDonTraHang;
	}

	public Integer getIdHoaDonThanhToanChiTiet() {
		return idHoaDonThanhToanChiTiet;
	}

	public void setIdHoaDonThanhToanChiTiet(Integer idHoaDonThanhToanChiTiet) {
		this.idHoaDonThanhToanChiTiet = idHoaDonThanhToanChiTiet;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

}
