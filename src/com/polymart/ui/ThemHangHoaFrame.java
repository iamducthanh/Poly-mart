package com.polymart.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.polymart.emtity.EmtityFrame;

public class ThemHangHoaFrame extends JFrame {

	private static final long serialVersionUID = -2914525596895096982L;
	
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	private JTextField txtMaSP;
	private JLabel lblTnSnPhm;
	private JLabel lblLoi;
	private JLabel lblGiVn;
	private JLabel lblGiVn_1;
	private JLabel lblGiBn;
	private JTextField txtTenSP;
	private JTextField txtLoaiSP;
	private JTextField txtGiaVon;
	private JTextField txtGiaBan;
	private JTextField txtGiaGiam;
	private JTextField txtMauSac;
	private JMenu mnThoat;
	private JMenu mnLuuSP;
	private JMenu mHelp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmtityFrame.frameHangHoa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ThemHangHoaFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1101, 643);
		setLocationRelativeTo(null);
		setTitle("Thêm sản phẩm");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnThoat = new JMenu("Thoát  |");
		mnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				close();
			}
		});
		menuBar.add(mnThoat);
		
		mnLuuSP = new JMenu("Lưu sản phẩm  |");
		menuBar.add(mnLuuSP);
		
		mHelp = new JMenu("Trợ giúp");
		menuBar.add(mHelp);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 119, 1067, 465);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1047, 399);
		panel.add(scrollPane);
		
		JButton btnLuuSP = new JButton("Lưu sản phẩm");
		btnLuuSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLuuSP.setBounds(935, 431, 122, 23);
		panel.add(btnLuuSP);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoa.setBounds(835, 431, 89, 23);
		panel.add(btnXoa);

		
		table = new JTable();
		scrollPane.setViewportView(table);
		model.addColumn("Mã sản phẩm");
		model.addColumn("Tên sản phẩm");
		model.addColumn("Loại");
		model.addColumn("Giá vốn");
		model.addColumn("Giá bán");
		model.addColumn("Giá giảm");
		model.addColumn("Màu sắc");
		model.addColumn("Size");
		table.setModel(model);
		
		JLabel lblNewLabel = new JLabel("Mã sản phẩm");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 88, 25);
		contentPane.add(lblNewLabel);
		
		txtMaSP = new JTextField();
		txtMaSP.setBorder(null);
		txtMaSP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaSP.setBounds(108, 11, 228, 25);
		contentPane.add(txtMaSP);
		txtMaSP.setColumns(10);
		
		lblTnSnPhm = new JLabel("Tên sản phẩm");
		lblTnSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnSnPhm.setBounds(10, 47, 126, 25);
		contentPane.add(lblTnSnPhm);
		
		lblLoi = new JLabel("Loại");
		lblLoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLoi.setBounds(10, 83, 88, 25);
		contentPane.add(lblLoi);
		
		lblGiVn = new JLabel("Giá vốn");
		lblGiVn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGiVn.setBounds(380, 11, 88, 25);
		contentPane.add(lblGiVn);
		
		lblGiVn_1 = new JLabel("Giá bán");
		lblGiVn_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGiVn_1.setBounds(380, 47, 88, 25);
		contentPane.add(lblGiVn_1);
		
		lblGiBn = new JLabel("Giá giảm");
		lblGiBn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGiBn.setBounds(380, 83, 88, 25);
		contentPane.add(lblGiBn);
		
		txtTenSP = new JTextField();
		txtTenSP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenSP.setColumns(10);
		txtTenSP.setBorder(null);
		txtTenSP.setBounds(108, 47, 228, 25);
		contentPane.add(txtTenSP);
		
		txtLoaiSP = new JTextField();
		txtLoaiSP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtLoaiSP.setColumns(10);
		txtLoaiSP.setBorder(null);
		txtLoaiSP.setBounds(108, 83, 228, 25);
		contentPane.add(txtLoaiSP);
		
		txtGiaVon = new JTextField();
		txtGiaVon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtGiaVon.setColumns(10);
		txtGiaVon.setBorder(null);
		txtGiaVon.setBounds(465, 11, 171, 25);
		contentPane.add(txtGiaVon);
		
		txtGiaBan = new JTextField();
		txtGiaBan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtGiaBan.setColumns(10);
		txtGiaBan.setBorder(null);
		txtGiaBan.setBounds(465, 47, 171, 25);
		contentPane.add(txtGiaBan);
		
		txtGiaGiam = new JTextField();
		txtGiaGiam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtGiaGiam.setColumns(10);
		txtGiaGiam.setBorder(null);
		txtGiaGiam.setBounds(465, 83, 171, 25);
		contentPane.add(txtGiaGiam);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSize.setBounds(690, 11, 88, 25);
		contentPane.add(lblSize);
		
		JLabel lblGiVn_2_1 = new JLabel("Màu sắc");
		lblGiVn_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGiVn_2_1.setBounds(690, 47, 88, 25);
		contentPane.add(lblGiVn_2_1);
		
		txtMauSac = new JTextField();
		txtMauSac.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMauSac.setColumns(10);
		txtMauSac.setBorder(null);
		txtMauSac.setBounds(771, 47, 171, 25);
		contentPane.add(txtMauSac);
		
		JComboBox<Object> cbbSize = new JComboBox<Object>();
		cbbSize.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbSize.setModel(new DefaultComboBoxModel<Object>(new String[] {"S", "M", "L", "XL", "XXL", "Free size"}));
		cbbSize.setBounds(771, 13, 171, 25);
		contentPane.add(cbbSize);
		
		JButton btnThemSP = new JButton("+ Thêm");
		btnThemSP.setBounds(981, 14, 89, 23);
		contentPane.add(btnThemSP);
		
		JButton btnMoi = new JButton("Tạo mới");
		btnMoi.setBounds(981, 50, 89, 23);
		contentPane.add(btnMoi);
		
	}
	
	public void close() {
		this.dispose();
	}
}
