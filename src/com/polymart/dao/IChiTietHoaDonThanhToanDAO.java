package com.polymart.dao;

import com.polymart.model.ChiTietHoaDonThanhToanModel;

import java.util.List;

public interface IChiTietHoaDonThanhToanDAO extends GenericDAO<ChiTietHoaDonThanhToanModel> {

    List<ChiTietHoaDonThanhToanModel> findAll();

    ChiTietHoaDonThanhToanModel save(ChiTietHoaDonThanhToanModel chiTietHoaDonThanhToanModel);

    boolean update(ChiTietHoaDonThanhToanModel chiTietHoaDonThanhToanModel);

}
