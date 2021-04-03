package com.polymart.dao.impl;

import java.util.List;

import com.polymart.dao.IHoaDonNhapHangDAO;
import com.polymart.mapper.HoaDonNhapHangMapper;
import com.polymart.model.HoaDonNhapHangModel;

public class HoaDonNhapHangDAO extends AbstractDAO<HoaDonNhapHangModel> implements IHoaDonNhapHangDAO {

	@Override

	public List<HoaDonNhapHangModel> findAll() {
		String sql = "SELECT * FROM HOADONNHAPHANG";
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
}
