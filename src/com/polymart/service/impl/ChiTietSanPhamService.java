package com.polymart.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.polymart.dao.IChiTietSanPhamDAO;
import com.polymart.dao.impl.ChiTietSanPhamDAO;
import com.polymart.model.AnhSanPhamModel;
import com.polymart.model.ChiTietHoaDonNhapHangModel;
import com.polymart.model.ChiTietHoaDonThanhToanModel;
import com.polymart.model.ChiTietSanPhamModel;
import com.polymart.service.IAnhSanPhamService;
import com.polymart.service.IChiTietSanPhamService;
import com.polymart.service.ISanPhamService;

public class ChiTietSanPhamService implements IChiTietSanPhamService {

    private static IChiTietSanPhamDAO chiTietSanPhamDAO = new ChiTietSanPhamDAO();
    private static List<ChiTietSanPhamModel> lstChiTietSanPhamModels = chiTietSanPhamDAO.findAll();
    private IAnhSanPhamService anhSanPhamService = new AnhSanPhamService();

    @Override
    public List<ChiTietSanPhamModel> findAll() {
        Collections.reverse(lstChiTietSanPhamModels);
        return lstChiTietSanPhamModels.stream().filter(e -> e.getStatus()).collect(Collectors.toList());
    }

    // tìm kiếm theo mã hoặc tên sản phẩm
    @Override
    public List<ChiTietSanPhamModel> findByIdOrNameProduct(String input) {
        return chiTietSanPhamDAO.findByIdOrNameProduct(input);
    }

    @Override
    public List<ChiTietSanPhamModel> findAllByHoaDonThanhToan() {
        return lstChiTietSanPhamModels.stream().filter(e -> e.getStatus() && e.getSoLuong() > 0).collect(Collectors.toList());
    }

    @Override
    public int saveProduct(List<ChiTietSanPhamModel> lstChiTietSanPham, List<String> lstPhoto) {
        int rowCountSave = 0;
        int id = -1;
        String[] arrPhoto;
        AnhSanPhamModel anhSanPhamModel;
        for (int j = 0; j < lstChiTietSanPham.size(); j++) {
            id = chiTietSanPhamDAO.save(lstChiTietSanPham.get(j));
            if (id > 0) {
                lstChiTietSanPham.get(j).setId(id);
                arrPhoto = lstPhoto.get(j).split(",");
                for (int i = 0; i < arrPhoto.length; i++) {
                    anhSanPhamModel = new AnhSanPhamModel();
                    anhSanPhamModel.setIdChiTietSanPham(id);
                    anhSanPhamModel.setTenAnh(arrPhoto[i].trim());
                    anhSanPhamService.saveAnhSanPhamById(anhSanPhamModel);
                }
                rowCountSave++;
                lstChiTietSanPhamModels.add(lstChiTietSanPham.get(j));
            }
        }
        if (rowCountSave > 0) {
            lstChiTietSanPhamModels = chiTietSanPhamDAO.findAll();
        }
        return rowCountSave;
    }

    @Override
    public Integer getIdProductById(Integer id) {
        var ref = new Object() {
            int idSp = -1;
        };
        lstChiTietSanPhamModels.forEach(e -> {
            if (e.getId().equals(id) && e.getStatus()) {
                ref.idSp = e.getIdSanPham();
            }
        });
        return ref.idSp;
    }

    @Override
    public void reloadData() {
        lstChiTietSanPhamModels = chiTietSanPhamDAO.findAll();
    }

    @Override
    public ChiTietSanPhamModel getById(Integer id) {
        var ref = new Object() {
            ChiTietSanPhamModel chiTietSanPhamModel = null;
        };
        lstChiTietSanPhamModels.forEach(e -> {
            if (e.getId().equals(id) && e.getStatus()) {
                ref.chiTietSanPhamModel = e;
            }
        });
        return ref.chiTietSanPhamModel;
    }

    @Override
    public boolean updatePrice(int id, Long giaBan, Long giaGiam) {
        return chiTietSanPhamDAO.updatePrice(id, giaBan, giaGiam);
    }

    @Override
    public boolean checkThemMoiSanPham(ChiTietSanPhamModel chiTietSanPhamModel) {
        return lstChiTietSanPhamModels.stream().filter(e ->
                e.getIdSanPham().equals(chiTietSanPhamModel.getIdSanPham())
                        && e.getMauSac().equalsIgnoreCase(chiTietSanPhamModel.getMauSac())
                        && e.getSize().equalsIgnoreCase(chiTietSanPhamModel.getSize())).collect(Collectors.toList()).isEmpty();
    }
}
