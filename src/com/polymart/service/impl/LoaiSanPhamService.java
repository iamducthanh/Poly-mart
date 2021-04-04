package com.polymart.service.impl;

import com.polymart.dao.ILoaiSanPhamDAO;
import com.polymart.dao.impl.LoaiSanPhamDAO;
import com.polymart.model.LoaiSanPhamModel;
import com.polymart.service.ILoaiSanPhamService;

import java.util.HashMap;
import java.util.Map;

public class LoaiSanPhamService implements ILoaiSanPhamService {

    private static ILoaiSanPhamDAO loaiSanPhamDAO = new LoaiSanPhamDAO();
    private static Map<Integer, LoaiSanPhamModel> mapLoaiSanPham = new HashMap<Integer, LoaiSanPhamModel>();

    static {
    	for (LoaiSanPhamModel x : loaiSanPhamDAO.findAll()) {
            mapLoaiSanPham.put(x.getId(), x);
        }
    }

    @Override
    public String findNameById(Integer id) {
        return mapLoaiSanPham.get(id) == null ? null : mapLoaiSanPham.get(id).getTenLoaiSP();
    }
}
