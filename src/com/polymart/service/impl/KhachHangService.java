package com.polymart.service.impl;

import com.polymart.dao.IKhachHangDAO;
import com.polymart.dao.impl.KhachHangDAO;
import com.polymart.model.KhachHangModel;
import com.polymart.service.IKhachHangService;

import java.util.*;

public class KhachHangService implements IKhachHangService {

	private static IKhachHangDAO khachHangDAO = new KhachHangDAO();

	@Override
	public List<KhachHangModel> findAll() {
		return khachHangDAO.findAll();
	}

	@Override
	public List<KhachHangModel> filter(String nameOrPhone) {
		return khachHangDAO.filter(nameOrPhone);
	}

	@Override
	public KhachHangModel save(KhachHangModel khachHangModel) {
		Integer newKhachHangId = khachHangDAO.save(khachHangModel);
		return khachHangDAO.findOne(newKhachHangId);
	}

	@Override
	public KhachHangModel update(KhachHangModel updatekhachHangModel) {
		khachHangDAO.update(updatekhachHangModel);
		return khachHangDAO.findOne(updatekhachHangModel.getId());
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
