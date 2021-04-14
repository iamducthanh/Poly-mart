package com.polymart.model;

import java.sql.Timestamp;

public class HoaDonThanhToanModel extends AbstractModel {
    private Integer idKhachHang;
    private Integer idNhanVien;
    private Integer diemDaDoi;
    private Timestamp ngayThanhToan;
    private String ghiChu;
    private int traHang;
    private boolean remove;

    public int getTraHang() {
        return traHang;
    }

    public void setTraHang(int traHang) {
        this.traHang = traHang;
    }

    public boolean isRemove() {
        return remove;
    }

    public void setRemove(boolean remove) {
        this.remove = remove;
    }

    public Integer getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(Integer idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public Integer getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(Integer idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public Integer getDiemDaDoi() {
        return diemDaDoi;
    }

    public void setDiemDaDoi(Integer diemDaDoi) {
        this.diemDaDoi = diemDaDoi;
    }

    public Timestamp getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Timestamp ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

}
