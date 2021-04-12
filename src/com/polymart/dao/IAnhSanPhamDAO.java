package com.polymart.dao;

import com.polymart.model.AnhSanPhamModel;

import java.util.List;

public interface IAnhSanPhamDAO extends GenericDAO<AnhSanPhamModel> {
    List<AnhSanPhamModel> findAll();

    List<AnhSanPhamModel> getByIdCtsp(int idSp);
}
