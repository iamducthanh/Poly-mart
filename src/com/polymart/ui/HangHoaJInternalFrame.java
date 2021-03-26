package com.polymart.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class HangHoaJInternalFrame extends JInternalFrame {

	private static final long serialVersionUID = 7158581259856675232L;

	private JPanel contentPane;
	private JPanel panelOption;
	private JTextField txtTimKiem;
	private JTextField txtTimNhomHang;
	private JTextField txtTimKiemKho;
	JPanel panel = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel hangHoaJPanel = new JPanel();
	JPanel setGiaPanel = new JPanel();
	JFrame optionSetGiaFrame = new JFrame();
	JFrame optionDanhMucFrame = new JFrame();
	JFrame optionKiemKhoFrame = new JFrame();


	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	int width = (int) dimension.getWidth();
	int height = (int) dimension.getHeight();
	
	JCheckBox chkHinhAnh = new JCheckBox("Hình ảnh");
	JCheckBox chkMaHang = new JCheckBox("Mã hàng");
	JCheckBox chkMaVach = new JCheckBox("Mã vạch");
	JCheckBox chkTenHang = new JCheckBox("Tên hàng");
	JCheckBox chkNhomHang = new JCheckBox("Nhóm hàng");
	JCheckBox chkLoaiHang = new JCheckBox("Loại hàng");
	JCheckBox chkLKKenhBan = new JCheckBox("Liên kết kênh bán");
	JCheckBox chkGiaBan = new JCheckBox("Giá bán");
	JCheckBox chkGiaVon = new JCheckBox("Giá vốn");
	JCheckBox chkDMNhieuNhat = new JCheckBox("Định mức tồn nhiều nhất");
	JCheckBox chkDMItNhat = new JCheckBox("Định mức tồn ít nhất");
	JCheckBox chkDuKienHH = new JCheckBox("Dự kiến kết hàng");
	JCheckBox chkKhachHangDat = new JCheckBox("Khách hàng đặt");
	JCheckBox chkViTri = new JCheckBox("Vị trí");
	JCheckBox chkTonKho = new JCheckBox("Tồn kho");
	JCheckBox chkThuongHieu = new JCheckBox("Thương hiệu");
	JCheckBox chkTrangThai = new JCheckBox("Trạng thái");
	
	JCheckBox chkSetGiaMaHang = new JCheckBox("Mã hàng");
	JCheckBox chkSetGiaTenHang = new JCheckBox("Tên hàng");
	JCheckBox chkSetGiaGiaVon = new JCheckBox("Giá vốn");
	JCheckBox chkSetGiaGiaNhapCuoi = new JCheckBox("Giá nhập cuối");
	
	JCheckBox chkPhieuTam = new JCheckBox("Phiếu tạm");
	JCheckBox chkCanBangKho = new JCheckBox("Đã cân bằng kho");
	JCheckBox chkDaHuy = new JCheckBox("Đã hủy");
	
	JCheckBox chkMaKiemKho = new JCheckBox("Mã kiểm kho");
	JCheckBox chkThoiGian = new JCheckBox("Thời gian");
	JCheckBox chkNguoiTao = new JCheckBox("Người tạo");
	JCheckBox chkNguoiCanBang = new JCheckBox("Nguời cân bằng");
	JCheckBox chkNgayCanBang = new JCheckBox("Ngày cân bằng");
	JCheckBox chkSLThucTe = new JCheckBox("Số lượng thực tế");
	JCheckBox chkTongThucTe = new JCheckBox("Tổng thực tế");
	JCheckBox chkTongChenhLech = new JCheckBox("Tổng chênh lệch");
	JCheckBox chkTongGiaTriLech = new JCheckBox("Tổng giá trị lệch");
	JCheckBox chkSLLechTang = new JCheckBox("Số lượng lệch tăng");
	JCheckBox chkTongGiaTriTang = new JCheckBox("Tổng giá trị tăng");
	JCheckBox chkSLLechGiam = new JCheckBox("Số lượng lệch giảm");
	JCheckBox chkTongGiaTriGiam = new JCheckBox("Tổng giá trị giảm");
	JCheckBox chkGhiChu = new JCheckBox("Ghi chú");
	JCheckBox chkTrangThaiKK = new JCheckBox("Trạng thái");

	/**
	 * 
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hàng hóa - Danh mục");
	//	setBounds(100, 100, 1920, 639);
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

	//	setExtendedState(JFrame.MAXIMIZED_BOTH);

//		initTopDanhMuc();
//		initCenterDanhMuc();
	//	initTopThietLapGia();
	//	initCenterThietLapGia();
//		initTopKiemKho();
//		initCenterKiemKho();

	}

	public void initTopDanhMuc() {

		JLabel lblNewLabel = new JLabel("Hàng hóa                       ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNewLabel, BorderLayout.WEST);

		txtTimKiem = new JTextField();
		txtTimKiem.setText(" TÌm theo mã, tên hàng");
		panel.add(txtTimKiem, BorderLayout.CENTER);
		txtTimKiem.setColumns(10);
		txtTimKiem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTimKiem.getText().equals(" TÌm theo mã, tên hàng")) {
					txtTimKiem.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTimKiem.getText().equals("")) {
					txtTimKiem.setText(" TÌm theo mã, tên hàng");
				}
			}
		});

		JLabel lblNewLabel_1 = new JLabel("                                     ");
		panel1.add(lblNewLabel_1);

		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "Thêm mới", "Thêm hàng hóa", "Thêm dịch vụ", "Thêm combo - đóng gói" }));
		panel1.add(comboBox);

		JButton btnImport = new JButton("Import");
		panel1.add(btnImport);

		JButton btnNewButton_1 = new JButton("Export");
		panel1.add(btnNewButton_1);
		
		optionDanhMucFrame.setSize(344, 264);
		optionDanhMucFrame.setLocation(width - 360, height - (height/100*86));
		panelOption = new JPanel();
		panelOption.setLayout(null);
		panelOption.setBackground(Color.white) ;
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
		
		optionDanhMucFrame.add(panelOption);
		optionDanhMucFrame.setUndecorated(true);

		JComboBox<String> optionDanhMuc = new JComboBox<String>();
		optionDanhMuc.addItem("≡");
		panel1.add(optionDanhMuc);
		optionDanhMuc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				optionDanhMucFrame.setVisible(true);
			}
		});
		
		optionDanhMuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				optionDanhMucFrame.setVisible(true);

			}
		});
		
		optionDanhMucFrame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				optionDanhMucFrame.setVisible(false);

			}
		});
		
	}

	public void initCenterDanhMuc() {
		hangHoaJPanel.setLayout(new BoxLayout(hangHoaJPanel, BoxLayout.Y_AXIS));
		JLabel lblNewLabel_2 = new JLabel("Loại hàng             ▼");
		lblNewLabel_2.setFont(new Font("Consolas", Font.BOLD, 14));
		lblNewLabel_2.setVisible(false);
		JLabel lblNewLabel_2t1 = new JLabel("Loại hàng             ▲");
		lblNewLabel_2t1.setFont(new Font("Consolas", Font.BOLD, 14));
		hangHoaJPanel.add(lblNewLabel_2);
		hangHoaJPanel.add(lblNewLabel_2t1);

		JPanel panel_1 = new JPanel();
		panel_1.setVisible(false);
		hangHoaJPanel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		JCheckBox checkBox1 = new JCheckBox("Hàng hóa");
		panel_1.add(checkBox1);
		JCheckBox checkBox2 = new JCheckBox("Dịch vụ");
		panel_1.add(checkBox2);
		JCheckBox checkBox3 = new JCheckBox("Combo - đóng gói              ");
		panel_1.add(checkBox3);

		JLabel lblNewLabel_3 = new JLabel("Tồn kho               ▼");
		lblNewLabel_3.setFont(new Font("Consolas", Font.BOLD, 14));
		lblNewLabel_3.setVisible(false);
		JLabel lblNewLabel_3t1 = new JLabel("Tồn kho               ▲");
		lblNewLabel_3t1.setFont(new Font("Consolas", Font.BOLD, 14));
		hangHoaJPanel.add(lblNewLabel_3);
		hangHoaJPanel.add(lblNewLabel_3t1);

		JPanel panel_2 = new JPanel();
		panel_2.setVisible(false);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		hangHoaJPanel.add(panel_2);

		JRadioButton radio1 = new JRadioButton("Tất cả");
		JRadioButton radio2 = new JRadioButton("Dưới định mức tồn");
		JRadioButton radio3 = new JRadioButton("Vượi định mức tồn");
		JRadioButton radio4 = new JRadioButton("Còn hàng trong kho");
		JRadioButton radio5 = new JRadioButton("Hết hàng trong kho            ");
		panel_2.add(radio1);
		panel_2.add(radio2);
		panel_2.add(radio3);
		panel_2.add(radio4);
		panel_2.add(radio5);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(radio1);
		buttonGroup.add(radio2);
		buttonGroup.add(radio3);
		buttonGroup.add(radio4);
		buttonGroup.add(radio5);

		JLabel lblNewLabel_5 = new JLabel("Bán trực tiếp         ▼   ");
		lblNewLabel_5.setFont(new Font("Consolas", Font.BOLD, 14));
		lblNewLabel_5.setVisible(false);
		JLabel lblNewLabel_5t1 = new JLabel("Bán trực tiếp         ▲   ");
		lblNewLabel_5t1.setFont(new Font("Consolas", Font.BOLD, 14));
		hangHoaJPanel.add(lblNewLabel_5);
		hangHoaJPanel.add(lblNewLabel_5t1);

		JPanel panel_3 = new JPanel();
		panel_3.setVisible(false);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		hangHoaJPanel.add(panel_3);

		JRadioButton radio6 = new JRadioButton("Tất cả");
		JRadioButton radio7 = new JRadioButton("Được bán trực tiếp");
		JRadioButton radio8 = new JRadioButton("Không được bán trực tiếp");
		panel_3.add(radio6);
		panel_3.add(radio7);
		panel_3.add(radio8);

		ButtonGroup buttonGroup2 = new ButtonGroup();
		buttonGroup2.add(radio6);
		buttonGroup2.add(radio7);
		buttonGroup2.add(radio8);

		JLabel lblNewLabel_6 = new JLabel("Ngày dự kiến hết hàng ▼");
		lblNewLabel_6.setFont(new Font("Consolas", Font.BOLD, 14));
		lblNewLabel_6.setVisible(false);
		JLabel lblNewLabel_6t1 = new JLabel("Ngày dự kiến hết hàng ▲");
		lblNewLabel_6t1.setFont(new Font("Consolas", Font.BOLD, 14));
		hangHoaJPanel.add(lblNewLabel_6);
		hangHoaJPanel.add(lblNewLabel_6t1);

		JPanel panel_4 = new JPanel();
		panel_4.setVisible(false);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		hangHoaJPanel.add(panel_4);

		JRadioButton radio9 = new JRadioButton("Toàn thời gian                    ");
		JRadioButton radio10 = new JRadioButton("Lựa chọn khác");
		panel_4.add(radio9);
		panel_4.add(radio10);

		ButtonGroup buttonGroup3 = new ButtonGroup();
		buttonGroup3.add(radio9);
		buttonGroup3.add(radio10);

		JLabel lblNewLabel_7 = new JLabel("Liên kết kênh bán     ▼");
		lblNewLabel_7.setFont(new Font("Consolas", Font.BOLD, 14));
		lblNewLabel_7.setVisible(false);
		JLabel lblNewLabel_7t1 = new JLabel("Liên kết kênh bán     ▲");
		lblNewLabel_7t1.setFont(new Font("Consolas", Font.BOLD, 14));
		hangHoaJPanel.add(lblNewLabel_7);
		hangHoaJPanel.add(lblNewLabel_7t1);

		JPanel panel_5 = new JPanel();
		panel_5.setVisible(false);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		hangHoaJPanel.add(panel_5);

		JRadioButton radio11 = new JRadioButton("Tất cả");
		JRadioButton radio12 = new JRadioButton("Có liên kết kênh bán");
		JRadioButton radio13 = new JRadioButton("Không liên kết kênh bán  ");
		panel_5.add(radio11);
		panel_5.add(radio12);
		panel_5.add(radio13);

		ButtonGroup buttonGroup4 = new ButtonGroup();
		buttonGroup4.add(radio11);
		buttonGroup4.add(radio12);
		buttonGroup4.add(radio13);

		JLabel lblNewLabel_8 = new JLabel("Lựa chọn hiển thị     ▼");
		lblNewLabel_8.setFont(new Font("Consolas", Font.BOLD, 14));
		lblNewLabel_8.setVisible(false);
		JLabel lblNewLabel_8t1 = new JLabel("Lựa chọn hiển thị     ▲");
		lblNewLabel_8t1.setFont(new Font("Consolas", Font.BOLD, 14));
		hangHoaJPanel.add(lblNewLabel_8);
		hangHoaJPanel.add(lblNewLabel_8t1);

		JPanel panel_6 = new JPanel();
		panel_6.setVisible(false);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));
		hangHoaJPanel.add(panel_6);

		JRadioButton radio14 = new JRadioButton("Tất cả");
		JRadioButton radio15 = new JRadioButton("Hàng đang kinh doanh");
		JRadioButton radio16 = new JRadioButton("Hàng ngừng kinh doanh   ");
		panel_6.add(radio14);
		panel_6.add(radio15);
		panel_6.add(radio16);

		ButtonGroup buttonGroup5 = new ButtonGroup();
		buttonGroup5.add(radio14);
		buttonGroup5.add(radio15);
		buttonGroup5.add(radio16);

		lblNewLabel_2t1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_2t1.setVisible(false);
				lblNewLabel_2.setVisible(true);
				panel_1.setVisible(true);
			}
		});

		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_2.setVisible(false);
				lblNewLabel_2t1.setVisible(true);
				panel_1.setVisible(false);
			}
		});

		lblNewLabel_3t1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_3t1.setVisible(false);
				lblNewLabel_3.setVisible(true);
				panel_2.setVisible(true);

			}
		});

		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_3.setVisible(false);
				lblNewLabel_3t1.setVisible(true);
				panel_2.setVisible(false);

			}
		});

		lblNewLabel_5t1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_5t1.setVisible(false);
				lblNewLabel_5.setVisible(true);
				panel_3.setVisible(true);

			}
		});

		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_5.setVisible(false);
				lblNewLabel_5t1.setVisible(true);
				panel_3.setVisible(false);

			}
		});

		lblNewLabel_6t1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_6t1.setVisible(false);
				lblNewLabel_6.setVisible(true);
				panel_4.setVisible(true);

			}
		});

		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_6.setVisible(false);
				lblNewLabel_6t1.setVisible(true);
				panel_4.setVisible(false);

			}
		});

		lblNewLabel_7t1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_7t1.setVisible(false);
				lblNewLabel_7.setVisible(true);
				panel_5.setVisible(true);

			}
		});

		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_7.setVisible(false);
				lblNewLabel_7t1.setVisible(true);
				panel_5.setVisible(false); 

			}
		});

		lblNewLabel_8t1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_8t1.setVisible(false);
				lblNewLabel_8.setVisible(true);
				panel_6.setVisible(true);

			}
		});

		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_8.setVisible(false);
				lblNewLabel_8t1.setVisible(true);
				panel_6.setVisible(false);

			}
		});

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);
		model.addColumn("☐");
		model.addColumn("Mã hàng");
		model.addColumn("Tên hàng");
		model.addColumn("GIá bán");
		model.addColumn("Giá vốn");
		model.addColumn("Tồn kho");
		model.addColumn("KH đặt hàng");
		model.addColumn("Dự kiếm hết hàng");
		table.setModel(model);

		// table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(350);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		table.getColumnModel().getColumn(5).setPreferredWidth(120);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(130);

	}

	public void initTopThietLapGia() {
		JLabel lblNewLabel = new JLabel("Bảng giá chung                       ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNewLabel, BorderLayout.WEST);

		JButton btnImport = new JButton("Xuất file ");
		btnImport.setIcon(new ImageIcon("C:\\images\\export.png"));
		panel1.add(btnImport);

		JComboBox cbbOptionSetGia = new JComboBox();
		cbbOptionSetGia.addItem("≡");
		panel1.add(cbbOptionSetGia);
		
		optionSetGiaFrame.setSize(150, 140);
		optionSetGiaFrame.setLocation(width - 160, height - (height/100*86));
		panelOption = new JPanel();
		panelOption.setLayout(null);
		panelOption.setBackground(Color.white) ;
		panelOption.setBorder(new EmptyBorder(0, 0, 5, 5));
		optionSetGiaFrame.add(panelOption);
		optionSetGiaFrame.setUndecorated(true);
		uiCommon uiCommon = new uiCommon(panelOption);
		
		uiCommon.addCheckBox(chkSetGiaMaHang, 15, 12, 99);
		uiCommon.addCheckBox(chkSetGiaTenHang, 15, 43, 99);
		uiCommon.addCheckBox(chkSetGiaGiaVon, 15, 69, 99);
		uiCommon.addCheckBox(chkSetGiaGiaNhapCuoi, 15, 95, 140);

		
		cbbOptionSetGia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				optionSetGiaFrame.setVisible(true);
			}
		});
		
		cbbOptionSetGia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				optionSetGiaFrame.setVisible(true);

			}
		});
		
		optionSetGiaFrame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				optionSetGiaFrame.setVisible(false);

			}
		});
	}
	
	public void initCenterThietLapGia() {
		setGiaPanel.setLayout(new BoxLayout(setGiaPanel, BoxLayout.Y_AXIS));
		JLabel lblNewLabel_2 = new JLabel("Loại hàng             ▼");
		lblNewLabel_2.setFont(new Font("Consolas", Font.BOLD, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
        JLabel lblNewLabel_4 = new JLabel("Bảng giá");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bảng giá chung"}));
		
		JLabel lblNewLabel_4_1 = new JLabel("Nhóm hàng");
		
		txtTimNhomHang = new JTextField();
		txtTimNhomHang.setText("Tìm kiếm nhóm hàng");
		txtTimNhomHang.setColumns(10);
		GroupLayout gl_hangHoaJPanel = new GroupLayout(hangHoaJPanel);
		gl_hangHoaJPanel.setHorizontalGroup(
			gl_hangHoaJPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_hangHoaJPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_hangHoaJPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(comboBox, 0, 150, Short.MAX_VALUE)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTimNhomHang))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_hangHoaJPanel.setVerticalGroup(
			gl_hangHoaJPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_hangHoaJPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_4_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtTimNhomHang, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)

					.addContainerGap(112, Short.MAX_VALUE))
		);
		hangHoaJPanel.setLayout(gl_hangHoaJPanel);
		panel.add(panel1, BorderLayout.EAST);
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		txtTimNhomHang.setBorder(null);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model.addColumn("Mã hàng");
		model.addColumn("Tên hàng");
		model.addColumn("Giá vốn");
		model.addColumn("Giá nhập cuối");
		model.addColumn("Giá chung");
		table.setModel(model);
	}

	public void initTopKiemKho() {
		JLabel lblNewLabel = new JLabel("Phiếu kiểm kho                       ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNewLabel, BorderLayout.WEST);
		
		txtTimKiemKho = new JTextField();
		txtTimKiemKho.setText(" TÌm theo mã phiếu kiểm");
		panel.add(txtTimKiemKho, BorderLayout.CENTER);
		txtTimKiemKho.setColumns(10);
		txtTimKiemKho.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTimKiemKho.getText().equals(" TÌm theo mã phiếu kiểm")) {
					txtTimKiemKho.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTimKiemKho.getText().equals("")) {
					txtTimKiemKho.setText(" TÌm theo mã phiếu kiểm");
				}
			}
		});
		JLabel lblNewLabel_1 = new JLabel(String.format("%60s", " "));
		panel1.add(lblNewLabel_1);
		
		JButton btnKiemKho = new JButton("+ Kiểm kho ");
		panel1.add(btnKiemKho);
		JButton btnImport = new JButton("→ Xuất file ");
		panel1.add(btnImport);

		optionKiemKhoFrame.setSize(344, 234);
		optionKiemKhoFrame.setLocation(width - 360, height - (height/100*86));
		panelOption = new JPanel();
		panelOption.setLayout(null);
		panelOption.setBackground(Color.white) ;
		panelOption.setBorder(new EmptyBorder(0, 0, 5, 5));
		uiCommon uiCommon = new uiCommon(panelOption);
		
		uiCommon.addCheckBox(chkMaKiemKho, 10, 7, 150);
		uiCommon.addCheckBox(chkThoiGian, 10, 33, 150);
		uiCommon.addCheckBox(chkNguoiTao, 10, 59, 150);
		uiCommon.addCheckBox(chkNguoiCanBang, 10, 85, 150);
		uiCommon.addCheckBox(chkNgayCanBang, 10, 111, 150);
		
		uiCommon.addCheckBox(chkSLThucTe, 10, 137, 150);
		uiCommon.addCheckBox(chkTongThucTe, 10, 163, 150);
		uiCommon.addCheckBox(chkTongChenhLech, 10, 189, 150);
		
		uiCommon.addCheckBox(chkTongGiaTriLech, 160, 7, 178);
		uiCommon.addCheckBox(chkSLLechTang, 160, 163, 178);
		uiCommon.addCheckBox(chkTongGiaTriTang, 160, 137, 178);
		uiCommon.addCheckBox(chkSLLechGiam, 160, 111, 178);
		uiCommon.addCheckBox(chkTongGiaTriGiam, 160, 85, 178);
		uiCommon.addCheckBox(chkGhiChu, 160, 59, 99);
		uiCommon.addCheckBox(chkTrangThaiKK, 160, 33, 99);

		
		optionKiemKhoFrame.add(panelOption);
		optionKiemKhoFrame.setUndecorated(true);

		JComboBox<String> cbbOptionKiemKho = new JComboBox<String>();
		cbbOptionKiemKho.addItem("≡");
		panel1.add(cbbOptionKiemKho);
		cbbOptionKiemKho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				optionKiemKhoFrame.setVisible(true);
			}
		});
		
		cbbOptionKiemKho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				optionKiemKhoFrame.setVisible(true);

			}
		});
		
		optionKiemKhoFrame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				optionKiemKhoFrame.setVisible(false);

			}
		});
		
	}

	public void initCenterKiemKho() {
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		JLabel lblNewLabel_9 = new JLabel("Thời gian");
		
		JDateChooser dateChooser = new JDateChooser();
		
		JLabel lblNewLabel_10 = new JLabel("Trạng thái                                   ▼");		
		JPanel left = new JPanel();
		GroupLayout gl_hangHoaJPanel = new GroupLayout(hangHoaJPanel);
		gl_hangHoaJPanel.setHorizontalGroup(
			gl_hangHoaJPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_hangHoaJPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_hangHoaJPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(left, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
						.addComponent(dateChooser, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_9, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_10, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 177, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_hangHoaJPanel.setVerticalGroup(
			gl_hangHoaJPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_hangHoaJPanel.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_9)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_10)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(left, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		left.setLayout(null);
		
		chkPhieuTam.setBounds(6, 7, 99, 23);
		left.add(chkPhieuTam);
		
		chkCanBangKho.setBounds(6, 33, 139, 23);
		left.add(chkCanBangKho);
		
		chkDaHuy.setBounds(6, 59, 99, 23);
		left.add(chkDaHuy);
		hangHoaJPanel.setLayout(gl_hangHoaJPanel);
		panel.add(panel1, BorderLayout.EAST);
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		table = new JTable();
		scrollPane.setViewportView(table);
		model.addColumn("☐");
		model.addColumn("Mã kiểm kho");
		model.addColumn("Thời gian");
		model.addColumn("Ngày cân bằng");
		model.addColumn("SL thực tế");
		model.addColumn("Tổng thực tế");
		model.addColumn("Tổng chênh lệch");
		model.addColumn("Số lượng lệch tăng");
		model.addColumn("Số lượng lệch giảm");
		model.addColumn("Ghi chú");
		table.setModel(model);

		// table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		table.getColumnModel().getColumn(5).setPreferredWidth(120);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(130);
		table.getColumnModel().getColumn(8).setPreferredWidth(130);
		table.getColumnModel().getColumn(9).setPreferredWidth(130);
	}


}
