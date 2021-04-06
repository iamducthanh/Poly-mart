package com.polymart.service.impl;

import com.polymart.dao.IChiTietHoaDonTraHangDAO;
import com.polymart.dao.impl.ChiTietHoaDonTraHangDAO;
import com.polymart.model.ChiTietHoaDonTraHangModel;
import com.polymart.service.IChiTietHoaDonTraHangService;

import java.util.List;
import java.util.stream.Collectors;

public class ChiTietHoaDonTraHangService implements IChiTietHoaDonTraHangService {

    private static IChiTietHoaDonTraHangDAO chiTietHoaDonTraHangDAO = new ChiTietHoaDonTraHangDAO();
    private static List<ChiTietHoaDonTraHangModel> lstChiTietHoaDonTraHangModels = chiTietHoaDonTraHangDAO.findAll();

    @Override
    public boolean save(ChiTietHoaDonTraHangModel chiTietHoaDonTraHangModel) {
        return chiTietHoaDonTraHangDAO.save(chiTietHoaDonTraHangModel);
    }

    @Override
    public List<ChiTietHoaDonTraHangModel> findByIdHoaDonTraHang(int idHoaDonTraHang) {
        return lstChiTietHoaDonTraHangModels.stream().filter(e -> e.getIdHoaDonTraHang().equals(idHoaDonTraHang)).collect(Collectors.toList());
    }

    @Override
    public void reloadData() {
        lstChiTietHoaDonTraHangModels = chiTietHoaDonTraHangDAO.findAll();
    }
}
