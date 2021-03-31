package com.polymart.dao.impl;

import com.polymart.dao.INguonHangDAO;
import com.polymart.mapper.NguonHangMapper;
import com.polymart.model.NguonHangModel;

import java.util.List;

public class NguonHangDAO extends AbstractDAO<NguonHangModel> implements INguonHangDAO {

    @Override
    public List<NguonHangModel> fillAll() {
        String sql = "SELECT * FROM NGUONHANG";
        return query(sql, new NguonHangMapper());
    }
}
