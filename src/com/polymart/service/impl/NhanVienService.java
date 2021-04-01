package com.polymart.service.impl;

import java.util.List;

import com.polymart.dao.INhanVienDAO;
import com.polymart.dao.impl.NhanVienDAO;
import com.polymart.model.NhanVienModel;
import com.polymart.service.INhanVienService;

public class NhanVienService implements INhanVienService {

	private static INhanVienDAO nhanVienDAO = new NhanVienDAO();
//    private static List<NhanVienModel> list;    //Nạp dữ liệu từ SQL

	@Override
	public NhanVienModel findByIdAndPassword(Integer id, String password) {
		List<NhanVienModel> list = nhanVienDAO.findByIdAndPassword(String.valueOf(id), password);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public List<NhanVienModel> findAll() {
		return nhanVienDAO.findAll();
	}

	@Override
	public NhanVienModel save(NhanVienModel newNhanVienModel) {
		Integer newNhanVienId = nhanVienDAO.save(newNhanVienModel);
		return nhanVienDAO.findOne(newNhanVienId);
	}

	@Override
	public NhanVienModel update(NhanVienModel updateNhanVienModel) {
		nhanVienDAO.update(updateNhanVienModel);
		return nhanVienDAO.findOne(updateNhanVienModel.getId());
	}

	@Override
	public void delete(Integer[] ids) {
		for (Integer id : ids) {
			nhanVienDAO.delete(id);
		}
	}

	@Override
	public NhanVienModel findOne(Integer id) {
		return nhanVienDAO.findOne(id);
	}

	@Override
	public List<NhanVienModel> filter(String idOrName) {
		return nhanVienDAO.filter(idOrName);
	}

	@Override
	public List<NhanVienModel> filterByChucVu(String chucVu) {
		return nhanVienDAO.filterByChucVu(chucVu);
	}
}
