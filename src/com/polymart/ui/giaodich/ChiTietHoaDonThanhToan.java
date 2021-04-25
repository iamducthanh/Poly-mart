package com.polymart.ui.giaodich;

import java.awt.*;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.polymart.entity.EntityValidate;
import com.polymart.model.ChiTietHoaDonThanhToanModel;
import com.polymart.model.ChiTietSanPhamModel;
import com.polymart.service.IChiTietSanPhamService;
import com.polymart.service.IKhachHangService;
import com.polymart.service.ISanPhamService;
import com.polymart.service.impl.ChiTietSanPhamService;
import com.polymart.service.impl.KhachHangService;
import com.polymart.service.impl.SanPhamService;

import javax.swing.JTextArea;

public class ChiTietHoaDonThanhToan extends JFrame {

    private static final long serialVersionUID = -1667093807201607235L;

    private JPanel contentPane;
    private JTable tableChiTietHoaDonThanhToan;
    private DefaultTableModel modelChiTietHoaDonThanhToan;

    private JLabel lblDiemDaDoi;
    private JLabel lblTenKhachHang;
    private JLabel lblMaHoaDon;
    private JTextArea txtGhiChu;

    private ISanPhamService sanPhamService = new SanPhamService();
    private IChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamService();
    private IKhachHangService khachHangService = new KhachHangService();

    public ChiTietHoaDonThanhToan() throws HeadlessException {
        init();
    }

    public ChiTietHoaDonThanhToan(List<ChiTietHoaDonThanhToanModel> lstChiTietHoaDonThanhToanModels, int idKhachHang,
                                  int diemDaDoi, String ghiChu) {
        init();

        if (!lstChiTietHoaDonThanhToanModels.isEmpty()) {
            lblMaHoaDon.setText(lstChiTietHoaDonThanhToanModels.get(0).getHoaDonThanhToan().toString());
            lblTenKhachHang.setText(khachHangService.findOne(idKhachHang).getHoTen());
            lblDiemDaDoi.setText(String.valueOf(diemDaDoi));
            txtGhiChu.setText(ghiChu);
        }
        modelChiTietHoaDonThanhToan.setRowCount(0);
        for (ChiTietHoaDonThanhToanModel e : lstChiTietHoaDonThanhToanModels) {
            ChiTietSanPhamModel chiTietSanPhamModel = chiTietSanPhamService.getById(e.getChiTietSanPham());
            modelChiTietHoaDonThanhToan.addRow(new Object[]{e.getChiTietSanPham(),
                    sanPhamService.findByID(chiTietSanPhamService.getIdProductById(e.getChiTietSanPham())).getTenSP(),
                    e.getSoLuong(), EntityValidate.dinhDangMonney(chiTietSanPhamModel.getGiaBan()), EntityValidate.dinhDangMonney(chiTietSanPhamModel.getGiaGiam()),
                    EntityValidate.dinhDangMonney(e.getGiamGiaThem()),
                    EntityValidate.dinhDangMonney(e.getTraHang()),
                    EntityValidate.dinhDangMonney(e.getSoLuong() * (chiTietSanPhamModel.getGiaBan() - chiTietSanPhamModel.getGiaGiam()) - e.getGiamGiaThem())});
        }
        tableChiTietHoaDonThanhToan.setRowHeight(25);
    }

    private void init() {
        modelChiTietHoaDonThanhToan = new DefaultTableModel() {

            private static final long serialVersionUID = 3913815213671293282L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        setTitle("Chi tiết hóa đơn thanh toán");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setBounds(100, 100, 877, 594);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JLabel lblNewLabel = new JLabel("Chi tiết hóa đơn thanh toán");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setBounds(20, 11, 307, 39);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Mã hóa đơn thanh toán: ");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(30, 61, 170, 25);
        contentPane.add(lblNewLabel_1);

        lblMaHoaDon = new JLabel("Cái label này để hiển thị mã hóa đơn thanh toán");
        lblMaHoaDon.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblMaHoaDon.setBounds(210, 61, 387, 25);
        contentPane.add(lblMaHoaDon);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 247, 819, 299);
        contentPane.add(scrollPane);

        tableChiTietHoaDonThanhToan = new JTable();
        scrollPane.setViewportView(tableChiTietHoaDonThanhToan);

        JLabel lblNewLabel_1_1 = new JLabel("Khách hàng:");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(30, 96, 170, 25);
        contentPane.add(lblNewLabel_1_1);

        lblTenKhachHang = new JLabel("Cái label này để hiển thị khách hàng");
        lblTenKhachHang.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTenKhachHang.setBounds(136, 97, 387, 25);
        contentPane.add(lblTenKhachHang);

        modelChiTietHoaDonThanhToan.addColumn("Mã sản phẩm");
        modelChiTietHoaDonThanhToan.addColumn("Tên sản phẩm");
        modelChiTietHoaDonThanhToan.addColumn("Số lượng");
        modelChiTietHoaDonThanhToan.addColumn("Đơn giá");
        modelChiTietHoaDonThanhToan.addColumn("Giảm giá");
        modelChiTietHoaDonThanhToan.addColumn("Giá giám thêm");
        modelChiTietHoaDonThanhToan.addColumn("Trả hàng");
        modelChiTietHoaDonThanhToan.addColumn("Thành tiền");
        tableChiTietHoaDonThanhToan.setModel(modelChiTietHoaDonThanhToan);

        JLabel lblNewLabel_1_1_1 = new JLabel("Điểm đã đổi:");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1_1.setBounds(30, 132, 170, 25);
        contentPane.add(lblNewLabel_1_1_1);

        lblDiemDaDoi = new JLabel("Cái label này để hiển thị điểm đã đổi");
        lblDiemDaDoi.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblDiemDaDoi.setBounds(136, 133, 387, 25);
        contentPane.add(lblDiemDaDoi);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Ghi chú:");
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1_1_1.setBounds(30, 168, 81, 25);
        contentPane.add(lblNewLabel_1_1_1_1);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(136, 170, 387, 66);
        contentPane.add(scrollPane_1);

        txtGhiChu = new JTextArea();
        txtGhiChu.setEditable(false);
        scrollPane_1.setViewportView(txtGhiChu);
    }
}
