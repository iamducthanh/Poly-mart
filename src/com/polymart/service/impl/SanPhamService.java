package com.polymart.service.impl;

import com.polymart.dao.ISanPhamDAO;
import com.polymart.dao.impl.SanPhamDAO;
import com.polymart.model.SanPhamModel;
import com.polymart.service.ISanPhamService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SanPhamService implements ISanPhamService {

    private static ISanPhamDAO iSanPhamDAO = new SanPhamDAO();
    private static Map<Integer, SanPhamModel> mapSanPham = new HashMap<Integer, SanPhamModel>();    //Nạp dữ liệu từ SQL

    static {
        initSanPham();
    }

    private static void initSanPham() {
        for (SanPhamModel sanPham : iSanPhamDAO.findAll()) {
            mapSanPham.put(sanPham.getId(), sanPham);
        }
    }

    @Override
    public List<SanPhamModel> findAll() {
        return new ArrayList<>(mapSanPham.values());
    }

    @Override
    public SanPhamModel findByID(Integer id) {
        return mapSanPham.get(id);
    }
}
