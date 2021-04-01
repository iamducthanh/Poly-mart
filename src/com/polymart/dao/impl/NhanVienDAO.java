package com.polymart.dao.impl;

import java.util.List;

import com.polymart.dao.INhanVienDAO;
import com.polymart.mapper.NhanVienMapper;
import com.polymart.model.NhanVienModel;

public class NhanVienDAO extends AbstractDAO<NhanVienModel> implements INhanVienDAO {

    @Override
    public List<NhanVienModel> findAll() {
        String sql = "SELECT*FROM NHANVIEN";
        return query(sql, new NhanVienMapper());
    }

    @Override
    public Integer save(NhanVienModel nhanVienModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO NHANVIEN (HOTEN, ");
        sql.append("NGAYSINH, GIOITINH, DIACHI, SODIENTHOAI, EMAIL, CHUCVU, ");
        sql.append("MUCLUONG, ANHDAIDIEN, MATKHAU) ");
        sql.append("VALUES (?,?,?,?,?,?,?,?,?,?)");
        return insert(sql.toString(), nhanVienModel.getHoTen(), nhanVienModel.getNgaySinh(), nhanVienModel.isGioiTinh(),
                nhanVienModel.getDiaChi(), nhanVienModel.getSdt(), nhanVienModel.getEmail(), nhanVienModel.getChucVu(),
                nhanVienModel.getLuong(), nhanVienModel.getAnhDaiDien(), nhanVienModel.getMatKhau());
    }

    @Override
    public void update(NhanVienModel nhanVienModel) {
        StringBuilder sql = new StringBuilder("UPDATE NHANVIEN SET HOTEN = ?, ");
        sql.append("NGAYSINH = ?, GIOITINH = ?, DIACHI = ?, SODIENTHOAI = ?, ");
        sql.append("EMAIL = ?, CHUCVU = ?, MUCLUONG = ?, ANHDAIDIEN = ?, MATKHAU = ?");
        sql.append("WHERE ID = ?");
        update(sql.toString(), nhanVienModel.getHoTen(), nhanVienModel.getNgaySinh(), nhanVienModel.isGioiTinh(),
                nhanVienModel.getDiaChi(), nhanVienModel.getSdt(), nhanVienModel.getEmail(), nhanVienModel.getChucVu(),
                nhanVienModel.getLuong(), nhanVienModel.getAnhDaiDien(), nhanVienModel.getMatKhau(),
                nhanVienModel.getId());
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE NHANVIEN WHERE ID = ?";
        update(sql, id);
    }

    @Override
    public NhanVienModel findOne(Integer id) {
        String sql = "SELECT*FROM NHANVIEN WHERE ID = ?";
        List<NhanVienModel> listNhanVien = query(sql, new NhanVienMapper(), id);
        return listNhanVien.isEmpty() ? null : listNhanVien.get(0);
    }

    @Override
    public List<NhanVienModel> filterByIdAndName(String idOrName) {
        String sql = "SELECT*FROM NHANVIEN WHERE ID LIKE ? OR HOTEN LIKE ?";
        // dấu ? k để thế đc, đó
        // what sao nãy t coppy đoạnm này sang bên kia xóa '% cũng k đc ???
        return query(sql, new NhanVienMapper(), idOrName, idOrName); // run ok, ra ko có đó
        // ơ chạy thử kiểu j thế
        // đc k nhi, ko ra đâu
        // để t thử xem
        // ra đó
        // ^^ k ra hicc, éo biết thêm % kiểu j giờ,
    }
}
