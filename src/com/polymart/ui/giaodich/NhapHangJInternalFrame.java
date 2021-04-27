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
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.polymart.config.SecurityConfig;
import com.polymart.entity.*;
import com.polymart.model.ChiTietHoaDonNhapHangModel;
import com.polymart.model.HoaDonNhapHangModel;
import com.polymart.service.IChiTietHoaDonNhapHangService;
import com.polymart.service.IChiTietSanPhamService;
import com.polymart.service.IHoaDonNhapHangService;
import com.polymart.service.INguonHangService;
import com.polymart.service.INhanVienService;
import com.polymart.service.impl.ChiTietHoaDonNhapHangService;
import com.polymart.service.impl.ChiTietSanPhamService;
import com.polymart.service.impl.HoaDonNhapHangService;
import com.polymart.service.impl.NguonHangService;
import com.polymart.service.impl.NhanVienService;
import com.polymart.ui.MainFrame;
import com.polymart.ui.common.uiCommon;
import com.toedter.calendar.JDateChooser;

public class NhapHangJInternalFrame extends JInternalFrame {

    private static final long serialVersionUID = -7230782299903914961L;

    private JPanel contentPane;
    private JPanel panel = new JPanel();
    private JPanel hangHoaJPanel = new JPanel();

    private JTextField txtTimPhieuNhap;
    private JFrame optionKiemKhoFrame = new JFrame();
    private JPanel panelOption;
    private JTable tableNhapHang;
    private DefaultTableModel modelNhapHang;

    private IHoaDonNhapHangService hoaDonNhapHangService = new HoaDonNhapHangService();
    private IChiTietHoaDonNhapHangService chiTietHoaDonNhapHangService = new ChiTietHoaDonNhapHangService();
    private IChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamService();
    private INhanVienService nhanVienService = new NhanVienService();
    private INguonHangService nguonHangService = new NguonHangService();

    private List<HoaDonNhapHangModel> lstHoaDonNhapHang = null;

    private HoaDonNhapHangModel hoaDonNhapHangModel = null;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NhapHangJInternalFrame frame = new NhapHangJInternalFrame();
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
    public NhapHangJInternalFrame() {
        init();
    }

    public void init() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        modelNhapHang = new DefaultTableModel() {

            private static final long serialVersionUID = 8059662035043568002L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setBounds(100, 100, 1920, 639);
        setFocusable(true);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(75, 0, 130));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        panel.setBackground(Color.WHITE);
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setBounds(68, 120, 96, 20);
        hangHoaJPanel.setBackground(Color.WHITE);

        contentPane.add(hangHoaJPanel, BorderLayout.WEST);
        setTitle("Hàng hóa - Kiểm kho");

        optionKiemKhoFrame.setSize(344, 234);
        optionKiemKhoFrame.setLocation(uiCommon.width - 360, uiCommon.height - (uiCommon.height / 100 * 86));
        panelOption = new JPanel();
        panelOption.setLayout(null);
        panelOption.setBackground(Color.white);
        panelOption.setBorder(new EmptyBorder(0, 0, 5, 5));

        optionKiemKhoFrame.getContentPane().add(panelOption);
        optionKiemKhoFrame.setUndecorated(true);

