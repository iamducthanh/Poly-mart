package com.polymart.service.impl;

import com.polymart.dao.IKhachHangDAO;
import com.polymart.dao.impl.KhachHangDAO;
import com.polymart.model.KhachHangModel;
import com.polymart.service.IKhachHangService;

import java.util.*;
import java.util.stream.Collectors;

public class KhachHangService implements IKhachHangService {

    private static IKhachHangDAO khachHangDAO = new KhachHangDAO();
    private static List<KhachHangModel> lstKhachHang = khachHangDAO.findAll();

    @Override
    public List<KhachHangModel> findAll() {
        return khachHangDAO.findAll();
    }

    @Override
    public List<KhachHangModel> filter(String nameOrPhone) {
        String finalNameOrPhone = nameOrPhone.trim().toLowerCase(Locale.ROOT);
        return lstKhachHang.stream().filter(e -> e.getHoTen().contains(finalNameOrPhone)
                || e.getSdt().contains(finalNameOrPhone)).collect(Collectors.toList());
    }

    @Override
    public KhachHangModel save(KhachHangModel khachHangModel) {
        Integer newKhachHangId = khachHangDAO.save(khachHangModel);
        khachHangModel = khachHangDAO.findOne(newKhachHangId);
        if (khachHangModel != null) {
            lstKhachHang.add(khachHangModel);
        }
        return khachHangModel;
    }

    @Override
    public KhachHangModel update(KhachHangModel updateKhachHangModel) {
        khachHangDAO.update(updateKhachHangModel);
        return khachHangDAO.findOne(updateKhachHangModel.getId());
    }

    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            khachHangDAO.delete(id);
        }
    }

    @Override
    public KhachHangModel findOne(Integer id) {
        return khachHangDAO.findOne(id);
    }
}
