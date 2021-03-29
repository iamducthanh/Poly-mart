package com.polymart.model;

public class LoaiSanPhamModel extends AbstractModel {
    private String tenLoaiSP;

    public LoaiSanPhamModel() {
    }

    public LoaiSanPhamModel(String tenLoaiSP) {
        this.tenLoaiSP = tenLoaiSP;
    }

    String getTenLoaiSP() {
        return tenLoaiSP;
    }

    void setTenLoaiSP(String tenLoaiSP) {
        this.tenLoaiSP = tenLoaiSP;
    }


}
