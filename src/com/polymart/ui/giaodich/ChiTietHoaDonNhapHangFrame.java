package com.polymart.ui.giaodich;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.polymart.model.ChiTietHoaDonNhapHangModel;
import com.polymart.service.IChiTietSanPhamService;
import com.polymart.service.ISanPhamService;
import com.polymart.service.impl.ChiTietSanPhamService;
import com.polymart.service.impl.SanPhamService;

public class ChiTietHoaDonNhapHangFrame extends JFrame {

    private static final long serialVersionUID = -1275654074282876688L;

    private JPanel contentPane;
    private JTable tableChiTietHoaDonNhap;
    private DefaultTableModel modelChiTietHoaDonNhap;

    private JLabel lblMaHoaDon;
    private JLabel lblTenNguonHang;

    private ISanPhamService sanPhamService = new SanPhamService();
    private IChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamService();

    public ChiTietHoaDonNhapHangFrame() throws HeadlessException {
        init();
    }

    public ChiTietHoaDonNhapHangFrame(List<ChiTietHoaDonNhapHangModel> lstChiTietHoaDonNhapHang, String nguonHang) {
        init();
        setForm(lstChiTietHoaDonNhapHang, nguonHang, lblMaHoaDon, lblTenNguonHang);
    }

    private void init() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("images\\fpt.png"));
        modelChiTietHoaDonNhap = new DefaultTableModel() {

            private static final long serialVersionUID = 7584408658853210846L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        setTitle("Chi tiết hóa đơn nhập hàng");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setBounds(100, 100, 877, 594);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JLabel lblNewLabel = new JLabel("Chi tiết hóa đơn nhập hàng");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setBounds(20, 11, 307, 39);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Mã hóa đơn nhập hàng: ");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(30, 61, 170, 25);
        contentPane.add(lblNewLabel_1);

        lblMaHoaDon = new JLabel("Cái label này để hiển thị mã hóa đơn nhập hàng");
        lblMaHoaDon.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblMaHoaDon.setBounds(210, 61, 387, 25);
        contentPane.add(lblMaHoaDon);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 155, 819, 391);
        contentPane.add(scrollPane);

        tableChiTietHoaDonNhap = new JTable();
        scrollPane.setViewportView(tableChiTietHoaDonNhap);

        JLabel lblNewLabel_1_1 = new JLabel("Nguồn hàng:");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(30, 96, 170, 25);
        contentPane.add(lblNewLabel_1_1);

        lblTenNguonHang = new JLabel("Cái label này để hiển thị nguồn hàng");
        lblTenNguonHang.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTenNguonHang.setBounds(136, 97, 387, 25);
        contentPane.add(lblTenNguonHang);

        modelChiTietHoaDonNhap.addColumn("Mã sản phẩm");
        modelChiTietHoaDonNhap.addColumn("Tên sản phẩm");
        modelChiTietHoaDonNhap.addColumn("Số lượng");
        modelChiTietHoaDonNhap.addColumn("Đơn giá");
        modelChiTietHoaDonNhap.addColumn("Thành tiền");
        tableChiTietHoaDonNhap.setModel(modelChiTietHoaDonNhap);
    }

    private void setForm(List<ChiTietHoaDonNhapHangModel> lstChiTietHoaDonNhapHang, String nguonHang,
                         JLabel lblMaHoaDon, JLabel lblTenNguonHang) {
        if (lstChiTietHoaDonNhapHang != null && !lstChiTietHoaDonNhapHang.isEmpty()) {
            lblMaHoaDon.setText(lstChiTietHoaDonNhapHang.get(0).getIdHoaDonNhapHang().toString());
            lblTenNguonHang.setText(nguonHang);
            for (ChiTietHoaDonNhapHangModel x : lstChiTietHoaDonNhapHang) {
                modelChiTietHoaDonNhap.addRow(new Object[]{
                        x.getIdChiTietSanPham(), sanPhamService
                        .findByID(chiTietSanPhamService.getIdProductById(x.getIdChiTietSanPham())).getTenSP(),
                        x.getSoLuong(), x.getGiaNhap(), x.getGiaNhap() * x.getSoLuong()});
            }
        }
        tableChiTietHoaDonNhap.setRowHeight(25);
    }
}
