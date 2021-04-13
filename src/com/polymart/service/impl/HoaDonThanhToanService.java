package com.polymart.service.impl;

import com.polymart.dao.IHoaDonThanhToanDAO;
import com.polymart.dao.impl.HoaDonThanhToanDAO;
import com.polymart.model.HoaDonThanhToanModel;
import com.polymart.service.IHoaDonThanhToanService;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HoaDonThanhToanService implements IHoaDonThanhToanService {

    private static IHoaDonThanhToanDAO hoaDonThanhToanDAO = new HoaDonThanhToanDAO();
    private static List<HoaDonThanhToanModel> lstHoaDonThanhToanModels = hoaDonThanhToanDAO.findAll();

    @Override
    public List<HoaDonThanhToanModel> findAll() {
        Collections.reverse(lstHoaDonThanhToanModels);
        return lstHoaDonThanhToanModels;
    }

    @Override
    public HoaDonThanhToanModel findById(int id) {
        var ref = new Object() {
            HoaDonThanhToanModel hoaDonThanhToanModel = null;
        };
        lstHoaDonThanhToanModels.forEach(e -> {
            if (e.getId().equals(id) && e.isRemove()) {
                ref.hoaDonThanhToanModel = e;
            }
        });
        return ref.hoaDonThanhToanModel;
    }

    @Override
    public HoaDonThanhToanModel save(HoaDonThanhToanModel hoaDonThanhToanModel) {
        int id = hoaDonThanhToanDAO.save(hoaDonThanhToanModel);
        hoaDonThanhToanModel = hoaDonThanhToanDAO.findById(id);
        if (hoaDonThanhToanModel != null) {
            lstHoaDonThanhToanModels.add(hoaDonThanhToanModel);
            return hoaDonThanhToanModel;
        }
        return null;
    }

    @Override
    public boolean remove(HoaDonThanhToanModel hoaDonThanhToanModel) {
        if (hoaDonThanhToanDAO.remove(hoaDonThanhToanModel) > 0) {
            lstHoaDonThanhToanModels.remove(hoaDonThanhToanModel);
            return true;
        }
        return false;
    }

    @Override
    public List<HoaDonThanhToanModel> filterByDate(Timestamp timestamp) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        return lstHoaDonThanhToanModels.stream()
                .filter(e -> simpleDateFormat.format(e.getNgayThanhToan()).equals(simpleDateFormat.format(timestamp)) && e.isRemove())
                .collect(Collectors.toList());
    }
}
