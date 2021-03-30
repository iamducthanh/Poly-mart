package com.polymart.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.polymart.dao.INhanVienDAO;
import com.polymart.dao.impl.NhanVienDAO;
import com.polymart.model.NhanVienModel;
import com.polymart.service.INhanVienService;

public class NhanVienService implements INhanVienService {

	private static INhanVienDAO nhanVienDAO = new NhanVienDAO();
    private static Map<Integer, NhanVienModel> mapNhanVien = new HashMap<Integer, NhanVienModel>();    //Nạp dữ liệu từ SQL

    static {
        initNhanVien();
    }

    private static void initNhanVien() {
    	for (NhanVienModel nhanVien : nhanVienDAO.findAll()) {
			mapNhanVien.put(nhanVien.getId(), nhanVien);
		}
    }

    @Override
    public NhanVienModel findNhanVienByIdAndPassword(Integer id, String password) {
        NhanVienModel nhanVien = mapNhanVien.get(id);
        if (nhanVien != null && nhanVien.getMatKhau().equals(password)) {
            return nhanVien;
        }
        return null;
    }

	@Override
	public List<NhanVienModel> findAll() {
		return new ArrayList<>(mapNhanVien.values());
	}

    @Override
    public boolean changePassword(Integer id, String newPassword) {
        NhanVienModel nhanVien = mapNhanVien.get(id);
        if (nhanVien != null) {
            mapNhanVien.get(id).setMatKhau(newPassword);
            return true;
        }
        return false;
    }
}
