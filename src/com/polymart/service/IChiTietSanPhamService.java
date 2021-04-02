package com.polymart.service;

import com.polymart.model.ChiTietSanPhamModel;

import java.util.List;

public interface IChiTietSanPhamService {

    List<ChiTietSanPhamModel> findAll();

    List<ChiTietSanPhamModel> findByIdOrNameProduct(String input);

}
