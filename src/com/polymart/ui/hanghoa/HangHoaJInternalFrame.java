package com.polymart.ui.hanghoa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.polymart.entity.EntityFrame;
import com.polymart.model.ChiTietSanPhamModel;
import com.polymart.model.SanPhamModel;
import com.polymart.service.IChiTietSanPhamService;
import com.polymart.service.ILoaiSanPhamService;
import com.polymart.service.ISanPhamService;
import com.polymart.service.impl.ChiTietSanPhamService;
import com.polymart.service.impl.LoaiSanPhamService;
import com.polymart.service.impl.SanPhamService;
import com.polymart.ui.common.uiCommon;

public class HangHoaJInternalFrame extends JInternalFrame {

    private static final long serialVersionUID = 7158581259856675232L;

    private JPanel contentPane;
    private JPanel panelOption;
    private JTextField txtFind;
    private JTable tblHangHoa;
    private DefaultTableModel modelHangHoa;
    private String columnHangHoa[] = {"Mã sản phẩm", "Tên sản phẩm", "Loại", "Số lượng", "Giá bán", "Giá vốn",
            "Giảm giá", "Size", "Màu sắc"};

    private JPanel pnlTop = new JPanel();
    private JPanel pnlNavibar;
    private static JFrame optionDanhMucFrame = new JFrame();

    // combobox hàng hóa
    private JCheckBox chkHinhAnh = new JCheckBox("Hình ảnh");
    private JCheckBox chkMaHang = new JCheckBox("Mã hàng");
    private JCheckBox chkMaVach = new JCheckBox("Mã vạch");
    private JCheckBox chkTenHang = new JCheckBox("Tên hàng");
    private JCheckBox chkNhomHang = new JCheckBox("Nhóm hàng");
    private JCheckBox chkLoaiHang = new JCheckBox("Loại hàng");
    private JCheckBox chkLKKenhBan = new JCheckBox("Liên kết kênh bán");
    private JCheckBox chkGiaBan = new JCheckBox("Giá bán");
    private JCheckBox chkGiaVon = new JCheckBox("Giá vốn");
    private JCheckBox chkDMNhieuNhat = new JCheckBox("Định mức tồn nhiều nhất");
    private JCheckBox chkDMItNhat = new JCheckBox("Định mức tồn ít nhất");
    private JCheckBox chkDuKienHH = new JCheckBox("Dự kiến kết hàng");
    private JCheckBox chkKhachHangDat = new JCheckBox("Khách hàng đặt");
    private JCheckBox chkViTri = new JCheckBox("Vị trí");
    private JCheckBox chkTonKho = new JCheckBox("Tồn kho");
    private JCheckBox chkThuongHieu = new JCheckBox("Thương hiệu");
    private JCheckBox chkTrangThai = new JCheckBox("Trạng thái");

    // service
    private ISanPhamService sanPhamService = new SanPhamService();
    private ILoaiSanPhamService loaiSanPhamService = new LoaiSanPhamService();
    private IChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamService();

    // lisst
    private List<ChiTietSanPhamModel> lstChiTietSanPhamModels;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HangHoaJInternalFrame frame = new HangHoaJInternalFrame();
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
    public HangHoaJInternalFrame() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setFocusable(true);
        contentPane = new JPanel();
        pnlNavibar = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        contentPane.add(pnlTop, BorderLayout.NORTH);
        pnlTop.setBounds(68, 120, 96, 20);

        contentPane.add(pnlNavibar, BorderLayout.WEST);
        pnlTop.setLayout(new BoxLayout(pnlTop, BoxLayout.X_AXIS));

        Component horizontalStrut_1 = Box.createHorizontalStrut(20);
        pnlTop.add(horizontalStrut_1);
        JLabel lblTitle = new JLabel("Hàng hóa");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        pnlTop.add(lblTitle);

        Component horizontalStrut = Box.createHorizontalStrut(95);
        pnlTop.add(horizontalStrut);

