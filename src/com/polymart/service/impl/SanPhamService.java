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
            if (String.valueOf(e.getId()).contains(String.valueOf(id))) {
                ref.sanPhamModel = e;
            }
        });
        return ref.sanPhamModel;
    }

    @Override
    public SanPhamModel findByNameSPAndNameLoai(String nameSanPham, String nameLoaiSanPham) {
        List<SanPhamModel> lstTimKiem = sanPhamDAO.findByNameSPAndNameLoai(nameSanPham, nameLoaiSanPham);
        return lstTimKiem.isEmpty() ? null : lstTimKiem.get(0);
    }

    @Override
    public List<SanPhamModel> findByName(String nameSanPham) {
        return lstSanPham.stream().filter(e -> e.getTenSP().toLowerCase().contains(nameSanPham.toLowerCase())).collect(Collectors.toList()); 
    }

    @Override
    public boolean updateSanPham(SanPhamModel sanPhamModel) {
        if (sanPhamModel != null) {
            if (sanPhamDAO.update(sanPhamModel)) {
                lstSanPham = sanPhamDAO.findAll();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean saveSanPham(SanPhamModel sanPhamModel) {
        if (sanPhamModel != null) {
            if (sanPhamDAO.save(sanPhamModel)) {
                lstSanPham = sanPhamDAO.findAll();
                return true;
            }
        }
        return false;
    }

	@Override
	public List<SanPhamModel> searchByID(Integer id) {
	        return lstSanPham.stream().filter(e -> String.valueOf(e.getId()).toLowerCase().contains(String.valueOf(id))).collect(Collectors.toList());
	    
	}
}
