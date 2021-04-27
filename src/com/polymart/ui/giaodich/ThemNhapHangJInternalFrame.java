package com.polymart.ui.giaodich;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
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

import com.polymart.entity.*;
import com.polymart.model.*;
import com.polymart.service.*;
import com.polymart.service.impl.*;
import com.polymart.ui.common.uiCommon;

public class ThemNhapHangJInternalFrame extends JInternalFrame {

    private static final long serialVersionUID = -4001431086652454768L;

    private JPanel contentPane;
    private DefaultTableModel modelDSSanPham;
    private DefaultTableModel modelDSNhapHang;

    private JTextField txtTimKiem;
    private JTable tableDSSanPham;
    private JTextField txtSoLuongNhap;
    private JTable tableDSNhapHang;

    private INguonHangService nguonHangService = new NguonHangService();
    private IChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamService();
    private ISanPhamService sanPhamService = new SanPhamService();
    private IHoaDonNhapHangService hoaDonNhapHangService = new HoaDonNhapHangService();
    private IChiTietHoaDonNhapHangService chiTietHoaDonNhapHangService = new ChiTietHoaDonNhapHangService();
    private ILoaiSanPhamService loaiSanPhamService = new LoaiSanPhamService();

    private List<ChiTietSanPhamModel> lstTietSanPham = chiTietSanPhamService.findAll();
    private List<NguonHangModel> lstNguonHang = nguonHangService.findAll();
    private List<ChiTietHoaDonNhapHangModel> lstChiTietHoaDonNhap = new ArrayList<>();

    private ChiTietHoaDonNhapHangModel chiTietHoaDonNhapHangModel = null;
    private ChiTietSanPhamModel chiTietSanPhamModel = null;
    private SanPhamModel sanPhamModel = null;

    private JButton btnLuuTam = new JButton("Lưu tạm");
    private JTextField txtGiaNhap;

    private NhapHangJInternalFrame nhapHangJInternalFrame = null;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ThemNhapHangJInternalFrame frame = new ThemNhapHangJInternalFrame();
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

    public ThemNhapHangJInternalFrame() {
        init();
    }

    public ThemNhapHangJInternalFrame(NhapHangJInternalFrame nhapHangJInternalFrame) {
        this.nhapHangJInternalFrame = nhapHangJInternalFrame;
        init();
    }

    // import data from file excel
    private void importExcel(JLabel lblTongTien) {
        try {
            EntityExcel.importExcel(modelDSNhapHang);
            String getMaSanPham, getNameSanPham, getLoaiSanPham, getGiaNhap, getSize, getMauSac, getSoLuong;
            List<Integer> lstLoiDuLieu = new ArrayList<>();
            lstChiTietHoaDonNhap = new ArrayList<>();
            if (modelDSNhapHang.getRowCount() > 0) {
                for (int i = 0; i < modelDSNhapHang.getRowCount(); i++) {
                    getMaSanPham = modelDSNhapHang.getValueAt(i, 0).toString();
                    getNameSanPham = modelDSNhapHang.getValueAt(i, 1).toString();
                    getLoaiSanPham = modelDSNhapHang.getValueAt(i, 2).toString();
                    getGiaNhap = modelDSNhapHang.getValueAt(i, 3).toString();
                    getSize = modelDSNhapHang.getValueAt(i, 4).toString();
                    getMauSac = modelDSNhapHang.getValueAt(i, 5).toString();
                    getSoLuong = modelDSNhapHang.getValueAt(i, 6).toString();
                    sanPhamModel = sanPhamService.findByNameSPAndNameLoai(getNameSanPham, getLoaiSanPham);
                    if (sanPhamModel == null) {
                        // tên sản phẩm hoặc tên loại không tồn tại
                        lstLoiDuLieu.add(i);
                        continue;
                    }
                    chiTietSanPhamModel = chiTietSanPhamService.getById(Integer.parseInt(getMaSanPham));
                    if (chiTietSanPhamModel == null) {
                        // mã chi tiết sản phẩm khong tồn tại
                        lstLoiDuLieu.add(i);
                        continue;
                    }
                    if (!chiTietSanPhamModel.getIdSanPham().equals(sanPhamModel.getId())) {
                        // mã sản phẩm không trùng lặp
                        lstLoiDuLieu.add(i);
                        continue;
                    }
                    if (!EntityValidate.checkMoney2(this, getGiaNhap)
                            || !EntityValidate.checkSize2(this, getSize)
                            || !EntityValidate.checkPositiveNumber2(this, getSoLuong)
                            || !EntityValidate.checkColor2(this, getMauSac)) {
                        // dữ liệu nhập không hợp lệ
                        lstLoiDuLieu.add(i);
                        continue;
                    }
                    if (!chiTietSanPhamModel.getSize().equalsIgnoreCase(getSize.toLowerCase(Locale.ROOT))
                            || !chiTietSanPhamModel.getMauSac().equalsIgnoreCase(getMauSac.toLowerCase(Locale.ROOT))) {
                        // lỗi màu sắc hoặc size không khớp với mã chi tiết sản phẩm
                        lstLoiDuLieu.add(i);
                        continue;
                    }
                    chiTietHoaDonNhapHangModel = new ChiTietHoaDonNhapHangModel();
                    chiTietHoaDonNhapHangModel.setGiaNhap(Long.valueOf(getGiaNhap));
                    chiTietHoaDonNhapHangModel.setIdChiTietSanPham(chiTietSanPhamModel.getId());
                    chiTietHoaDonNhapHangModel.setSoLuong(Integer.parseInt(getSoLuong));
                    lstChiTietHoaDonNhap.add(chiTietHoaDonNhapHangModel);
                }
                StringBuilder sp = new StringBuilder();
                sp.append("Tổng số bản ghi file excel có: " + modelDSNhapHang.getRowCount());
                if (!lstLoiDuLieu.isEmpty()) {
                    sp.append("\nCác bản ghi không thể đọc do lỗi dữ liệu (được đánh số theo thứ tự trên file excel): ");
                    lstLoiDuLieu.forEach(e -> sp.append(e + 2).append(", "));
                }
                for (int i = lstLoiDuLieu.size() - 1; i >= 0; i--) {
                    modelDSNhapHang.removeRow(i);
                }
                sp.append("\nTổng số bản ghi đọc thành công: " + modelDSNhapHang.getRowCount());
                EntityMessage.show(this, sp.toString());
                hienThiTongTien(lblTongTien);
            } else {
                EntityMessage.show(this, "File excel không có dữ liệu");
            }
        } catch (IOException e) {
            e.printStackTrace();
            EntityMessage.show(this, "Lỗi thao tác");
        }
    }

