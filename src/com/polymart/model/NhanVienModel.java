package com.polymart.model;

import java.util.Date;

public class NhanVienModel extends AbstractModel {
    private String hoTen;
    private Date ngaySinh;
    private String diaChi;
    private String sdt;
    private String chucVu;
    private String matKhau;
    private String email;
    private Boolean gioiTinh;
    private Long luong;
    private String anhDaiDien;

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
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

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Long getLuong() {
        return luong;
    }

    public void setLuong(Long luong) {
        this.luong = luong;
    }

    public String getAnhDaiDien() {
        return anhDaiDien;
    }

    public void setAnhDaiDien(String anhDaiDien) {
        this.anhDaiDien = anhDaiDien;
    }

	@Override
	public String toString() {
		return "NhanVienModel [ID = " + "\nhoTen=" + hoTen + "\nngaySinh=" + ngaySinh + "\ndiaChi=" + diaChi + "\nSDT=" + sdt
				+ "\nchucVu=" + chucVu + "\nmatKhau=" + matKhau + "\nemail=" + email + "\ngioiTinh=" + gioiTinh
				+ "\nluong=" + luong + "\nanhDaiDien=" + anhDaiDien + "]";
	}

    
}
