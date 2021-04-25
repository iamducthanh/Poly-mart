package com.polymart.ui.hanghoa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.polymart.entity.EntityExcel;
import com.polymart.entity.EntityMessage;
import com.polymart.entity.EntityValidate;
import com.polymart.model.ChiTietSanPhamModel;
import com.polymart.model.LoaiSanPhamModel;
import com.polymart.model.SanPhamModel;
import com.polymart.service.IChiTietSanPhamService;
import com.polymart.service.ILoaiSanPhamService;
import com.polymart.service.ISanPhamService;
import com.polymart.service.impl.ChiTietSanPhamService;
import com.polymart.service.impl.LoaiSanPhamService;
import com.polymart.service.impl.SanPhamService;
import com.polymart.ui.MainFrame;
import com.polymart.ui.common.RoundedBorder;
import com.polymart.ui.common.uiCommon;

public class HangHoaJInternalFrame extends JInternalFrame {

	private static final long serialVersionUID = 7158581259856675232L;

	private JPanel contentPane;
	private JPanel panelOption;
	private JTable tblHangHoa;
	private DefaultTableModel modelHangHoa;
	private String columnHangHoa[] = { "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá bán", "Giá vốn", "Giảm giá",
			"Size", "Màu sắc" };

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
	JRadioButton rdoHetHangTrongKho = new JRadioButton("Hết hàng trong kho            ");
	private JCheckBox chkDMItNhat = new JCheckBox("Định mức tồn ít nhất");
	private JCheckBox chkDuKienHH = new JCheckBox("Dự kiến kết hàng");
	private JCheckBox chkKhachHangDat = new JCheckBox("Khách hàng đặt");
	private JCheckBox chkViTri = new JCheckBox("Vị trí");
	private JCheckBox chkTonKho = new JCheckBox("Tồn kho");
	private JCheckBox chkThuongHieu = new JCheckBox("Thương hiệu");
	private JCheckBox chkTrangThai = new JCheckBox("Trạng thái");
	JRadioButton rdoVuotDinhMucTon = new JRadioButton("Vượi định mức tồn");
	JRadioButton rdoDuoiDinhMucTon = new JRadioButton("Dưới định mức tồn");
	JRadioButton rdoTonKhoTatCa = new JRadioButton("Tất cả");
	JRadioButton rdoConHangTrongKho = new JRadioButton("Còn hàng trong kho");
	JComboBox<String> cboLoaiSanPham = new JComboBox<String>();

	// service
	private ISanPhamService sanPhamService = new SanPhamService();
	private IChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamService();
	private ILoaiSanPhamService loaiSanPhamService = new LoaiSanPhamService();
	private List<LoaiSanPhamModel> lstLoaiSanPham = loaiSanPhamService.findAll();

	// lisst
	private List<ChiTietSanPhamModel> lstChiTietSanPhamModels;
	private List<ChiTietSanPhamModel> listSanPhamLoc = new ArrayList<ChiTietSanPhamModel>();

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
		contentPane.setBackground(new Color(75, 0, 130));
		pnlNavibar = new JPanel();
		pnlNavibar.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		pnlTop.setBackground(Color.WHITE);
		contentPane.add(pnlTop, BorderLayout.NORTH);
		pnlTop.setBounds(68, 120, 96, 20);

