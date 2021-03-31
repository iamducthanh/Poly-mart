package com.polymart.ui.giaodich;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.polymart.model.NguonHangModel;
import com.polymart.service.INguonHangService;
import com.polymart.service.impl.NguonHangService;
import java.awt.SystemColor;

public class ThemNhapHangJInternalFrame extends JInternalFrame {

	private static final long serialVersionUID = -4001431086652454768L;

	private JPanel contentPane;
	JPanel panel = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel hangHoaJPanel = new JPanel();
	private JTable tableThemNhapHang;
	DefaultTableModel modelThemNhapHang = new DefaultTableModel();
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JTextField txtSoLuong;
	private JTextField txtDonGia;
	private INguonHangService nguonHangService = new NguonHangService();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemNhapHangJInternalFrame frame = new ThemNhapHangJInternalFrame();
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
	public ThemNhapHangJInternalFrame() {
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
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JButton btnQuayLai = new JButton("<-   ");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnQuayLai.setContentAreaFilled(false);
		btnQuayLai.setBorder(null);
		btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_1.add(btnQuayLai);

		JLabel lblNewLabel = new JLabel("Nhập hàng           ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_1.add(lblNewLabel);

		JComboBox<Object> cbbTimSanPham = new JComboBox<Object>();
		cbbTimSanPham.setBackground(SystemColor.control);
		cbbTimSanPham.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbTimSanPham.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "Tìm theo mã sản phẩm                                   ", "203497", "652353", "675423",
						"234543", "234569", "049345", "096853", "097565" }));
		panel_1.add(cbbTimSanPham);

		AutoCompleteDecorator.decorate(cbbTimSanPham);
		// sau khi chọn đc mã sản phẩm sẽ load dữ liệu của sản phẩm đó sang thông tin
		// bên phải

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.EAST);

		JComboBox<Object> cbbNguonHang = new JComboBox<Object>();
		cbbNguonHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbNguonHang.setModel(new DefaultComboBoxModel<Object>(new String[] { "Chọn nguồn hàng" }));

		JButton btnLuuTam = new JButton("Lưu tạm");
		btnLuuTam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Sau khi ấn lưu tạm sẽ thêm vào bảng bên trái và tính lại thành tiền

			}
		});

		JButton btnHoanThanh = new JButton("Hoàn thành");
		btnHoanThanh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ấn hoàn thành sẽ lấy tên người đang đăng nhập, ngày, nguồn hàng

			}
		});

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Th\u00F4ng tin s\u1EA3n ph\u1EA9m", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.BLACK));

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Thành tiền", JLabel.RIGHT);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblNewLabel_2 = new JLabel("10 củ", JLabel.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 22));

		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Ghi chú");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup().addContainerGap().addGroup(gl_panel_2
						.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup().addGroup(gl_panel_2
								.createParallelGroup(Alignment.LEADING)
								.addComponent(cbbNguonHang, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_2.createSequentialGroup().addGap(125)
										.addComponent(btnLuuTam, GroupLayout.PREFERRED_SIZE, 89,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnHoanThanh)))
								.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup().addGap(103)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 201,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 79,
												GroupLayout.PREFERRED_SIZE))
								.addGap(19))
						.addGroup(gl_panel_2.createSequentialGroup()
								.addComponent(lblNewLabel_1_1_1_1_2, GroupLayout.PREFERRED_SIZE, 201,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(122, Short.MAX_VALUE))))
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup().addGap(20)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE).addContainerGap()));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
						.addComponent(cbbNguonHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblNewLabel_1_1_1_1_2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1_1_1_1_1).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblNewLabel_2).addGap(40)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnHoanThanh, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLuuTam, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		JTextArea txtGhiChu = new JTextArea();
		scrollPane_1.setViewportView(txtGhiChu);

		JLabel lblNewLabel_1 = new JLabel("Mã sản phẩm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

		txtMaSP = new JTextField();
		txtMaSP.setEditable(false);
		txtMaSP.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Tên sản phẩm");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

		txtTenSP = new JTextField();
		txtTenSP.setEditable(false);
		txtTenSP.setColumns(10);

		JLabel lblNewLabel_1_1_1 = new JLabel("Số lượng");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Đơn giá");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

		txtDonGia = new JTextField();
		txtDonGia.setEditable(false);
		txtDonGia.setColumns(10);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_3
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup().addGap(10).addComponent(txtMaSP,
								GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_3.createSequentialGroup().addGap(10).addComponent(txtTenSP,
								GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
						.addGroup(gl_panel_3.createSequentialGroup().addGap(10).addComponent(txtSoLuong,
								GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
						.addGroup(gl_panel_3.createSequentialGroup().addGap(10).addComponent(txtDonGia,
								GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)))
				.addContainerGap()));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addGap(5).addComponent(lblNewLabel_1)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtMaSP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtTenSP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtSoLuong, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtDonGia, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(30, Short.MAX_VALUE)));
		panel_3.setLayout(gl_panel_3);
		panel_2.setLayout(gl_panel_2);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		tableThemNhapHang = new JTable();
		scrollPane.setViewportView(tableThemNhapHang);
		modelThemNhapHang.addColumn("Mã sản phẩm");
		modelThemNhapHang.addColumn("Tên sản phẩm");
		modelThemNhapHang.addColumn("Số lượng");
		modelThemNhapHang.addColumn("Đơn giá");
		modelThemNhapHang.addColumn("Thành tiền");
		tableThemNhapHang.setModel(modelThemNhapHang);

		setCbbNguonHang(nguonHangService.findAll(), cbbNguonHang);

	}

	public void close() {
		this.setVisible(false);
	}

	private void setCbbNguonHang(List<NguonHangModel> lstNguonHang, JComboBox<Object> cbbNguonHang) {
		if (lstNguonHang != null && !lstNguonHang.isEmpty()) {
			cbbNguonHang.removeAll();
			List<String> tenNguonHang = lstNguonHang.stream().map(e -> e.getTenNguonHang())
					.collect(Collectors.toList());
			tenNguonHang.stream().forEach(System.out::println);
			tenNguonHang.forEach(x -> {
				cbbNguonHang.addItem(x);
			});
		}
	}
}
