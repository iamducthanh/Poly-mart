package com.polymart.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.polymart.dao.IHoaDonNhapHangDAO;
import com.polymart.dao.impl.HoaDonNhapHangDAO;
import com.polymart.model.HoaDonNhapHangModel;
import com.polymart.service.IHoaDonNhapHangService;

public class HoaDonNhapHangService implements IHoaDonNhapHangService {

    private static IHoaDonNhapHangDAO hoaDonNhapHangDAO = new HoaDonNhapHangDAO();
    private static List<HoaDonNhapHangModel> lstHoaDonNhapHangModels = hoaDonNhapHangDAO.findAll();

    @Override
    public List<HoaDonNhapHangModel> findAll() {
        Collections.reverse(lstHoaDonNhapHangModels);
        return lstHoaDonNhapHangModels;
    }

    @Override
    public HoaDonNhapHangModel save(HoaDonNhapHangModel hoaDonNhapHangModel) {
        if (hoaDonNhapHangModel != null) {
            int id = hoaDonNhapHangDAO.save(hoaDonNhapHangModel);
            hoaDonNhapHangModel = hoaDonNhapHangDAO.findById(id);
            if (hoaDonNhapHangModel != null) {
                lstHoaDonNhapHangModels.add(hoaDonNhapHangModel);
                return hoaDonNhapHangModel;
            }
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
        var ref = new Object() {
            HoaDonNhapHangModel hoaDonNhapHangModel = null;
        };
        lstHoaDonNhapHangModels.forEach(e -> {
            if (e.getId().equals(id)) {
                ref.hoaDonNhapHangModel = e;
            }
        });
        return ref.hoaDonNhapHangModel;
    }

    @Override
    public List<HoaDonNhapHangModel> filterByDate(Timestamp timestamp) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        return lstHoaDonNhapHangModels.stream()
                .filter(e -> simpleDateFormat.format(e.getNgayNhap()).equals(simpleDateFormat.format(timestamp)) && e.isRemove())
                .collect(Collectors.toList());
    }
}
