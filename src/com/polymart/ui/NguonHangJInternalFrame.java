package com.polymart.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.table.DefaultTableModel;

public class NguonHangJInternalFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3314858072598500922L;
	private JPanel contentPane;
	//textfiled nguồn hàng
	private JTextField txtTimNguonHang;
	private JTextField txtTenNguonHang;
	private JTextField txtSDTNguonHang;
	private JTextField txtDiaChiNguonHang;
	JPanel panel = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel hangHoaJPanel = new JPanel();
	private JTable table;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NguonHangJInternalFrame frame = new NguonHangJInternalFrame();
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
	public NguonHangJInternalFrame() {
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
		
	//	initNguonHang();
	}
	
	public void initNguonHang() {
		setTitle("Hàng hóa - Nguồn hàng");
		JPanel panelNguonHang = new JPanel();
		panelNguonHang.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelNguonHang.setBounds(100, 100, 751, 629);
		setContentPane(panelNguonHang);
		panelNguonHang.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nguồn hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 34, 159, 26);
		panelNguonHang.add(lblNewLabel);
		
		txtTimNguonHang = new JTextField();
		txtTimNguonHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimNguonHang.setText(" Tìm theo tên, số điện thoại");
		txtTimNguonHang.setBounds(163, 34, 438, 30);
		panelNguonHang.add(txtTimNguonHang);
		txtTimNguonHang.setColumns(10);
		
		JButton btnTimNguonHang = new JButton("Tìm");
		btnTimNguonHang.setBounds(611, 39, 89, 25);
		panelNguonHang.add(btnTimNguonHang);
		
		JLabel lblNewLabel_1 = new JLabel("Tên nguồn hàng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(23, 107, 130, 30);
		panelNguonHang.add(lblNewLabel_1);
		
		txtTenNguonHang = new JTextField();
		txtTenNguonHang.setBounds(163, 109, 350, 30);
		panelNguonHang.add(txtTenNguonHang);
		txtTenNguonHang.setColumns(10);
		
		txtSDTNguonHang = new JTextField();
		txtSDTNguonHang.setText(" ");
		txtSDTNguonHang.setColumns(10);
		txtSDTNguonHang.setBounds(163, 150, 350, 30);
		panelNguonHang.add(txtSDTNguonHang);
		
		txtDiaChiNguonHang = new JTextField();
		txtDiaChiNguonHang.setText(" ");
		txtDiaChiNguonHang.setColumns(10);
		txtDiaChiNguonHang.setBounds(163, 191, 350, 30);
		panelNguonHang.add(txtDiaChiNguonHang);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(23, 148, 130, 30);
		panelNguonHang.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Địa chỉ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(23, 191, 130, 30);
		panelNguonHang.add(lblNewLabel_1_2);
		
		JButton btnThemNguonHang = new JButton("Thêm");
		btnThemNguonHang.setBounds(611, 113, 89, 25);
		panelNguonHang.add(btnThemNguonHang);
		
		JButton btnCapNhatNguonHang = new JButton("Cập nhật");
		btnCapNhatNguonHang.setBounds(611, 154, 89, 25);
		panelNguonHang.add(btnCapNhatNguonHang);
		
		JButton btnXoaNguonHang = new JButton("Xóa");
		btnXoaNguonHang.setBounds(611, 195, 89, 25);
		panelNguonHang.add(btnXoaNguonHang);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 249, 717, 343);
		panelNguonHang.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"T\u00EAn ngu\u1ED3n h\u00E0ng", "Địa chỉ", "Số điện thoại"
			}
		));
		scrollPane.setViewportView(table);
		
		
		txtTimNguonHang.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTimNguonHang.getText().equals(" Tìm theo tên, số điện thoại")) {
					txtTimNguonHang.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTimNguonHang.getText().equals("")) {
					txtTimNguonHang.setText(" Tìm theo tên, số điện thoại");
				}
			}
		});
	}

}
