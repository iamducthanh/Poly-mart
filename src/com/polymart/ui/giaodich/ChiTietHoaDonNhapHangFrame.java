package com.polymart.ui.giaodich;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ChiTietHoaDonNhapHangFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1275654074282876688L;
	private JPanel contentPane;
	private JTable tableChiTietHoaDonNhap;
 	DefaultTableModel modelChiTietHoaDonNhap = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiTietHoaDonNhapHangFrame frame = new ChiTietHoaDonNhapHangFrame();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChiTietHoaDonNhapHangFrame() {
		setTitle("Chi tiết hóa đơn nhập hàng");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 877, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chi tiết hóa đơn nhập hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(20, 11, 307, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã hóa đơn nhập hàng: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(30, 61, 170, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblMaHoaDon = new JLabel("Cái label này để hiển thị mã hóa đơn nhập hàng");
		lblMaHoaDon.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaHoaDon.setBounds(210, 61, 387, 25);
		contentPane.add(lblMaHoaDon);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 155, 819, 391);
		contentPane.add(scrollPane);
		
		tableChiTietHoaDonNhap = new JTable();
		scrollPane.setViewportView(tableChiTietHoaDonNhap);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nguồn hàng:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(30, 96, 170, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblCiLabelNy = new JLabel("Cái label này để hiển thị nguồn hàng");
		lblCiLabelNy.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCiLabelNy.setBounds(136, 97, 387, 25);
		contentPane.add(lblCiLabelNy);
		
		modelChiTietHoaDonNhap.addColumn("Mã sản phẩm");
		modelChiTietHoaDonNhap.addColumn("Tên sản phẩm");
		modelChiTietHoaDonNhap.addColumn("Số lượng");
		modelChiTietHoaDonNhap.addColumn("Đơn giá");
		modelChiTietHoaDonNhap.addColumn("Thành tiền");
		tableChiTietHoaDonNhap.setModel(modelChiTietHoaDonNhap);
	}
}
