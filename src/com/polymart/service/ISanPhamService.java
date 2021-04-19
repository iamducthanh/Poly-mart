package com.polymart.service;

import com.polymart.model.SanPhamModel;

import java.util.List;

public interface ISanPhamService {

    List<SanPhamModel> findAll();

    List<SanPhamModel> findByIdLoai(int idLoai);

    SanPhamModel findByID(Integer id);

    SanPhamModel findByNameSPAndNameLoai(String nameSanPham, String nameLoaiSanPham);

}
