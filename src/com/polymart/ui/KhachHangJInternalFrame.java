package com.polymart.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class KhachHangJInternalFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1800520210551253741L;
	private JPanel contentPane;
	private JTextField txtTmKiem;
	private JTextField txtMaKhachHang;
	private JTextField txtTenKhachHang;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtTichDiem;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnTaoMoi;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnCapNhat;
	private JTable table;
	
	private DefaultTableModel model = new DefaultTableModel();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHangJInternalFrame frame = new KhachHangJInternalFrame();
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
	public KhachHangJInternalFrame() {
		setFocusable(true);

		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		setBackground(SystemColor.activeCaption);
		setTitle("Quản lí khách hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 649);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chi ti\u1EBFt kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(10, 11, 719, 284);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã khách hàng: ", JLabel.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 90, 142, 25);
		panel.add(lblNewLabel);
		
		txtTmKiem = new JTextField();
		txtTmKiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTmKiem.setText(" Tìm theo mã, tên, số điện thoại khách hàng");
		txtTmKiem.setBounds(184, 38, 362, 25);
		panel.add(txtTmKiem);
		txtTmKiem.setColumns(10);
		
		txtTmKiem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTmKiem.getText().equals(" Tìm theo mã, tên, số điện thoại khách hàng")) {
					txtTmKiem.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTmKiem.getText().equals("")) {
					txtTmKiem.setText(" Tìm theo mã, tên, số điện thoại khách hàng");
				}
			}
		});
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBounds(575, 39, 89, 25);
		panel.add(btnTimKiem);
		
		JLabel lblNewLabel_1 = new JLabel("Tên khách hàng: ", JLabel.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 126, 142, 25);
		panel.add(lblNewLabel_1);
		
		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setBounds(184, 90, 337, 25);
		panel.add(txtMaKhachHang);
		txtMaKhachHang.setColumns(10);
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(184, 126, 337, 25);
		panel.add(txtTenKhachHang);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(184, 162, 337, 25);
		panel.add(txtSDT);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(184, 198, 337, 25);
		panel.add(txtDiaChi);
		
		txtTichDiem = new JTextField();
		txtTichDiem.setColumns(10);
		txtTichDiem.setBounds(184, 234, 337, 25);
		panel.add(txtTichDiem);
		
		lblNewLabel_2 = new JLabel("Số điện thoại: ", JLabel.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 162, 142, 25);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Địa chỉ: ", JLabel.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 198, 142, 25);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Tích điểm: ", JLabel.RIGHT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(10, 232, 142, 25);
		panel.add(lblNewLabel_4);
		
		btnTaoMoi = new JButton("Tạo mới");
		btnTaoMoi.setBounds(575, 93, 89, 25);
		panel.add(btnTaoMoi);
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(575, 129, 89, 25);
		panel.add(btnThem);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(575, 165, 89, 25);
		panel.add(btnXoa);
		
		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setBounds(575, 201, 89, 25);
		panel.add(btnCapNhat);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Danh s\u00E1ch kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(SystemColor.control);
		panel_1.setBounds(10, 306, 719, 295);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 699, 263);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model.addColumn("Mã khách hàng");
		model.addColumn("Tên khách hàng");
		model.addColumn("Số điện thoại");
		model.addColumn("Địa chỉ");
		model.addColumn("Tích điểm");
		table.setModel(model);
	}
}
