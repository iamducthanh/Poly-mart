package com.polymart.dao;

import com.polymart.model.KhachHangModel;

import java.util.List;

public interface IKhachHangDAO extends GenericDAO<KhachHangModel> {

    List<KhachHangModel> findAll();

}
