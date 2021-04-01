package com.polymart.dao.impl;

import com.polymart.dao.IKhachHangDAO;
import com.polymart.mapper.KhachHangMapper;
import com.polymart.model.KhachHangModel;

import java.util.List;

public class KhachHangDAO extends AbstractDAO<KhachHangModel> implements IKhachHangDAO {
    @Override
    public List<KhachHangModel> findAll() {
        String sql = "SELECT * FROM KHACHHANG";
        return query(sql, new KhachHangMapper());
    }
}
