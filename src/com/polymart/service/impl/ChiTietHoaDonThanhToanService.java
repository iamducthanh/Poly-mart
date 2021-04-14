package com.polymart.service.impl;

import com.polymart.dao.IChiTietHoaDonThanhToanDAO;
import com.polymart.dao.impl.ChiTietHoaDonThanhToanDAO;
import com.polymart.model.ChiTietHoaDonThanhToanModel;
import com.polymart.service.IChiTietHoaDonThanhToanService;

import java.util.List;
import java.util.stream.Collectors;

public class ChiTietHoaDonThanhToanService implements IChiTietHoaDonThanhToanService {

    private static IChiTietHoaDonThanhToanDAO hoaDonThanhToanDAO = new ChiTietHoaDonThanhToanDAO();
    private static List<ChiTietHoaDonThanhToanModel> lstChiTietHoaDonThanhToanModels = hoaDonThanhToanDAO.findAll();

    @Override
    public List<ChiTietHoaDonThanhToanModel> findByIdHoaDonThanhToan(Integer idHoaDonThanhToan) {
        return lstChiTietHoaDonThanhToanModels.stream().filter(e -> e.getHoaDonThanhToan().equals(idHoaDonThanhToan))
                .collect(Collectors.toList());
    }

    @Override
    public boolean save(ChiTietHoaDonThanhToanModel chiTietHoaDonThanhToanModel) {
        if (chiTietHoaDonThanhToanModel != null) {
            if (hoaDonThanhToanDAO.save(chiTietHoaDonThanhToanModel)) {
                lstChiTietHoaDonThanhToanModels.add(chiTietHoaDonThanhToanModel);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean update(ChiTietHoaDonThanhToanModel chiTietHoaDonThanhToanModel) {
        if (hoaDonThanhToanDAO.update(chiTietHoaDonThanhToanModel)) {
            lstChiTietHoaDonThanhToanModels.forEach(e -> {
                if (e.getId().equals(chiTietHoaDonThanhToanModel.getId())) {
                    e.setSoLuong(chiTietHoaDonThanhToanModel.getSoLuong());
                }
            });
            return true;
        }
        return false;
    }

    @Override
    public ChiTietHoaDonThanhToanModel findById(int id) {
        var ref = new Object() {
            ChiTietHoaDonThanhToanModel chiTietHoaDonThanhToanModel = null;
        };
        lstChiTietHoaDonThanhToanModels.forEach(e -> {
            if (e.getId().equals(id)) {
                ref.chiTietHoaDonThanhToanModel = e;
            }
        });
        return ref.chiTietHoaDonThanhToanModel;
    }

    @Override
    public void reloadData() {
        lstChiTietHoaDonThanhToanModels = hoaDonThanhToanDAO.findAll();
    }
}
