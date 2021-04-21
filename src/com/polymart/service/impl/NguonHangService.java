package com.polymart.service.impl;

import java.util.List;

import com.polymart.dao.INguonHangDAO;
import com.polymart.dao.impl.NguonHangDAO;
import com.polymart.model.NguonHangModel;
import com.polymart.service.INguonHangService;

public class NguonHangService implements INguonHangService {

    private static INguonHangDAO nguonHangDAO = new NguonHangDAO();
    private static List<NguonHangModel> lstNguonHang = nguonHangDAO.findAll();

    @Override
    public List<NguonHangModel> findAll() {
        return nguonHangDAO.findAll();
    }

    @Override

    public List<NguonHangModel> fillter(String nameOrPhone) {
        return new NguonHangDAO().fillter(nameOrPhone);
    }

    @Override
    public NguonHangModel save(NguonHangModel nguonHangModel) {
        Integer newNguonHangId = nguonHangDAO.save(nguonHangModel);
        return nguonHangDAO.findOne(newNguonHangId);

    }

    @Override
    public NguonHangModel update(NguonHangModel updatenguonHangModel) {
        nguonHangDAO.update(updatenguonHangModel);
        return nguonHangDAO.findOne(updatenguonHangModel.getId());
    }

    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            nguonHangDAO.delete(id);
        }
    }

    @Override
    public NguonHangModel findOne(Integer id) {
        return nguonHangDAO.findOne(id);
    }

    @Override
    public String getNameById(Integer id) {
        var ref = new Object() {
            String nameNguonHang = null;
        };
        lstNguonHang.forEach(e -> {
            if (e.getId().equals(id)) {
                ref.nameNguonHang = e.getTenNguonHang();
            }
        });
        return ref.nameNguonHang;
    }
}
