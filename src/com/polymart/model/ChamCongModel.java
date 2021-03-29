package com.polymart.model;

import java.sql.Timestamp;

public class ChamCongModel {
    private Long idNhanVien;
    private Timestamp ngayChamCong;

    public ChamCongModel() {
    }

    public ChamCongModel(Long idNhanVien, Timestamp ngayChamCong) {
        this.idNhanVien = idNhanVien;
        this.ngayChamCong = ngayChamCong;
    }

    public Long getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(Long idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public Timestamp getNgayChamCong() {
        return ngayChamCong;
    }

    public void setNgayChamCong(Timestamp ngayChamCong) {
        this.ngayChamCong = ngayChamCong;
    }


}