    // set cột của table
    private void setColumnTable() {
        modelDSSanPham.addColumn("Mã sản phẩm");
        modelDSSanPham.addColumn("Tên sản phẩm");
        modelDSSanPham.addColumn("Loại");
        modelDSSanPham.addColumn("Size");
        modelDSSanPham.addColumn("Màu sắc");
        modelDSSanPham.addColumn("Số lượng trong kho");
        tableDSSanPham.setModel(modelDSSanPham);

        modelDSNhapHang.addColumn("Mã sản phẩm");
        modelDSNhapHang.addColumn("Tên sản phẩm");
        modelDSNhapHang.addColumn("Loại");
        modelDSNhapHang.addColumn("Giá nhập");
        modelDSNhapHang.addColumn("Size");
        modelDSNhapHang.addColumn("Màu sắc");
        modelDSNhapHang.addColumn("Số lượng nhập");
        tableDSNhapHang.setModel(modelDSNhapHang);
    }

    public void close() {
        this.setVisible(false);
    }

    // sự kiện tìm kiếm sản phẩm theo tên sản phẩm hoặc mã sản phẩm
    private void evtSearchProduct(JTextField txtSearch) {
        String getInputSearch = txtSearch.getText();
        if (getInputSearch.equalsIgnoreCase("Tìm theo tên hoặc mã sản phẩm")) {
            lstTietSanPham = chiTietSanPhamService.findAll();
            showTable(lstTietSanPham);
        } else {
            lstTietSanPham = chiTietSanPhamService.findByIdOrNameProduct(getInputSearch);
            if (lstTietSanPham != null && !lstTietSanPham.isEmpty()) {
                showTable(lstTietSanPham);
            } else {
                EntityMessage.show(this, "Không có sản phẩm nào cần tìm");
            }
        }
    }

    // hiển thị dữ liệu lên bảng
    private void showTable(List<ChiTietSanPhamModel> lst) {
        modelDSSanPham.setRowCount(0);
        for (ChiTietSanPhamModel x : lst) {
            sanPhamModel = sanPhamService.findByID(x.getIdSanPham());
            if (sanPhamModel.isStatusKinhDoanh()) {
                modelDSSanPham.addRow(new Object[]{
                        x.getId(),
                        sanPhamModel.getTenSP(),
                        loaiSanPhamService.findNameById(sanPhamModel.getIdLoaiSP()),
                        x.getSize(),
                        x.getMauSac(),
                        x.getSoLuong()
                });
            }
        }
    }

