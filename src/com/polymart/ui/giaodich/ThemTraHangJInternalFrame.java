package com.polymart.ui.giaodich;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ThemTraHangJInternalFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1044582693223562703L;
	private JPanel contentPane;
	DefaultTableModel modelDanhSachHoaDon = new DefaultTableModel();
	DefaultTableModel modelDanhSachSanPham = new DefaultTableModel();

	private JTextField txtTimKiem;
	private JTable tableDanhSachSanPham;
	private JTable tableDanhSachHoaDON;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemTraHangJInternalFrame frame = new ThemTraHangJInternalFrame();
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
	public ThemTraHangJInternalFrame() {
		((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 639);

		setFocusable(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);

		JButton btnQuayLai = new JButton("<-   ");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnQuayLai.setContentAreaFilled(false);
		btnQuayLai.setBorder(null);
		btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 17));

		JLabel lblNewLabel = new JLabel("Trả hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimKiem.setText(" Tìm theo mã hóa đơn thanh toán");
		txtTimKiem.setColumns(10);

		JButton btnTimKiem = new JButton("Tìm kiếm");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(5).addComponent(btnQuayLai).addGap(5)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
						.addGap(5).addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
						.addGap(557)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addGap(5)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnQuayLai, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				" Th\u00F4ng tin h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_5.add(scrollPane, BorderLayout.CENTER);

		tableDanhSachHoaDON = new JTable();
		scrollPane.setViewportView(tableDanhSachHoaDON);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				" Danh s\u00E1ch s\u1EA3n ph\u1EA9m ", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		contentPane.add(panel_2, BorderLayout.SOUTH);

		JScrollPane scrollPane_1 = new JScrollPane();

		JLabel lblNewLabel_1_1 = new JLabel("Mã khách hàng");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JScrollPane scrollPane_2 = new JScrollPane();

		JLabel lblNewLabel_1 = new JLabel("Tổng tiền hoàn trả", JLabel.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblTongTien = new JLabel("0.0", SwingConstants.RIGHT);
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 20));

		JButton btnHoanTra = new JButton("Hoàn trả");

		JLabel lblNewLabel_1_1_1 = new JLabel("KH00001");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblNewLabel_1_1_2 = new JLabel("Mã hóa đơn");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_1_1_1_1 = new JLabel("HD0002");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Ghi chú");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_2
				.createSequentialGroup().addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
				.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panel_2.createSequentialGroup().addGroup(gl_panel_2
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup().addGap(211).addComponent(btnHoanTra,
										GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_2.createSequentialGroup()
										.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 111,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 111,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_2.createSequentialGroup()
										.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 111,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 111,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 111,
										GroupLayout.PREFERRED_SIZE))
								.addGap(10))
						.addGroup(
								gl_panel_2.createSequentialGroup()
										.addComponent(lblTongTien, GroupLayout.PREFERRED_SIZE, 340,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
						.addGroup(gl_panel_2.createSequentialGroup().addComponent(lblNewLabel_1,
								GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE).addContainerGap()))));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_2
				.createSequentialGroup().addGap(3)
				.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_1_1).addComponent(lblNewLabel_1_1_1,
												GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 16,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 16,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 16,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNewLabel_1).addGap(18)
								.addComponent(lblTongTien, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addGap(46)
								.addComponent(btnHoanTra, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 300,
								GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));

		JTextArea textArea = new JTextArea();
		scrollPane_2.setViewportView(textArea);

		tableDanhSachSanPham = new JTable();
		scrollPane_1.setViewportView(tableDanhSachSanPham);
		panel_2.setLayout(gl_panel_2);
		modelDanhSachHoaDon.addColumn("Mã hóa đơn");
		modelDanhSachHoaDon.addColumn("Ngày tạo");
		modelDanhSachHoaDon.addColumn("Mã khách hàng");
		modelDanhSachHoaDon.addColumn("Mã nhân viên");
		modelDanhSachHoaDon.addColumn("Địa điểm");
		modelDanhSachHoaDon.addColumn("Tổng tiền");
		modelDanhSachHoaDon.addColumn("Trạng thái");
		modelDanhSachHoaDon.addColumn("Ghi chú");
		tableDanhSachHoaDON.setModel(modelDanhSachHoaDon);

		modelDanhSachSanPham.addColumn("Mã sản phẩm");
		modelDanhSachSanPham.addColumn("Tên sản phẩm");
		modelDanhSachSanPham.addColumn("Loại");
		modelDanhSachSanPham.addColumn("Đơn giá");
		modelDanhSachSanPham.addColumn("Size");
		modelDanhSachSanPham.addColumn("Màu sắc");
		modelDanhSachSanPham.addColumn("Số lượng mua");
		tableDanhSachSanPham.setModel(modelDanhSachSanPham);

		txtTimKiem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTimKiem.getText().equals(" Tìm theo mã khách hàng")) {
					txtTimKiem.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTimKiem.getText().equals("")) {
					txtTimKiem.setText(" Tìm theo mã khách hàng");
				}
			}
		});
		
		tableDanhSachHoaDON.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(modelDanhSachHoaDon.getRowCount() >= 0) {
					String soLuong = JOptionPane.showInputDialog("Nhập số lượng cần hoàn trả");
				}
			}
		});
	}

	public void close() {
		this.setVisible(false);
	}
}