        txtFind = new JTextField();
        txtFind.setFont(new Font("SansSerif", Font.PLAIN, 14));
        txtFind.setText(" Tìm theo mã, tên hàng");
        txtFind.setColumns(10);
        pnlTop.add(txtFind);
        txtFind.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtFind.getText().equals(" Tìm theo mã, tên hàng")) {
                    txtFind.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtFind.getText().equals("")) {
                    txtFind.setText(" Tìm theo mã, tên hàng");
                }
            }
        });

        Component horizontalGlue = Box.createHorizontalGlue();
        pnlTop.add(horizontalGlue);

        JButton btnTimKiem = new JButton("Tìm kiếm");
        btnTimKiem.setFont(new Font("SansSerif", Font.PLAIN, 15));
        pnlTop.add(btnTimKiem);

        Component horizontalStrut_2 = Box.createHorizontalStrut(120);
        pnlTop.add(horizontalStrut_2);

        JButton btnThemHang = new JButton("+ Thêm mới");
        btnThemHang.setFont(new Font("SansSerif", Font.PLAIN, 15));
        pnlTop.add(btnThemHang);
        btnThemHang.addActionListener(themSanPham);

        JButton btnImport = new JButton("Import");
        btnImport.setFont(new Font("SansSerif", Font.PLAIN, 15));
        pnlTop.add(btnImport);

        JButton btnExport = new JButton("Export");
        btnExport.setFont(new Font("SansSerif", Font.PLAIN, 15));
        pnlTop.add(btnExport);

        JButton btnOption = new JButton("");
        btnOption.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                optionClicked();
            }
        });
        pnlTop.add(btnOption);
        btnOption.setIcon(new ImageIcon("images\\danhmuc.png"));

        initTopHangHoa();
        initCenterHangHoa();
    }

    public void initTopHangHoa() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setTitle("Hàng hóa - Hàng hóa");

        optionDanhMucFrame.setSize(344, 264);
        optionDanhMucFrame.setLocation(uiCommon.width - 360, uiCommon.height - (uiCommon.height / 100 * 86));
        panelOption = new JPanel();
        panelOption.setLayout(null);
        panelOption.setBackground(Color.white);
        panelOption.setBorder(new EmptyBorder(0, 0, 5, 5));
        uiCommon uiCommon = new uiCommon(panelOption);

        uiCommon.addCheckBox(chkHinhAnh, 10, 7, 99);
        uiCommon.addCheckBox(chkMaHang, 10, 33, 99);
        uiCommon.addCheckBox(chkMaVach, 10, 59, 99);
        uiCommon.addCheckBox(chkTenHang, 10, 85, 99);
        uiCommon.addCheckBox(chkNhomHang, 10, 111, 99);
        uiCommon.addCheckBox(chkLoaiHang, 10, 137, 99);
        uiCommon.addCheckBox(chkLKKenhBan, 10, 163, 133);
        uiCommon.addCheckBox(chkGiaBan, 10, 189, 99);
        uiCommon.addCheckBox(chkGiaVon, 10, 215, 99);
        uiCommon.addCheckBox(chkDMNhieuNhat, 141, 163, 178);
        uiCommon.addCheckBox(chkDMItNhat, 141, 137, 178);
        uiCommon.addCheckBox(chkDuKienHH, 141, 111, 178);
        uiCommon.addCheckBox(chkKhachHangDat, 141, 85, 178);
        uiCommon.addCheckBox(chkViTri, 141, 59, 99);
        uiCommon.addCheckBox(chkTonKho, 141, 33, 99);
        uiCommon.addCheckBox(chkThuongHieu, 141, 7, 144);
        uiCommon.addCheckBox(chkTrangThai, 141, 189, 99);

        optionDanhMucFrame.getContentPane().add(panelOption);
        optionDanhMucFrame.setUndecorated(true);
    }

    public void initCenterHangHoa() {
        JPanel pnlLoaiHang = new JPanel();
        pnlLoaiHang.setBorder(
                new TitledBorder(null, "Lo\u1EA1i H\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlNavibar.setLayout(new BoxLayout(pnlNavibar, BoxLayout.Y_AXIS));
        pnlNavibar.add(pnlLoaiHang);
        pnlLoaiHang.setLayout(new BoxLayout(pnlLoaiHang, BoxLayout.Y_AXIS));
        JCheckBox chkbHangHoa = new JCheckBox("Hàng hóa");
        chkbHangHoa.setFont(new Font("SansSerif", Font.PLAIN, 14));
        pnlLoaiHang.add(chkbHangHoa);
        JCheckBox chkbDichVu = new JCheckBox("Dịch vụ");
        chkbDichVu.setFont(new Font("SansSerif", Font.PLAIN, 14));
        pnlLoaiHang.add(chkbDichVu);
        JCheckBox chkbCombo = new JCheckBox("Combo - đóng gói              ");
        chkbCombo.setFont(new Font("SansSerif", Font.PLAIN, 14));
        pnlLoaiHang.add(chkbCombo);

        Component verticalStrut = Box.createVerticalStrut(20);
        pnlNavibar.add(verticalStrut);

        JPanel pnlTonKho = new JPanel();
        pnlTonKho.setBorder(new TitledBorder(null, "T\u1ED3n kho", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlTonKho.setLayout(new BoxLayout(pnlTonKho, BoxLayout.Y_AXIS));
        pnlNavibar.add(pnlTonKho);

        JRadioButton rdoTonKhoTatCa = new JRadioButton("Tất cả");
        rdoTonKhoTatCa.setFont(new Font("SansSerif", Font.PLAIN, 14));
        JRadioButton rdoDuoiDinhMucTon = new JRadioButton("Dưới định mức tồn");
        rdoDuoiDinhMucTon.setFont(new Font("SansSerif", Font.PLAIN, 14));
        JRadioButton rdoVuotDinhMucTon = new JRadioButton("Vượi định mức tồn");
        rdoVuotDinhMucTon.setFont(new Font("SansSerif", Font.PLAIN, 14));
        JRadioButton rdoConHangTrongKho = new JRadioButton("Còn hàng trong kho");
        rdoConHangTrongKho.setFont(new Font("SansSerif", Font.PLAIN, 14));
        JRadioButton rdoHetHangTrongKho = new JRadioButton("Hết hàng trong kho            ");
        rdoHetHangTrongKho.setFont(new Font("SansSerif", Font.PLAIN, 14));
        pnlTonKho.add(rdoTonKhoTatCa);
        pnlTonKho.add(rdoDuoiDinhMucTon);
        pnlTonKho.add(rdoVuotDinhMucTon);
        pnlTonKho.add(rdoConHangTrongKho);
        pnlTonKho.add(rdoHetHangTrongKho);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdoTonKhoTatCa);
        buttonGroup.add(rdoDuoiDinhMucTon);
        buttonGroup.add(rdoVuotDinhMucTon);
        buttonGroup.add(rdoConHangTrongKho);
        buttonGroup.add(rdoHetHangTrongKho);

        Component verticalStrut_1_1 = Box.createVerticalStrut(20);
        pnlNavibar.add(verticalStrut_1_1);

        JPanel pnlBanTrucTiep = new JPanel();
        pnlBanTrucTiep.setBorder(new TitledBorder(null, "B\u00E1n tr\u1EF1c ti\u1EBFp", TitledBorder.LEADING,
                TitledBorder.TOP, null, null));
        pnlBanTrucTiep.setLayout(new BoxLayout(pnlBanTrucTiep, BoxLayout.Y_AXIS));
        pnlNavibar.add(pnlBanTrucTiep);

        JRadioButton rdoBanTrucTiepTatCa = new JRadioButton("Tất cả");
        rdoBanTrucTiepTatCa.setFont(new Font("SansSerif", Font.PLAIN, 14));
        JRadioButton rdoDuocBanTrucTiep = new JRadioButton("Được bán trực tiếp");
        rdoDuocBanTrucTiep.setFont(new Font("SansSerif", Font.PLAIN, 14));
        JRadioButton rdoKhongDuocBanTrucTiep = new JRadioButton("Không được bán trực tiếp");
        rdoKhongDuocBanTrucTiep.setFont(new Font("SansSerif", Font.PLAIN, 14));
        pnlBanTrucTiep.add(rdoBanTrucTiepTatCa);
        pnlBanTrucTiep.add(rdoDuocBanTrucTiep);
        pnlBanTrucTiep.add(rdoKhongDuocBanTrucTiep);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(rdoBanTrucTiepTatCa);
        buttonGroup2.add(rdoDuocBanTrucTiep);
        buttonGroup2.add(rdoKhongDuocBanTrucTiep);

        Component verticalStrut_1_2 = Box.createVerticalStrut(20);
        pnlNavibar.add(verticalStrut_1_2);

        JPanel pnlNgayDuKienHetHang = new JPanel();
        pnlNgayDuKienHetHang.setBorder(new TitledBorder(null, "Ng\u00E0y d\u1EF1 ki\u1EBFn h\u1EBFt h\u00E0ng",
                TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlNgayDuKienHetHang.setLayout(new BoxLayout(pnlNgayDuKienHetHang, BoxLayout.Y_AXIS));
        pnlNavibar.add(pnlNgayDuKienHetHang);

        JRadioButton rdoToanThoiGian = new JRadioButton("Toàn thời gian                    ");
        rdoToanThoiGian.setFont(new Font("SansSerif", Font.PLAIN, 14));
        JRadioButton rdoLuaChonKhac = new JRadioButton("Lựa chọn khác");
        rdoLuaChonKhac.setFont(new Font("SansSerif", Font.PLAIN, 14));
        pnlNgayDuKienHetHang.add(rdoToanThoiGian);
        pnlNgayDuKienHetHang.add(rdoLuaChonKhac);

        ButtonGroup buttonGroup3 = new ButtonGroup();
        buttonGroup3.add(rdoToanThoiGian);
        buttonGroup3.add(rdoLuaChonKhac);

        Component verticalStrut_2 = Box.createVerticalStrut(20);
        pnlNavibar.add(verticalStrut_2);

        JPanel pnlLienKetBanHang = new JPanel();
        pnlLienKetBanHang.setBorder(new TitledBorder(null, "Li\u00EAn k\u1EBFt b\u00E1n h\u00E0ng",
                TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlLienKetBanHang.setLayout(new BoxLayout(pnlLienKetBanHang, BoxLayout.Y_AXIS));
        pnlNavibar.add(pnlLienKetBanHang);

        JRadioButton rdoLienKetBanHangTatCa = new JRadioButton("Tất cả");
        rdoLienKetBanHangTatCa.setFont(new Font("SansSerif", Font.PLAIN, 14));
        JRadioButton rdoCoLienKetKenhBan = new JRadioButton("Có liên kết kênh bán");
        rdoCoLienKetKenhBan.setFont(new Font("SansSerif", Font.PLAIN, 14));
        JRadioButton rdoKhongLienKetKenhBan = new JRadioButton("Không liên kết kênh bán  ");
        rdoKhongLienKetKenhBan.setFont(new Font("SansSerif", Font.PLAIN, 14));
        pnlLienKetBanHang.add(rdoLienKetBanHangTatCa);
        pnlLienKetBanHang.add(rdoCoLienKetKenhBan);
        pnlLienKetBanHang.add(rdoKhongLienKetKenhBan);

        ButtonGroup buttonGroup4 = new ButtonGroup();
        buttonGroup4.add(rdoLienKetBanHangTatCa);
        buttonGroup4.add(rdoCoLienKetKenhBan);
        buttonGroup4.add(rdoKhongLienKetKenhBan);

        Component verticalStrut_1 = Box.createVerticalStrut(20);
        pnlNavibar.add(verticalStrut_1);

        JPanel pnlLuaChonHienThi = new JPanel();
        pnlLuaChonHienThi.setBorder(new TitledBorder(null, "L\u1EF1a ch\u1ECDn hi\u1EC3n th\u1ECB",
                TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlLuaChonHienThi.setLayout(new BoxLayout(pnlLuaChonHienThi, BoxLayout.Y_AXIS));
        pnlNavibar.add(pnlLuaChonHienThi);

        JRadioButton rdoLuaChonHienThiTatCa = new JRadioButton("Tất cả");
        rdoLuaChonHienThiTatCa.setFont(new Font("SansSerif", Font.PLAIN, 14));
        JRadioButton rdoHangDangKinhDoanh = new JRadioButton("Hàng đang kinh doanh");
        rdoHangDangKinhDoanh.setFont(new Font("SansSerif", Font.PLAIN, 14));
        JRadioButton rdoHangNgungKinhDoanh = new JRadioButton("Hàng ngừng kinh doanh   ");
        rdoHangNgungKinhDoanh.setFont(new Font("SansSerif", Font.PLAIN, 14));
        pnlLuaChonHienThi.add(rdoLuaChonHienThiTatCa);
        pnlLuaChonHienThi.add(rdoHangDangKinhDoanh);
        pnlLuaChonHienThi.add(rdoHangNgungKinhDoanh);

        ButtonGroup buttonGroup5 = new ButtonGroup();
        buttonGroup5.add(rdoLuaChonHienThiTatCa);
        buttonGroup5.add(rdoHangDangKinhDoanh);
        buttonGroup5.add(rdoHangNgungKinhDoanh);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        modelHangHoa = new DefaultTableModel(columnHangHoa, 0);
        tblHangHoa = new JTable(modelHangHoa) {
            private static final long serialVersionUID = 5377371199505474349L;

            public boolean isCellEditable(int row, int column) {
                return false;
            }

            ;
        };
        scrollPane.setViewportView(tblHangHoa);

        // table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblHangHoa.getColumnModel().getColumn(0).setPreferredWidth(120);
        tblHangHoa.getColumnModel().getColumn(1).setPreferredWidth(350);
        tblHangHoa.getColumnModel().getColumn(2).setPreferredWidth(120);
        tblHangHoa.getColumnModel().getColumn(3).setPreferredWidth(120);
        tblHangHoa.getColumnModel().getColumn(4).setPreferredWidth(120);
        tblHangHoa.getColumnModel().getColumn(5).setPreferredWidth(100);
        tblHangHoa.getColumnModel().getColumn(6).setPreferredWidth(130);
        tblHangHoa.getColumnModel().getColumn(7).setPreferredWidth(130);

        // hiển thị table
        showTable(getList());
        tblHangHoa.setRowHeight(25);

    }

    ActionListener themSanPham = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ThemHangHoaJInternalFrame themHangHoaJInternalFrame = new ThemHangHoaJInternalFrame();
            EntityFrame.POLYMARTMAIN.pnlMain.add(themHangHoaJInternalFrame);
            themHangHoaJInternalFrame.setVisible(true);
        }
    };

    // showw sản phẩm lên bảng
    private void showTable(List<ChiTietSanPhamModel> lst) {
        modelHangHoa.setRowCount(0);
        for (ChiTietSanPhamModel x : lst) {
            SanPhamModel sanPhamModel = sanPhamService.findByID(x.getIdSanPham());
            modelHangHoa.addRow(new Object[]{
                    x.getId(),
                    sanPhamModel.getTenSP(),
                    loaiSanPhamService.findNameById(sanPhamModel.getIdLoaiSP()),
                    x.getSoLuong(),
                    x.getGiaBan(),
                    x.getGiaVon(),
                    x.getGiaGiam(),
                    x.getSize(),
                    x.getMauSac()
            });
        }

    }

    // getList
    private List<ChiTietSanPhamModel> getList() {
        return lstChiTietSanPhamModels = chiTietSanPhamService.findAll();
    }

    protected void optionClicked() {
        optionDanhMucFrame.setVisible(!optionDanhMucFrame.isVisible());
    }
}
