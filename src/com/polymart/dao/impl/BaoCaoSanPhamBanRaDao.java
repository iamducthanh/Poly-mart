package com.polymart.dao.impl;

import java.util.Date;
import java.util.List;

import com.polymart.mapper.BaoCaoNgayMapper;
import com.polymart.model.BaoCaoNgayModel;

import java.sql.*;

public class BaoCaoSanPhamBanRaDao extends AbstractDAO<BaoCaoNgayModel> {
	public List<BaoCaoNgayModel> finAll(String nam, String thang, String ngay) {
		String sql = "EXEC BAOCAONGAY ?, ?, ?";
		return query(sql, new BaoCaoNgayMapper(), nam, thang, ngay);
	}

	public int soLuongTrongKho(int id) {
		String sql = "select SUM(CHITIETSANPHAM.SOLUONG) as'SoLuongTrongKho' from CHITIETSANPHAM join SANPHAM "
				+ "on SANPHAM.ID = CHITIETSANPHAM.IDSANPHAM where SANPHAM.ID=? group by CHITIETSANPHAM.IDSANPHAM";
		ResultSet rs = queryBySql(sql, id);
		int soLuong = 0;
		try {
			while (rs.next()) {
				soLuong = rs.getInt("SoLuongTrongKho");
			}
		} catch (Exception e) {
		}
		return soLuong;
	}

	public int tbSoLuongBanRa(String nam, String thang, int id) {
		String sql = "select SUM(C.soluong) as 'tongsoluong' from HOADONTHANHTOAN a JOIN \r\n"
				+ "CHITIETHOADONTHANHTOAN C ON C.IDHOADONTHANHTOAN = a.ID\r\n"
				+ "join CHITIETSANPHAM b on b.ID = C.IDCHITIETSANPHAM \r\n"
				+ "join SANPHAM on SANPHAM.ID = b.IDSANPHAM \r\n"
				+ "where YEAR(a.NGAYTHANHTOAN) = ? and MONTH(a.NGAYTHANHTOAN)=?  and SANPHAM.ID = ?\r\n"
				+ "group by b.IDSANPHAM";
		ResultSet rs = queryBySql(sql, nam, thang, id);
		int soLuong = 0;
		try {
			while (rs.next()) {
				soLuong = rs.getInt("tongsoluong");
			}
		} catch (Exception e) {
		}
		return soLuong;
	}

	public long tongThu(String nam, String thang, String ngay) {
		String sql = "select SUM(a.soluong*c.giaban) as 'tongthu' from CHITIETHOADONTHANHTOAN a join HOADONTHANHTOAN b on a.IDHOADONTHANHTOAN = b.ID \r\n"
				+ "join CHITIETSANPHAM c on c.ID = a.IDCHITIETSANPHAM\r\n"
				+ "where YEAR(NGAYTHANHTOAN) = ? and MONTH(ngaythanhtoan) =? and day(ngaythanhtoan)=?";
		ResultSet rs = queryBySql(sql, nam, thang, ngay);
		long tongThu = 0;
		try {
			while (rs.next()) {
				tongThu = rs.getLong("tongthu");
			}
		} catch (Exception e) {
		}
		return tongThu;
	}

	public long tongChi(String nam, String thang, String ngay) {
		String sql = "select SUM(sotien) as 'TongChi'  from CHITIEU "
				+ "where YEAR(NGAYCHITIEU) = ? and MONTH(NGAYCHITIEU)= ? and DAY(NGAYCHITIEU) =? and TRANGTHAI is null";
		ResultSet rs = queryBySql(sql, nam, thang, ngay);
		long tongChi = 0;
		try {
			while (rs.next()) {
				tongChi = rs.getLong("tongChi");
			}
		} catch (Exception e) {
		}
		return tongChi;
	}

	public int soLuongBanRaChiTiet(String nam, String thang, String ngay, int id) {
		String sql = "select sum(a.soluong) as 'soluong'  from CHITIETHOADONTHANHTOAN a "
				+ "join HOADONTHANHTOAN b on a.IDHOADONTHANHTOAN = b.ID \r\n"
				+ "join CHITIETSANPHAM c on c.ID = a.IDCHITIETSANPHAM\r\n"
				+ "where YEAR(NGAYTHANHTOAN) = ? and MONTH(ngaythanhtoan) =? and day(ngaythanhtoan)=?"
				+ " and c.ID=?";
		ResultSet rs = queryBySql(sql, nam, thang, ngay,id);
		int soLuong = 0;
		try {
			while (rs.next()) {
				soLuong = rs.getInt("soluong");
			}
		} catch (Exception e) {
		}
		return soLuong;
	}
}
