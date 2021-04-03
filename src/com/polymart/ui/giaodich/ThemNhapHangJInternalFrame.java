package com.polymart.ui.giaodich;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.List;

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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.polymart.entity.EntityMessage;
import com.polymart.entity.EntityValidate;
import com.polymart.model.ChiTietHoaDonNhapHangModel;
import com.polymart.model.ChiTietSanPhamModel;
import com.polymart.model.NguonHangModel;
import com.polymart.service.IChiTietSanPhamService;
import com.polymart.service.INguonHangService;
import com.polymart.service.ISanPhamService;
import com.polymart.service.impl.ChiTietSanPhamService;
import com.polymart.service.impl.NguonHangService;
import com.polymart.service.impl.SanPhamService;

public class ThemNhapHangJInternalFrame extends JInternalFrame {

	private static final long serialVersionUID = -4001431086652454768L;

	private JPanel contentPane;
	private DefaultTableModel modelDSSanPham = new DefaultTableModel();
	private DefaultTableModel modelDSNhapHang = new DefaultTableModel();

	private JTextField txtTimKiem;
	private JTable tableDSSanPham;
	private JTextField txtSoLgNhap;
	private JTextField txtSoLuongNhap;
	private JTable tableDSNhapHang;

	private INguonHangService nguonHangService = new NguonHangService();
	private IChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamService();
	private ISanPhamService sanPhamService = new SanPhamService();

	private List<ChiTietSanPhamModel> lstTietSanPham = chiTietSanPhamService.findAll();
	private List<NguonHangModel> lstNguonHang = nguonHangService.findAll();

	JButton btnLuuTam = new JButton("Lưu tạm");
	JLabel lblNewLabel_1_1_1 = new JLabel("Số lượng nhập: ");
	private JTextField txtGiaNhap;

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

		txtSoLgNhap = new JTextField();

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

