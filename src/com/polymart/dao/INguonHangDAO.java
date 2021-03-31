package com.polymart.dao;

import com.polymart.model.NguonHangModel;

import java.util.List;

public interface INguonHangDAO extends GenericDAO<NguonHangModel> {

    List<NguonHangModel> findAll();
    
    List<NguonHangModel> findByName(String name);
}