		contentPane.add(pnlNavibar, BorderLayout.WEST);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(75, 0, 130));
		GroupLayout gl_pnlTop = new GroupLayout(pnlTop);
		gl_pnlTop.setHorizontalGroup(gl_pnlTop.createParallelGroup(Alignment.LEADING).addComponent(panel,
				Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1185, Short.MAX_VALUE));
		gl_pnlTop.setVerticalGroup(gl_pnlTop.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlTop.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		// btnTimKiem.setIcon(new
		// ImageIcon(EntityImage.resizeTheoUrl("images\\search.png", 20, 20)));
		JButton btnExport = new JButton("Export");
		btnExport.setBackground(new Color(75, 0, 130));
		btnExport.setForeground(new Color(255, 255, 255));
		btnExport.setBorder(new RoundedBorder(10));
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					EntityExcel.exportExcel(tblHangHoa);
					JOptionPane.showMessageDialog(null, "Lưu thành công");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Lưu thất bại");
				}
			}
		});

		// btnExport.setIcon(new
		// ImageIcon(EntityImage.resizeTheoUrl("images\\export.png", 20, 20)));
		JButton btnThemHang = new JButton("Thêm mới");
		uiCommon.editButtonTop(btnThemHang);
		btnThemHang.addActionListener(themSanPham);
		JButton btnTimKiem = new JButton("Tìm kiếm");
		// tìm kiếm
		btnTimKiem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				evtBtnTimKiem(txtFind);
			}
		});
		txtFind = new JTextField();
		txtFind.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFind.setText(" Tìm theo mã, tên hàng");
		txtFind.setColumns(10);

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
		JLabel lblTitle = new JLabel("Hàng hóa");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(txtFind, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
					.addComponent(btnThemHang, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExport, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblTitle)
							.addComponent(txtFind, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnExport, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnThemHang, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		panel.setLayout(gl_panel);
		pnlTop.setLayout(gl_pnlTop);

		initTopHangHoa();
		initCenterHangHoa();
		loadLoaiSanPham();
		
		uiCommon.editButtonTop(btnThemHang);
		uiCommon.editButtonTop(btnExport);
		uiCommon.editButtonTop(btnTimKiem);

	}

	public void initTopHangHoa() {
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
		pnlLoaiHang.setBackground(Color.WHITE);
		pnlLoaiHang.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(160, 160, 160)),
				" Lo\u1EA1i H\u00E0ng ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		cboLoaiSanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				locSanPham();
			}
		});

		JPanel pnlTonKho = new JPanel();
		pnlTonKho.setBackground(Color.WHITE);
		pnlTonKho.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(160, 160, 160)),
				" T\u1ED3n kho ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		rdoTonKhoTatCa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				locSanPham();
			}
		});
		rdoTonKhoTatCa.setSelected(true);
		rdoTonKhoTatCa.setBackground(Color.WHITE);
		rdoTonKhoTatCa.setFont(new Font("SansSerif", Font.PLAIN, 14));

		rdoDuoiDinhMucTon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				locSanPham();
			}
		});
		rdoDuoiDinhMucTon.setBackground(Color.WHITE);
		rdoDuoiDinhMucTon.setFont(new Font("SansSerif", Font.PLAIN, 14));

		rdoVuotDinhMucTon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				locSanPham();
			}
		});
		rdoVuotDinhMucTon.setBackground(Color.WHITE);
		rdoVuotDinhMucTon.setFont(new Font("SansSerif", Font.PLAIN, 14));

		rdoConHangTrongKho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				locSanPham();
			}
		});
		rdoConHangTrongKho.setBackground(Color.WHITE);
		rdoConHangTrongKho.setFont(new Font("SansSerif", Font.PLAIN, 14));

		rdoHetHangTrongKho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				locSanPham();
			}
		});
		rdoHetHangTrongKho.setBackground(Color.WHITE);
		rdoHetHangTrongKho.setFont(new Font("SansSerif", Font.PLAIN, 14));

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdoTonKhoTatCa);
		buttonGroup.add(rdoDuoiDinhMucTon);
		buttonGroup.add(rdoVuotDinhMucTon);
		buttonGroup.add(rdoConHangTrongKho);
		buttonGroup.add(rdoHetHangTrongKho);

		JPanel pnlBanTrucTiep = new JPanel();
		pnlBanTrucTiep.setBackground(Color.WHITE);
		pnlBanTrucTiep.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(160, 160, 160)),
				" B\u00E1n tr\u1EF1c ti\u1EBFp ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlBanTrucTiep.setLayout(new BoxLayout(pnlBanTrucTiep, BoxLayout.Y_AXIS));

		JRadioButton rdoBanTrucTiepTatCa = new JRadioButton("Tất cả");
		rdoBanTrucTiepTatCa.setBackground(Color.WHITE);
		rdoBanTrucTiepTatCa.setFont(new Font("SansSerif", Font.PLAIN, 14));
		JRadioButton rdoDuocBanTrucTiep = new JRadioButton("Được bán trực tiếp");
		rdoDuocBanTrucTiep.setBackground(Color.WHITE);
		rdoDuocBanTrucTiep.setFont(new Font("SansSerif", Font.PLAIN, 14));
		JRadioButton rdoKhongDuocBanTrucTiep = new JRadioButton("Không được bán trực tiếp");
		rdoKhongDuocBanTrucTiep.setBackground(Color.WHITE);
		rdoKhongDuocBanTrucTiep.setFont(new Font("SansSerif", Font.PLAIN, 14));
		pnlBanTrucTiep.add(rdoBanTrucTiepTatCa);
		pnlBanTrucTiep.add(rdoDuocBanTrucTiep);
		pnlBanTrucTiep.add(rdoKhongDuocBanTrucTiep);

		ButtonGroup buttonGroup2 = new ButtonGroup();
		buttonGroup2.add(rdoBanTrucTiepTatCa);
		buttonGroup2.add(rdoDuocBanTrucTiep);
		buttonGroup2.add(rdoKhongDuocBanTrucTiep);

		JPanel pnlNgayDuKienHetHang = new JPanel();
		pnlNgayDuKienHetHang.setBackground(Color.WHITE);
		pnlNgayDuKienHetHang.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(160, 160, 160)),
				" Ng\u00E0y d\u1EF1 ki\u1EBFn h\u1EBFt h\u00E0ng ", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		pnlNgayDuKienHetHang.setLayout(new BoxLayout(pnlNgayDuKienHetHang, BoxLayout.Y_AXIS));

		JRadioButton rdoToanThoiGian = new JRadioButton("Toàn thời gian");
		rdoToanThoiGian.setBackground(Color.WHITE);
		rdoToanThoiGian.setFont(new Font("SansSerif", Font.PLAIN, 14));
		JRadioButton rdoLuaChonKhac = new JRadioButton("Lựa chọn khác");
		rdoLuaChonKhac.setBackground(Color.WHITE);
		rdoLuaChonKhac.setFont(new Font("SansSerif", Font.PLAIN, 14));
		pnlNgayDuKienHetHang.add(rdoToanThoiGian);
		pnlNgayDuKienHetHang.add(rdoLuaChonKhac);

		ButtonGroup buttonGroup3 = new ButtonGroup();
		buttonGroup3.add(rdoToanThoiGian);
		buttonGroup3.add(rdoLuaChonKhac);

		JPanel pnlLienKetBanHang = new JPanel();
		pnlLienKetBanHang.setBackground(Color.WHITE);
		pnlLienKetBanHang.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(160, 160, 160)),
				" Li\u00EAn k\u1EBFt b\u00E1n h\u00E0ng ", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		pnlLienKetBanHang.setLayout(new BoxLayout(pnlLienKetBanHang, BoxLayout.Y_AXIS));

		JRadioButton rdoLienKetBanHangTatCa = new JRadioButton("Tất cả");
		rdoLienKetBanHangTatCa.setBackground(Color.WHITE);
		rdoLienKetBanHangTatCa.setFont(new Font("SansSerif", Font.PLAIN, 14));
		JRadioButton rdoCoLienKetKenhBan = new JRadioButton("Có liên kết kênh bán");
		rdoCoLienKetKenhBan.setBackground(Color.WHITE);
		rdoCoLienKetKenhBan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		JRadioButton rdoKhongLienKetKenhBan = new JRadioButton("Không liên kết kênh bán  ");
		rdoKhongLienKetKenhBan.setBackground(Color.WHITE);
		rdoKhongLienKetKenhBan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		pnlLienKetBanHang.add(rdoLienKetBanHangTatCa);
		pnlLienKetBanHang.add(rdoCoLienKetKenhBan);
		pnlLienKetBanHang.add(rdoKhongLienKetKenhBan);

		ButtonGroup buttonGroup4 = new ButtonGroup();
		buttonGroup4.add(rdoLienKetBanHangTatCa);
		buttonGroup4.add(rdoCoLienKetKenhBan);
		buttonGroup4.add(rdoKhongLienKetKenhBan);

		JPanel pnlLuaChonHienThi = new JPanel();
		pnlLuaChonHienThi.setBackground(Color.WHITE);
		pnlLuaChonHienThi.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				" L\u1EF1a ch\u1ECDn hi\u1EC3n th\u1ECB ", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		pnlLuaChonHienThi.setLayout(new BoxLayout(pnlLuaChonHienThi, BoxLayout.Y_AXIS));

		JRadioButton rdoLuaChonHienThiTatCa = new JRadioButton("Tất cả");
		rdoLuaChonHienThiTatCa.setBackground(Color.WHITE);
		rdoLuaChonHienThiTatCa.setFont(new Font("SansSerif", Font.PLAIN, 14));
		JRadioButton rdoHangDangKinhDoanh = new JRadioButton("Hàng đang kinh doanh");
		rdoHangDangKinhDoanh.setBackground(Color.WHITE);
		rdoHangDangKinhDoanh.setFont(new Font("SansSerif", Font.PLAIN, 14));
		JRadioButton rdoHangNgungKinhDoanh = new JRadioButton("Hàng ngừng kinh doanh   ");
		rdoHangNgungKinhDoanh.setBackground(Color.WHITE);
		rdoHangNgungKinhDoanh.setFont(new Font("SansSerif", Font.PLAIN, 14));
		pnlLuaChonHienThi.add(rdoLuaChonHienThiTatCa);
		pnlLuaChonHienThi.add(rdoHangDangKinhDoanh);
		pnlLuaChonHienThi.add(rdoHangNgungKinhDoanh);

		ButtonGroup buttonGroup5 = new ButtonGroup();
		buttonGroup5.add(rdoLuaChonHienThiTatCa);
		buttonGroup5.add(rdoHangDangKinhDoanh);
		buttonGroup5.add(rdoHangNgungKinhDoanh);
		GroupLayout gl_pnlNavibar = new GroupLayout(pnlNavibar);
		gl_pnlNavibar.setHorizontalGroup(
			gl_pnlNavibar.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlNavibar.createSequentialGroup()
					.addGroup(gl_pnlNavibar.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlLoaiHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(pnlTonKho, GroupLayout.PREFERRED_SIZE, 202, Short.MAX_VALUE)
						.addComponent(pnlLienKetBanHang, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
						.addComponent(pnlLuaChonHienThi, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
						.addComponent(pnlNgayDuKienHetHang, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
						.addComponent(pnlBanTrucTiep, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
					.addGap(5))
		);
		gl_pnlNavibar.setVerticalGroup(
			gl_pnlNavibar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNavibar.createSequentialGroup()
					.addComponent(pnlLoaiHang, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addComponent(pnlTonKho, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(pnlBanTrucTiep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlNgayDuKienHetHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlLienKetBanHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(pnlLuaChonHienThi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);

		JLabel lblNewLabel = new JLabel("Định mức tồn");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtDinhMuc = new JTextField();
		txtDinhMuc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				checkDinhMuc();
			}
		});
		txtDinhMuc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDinhMuc.setText("10");
		txtDinhMuc.setColumns(10);
		GroupLayout gl_pnlTonKho = new GroupLayout(pnlTonKho);
		gl_pnlTonKho.setHorizontalGroup(gl_pnlTonKho.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlTonKho
				.createSequentialGroup()
				.addGroup(gl_pnlTonKho.createParallelGroup(Alignment.LEADING).addComponent(rdoTonKhoTatCa)

						.addComponent(rdoVuotDinhMucTon)
						.addComponent(rdoConHangTrongKho, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlTonKho.createSequentialGroup().addGap(1).addComponent(rdoDuoiDinhMucTon))
						.addGroup(gl_pnlTonKho.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING,
										gl_pnlTonKho.createSequentialGroup().addGap(7)
												.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 95,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(txtDinhMuc,
														GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
								.addComponent(rdoHetHangTrongKho, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 190,
										GroupLayout.PREFERRED_SIZE)))
				.addGap(15)));
		gl_pnlTonKho.setVerticalGroup(gl_pnlTonKho.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlTonKho.createSequentialGroup().addComponent(rdoTonKhoTatCa)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_pnlTonKho.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDinhMuc, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGap(3).addComponent(rdoDuoiDinhMucTon).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(rdoVuotDinhMucTon).addComponent(rdoConHangTrongKho)
						.addComponent(rdoHetHangTrongKho)));
		pnlTonKho.setLayout(gl_pnlTonKho);
		GroupLayout gl_pnlLoaiHang = new GroupLayout(pnlLoaiHang);
		gl_pnlLoaiHang.setHorizontalGroup(
			gl_pnlLoaiHang.createParallelGroup(Alignment.LEADING)
				.addComponent(cboLoaiSanPham, 0, 190, Short.MAX_VALUE)
		);
		gl_pnlLoaiHang.setVerticalGroup(
			gl_pnlLoaiHang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlLoaiHang.createSequentialGroup()
					.addComponent(cboLoaiSanPham, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(56, Short.MAX_VALUE))
		);
		pnlLoaiHang.setLayout(gl_pnlLoaiHang);
		pnlNavibar.setLayout(gl_pnlNavibar);

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
		tblHangHoa.setBackground(Color.WHITE);
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

		// click table
		tblHangHoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row = tblHangHoa.getSelectedRow();
				if (e.getClickCount() == 2 && row > -1 && row < tblHangHoa.getRowCount()) {
					clickTable(row);
				}
			}
		});
	}

	protected boolean checkDinhMuc() {
		if (txtDinhMuc.getText().isBlank()) {
			EntityMessage.show(null, "Định Mức Tồn Không Được Để Trống");
			return true;
		} else {
			try {
				Integer.parseInt(txtDinhMuc.getText());
			} catch (Exception e) {
				EntityMessage.show(null, "Bạn Nhập Sai! Nhập Lại Định Mức Tồn Là Kiểu Số");
				return true;
			}
		}
		return false;
	}

	ActionListener themSanPham = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			openThemHangHoa();
		}
	};

	private void openThemHangHoa() {
		ThemHangHoaJInternalFrame themHangHoaJInternalFrame = new ThemHangHoaJInternalFrame(this);
		MainFrame.pnlMain.add(themHangHoaJInternalFrame);
		themHangHoaJInternalFrame.setVisible(true);
	}

	private JTextField txtFind;
	private JTextField txtDinhMuc;

	private void clickTable(int row) {
		ChiTietSanPhamFrame chiTietSanPhamFrame = new ChiTietSanPhamFrame(lstChiTietSanPhamModels.get(row), this);
		chiTietSanPhamFrame.setVisible(true);
		chiTietSanPhamFrame.setLocationRelativeTo(null);
	}

	// Tìm kiếm sản phẩm
	private void evtBtnTimKiem(JTextField txtTimKiem) {
		String getTimKiem = txtTimKiem.getText();
		if (getTimKiem.equals("Tìm theo mã, tên hàng")) {
			showTable(getList());
		} else {
			lstChiTietSanPhamModels = chiTietSanPhamService.findByIdOrNameProduct(getTimKiem);
			if (lstChiTietSanPhamModels.isEmpty()) {
				showTable(getList());
				EntityMessage.show(this, "Mã hoặc tên sản phẩm không tồn tại");
			} else {
				showTable(lstChiTietSanPhamModels);
			}
		}
	}

	// showw sản phẩm lên bảng
	public void showTable(List<ChiTietSanPhamModel> lst) {
		modelHangHoa.setRowCount(0);
		if (lst.size() == 0) {
			return;
		}
		for (ChiTietSanPhamModel x : lst) {
			SanPhamModel sanPhamModel = sanPhamService.findByID(x.getIdSanPham());
			modelHangHoa.addRow(new Object[] { x.getId(), sanPhamModel.getTenSP(), x.getSoLuong(), EntityValidate.dinhDangMonney(x.getGiaBan()),
					EntityValidate.dinhDangMonney(x.getGiaVon()), EntityValidate.dinhDangMonney(x.getGiaGiam()), x.getSize(), x.getMauSac() });
		}

	}

	// getList
	public List<ChiTietSanPhamModel> getList() {
		return lstChiTietSanPhamModels = chiTietSanPhamService.findAll();
	}

	public void loadLoaiSanPham() {
		Vector<String> loaiSanPham = new Vector<String>();
		loaiSanPham.add("Tất Cả");
		for (LoaiSanPhamModel loaiSanPhamModel : lstLoaiSanPham) {
			loaiSanPham.add(loaiSanPhamModel.getTenLoaiSP());
		}
		cboLoaiSanPham.setModel(new DefaultComboBoxModel<String>(loaiSanPham));
	}
	// lọc sản phẩm trong kho 
	public void locSanPham() {
		if(checkDinhMuc()==true) {
			return;
		}
		String loaiSanPham = cboLoaiSanPham.getSelectedItem().toString();
		int index = cboLoaiSanPham.getSelectedIndex();
		List<ChiTietSanPhamModel> listSanPhamLocKho = new ArrayList<ChiTietSanPhamModel>();
		listSanPhamLocKho.clear();
		listSanPhamLoc.clear();
		if (loaiSanPham.equalsIgnoreCase("Tất Cả")) {
			listSanPhamLoc = chiTietSanPhamService.findAll();
		} else {
			for (ChiTietSanPhamModel sanPham : lstChiTietSanPhamModels) {
				SanPhamModel sanPhamModel = sanPhamService.findByID(sanPham.getIdSanPham());
				if (sanPhamModel.getIdLoaiSP().equals(lstLoaiSanPham.get(index-1).getId())) {
					listSanPhamLoc.add(sanPham);
				}
			}
		}
		if (rdoTonKhoTatCa.isSelected() == true) {
			for (ChiTietSanPhamModel chiTietSanPhamModel : listSanPhamLoc) {
				listSanPhamLocKho.add(chiTietSanPhamModel);
			}
		}
		if (rdoDuoiDinhMucTon.isSelected() == true) {
			for (ChiTietSanPhamModel chiTietSanPhamModel : listSanPhamLoc) {
				if (chiTietSanPhamModel.getSoLuong() < Integer.parseInt(txtDinhMuc.getText())) {
					listSanPhamLocKho.add(chiTietSanPhamModel);
				}
			}
		}
		if (rdoVuotDinhMucTon.isSelected() == true) {
			for (ChiTietSanPhamModel chiTietSanPhamModel : listSanPhamLoc) {
				if (chiTietSanPhamModel.getSoLuong() >= Integer.parseInt(txtDinhMuc.getText())) {
					listSanPhamLocKho.add(chiTietSanPhamModel);
				}
			}
		}
		if (rdoHetHangTrongKho.isSelected() == true) {
			for (ChiTietSanPhamModel chiTietSanPhamModel : listSanPhamLoc) {
				if (chiTietSanPhamModel.getSoLuong() == 0) {
					listSanPhamLocKho.add(chiTietSanPhamModel);
				}
			}
		}
		if (rdoConHangTrongKho.isSelected()) {
			for (ChiTietSanPhamModel chiTietSanPhamModel : listSanPhamLoc) {
				if (chiTietSanPhamModel.getSoLuong() > 0) {
					listSanPhamLocKho.add(chiTietSanPhamModel);
				}
			}
		}
		showTable(listSanPhamLocKho);
	}
}
