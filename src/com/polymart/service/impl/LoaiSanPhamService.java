package com.polymart.service.impl;

import com.polymart.dao.ILoaiSanPhamDAO;
import com.polymart.dao.impl.LoaiSanPhamDAO;
import com.polymart.model.LoaiSanPhamModel;
import com.polymart.service.ILoaiSanPhamService;

import java.util.List;
import java.util.stream.Collectors;

public class LoaiSanPhamService implements ILoaiSanPhamService {

    private static ILoaiSanPhamDAO loaiSanPhamDAO = new LoaiSanPhamDAO();
    private static List<LoaiSanPhamModel> lstLoaiSanPham = loaiSanPhamDAO.findAll();

    @Override
    public String findNameById(Integer id) {
        List<LoaiSanPhamModel> lst = lstLoaiSanPham.stream().filter(e -> e.getId() == id).collect(Collectors.toList());
        return lst.isEmpty() ? null : lst.get(0).getTenLoaiSP();
    }
}
