package com.polymart.model;

public class SanPhamModel extends AbstractModel {
    private Long idLoaiSP;
    private String tenSP;

    public SanPhamModel() {
    }

    public SanPhamModel(Long idLoaiSP, String tenSP) {
        this.idLoaiSP = idLoaiSP;
        this.tenSP = tenSP;
    }

    Long getIdLoaiSP() {
        return idLoaiSP;
    }

    void setIdLoaiSP(Long idLoaiSP) {
        this.idLoaiSP = idLoaiSP;
    }

    String getTenSP() {
        return tenSP;
    }

    void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }


}