    // lưu tạm sản phẩm vào hóa đơn nhập
    private void evtBtnLuuTam(JTextField txtSoLuong, JTextField txtGiaNhap, JTable tbSanPham, JLabel lblTongTien) {
        String getSoLuong = txtSoLuong.getText();
        String getMoney = txtGiaNhap.getText();
        int row = tbSanPham.getSelectedRow();
        if (row > -1 && row < tbSanPham.getRowCount()) {
            chiTietSanPhamModel = lstTietSanPham.get(row);
            if (EntityValidate.checkPositiveNumber(this, getSoLuong) && EntityValidate.checkMoney(this, getMoney)) {
                if (lstChiTietHoaDonNhap.stream().filter(e ->
                        e.getGiaNhap().equals(Long.valueOf(getMoney))
                                && e.getIdChiTietSanPham().equals(chiTietSanPhamModel.getId()))
                        .collect(Collectors.toList()).isEmpty()) {
                    sanPhamModel = sanPhamService.findByID(chiTietSanPhamModel.getIdSanPham());
                    modelDSNhapHang.addRow(new Object[]{
                            chiTietSanPhamModel.getId(),
                            sanPhamModel.getTenSP(),
                            loaiSanPhamService.findNameById(sanPhamModel.getIdLoaiSP()),
                            EntityValidate.dinhDangMonney(Long.parseLong(getMoney)),
                            chiTietSanPhamModel.getSize(),
                            chiTietSanPhamModel.getMauSac(),
                            getSoLuong
                    });
                    // taho đôi tượng chi tiest hóa đơn nhập hàng và add vào list
                    chiTietHoaDonNhapHangModel = new ChiTietHoaDonNhapHangModel();
                    chiTietHoaDonNhapHangModel.setGiaNhap(Long.valueOf(getMoney));
                    chiTietHoaDonNhapHangModel.setSoLuong(Integer.parseInt(getSoLuong));
                    chiTietHoaDonNhapHangModel.setIdChiTietSanPham(chiTietSanPhamModel.getId());
                    lstChiTietHoaDonNhap.add(chiTietHoaDonNhapHangModel);
                    // tính tổng tiền của tất cả sản phẩm có trên table
                    hienThiTongTien(lblTongTien);
                } else {
                    int i = 0;
                    for (ChiTietHoaDonNhapHangModel x : lstChiTietHoaDonNhap) {
                        if (x.getIdChiTietSanPham().equals(chiTietSanPhamModel.getId())
                                && x.getGiaNhap().equals(Long.valueOf(getMoney))) {
                            int setSoLuong = x.getSoLuong() + Integer.parseInt(getSoLuong);
                            x.setSoLuong(setSoLuong);
                            modelDSNhapHang.setValueAt(setSoLuong, i, 6);
                            // tính tổng tiền của tất cả sản phẩm có trên table
                            hienThiTongTien(lblTongTien);
                            return;
                        }
                        ++i;
                    }
                }
            }
        }

    }

    // nút "Xóa" một hàng của bảng danh sách sản phẩm nhập
    private void evtBtnDelete(JTable tbDSNhapHang, JLabel lblTongTien) {
        int row = tbDSNhapHang.getSelectedRow();
        if (row > -1 && row < tbDSNhapHang.getRowCount()) {
            modelDSNhapHang.removeRow(row);
            lstChiTietHoaDonNhap.remove(row);
            hienThiTongTien(lblTongTien);
        } else {
            EntityMessage.show(this, "Vui lòng chọn 1 hàng");
        }
    }

    // hiển thị tổng tieen lên label
    private void hienThiTongTien(JLabel lblTongTien) {
        // tính tổng tiền của tất cả sản phẩm có trên table
        lblTongTien.setText(
                EntityValidate.dinhDangMonney(lstChiTietHoaDonNhap.stream().mapToLong(e -> e.getGiaNhap() * e.getSoLuong()).sum()));
    }

    // show nguồn hàng lên combobox
    private void showNguonHang(JComboBox<Object> cbcNguonHang, List<NguonHangModel> lstNguonHang) {
        cbcNguonHang.removeAllItems();
        if (lstNguonHang != null && !lstNguonHang.isEmpty()) {
            for (NguonHangModel x : lstNguonHang) {
                cbcNguonHang.addItem("NH - " + x.getTenNguonHang());
            }
        }
    }

