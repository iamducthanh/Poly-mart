package com.polymart.dao;

import com.polymart.model.HoaDonTraHangModel;

import java.util.List;

public interface IHoaDonTraHangDAO extends GenericDAO<HoaDonTraHangModel> {

    Object[] getDataTableTraHang(int id);

    List<HoaDonTraHangModel> findAll();

    int save(HoaDonTraHangModel hoaDonTraHangModel);

    boolean remove(HoaDonTraHangModel hoaDonTraHangModel);

    HoaDonTraHangModel findById(Integer id);

}
