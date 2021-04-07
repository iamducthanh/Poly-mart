package com.polymart.ui.giaodich;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
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

import com.polymart.entity.EntityFrame;
import com.polymart.entity.EntityMessage;
import com.polymart.entity.EntityValidate;
import com.polymart.model.ChiTietHoaDonThanhToanModel;
import com.polymart.model.HoaDonThanhToanModel;
import com.polymart.service.IChiTietHoaDonThanhToanService;
import com.polymart.service.IChiTietSanPhamService;
import com.polymart.service.IHoaDonThanhToanService;
import com.polymart.service.IKhachHangService;
import com.polymart.service.INhanVienService;
import com.polymart.service.impl.ChiTietHoaDonThanhToanService;
import com.polymart.service.impl.ChiTietSanPhamService;
import com.polymart.service.impl.HoaDonThanhToanService;
import com.polymart.service.impl.KhachHangService;
import com.polymart.service.impl.NhanVienService;
import com.polymart.ui.common.uiCommon;
import com.toedter.calendar.JDateChooser;

public class ThanhToanJInternalFrame extends JInternalFrame {

    private static final long serialVersionUID = -7230782299903914961L;

    private JPanel contentPane;
    private JPanel panel = new JPanel();
    private JPanel panel1 = new JPanel();
    private JPanel hangHoaJPanel = new JPanel();

    private JTextField txtTimHoaDon;
    private JFrame optionKiemKhoFrame = new JFrame();
    private JPanel panelOption;
    private JTable tableThanhToan;
    private DefaultTableModel modelThanhToan;

    private JTextField txtMaNhanVien;
    private JTextField txtMaKhachHang;
    private JTextField txtDiaDIem;
    private JTextField txtMaPhieu;
    private JLabel lblSLng;
    private JLabel lblMSnPhm;
    private JLabel lblNgiNhp;
    private JLabel lblNgunHng;
    private JLabel lblGhiCh;
    private JTextField txtSoLuong;
    private JTextField txtGiamGia;
    private JTextField txtTongTien;

    private IHoaDonThanhToanService hoaDonThanhToanService = new HoaDonThanhToanService();
    private IChiTietHoaDonThanhToanService chiTietHoaDonThanhToanService = new ChiTietHoaDonThanhToanService();
    private IKhachHangService khachHangService = new KhachHangService();
    private INhanVienService nhanVienService = new NhanVienService();
    private IChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamService();

    private List<HoaDonThanhToanModel> lstHoaDonThanhToanModels = hoaDonThanhToanService.findAll();

