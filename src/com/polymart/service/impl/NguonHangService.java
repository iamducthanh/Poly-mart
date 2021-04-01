package com.polymart.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.polymart.dao.INguonHangDAO;
import com.polymart.dao.impl.NguonHangDAO;
import com.polymart.model.NguonHangModel;
import com.polymart.service.INguonHangService;

public class NguonHangService implements INguonHangService {

    private static INguonHangDAO nguonHangDAO = new NguonHangDAO();
    private static Map<Integer, NguonHangModel> mapNhanVien = new HashMap<Integer, NguonHangModel>();    //Nạp dữ liệu từ SQL

    static {
        initNhanVien();
    }

    private static void initNhanVien() {
    	for (NguonHangModel nguonHang : nguonHangDAO.findAll()) {
			mapNhanVien.put(nguonHang.getId(), nguonHang);
		}
    }

	@Override
	public List<NguonHangModel> findAll() {
		return new ArrayList<>(mapNhanVien.values());
	}

	@Override
	public List<NguonHangModel> findByName(String name) {
		return new NguonHangDAO().findByName(name);
	}
}
