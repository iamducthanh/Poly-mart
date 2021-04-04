package com.polymart.service.impl;

import com.polymart.dao.IChiTietSanPhamDAO;
import com.polymart.dao.impl.ChiTietSanPhamDAO;
import com.polymart.model.ChiTietHoaDonNhapHangModel;
import com.polymart.model.ChiTietSanPhamModel;
import com.polymart.service.IChiTietSanPhamService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ChiTietSanPhamService implements IChiTietSanPhamService {

    private static IChiTietSanPhamDAO chiTietSanPhamDAO = new ChiTietSanPhamDAO();
    private static List<ChiTietSanPhamModel> lstChiTietSanPhamModels = chiTietSanPhamDAO.findAll();

    @Override
    public List<ChiTietSanPhamModel> findAll() {
        return lstChiTietSanPhamModels;
    }

    // tìm kiếm theo mã hoặc tên sản phẩm
    @Override
    public List<ChiTietSanPhamModel> findByIdOrNameProduct(String input) {
        return chiTietSanPhamDAO.findByIdOrNameProduct(input);
    }

    @Override
    public void updateNhapHang(ChiTietHoaDonNhapHangModel chiTietHoaDonNhapHangModel) {
        chiTietSanPhamDAO.updateNhapHang(chiTietHoaDonNhapHangModel);
    }

    @Override
    public Integer getIdProductById(Integer id) {
        List<ChiTietSanPhamModel> lstTim = lstChiTietSanPhamModels.stream().filter(e -> e.getId().toString().equals(id.toString()))
                .collect(Collectors.toList());
        return lstTim.isEmpty() ? -1 : lstTim.get(0).getIdSanPham();
    }

    @Override
    public void reloadData() {
        lstChiTietSanPhamModels = chiTietSanPhamDAO.findAll();
    }
}
