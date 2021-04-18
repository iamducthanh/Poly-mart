package com.polymart.service.impl;

import com.polymart.dao.ISanPhamDAO;
import com.polymart.dao.impl.SanPhamDAO;
import com.polymart.model.SanPhamModel;
import com.polymart.service.ISanPhamService;

import java.util.*;
import java.util.stream.Collectors;

public class SanPhamService implements ISanPhamService {

    private static ISanPhamDAO sanPhamDAO = new SanPhamDAO();
    private static List<SanPhamModel> lstSanPham = sanPhamDAO.findAll();

    @Override
    public List<SanPhamModel> findAll() {
        return lstSanPham;
    }

    @Override
    public List<SanPhamModel> findByIdLoai(int idLoai) {
        return lstSanPham.stream().filter(e -> e.getIdLoaiSP().equals(idLoai)).collect(Collectors.toList());
    }

    @Override
    public SanPhamModel findByID(Integer id) {
        var ref = new Object() {
            SanPhamModel sanPhamModel = null;
        };
        lstSanPham.forEach(e -> {
            if (e.getId().equals(id)) {
                ref.sanPhamModel = e;
            }
        });
        return ref.sanPhamModel;
    }
}
