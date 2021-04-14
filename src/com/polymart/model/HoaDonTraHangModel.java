package com.polymart.model;

import java.sql.Timestamp;

public class HoaDonTraHangModel extends AbstractModel {
    private Integer idNhanVien;
    private Timestamp ngayTraHang;
    private String ghiChu;
    private boolean remove;

    public boolean isRemove() {
        return remove;
    }

    public void setRemove(boolean remove) {
        this.remove = remove;
    }

    public Integer getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(Integer idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public Timestamp getNgayTraHang() {
        return ngayTraHang;
    }

    public void setNgayTraHang(Timestamp ngayTraHang) {
        this.ngayTraHang = ngayTraHang;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

}
