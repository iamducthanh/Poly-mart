package com.polymart.service.impl;

import com.polymart.dao.IChiTietHoaDonNhapHangDAO;
import com.polymart.dao.IHoaDonNhapHangDAO;
import com.polymart.dao.impl.ChiTietHoaDonNhapHangDAO;
import com.polymart.dao.impl.HoaDonNhapHangDAO;
import com.polymart.model.ChiTietHoaDonNhapHangModel;
import com.polymart.model.HoaDonNhapHangModel;
import com.polymart.service.IHoaDonNhapHangService;

import java.util.List;

public class HoaDonNhapHangService implements IHoaDonNhapHangService {

    private IHoaDonNhapHangDAO hoaDonNhapHangDAO = new HoaDonNhapHangDAO();
    private IChiTietHoaDonNhapHangDAO chiTietHoaDonNhapHangDAO = new ChiTietHoaDonNhapHangDAO();

    @Override
    public boolean save(HoaDonNhapHangModel hoaDonNhapHangModel,
                        List<ChiTietHoaDonNhapHangModel> lstChiTietHoaDonNhapHangModel) {
        if (hoaDonNhapHangModel != null &&
                lstChiTietHoaDonNhapHangModel != null && !lstChiTietHoaDonNhapHangModel.isEmpty()) {
            int id = hoaDonNhapHangDAO.save(hoaDonNhapHangModel);
            if (id > 0) {
                return chiTietHoaDonNhapHangDAO.save(id, lstChiTietHoaDonNhapHangModel);
            }
        }
        return false;
    }
}
