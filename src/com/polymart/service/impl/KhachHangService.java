package com.polymart.service.impl;

import com.polymart.dao.IKhachHangDAO;
import com.polymart.dao.impl.KhachHangDAO;
import com.polymart.model.KhachHangModel;
import com.polymart.service.IKhachHangService;

import java.util.*;

public class KhachHangService implements IKhachHangService {

    private static IKhachHangDAO iKhachHangDao = new KhachHangDAO();
    private static Map<Integer, KhachHangModel> mapKhachHang = new HashMap<Integer, KhachHangModel>();    //Nạp dữ liệu từ SQL

    static {
        initKhachHang();
    }

    private static void initKhachHang() {
        for (KhachHangModel x : iKhachHangDao.findAll()) {
            mapKhachHang.put(x.getId(), x);
        }
    }

    @Override
    public List<KhachHangModel> findAll() {
        return new ArrayList<>(mapKhachHang.values());
    }

    @Override
    public List<KhachHangModel> findByNameOrPhoneNumber(String input) {
        input = input.toLowerCase();
        List<KhachHangModel> lstTimKiem = new ArrayList<>();
        for (KhachHangModel x : mapKhachHang.values()) {
            if (x.getHoTen() != null && !x.getHoTen().isBlank()) {
                if (x.getHoTen().toLowerCase().contains(input)) {
                    lstTimKiem.add(x);
                }
            }
            if (x.getSdt() != null && !x.getSdt().isBlank()) {
                if (x.getSdt().contains(input)) {
                    lstTimKiem.add(x);
                }
            }
        }
        return lstTimKiem;
    }

    @Override
    public KhachHangModel save(KhachHangModel khachHangModel) {
        return null;
    }
}
