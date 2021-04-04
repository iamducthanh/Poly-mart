package com.polymart.ui.hanghoa;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChiTietSanPhamFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -183259936805942123L;
	private JPanel contentPane;
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JTextField txtGiaBan;
	private JTextField txtLoai;
	private JTextField txtGiaVon;
	private JTextField txtSoLuong;
	private JTextField txtGiaGiam;
	private JTextField txtMauSac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiTietSanPhamFrame frame = new ChiTietSanPhamFrame();
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
	public ChiTietSanPhamFrame() {
		setTitle("Chi tiết sản phẩm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Chi ti\u1EBFt s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(10, 11, 765, 470);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã sản phẩm:", JLabel.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 32, 124, 25);
		panel.add(lblNewLabel);
		
		txtMaSP = new JTextField();
		txtMaSP.setEditable(false);
		txtMaSP.setBounds(174, 34, 152, 25);
		panel.add(txtMaSP);
		txtMaSP.setColumns(10);
		
		txtTenSP = new JTextField();
		txtTenSP.setEditable(false);
		txtTenSP.setColumns(10);
		txtTenSP.setBounds(174, 74, 240, 25);
		panel.add(txtTenSP);
		
		txtGiaBan = new JTextField();
		txtGiaBan.setEditable(false);
		txtGiaBan.setColumns(10);
		txtGiaBan.setBounds(174, 194, 152, 25);
		panel.add(txtGiaBan);
		
		txtLoai = new JTextField();
		txtLoai.setEditable(false);
		txtLoai.setColumns(10);
		txtLoai.setBounds(174, 114, 240, 25);
		panel.add(txtLoai);
		
		txtGiaVon = new JTextField();
		txtGiaVon.setEditable(false);
		txtGiaVon.setColumns(10);
		txtGiaVon.setBounds(174, 234, 152, 25);
		panel.add(txtGiaVon);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setEditable(false);
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(174, 154, 152, 25);
		panel.add(txtSoLuong);
		
		txtGiaGiam = new JTextField();
		txtGiaGiam.setEditable(false);
		txtGiaGiam.setColumns(10);
		txtGiaGiam.setBounds(174, 274, 152, 25);
		panel.add(txtGiaGiam);
		
		txtMauSac = new JTextField();
		txtMauSac.setEditable(false);
		txtMauSac.setColumns(10);
		txtMauSac.setBounds(174, 354, 152, 25);
		panel.add(txtMauSac);
		
		JLabel lblTnSnPhm = new JLabel("Tên sản phẩm:", SwingConstants.RIGHT);
		lblTnSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnSnPhm.setBounds(10, 74, 124, 25);
		panel.add(lblTnSnPhm);
		
		JLabel lblLoi = new JLabel("Loại:", SwingConstants.RIGHT);
		lblLoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLoi.setBounds(10, 114, 124, 25);
		panel.add(lblLoi);
		
		JLabel lblSLng = new JLabel("Số lượng:", SwingConstants.RIGHT);
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSLng.setBounds(10, 154, 124, 25);
		panel.add(lblSLng);
		
		JLabel lblGiBn = new JLabel("Giá bán:", SwingConstants.RIGHT);
		lblGiBn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGiBn.setBounds(10, 194, 124, 25);
		panel.add(lblGiBn);
		
		JLabel lblGiVn = new JLabel("Giá vốn:", SwingConstants.RIGHT);
		lblGiVn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGiVn.setBounds(10, 234, 124, 25);
		panel.add(lblGiVn);
		
		JLabel lblGiGim = new JLabel("Giá giảm:", SwingConstants.RIGHT);
		lblGiGim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGiGim.setBounds(10, 274, 124, 25);
		panel.add(lblGiGim);
		
		JLabel lblSize = new JLabel("Size:", SwingConstants.RIGHT);
		lblSize.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSize.setBounds(10, 314, 124, 25);
		panel.add(lblSize);
		
		JLabel lblMuSc = new JLabel("Màu sắc:", SwingConstants.RIGHT);
		lblMuSc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMuSc.setBounds(10, 354, 124, 25);
		panel.add(lblMuSc);
		
		JComboBox cbbSize = new JComboBox();
		cbbSize.setBounds(174, 314, 131, 25);
		panel.add(cbbSize);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "H\u00ECnh \u1EA3nh", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(428, 11, 327, 448);
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel image1 = new JLabel("");
		image1.setIcon(new ImageIcon("images\\imgThemAnh.jpg"));
		panel_1.add(image1);
		
		JLabel image2 = new JLabel("");
		image2.setIcon(new ImageIcon("images\\imgThemAnh.jpg"));
		panel_1.add(image2);
		
		JLabel image3 = new JLabel("");
		image3.setIcon(new ImageIcon("images\\imgThemAnh.jpg"));
		panel_1.add(image3);
		
		JLabel image4 = new JLabel("");
		image4.setIcon(new ImageIcon("images\\imgThemAnh.jpg"));
		panel_1.add(image4);
		
		JLabel image5 = new JLabel("");
		image5.setIcon(new ImageIcon("images\\imgThemAnh.jpg"));
		panel_1.add(image5);
		
		JLabel image6 = new JLabel("");
		image6.setIcon(new ImageIcon("images\\imgThemAnh.jpg"));
		panel_1.add(image6);
		
		JLabel image7 = new JLabel("");
		image7.setIcon(new ImageIcon("images\\imgThemAnh.jpg"));
		panel_1.add(image7);
		
		JLabel image8 = new JLabel("");
		image8.setIcon(new ImageIcon("images\\imgThemAnh.jpg"));
		panel_1.add(image8);
		
		JLabel image9 = new JLabel("");
		image9.setIcon(new ImageIcon("images\\imgThemAnh.jpg"));
		panel_1.add(image9);
		
		JLabel image10 = new JLabel("");
		image10.setIcon(new ImageIcon("images\\imgThemAnh.jpg"));
		panel_1.add(image10);
		
		JLabel image11 = new JLabel("");
		image11.setIcon(new ImageIcon("images\\imgThemAnh.jpg"));
		panel_1.add(image11);
		
		JLabel image12 = new JLabel("");
		image12.setIcon(new ImageIcon("images\\imgThemAnh.jpg"));
		panel_1.add(image12);
		
		JButton btnNewButton = new JButton("Thoát");
		btnNewButton.setBounds(669, 492, 89, 25);
		contentPane.add(btnNewButton);
		
		JButton btnLu = new JButton("Lưu");
		btnLu.setBounds(570, 492, 89, 25);
		contentPane.add(btnLu);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtGiaBan.setEditable(true);
				txtGiaGiam.setEditable(true);
				txtGiaVon.setEditable(true);
				txtLoai.setEditable(true);
				txtMaSP.setEditable(true);
				txtSoLuong.setEditable(true);
				txtTenSP.setEditable(true);
				txtMauSac.setEditable(true);
			}
		});
		btnSa.setBounds(471, 492, 89, 25);
		contentPane.add(btnSa);
	}
}
