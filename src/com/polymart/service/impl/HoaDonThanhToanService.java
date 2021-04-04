package com.polymart.service.impl;

import com.polymart.dao.IHoaDonThanhToanDAO;
import com.polymart.dao.impl.HoaDonThanhToanDAO;
import com.polymart.model.HoaDonThanhToanModel;
import com.polymart.service.IHoaDonThanhToanService;

import java.util.List;

public class HoaDonThanhToanService implements IHoaDonThanhToanService {

	private static IHoaDonThanhToanDAO hoaDonThanhToanDAO = new HoaDonThanhToanDAO();
	private static List<HoaDonThanhToanModel> lstHoaDonThanhToanModels = hoaDonThanhToanDAO.findAll();

	@Override
	public List<HoaDonThanhToanModel> findAll() {
		return lstHoaDonThanhToanModels;
	}

	@Override
	public HoaDonThanhToanModel save(HoaDonThanhToanModel hoaDonThanhToanModel) {
		if (hoaDonThanhToanModel != null) {
			int id = hoaDonThanhToanDAO.save(hoaDonThanhToanModel);
			hoaDonThanhToanModel = hoaDonThanhToanDAO.findById(id);
			if (hoaDonThanhToanModel != null) {
				lstHoaDonThanhToanModels.add(hoaDonThanhToanModel);
				return hoaDonThanhToanModel;
			}
		}
		return null;
	}

	@Override
	public boolean remove(HoaDonThanhToanModel hoaDonThanhToanModel) {
		if (hoaDonThanhToanModel != null) {
			if (hoaDonThanhToanDAO.remove(hoaDonThanhToanModel) > 0) {
				lstHoaDonThanhToanModels.remove(hoaDonThanhToanModel);
				return true;
			}
		}
		return false;
	}
}
