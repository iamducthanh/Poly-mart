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

import com.polymart.ui.common.uiCommon;
import com.toedter.calendar.JDateChooser;

public class ThanhToanJInternalFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7230782299903914961L;
	private JPanel contentPane;
	JPanel panel = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel hangHoaJPanel = new JPanel();
	
	private JTextField txtTimPhieuNhap;
	JFrame optionKiemKhoFrame = new JFrame();
	private JPanel panelOption;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	
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
	JPanel contentNhaPanel;




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
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
	//	initTopNhapHang();
	//	initCenterNhapHang();
	//	initFrameThem();
	}
	
	public void initTopThanhToan() {
		JLabel lblNewLabel = new JLabel("Hóa đơn thanh toán         ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNewLabel, BorderLayout.WEST);
		
		txtTimPhieuNhap = new JTextField();
		txtTimPhieuNhap.setText(" TÌm theo mã phiếu nhập");
		panel.add(txtTimPhieuNhap, BorderLayout.CENTER);
		txtTimPhieuNhap.setColumns(10);
		txtTimPhieuNhap.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTimPhieuNhap.getText().equals(" TÌm theo mã phiếu")) {
					txtTimPhieuNhap.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTimPhieuNhap.getText().equals("")) {
					txtTimPhieuNhap.setText(" TÌm theo mã phiếu");
				}
			}
		});
		JLabel lblNewLabel_1 = new JLabel(String.format("%60s", " "));
		panel1.add(lblNewLabel_1);
		
		JButton btnThemPhieuNhap = new JButton("+ Thêm mới ");
		panel1.add(btnThemPhieuNhap);
		JButton btnExport = new JButton("→ Xuất file ");
		panel1.add(btnExport);

		optionKiemKhoFrame.setSize(344, 234);
		optionKiemKhoFrame.setLocation(uiCommon.width - 360, uiCommon.height - (uiCommon.height/100*86));
		panelOption = new JPanel();
		panelOption.setLayout(null);
		panelOption.setBackground(Color.white) ;
		panelOption.setBorder(new EmptyBorder(0, 0, 5, 5));
		
		optionKiemKhoFrame.getContentPane().add(panelOption);
		optionKiemKhoFrame.setUndecorated(true);

		JComboBox<String> cbbOptionKiemKho = new JComboBox<String>();
		cbbOptionKiemKho.addItem("≡");
		panel1.add(cbbOptionKiemKho);

		btnThemPhieuNhap.addActionListener(openThemPhieuNhapHang);
		
	}
	
	public void initCenterThanhToan() {
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		JLabel lblNewLabel_9 = new JLabel("Thời gian");
		
		JDateChooser dateChooser = new JDateChooser();
		
		JButton btnLocTheoNgay = new JButton("Lọc");
		GroupLayout gl_hangHoaJPanel = new GroupLayout(hangHoaJPanel);
		gl_hangHoaJPanel.setHorizontalGroup(
			gl_hangHoaJPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_hangHoaJPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_hangHoaJPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLocTheoNgay)
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_hangHoaJPanel.setVerticalGroup(
			gl_hangHoaJPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_hangHoaJPanel.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_9)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnLocTheoNgay)
					.addContainerGap(141, Short.MAX_VALUE))
		);
		
		hangHoaJPanel.setLayout(gl_hangHoaJPanel);
		panel.add(panel1, BorderLayout.EAST);
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		table = new JTable();
		scrollPane.setViewportView(table);
		model.addColumn("Mã phiếu");
		model.addColumn("Ngày tạo");
		model.addColumn("Mã khách hàng");
		model.addColumn("Mã nhân viên");
		model.addColumn("Địa điểm");
		model.addColumn("Ngày thanh toán");
		model.addColumn("Ghi chú");
		model.addColumn("Số lượng");
		model.addColumn("Giảm giá");
		model.addColumn("Tổng tiền");
		model.addColumn("Trạng thái");

		table.setModel(model);

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
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin phi\u1EBFu nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
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

	ActionListener openThemPhieuNhapHang = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			initFrameThem();
			
		}
	};
}
