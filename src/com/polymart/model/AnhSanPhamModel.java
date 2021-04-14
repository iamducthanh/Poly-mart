package com.polymart.model;

public class AnhSanPhamModel {
    private Integer idSanPham;
    private String tenAnh;
    private Integer idChiTietSanPham;

    public Integer getIdChiTietSanPham() {
        return idChiTietSanPham;
    }

    public void setIdChiTietSanPham(Integer idChiTietSanPham) {
        this.idChiTietSanPham = idChiTietSanPham;
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