    // nút "Hoàn thành"
    private void evtBtnHoanThanh(JComboBox<Object> cbcNguonHang, JTextArea txaGhiChu) {
        if (!lstChiTietHoaDonNhap.isEmpty()) {
            HoaDonNhapHangModel hoaDonNhapHangModel = new HoaDonNhapHangModel();
            hoaDonNhapHangModel.setIdNguonHang(lstNguonHang.get(cbcNguonHang.getSelectedIndex()).getId());
            hoaDonNhapHangModel.setIdNhanVienNhap(EntityAuthorization.USER.getId());
            hoaDonNhapHangModel.setGhiChu(txaGhiChu.getText());
            hoaDonNhapHangModel = hoaDonNhapHangService.save(hoaDonNhapHangModel);
            if (hoaDonNhapHangModel != null) {
                try {
                    for (ChiTietHoaDonNhapHangModel x : lstChiTietHoaDonNhap) {
                        x.setIdHoaDonNhapHang(hoaDonNhapHangModel.getId());
                        if (!chiTietHoaDonNhapHangService.save(x)) {
                            hoaDonNhapHangService.remove(hoaDonNhapHangModel);
                            chiTietHoaDonNhapHangService.reloadData();
                            EntityMessage.show(this, "Thêm thất bại");
                            return;
                        }
                    }
                    EntityMessage.show(this, "Thêm thành công");
                    this.setVisible(false);
                    nhapHangJInternalFrame.showTable(hoaDonNhapHangService.findAll());
                    chiTietSanPhamService.reloadData();
                } catch (Exception e) {
                    e.printStackTrace();
                    hoaDonNhapHangService.remove(hoaDonNhapHangModel);
                    chiTietHoaDonNhapHangService.reloadData();
                    EntityMessage.show(this, "Thêm thất bại");
                }
            } else {
                EntityMessage.show(this, "Thêm thất bại");
            }
        } else {
            EntityMessage.show(this, "Chưa thêm sản phẩm");
        }
    }

    private void init() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        modelDSNhapHang = new DefaultTableModel() {

            private static final long serialVersionUID = 7830236206956859560L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelDSSanPham = new DefaultTableModel() {

            private static final long serialVersionUID = -4855916871376159741L;

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

        JLabel lblNewLabel = new JLabel("Nhập hàng");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));

        txtTimKiem = new JTextField();
        txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtTimKiem.setText("Tìm theo tên hoặc mã sản phẩm");
        txtTimKiem.setColumns(10);

        JButton btnTimKiem = new JButton("Tìm kiếm");

