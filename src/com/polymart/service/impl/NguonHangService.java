package com.polymart.service.impl;

import com.polymart.model.NguonHangModel;
import com.polymart.service.INguonHangService;

import java.util.ArrayList;
import java.util.List;

public class NguonHangService implements INguonHangService {

    private List<NguonHangModel> lstNguonHang = null;

    public NguonHangService() {
        lstNguonHang = new ArrayList<NguonHangModel>();

    }

    @Override
    public List<NguonHangModel> getListNguonHang() {
        return lstNguonHang;
    }
}
