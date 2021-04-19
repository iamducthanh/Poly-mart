package com.polymart.service.impl;

import com.polymart.dao.IAnhSanPhamDAO;
import com.polymart.dao.impl.AnhSanPhamDAO;
import com.polymart.model.AnhSanPhamModel;
import com.polymart.service.IAnhSanPhamService;

import java.util.List;
import java.util.stream.Collectors;

public class AnhSanPhamService implements IAnhSanPhamService {

    private static IAnhSanPhamDAO anhSanPhamDAO = new AnhSanPhamDAO();
    private static List<AnhSanPhamModel> lstAnhSanPhamModels = anhSanPhamDAO.findAll();

    @Override
    public List<AnhSanPhamModel> getByIdCtsp(int idSp) {
        return lstAnhSanPhamModels.stream().filter(e -> e.getIdChiTietSanPham().equals(idSp)).collect(Collectors.toList());
    }

    @Override
    public boolean saveAnhSanPhamById(AnhSanPhamModel anhSanPhamModel) {
        return anhSanPhamDAO.save(anhSanPhamModel);
    }

    @Override
    public void reloadDta() {
        lstAnhSanPhamModels = anhSanPhamDAO.findAll();
    }
}
