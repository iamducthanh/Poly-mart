package com.polymart.ui.giaodich;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

import com.polymart.entity.EntityAuthorization;
import com.polymart.entity.EntityMessage;
import com.polymart.entity.EntityValidate;
import com.polymart.model.*;
import com.polymart.service.IChiTietHoaDonThanhToanService;
import com.polymart.service.IChiTietHoaDonTraHangService;
import com.polymart.service.IChiTietSanPhamService;
import com.polymart.service.IHoaDonThanhToanService;
import com.polymart.service.IHoaDonTraHangService;
import com.polymart.service.IKhachHangService;
import com.polymart.service.ISanPhamService;
import com.polymart.service.impl.ChiTietHoaDonThanhToanService;
import com.polymart.service.impl.ChiTietHoaDonTraHangService;
import com.polymart.service.impl.ChiTietSanPhamService;
import com.polymart.service.impl.HoaDonThanhToanService;
import com.polymart.service.impl.HoaDonTraHangService;
import com.polymart.service.impl.KhachHangService;
import com.polymart.service.impl.SanPhamService;
import com.polymart.ui.common.uiCommon;

import javax.swing.ImageIcon;

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

    private TraHangJInternalFrame traHangJInternalFrame;

    private Long tongTien = Long.valueOf(0);
    private HoaDonThanhToanModel hoaDonThanhToanModel;
    private ChiTietHoaDonThanhToanModel chiTietHoaDonThanhToanModel;
    private KhachHangModel khachHangModel;
    private ChiTietSanPhamModel chiTietSanPhamModel;

    private double tongTienHoaDon = Long.valueOf(0);

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
        init();
    }

    public ThemTraHangJInternalFrame(TraHangJInternalFrame traHangJInternalFrame) {
        this.traHangJInternalFrame = traHangJInternalFrame;
        init();
    }

    private void init() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        modelDanhSachSanPham = new DefaultTableModel() {

            private static final long serialVersionUID = -6399184591727512268L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelDanhSachTraHang = new DefaultTableModel() {

            private static final long serialVersionUID = 6710114029206253334L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1920, 639);

        setFocusable(true);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));


        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.WHITE);
        contentPane.add(panel_1, BorderLayout.NORTH);

        JButton btnQuayLai = new JButton("");
        btnQuayLai.setIcon(new ImageIcon("images\\back-6.png"));
        btnQuayLai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });
        btnQuayLai.setContentAreaFilled(false);
        btnQuayLai.setBorder(null);
        btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 17));

        JLabel lblNewLabel = new JLabel("  Trả hàng");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));

        txtTimKiem = new JTextField();
        txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtTimKiem.setText("Tìm theo mã hóa đơn thanh toán");
        txtTimKiem.setColumns(10);

        JButton btnTimKiem = new JButton("Tìm kiếm");
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(5)
                                .addComponent(btnQuayLai)
                                .addGap(5)
                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                                .addGap(5)
                                .addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                .addGap(610))
        );
        gl_panel_1.setVerticalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(5)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(btnQuayLai, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_1.setLayout(gl_panel_1);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_5 = new JPanel();
        panel_5.setBackground(Color.WHITE);
        panel_5.setBorder(new TitledBorder(
                new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
                " Th\u00F4ng tin h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null,
                new Color(0, 0, 0)));
        panel.add(panel_5, BorderLayout.CENTER);
        panel_5.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        panel_5.add(scrollPane, BorderLayout.CENTER);

        tableDanhSachSanPham = new JTable();
        tableDanhSachSanPham.setBackground(Color.WHITE);
        scrollPane.setViewportView(tableDanhSachSanPham);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.WHITE);
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
        			.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 894, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
        			.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
        						.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblNewLabel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
        						.addGroup(gl_panel_2.createSequentialGroup()
        							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
        								.addComponent(lblNewLabel_1_1_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(lblNewLabel_1_1))
        							.addGap(19)
        							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
        								.addComponent(lblMaHoaDonThanhToan, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(lblKhachHang, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))))
        					.addContainerGap())
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addComponent(lblTongTien, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addComponent(btnHoanTra, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
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
        					.addComponent(btnHoanTra, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );

        JTextArea txaGhiChu = new JTextArea();
        scrollPane_2.setViewportView(txaGhiChu);

        tableDanhSachTraHang = new JTable();
        tableDanhSachTraHang.setBackground(Color.WHITE);
        scrollPane_1.setViewportView(tableDanhSachTraHang);
        panel_2.setLayout(gl_panel_2);
        setColumnTable();

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
                    addProductToTableTraHang(tableDanhSachSanPham, lblTongTien, txaGhiChu);
                }
            }
        });

        btnTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evtTimKiemHoaDonThanhToan(txtTimKiem, lblKhachHang, lblMaHoaDonThanhToan, lblTongTien, txaGhiChu);
            }
        });

        btnHoanTra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveHoaDonTraHang(tableDanhSachTraHang, txaGhiChu);
            }
        });
        tableDanhSachSanPham.setRowHeight(25);
        tableDanhSachTraHang.setRowHeight(25);

        uiCommon.editButtonCenter(btnHoanTra);
        uiCommon.editButtonCenter(btnTimKiem);
    }

    // set cột table
    private void setColumnTable() {
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
    }

    // lưu hóa đơn trả hàng
    private void saveHoaDonTraHang(JTable tbTraHang, JTextArea txaGhiChu) {
        if (tbTraHang.getRowCount() > 0) {
            HoaDonTraHangModel hoaDonTraHangModel = new HoaDonTraHangModel();
            hoaDonTraHangModel.setGhiChu(txaGhiChu.getText());
            hoaDonTraHangModel.setIdNhanVien(EntityAuthorization.USER.getId());
            hoaDonTraHangModel = hoaDonTraHangService.save(hoaDonTraHangModel);
            if (hoaDonTraHangModel == null) {
                EntityMessage.show(this, "Lưu thất bại");
            } else {
                for (ChiTietHoaDonTraHangModel x : lstChiTietHoaDonTraHangModels) {
                    x.setIdHoaDonTraHang(hoaDonTraHangModel.getId());
                    if (!chiTietHoaDonTraHangService.save(x)) {
                        EntityMessage.show(this, "Thêm thất bại");
                        hoaDonTraHangService.remove(hoaDonTraHangModel);
                        chiTietHoaDonTraHangService.reloadData();
                        return;
                    }
                }
                EntityMessage.show(this, "Thêm thành công");
                this.setVisible(false);
                traHangJInternalFrame.showTable(traHangJInternalFrame.getData());
                chiTietSanPhamService.reloadData();
                chiTietHoaDonTraHangService.reloadData();
                chiTietHoaDonThanhToanService.reloadData();
            }
        } else {
            EntityMessage.show(this, "Thêm sản trả trước khi lưu");
        }
    }

    // thêm sản phẩm trả hàng
    private void addProductToTableTraHang(JTable tbSanPham, JLabel lblTongTien, JTextArea txaGhiChu) {
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
                            setTongTien(lblTongTien, txaGhiChu);
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
                                    setTongTien(lblTongTien, txaGhiChu);
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

    // hiển thị tổng tiền lên label
    private void setTongTien(JLabel lblTongTien, JTextArea txaGhiChu) {
        tongTien = Long.valueOf(0);
        tongTienHoaDon = Long.valueOf(0);
        lstChiTietHoaDonTraHangModels.forEach(e -> {
            chiTietHoaDonThanhToanModel = chiTietHoaDonThanhToanService.findById(e.getIdHoaDonThanhToanChiTiet());
            chiTietSanPhamModel = chiTietSanPhamService.getById(chiTietHoaDonThanhToanModel.getChiTietSanPham());
            tongTien += ((chiTietSanPhamModel.getGiaBan()
                    - chiTietSanPhamModel.getGiaGiam()) * e.getSoLuong()
                    - chiTietHoaDonThanhToanModel.getGiamGiaThem());
        });
        int sumTra = lstChiTietHoaDonTraHangModels.stream().mapToInt(e -> e.getSoLuong()).sum();
        int sumThanhToan = lstChiTietHoaDonThanhToanModels.stream().mapToInt(e -> e.getSoLuong()).sum();
        if (sumTra == sumThanhToan) {
            tongTien -= hoaDonThanhToanModel.getDiemDaDoi();
            tongTienHoaDon = lstChiTietHoaDonThanhToanModels.stream().mapToLong(
                    e -> (((chiTietSanPhamService.getById(e.getChiTietSanPham()).getGiaBan()
                            - chiTietSanPhamService.getById(e.getChiTietSanPham()).getGiaGiam())
                            * e.getSoLuong()) - e.getGiamGiaThem())).sum();
            if (tongTienHoaDon > 0) {
                txaGhiChu.setText(txaGhiChu.getText() + " - Trừ "
                        + EntityValidate.dinhDangMonney((long) (tongTienHoaDon * 0.01))
                        + " điểm cộng sau khi thanh toán hóa đơn " + chiTietHoaDonThanhToanModel.getHoaDonThanhToan() + "\n");
            }
            if (hoaDonThanhToanModel.getDiemDaDoi() > 0) {
                txaGhiChu.setText(txaGhiChu.getText() + " - Hoàn trả " + hoaDonThanhToanModel.getDiemDaDoi()
                        + " điểm vào tài khoản khách hàng");
            }
        }
        tongTienHoaDon = tongTienHoaDon * 0.01;
        double setTong = tongTien - tongTienHoaDon;
        lblTongTien.setText(EntityValidate.dinhDangMonney((long) (tongTien - (tongTienHoaDon * 0.01))));
    }

    // Tìm kiếm hóa đơn thanh toán
    private void evtTimKiemHoaDonThanhToan(JTextField txtTimKiem, JLabel lblKhachHang, JLabel lblMaHoaDon, JLabel lblTongTien, JTextArea txaGhiChu) {
        String getTimKiem = txtTimKiem.getText();
        if (EntityValidate.checkIdNumber(this, getTimKiem)) {
            hoaDonThanhToanModel = hoaDonThanhToanService.findById(Integer.parseInt(getTimKiem));
            if (hoaDonThanhToanModel != null) {
                lstChiTietHoaDonThanhToanModels = chiTietHoaDonThanhToanService.findByIdHoaDonThanhToan(Integer.parseInt(getTimKiem));
                if (lstChiTietHoaDonThanhToanModels.isEmpty()) {
                    EntityMessage.show(this, "Hóa đơn không có hàng");
                } else {
                    lstChiTietHoaDonTraHangModels = new ArrayList<>();
                    khachHangModel = khachHangService.findOne(hoaDonThanhToanModel.getIdKhachHang());
                    lblKhachHang.setText(khachHangModel.getHoTen());
                    lblMaHoaDon.setText(hoaDonThanhToanModel.getId().toString());
                    lblTongTien.setText(EntityValidate.dinhDangMonney(0));
                    txaGhiChu.setText("");
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
                                EntityValidate.dinhDangMonney(chiTietSanPhamModel.getGiaBan()),
                                EntityValidate.dinhDangMonney(chiTietSanPhamModel.getGiaGiam()),
                                EntityValidate.dinhDangMonney(x.getGiamGiaThem())
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
