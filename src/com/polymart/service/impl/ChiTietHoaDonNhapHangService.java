package com.polymart.service.impl;

import com.polymart.dao.IChiTietHoaDonNhapHangDAO;
import com.polymart.dao.impl.ChiTietHoaDonNhapHangDAO;
import com.polymart.model.ChiTietHoaDonNhapHangModel;
import com.polymart.service.IChiTietHoaDonNhapHangService;

import java.util.List;

public class ChiTietHoaDonNhapHangService implements IChiTietHoaDonNhapHangService {

    private IChiTietHoaDonNhapHangDAO chiTietHoaDonNhapHangDAO = new ChiTietHoaDonNhapHangDAO();
//    private List<ChiTietHoaDonNhapHangModel> lstChiTietHoaDonNhapHangModels = new

    @Override
    public List<ChiTietHoaDonNhapHangModel> findByIdHoaDonNhap(Integer idHoaDonNhap) {
        return null;
    }

    @Override
    public boolean save(ChiTietHoaDonNhapHangModel chiTietHoaDonNhapHangModel) {
        return chiTietHoaDonNhapHangDAO.save(chiTietHoaDonNhapHangModel);
    }
}