		JLabel lblNewLabel = new JLabel("Nhập hàng           ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimKiem.setText(" Tìm theo tên hoặc mã sản phẩm");
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

		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.NORTH);

		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.SOUTH);

		txtSoLuongNhap = new JTextField();
		txtSoLuongNhap.setColumns(10);

		JLabel lblSoLuongNhap = new JLabel("Số lượng nhập: ");
		lblSoLuongNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblGiaNhap = new JLabel("Giá nhập:");
		lblGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));

		txtGiaNhap = new JTextField();
		txtGiaNhap.setColumns(10);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup().addContainerGap()
						.addComponent(lblSoLuongNhap, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtSoLuongNhap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(17).addComponent(lblGiaNhap).addGap(28)
						.addComponent(txtGiaNhap, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
						.addGap(41).addComponent(btnLuuTam, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
						.addGap(1261)));
		gl_panel_4.setVerticalGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_4
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblGiaNhap, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtGiaNhap, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLuuTam, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
						.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSoLuongNhap, GroupLayout.PREFERRED_SIZE, 30,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSoLuongNhap, GroupLayout.PREFERRED_SIZE, 30,
										GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		panel_4.setLayout(gl_panel_4);

		lblSoLuongNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				" Th\u00F4ng tin s\u1EA3n ph\u1EA9m ", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_5.add(scrollPane, BorderLayout.CENTER);

		tableDSSanPham = new JTable();
		scrollPane.setViewportView(tableDSSanPham);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				" Nh\u1EADp h\u00E0ng ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel_2, BorderLayout.SOUTH);

		JScrollPane scrollPane_1 = new JScrollPane();

		JComboBox<Object> cbbNguonHang = new JComboBox<Object>();
		cbbNguonHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbNguonHang.setModel(new DefaultComboBoxModel<Object>(new String[] { "Chọn nguồn hàng" }));

		JLabel lblNewLabel_1_1 = new JLabel("Ghi chú");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JScrollPane scrollPane_2 = new JScrollPane();

		JLabel lblNewLabel_1 = new JLabel("Thành tiền", JLabel.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblTongTien = new JLabel("0.0", SwingConstants.RIGHT);
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 20));
		JButton btnHoanThanh = new JButton("Hoàn thành");

		JButton btnXoa = new JButton("- Xóa");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_2.createSequentialGroup().addContainerGap().addComponent(
										btnXoa, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE))
						.addGap(18)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_2
								.createSequentialGroup()
								.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addComponent(cbbNguonHang, GroupLayout.PREFERRED_SIZE, 265,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 201,
												GroupLayout.PREFERRED_SIZE))
								.addGap(81))
								.addGroup(gl_panel_2.createSequentialGroup()
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 122,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(gl_panel_2.createSequentialGroup()
										.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblTongTien, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(scrollPane_2, Alignment.TRAILING,
														GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
										.addContainerGap())
								.addGroup(
										gl_panel_2
												.createSequentialGroup().addComponent(btnHoanThanh,
														GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
												.addContainerGap()))));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_2
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_2.createSequentialGroup()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2
								.createSequentialGroup()
								.addComponent(cbbNguonHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNewLabel_1_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_1).addGap(18)
								.addComponent(lblTongTien, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE).addGap(5))
						.addGroup(gl_panel_2.createSequentialGroup()
								.addComponent(btnHoanThanh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGap(6)))));

		JTextArea txtGhiChu = new JTextArea();
		scrollPane_2.setViewportView(txtGhiChu);

		tableDSNhapHang = new JTable();
		scrollPane_1.setViewportView(tableDSNhapHang);
		panel_2.setLayout(gl_panel_2);
		modelDSSanPham.addColumn("Mã sản phẩm");
		modelDSSanPham.addColumn("Tên sản phẩm");
		modelDSSanPham.addColumn("Loại");
		modelDSSanPham.addColumn("Size");
		modelDSSanPham.addColumn("Màu sắc");
		modelDSSanPham.addColumn("Số lượng tồn kho");
		tableDSSanPham.setModel(modelDSSanPham);

		modelDSNhapHang.addColumn("Mã sản phẩm");
		modelDSNhapHang.addColumn("Tên sản phẩm");
		modelDSNhapHang.addColumn("Loại");
		modelDSNhapHang.addColumn("Giá nhập");
		modelDSNhapHang.addColumn("Size");
		modelDSNhapHang.addColumn("Màu sắc");
		modelDSNhapHang.addColumn("Số lượng nhập");
		tableDSNhapHang.setModel(modelDSNhapHang);

		txtTimKiem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTimKiem.getText().equals(" Tìm theo tên hoặc mã sản phẩm")) {
					txtTimKiem.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTimKiem.getText().equals("")) {
					txtTimKiem.setText(" Tìm theo tên hoặc mã sản phẩm");
				}
			}
		});

		// show dữ liệu lên table lúc khởi chạy chương trình
		showTable(lstTietSanPham);

		// show dữ liệu lên bảng khi click nút tìm kiếm
		btnTimKiem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				evtSearchProduct(txtTimKiem);
			}
		});

		// sự kiện lưu tạm sản phẩm vào bảng hàng nhập
		btnLuuTam.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				evtBtnLuuTam(txtSoLgNhap, tableDSSanPham, lblTongTien);
			}
		});

		// xóa một hàng trong bảng hàng nhập
		btnXoa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				evtBtnDelete(tableDSNhapHang);

			}
		});

		// hiển thị nguồn hàng vào combobox
		showNguonHang(cbbNguonHang, lstNguonHang);

	}

	public void close() {
		this.setVisible(false);
	}

	// sự kiện tìm kiếm sản phẩm theo tên sản phẩm hoặc mã sản phẩm
	private void evtSearchProduct(JTextField txtSearch) {
		String getInputSearch = txtSearch.getText();
		lstTietSanPham = chiTietSanPhamService.findByIdOrNameProduct(getInputSearch);
		if (lstTietSanPham != null && !lstTietSanPham.isEmpty()) {
			showTable(lstTietSanPham);
		} else {
			EntityMessage.show(this, "Không có sản phẩm nào cần tìm");
		}
	}

	// hiển thị dữ liệu lên bảng
	private void showTable(List<ChiTietSanPhamModel> lst) {
		modelDSSanPham.setRowCount(0);
		for (ChiTietSanPhamModel x : lst) {
			modelDSSanPham.addRow(new Object[] { x.getId(), sanPhamService.findNameByID(x.getIdSanPham()),
					"Loại chỉnh sửa sau", x.getSize(), x.getMauSac(), x.getSoLuong() });
		}
	}

	// lưu tạm sản phẩm vào hóa đơn nhập
	private void evtBtnLuuTam(JTextField txtSoLuong, JTable tbSanPham, JLabel lblTongTien) {
		String getSoLuong = txtSoLuong.getText();
		if (EntityValidate.checkPositiveNumber(this, getSoLuong)) {
			int row = tbSanPham.getSelectedRow();
			if (row > -1 && row < tbSanPham.getRowCount()) {
				ChiTietSanPhamModel chiTietSanPhamModel = lstTietSanPham.get(row);
				modelDSNhapHang.addRow(new Object[] { chiTietSanPhamModel.getId(),
						sanPhamService.findNameByID(chiTietSanPhamModel.getIdSanPham()), "Loại sửa sau",
						chiTietSanPhamModel.getGiaBan(), chiTietSanPhamModel.getSize(), chiTietSanPhamModel.getMauSac(),
						getSoLuong });
				Double tongTien = Double.parseDouble(lblTongTien.getText())
						+ (chiTietSanPhamModel.getGiaBan() * Integer.parseInt(getSoLuong));
				lblTongTien.setText(tongTien.toString());
			}
		}
	}

	// nút "Xóa" một hàng của bảng danh sách sản phẩm nhập
	private void evtBtnDelete(JTable tbDSNhapHang) {
		int row = tbDSNhapHang.getSelectedRow();
		if (row > -1 && row < tbDSNhapHang.getRowCount()) {
			modelDSNhapHang.removeRow(row);
		} else {
			EntityMessage.show(this, "Vui lòng chọn 1 hàng");
		}
	}

	// show nguồn hàng lên combobox
	private void showNguonHang(JComboBox cbcNguonHang, List<NguonHangModel> lstNguonHang) {
		cbcNguonHang.removeAllItems();
		if (lstNguonHang != null && !lstNguonHang.isEmpty()) {
			for (NguonHangModel x : lstNguonHang) {
				cbcNguonHang.addItem(x.getTenNguonHang());
			}
		}
	}

	// nút "Hoàn thành"
	private void evtBtnHoanThanh(JTable tbDSNhapHang, JComboBox cbcNguonHang, JTextArea txaGhiChu) {
		ChiTietHoaDonNhapHangModel cthdNhapHang = new ChiTietHoaDonNhapHangModel();

	}
}
