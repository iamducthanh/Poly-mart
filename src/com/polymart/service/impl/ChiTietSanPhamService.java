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

public class ChiTietSanPhamService implements IChiTietSanPhamService {

    private static IChiTietSanPhamDAO chiTietSanPhamDAO = new ChiTietSanPhamDAO();
    private static Map<Integer, ChiTietSanPhamModel> mapChiTietSanPham = new HashMap<Integer, ChiTietSanPhamModel>();    //Nạp dữ liệu từ SQL

    static {
        initChiTietSanPham();
    }

    private static void initChiTietSanPham() {
        for (ChiTietSanPhamModel x : chiTietSanPhamDAO.findAll()) {
            mapChiTietSanPham.put(x.getId(), x);
        }
    }

    @Override
    public List<ChiTietSanPhamModel> findAll() {
        return new ArrayList<>(mapChiTietSanPham.values());
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
}
