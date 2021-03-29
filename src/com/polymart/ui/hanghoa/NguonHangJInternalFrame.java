package com.polymart.ui.hanghoa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class NguonHangJInternalFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3314858072598500922L;
	private JPanel contentPane;

	JPanel panel = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel hangHoaJPanel = new JPanel();
	private JTextField txtTim;
	private JTable table_1;
	private JTextField txtNguonHang;
	private JTextField txtSoDT;
	private JTextField txtDiaChi;
	DefaultTableModel model = new DefaultTableModel();


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
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	setBounds(100, 100, 1920, 639);
		setFocusable(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("   Nguồn hàng         ");
		lblNewLabel.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 18));
		
		txtTim = new JTextField();
		txtTim.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 14));
		txtTim.setText(" Tìm theo tên, số điện thoại");
		txtTim.setColumns(10);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel)
					.addGap(5)
					.addComponent(txtTim, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(365))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtTim, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Chi ti\u1EBFt ngu\u1ED3n h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		
		JButton btnXoa = new JButton("Xóa");
		
		JButton btnCapNhat = new JButton("Cập nhật");
		
		JButton btnThem = new JButton("Thêm");
		
		JButton btnToMi = new JButton("Tạo mới");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(11, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(73, Short.MAX_VALUE)
					.addComponent(btnToMi, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnToMi, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(246, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_2 = new JLabel("Tên nguồn hàng");
		lblNewLabel_2.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 16));
		
		txtNguonHang = new JTextField();
		txtNguonHang.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Số điện thoại");
		lblNewLabel_2_1.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 16));
		
		txtSoDT = new JTextField();
		txtSoDT.setColumns(10);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Địa chỉ");
		lblNewLabel_2_1_1.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 16));
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNguonHang, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSoDT, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(29)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtNguonHang, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtSoDT, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(124, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		panel_2.setLayout(gl_panel_2);
		
		txtTim.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTim.getText().equals(" Tìm theo tên, số điện thoại")) {
					txtTim.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTim.getText().equals("")) {
					txtTim.setText(" Tìm theo tên, số điện thoại");
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		model.addColumn("Tên nguồn hàng");
		model.addColumn("Địa chỉ");
		model.addColumn("Số điện thoại");
		table_1.setModel(model);
	}
	

}
