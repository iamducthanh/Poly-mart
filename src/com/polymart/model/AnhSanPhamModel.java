package com.polymart.model;

public class AnhSanPhamModel {
    private Long idSanPham;
    private String tenAnh;

    public AnhSanPhamModel() {
    }

    public AnhSanPhamModel(Long idSanPham, String tenAnh) {
        this.idSanPham = idSanPham;
        this.tenAnh = tenAnh;
    }

    public Long getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Long idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTenAnh() {
        return tenAnh;
    }

    public void setTenAnh(String tenAnh) {
        this.tenAnh = tenAnh;
    }


}
