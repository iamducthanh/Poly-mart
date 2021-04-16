package com.polymart.dao.impl;

import java.util.List;

import com.polymart.dao.IChiTieuDAO;
import com.polymart.mapper.ChiTieuMapper;
import com.polymart.model.ChiTieuModel;

public class ChiTieuDao extends AbstractDAO<ChiTieuModel> implements IChiTieuDAO {

	@Override
	public List<ChiTieuModel> findAll() {
		String sql = "select a.*,b.HOTEN from CHITIEU a join NHANVIEN b on b.ID = a.IDNHANVIEN  where trangthai is  null order by MACT desc";
		return query(sql, new ChiTieuMapper());
	}
	public List<ChiTieuModel> findAllLichSuXoa() {
		String sql = "select a.*,b.HOTEN from CHITIEU a join NHANVIEN b on b.ID = a.IDNHANVIEN  where trangthai = 1 order by MACT desc";
		return query(sql, new ChiTieuMapper());
	}
	@Override
	public void save(ChiTieuModel chiTieuModel) {
		String sql = "insert into CHITIEU (MUCDICHCHITIEU,IDNHANVIEN,SOTIEN,GHICHU) values(?,?,?,?)";
		insert(sql, chiTieuModel.getMucDichChiTieu(),chiTieuModel.getIdNhanVien(),chiTieuModel.getSoTien(),chiTieuModel.getGhiChu());
		
	}

	@Override
	public List<ChiTieuModel> findTheoNgay(int nam, int thang, int ngay) {
		String sql = "select a.*,b.HOTEN from CHITIEU a join NHANVIEN b on b.ID = a.IDNHANVIEN "
				+ "where YEAR(NGAYCHITIEU) = ? and MONTH(NGAYCHITIEU) = ? and DAY(NGAYCHITIEU) =? and trangthai is  null order by MACT desc";
		return query(sql, new ChiTieuMapper(),nam,thang,ngay);
	}
	
	public List<ChiTieuModel> findTheoThang(int nam, int thang) {
		String sql = "select a.*,b.HOTEN from CHITIEU a join NHANVIEN b on b.ID = a.IDNHANVIEN "
				+ "where YEAR(NGAYCHITIEU) = ? and MONTH(NGAYCHITIEU) = ? and trangthai is  null order by MACT desc";
		return query(sql, new ChiTieuMapper(),nam,thang);
	}
	public List<ChiTieuModel> findTraLuong(int nam, int thang) {
		String sql = " select a.*,b.HOTEN from CHITIEU a join NHANVIEN b on b.ID = a.IDNHANVIEN "
				+ "where year (ngaychitieu) = ? and month(ngaychitieu) = ? and MUCDICHCHITIEU = N'Thanh Toán Lương' order by MACT desc;";
		return query(sql, new ChiTieuMapper(),nam,thang);
	}

//	public void delete(int maCT,String ghiChu) {
//		String sql = "update  CHITIEU set trangthai = 1, GHICHU = ? where mact =?";
//		update(sql,ghiChu, maCT);
//	}
	public void delete(int maCT,String ghiChu) {
		String sql = "update  CHITIEU set trangthai = 1, ghichu = ? where mact =?";
		update(sql,ghiChu, maCT);
	}
}
