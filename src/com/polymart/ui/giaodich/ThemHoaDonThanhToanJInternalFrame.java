package com.polymart.ui.giaodich;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
import com.polymart.model.ChiTietHoaDonThanhToanModel;
import com.polymart.model.ChiTietSanPhamModel;
import com.polymart.model.HoaDonThanhToanModel;
import com.polymart.model.KhachHangModel;
import com.polymart.model.SanPhamModel;
import com.polymart.service.IChiTietHoaDonThanhToanService;
import com.polymart.service.IChiTietSanPhamService;
import com.polymart.service.IHoaDonThanhToanService;
import com.polymart.service.IKhachHangService;
import com.polymart.service.ILoaiSanPhamService;
import com.polymart.service.ISanPhamService;
import com.polymart.service.impl.ChiTietHoaDonThanhToanService;
import com.polymart.service.impl.ChiTietSanPhamService;
import com.polymart.service.impl.HoaDonThanhToanService;
import com.polymart.service.impl.KhachHangService;
import com.polymart.service.impl.LoaiSanPhamService;
import com.polymart.service.impl.SanPhamService;
import com.polymart.ui.common.uiCommon;

public class ThemHoaDonThanhToanJInternalFrame extends JInternalFrame {

    private static final long serialVersionUID = -2254544205302634680L;

    private JPanel contentPane;
    private DefaultTableModel modelDSSanPham;
    private DefaultTableModel modelDSThanhToan;

    private JTextField txtTimKiem;
    private JTable tableDSSanPham;
    private JTextField txtSoLgBan;
    private JTable tableDSThanhToan;
    private JTextField txtGiaGiamThem;
    private JLabel lblTienTraLai;
    private JLabel lblTongTien;

    private IChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamService();
    private ISanPhamService sanPhamService = new SanPhamService();
    private ILoaiSanPhamService loaiSanPhamService = new LoaiSanPhamService();
    private IHoaDonThanhToanService hoaDonThanhToanService = new HoaDonThanhToanService();
    private IChiTietHoaDonThanhToanService chiTietHoaDonThanhToanService = new ChiTietHoaDonThanhToanService();
    private IKhachHangService khachHangService = new KhachHangService();

    private List<ChiTietSanPhamModel> lstTietSanPham = chiTietSanPhamService.findAllByHoaDonThanhToan();
    private List<KhachHangModel> lstKhachHang = khachHangService.findAll();
    private List<ChiTietHoaDonThanhToanModel> lstChiTietHoaDonThanhToanModels = new ArrayList<>();

    private ChiTietHoaDonThanhToanModel chiTietHoaDonThanhToanModel = null;
    private ChiTietSanPhamModel chiTietSanPhamModel = null;
    private SanPhamModel sanPhamModel = null;
    private JCheckBox chkTichDiem;

    private ThanhToanJInternalFrame thanhToanJInternalFrame = null;

