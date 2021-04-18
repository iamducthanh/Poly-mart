package com.polymart.service;

import com.polymart.model.AnhSanPhamModel;

import java.util.List;

public interface IAnhSanPhamService {

    List<AnhSanPhamModel> getByIdCtsp(int idSp);

    boolean saveAnhSanPhamById(AnhSanPhamModel anhSanPhamModel);

    void reloadDta();

}
