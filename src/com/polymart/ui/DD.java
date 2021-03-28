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

public class DD extends JFrame {

	JPanel contentPane;
	private JTextField txtSoLuong;
	private JTextField txtMaSP;
	private JTextField txtNguoiNhap;
	private JTextField txtMaPhieu;
	private JLabel lblSLng;
	private JLabel lblMSnPhm;
	private JLabel lblNgiNhp;
	private JLabel lblNgunHng;
	private JLabel lblGhiCh;

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
		setTitle("Thêm phiết nhập hàng");
		setBounds(100, 100, 633, 543);
		setFocusable(true);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnThoat = new JMenu("Thoát");
		menuBar.add(mnThoat);
		
		JMenu mnLuu = new JMenu("Lưu");
		menuBar.add(mnLuu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin phi\u1EBFu nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(10, 11, 595, 411);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã phiếu: ", JLabel.RIGHT);
		lblNewLabel.setBounds(0, 31, 125, 25);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblMSnPhm = new JLabel("Mã sản phẩm: ", JLabel.RIGHT);
		lblMSnPhm.setBounds(0, 78, 125, 25);
		panel.add(lblMSnPhm);
		lblMSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtMaPhieu = new JTextField();
		txtMaPhieu.setBounds(154, 31, 300, 25);
		panel.add(txtMaPhieu);
		txtMaPhieu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaPhieu.setColumns(10);
		
		txtMaSP = new JTextField();
		txtMaSP.setBounds(154, 78, 300, 25);
		panel.add(txtMaSP);
		txtMaSP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaSP.setColumns(10);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(154, 124, 300, 25);
		panel.add(txtSoLuong);
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSoLuong.setColumns(10);
		
		txtNguoiNhap = new JTextField();
		txtNguoiNhap.setBounds(154, 169, 300, 25);
		panel.add(txtNguoiNhap);
		txtNguoiNhap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNguoiNhap.setColumns(10);
		
		JComboBox cbbNguonHang = new JComboBox();
		cbbNguonHang.setBounds(154, 212, 419, 25);
		panel.add(cbbNguonHang);
		
		lblSLng = new JLabel("Số lượng: ", JLabel.RIGHT);
		lblSLng.setBounds(0, 124, 125, 25);
		panel.add(lblSLng);
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblNgiNhp = new JLabel("Người nhập: ", JLabel.RIGHT);
		lblNgiNhp.setBounds(0, 169, 125, 25);
		panel.add(lblNgiNhp);
		lblNgiNhp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblNgunHng = new JLabel("Nguồn hàng: ", JLabel.RIGHT);
		lblNgunHng.setBounds(0, 210, 125, 25);
		panel.add(lblNgunHng);
		lblNgunHng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblGhiCh = new JLabel("Ghi chú: ", JLabel.RIGHT);
		lblGhiCh.setBounds(0, 256, 125, 25);
		panel.add(lblGhiCh);
		lblGhiCh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(154, 256, 419, 131);
		panel.add(scrollPane);
		
		JTextArea txtGhiChu = new JTextArea();
		scrollPane.setViewportView(txtGhiChu);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBounds(516, 443, 89, 23);
		contentPane.add(btnThoat);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setBounds(417, 443, 89, 23);
		contentPane.add(btnLuu);

		
	}
}
