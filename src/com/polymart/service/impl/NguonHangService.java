package com.polymart.service.impl;

import com.polymart.dao.INguonHangDAO;
import com.polymart.dao.impl.NguonHangDAO;
import com.polymart.model.NguonHangModel;
import com.polymart.service.INguonHangService;

import java.util.ArrayList;
import java.util.List;

public class NguonHangService implements INguonHangService {

    private List<NguonHangModel> lstNguonHang = null;
    private INguonHangDAO iNguonHangDAO = new NguonHangDAO();

    public NguonHangService() {
        lstNguonHang = new ArrayList<NguonHangModel>();
        lstNguonHang = iNguonHangDAO.fillAll();
    }

    @Override
    public List<NguonHangModel> getListNguonHang() {
        return lstNguonHang;
    }
}
