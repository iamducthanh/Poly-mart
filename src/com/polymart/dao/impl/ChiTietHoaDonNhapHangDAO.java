package com.polymart.dao.impl;

import com.polymart.dao.IChiTietHoaDonNhapHangDAO;
import com.polymart.mapper.ChiTietHoaDonNhapHangMapper;
import com.polymart.model.ChiTietHoaDonNhapHangModel;

import java.util.List;

public class ChiTietHoaDonNhapHangDAO extends AbstractDAO<ChiTietHoaDonNhapHangModel>
		implements IChiTietHoaDonNhapHangDAO {

	@Override
	public List<ChiTietHoaDonNhapHangModel> findAll() {
		String sql = "SELECT * FROM CHITIETHOADONNHAPHANG JOIN HOADONNHAPHANG" +
				" ON HOADONNHAPHANG.ID = CHITIETHOADONNHAPHANG.IDHOADONNHAPHANG" +
				" WHERE HOADONNHAPHANG.TREMOVE = 1";
		return query(sql, new ChiTietHoaDonNhapHangMapper());
	}

	@Override
	public boolean save(ChiTietHoaDonNhapHangModel chiTietHoaDonNhapHangModel) {
		if (chiTietHoaDonNhapHangModel != null) {
			String sqlInsert = "EXEC PROC_INSERT_CTHOADONNHAPHANG ?, ?, ?, ?";
			return (update(sqlInsert, chiTietHoaDonNhapHangModel.getIdHoaDonNhapHang(),
					chiTietHoaDonNhapHangModel.getIdChiTietSanPham(), chiTietHoaDonNhapHangModel.getGiaNhap(),
					chiTietHoaDonNhapHangModel.getSoLuong())) > 0;
		}
		return false;
	}

	@Override
	public List<ChiTietHoaDonNhapHangModel> findByIdHoaDonNhap(Integer idHoaDonNhap) {
		String sql = "SELECT * FROM CHITIETHOADONNHAPHANG JOIN HOADONNHAPHANG" +
				" ON HOADONNHAPHANG.ID = CHITIETHOADONNHAPHANG.IDHOADONNHAPHANG" +
				" WHERE HOADONNHAPHANG.ID = ? AND HOADONNHAPHANG.TREMOVE = 1";
		return query(sql, new ChiTietHoaDonNhapHangMapper(), idHoaDonNhap);
	}
}
