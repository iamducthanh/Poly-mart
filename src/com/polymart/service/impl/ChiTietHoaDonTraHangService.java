package com.polymart.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.polymart.dao.IChiTietHoaDonTraHangDAO;
import com.polymart.dao.impl.ChiTietHoaDonTraHangDAO;
import com.polymart.model.ChiTietHoaDonTraHangModel;
import com.polymart.service.IChiTietHoaDonTraHangService;

public class ChiTietHoaDonTraHangService implements IChiTietHoaDonTraHangService {

    private static IChiTietHoaDonTraHangDAO chiTietHoaDonTraHangDAO = new ChiTietHoaDonTraHangDAO();
    private static List<ChiTietHoaDonTraHangModel> lstChiTietHoaDonTraHangModels = chiTietHoaDonTraHangDAO.findAll();

    @Override
    public boolean save(ChiTietHoaDonTraHangModel chiTietHoaDonTraHangModel) {
        if (chiTietHoaDonTraHangDAO.save(chiTietHoaDonTraHangModel)) {
            lstChiTietHoaDonTraHangModels.add(chiTietHoaDonTraHangModel);
            return true;
        }
        return false;
    }

    @Override
    public List<ChiTietHoaDonTraHangModel> findByIdHoaDonTraHang(int idHoaDonTraHang) {
//        List<ChiTietHoaDonTraHangModel> lst = new ArrayList<>();
//        lstChiTietHoaDonTraHangModels.forEach(e -> {
//            if (e.getIdHoaDonTraHang().equals(idHoaDonTraHang)) {
//                lst.add(e);
//            }
//        });
//        return lst;
        return lstChiTietHoaDonTraHangModels.stream().filter(e -> e.getIdHoaDonTraHang().equals(idHoaDonTraHang)).collect(Collectors.toList());
    }

    @Override
    public void reloadData() {
        lstChiTietHoaDonTraHangModels = chiTietHoaDonTraHangDAO.findAll();
    }
}
