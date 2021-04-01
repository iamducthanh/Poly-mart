package com.polymart.ui;

import com.polymart.service.INhanVienService;
import com.polymart.service.impl.NhanVienService;

public class Test {

    public static void main(String[] args) {
        INhanVienService iNhanVienService = new NhanVienService();
        System.out.println("kết quả " + iNhanVienService.filterByIdAndName("Nguyễn Quang Ngọc"));
    }
}
