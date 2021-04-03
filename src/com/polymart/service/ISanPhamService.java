package com.polymart.service;

import com.polymart.model.SanPhamModel;

import java.util.List;

public interface ISanPhamService {

    List<SanPhamModel> findAll();

    SanPhamModel findByID(Integer id);

}
