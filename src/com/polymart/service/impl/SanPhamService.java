package com.polymart.service.impl;

import com.polymart.dao.ISanPhamDAO;
import com.polymart.dao.impl.SanPhamDAO;
import com.polymart.model.SanPhamModel;
import com.polymart.service.ISanPhamService;

import java.util.*;
import java.util.stream.Collectors;

public class SanPhamService implements ISanPhamService {

	private static ISanPhamDAO sanPhamDAO = new SanPhamDAO();
	private static List<SanPhamModel> lstSanPham = sanPhamDAO.findAll();

	@Override
	public List<SanPhamModel> findAll() {
		return lstSanPham;
	}

	@Override
	public SanPhamModel findByID(Integer id) {
		List<SanPhamModel> lst = lstSanPham.stream().filter(e -> e.getId().equals(id)).collect(Collectors.toList());
		return lst.isEmpty() ? null : lst.get(0);
	}
}
