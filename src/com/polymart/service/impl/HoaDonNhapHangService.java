package com.polymart.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.polymart.dao.IHoaDonNhapHangDAO;
import com.polymart.dao.impl.HoaDonNhapHangDAO;
import com.polymart.model.HoaDonNhapHangModel;
import com.polymart.service.IHoaDonNhapHangService;

public class HoaDonNhapHangService implements IHoaDonNhapHangService {

    private static IHoaDonNhapHangDAO hoaDonNhapHangDAO = new HoaDonNhapHangDAO();
    private static Map<Integer, HoaDonNhapHangModel> mapHoaDonNhapHang = new HashMap<Integer, HoaDonNhapHangModel>();

    static {
        for (HoaDonNhapHangModel x : hoaDonNhapHangDAO.findAll()) {
            mapHoaDonNhapHang.put(x.getId(), x);
        }
    }

    @Override
    public List<HoaDonNhapHangModel> findAll() {
        return new ArrayList<>(mapHoaDonNhapHang.values());
    }

    @Override
    public HoaDonNhapHangModel save(HoaDonNhapHangModel hoaDonNhapHangModel) {
        if (hoaDonNhapHangModel != null) {
            int id = hoaDonNhapHangDAO.save(hoaDonNhapHangModel);
            hoaDonNhapHangModel = hoaDonNhapHangDAO.findById(id);
            mapHoaDonNhapHang.put(id, hoaDonNhapHangModel);
            return hoaDonNhapHangModel;
        }
        return null;
    }

    @Override
    public boolean remove(HoaDonNhapHangModel hoaDonNhapHangModel) {
        if (hoaDonNhapHangModel != null) {
            if (mapHoaDonNhapHang.get(hoaDonNhapHangModel.getId()) != null) {
                if (hoaDonNhapHangDAO.remove(hoaDonNhapHangModel) > 0) {
                    mapHoaDonNhapHang.remove(hoaDonNhapHangModel.getId());
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public HoaDonNhapHangModel findById(Integer id) {
        return mapHoaDonNhapHang.get(id);
    }
}
