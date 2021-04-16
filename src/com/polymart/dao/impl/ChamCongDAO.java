package com.polymart.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.polymart.dao.IChamCongDAO;
import com.polymart.mapper.ChamCongMapper;
import com.polymart.model.ChamCongModel;

public class ChamCongDAO extends AbstractDAO<ChamCongModel> implements IChamCongDAO {

	@Override
	public List<ChamCongModel> findAll() {
		String sql = "SELECT*FROM CHAMCONG";
		return query(sql, new ChamCongMapper());
	}

	@Override
	public Integer save(ChamCongModel chamCongModel) {
		String sql = "INSERT INTO CHAMCONG (IDNHANVIEN,NGAYCHAMCONG) VALUES (?,?)";
		return insert(sql, chamCongModel.getIdNhanVien(), chamCongModel.getNgayChamCong());
	}

	@Override
	public List<ChamCongModel> filterDay(String a, String b, String c) {
		String sql = "select a.*,b.HOTEN from CHAMCONG a join NHANVIEN b on a.IDNHANVIEN = b.ID WHERE YEAR(NGAYCHAMCONG) =? and MONTH(NGAYCHAMCONG)=? and DAY(NGAYCHAMCONG) =?";
		return query(sql, new ChamCongMapper(), a, b, c);
	}

	@Override
	public List<ChamCongModel> filterMonth(String a, String b) {
		String sql = "select a.*,b.HOTEN from CHAMCONG a join NHANVIEN b on a.IDNHANVIEN = b.ID WHERE YEAR(NGAYCHAMCONG) =? and MONTH(NGAYCHAMCONG)=?";
		return query(sql, new ChamCongMapper(), a, b);
	}

	@Override
	public void delete(Integer id, String nam, String thang, String ngay) {
		String sql = "delete from CHAMCONG where IDNHANVIEN = ? and YEAR(ngaychamcong) =? and MONTH(NGAYCHAMCONG)=? and DAY(NGAYCHAMCONG)=?";
		update(sql, id, nam, thang, ngay);
	}

	public List<String> findNam() {
		List<String> listNam = new ArrayList<String>();
		String sql = "select YEAR(NGAYCHAMCONG) as 'Nam' from CHAMCONG group by YEAR(NGAYCHAMCONG)";
		try {
			Connection con = getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				listNam.add(String.valueOf(rs.getString("nam")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listNam;
	}
	public void updateGioRa(ChamCongModel chamCong) {
		Calendar c= Calendar.getInstance();
		c.setTime(chamCong.getNgayChamCong());
		String sql = "update CHAMCONG set Giora = ? where IDNHANVIEN = ? and YEAR(NGAYCHAMCONG) = ? and MONTH(NGAYCHAMCONG) = ? and DAY(NGAYCHAMCONG) = ?";
		update(sql, chamCong.getGioRa(),chamCong.getIdNhanVien(),c.get(Calendar.YEAR),(c.get(Calendar.MONTH)+1),c.get(Calendar.DAY_OF_MONTH));
	}
}
