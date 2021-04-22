package com.polymart.service;

import com.polymart.model.SanPhamModel;

import java.util.List;

public interface ISanPhamService {

    List<SanPhamModel> findAll();

    List<SanPhamModel> findByIdLoai(int idLoai);

    SanPhamModel findByID(Integer id);
    
    List<SanPhamModel> searchByID(Integer id);

    SanPhamModel findByNameSPAndNameLoai(String nameSanPham, String nameLoaiSanPham);

    List<SanPhamModel> findByName(String nameSanPham);

    boolean updateSanPham(SanPhamModel sanPhamModel);

    boolean saveSanPham(SanPhamModel sanPhamModel);

}
