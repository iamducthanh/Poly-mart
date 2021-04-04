package com.polymart.dao;

import com.polymart.model.HoaDonThanhToanModel;

import java.util.List;

public interface IHoaDonThanhToanDAO extends GenericDAO<HoaDonThanhToanModel> {

    List<HoaDonThanhToanModel> findAll();

    Integer save(HoaDonThanhToanModel hoaDonThanhToanModel);

    Integer remove(HoaDonThanhToanModel hoaDonThanhToanModel);

}
