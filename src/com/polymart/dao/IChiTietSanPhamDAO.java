package com.polymart.dao;

import java.util.List;

import com.polymart.model.ChiTietSanPhamModel;

public interface IChiTietSanPhamDAO extends GenericDAO<ChiTietSanPhamModel> {
    List<ChiTietSanPhamModel> findAll();

    List<ChiTietSanPhamModel> findByIdOrNameProduct(String input);

    int save(ChiTietSanPhamModel chiTietSanPhamModel);

    boolean updatePrice(int id, Long giaBan, Long giaGiam);
}
