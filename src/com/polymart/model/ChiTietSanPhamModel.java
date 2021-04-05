package com.polymart.model;

import java.sql.Timestamp;

public class ChiTietSanPhamModel extends AbstractModel {
	private Integer idSanPham;
	private String mauSac;
	private String size;
	private Integer soLuong;
	private Long giaBan;
	private Long giaVon;
	private Long giaGiam;
	private Timestamp ngayCapNhat;
	private Boolean status;

	public Integer getIdSanPham() {
		return idSanPham;
	}

	public void setIdSanPham(Integer idSanPham) {
		this.idSanPham = idSanPham;
	}

	public String getMauSac() {
		return mauSac;
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public Long getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(Long giaBan) {
		this.giaBan = giaBan;
	}

	public Long getGiaVon() {
		return giaVon;
	}

	public void setGiaVon(Long giaVon) {
		this.giaVon = giaVon;
	}

	public Long getGiaGiam() {
		return giaGiam;
	}

	public void setGiaGiam(Long giaGiam) {
		this.giaGiam = giaGiam;
	}

	public Timestamp getNgayCapNhat() {
		return ngayCapNhat;
	}

	public void setNgayCapNhat(Timestamp ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
