package com.polymart.ui.giaodich;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.polymart.entity.EntityValidate;
import com.polymart.model.ChiTietHoaDonNhapHangModel;
import com.polymart.service.IChiTietSanPhamService;
import com.polymart.service.ISanPhamService;
import com.polymart.service.impl.ChiTietSanPhamService;
import com.polymart.service.impl.SanPhamService;

import javax.swing.JTextArea;

public class ChiTietHoaDonNhapHangFrame extends JFrame {

	private static final long serialVersionUID = -1275654074282876688L;

	private JPanel contentPane;
	private JTable tableChiTietHoaDonNhap;
	private DefaultTableModel modelChiTietHoaDonNhap;

	private JLabel lblMaHoaDon;
	private JLabel lblTenNguonHang;
	private JTextArea txtGhiChu;

	private ISanPhamService sanPhamService = new SanPhamService();
	private IChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamService();

	public ChiTietHoaDonNhapHangFrame() throws HeadlessException {
		init();
	}

	public ChiTietHoaDonNhapHangFrame(List<ChiTietHoaDonNhapHangModel> lstChiTietHoaDonNhapHang, String nguonHang,
			String ghiChu) {
		init();
		setForm(lstChiTietHoaDonNhapHang, nguonHang, ghiChu, lblMaHoaDon, lblTenNguonHang, txtGhiChu);
	}

	private void init() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\fpt.png"));
		modelChiTietHoaDonNhap = new DefaultTableModel() {

			private static final long serialVersionUID = 7584408658853210846L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		setTitle("Chi tiết hóa đơn nhập hàng");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
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

		lblMaHoaDon = new JLabel("Cái label này để hiển thị mã hóa đơn nhập hàng");
		lblMaHoaDon.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaHoaDon.setBounds(210, 61, 387, 25);
		contentPane.add(lblMaHoaDon);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 247, 819, 299);
		contentPane.add(scrollPane);

		tableChiTietHoaDonNhap = new JTable();
		scrollPane.setViewportView(tableChiTietHoaDonNhap);

		JLabel lblNewLabel_1_1 = new JLabel("Nguồn hàng:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(30, 96, 170, 25);
		contentPane.add(lblNewLabel_1_1);

		lblTenNguonHang = new JLabel("Cái label này để hiển thị nguồn hàng");
		lblTenNguonHang.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenNguonHang.setBounds(136, 97, 387, 25);
		contentPane.add(lblTenNguonHang);

		modelChiTietHoaDonNhap.addColumn("Mã sản phẩm");
		modelChiTietHoaDonNhap.addColumn("Tên sản phẩm");
		modelChiTietHoaDonNhap.addColumn("Số lượng");
		modelChiTietHoaDonNhap.addColumn("Đơn giá");
		modelChiTietHoaDonNhap.addColumn("Thành tiền");
		tableChiTietHoaDonNhap.setModel(modelChiTietHoaDonNhap);

		JLabel lblNewLabel_1_1_1 = new JLabel("Ghi chú:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(30, 132, 87, 25);
		contentPane.add(lblNewLabel_1_1_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(146, 132, 451, 100);
		contentPane.add(scrollPane_1);

		txtGhiChu = new JTextArea();
		txtGhiChu.setEditable(false);
		scrollPane_1.setViewportView(txtGhiChu);
	}


	private void setForm(List<ChiTietHoaDonNhapHangModel> lstChiTietHoaDonNhapHang, String nguonHang, String ghiChu,
			JLabel lblMaHoaDon, JLabel lblTenNguonHang, JTextArea txtGhiChu) {
		if (lstChiTietHoaDonNhapHang != null && !lstChiTietHoaDonNhapHang.isEmpty()) {
			lblMaHoaDon.setText(lstChiTietHoaDonNhapHang.get(0).getIdHoaDonNhapHang().toString());
			lblTenNguonHang.setText(nguonHang);
			txtGhiChu.setText(ghiChu);
			for (ChiTietHoaDonNhapHangModel x : lstChiTietHoaDonNhapHang) {
				modelChiTietHoaDonNhap.addRow(new Object[] { x.getIdChiTietSanPham(),
						sanPhamService.findByID(chiTietSanPhamService.getIdProductById(x.getIdChiTietSanPham()))
								.getTenSP(),
						x.getSoLuong(), EntityValidate.dinhDangMonney(x.getGiaNhap()),
						EntityValidate.dinhDangMonney(x.getGiaNhap() * x.getSoLuong()) });
			}
		}
		tableChiTietHoaDonNhap.setRowHeight(25);
	}
}
