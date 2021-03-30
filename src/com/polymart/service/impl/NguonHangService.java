package com.polymart.service.impl;

import com.polymart.model.NguonHangModel;
import com.polymart.service.INguonHang;

import java.util.ArrayList;
import java.util.List;

public class NguonHangImpl implements INguonHang {

    private List<NguonHangModel> lstNguonHang = null;

    public NguonHangImpl() {
        lstNguonHang = new ArrayList<NguonHangModel>();

    }

    @Override
    public List<NguonHangModel> getListNguonHang() {
        return lstNguonHang;
    }
}
