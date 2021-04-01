package com.polymart.service;

import java.util.List;

import com.polymart.model.NguonHangModel;

public interface INguonHangService {
	
	List<NguonHangModel> findAll();
	
	List<NguonHangModel> findByName(String name);
}
