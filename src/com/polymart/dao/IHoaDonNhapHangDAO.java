package com.polymart.dao;

import com.polymart.model.HoaDonNhapHangModel;

public interface IHoaDonNhapHangDAO extends GenericDAO<HoaDonNhapHangModel> {

    Integer save(HoaDonNhapHangModel hoaDonNhapHangModel);

}
