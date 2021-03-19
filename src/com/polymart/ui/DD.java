package com.polymart.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class DD extends JFrame {

	private static final long serialVersionUID = 7158581259856675232L;

	private JPanel optionSetGiaFrame;
	private JPanel panelOption;
	private JTextField txtTimKiem;
	JPanel panel = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel hangHoaJPanel = new JPanel();
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	int width = (int) dimension.getWidth();
	int height = (int) dimension.getHeight();
	JFrame optionDanhMucFrame = new JFrame();
	
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
	private JTextField txtTmKimNhm;

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
	public DD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hàng hóa - Danh mục");
	//	setBounds(100, 100, 1920, 639);
		setFocusable(true);
		optionSetGiaFrame = new JPanel();
		optionSetGiaFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(optionSetGiaFrame);
		optionSetGiaFrame.setLayout(null);
		optionSetGiaFrame.add(panel);
		panel.setBounds(5, 5, 218, 0);
		panel.setLayout(new BorderLayout(0, 0));
		
		JCheckBox chkSetGiaMaHang = new JCheckBox("Mã hàng");
		chkSetGiaMaHang.setBounds(15, 12, 99, 23);
		optionSetGiaFrame.add(chkSetGiaMaHang);
		
		JCheckBox chkSetGiaTenHang = new JCheckBox("Tên hàng");
		chkSetGiaTenHang.setBounds(15, 43, 99, 23);
		optionSetGiaFrame.add(chkSetGiaTenHang);
		
		JCheckBox chkSetGiaGiaVon = new JCheckBox("Giá vốn");
		chkSetGiaGiaVon.setBounds(15, 69, 99, 23);
		optionSetGiaFrame.add(chkSetGiaGiaVon);
		
		JCheckBox chkSetGiaGiaNhapCuoi = new JCheckBox("Giá nhập cuối");
		chkSetGiaGiaNhapCuoi.setBounds(15, 95, 99, 23);
		optionSetGiaFrame.add(chkSetGiaGiaNhapCuoi);
	}
}
