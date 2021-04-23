package com.polymart.mapper;

import java.sql.ResultSet;

import com.polymart.model.BaoCaoNgayModel;

public class BaoCaoNgayMapper implements RowMapper<BaoCaoNgayModel> {

	@Override
	public BaoCaoNgayModel mapRow(ResultSet rs) {
		try {
			BaoCaoNgayModel baoCao = new BaoCaoNgayModel();
			baoCao.setIdSanPham(rs.getInt("IDSANPHAM"));
			baoCao.setSoLuongBanRa(rs.getInt("tongsoluong"));
			return baoCao;
		} catch (Exception e) {
			return null;
		}
	}

}
