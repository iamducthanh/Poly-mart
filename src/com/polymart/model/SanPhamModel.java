package com.polymart.model;

public class SanPhamModel extends AbstractModel {
    private Integer idLoaiSP;
    private String tenSP;
    private String moTa;

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getIdLoaiSP() {
        return idLoaiSP;
    }

    public void setIdLoaiSP(Integer idLoaiSP) {
        this.idLoaiSP = idLoaiSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

}
