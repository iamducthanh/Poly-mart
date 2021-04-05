package com.polymart.service.impl;

import com.polymart.dao.IChiTietHoaDonTraHangDAO;
import com.polymart.dao.impl.ChiTietHoaDonTraHangDAO;
import com.polymart.model.ChiTietHoaDonTraHangModel;
import com.polymart.service.IChiTietHoaDonTraHangService;

public class ChiTietHoaDonTraHangService implements IChiTietHoaDonTraHangService {

    private static IChiTietHoaDonTraHangDAO chiTietHoaDonTraHangDAO = new ChiTietHoaDonTraHangDAO();

    @Override
    public boolean save(ChiTietHoaDonTraHangModel chiTietHoaDonTraHangModel) {
        return chiTietHoaDonTraHangDAO.save(chiTietHoaDonTraHangModel);
    }
}
