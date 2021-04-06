package com.polymart.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.polymart.dao.IChiTietSanPhamDAO;
import com.polymart.dao.impl.ChiTietSanPhamDAO;
import com.polymart.model.ChiTietHoaDonNhapHangModel;
import com.polymart.model.ChiTietHoaDonThanhToanModel;
import com.polymart.model.ChiTietSanPhamModel;
import com.polymart.service.IChiTietSanPhamService;

public class ChiTietSanPhamService implements IChiTietSanPhamService {

    private static IChiTietSanPhamDAO chiTietSanPhamDAO = new ChiTietSanPhamDAO();
    private static List<ChiTietSanPhamModel> lstChiTietSanPhamModels = chiTietSanPhamDAO.findAll();

    @Override
    public List<ChiTietSanPhamModel> findAll() {
        return lstChiTietSanPhamModels.stream().filter(e -> e.getStatus()).collect(Collectors.toList());
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
    public void updateThanhToan(ChiTietHoaDonThanhToanModel chiTietHoaDonThanhToanModel) {
        chiTietSanPhamDAO.updateThanhToan(chiTietHoaDonThanhToanModel);
    }

    @Override
    public void updateTraHang(Integer id, Integer soLuong) {
        chiTietSanPhamDAO.updateTraHang(id, soLuong);
    }

    @Override
    public Integer getIdProductById(Integer id) {
        List<ChiTietSanPhamModel> lstTim = lstChiTietSanPhamModels.stream().filter(e -> e.getId().equals(id))
                .collect(Collectors.toList());
        return lstTim.isEmpty() ? -1 : lstTim.get(0).getIdSanPham();
    }

    @Override
    public void reloadData() {
        lstChiTietSanPhamModels = chiTietSanPhamDAO.findAll();
    }

    @Override
    public ChiTietSanPhamModel getById(Integer id) {
        return lstChiTietSanPhamModels.stream().filter(e -> e.getStatus() && e.getId().equals(id)).collect(Collectors.toList()).get(0);
    }
}
