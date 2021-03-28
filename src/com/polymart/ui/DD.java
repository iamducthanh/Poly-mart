package com.polymart.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;

import com.polymart.emtity.*;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;

public class DD extends JFrame {

	JPanel contentNhaPanel;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmtityFrame.frameDd.setVisible(true);
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Thêm phiếu thanh toán");
		setBounds(100, 100, 633, 626);
		setFocusable(true);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnThoat = new JMenu("Thoát");
		menuBar.add(mnThoat);
		
		JMenu mnLuu = new JMenu("Lưu");
		menuBar.add(mnLuu);
		contentNhaPanel = new JPanel();
		contentNhaPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentNhaPanel);
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

		
	}
}
