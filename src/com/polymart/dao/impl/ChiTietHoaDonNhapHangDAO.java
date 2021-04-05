package com.polymart.dao.impl;

import com.polymart.dao.IChiTietHoaDonNhapHangDAO;
import com.polymart.mapper.ChiTietHoaDonNhapHangMapper;
import com.polymart.model.ChiTietHoaDonNhapHangModel;

import java.util.List;

public class ChiTietHoaDonNhapHangDAO extends AbstractDAO<ChiTietHoaDonNhapHangModel>
		implements IChiTietHoaDonNhapHangDAO {

	@Override
	public List<ChiTietHoaDonNhapHangModel> findAll() {
		String sql = "SELECT * FROM CHITIETHOADONNHAPHANG";
		return query(sql, new ChiTietHoaDonNhapHangMapper());
	}

	@Override
	public boolean save(ChiTietHoaDonNhapHangModel chiTietHoaDonNhapHangModel) {
		if (chiTietHoaDonNhapHangModel != null) {
			String sqlInsert = "INSERT INTO CHITIETHOADONNHAPHANG (IDHOADONNHAPHANG, IDCHITIETSANPHAM, GIANHAP, SOLUONG)\n"
					+ "VALUES (?, ?, ?, ?)";
			return (insert(sqlInsert, chiTietHoaDonNhapHangModel.getIdHoaDonNhapHang(),
					chiTietHoaDonNhapHangModel.getIdChiTietSanPham(), chiTietHoaDonNhapHangModel.getGiaNhap(),
					chiTietHoaDonNhapHangModel.getSoLuong())) > -1;
		}
		return false;
	}

	@Override
	public List<ChiTietHoaDonNhapHangModel> findByIdHoaDonNhap(Integer idHoaDonNhap) {
		String sql = "SELECT * FROM CHITIETHOADONNHAPHANG WHERE IDHOADONNHAPHANG = ?";
		return query(sql, new ChiTietHoaDonNhapHangMapper(), idHoaDonNhap);
	}
}