    // tính tổng tiền
    private Long tongTien = Long.valueOf(0);
    private JTextField txtTienKhachDua;

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
        init();
    }

    public ThemHoaDonThanhToanJInternalFrame(ThanhToanJInternalFrame thanhToanJInternalFrame) {
        this.thanhToanJInternalFrame = thanhToanJInternalFrame;
        init();
    }

    // kiểm tra tiền khách đưa và tính tiền trả lại
    private void tienKhachDua() {
        String getTienKhachDua = txtTienKhachDua.getText();
        if (EntityValidate.checkMoney(this, getTienKhachDua)) {
            if (tongTien == 0) {
                return;
            } else {
                Long tienKhachDua = Long.valueOf(0);
                if (Long.parseLong(getTienKhachDua) <= tongTien) {
                    lblTienTraLai.setText(EntityValidate.dinhDangMonney(tienKhachDua));
                } else {
                    lblTienTraLai.setText(EntityValidate.dinhDangMonney(Long.parseLong(getTienKhachDua)
                            - tongTien));
                }
            }
        }
    }

    // set tiền khi tích đổi điểm

    private void clickedTichDiem(JCheckBox chkTichDiem, JLabel lblTongTien) {
        Long setTien;
        if (chkTichDiem.isSelected()) {
            if (tongTien > Long.parseLong(chkTichDiem.getText())) {
                setTien = tongTien - Long.parseLong(chkTichDiem.getText());
                lblTongTien.setText(EntityValidate.dinhDangMonney(setTien));
            }
        } else {
            lblTongTien.setText(EntityValidate.dinhDangMonney(tongTien));
        }
        tienKhachDua();
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
                    saveHoaDon(lblTongTien, getSoLuong, getMoney);
                } else {
                    EntityMessage.show(this, "Số lượng vượt quá số lượng hàng tồn kho");
                }
            } else {
                EntityMessage.show(this, "Mời chọn 1 sản phẩm");
            }
        }
    }

    private void saveHoaDon(JLabel lblTongTien, String getSoLuong, String getMoney) {
        if (lstChiTietHoaDonThanhToanModels.stream().filter(e ->
                e.getChiTietSanPham().equals(chiTietSanPhamModel.getId())
                        && e.getGiamGiaThem().equals(Long.valueOf(getMoney)))
                .collect(Collectors.toList()).isEmpty()) {
            // check nếu thông tin sản phẩm chưa có trong list trả hàng
            checkSanPhamChuaCoTrongList(lblTongTien, getSoLuong, getMoney);
        } else {
            // cộng dồn số lượng khi thông tin trả hàng đã có trong list trả hàng
            checkSanPhamCoTrongList(lblTongTien, getSoLuong, getMoney);
        }
    }

    // cộng dồn số lượng khi thông tin trả hàng đã có trong list trả hàng

    private void checkSanPhamCoTrongList(JLabel lblTongTien, String getSoLuong, String getMoney) {
        int i = 0;
        for (ChiTietHoaDonThanhToanModel x : lstChiTietHoaDonThanhToanModels) {
            if (x.getChiTietSanPham().equals(chiTietSanPhamModel.getId())
                    && x.getGiamGiaThem().equals(Long.valueOf(getMoney))) {
                int setSoLuong = x.getSoLuong() + Integer.parseInt(getSoLuong);
                if (setSoLuong <= chiTietSanPhamModel.getSoLuong()) {
                    x.setSoLuong(setSoLuong);
                    modelDSThanhToan.setValueAt(setSoLuong, i, 8);
                    // tính tổng tiền của tất cả sản phẩm có trên table
                    tinhTienHienThiLabel(lblTongTien);
                } else {
                    EntityMessage.show(this, "Số lượng vượt quá số lượng hàng tồn kho");
                }
                return;
            }
            ++i;
        }
    }
    // check nếu thông tin sản phẩm chưa có trong list trả hàng

    private void checkSanPhamChuaCoTrongList(JLabel lblTongTien, String getSoLuong, String getMoney) {
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
            tinhTienHienThiLabel(lblTongTien);
        } else {
            EntityMessage.show(this, "Số lượng vượt quá số lượng hàng tồn kho");
        }
    }
    // tính tổng tiền và hiển thị lên table

    private void tinhTienHienThiLabel(JLabel lblTongTien) {
        tongTien = lstChiTietHoaDonThanhToanModels.stream().mapToLong(
                e -> (((chiTietSanPhamModel.getGiaBan() - chiTietSanPhamModel.getGiaGiam())
                        * e.getSoLuong()) - e.getGiamGiaThem())).sum();
        lblTongTien.setText(EntityValidate.dinhDangMonney(tongTien));
        lblTienTraLai.setText(String.valueOf(0));
    }
    // hiển thị danh sach khách hàng

    private void evtShowVisit(JComboBox<Object> cbcKhachHang) {
        cbcKhachHang.removeAllItems();
        if (!lstKhachHang.isEmpty()) {
            chkTichDiem.setText(lstKhachHang.get(0).getTichDiem().toString());
            for (KhachHangModel x : lstKhachHang) {
                cbcKhachHang.addItem("KH - " + x.getHoTen());
            }
        }
    }
    // hoàn thành hóa đơn và cập nhật dữ liệu liên quan

    private void evtBtnHoanThanh(JComboBox<Object> cbcKhachHang, JTextArea txaGhiChu, JCheckBox chkTichDiem) {
        if (!lstChiTietHoaDonThanhToanModels.isEmpty()) {
            KhachHangModel khachHangModel = lstKhachHang.get(cbcKhachHang.getSelectedIndex());
            HoaDonThanhToanModel hoaDonThanhToanModel = new HoaDonThanhToanModel();
            hoaDonThanhToanModel.setIdKhachHang(khachHangModel.getId());
            hoaDonThanhToanModel.setIdNhanVien(EntityAuthorization.USER.getId());
            hoaDonThanhToanModel.setGhiChu(txaGhiChu.getText());
            if (chkTichDiem.isSelected()) {
                hoaDonThanhToanModel.setDiemDaDoi(khachHangModel.getTichDiem());
            } else {
                hoaDonThanhToanModel.setDiemDaDoi(0);
            }
            hoaDonThanhToanModel = hoaDonThanhToanService.save(hoaDonThanhToanModel);
            if (hoaDonThanhToanModel != null) {
                taoHoaDonThanhToanThanhCong(khachHangModel, hoaDonThanhToanModel);
            } else {
                EntityMessage.show(this, "Thêm thất bại");
            }
        } else {
            EntityMessage.show(this, "Chưa thêm sản phẩm");
        }
    }

    private void taoHoaDonThanhToanThanhCong(KhachHangModel khachHangModel, HoaDonThanhToanModel hoaDonThanhToanModel) {
        if (luuChiTietHoaDonThanhToan(hoaDonThanhToanModel)) return;
        capNhatTichDiemCuaKhachHang(khachHangModel, hoaDonThanhToanModel);
        if (khachHangService.update(khachHangModel) != null) {
            EntityMessage.show(this, "Thêm thành công");
            this.setVisible(false);
            thanhToanJInternalFrame.showTable(hoaDonThanhToanService.findAll());
            chiTietSanPhamService.reloadData();
            chiTietHoaDonThanhToanService.reloadData();
        } else {
            luuHoaDonThatBai(hoaDonThanhToanModel);
        }
    }

    // cập nhật tích điểm của khách hàng thanh toán

    private void capNhatTichDiemCuaKhachHang(KhachHangModel khachHangModel, HoaDonThanhToanModel hoaDonThanhToanModel) {
        String tichDiem = String.valueOf(tongTien * 0.01);
        khachHangModel.setTichDiem(khachHangModel.getTichDiem() - hoaDonThanhToanModel.getDiemDaDoi()
                + Integer.parseInt(tichDiem.substring(0, tichDiem.indexOf("."))));
        if (khachHangModel.getHoTen().equalsIgnoreCase("admin")) {
            khachHangModel.setTichDiem(0);
        }
    }
    // lưu lần lượt chi tiết hóa đơn thanh toán

    private boolean luuChiTietHoaDonThanhToan(HoaDonThanhToanModel hoaDonThanhToanModel) {
        for (ChiTietHoaDonThanhToanModel x : lstChiTietHoaDonThanhToanModels) {
            x.setHoaDonThanhToan(hoaDonThanhToanModel.getId());
            if (!chiTietHoaDonThanhToanService.save(x)) {
                luuHoaDonThatBai(hoaDonThanhToanModel);
                return true;
            }
        }
        return false;
    }
    // hiển thị thông báo khi lưu hóa đơn thất bái

    private void luuHoaDonThatBai(HoaDonThanhToanModel hoaDonThanhToanModel) {
        hoaDonThanhToanService.remove(hoaDonThanhToanModel);
        chiTietHoaDonThanhToanService.reloadData();
        EntityMessage.show(this, "Thêm thất bại");
    }
    // nút "Xóa" một hàng của bảng danh sách sản phẩm nhập

    private void evtBtnDelete(JTable tbDSThanhToan, JLabel lblTongTien) {
        int row = tbDSThanhToan.getSelectedRow();
        if (row > -1 && row < tbDSThanhToan.getRowCount()) {
            chiTietSanPhamModel = chiTietSanPhamService.getById(Integer.parseInt(tbDSThanhToan.getValueAt(row, 0).toString()));
            // xóa trên bảng
            modelDSThanhToan.removeRow(row);
            lstChiTietHoaDonThanhToanModels.remove(row);
            // tính tổng tiền của tất cả sản phẩm có trên table
            tinhTienHienThiLabel(lblTongTien);
        } else {
            EntityMessage.show(this, "Vui lòng chọn 1 hàng");
        }
    }
    // hiển thị danh sách sản phẩm lên table

    private void showTableProduct(List<ChiTietSanPhamModel> lstTietSanPham) {
        if (!lstTietSanPham.isEmpty()) {
            modelDSSanPham.setRowCount(0);
            for (ChiTietSanPhamModel x : lstTietSanPham) {
                sanPhamModel = sanPhamService.findByID(x.getIdSanPham());
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

    // tìm kiếm theo số diện thoại khách hàng
    private void evtSearchKhachHang(JComboBox cbcKhachHang) {
        String getSearch = JOptionPane.showInputDialog("Nhập tên hoặc số điện thoại của khách hàng!");
        if (getSearch.isBlank()) {
            return;
        }
        List<KhachHangModel> lstSearch = khachHangService.filter(getSearch);
        if (lstSearch.isEmpty()) {
            EntityMessage.show(this, "Không tìm thấy ai");
            return;
        }
        lstKhachHang = lstSearch;
        evtShowVisit(cbcKhachHang);
    }

    private void init() {
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

        JLabel lblNewLabel = new JLabel("  Thanh toán bán hàng");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));

        txtTimKiem = new JTextField();
        txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtTimKiem.setText("Tìm theo tên hoặc mã sản phẩm");
        txtTimKiem.setColumns(10);

        JButton btnTimKiem = new JButton("Tìm kiếm");
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(5)
                                .addComponent(btnQuayLai)
                                .addGap(5)
                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(558, Short.MAX_VALUE))
        );
        gl_panel_1.setVerticalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(5)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(btnQuayLai, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_1.setLayout(gl_panel_1);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(Color.WHITE);
        panel.add(panel_4, BorderLayout.SOUTH);

        txtSoLgBan = new JTextField();
        txtSoLgBan.setColumns(10);

        JButton btnLuuTam = new JButton("Lưu tạm");

        JLabel lblSoLuongBan = new JLabel("Số lượng bán:");
        lblSoLuongBan.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JLabel lblGiaGiamThem = new JLabel("Giá giảm thêm:");
        lblGiaGiamThem.setFont(new Font("Tahoma", Font.PLAIN, 16));

        txtGiaGiamThem = new JTextField("0");
        txtGiaGiamThem.setFont(new Font("Tahoma", Font.PLAIN, 13));
        txtGiaGiamThem.setColumns(10);

        JLabel lbliim = new JLabel("Đổi điểm");
        lbliim.setFont(new Font("Tahoma", Font.PLAIN, 16));

        chkTichDiem = new JCheckBox("Điểm hiện có");
        chkTichDiem.setBackground(new Color(255, 255, 255));
        GroupLayout gl_panel_4 = new GroupLayout(panel_4);
        gl_panel_4.setHorizontalGroup(
                gl_panel_4.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_4.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblSoLuongBan, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(txtSoLgBan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(lblGiaGiamThem)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(txtGiaGiamThem, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                .addGap(38)
                                .addComponent(lbliim, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                .addGap(37)
                                .addComponent(chkTichDiem, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                .addGap(31)
                                .addComponent(btnLuuTam, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addGap(989))
        );
        gl_panel_4.setVerticalGroup(
                gl_panel_4.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_4.createSequentialGroup()
                                .addContainerGap(12, Short.MAX_VALUE)
                                .addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblSoLuongBan, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSoLgBan, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblGiaGiamThem, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtGiaGiamThem, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbliim, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                        .addGroup(gl_panel_4.createSequentialGroup()
                                .addGap(15)
                                .addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnLuuTam, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(chkTichDiem, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        panel_4.setLayout(gl_panel_4);

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

        lblTongTien = new JLabel("0", SwingConstants.RIGHT);
        lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 20));

        JButton btnHoanThanh = new JButton("Hoàn thành");

        JButton btnXoa = new JButton("- Xóa");

        JLabel lblTinKhcha = new JLabel("Tiền khách đưa:");
        lblTinKhcha.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JLabel lbliim_1_1 = new JLabel("Tiền trả lại:");
        lbliim_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));

        lblTienTraLai = new JLabel("0", JLabel.RIGHT);
        lblTienTraLai.setFont(new Font("Tahoma", Font.PLAIN, 16));

        txtTienKhachDua = new JTextField("0");
        txtTienKhachDua.setFont(new Font("Tahoma", Font.PLAIN, 13));
        txtTienKhachDua.setColumns(10);

        JButton btnTm = new JButton("Tìm");
        uiCommon.editButtonCenter(btnTm);
        btnTm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                evtSearchKhachHang(cbbKhachHang);
            }
        });
        GroupLayout gl_panel_2 = new GroupLayout(panel_2);
        gl_panel_2.setHorizontalGroup(
                gl_panel_2.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panel_2.createSequentialGroup()
                                .addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_panel_2.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE))
                                .addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_panel_2.createSequentialGroup()
                                                .addGap(18)
                                                .addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
                                                        .addComponent(lblNewLabel_1_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnHoanThanh, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                                                        .addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
                                                                .addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
                                                                        .addComponent(lblTinKhcha, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lbliim_1_1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
                                                                        .addComponent(lblTienTraLai, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                                                        .addComponent(txtTienKhachDua, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)))
                                                        .addGroup(gl_panel_2.createSequentialGroup()
                                                                .addComponent(cbbKhachHang, 0, 269, Short.MAX_VALUE)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(btnTm, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap())
                                        .addGroup(gl_panel_2.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(gl_panel_2.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(lblTongTien, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                                .addContainerGap())))
        );
        gl_panel_2.setVerticalGroup(
                gl_panel_2.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panel_2.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
                                        .addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
                                                .addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
                                                        .addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnHoanThanh, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(gl_panel_2.createSequentialGroup()
                                                .addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(cbbKhachHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnTm, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(lblNewLabel_1_1)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_panel_2.createSequentialGroup()
                                                                .addComponent(lblTinKhcha, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(lbliim_1_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_panel_2.createSequentialGroup()
                                                                .addComponent(txtTienKhachDua, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(lblTienTraLai, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(lblNewLabel_1)
                                                .addGap(18)
                                                .addComponent(lblTongTien, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))))
        );

        JTextArea txtGhiChu = new JTextArea();
        scrollPane_2.setViewportView(txtGhiChu);

        tableDSThanhToan = new JTable();
        tableDSThanhToan.setBackground(Color.WHITE);
        scrollPane_1.setViewportView(tableDSThanhToan);
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
        tableDSThanhToan.setModel(modelDSThanhToan);

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
                clickedTichDiem(chkTichDiem, lblTongTien);
            }
        });

        // hiển thị danh sách khách hàng
        evtShowVisit(cbbKhachHang);

        // hiển thị điểm khách hàng
        cbbKhachHang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cbbKhachHang.getItemCount() > 0) {
                    KhachHangModel khachHangModel = lstKhachHang.get(cbbKhachHang.getSelectedIndex());
                    chkTichDiem.setText(khachHangModel.getTichDiem().toString());
                    chkTichDiem.setSelected(false);
                    lblTongTien.setText(EntityValidate.dinhDangMonney(tongTien));
                    tienKhachDua();
                }
            }
        });

        // lưu hóa đơn
        btnHoanThanh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evtBtnHoanThanh(cbbKhachHang, txtGhiChu, chkTichDiem);
            }
        });


        // hiển thị danh sách sản phẩm
        showTableProduct(lstTietSanPham);

        // xóa sản phẩm thanh toán
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evtBtnDelete(tableDSThanhToan, lblTongTien);
                clickedTichDiem(chkTichDiem, lblTongTien);
            }
        });
        tableDSSanPham.setRowHeight(25);
        tableDSThanhToan.setRowHeight(25);

        // trừ tổng tiền khi dùng điểm
        chkTichDiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedTichDiem(chkTichDiem, lblTongTien);
            }
        });

        uiCommon.editButtonCenter(btnXoa);
        uiCommon.editButtonCenter(btnHoanThanh);
        uiCommon.editButtonCenter(btnLuuTam);
        uiCommon.editButtonCenter(btnTimKiem);

        txtTienKhachDua.addKeyListener(new KeyListener() {
            String key;

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                key = String.valueOf(e.getKeyChar());
                if (key.matches("\\w") || key.matches("\\p{Punct}")) {
                    tienKhachDua();
                } else {
                    lblTienTraLai.setText(String.valueOf(0));
                }
            }
        });
    }

}
