package com.polymart.dao.impl;

import com.polymart.dao.ISanPhamDAO;
import com.polymart.mapper.NguonHangMapper;
import com.polymart.mapper.SanPhamMapper;
import com.polymart.model.LoaiSanPhamModel;
import com.polymart.model.NguonHangModel;
import com.polymart.model.SanPhamModel;

import java.util.List;

public class SanPhamDAO extends AbstractDAO<SanPhamModel> implements ISanPhamDAO {
    @Override
    public List<SanPhamModel> findAll() {
        String sql = "SELECT * FROM SANPHAM";
        return query(sql, new SanPhamMapper());
    }

    @Override
    public List<SanPhamModel> findByNameSPAndNameLoai(String nameSanPham, String nameLoaiSanPham) {
        String sql = "SELECT * FROM SANPHAM JOIN LOAISANPHAM\n" +
                "ON SANPHAM.IDLOAISANPHAM = LOAISANPHAM.ID\n" +
                "WHERE SANPHAM.TEN = ? AND LOAISANPHAM.TEN = ?";
        return query(sql, new SanPhamMapper(), nameSanPham, nameLoaiSanPham);
    }
    public Integer save(SanPhamModel spModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO SANPHAM (IDLOAISANPHAM,TEN,MOTA,TRANGTHAIKINHDOANH) VALUES (?,?,?,?)");
		return insert(sql.toString(), spModel.getIdLoaiSP(),spModel.getTenSP(),spModel.getMoTa(),spModel.isStatusKinhDoanh());
	}
	public void update(SanPhamModel spModel) {
		StringBuilder sql = new StringBuilder("UPDATE SANPHAM SET MOTA = ?, TRANGTHAIKINHDOANH = ?");
		sql.append(" WHERE ID = ?");
		update(sql.toString(), spModel.getMoTa(),spModel.isStatusKinhDoanh(),spModel.getId());
	}
	public List<SanPhamModel> fillter(String name) {
		String sql = "SELECT*FROM SANPHAM WHERE TEN LIKE ? ";
		return query(sql, new SanPhamMapper(), "%" + name+ "%");
	}
}
