package com.polymart.service;

import java.util.List;

import com.polymart.model.ChiTietSanPhamModel;
import com.polymart.model.UpdatePhotoProduct;

public interface IChiTietSanPhamService {

    List<ChiTietSanPhamModel> findAll();

    List<ChiTietSanPhamModel> findByIdOrNameProduct(String input);

    List<ChiTietSanPhamModel> findAllByHoaDonThanhToan();

    int saveProduct(List<ChiTietSanPhamModel> lstChiTietSanPham, List<UpdatePhotoProduct> lstPhoto);

    Integer getIdProductById(Integer id);

    void reloadData();

    ChiTietSanPhamModel getById(Integer id);

    boolean updatePrice(int id, Long giaBan, Long giaGiam);

    boolean checkThemMoiSanPham(ChiTietSanPhamModel chiTietSanPhamModel);

}