        panel_1 = new JPanel();
        panel_1.setBackground(new Color(75, 0, 130));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 1101, Short.MAX_VALUE)
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                .addGap(16))
        );
        btnXuat = new JButton("→ Xuất");
        btnXuat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                evtBtnXuatFileExcel();
            }
        });
        btnXoa = new JButton("- Xoá ");

        // xóa hóa đơn
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evtBtnXoa(tableNhapHang);
            }
        });

        // xóa hóa đơn
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evtBtnXoa(tableNhapHang);
            }
        });

        btnThemPhieuNhap = new JButton("+ Thêm");

        btnThemPhieuNhap.addActionListener(openThemPhieuNhapHang);

        btnTimKiem = new JButton("Tìm");

        // tìm kiếm hóa đơn
        btnTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evtBtnSearchById(txtTimPhieuNhap);
            }
        });

        txtTimPhieuNhap = new JTextField();
        txtTimPhieuNhap.setBorder(null);
        txtTimPhieuNhap.setText("Tìm theo mã phiếu nhập");
        txtTimPhieuNhap.setColumns(10);
        txtTimPhieuNhap.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtTimPhieuNhap.getText().equals("Tìm theo mã phiếu nhập")) {
                    txtTimPhieuNhap.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtTimPhieuNhap.getText().equals("")) {
                    txtTimPhieuNhap.setText("Tìm theo mã phiếu nhập");
                }
            }
        });

        JLabel lblNewLabel = new JLabel("Hóa đơn nhập hàng");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(txtTimPhieuNhap, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                                .addComponent(btnThemPhieuNhap, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnXuat, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addGap(6))
        );
        gl_panel_1.setVerticalGroup(
                gl_panel_1.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTimPhieuNhap, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnXuat, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnThemPhieuNhap, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        panel_1.setLayout(gl_panel_1);
        panel.setLayout(gl_panel);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        JLabel lblNewLabel_9 = new JLabel("Thời gian");

        JDateChooser dateChooser = new JDateChooser(new Date());

        JButton btnLocTheoNgay = new JButton("Lọc");
        GroupLayout gl_hangHoaJPanel = new GroupLayout(hangHoaJPanel);
        gl_hangHoaJPanel.setHorizontalGroup(gl_hangHoaJPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_hangHoaJPanel.createSequentialGroup().addGroup(gl_hangHoaJPanel
                        .createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_hangHoaJPanel.createSequentialGroup().addGap(10)
                                .addGroup(gl_hangHoaJPanel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 84,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnLocTheoNgay, GroupLayout.PREFERRED_SIZE, 80,
                                                GroupLayout.PREFERRED_SIZE)))
                        .addGroup(gl_hangHoaJPanel.createSequentialGroup().addContainerGap().addComponent(dateChooser,
                                GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        gl_hangHoaJPanel.setVerticalGroup(gl_hangHoaJPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_hangHoaJPanel.createSequentialGroup().addGap(5).addComponent(lblNewLabel_9)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addGap(11)
                        .addComponent(btnLocTheoNgay, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)));
        hangHoaJPanel.setLayout(gl_hangHoaJPanel);

        tableNhapHang = new JTable();
        tableNhapHang.setBackground(Color.WHITE);
        scrollPane.setViewportView(tableNhapHang);
        modelNhapHang.addColumn("Mã hóa đơn");
        modelNhapHang.addColumn("Người nhập");
        modelNhapHang.addColumn("Nguồn hàng");
        modelNhapHang.addColumn("Ngày");
        modelNhapHang.addColumn("Tổng tiền");
        modelNhapHang.addColumn("Ghi chú");
        tableNhapHang.setModel(modelNhapHang);

        // Click đúp vào 1 hóa đơn sẽ show thông tin lên chiTietHoaDonNhapHang
        tableNhapHang.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                int row = tableNhapHang.getSelectedRow();
                if (row > -1 && row < tableNhapHang.getRowCount()) {
                    hoaDonNhapHangModel = hoaDonNhapHangService
                            .findById(Integer.parseInt(tableNhapHang.getValueAt(row, 0).toString()));
                }
                setOpenChiTietHoaDonNhap(mouseEvent);
            }
        });

        // hiển thị danh sách hóa đơn len bảng
        getList();
        showTable(lstHoaDonNhapHang);

        // sự kiện lọc cho nút "Lọc"
        btnLocTheoNgay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evtBtnLoc(dateChooser);
            }
        });
        tableNhapHang.setRowHeight(25);
        tableNhapHang.getColumnModel().getColumn(0).setPreferredWidth(50);
        tableNhapHang.getColumnModel().getColumn(1).setPreferredWidth(200);
        tableNhapHang.getColumnModel().getColumn(2).setPreferredWidth(120);
        tableNhapHang.getColumnModel().getColumn(3).setPreferredWidth(120);
        tableNhapHang.getColumnModel().getColumn(4).setPreferredWidth(120);
        uiCommon.editButtonTop(btnTimKiem);
        uiCommon.editButtonTop(btnThemPhieuNhap);
        uiCommon.editButtonTop(btnXuat);
        uiCommon.editButtonTop(btnXoa);
        uiCommon.editButtonCenter(btnLocTheoNgay);

        setChucVu();
    }

    private void setChucVu() {
        if (EntityAuthorization.USER.getChucVu().equals(SecurityConfig.VAITRO_QUANLY)) return;
        btnXoa.setVisible(false);
        btnXuat.setVisible(false);
        if (EntityAuthorization.USER.getChucVu().equals(SecurityConfig.VAITRO_THUNGAN)) {
            btnXoa.setVisible(true);
            btnXuat.setVisible(true);
        }
    }

    private void setOpenChiTietHoaDonNhap(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
            int row = tableNhapHang.getSelectedRow();
            if (row > -1 && row < tableNhapHang.getRowCount()) {
                List<ChiTietHoaDonNhapHangModel> lstChiTietHoaDonNhap = chiTietHoaDonNhapHangService
                        .findByIdHoaDonNhap(hoaDonNhapHangModel.getId());
                if (lstChiTietHoaDonNhap.isEmpty()) {
                    EntityMessage.show(this, "Hóa đơn không có sản phẩm");
                } else {
                    ChiTietHoaDonNhapHangFrame chiTietHoaDonNhapHang = new ChiTietHoaDonNhapHangFrame(
                            lstChiTietHoaDonNhap, nguonHangService.getNameById(hoaDonNhapHangModel.getIdNguonHang()),
                            hoaDonNhapHangModel.getGhiChu());
                    chiTietHoaDonNhapHang.setVisible(true);
                }
            }
        }
    }

    ActionListener openThemPhieuNhapHang = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            setOpenThemPhieuNhapHang();
        }
    };
    private JButton btnTimKiem;
    private JButton btnThemPhieuNhap;
    private JButton btnXoa;
    private JButton btnXuat;
    private JPanel panel_1;

    private void setOpenThemPhieuNhapHang() {
        ThemNhapHangJInternalFrame themNhapHangJInternalFrame = new ThemNhapHangJInternalFrame(this);
        MainFrame.pnlMain.add(themNhapHangJInternalFrame);
        themNhapHangJInternalFrame.setVisible(true);
    }

    // đổi dữ liệu từ service về list
    public List<HoaDonNhapHangModel> getList() {
        return lstHoaDonNhapHang = hoaDonNhapHangService.findAll();
    }

    // hiển thị danh sách háo đơn lên bảng
    public void showTable(List<HoaDonNhapHangModel> lst) {
        modelNhapHang.setRowCount(0);
        for (HoaDonNhapHangModel x : lst) {
            List<ChiTietHoaDonNhapHangModel> lstChiTietHoaDonNhap = chiTietHoaDonNhapHangService
                    .findByIdHoaDonNhap(x.getId());
            modelNhapHang.addRow(new Object[]{x.getId(),
                    x.getIdNhanVienNhap() + " - " + nhanVienService.getNameNhanVien().get(x.getIdNhanVienNhap()),
                    nguonHangService.getNameById(x.getIdNguonHang()),
                    new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(x.getNgayNhap()),
                    EntityValidate.dinhDangMonney(lstChiTietHoaDonNhap.stream().mapToLong(e -> e.getGiaNhap() * e.getSoLuong()).sum()),
                    x.getGhiChu()});
        }
    }

    // tìm kiếm theo mã hóa đơn nhập
    private void evtBtnSearchById(JTextField txtInputId) {
        String getID = txtInputId.getText();
        if (getID.equals("Tìm theo mã phiếu nhập")) {
            showTable(getList());
        } else {
            if (EntityValidate.checkIdNumber(this, getID)) {
                hoaDonNhapHangModel = hoaDonNhapHangService.findById(Integer.parseInt(getID));
                if (hoaDonNhapHangModel == null) {
                    EntityMessage.show(this, "Mã hóa đơn không tồn tại");
                } else {
                    lstHoaDonNhapHang = new ArrayList<>();
                    lstHoaDonNhapHang.add(hoaDonNhapHangModel);
                    showTable(lstHoaDonNhapHang);
                }
            }
        }
    }

    // xóa một hàng trên table
    private void evtBtnXoa(JTable tbNhapHang) {
        int row = tbNhapHang.getSelectedRow();
        if ((row > -1 && row < tbNhapHang.getRowCount()) && hoaDonNhapHangModel != null) {
            if (EntityMessage.confirm(this, "Thao tác này có thể sẽ bị mất dữ liệu\nĐồng ý xóa?")) {
                hoaDonNhapHangModel = hoaDonNhapHangService
                        .findById(Integer.parseInt(tableNhapHang.getValueAt(row, 0).toString()));
                if (hoaDonNhapHangService.remove(hoaDonNhapHangModel)) {
                    EntityMessage.show(this, "Xóa thành công");
                    modelNhapHang.removeRow(row);
                    chiTietHoaDonNhapHangService.reloadData();
                    chiTietSanPhamService.reloadData();
                } else {
                    EntityMessage.show(this, "Xóa thất bại");
                }
            }
        } else {
            EntityMessage.show(this, "Vui lòng chọn 1 hàng");
        }
    }

    // lọc theo ngày được chọn
    private void evtBtnLoc(JDateChooser dateChooser) {
        try {
            Timestamp timestamp = new Timestamp(dateChooser.getCalendar().getTimeInMillis());
            List<HoaDonNhapHangModel> lstLoc = hoaDonNhapHangService.filterByDate(timestamp);
            if (lstLoc.isEmpty()) {
                EntityMessage.show(this, "Không có hóa đơn nào trong ngày được chọn");
            } else {
                lstHoaDonNhapHang = lstLoc;
                showTable(lstHoaDonNhapHang);
            }
        } catch (Exception e) {
            EntityMessage.show(this, "Mời chọn ngày muốn tìm");
        }
    }

    // xuất file excel
    private void evtBtnXuatFileExcel() {
        try {
            EntityExcel.exportExcel(tableNhapHang);
            EntityMessage.show(this, "Lưu thành côngg");
        } catch (IOException ioException) {
            ioException.printStackTrace();
            EntityMessage.show(this, "Lưu thất bại");
        }
    }
}
