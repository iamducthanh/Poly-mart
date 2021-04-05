package com.polymart.ui.giaodich;

import com.polymart.entity.EntityMessage;
import com.polymart.entity.EntityValidate;
import com.polymart.model.ChiTietHoaDonThanhToanModel;
import com.polymart.model.ChiTietHoaDonTraHangModel;
import com.polymart.model.ChiTietSanPhamModel;
import com.polymart.model.HoaDonThanhToanModel;
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

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ThemTraHangJInternalFrame extends JInternalFrame {

    private static final long serialVersionUID = -1044582693223562703L;

    private JPanel contentPane;
    private DefaultTableModel modelDanhSachSanPham;
    private DefaultTableModel modelDanhSachTraHang;

    private JTextField txtTimKiem;
    private JTable tableDanhSachTraHang;
    private JTable tableDanhSachSanPham;

    private IHoaDonThanhToanService hoaDonThanhToanService = new HoaDonThanhToanService();
    private IChiTietHoaDonThanhToanService chiTietHoaDonThanhToanService = new ChiTietHoaDonThanhToanService();
    private IChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamService();
    private ISanPhamService sanPhamService = new SanPhamService();
    private IKhachHangService khachHangService = new KhachHangService();
    private IHoaDonTraHangService hoaDonTraHangService = new HoaDonTraHangService();
    private IChiTietHoaDonTraHangService chiTietHoaDonTraHangService = new ChiTietHoaDonTraHangService();

    private List<ChiTietHoaDonThanhToanModel> lstChiTietHoaDonThanhToanModels = null;
    private List<ChiTietHoaDonTraHangModel> lstChiTietHoaDonTraHangModels = new ArrayList<>();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ThemTraHangJInternalFrame frame = new ThemTraHangJInternalFrame();
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
    public ThemTraHangJInternalFrame() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        modelDanhSachSanPham = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelDanhSachTraHang = new DefaultTableModel() {
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

        JLabel lblNewLabel = new JLabel("Trả hàng");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));

        txtTimKiem = new JTextField();
        txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtTimKiem.setText("Tìm theo mã hóa đơn thanh toán");
        txtTimKiem.setColumns(10);

        JButton btnTimKiem = new JButton("Tìm kiếm");
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel_1.createSequentialGroup().addGap(5).addComponent(btnQuayLai).addGap(5)
                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                        .addGap(5).addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                        .addGap(557)));
        gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
                .createSequentialGroup().addGap(5)
                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                .addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnQuayLai, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        panel_1.setLayout(gl_panel_1);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new TitledBorder(
                new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
                " Th\u00F4ng tin h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null,
                new Color(0, 0, 0)));
        panel.add(panel_5, BorderLayout.CENTER);
        panel_5.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        panel_5.add(scrollPane, BorderLayout.CENTER);

        tableDanhSachSanPham = new JTable();
        scrollPane.setViewportView(tableDanhSachSanPham);

        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new TitledBorder(
                new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
                " Danh s\u00E1ch s\u1EA3n ph\u1EA9m ", TitledBorder.LEADING, TitledBorder.TOP, null,
                new Color(0, 0, 0)));
        contentPane.add(panel_2, BorderLayout.SOUTH);

        JScrollPane scrollPane_1 = new JScrollPane();

        JLabel lblNewLabel_1_1 = new JLabel("Khách hàng:");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

        JScrollPane scrollPane_2 = new JScrollPane();

        JLabel lblNewLabel_1 = new JLabel("Tổng tiền hoàn trả", JLabel.RIGHT);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));

        JLabel lblTongTien = new JLabel("0", SwingConstants.RIGHT);
        lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 20));

        JButton btnHoanTra = new JButton("Hoàn trả");

        JLabel lblKhachHang = new JLabel("KH00001");
        lblKhachHang.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel lblNewLabel_1_1_2 = new JLabel("Mã hóa đơn thanh toán:");
        lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

        JLabel lblMaHoaDonThanhToan = new JLabel("HD0002");
        lblMaHoaDonThanhToan.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel lblNewLabel_1_1_2_1 = new JLabel("Ghi chú");
        lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GroupLayout gl_panel_2 = new GroupLayout(panel_2);
        gl_panel_2.setHorizontalGroup(
                gl_panel_2.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panel_2.createSequentialGroup()
                                .addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 1210, Short.MAX_VALUE)
                                .addPreferredGap(ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
                                .addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
                                        .addGroup(gl_panel_2.createSequentialGroup()
                                                .addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_panel_2.createSequentialGroup()
                                                                .addGap(211)
                                                                .addComponent(btnHoanTra, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_panel_2.createSequentialGroup()
                                                                .addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
                                                                        .addComponent(lblNewLabel_1_1_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(lblNewLabel_1_1))
                                                                .addGap(19)
                                                                .addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
                                                                        .addComponent(lblKhachHang, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lblMaHoaDonThanhToan, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))))
                                                .addGap(10))
                                        .addGroup(gl_panel_2.createSequentialGroup()
                                                .addComponent(lblTongTien, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(gl_panel_2.createSequentialGroup()
                                                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
        );
        gl_panel_2.setVerticalGroup(
                gl_panel_2.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panel_2.createSequentialGroup()
                                .addGap(3)
                                .addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_panel_2.createSequentialGroup()
                                                .addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_panel_2.createSequentialGroup()
                                                                .addComponent(lblNewLabel_1_1)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_panel_2.createSequentialGroup()
                                                                .addComponent(lblKhachHang, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(lblMaHoaDonThanhToan, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(lblNewLabel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(lblNewLabel_1)
                                                .addGap(18)
                                                .addComponent(lblTongTien, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                                .addGap(46)
                                                .addComponent(btnHoanTra, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );

        JTextArea txaGhiChu = new JTextArea();
        scrollPane_2.setViewportView(txaGhiChu);

        tableDanhSachTraHang = new JTable();
        scrollPane_1.setViewportView(tableDanhSachTraHang);
        panel_2.setLayout(gl_panel_2);
        modelDanhSachSanPham.addColumn("Mã thanh toán");
        modelDanhSachSanPham.addColumn("Mã sản phẩm");
        modelDanhSachSanPham.addColumn("Tên sản phẩm");
        modelDanhSachSanPham.addColumn("Số lượng");
        modelDanhSachSanPham.addColumn("Size");
        modelDanhSachSanPham.addColumn("Màu sắc");
        modelDanhSachSanPham.addColumn("Đơn giá");
        modelDanhSachSanPham.addColumn("Giá giảm");
        modelDanhSachSanPham.addColumn("Giá giảm thêm");
        tableDanhSachSanPham.setModel(modelDanhSachSanPham);

        modelDanhSachTraHang.addColumn("Mã sản phẩm");
        modelDanhSachTraHang.addColumn("Tên sản phẩm");
        modelDanhSachTraHang.addColumn("Số lượng trả");
        modelDanhSachTraHang.addColumn("Size");
        modelDanhSachTraHang.addColumn("Màu sắc");
        tableDanhSachTraHang.setModel(modelDanhSachTraHang);

        txtTimKiem.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtTimKiem.getText().equals("Tìm theo mã hóa đơn thanh toán")) {
                    txtTimKiem.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtTimKiem.getText().equals("")) {
                    txtTimKiem.setText("Tìm theo mã hóa đơn thanh toán");
                }
            }
        });

        tableDanhSachSanPham.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    addProductToTableTraHang(tableDanhSachSanPham, lblTongTien);
                }
            }
        });

        btnTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evtTimKiemHoaDonThanhToan(txtTimKiem, lblKhachHang, lblMaHoaDonThanhToan, lblTongTien);
            }
        });
    }

    private void addProductToTableTraHang(JTable tbSanPham, JLabel lblTongTien) {
        if (modelDanhSachSanPham.getRowCount() >= 0) {
            int row = tbSanPham.getSelectedRow();
            if (row > -1 && row < tbSanPham.getRowCount()) {
                String soLuong = JOptionPane.showInputDialog("Nhập số lượng cần hoàn trả");
                if (EntityValidate.checkPositiveNumber(this, soLuong)) {
                    ChiTietHoaDonTraHangModel chiTietHoaDonTraHangModel = new ChiTietHoaDonTraHangModel();
                    ChiTietHoaDonThanhToanModel chiTietHoaDonThanhToanModel = lstChiTietHoaDonThanhToanModels.get(row);
                    ChiTietSanPhamModel chiTietSanPhamModel = chiTietSanPhamService.getById(chiTietHoaDonThanhToanModel.getChiTietSanPham());
                    if (lstChiTietHoaDonTraHangModels.stream().filter(e -> e.getIdHoaDonThanhToanChiTiet()
                            .equals(chiTietHoaDonThanhToanModel.getId())).collect(Collectors.toList()).isEmpty()) {
                        if (Integer.parseInt(soLuong) <= chiTietHoaDonThanhToanModel.getSoLuong()) {
                            modelDanhSachTraHang.addRow(new Object[]{
                                    chiTietSanPhamModel.getId(),
                                    sanPhamService.findByID(chiTietSanPhamModel.getIdSanPham()).getTenSP(),
                                    soLuong,
                                    chiTietSanPhamModel.getSize(),
                                    chiTietSanPhamModel.getMauSac()
                            });
                            chiTietHoaDonTraHangModel.setIdHoaDonThanhToanChiTiet(chiTietHoaDonThanhToanModel.getId());
                            chiTietHoaDonTraHangModel.setSoLuong(Integer.parseInt(soLuong));
                            lstChiTietHoaDonTraHangModels.add(chiTietHoaDonTraHangModel);
                            Long tongTien = Long.parseLong(lblTongTien.getText()) + (Integer.parseInt(soLuong) * (chiTietSanPhamModel.getGiaBan()
                                    - chiTietSanPhamModel.getGiaGiam()) - chiTietHoaDonThanhToanModel.getGiamGiaThem());
                            lblTongTien.setText(tongTien.toString());
                        } else {
                            EntityMessage.show(this, "Số lượng trả không được lớn hơn số lượng mua");
                        }
                    } else {
                        int i = 0;
                        for (ChiTietHoaDonTraHangModel x : lstChiTietHoaDonTraHangModels) {
                            if (x.getIdHoaDonThanhToanChiTiet().equals(chiTietHoaDonThanhToanModel.getId())) {
                                int setSoLuong = x.getSoLuong() + Integer.parseInt(soLuong);
                                if (setSoLuong > chiTietHoaDonThanhToanModel.getSoLuong()) {
                                    EntityMessage.show(this, "Số lượng trả không được lớn hơn số lượng mua");
                                } else {
                                    x.setSoLuong(setSoLuong);
                                    modelDanhSachTraHang.setValueAt(setSoLuong, i, 2);
                                    Long tongTien = Long.parseLong(lblTongTien.getText()) + (Integer.parseInt(soLuong) * (chiTietSanPhamModel.getGiaBan()
                                            - chiTietSanPhamModel.getGiaGiam()) - chiTietHoaDonThanhToanModel.getGiamGiaThem());
                                    lblTongTien.setText(tongTien.toString());
                                }
                                return;
                            }
                            ++i;
                        }
                    }
                }
            }
        }
    }

    // Tìm kiếm hóa đơn thanh toán
    private void evtTimKiemHoaDonThanhToan(JTextField txtTimKiem, JLabel lblKhachHang, JLabel lblMaHoaDon, JLabel lblTongTien) {
        String getTimKiem = txtTimKiem.getText();
        if (EntityValidate.checkIdNumber(this, getTimKiem)) {
            HoaDonThanhToanModel hoaDonThanhToanModel = hoaDonThanhToanService.findById(Integer.parseInt(getTimKiem));
            if (hoaDonThanhToanModel != null) {
                lstChiTietHoaDonThanhToanModels = chiTietHoaDonThanhToanService.findByIdHoaDonThanhToan(Integer.parseInt(getTimKiem));
                if (lstChiTietHoaDonThanhToanModels.isEmpty()) {
                    EntityMessage.show(this, "Hóa đơn không có hàng");
                } else {
                    lblKhachHang.setText(khachHangService.findOne(hoaDonThanhToanModel.getIdKhachHang()).getHoTen());
                    lblMaHoaDon.setText(hoaDonThanhToanModel.getId().toString());
                    lblTongTien.setText("0");
                    modelDanhSachTraHang.setRowCount(0);
                    modelDanhSachSanPham.setRowCount(0);
                    for (ChiTietHoaDonThanhToanModel x : lstChiTietHoaDonThanhToanModels) {
                        ChiTietSanPhamModel chiTietSanPhamModel = chiTietSanPhamService.getById(x.getChiTietSanPham());
                        modelDanhSachSanPham.addRow(new Object[]{
                                getTimKiem,
                                x.getChiTietSanPham(),
                                sanPhamService.findByID(chiTietSanPhamService.getIdProductById(x.getChiTietSanPham())).getTenSP(),
                                x.getSoLuong(),
                                chiTietSanPhamModel.getSize(),
                                chiTietSanPhamModel.getMauSac(),
                                chiTietSanPhamModel.getGiaBan(),
                                chiTietSanPhamModel.getGiaGiam(),
                                x.getGiamGiaThem()
                        });
                    }
                }
            } else {
                EntityMessage.show(this, "Hóa đơn không tồn tại");
            }
        }
    }

    public void close() {
        this.setVisible(false);
    }
}
