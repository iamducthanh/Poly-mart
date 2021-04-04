package com.polymart.service.impl;

import com.polymart.dao.IChiTietHoaDonNhapHangDAO;
import com.polymart.dao.IChiTietSanPhamDAO;
import com.polymart.dao.IHoaDonNhapHangDAO;
import com.polymart.dao.impl.ChiTietHoaDonNhapHangDAO;
import com.polymart.dao.impl.ChiTietSanPhamDAO;
import com.polymart.dao.impl.HoaDonNhapHangDAO;
import com.polymart.model.ChiTietHoaDonNhapHangModel;
import com.polymart.model.HoaDonNhapHangModel;
import com.polymart.service.IHoaDonNhapHangService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HoaDonNhapHangService implements IHoaDonNhapHangService {

    private static IHoaDonNhapHangDAO hoaDonNhapHangDAO = new HoaDonNhapHangDAO();
    private static List<HoaDonNhapHangModel> lstHoaDonNhapHangModels = hoaDonNhapHangDAO.findAll();

    @Override
    public List<HoaDonNhapHangModel> findAll() {
        return lstHoaDonNhapHangModels;
    }

    @Override
    public HoaDonNhapHangModel save(HoaDonNhapHangModel hoaDonNhapHangModel) {
        if (hoaDonNhapHangModel != null) {
            int id = hoaDonNhapHangDAO.save(hoaDonNhapHangModel);
            hoaDonNhapHangModel = hoaDonNhapHangDAO.findById(id);
            lstHoaDonNhapHangModels.add(hoaDonNhapHangModel);
            return hoaDonNhapHangModel;
        }
        return null;
    }

    @Override
    public boolean remove(HoaDonNhapHangModel hoaDonNhapHangModel) {
        if (hoaDonNhapHangModel != null) {
            if (hoaDonNhapHangDAO.remove(hoaDonNhapHangModel) > 0) {
                lstHoaDonNhapHangModels.remove(hoaDonNhapHangModel);
                return true;
            }
        }
        return false;
    }

    @Override
    public HoaDonNhapHangModel findById(Integer id) {
        List<HoaDonNhapHangModel> lst = lstHoaDonNhapHangModels.stream().filter(e -> e.getId() == id).collect(Collectors.toList());
        return lst.isEmpty() ? null : lst.get(0);
    }
}
