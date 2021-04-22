package com.polymart.service;

import com.polymart.model.LoaiSanPhamModel;

import java.util.List;

public interface ILoaiSanPhamService {
    List<LoaiSanPhamModel> findAll();

    String findNameById(Integer id);

    List<LoaiSanPhamModel> findById(Integer id);

    boolean saveLoaiSanPham(LoaiSanPhamModel loaiSanPhamModel);

    boolean findByName(String nameLoaiSanPham);

}
