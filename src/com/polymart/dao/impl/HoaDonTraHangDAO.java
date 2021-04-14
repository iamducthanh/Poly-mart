package com.polymart.dao.impl;

import com.polymart.dao.IHoaDonTraHangDAO;
import com.polymart.mapper.HoaDonTraHangMapper;
import com.polymart.model.HoaDonTraHangModel;

import java.sql.ResultSet;
import java.util.List;

public class HoaDonTraHangDAO extends AbstractDAO<HoaDonTraHangModel> implements IHoaDonTraHangDAO {

	@Override
	public Object[] getDataTableTraHang(int id) {
		String sql = "EXEC PROC_SHOWTABLE_TRAHANG ?";
		ResultSet resultSet = null;
		Object[] result = null;
		try {
			resultSet = queryBySql(sql, id);
			if (resultSet.next()) {
				result = new Object[resultSet.getMetaData().getColumnCount()];
				result[0] = resultSet.getString("ID");
				result[1] = resultSet.getString("IDHOADONTHANHTOAN");
				result[2] = resultSet.getDate("NGAYTRAHANG");
				result[3] = resultSet.getString("HOTEN");
				result[4] = resultSet.getLong("TONGTIEN");
			}
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return result;
	}

	@Override
	public List<HoaDonTraHangModel> findAll() {
		String sql = "SELECT * FROM HOADONTRAHANG WHERE TREMOVE = 1";
		return query(sql, new HoaDonTraHangMapper());
	}

	@Override
	public int save(HoaDonTraHangModel hoaDonTraHangModel) {
		String sql = "INSERT INTO HOADONTRAHANG (IDNHANVIEN, GHICHU) VALUES (?, ?)";
		return insert(sql, hoaDonTraHangModel.getIdNhanVien(), hoaDonTraHangModel.getGhiChu());
	}

	@Override
	public boolean remove(HoaDonTraHangModel hoaDonTraHangModel) {
		String sql = "EXEC PROC_DELETE_HOADONTRAHANG ?";
		return update(sql, hoaDonTraHangModel.getId()) > 0;
	}

	@Override
	public HoaDonTraHangModel findById(Integer id) {
		String sql = "SELECT * FROM HOADONTRAHANG WHERE ID = ? AND TREMOVE = 1";
		List<HoaDonTraHangModel> lstTim = query(sql, new HoaDonTraHangMapper(), id);
		return lstTim.isEmpty() ? null : lstTim.get(0);
	}
}
