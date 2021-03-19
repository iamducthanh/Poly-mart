package com.polymart.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class NhanVienJFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7184061226380381253L;
	private JPanel contentPane;
	private JTextField txtTimKiem;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	JPanel nhanVienJPanel = new JPanel();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVienJFrame frame = new NhanVienJFrame();
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
	JPanel panel = new JPanel();
	public NhanVienJFrame() {
		setFocusable(true);
		setTitle("NhÃ¢n viÃªn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1062, 662);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
//		initTopNhanVien();
//		initCenterNhanVien();
	}
	
	public void initTopNhanVien() {
		JLabel lblNhanVien = new JLabel("Nhân viên                       ");
		lblNhanVien.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNhanVien, BorderLayout.WEST);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setText(" TÌm theo mã, tên nhân viên");
		panel.add(txtTimKiem, BorderLayout.CENTER);
		txtTimKiem.setColumns(10);
		txtTimKiem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTimKiem.getText().equals(" TÌm theo mã, tên nhân viên")) {
					txtTimKiem.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTimKiem.getText().equals("")) {
					txtTimKiem.setText(" TÌm theo mã, tên nhân viên");
				}
			}
		});
		
		JPanel panel1 = new JPanel();
		panel.add(panel1, BorderLayout.EAST);
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("                                     ");
		panel1.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("+ Nhân viên");
		panel1.add(btnNewButton_1);
		
		JComboBox comboBox1 = new JComboBox();
		panel1.add(comboBox1);
	}
	
	public void initCenterNhanVien() {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		nhanVienJPanel.setLayout(new BoxLayout(nhanVienJPanel, BoxLayout.Y_AXIS));
		JLabel lblNewLabel_2 = new JLabel("Loại hàng             ▼");
		lblNewLabel_2.setFont(new Font("Consolas", Font.BOLD, 14));
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model.addColumn("☐");
		model.addColumn("Mã nhân viên");
		model.addColumn("Tên nhân viên");
		model.addColumn("Mã chấm công");
		model.addColumn("Phòng ban");
		model.addColumn("Chức danh");
		model.addColumn("Số điện thoại");
		model.addColumn("Nợ lương nhân viên");
		table.setModel(model);
		
		JPanel panelLeft = new JPanel();
		contentPane.add(panelLeft, BorderLayout.WEST);
		
		JComboBox cbbPhongBan = new JComboBox();
		cbbPhongBan.setModel(new DefaultComboBoxModel(new String[] {"Tất cả"}));
		
		JLabel lblNewLabel = new JLabel("Phòng ban");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblChcDanh = new JLabel("Chức danh");
		lblChcDanh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JComboBox cbbChucDanh = new JComboBox();
		cbbChucDanh.setModel(new DefaultComboBoxModel(new String[] {"Tất cả"}));
		GroupLayout gl_panelLeft = new GroupLayout(panelLeft);
		gl_panelLeft.setHorizontalGroup(
			gl_panelLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLeft.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addComponent(cbbPhongBan, 0, 159, Short.MAX_VALUE))
						.addComponent(lblChcDanh, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbbChucDanh, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelLeft.setVerticalGroup(
			gl_panelLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLeft.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbbPhongBan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblChcDanh, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbbChucDanh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(465, Short.MAX_VALUE))
		);
		panelLeft.setLayout(gl_panelLeft);
	}
}
