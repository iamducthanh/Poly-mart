package com.polymart.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.polymart.dao.INguonHangDAO;
import com.polymart.dao.impl.NguonHangDAO;
import com.polymart.model.NguonHangModel;
import com.polymart.service.INguonHangService;

public class NguonHangService implements INguonHangService {

    private static INguonHangDAO nguonHangDAO = new NguonHangDAO();
    private static List<NguonHangModel> lstNguonHang = nguonHangDAO.findAll();

    @Override
    public List<NguonHangModel> findAll() {
        return lstNguonHang;
    }

    @Override
    public List<NguonHangModel> findByName(String name) {
        return lstNguonHang.stream().filter(e -> e.getTenNguonHang().equalsIgnoreCase(name)).collect(Collectors.toList());
    }

    @Override
    public String getNameById(Integer id) {
        List<NguonHangModel> lst = lstNguonHang.stream().filter(e -> e.getId() == id).collect(Collectors.toList());
        return lst.isEmpty() ? null : lst.get(0).getTenNguonHang();
    }
}
