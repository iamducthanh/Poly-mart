package com.polymart.dao.impl;

import com.polymart.dao.IHoaDonThanhToanDAO;
import com.polymart.mapper.HoaDonThanhToanMapper;
import com.polymart.model.HoaDonThanhToanModel;

import java.util.List;

public class HoaDonThanhToanDAO extends AbstractDAO<HoaDonThanhToanModel> implements IHoaDonThanhToanDAO {
	@Override
	public List<HoaDonThanhToanModel> findAll() {
		String sql = "SELECT * FROM HOADONTHANHTOAN WHERE TREMOVE = 1";
		return query(sql, new HoaDonThanhToanMapper());
	}

	@Override
	public HoaDonThanhToanModel findById(int id) {
		String sql = "SELECT * FROM HOADONTHANHTOAN WHERE ID = ? AND TREMOVE = 1";
		List<HoaDonThanhToanModel> lst = query(sql, new HoaDonThanhToanMapper(), id);
		return lst.isEmpty() ? null : lst.get(0);
	}

	@Override
	public Integer save(HoaDonThanhToanModel hoaDonThanhToanModel) {
		String sql = "INSERT INTO HOADONTHANHTOAN (IDKHACHHANG, IDNHANVIEN, DIEMDADOI, GHICHU)\n"
				+ "VALUES (?, ?, ?, ?)";
		return insert(sql, hoaDonThanhToanModel.getIdKhachHang(), hoaDonThanhToanModel.getIdNhanVien(),
				hoaDonThanhToanModel.getDiemDaDoi(), hoaDonThanhToanModel.getGhiChu());
	}

	@Override
	public Integer remove(HoaDonThanhToanModel hoaDonThanhToanModel) {
		String sql = "EXEC PROC_DELETE_HOADONTHANHTOAN ?";
		return update(sql, hoaDonThanhToanModel.getId());
	}
}
