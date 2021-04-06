package com.polymart.ui.giaodich;

import com.polymart.entity.EntityAuthorization;
import com.polymart.entity.EntityMessage;
import com.polymart.entity.EntityValidate;
import com.polymart.model.*;
import com.polymart.service.*;
import com.polymart.service.impl.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class ThemHoaDonThanhToanJInternalFrame extends JInternalFrame {

    private static final long serialVersionUID = -2254544205302634680L;

    private JPanel contentPane;
    private DefaultTableModel modelDSSanPham;
    private DefaultTableModel modelDSThanhToan;

    private JTextField txtTimKiem;
    private JTable tableDSSanPham;
    private JTextField txtSoLgBan;
    private JTable tableDSNhapHang;
    private JTextField txtGiaGiamThem;

    private IChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamService();
    private ISanPhamService sanPhamService = new SanPhamService();
    private ILoaiSanPhamService loaiSanPhamService = new LoaiSanPhamService();
    private IHoaDonThanhToanService hoaDonThanhToanService = new HoaDonThanhToanService();
    private IChiTietHoaDonThanhToanService chiTietHoaDonThanhToanService = new ChiTietHoaDonThanhToanService();
    private IKhachHangService khachHangService = new KhachHangService();

    private List<ChiTietSanPhamModel> lstTietSanPham = chiTietSanPhamService.findAll();
    private List<KhachHangModel> lstKhachHang = khachHangService.findAll();
    private List<ChiTietHoaDonThanhToanModel> lstChiTietHoaDonThanhToanModels = new ArrayList<>();

    private ChiTietHoaDonThanhToanModel chiTietHoaDonThanhToanModel = null;
    private ChiTietSanPhamModel chiTietSanPhamModel = null;
    private SanPhamModel sanPhamModel = null;
    private JTextField textField;

    private ThanhToanJInternalFrame thanhToanJInternalFrame = null;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ThemHoaDonThanhToanJInternalFrame frame = new ThemHoaDonThanhToanJInternalFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */

    public ThemHoaDonThanhToanJInternalFrame() {
    }

    public ThemHoaDonThanhToanJInternalFrame(ThanhToanJInternalFrame thanhToanJInternalFrame) {
        this.thanhToanJInternalFrame = thanhToanJInternalFrame;
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        modelDSThanhToan = new DefaultTableModel() {

            private static final long serialVersionUID = 85061541709242169L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelDSSanPham = new DefaultTableModel() {

            private static final long serialVersionUID = -8294453440840014339L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1920, 639);

        setFocusable(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.NORTH);

        JButton btnQuayLai = new JButton("<-   ");
        btnQuayLai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });
        btnQuayLai.setContentAreaFilled(false);
        btnQuayLai.setBorder(null);
        btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 17));

        JLabel lblNewLabel = new JLabel("Thanh toán bán hàng");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));

        txtTimKiem = new JTextField();
        txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtTimKiem.setText(" Tìm theo tên hoặc mã sản phẩm");
        txtTimKiem.setColumns(10);

        JButton btnTimKiem = new JButton("Tìm kiếm");
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel_1.createSequentialGroup().addGap(5).addComponent(btnQuayLai).addGap(5)
                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                        .addGap(557)));
        gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
                .createSequentialGroup().addGap(5)
                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                .addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnQuayLai, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        panel_1.setLayout(gl_panel_1);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_4 = new JPanel();
        panel.add(panel_4, BorderLayout.SOUTH);

        txtSoLgBan = new JTextField();
        txtSoLgBan.setColumns(10);

        JButton btnLuuTam = new JButton("Lưu tạm");

        JLabel lblSoLuongBan = new JLabel("Số lượng bán:");
        lblSoLuongBan.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JLabel lblGiaGiamThem = new JLabel("Giá giảm thêm:");
        lblGiaGiamThem.setFont(new Font("Tahoma", Font.PLAIN, 16));

        txtGiaGiamThem = new JTextField("0");
        txtGiaGiamThem.setColumns(10);

        JLabel lbliim = new JLabel("Đổi điểm");
        lbliim.setFont(new Font("Tahoma", Font.PLAIN, 16));

        textField = new JTextField("0");
        textField.setColumns(10);
        GroupLayout gl_panel_4 = new GroupLayout(panel_4);
        gl_panel_4.setHorizontalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel_4.createSequentialGroup().addContainerGap()
                        .addComponent(lblSoLuongBan, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(txtSoLgBan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(18).addComponent(lblGiaGiamThem).addGap(34)
                        .addComponent(txtGiaGiamThem, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                        .addGap(18).addComponent(lbliim, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                        .addGap(34).addComponent(textField, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                        .addGap(50).addComponent(btnLuuTam, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                        .addGap(957)));
        gl_panel_4.setVerticalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_4
                .createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblGiaGiamThem, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblSoLuongBan, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSoLgBan, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
                .addGroup(gl_panel_4.createSequentialGroup().addGap(13)
                        .addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
                                .addComponent(lbliim, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGroup(gl_panel_4.createSequentialGroup().addGap(2).addComponent(textField,
                                        GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(txtGiaGiamThem, GroupLayout.PREFERRED_SIZE, 30,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnLuuTam, GroupLayout.PREFERRED_SIZE, 30,
                                                GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap()));
        panel_4.setLayout(gl_panel_4);

        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new TitledBorder(
                new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
                " Th\u00F4ng tin s\u1EA3n ph\u1EA9m ", TitledBorder.LEADING, TitledBorder.TOP, null,
                new Color(0, 0, 0)));
        panel.add(panel_5, BorderLayout.CENTER);
        panel_5.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        panel_5.add(scrollPane, BorderLayout.CENTER);

        tableDSSanPham = new JTable();
        scrollPane.setViewportView(tableDSSanPham);

        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new TitledBorder(
                new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
                " Danh s\u00E1ch thanh to\u00E1n ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        contentPane.add(panel_2, BorderLayout.SOUTH);

        JScrollPane scrollPane_1 = new JScrollPane();

        JComboBox<Object> cbbKhachHang = new JComboBox<Object>();
        cbbKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cbbKhachHang.setModel(new DefaultComboBoxModel<Object>(new String[]{"Chọn khách hàng"}));

        JLabel lblNewLabel_1_1 = new JLabel("Ghi chú");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JScrollPane scrollPane_2 = new JScrollPane();

        JLabel lblNewLabel_1 = new JLabel("Thành tiền", JLabel.RIGHT);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));

        JLabel lblTongTien = new JLabel("0", SwingConstants.RIGHT);
        lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 20));

        JButton btnHoanThanh = new JButton("Hoàn thành");

        JButton btnXoa = new JButton("- Xóa");
        GroupLayout gl_panel_2 = new GroupLayout(panel_2);
        gl_panel_2
                .setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
                        gl_panel_2.createSequentialGroup()
                                .addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(
                                                gl_panel_2
                                                        .createSequentialGroup().addContainerGap().addComponent(btnXoa,
                                                        GroupLayout.PREFERRED_SIZE, 76,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE))
                                .addGap(18)
                                .addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_panel_2.createSequentialGroup()
                                                .addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(cbbKhachHang, GroupLayout.PREFERRED_SIZE, 265,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 201,
                                                                GroupLayout.PREFERRED_SIZE))
                                                .addGap(81))
                                        .addGroup(gl_panel_2
                                                .createSequentialGroup()
                                                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 122,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(gl_panel_2.createSequentialGroup().addGroup(gl_panel_2
                                                .createParallelGroup(Alignment.LEADING, false)
                                                .addComponent(lblTongTien, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(scrollPane_2, Alignment.TRAILING,
                                                        GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
                                                .addContainerGap())
                                        .addGroup(gl_panel_2
                                                .createSequentialGroup().addComponent(btnHoanThanh,
                                                        GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap()))));
        gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_2
                .createSequentialGroup().addContainerGap()
                .addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_2.createSequentialGroup()
                                .addComponent(cbbKhachHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNewLabel_1_1)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_1).addGap(18)
                                .addComponent(lblTongTien, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                                .addComponent(btnHoanThanh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_panel_2.createSequentialGroup()
                                .addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))

        );

        JTextArea txtGhiChu = new JTextArea();
        scrollPane_2.setViewportView(txtGhiChu);

        tableDSNhapHang = new JTable();
        scrollPane_1.setViewportView(tableDSNhapHang);
        panel_2.setLayout(gl_panel_2);
        modelDSSanPham.addColumn("Mã sản phẩm");
        modelDSSanPham.addColumn("Tên sản phẩm");
        modelDSSanPham.addColumn("Loại");
        modelDSSanPham.addColumn("Size");
        modelDSSanPham.addColumn("Màu sắc");
        modelDSSanPham.addColumn("Số lượng tồn kho");
        tableDSSanPham.setModel(modelDSSanPham);

        modelDSThanhToan.addColumn("Mã sản phẩm");
        modelDSThanhToan.addColumn("Tên sản phẩm");
        modelDSThanhToan.addColumn("Loại");
        modelDSThanhToan.addColumn("Đơn giá");
        modelDSThanhToan.addColumn("Giá giảm");
        modelDSThanhToan.addColumn("Giá giảm thêm");
        modelDSThanhToan.addColumn("Size");
        modelDSThanhToan.addColumn("Màu sắc");
        modelDSThanhToan.addColumn("Số lượng bán");
        tableDSNhapHang.setModel(modelDSThanhToan);

        txtTimKiem.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtTimKiem.getText().equals("Tìm theo tên hoặc mã sản phẩm")) {
                    txtTimKiem.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtTimKiem.getText().equals("")) {
                    txtTimKiem.setText("Tìm theo tên hoặc mã sản phẩm");
                }
            }
        });

        // tìm kiếm theo mã hoặc tên sản phẩm
        btnTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evtBtnSearchProductByIdOrName(txtTimKiem);
            }
        });

        // lưu tạm sản phảm
        btnLuuTam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evtBtnAddProductToTable(txtSoLgBan, txtGiaGiamThem, tableDSSanPham, lblTongTien);
            }
        });

        // hiển thị danh sách khách hàng
        evtShowVisit(cbbKhachHang);

        // lưu hóa đơn
        btnHoanThanh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evtBtnHoanThanh(cbbKhachHang, txtGhiChu);
            }
        });

        // hiển thị danh sách sản phẩm
        showTableProduct(lstTietSanPham);
    }

    public void close() {
        this.setVisible(false);
    }

    // chức năng tìm kiếm sản phẩm theo mã hoặc tên sản phẩm
    private void evtBtnSearchProductByIdOrName(JTextField txtInputSearch) {
        String getInputSearch = txtInputSearch.getText();
        if (getInputSearch.equalsIgnoreCase("Tìm theo tên hoặc mã sản phẩm")) {
            lstTietSanPham = chiTietSanPhamService.findAll();
            showTableProduct(lstTietSanPham);
        } else {
            lstTietSanPham = chiTietSanPhamService.findByIdOrNameProduct(getInputSearch);
            if (lstTietSanPham != null && !lstTietSanPham.isEmpty()) {
                showTableProduct(lstTietSanPham);
            } else {
                EntityMessage.show(this, "Không có sản phẩm nào cần tìm");
            }
        }
    }

    // chức năng lưu tạm sản phẩm và số lượng mua vào bảng danh sách thanh toán
    private void evtBtnAddProductToTable(JTextField txtSoLuong, JTextField txtGiaGiamThem, JTable tbSanPham,
                                         JLabel lblTongTien) {
        String getSoLuong = txtSoLuong.getText();
        String getMoney = txtGiaGiamThem.getText();
        if (EntityValidate.checkPositiveNumber(this, getSoLuong) && EntityValidate.checkMoney(this, getMoney)) {
            int row = tbSanPham.getSelectedRow();
            if (row > -1 && row < tbSanPham.getRowCount()) {
                chiTietSanPhamModel = lstTietSanPham.get(row);
                int soLuongDaThem = lstChiTietHoaDonThanhToanModels.stream().filter(e ->
                        e.getChiTietSanPham().equals(chiTietSanPhamModel.getId())).mapToInt(x -> x.getSoLuong()).sum();
                if ((Integer.parseInt(getSoLuong) + soLuongDaThem) <= chiTietSanPhamModel.getSoLuong()) {
                    if (lstChiTietHoaDonThanhToanModels.stream().filter(e ->
                            e.getChiTietSanPham().equals(chiTietSanPhamModel.getId())
                                    && e.getGiamGiaThem().equals(Long.valueOf(getMoney)))
                            .collect(Collectors.toList()).isEmpty()) {
                        if (Integer.parseInt(getSoLuong) <= chiTietSanPhamModel.getSoLuong()) {
                            sanPhamModel = sanPhamService.findByID(chiTietSanPhamModel.getIdSanPham());
                            modelDSThanhToan.addRow(new Object[]{chiTietSanPhamModel.getId(), sanPhamModel.getTenSP(),
                                    loaiSanPhamService.findNameById(sanPhamModel.getIdLoaiSP()),
                                    chiTietSanPhamModel.getGiaBan(), chiTietSanPhamModel.getGiaGiam(), getMoney,
                                    chiTietSanPhamModel.getSize(), chiTietSanPhamModel.getMauSac(), getSoLuong});
                            // taho đôi tượng chi tiest hóa đơn nhập hàng và add vào list
                            chiTietHoaDonThanhToanModel = new ChiTietHoaDonThanhToanModel();
                            chiTietHoaDonThanhToanModel.setGiamGiaThem(Long.valueOf(getMoney));
                            chiTietHoaDonThanhToanModel.setSoLuong(Integer.parseInt(getSoLuong));
                            chiTietHoaDonThanhToanModel.setChiTietSanPham(chiTietSanPhamModel.getId());
                            lstChiTietHoaDonThanhToanModels.add(chiTietHoaDonThanhToanModel);
                            // tính tổng tiền của tất cả sản phẩm có trên table
                            Long tongTien = lstChiTietHoaDonThanhToanModels.stream().mapToLong(
                                    e -> (chiTietSanPhamModel.getGiaBan() * Integer.parseInt(getSoLuong))
                                            - (chiTietSanPhamModel.getGiaGiam() * e.getSoLuong())).sum();
                            lblTongTien.setText(String.valueOf(tongTien - Long.parseLong(getMoney)));
                        } else {
                            EntityMessage.show(this, "Số lượng vượt quá số lượng hàng tồn kho");
                        }
                    } else {
                        int i = 0;
                        for (ChiTietHoaDonThanhToanModel x : lstChiTietHoaDonThanhToanModels) {
                            if (x.getChiTietSanPham().equals(chiTietSanPhamModel.getId())
                                    && x.getGiamGiaThem().equals(Long.valueOf(getMoney))) {
                                int setSoLuong = x.getSoLuong() + Integer.parseInt(getSoLuong);
                                if (setSoLuong <= chiTietSanPhamModel.getSoLuong()) {
                                    x.setSoLuong(setSoLuong);
                                    modelDSThanhToan.setValueAt(setSoLuong, i, 8);
                                    // tính tổng tiền của tất cả sản phẩm có trên table
                                    Long tongTien = lstChiTietHoaDonThanhToanModels.stream().mapToLong(
                                            e -> (chiTietSanPhamModel.getGiaBan() * Integer.parseInt(getSoLuong))
                                                    - (chiTietSanPhamModel.getGiaGiam() * e.getSoLuong())).sum();
                                    lblTongTien.setText(String.valueOf(tongTien - Double.parseDouble(getMoney)));
                                } else {
                                    EntityMessage.show(this, "Số lượng vượt quá số lượng hàng tồn kho");
                                }
                                return;
                            }
                            ++i;
                        }
                    }
                } else {
                    EntityMessage.show(this, "Số lượng vượt quá số lượng hàng tồn kho");
                }
            } else {
                EntityMessage.show(this, "Mời chọn 1 sản phẩm");
            }
        }
    }

    // hiển thị danh sach khách hàng
    private void evtShowVisit(JComboBox<Object> cbcKhachHang) {
        cbcKhachHang.removeAllItems();
        for (KhachHangModel x : lstKhachHang) {
            cbcKhachHang.addItem("KH - " + x.getHoTen());
        }
    }

    // hoàn thành hóa đơn và cập nhật dữ liệu liên quan
    private void evtBtnHoanThanh(JComboBox<Object> cbcKhachHang, JTextArea txaGhiChu) {
        if (!lstChiTietHoaDonThanhToanModels.isEmpty()) {
            HoaDonThanhToanModel hoaDonThanhToanModel = new HoaDonThanhToanModel();
            hoaDonThanhToanModel.setIdKhachHang(lstKhachHang.get(cbcKhachHang.getSelectedIndex()).getId());
            hoaDonThanhToanModel.setIdNhanVien(EntityAuthorization.USER.getId());
            hoaDonThanhToanModel.setGhiChu(txaGhiChu.getText());
            hoaDonThanhToanModel.setDiemDaDoi(0);
            hoaDonThanhToanModel = hoaDonThanhToanService.save(hoaDonThanhToanModel);
            if (hoaDonThanhToanModel != null) {
                int count = 0;
                for (ChiTietHoaDonThanhToanModel x : lstChiTietHoaDonThanhToanModels) {
                    x.setHoaDonThanhToan(hoaDonThanhToanModel.getId());
                    if (chiTietHoaDonThanhToanService.save(x)) {
                        chiTietSanPhamService.updateThanhToan(x);
                        count++;
                    }
                }
                if (count > 0) {
                    EntityMessage.show(this, "Thêm thành công");
                    this.setVisible(false);
                    thanhToanJInternalFrame.showTable(hoaDonThanhToanService.findAll());
                    chiTietSanPhamService.reloadData();
                } else {
                    hoaDonThanhToanService.remove(hoaDonThanhToanModel);
                    EntityMessage.show(this, "Thêm thất bại");
                }
            } else {
                EntityMessage.show(this, "Thêm thất bại");
            }
        } else {
            EntityMessage.show(this, "Chưa thêm sản phẩm");
        }
    }

    // hiển thị danh sách sản phẩm lên table
    private void showTableProduct(List<ChiTietSanPhamModel> lstTietSanPham) {
        if (!lstTietSanPham.isEmpty()) {
            modelDSSanPham.setRowCount(0);
            for (ChiTietSanPhamModel x : lstTietSanPham) {
                sanPhamModel = sanPhamService.findByID(x.getIdSanPham());
                modelDSSanPham.addRow(new Object[]{x.getId(), sanPhamModel.getTenSP(),
                        loaiSanPhamService.findNameById(sanPhamModel.getIdLoaiSP()), x.getSize(), x.getMauSac(),
                        x.getSoLuong()});
            }
        }
    }
}
