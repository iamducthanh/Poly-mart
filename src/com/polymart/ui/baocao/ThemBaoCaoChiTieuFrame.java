package com.polymart.ui.baocao;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class ThemBaoCaoChiTieuFrame extends JFrame {

	private static final long serialVersionUID = -8420199500518475018L;

	private JPanel contentPane;
	private JTextField txtMaNV;
	private JTextField txtSoTien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemBaoCaoChiTieuFrame frame = new ThemBaoCaoChiTieuFrame();
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
	public ThemBaoCaoChiTieuFrame() {
		setTitle("Thêm báo cáo chi tiêu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã nhân viên: ", JLabel.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 30, 128, 25);
		contentPane.add(lblNewLabel);

		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaNV.setBounds(174, 30, 216, 25);
		contentPane.add(txtMaNV);
		txtMaNV.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(174, 127, 284, 93);
		contentPane.add(scrollPane);

		JTextArea txtMucDichCT = new JTextArea();
		scrollPane.setViewportView(txtMucDichCT);
		txtMucDichCT.setFont(new Font("Monospaced", Font.PLAIN, 15));

		txtSoTien = new JTextField();
		txtSoTien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSoTien.setColumns(10);
		txtSoTien.setBounds(174, 239, 216, 25);
		contentPane.add(txtSoTien);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(174, 287, 284, 105);
		contentPane.add(scrollPane_1);

		JTextArea txtGhiChu = new JTextArea();
		scrollPane_1.setViewportView(txtGhiChu);
		txtGhiChu.setFont(new Font("Monospaced", Font.PLAIN, 15));

		JLabel lblNgyChiTiu = new JLabel("Ngày chi tiêu: ", SwingConstants.RIGHT);
		lblNgyChiTiu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgyChiTiu.setBounds(10, 76, 128, 25);
		contentPane.add(lblNgyChiTiu);

		JLabel lblMcchChi = new JLabel("Mục đích chi tiêu: ", SwingConstants.RIGHT);
		lblMcchChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMcchChi.setBounds(10, 127, 128, 25);
		contentPane.add(lblMcchChi);

		JLabel lblSTin = new JLabel("Số tiền: ", SwingConstants.RIGHT);
		lblSTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSTin.setBounds(10, 239, 128, 25);
		contentPane.add(lblSTin);

		JLabel lblGhiCh = new JLabel("Ghi chú: ", SwingConstants.RIGHT);
		lblGhiCh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGhiCh.setBounds(10, 287, 128, 25);
		contentPane.add(lblGhiCh);

		JDateChooser dateNgayChiTieu = new JDateChooser();
		dateNgayChiTieu.setBounds(174, 76, 216, 25);
		contentPane.add(dateNgayChiTieu);

		JButton btnLuu = new JButton("Lưu");
		btnLuu.setBounds(369, 468, 89, 23);
		contentPane.add(btnLuu);
	}
}
