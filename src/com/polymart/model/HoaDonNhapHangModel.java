package com.polymart.model;

import java.sql.Timestamp;

public class HoaDonNhapHangModel extends AbstractModel {
    private Integer idNhanVienNhap;
    private Integer idNguonHang;
    private Timestamp ngayNhap;
    private String ghiChu;

    public HoaDonNhapHangModel() {
    }

    public HoaDonNhapHangModel(Integer idNhanVienNhap, Integer idNguonHang, Timestamp ngayNhap, String ghiChu) {
        this.idNhanVienNhap = idNhanVienNhap;
        this.idNguonHang = idNguonHang;
        this.ngayNhap = ngayNhap;
        this.ghiChu = ghiChu;
    }

    public Integer getIdNhanVienNhap() {
        return idNhanVienNhap;
    }

    public void setIdNhanVienNhap(Integer idNhanVienNhap) {
        this.idNhanVienNhap = idNhanVienNhap;
    }

    public Integer getIdNguonHang() {
        return idNguonHang;
    }

    public void setIdNguonHang(Integer idNguonHang) {
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
