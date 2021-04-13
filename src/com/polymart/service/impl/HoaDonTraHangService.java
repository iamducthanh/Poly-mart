package com.polymart.service.impl;

import com.polymart.dao.IHoaDonTraHangDAO;
import com.polymart.dao.impl.HoaDonTraHangDAO;
import com.polymart.model.HoaDonTraHangModel;
import com.polymart.service.IHoaDonTraHangService;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HoaDonTraHangService implements IHoaDonTraHangService {

    private static IHoaDonTraHangDAO hoaDonTraHangDAO = new HoaDonTraHangDAO();
    private static List<HoaDonTraHangModel> lstHoaDonTraHangModels = hoaDonTraHangDAO.findAll();

    @Override
    public Object[] getDataTableById(Integer id) {
        return hoaDonTraHangDAO.getDataTableTraHang(id);
    }

    @Override
    public List<HoaDonTraHangModel> findAll() {
        Collections.reverse(lstHoaDonTraHangModels);
        return lstHoaDonTraHangModels;
    }

    @Override
    public HoaDonTraHangModel save(HoaDonTraHangModel hoaDonTraHangModel) {
        if (hoaDonTraHangModel != null) {
            int id = hoaDonTraHangDAO.save(hoaDonTraHangModel);
            hoaDonTraHangModel = hoaDonTraHangDAO.findById(id);
            if (hoaDonTraHangModel != null) {
                lstHoaDonTraHangModels.add(hoaDonTraHangModel);
                return hoaDonTraHangModel;
            }
        }
        return null;
    }

    @Override
    public boolean remove(HoaDonTraHangModel hoaDonTraHangModel) {
        if (hoaDonTraHangModel != null && hoaDonTraHangDAO.remove(hoaDonTraHangModel)) {
            lstHoaDonTraHangModels.remove(hoaDonTraHangModel);
            return true;
        }
        return false;
    }

    @Override
    public HoaDonTraHangModel findById(int id) {
        var ref = new Object() {
            HoaDonTraHangModel hoaDonTraHangModel = null;
        };
        lstHoaDonTraHangModels.forEach(e -> {
            if (e.getId().equals(id) && e.isRemove()) {
                ref.hoaDonTraHangModel = e;
            }
        });
        return ref.hoaDonTraHangModel;
    }

    @Override
    public List<HoaDonTraHangModel> filterByDate(Timestamp timestamp) {
        SimpleDateFormat sp = new SimpleDateFormat("yyyyMMdd");
        return lstHoaDonTraHangModels.stream().filter(e -> sp.format(e.getNgayTraHang()).equals(sp.format(timestamp)) && e.isRemove()).collect(Collectors.toList());
    }
}
