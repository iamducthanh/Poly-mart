package com.polymart.service.impl;

import com.polymart.dao.IChiTietSanPhamDAO;
import com.polymart.dao.impl.ChiTietSanPhamDAO;
import com.polymart.model.ChiTietSanPhamModel;
import com.polymart.model.SanPhamModel;
import com.polymart.service.IChiTietSanPhamService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChiTietSanPhamService implements IChiTietSanPhamService {

    private static IChiTietSanPhamDAO iChiTietSanPhamService = new ChiTietSanPhamDAO();
    private static Map<Integer, ChiTietSanPhamModel> mapChiTietSanPham = new HashMap<Integer, ChiTietSanPhamModel>();    //Nạp dữ liệu từ SQL

    static {
        initChiTietSanPham();
    }

    private static void initChiTietSanPham() {
        for (ChiTietSanPhamModel x: iChiTietSanPhamService.findAll()) {
            mapChiTietSanPham.put(x.getId(), x);
        }
    }

    @Override
    public List<ChiTietSanPhamModel> findAll() {
        return null;
    }
}
