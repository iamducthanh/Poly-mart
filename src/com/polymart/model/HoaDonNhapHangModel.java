package com.polymart.model;

import java.sql.Timestamp;

public class HoaDonNhapHangModel extends AbstractModel {
    private Long idNhanVienNhap;
    private Long idNguonHang;
    private Timestamp ngayNhap;
    private String ghiChu;

    public HoaDonNhapHangModel() {
    }

    public HoaDonNhapHangModel(Long idNhanVienNhap, Long idNguonHang, Timestamp ngayNhap, String ghiChu) {
        this.idNhanVienNhap = idNhanVienNhap;
        this.idNguonHang = idNguonHang;
        this.ngayNhap = ngayNhap;
        this.ghiChu = ghiChu;
    }

    public Long getIdNhanVienNhap() {
        return idNhanVienNhap;
    }

    public void setIdNhanVienNhap(Long idNhanVienNhap) {
        this.idNhanVienNhap = idNhanVienNhap;
    }

    public Long getIdNguonHang() {
        return idNguonHang;
    }

    public void setIdNguonHang(Long idNguonHang) {
        this.idNguonHang = idNguonHang;
    }

    public Timestamp getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Timestamp ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }


}
