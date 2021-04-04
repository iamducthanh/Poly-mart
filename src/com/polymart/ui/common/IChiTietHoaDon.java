package com.polymart.ui.common;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class IChiTietHoaDon extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8080716429179868714L;
	private JPanel contentPane;
	private JTable tableChiTietHoaDonTraHang;
	DefaultTableModel modelChiTietHoaDonTraHang = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IChiTietHoaDon frame = new IChiTietHoaDon();
					frame.setLocationRelativeTo(null);
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
	public IChiTietHoaDon() {
		setTitle("Chi tiết hóa đơn trả hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Chi tiết hóa đơn trả hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(20, 11, 307, 39);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mã hóa đơn trả hàng: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(30, 61, 170, 25);
		contentPane.add(lblNewLabel_1);

		JLabel lblMaHoaDon = new JLabel("Cái label này để hiển thị mã hóa đơn trả hàng");
		lblMaHoaDon.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaHoaDon.setBounds(210, 61, 387, 25);
		contentPane.add(lblMaHoaDon);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 155, 819, 391);
		contentPane.add(scrollPane);

		tableChiTietHoaDonTraHang = new JTable();
		scrollPane.setViewportView(tableChiTietHoaDonTraHang);

		JLabel lblNewLabel_1_1 = new JLabel("Khách hàng:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(30, 96, 170, 25);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblCiLabelNy = new JLabel("Cái label này để hiển thị khách hàng");
		lblCiLabelNy.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCiLabelNy.setBounds(136, 97, 387, 25);
		contentPane.add(lblCiLabelNy);

		modelChiTietHoaDonTraHang.addColumn("Mã sản phẩm");
		modelChiTietHoaDonTraHang.addColumn("Tên sản phẩm");
		modelChiTietHoaDonTraHang.addColumn("Số lượng");
		modelChiTietHoaDonTraHang.addColumn("Đơn giá");
		modelChiTietHoaDonTraHang.addColumn("Giảm giá");
		modelChiTietHoaDonTraHang.addColumn("Thành tiền");
		tableChiTietHoaDonTraHang.setModel(modelChiTietHoaDonTraHang);
	}

}
