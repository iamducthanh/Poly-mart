package com.polymart.model;

public class ChiTietHoaDonThanhToanModel extends AbstractModel {
    private Long chiTietSanPham;
    private Long hoaDonThanhToan;
    private Integer soLuong;
    private Integer giamGiaThem;

    public ChiTietHoaDonThanhToanModel() {
    }

    public ChiTietHoaDonThanhToanModel(Long chiTietSanPham, Long hoaDonThanhToan, Integer soLuong, Integer giamGiaThem) {
        this.chiTietSanPham = chiTietSanPham;
        this.hoaDonThanhToan = hoaDonThanhToan;
        this.soLuong = soLuong;
        this.giamGiaThem = giamGiaThem;
    }

    public Long getChiTietSanPham() {
        return chiTietSanPham;
    }

    public void setChiTietSanPham(Long chiTietSanPham) {
        this.chiTietSanPham = chiTietSanPham;
    }

    public Long getHoaDonThanhToan() {
        return hoaDonThanhToan;
    }

    public void setHoaDonThanhToan(Long hoaDonThanhToan) {
        this.hoaDonThanhToan = hoaDonThanhToan;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getGiamGiaThem() {
        return giamGiaThem;
    }

    public void setGiamGiaThem(Integer giamGiaThem) {
        this.giamGiaThem = giamGiaThem;
    }


}
