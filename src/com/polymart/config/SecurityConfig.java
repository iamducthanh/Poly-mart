package com.polymart.config;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SecurityConfig {

    public static final String VAITRO_QUANLY = "QUẢN LÝ";
    public static final String VAITRO_BANHANG = "NHÂN VIÊN BÁN HÀNG";
    public static final String VAITRO_THUNGAN = "NHÂN VIÊN THU NGÂN";

    //String: VaiTro
    //List<Component> ChucNang
    private static final Map<String, List<Component>> mapConfig = new HashMap<String, List<Component>>();

    static {
        init();
    }

    private static void init() {

        //Cấu hình vai trò cho "QUẢN LÝ"
        List<Component> functionQuanLy = new ArrayList<Component>();
        functionQuanLy.add(null);

        mapConfig.put(VAITRO_QUANLY, functionQuanLy);

        //Cấu hình vai trò cho "NHÂN VIÊN BÁN HÀNG"
        List<Component> functionBanHang = new ArrayList<Component>();
        functionBanHang.add(null);

        mapConfig.put(VAITRO_QUANLY, functionBanHang);

        //Cấu hình vai trò cho "NHÂN VIÊN THU NGÂN"
        List<Component> functionThuNgan = new ArrayList<Component>();
        functionThuNgan.add(null);

        mapConfig.put(VAITRO_QUANLY, functionThuNgan);
    }

    public static Set<String> getAllRoles() {
        return mapConfig.keySet();
    }

    public static List<Component> getAllFunctionForRole(String VaiTro) {
        return mapConfig.get(VaiTro);
    }
}
