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

import com.polymart.model.ChiTietHoaDonThanhToanModel;
import com.polymart.model.ChiTietHoaDonTraHangModel;
import com.polymart.model.ChiTietSanPhamModel;
import com.polymart.model.SanPhamModel;
import com.polymart.service.IChiTietHoaDonThanhToanService;
import com.polymart.service.IChiTietSanPhamService;
import com.polymart.service.ISanPhamService;
import com.polymart.service.impl.ChiTietHoaDonThanhToanService;
import com.polymart.service.impl.ChiTietSanPhamService;
import com.polymart.service.impl.SanPhamService;
import javax.swing.JTextArea;

public class ChiTietHoaDonTraHang extends JFrame {

    private static final long serialVersionUID = 8080716429179868714L;

    private JPanel contentPane;
    private JTable tableChiTietHoaDonTraHang;
    private DefaultTableModel modelChiTietHoaDonTraHang;

    private JLabel lblMaHoaDon;

    private IChiTietHoaDonThanhToanService chiTietHoaDonThanhToanService = new ChiTietHoaDonThanhToanService();
    private IChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamService();
    private ISanPhamService sanPhamService = new SanPhamService();

    public ChiTietHoaDonTraHang() throws HeadlessException {
        init();
    }

    public ChiTietHoaDonTraHang(List<ChiTietHoaDonTraHangModel> lstChiTietHoaDonTraHangModels) {
        init();
        modelChiTietHoaDonTraHang.setRowCount(0);
        for (ChiTietHoaDonTraHangModel x : lstChiTietHoaDonTraHangModels) {
            ChiTietHoaDonThanhToanModel chiTietHoaDonThanhToanModel = chiTietHoaDonThanhToanService.findById(x.getIdHoaDonThanhToanChiTiet());
            ChiTietSanPhamModel chiTietSanPhamModel = chiTietSanPhamService.getById(chiTietHoaDonThanhToanModel.getChiTietSanPham());
            SanPhamModel sanPhamModel = sanPhamService.findByID(chiTietSanPhamModel.getIdSanPham());
            lblMaHoaDon.setText(x.getIdHoaDonTraHang().toString());
            modelChiTietHoaDonTraHang.addRow(new Object[]{
                    chiTietSanPhamModel.getId(),
                    sanPhamModel.getTenSP(),
                    chiTietSanPhamModel.getSize(),
                    chiTietSanPhamModel.getMauSac(),
                    x.getSoLuong(),
                    chiTietSanPhamModel.getGiaBan(),
                    chiTietSanPhamModel.getGiaGiam(),
                    x.getSoLuong() * (chiTietSanPhamModel.getGiaBan() - chiTietSanPhamModel.getGiaGiam())
            });
        }
        tableChiTietHoaDonTraHang.setRowHeight(25);
    }

    private void init() {
        modelChiTietHoaDonTraHang = new DefaultTableModel() {

            private static final long serialVersionUID = -4228410111804596908L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        setTitle("Chi tiết hóa đơn trả hàng");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setBounds(100, 100, 877, 594);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Chi tiết hóa đơn trả hàng");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setBounds(20, 11, 307, 39);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Mã hóa đơn trả hàng: ");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(30, 61, 170, 25);
        contentPane.add(lblNewLabel_1);

        lblMaHoaDon = new JLabel("Cái label này để hiển thị mã hóa đơn trả hàng");
        lblMaHoaDon.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblMaHoaDon.setBounds(210, 61, 387, 25);
        contentPane.add(lblMaHoaDon);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 221, 819, 325);
        contentPane.add(scrollPane);

        tableChiTietHoaDonTraHang = new JTable();
        scrollPane.setViewportView(tableChiTietHoaDonTraHang);

        modelChiTietHoaDonTraHang.addColumn("Mã sản phẩm");
        modelChiTietHoaDonTraHang.addColumn("Tên sản phẩm");
        modelChiTietHoaDonTraHang.addColumn("Size");
        modelChiTietHoaDonTraHang.addColumn("Màu sắc");
        modelChiTietHoaDonTraHang.addColumn("Số lượng");
        modelChiTietHoaDonTraHang.addColumn("Đơn giá");
        modelChiTietHoaDonTraHang.addColumn("Giảm giá");
        modelChiTietHoaDonTraHang.addColumn("Thành tiền");
        tableChiTietHoaDonTraHang.setModel(modelChiTietHoaDonTraHang);
        
        JLabel lblNewLabel_1_1 = new JLabel("Ghi chú:");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(30, 97, 106, 25);
        contentPane.add(lblNewLabel_1_1);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(183, 97, 387, 104);
        contentPane.add(scrollPane_1);
        
        JTextArea txtGhiChu = new JTextArea();
        scrollPane_1.setViewportView(txtGhiChu);
    }
}
