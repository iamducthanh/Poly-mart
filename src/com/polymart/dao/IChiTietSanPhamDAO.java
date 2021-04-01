package com.polymart.dao;

import com.polymart.model.ChiTietSanPhamModel;

import java.util.List;

public interface IChiTietSanPhamDAO extends GenericDAO<ChiTietSanPhamModel> {
    List<ChiTietSanPhamModel> findAll();
}
