package com.polymart.entity;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EntityFormat {
    public static String dinhDangMonney(long l) {
        Locale locale = new Locale("vi", "VN");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        return format.format(l);
    }

    public static String dinhDangNgay(Date d) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        return simpleDateFormat.format(d);
    }
}
