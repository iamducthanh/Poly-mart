package com.polymart.model;

public class ChiTietHoaDonThanhToanModel extends AbstractModel {
    private Integer chiTietSanPham;
    private Integer hoaDonThanhToan;
    private Integer soLuong;
    private Long giamGiaThem;

    public ChiTietHoaDonThanhToanModel() {
    }

    public ChiTietHoaDonThanhToanModel(Integer chiTietSanPham, Integer hoaDonThanhToan, Integer soLuong, Long giamGiaThem) {
        this.chiTietSanPham = chiTietSanPham;
        this.hoaDonThanhToan = hoaDonThanhToan;
        this.soLuong = soLuong;
        this.giamGiaThem = giamGiaThem;
    }

    public Integer getChiTietSanPham() {
        return chiTietSanPham;
    }

    public void setChiTietSanPham(Integer chiTietSanPham) {
        this.chiTietSanPham = chiTietSanPham;
    }

    public Integer getHoaDonThanhToan() {
        return hoaDonThanhToan;
    }

    public void setHoaDonThanhToan(Integer hoaDonThanhToan) {
        this.hoaDonThanhToan = hoaDonThanhToan;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Long getGiamGiaThem() {
        return giamGiaThem;
    }

    public void setGiamGiaThem(Long giamGiaThem) {
        this.giamGiaThem = giamGiaThem;
    }


}
