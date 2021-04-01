package com.polymart.service;

import com.polymart.model.KhachHangModel;

import java.util.List;

public interface IKhachHangService {
    List<KhachHangModel> findAll();

    List<KhachHangModel> findByNameOrPhoneNumber(String input);

    KhachHangModel save(KhachHangModel khachHangModel);

}
