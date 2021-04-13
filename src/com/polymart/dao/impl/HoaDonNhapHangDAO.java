package com.polymart.dao.impl;

import java.util.List;

import com.polymart.dao.IHoaDonNhapHangDAO;
import com.polymart.mapper.HoaDonNhapHangMapper;
import com.polymart.model.HoaDonNhapHangModel;

public class HoaDonNhapHangDAO extends AbstractDAO<HoaDonNhapHangModel> implements IHoaDonNhapHangDAO {

	@Override

	public List<HoaDonNhapHangModel> findAll() {
		String sql = "SELECT * FROM HOADONNHAPHANG WHERE TREMOVE = 1";
		return query(sql, new HoaDonNhapHangMapper());
	}

	@Override
	public Integer save(HoaDonNhapHangModel hoaDonNhapHangModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO HOADONNHAPHANG (IDNHANVIEN, IDNGUONHANG, GHICHU)");
		sql.append(" VALUES (?, ?, ?)");
		int id = insert(sql.toString(), hoaDonNhapHangModel.getIdNhanVienNhap(), hoaDonNhapHangModel.getIdNguonHang(),
				hoaDonNhapHangModel.getGhiChu());
		return id;
	}

	@Override
	public Integer remove(HoaDonNhapHangModel hoaDonNhapHangModel) {
		String sql = "EXEC PROC_DELETE_HOADONNHAPHANG ?";
		return update(sql, hoaDonNhapHangModel.getId());
	}

	@Override
	public HoaDonNhapHangModel findById(Integer id) {
		String sql = "SELECT * FROM HOADONNHAPHANG WHERE ID = ? AND TREMOVE = 1";
		List<HoaDonNhapHangModel> lst = query(sql, new HoaDonNhapHangMapper(), id);
		return lst == null ? null : lst.get(0);
	}
}