    private HoaDonThanhToanModel hoaDonThanhToanModel = new HoaDonThanhToanModel();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ThanhToanJInternalFrame frame = new ThanhToanJInternalFrame();
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
    public ThanhToanJInternalFrame() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        modelThanhToan = new DefaultTableModel() {

            private static final long serialVersionUID = -8747914044493540900L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setBounds(100, 100, 1920, 639);
        setFocusable(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setBounds(68, 120, 96, 20);
        panel.setLayout(new BorderLayout(0, 0));

        contentPane.add(hangHoaJPanel, BorderLayout.WEST);
        panel.add(panel1, BorderLayout.EAST);
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        initTopThanhToan();
        initCenterThanhToan();
//        initFrameThem();
    }

    public void initTopThanhToan() {
        JLabel lblNewLabel = new JLabel("Hóa đơn thanh toán       ");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(lblNewLabel, BorderLayout.WEST);

        txtTimHoaDon = new JTextField();
        txtTimHoaDon.setText("Tìm theo mã hóa đơn");
        panel.add(txtTimHoaDon, BorderLayout.CENTER);
        txtTimHoaDon.setColumns(10);
        txtTimHoaDon.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtTimHoaDon.getText().equals("Tìm theo mã hóa đơn")) {
                    txtTimHoaDon.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtTimHoaDon.getText().equals("")) {
                    txtTimHoaDon.setText("Tìm theo mã hóa đơn");
                }
            }
        });

        JButton btnTimKiem = new JButton("Tìm kiếm");
        panel1.add(btnTimKiem);
        JLabel lblNewLabel_1 = new JLabel(String.format("%60s", " "));
        panel1.add(lblNewLabel_1);

        JButton btnThemPhieuNhap = new JButton("+ Thêm mới ");
        panel1.add(btnThemPhieuNhap);
        JButton btnXoa = new JButton("- Xoá ");
        panel1.add(btnXoa);
        JButton btnExport = new JButton("→ Xuất file ");
        panel1.add(btnExport);

        optionKiemKhoFrame.setSize(344, 234);
        optionKiemKhoFrame.setLocation(uiCommon.width - 360, uiCommon.height - (uiCommon.height / 100 * 86));
        panelOption = new JPanel();
        panelOption.setLayout(null);
        panelOption.setBackground(Color.white);
        panelOption.setBorder(new EmptyBorder(0, 0, 5, 5));

        optionKiemKhoFrame.getContentPane().add(panelOption);
        optionKiemKhoFrame.setUndecorated(true);

        JComboBox<String> cbbOptionKiemKho = new JComboBox<String>();
        cbbOptionKiemKho.addItem("≡");
        panel1.add(cbbOptionKiemKho);

        btnThemPhieuNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOpenThemHoaDonThanhToan();
            }
        });

        // tìm kiếm
        btnTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evtBtnSearchById(txtTimHoaDon);
            }
        });

        // xóa
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evtBtnXoa(tableThanhToan);
            }
        });

    }

    public void initCenterThanhToan() {
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        JLabel lblNewLabel_9 = new JLabel("Thời gian");

        JDateChooser dateChooser = new JDateChooser(new Date());

        JButton btnLocTheoNgay = new JButton("Lọc");
        GroupLayout gl_hangHoaJPanel = new GroupLayout(hangHoaJPanel);
        gl_hangHoaJPanel.setHorizontalGroup(gl_hangHoaJPanel.createParallelGroup(Alignment.TRAILING)
                .addGroup(gl_hangHoaJPanel.createSequentialGroup().addContainerGap()
                        .addGroup(gl_hangHoaJPanel.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLocTheoNgay)
                                .addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        gl_hangHoaJPanel.setVerticalGroup(gl_hangHoaJPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_hangHoaJPanel.createSequentialGroup().addGap(5).addComponent(lblNewLabel_9)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnLocTheoNgay)
                        .addContainerGap(141, Short.MAX_VALUE)));

        hangHoaJPanel.setLayout(gl_hangHoaJPanel);
        panel.add(panel1, BorderLayout.EAST);
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        tableThanhToan = new JTable();
        scrollPane.setViewportView(tableThanhToan);
        modelThanhToan.addColumn("Mã hóa đơn");
        modelThanhToan.addColumn("Mã khách hàng");
        modelThanhToan.addColumn("Mã nhân viên");
        modelThanhToan.addColumn("Tổng tiền");
        modelThanhToan.addColumn("Ngày tạo");
        modelThanhToan.addColumn("Ghi chú");

        tableThanhToan.setModel(modelThanhToan);

        // table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		table.getColumnModel().getColumn(0).setPreferredWidth(50);
//		table.getColumnModel().getColumn(1).setPreferredWidth(120);
//		table.getColumnModel().getColumn(2).setPreferredWidth(150);
//		table.getColumnModel().getColumn(3).setPreferredWidth(120);
//		table.getColumnModel().getColumn(4).setPreferredWidth(120);
//		table.getColumnModel().getColumn(5).setPreferredWidth(120);
//		table.getColumnModel().getColumn(6).setPreferredWidth(100);
//		table.getColumnModel().getColumn(7).setPreferredWidth(130);
//		table.getColumnModel().getColumn(8).setPreferredWidth(130);
//		table.getColumnModel().getColumn(9).setPreferredWidth(130);

        // Click đúp vào 1 hóa đơn sẽ show thông tin lên chiTietHoaDonThanhToan
        tableThanhToan.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                int row = tableThanhToan.getSelectedRow();
                if (row > -1 && row < tableThanhToan.getRowCount()) {
                    hoaDonThanhToanModel = hoaDonThanhToanService.findById(Integer.parseInt(tableThanhToan.getValueAt(row, 0).toString()));
                }
                setOpenChiTietHoaDonThanhToan(mouseEvent);
            }
        });

        // hiển thị hóa đơn lên table
        showTable(lstHoaDonThanhToanModels);

        // lọc theo ngày
        btnLocTheoNgay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evtBtnLoc(dateChooser);
            }
        });

    }

    private void setOpenChiTietHoaDonThanhToan(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
            int row = tableThanhToan.getSelectedRow();
            if (row > -1 && row < tableThanhToan.getRowCount()) {
                List<ChiTietHoaDonThanhToanModel> lstChiTietHoaDonThanhToanModels = chiTietHoaDonThanhToanService
                        .findByIdHoaDonThanhToan(hoaDonThanhToanModel.getId());
                if (!lstChiTietHoaDonThanhToanModels.isEmpty()) {
                    ChiTietHoaDonThanhToan chiTietHoaDonThanhToan = new ChiTietHoaDonThanhToan(
                            lstChiTietHoaDonThanhToanModels, hoaDonThanhToanModel.getIdKhachHang());
                    chiTietHoaDonThanhToan.setVisible(true);
                } else {
                    EntityMessage.show(this, "Hóa đơn không có sản phẩm");
                }
            }
        }
    }

    private void setOpenThemHoaDonThanhToan() {
        ThemHoaDonThanhToanJInternalFrame themHoaDonThanhToan = new ThemHoaDonThanhToanJInternalFrame(this);
        EntityFrame.POLYMARTMAIN.pnlMain.add(themHoaDonThanhToan);
        themHoaDonThanhToan.setVisible(true);
    }

    // hiển thị danh sách hóa dơn lên bảng
    public void showTable(List<HoaDonThanhToanModel> lst) {
        if (!lst.isEmpty()) {
            modelThanhToan.setRowCount(0);
            for (HoaDonThanhToanModel x : lst) {
                List<ChiTietHoaDonThanhToanModel> lstChiTietHoaDonThanhToanModels = chiTietHoaDonThanhToanService
                        .findByIdHoaDonThanhToan(x.getId());
                modelThanhToan.addRow(new Object[]{x.getId(), khachHangService.findOne(x.getIdKhachHang()).getHoTen(),
                        x.getIdNhanVien() + " - " + nhanVienService.getNameNhanVien().get(x.getIdNhanVien()),
                        lstChiTietHoaDonThanhToanModels.stream().mapToDouble(e -> e.getSoLuong()
                                * (chiTietSanPhamService.getById(e.getChiTietSanPham()).getGiaBan()
                                - chiTietSanPhamService.getById(e.getChiTietSanPham()).getGiaGiam())).sum(),
                        new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(x.getNgayThanhToan()), x.getGhiChu()});
            }
        }
    }

    // xóa một hàng trên table
    private void evtBtnXoa(JTable tbNhapHang) {
        int row = tbNhapHang.getSelectedRow();
        if ((row > -1 && row < tbNhapHang.getRowCount()) && hoaDonThanhToanModel != null) {
            if (EntityMessage.confirm(this, "Thao tác này có thể sẽ bị mất dữ liệu\nĐồng ý xóa?")) {
                hoaDonThanhToanModel = hoaDonThanhToanService.findById(Integer.parseInt(tableThanhToan.getValueAt(row, 0).toString()));
                if (hoaDonThanhToanService.remove(hoaDonThanhToanModel)) {
                    EntityMessage.show(this, "Xóa thành công");
                    modelThanhToan.removeRow(row);
                    chiTietHoaDonThanhToanService.reloadData();
                    chiTietSanPhamService.reloadData();
                } else {
                    EntityMessage.show(this, "Xóa thất bại");
                }
            }
        } else {
            EntityMessage.show(this, "Vui lòng chọn 1 hàng");
        }

    }

    // tìm kiếm mã hóa đơn hàng
    private void evtBtnSearchById(JTextField txtInputId) {
        String getID = txtInputId.getText();
        if (getID.equals("Tìm theo mã hóa đơn")) {
            showTable(getList());
        } else {
            if (EntityValidate.checkIdNumber(this, getID)) {
                hoaDonThanhToanModel = hoaDonThanhToanService.findById(Integer.parseInt(getID));
                if (hoaDonThanhToanModel == null) {
                    EntityMessage.show(this, "Mã hóa đơn không tồn tại");
                } else {
                    lstHoaDonThanhToanModels = new ArrayList<>();
                    lstHoaDonThanhToanModels.add(hoaDonThanhToanModel);
                    showTable(lstHoaDonThanhToanModels);
                }
            }
        }
    }

    // lọc theo ngày được chọn
    private void evtBtnLoc(JDateChooser dateChooser) {
        try {
            Timestamp timestamp = new Timestamp(dateChooser.getCalendar().getTimeInMillis());
            List<HoaDonThanhToanModel> lstLoc = hoaDonThanhToanService.filterByDate(timestamp);
            if (lstLoc.isEmpty()) {
                EntityMessage.show(this, "Không có hóa đơn nào trong ngày được chọn");
            } else {
                lstHoaDonThanhToanModels = lstLoc;
                showTable(lstHoaDonThanhToanModels);
            }
        } catch (Exception e) {
            EntityMessage.show(this, "Mời chọn ngày muốn tìm");
        }
    }

    // getdata list
    public List<HoaDonThanhToanModel> getList() {
        return lstHoaDonThanhToanModels = hoaDonThanhToanService.findAll();
    }

    public void initFrameThem() {
        JFrame themPhieuNhapFrame = new JFrame();
        themPhieuNhapFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        themPhieuNhapFrame.setTitle("Thêm phiếu thanh toán");
        themPhieuNhapFrame.setBounds(100, 100, 633, 626);
        themPhieuNhapFrame.setFocusable(true);
        themPhieuNhapFrame.setLocationRelativeTo(null);
        JMenuBar menuBar = new JMenuBar();
        themPhieuNhapFrame.setJMenuBar(menuBar);

        JMenu mnThoat = new JMenu("Thoát");
        menuBar.add(mnThoat);

        JMenu mnLuu = new JMenu("Lưu");
        menuBar.add(mnLuu);

        JPanel contentNhaPanel = new JPanel();
        contentNhaPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        themPhieuNhapFrame.setContentPane(contentNhaPanel);
        contentNhaPanel.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(
                new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
                "Th\u00F4ng tin phi\u1EBFu nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
        panel.setBounds(10, 11, 595, 510);
        contentNhaPanel.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Mã phiếu: ", JLabel.RIGHT);
        lblNewLabel.setBounds(10, 31, 125, 25);
        panel.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

        lblMSnPhm = new JLabel("Mã khách hàng: ", JLabel.RIGHT);
        lblMSnPhm.setBounds(10, 67, 125, 25);
        panel.add(lblMSnPhm);
        lblMSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 15));

        txtMaPhieu = new JTextField();
        txtMaPhieu.setBounds(154, 31, 300, 25);
        panel.add(txtMaPhieu);
        txtMaPhieu.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtMaPhieu.setColumns(10);

        txtMaKhachHang = new JTextField();
        txtMaKhachHang.setBounds(154, 67, 300, 25);
        panel.add(txtMaKhachHang);
        txtMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtMaKhachHang.setColumns(10);

        txtMaNhanVien = new JTextField();
        txtMaNhanVien.setBounds(154, 103, 300, 25);
        panel.add(txtMaNhanVien);
        txtMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtMaNhanVien.setColumns(10);

        txtDiaDIem = new JTextField();
        txtDiaDIem.setBounds(154, 139, 300, 25);
        panel.add(txtDiaDIem);
        txtDiaDIem.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtDiaDIem.setColumns(10);

        lblSLng = new JLabel("Mã nhân viên: ", JLabel.RIGHT);
        lblSLng.setBounds(10, 103, 125, 25);
        panel.add(lblSLng);
        lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 15));

        lblNgiNhp = new JLabel("Địa điểm: ", JLabel.RIGHT);
        lblNgiNhp.setBounds(10, 139, 125, 25);
        panel.add(lblNgiNhp);
        lblNgiNhp.setFont(new Font("Tahoma", Font.PLAIN, 15));

        lblNgunHng = new JLabel("Ngày thanh toán: ", JLabel.RIGHT);
        lblNgunHng.setBounds(10, 283, 125, 25);
        panel.add(lblNgunHng);
        lblNgunHng.setFont(new Font("Tahoma", Font.PLAIN, 15));

        lblGhiCh = new JLabel("Số lượng: ", JLabel.RIGHT);
        lblGhiCh.setBounds(10, 175, 125, 25);
        panel.add(lblGhiCh);
        lblGhiCh.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(154, 355, 419, 131);
        panel.add(scrollPane);

        JTextArea txtGhiChu = new JTextArea();
        scrollPane.setViewportView(txtGhiChu);

        JLabel lblGimGi = new JLabel("Giảm giá: ", SwingConstants.RIGHT);
        lblGimGi.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblGimGi.setBounds(10, 211, 125, 25);
        panel.add(lblGimGi);

        JLabel lblTngTin = new JLabel("Tổng tiền: ", SwingConstants.RIGHT);
        lblTngTin.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTngTin.setBounds(10, 247, 125, 25);
        panel.add(lblTngTin);

        JLabel lblTrngThi = new JLabel("Trạng thái: ", SwingConstants.RIGHT);
        lblTrngThi.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTrngThi.setBounds(10, 319, 125, 25);
        panel.add(lblTrngThi);

        JLabel lblGhiCh_1 = new JLabel("Ghi chú: ", SwingConstants.RIGHT);
        lblGhiCh_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblGhiCh_1.setBounds(10, 354, 125, 25);
        panel.add(lblGhiCh_1);

        txtSoLuong = new JTextField();
        txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtSoLuong.setColumns(10);
        txtSoLuong.setBounds(154, 175, 300, 25);
        panel.add(txtSoLuong);

        txtGiamGia = new JTextField();
        txtGiamGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtGiamGia.setColumns(10);
        txtGiamGia.setBounds(154, 211, 300, 25);
        panel.add(txtGiamGia);

        txtTongTien = new JTextField();
        txtTongTien.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtTongTien.setColumns(10);
        txtTongTien.setBounds(154, 247, 300, 25);
        panel.add(txtTongTien);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(154, 283, 300, 25);
        panel.add(dateChooser);

        JCheckBox chckbxNewCheckBox = new JCheckBox("Đã thanh toán");
        chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
        chckbxNewCheckBox.setBounds(154, 321, 151, 25);
        panel.add(chckbxNewCheckBox);

        JButton btnThoat = new JButton("Thoát");
        btnThoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnThoat.setBounds(516, 532, 89, 23);
        contentNhaPanel.add(btnThoat);

        JButton btnLuu = new JButton("Lưu");
        btnLuu.setBounds(417, 532, 89, 23);
        contentNhaPanel.add(btnLuu);
        themPhieuNhapFrame.setVisible(true);

    }

}
