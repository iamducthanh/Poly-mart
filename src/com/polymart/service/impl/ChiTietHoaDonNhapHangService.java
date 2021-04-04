package com.polymart.service.impl;

import com.polymart.dao.IChiTietHoaDonNhapHangDAO;
import com.polymart.dao.impl.ChiTietHoaDonNhapHangDAO;
import com.polymart.model.ChiTietHoaDonNhapHangModel;
import com.polymart.service.IChiTietHoaDonNhapHangService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChiTietHoaDonNhapHangService implements IChiTietHoaDonNhapHangService {

    private static IChiTietHoaDonNhapHangDAO chiTietHoaDonNhapHangDAO = new ChiTietHoaDonNhapHangDAO();
    private static List<ChiTietHoaDonNhapHangModel> lstChiTietHoaDonNhapHangModels = chiTietHoaDonNhapHangDAO.findAll();

    @Override
    public List<ChiTietHoaDonNhapHangModel> findByIdHoaDonNhap(Integer idHoaDonNhap) {
        return lstChiTietHoaDonNhapHangModels.stream().filter(e -> e.getIdHoaDonNhapHang() == idHoaDonNhap).collect(Collectors.toList());
    }

    @Override
    public boolean save(ChiTietHoaDonNhapHangModel chiTietHoaDonNhapHangModel) {
        if (chiTietHoaDonNhapHangDAO.save(chiTietHoaDonNhapHangModel)) {
            lstChiTietHoaDonNhapHangModels.add(chiTietHoaDonNhapHangModel);
            return true;
        }
        return false;
    }

    @Override
    public void reloadData() {
        lstChiTietHoaDonNhapHangModels = chiTietHoaDonNhapHangDAO.findAll();
    }
}