        JButton btnImport = new JButton("Import");
        uiCommon.editButtonCenter(btnImport);
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
                                .addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED, 503, Short.MAX_VALUE)
                                .addComponent(btnImport, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
        );
        gl_panel_1.setVerticalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(5)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnImport, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(btnQuayLai, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_1.setLayout(gl_panel_1);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(Color.WHITE);
        panel.add(panel_4, BorderLayout.SOUTH);

        txtSoLuongNhap = new JTextField();
        txtSoLuongNhap.setColumns(10);

        JLabel lblSoLuongNhap = new JLabel("Số lượng nhập: ");
        lblSoLuongNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JLabel lblGiaNhap = new JLabel("Giá nhập:");
        lblGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));

        txtGiaNhap = new JTextField();
        txtGiaNhap.setText("");
        txtGiaNhap.setColumns(10);
        GroupLayout gl_panel_4 = new GroupLayout(panel_4);
        gl_panel_4.setHorizontalGroup(
                gl_panel_4.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_4.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblSoLuongNhap, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(txtSoLuongNhap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(17)
                                .addComponent(lblGiaNhap)
                                .addGap(28)
                                .addComponent(txtGiaNhap, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(btnLuuTam, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addGap(1284))
        );
        gl_panel_4.setVerticalGroup(
                gl_panel_4.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panel_4.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING, false)
                                        .addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE, false)
                                                .addGroup(gl_panel_4.createSequentialGroup()
                                                        .addGap(2)
                                                        .addComponent(lblGiaNhap, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(gl_panel_4.createSequentialGroup()
                                                        .addGap(2)
                                                        .addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
                                                                .addComponent(txtGiaNhap, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(btnLuuTam, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(lblSoLuongNhap, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtSoLuongNhap, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        panel_4.setLayout(gl_panel_4);

        lblSoLuongNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JPanel panel_5 = new JPanel();
        panel_5.setBackground(Color.WHITE);
        panel_5.setBorder(new TitledBorder(
                new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
                " Th\u00F4ng tin s\u1EA3n ph\u1EA9m ", TitledBorder.LEADING, TitledBorder.TOP, null,
                new Color(0, 0, 0)));
        panel.add(panel_5, BorderLayout.CENTER);
        panel_5.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        panel_5.add(scrollPane, BorderLayout.CENTER);

        tableDSSanPham = new JTable();
        tableDSSanPham.setBackground(Color.WHITE);
        scrollPane.setViewportView(tableDSSanPham);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.WHITE);
        panel_2.setBorder(new TitledBorder(
                new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
                " Nh\u1EADp h\u00E0ng ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        contentPane.add(panel_2, BorderLayout.SOUTH);

        JScrollPane scrollPane_1 = new JScrollPane();

        JComboBox<Object> cbbNguonHang = new JComboBox<Object>();
        cbbNguonHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cbbNguonHang.setModel(new DefaultComboBoxModel<Object>(new String[]{"Chọn nguồn hàng"}));

        JLabel lblNewLabel_1_1 = new JLabel("Ghi chú");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JScrollPane scrollPane_2 = new JScrollPane();

        JLabel lblNewLabel_1 = new JLabel("Thành tiền", JLabel.RIGHT);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));

        JLabel lblTongTien = new JLabel("0.0", SwingConstants.RIGHT);
        lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 20));
        JButton btnHoanThanh = new JButton("Hoàn thành");

        JButton btnXoa = new JButton("- Xóa");
        GroupLayout gl_panel_2 = new GroupLayout(panel_2);
        gl_panel_2.setHorizontalGroup(
                gl_panel_2.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panel_2.createSequentialGroup()
                                .addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_panel_2.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE))
                                .addGap(18)
                                .addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_panel_2.createSequentialGroup()
                                                .addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(cbbNguonHang, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
                                                .addGap(81))
                                        .addGroup(gl_panel_2.createSequentialGroup()
                                                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(gl_panel_2.createSequentialGroup()
                                                .addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(lblTongTien, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(scrollPane_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
                                                .addContainerGap())
                                        .addGroup(gl_panel_2.createSequentialGroup()
                                                .addComponent(btnHoanThanh, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
        );
        gl_panel_2.setVerticalGroup(
                gl_panel_2.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panel_2.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_panel_2.createSequentialGroup()
                                                .addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_panel_2.createSequentialGroup()
                                                                .addComponent(cbbNguonHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(lblNewLabel_1_1)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(lblNewLabel_1)
                                                                .addGap(18)
                                                                .addComponent(lblTongTien, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                .addGap(5))
                                        .addGroup(gl_panel_2.createSequentialGroup()
                                                .addComponent(btnHoanThanh, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                .addGap(6))))
        );

        JTextArea txtGhiChu = new JTextArea();
        scrollPane_2.setViewportView(txtGhiChu);

        tableDSNhapHang = new JTable();
        tableDSNhapHang.setBackground(Color.WHITE);
        scrollPane_1.setViewportView(tableDSNhapHang);
        panel_2.setLayout(gl_panel_2);
        setColumnTable();

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

        // show dữ liệu lên table lúc khởi chạy chương trình
        showTable(lstTietSanPham);

        // show dữ liệu lên bảng khi click nút tìm kiếm
        btnTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evtSearchProduct(txtTimKiem);
            }
        });

        // sự kiện lưu tạm sản phẩm vào bảng hàng nhập
        btnLuuTam.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                evtBtnLuuTam(txtSoLuongNhap, txtGiaNhap, tableDSSanPham, lblTongTien);
            }
        });

        // xóa một hàng trong bảng hàng nhập
        btnXoa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                evtBtnDelete(tableDSNhapHang, lblTongTien);

            }
        });

        // hiển thị nguồn hàng vào combobox
        showNguonHang(cbbNguonHang, lstNguonHang);

        // nút hoàn thành
        btnHoanThanh.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                evtBtnHoanThanh(cbbNguonHang, txtGhiChu);
            }
        });
        tableDSNhapHang.setRowHeight(25);
        tableDSSanPham.setRowHeight(25);
        uiCommon.editButtonCenter(btnXoa);
        uiCommon.editButtonCenter(btnHoanThanh);
        uiCommon.editButtonCenter(btnLuuTam);
        uiCommon.editButtonCenter(btnTimKiem);

        btnImport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (modelDSNhapHang.getRowCount() > 0) {
                    if (!EntityMessage.confirm(null, "Thao tác này sẽ khiến cho dữ liệu trên bảng hiện có bị mất")) {
                        return;
                    }
                }
                importExcel(lblTongTien);
            }
        });


    }
}
