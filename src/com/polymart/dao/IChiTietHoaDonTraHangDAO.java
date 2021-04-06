package com.polymart.dao;

import com.polymart.model.ChiTietHoaDonTraHangModel;

import java.util.List;

public interface IChiTietHoaDonTraHangDAO extends GenericDAO<ChiTietHoaDonTraHangModel> {

    List<ChiTietHoaDonTraHangModel> findAll();

    boolean save(ChiTietHoaDonTraHangModel chiTietHoaDonTraHangModel);

}
