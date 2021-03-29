package com.polymart.model;

public class KhachHangModel extends AbstractModel {
    private String hoTen;
    private String sdt;
    private String diaChi;
    private Integer tichDiem;

    public KhachHangModel() {
    }

    public KhachHangModel(String hoTen, String sdt, String diaChi, Integer tichDiem) {
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.tichDiem = tichDiem;
    }

    String getHoTen() {
        return hoTen;
    }

    void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    String getSdt() {
        return sdt;
    }

    void setSdt(String sdt) {
        this.sdt = sdt;
    }

    String getDiaChi() {
        return diaChi;
    }

    void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    Integer getTichDiem() {
        return tichDiem;
    }

    void setTichDiem(Integer tichDiem) {
        this.tichDiem = tichDiem;
    }


}
