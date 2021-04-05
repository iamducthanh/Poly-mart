package com.polymart.dao;

import com.polymart.model.ChiTietHoaDonTraHangModel;

public interface IChiTietHoaDonTraHangDAO extends GenericDAO<ChiTietHoaDonTraHangModel> {

    boolean save(ChiTietHoaDonTraHangModel chiTietHoaDonTraHangModel);

}
