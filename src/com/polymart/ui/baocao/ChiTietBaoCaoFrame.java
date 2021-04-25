package com.polymart.ui.baocao;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.polymart.dao.impl.BaoCaoSanPhamBanRaDao;
import com.polymart.dao.impl.ChiTietSanPhamDAO;
import com.polymart.model.ChiTietSanPhamModel;
import java.awt.Color;

public class ChiTietBaoCaoFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5719522712034557393L;
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel modelBaoCaoSP = new DefaultTableModel();
	JLabel lblMaSP = new JLabel("label mã sản phẩm");
	JLabel lblTenSanPham = new JLabel("New label");
	List<ChiTietSanPhamModel> list = new ArrayList<ChiTietSanPhamModel>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiTietBaoCaoFrame frame = new ChiTietBaoCaoFrame();
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
	public ChiTietBaoCaoFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 817, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Chi tiết báo cáo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 243, 25);
		contentPane.add(lblNewLabel);

		JLabel lblMSnPhm = new JLabel("Mã sản phẩm: ");
		lblMSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMSnPhm.setBounds(10, 44, 129, 25);
		contentPane.add(lblMSnPhm);
		lblMaSP.setForeground(Color.RED);

		lblMaSP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMaSP.setBounds(133, 46, 243, 25);
		contentPane.add(lblMaSP);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 97, 783, 359);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		modelBaoCaoSP.addColumn("Mã Sản Phẩm Chi Tiết");
		modelBaoCaoSP.addColumn("Size");
		modelBaoCaoSP.addColumn("Màu sắc");
		modelBaoCaoSP.addColumn("Số lượng bán");
		modelBaoCaoSP.addColumn("Số lượng Trong Kho");
		modelBaoCaoSP.addColumn("Giá bán");
		modelBaoCaoSP.addColumn("Giá Giảm");
		table.setModel(modelBaoCaoSP);

		JLabel lblNewLabel_1 = new JLabel("Tên Sản Phẩm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(396, 52, 96, 25);
		contentPane.add(lblNewLabel_1);
		lblTenSanPham.setForeground(Color.RED);

		lblTenSanPham.setBounds(504, 44, 184, 35);
		contentPane.add(lblTenSanPham);
		loabTable();
	}

	public void loabTable() {
		modelBaoCaoSP.setRowCount(0);
		list.clear();
		Calendar c =null ;
		if (BaoCaoSanPhamBanRaTrongNgay.ngayBaoCao == null) {
			c=Calendar.getInstance();
		}else {
			c=BaoCaoSanPhamBanRaTrongNgay.ngayBaoCao;
		}
		String nam = String.valueOf(c.get(Calendar.YEAR));
		String thang = String.valueOf(c.get(Calendar.MONTH) + 1);
		String ngay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		ChiTietSanPhamDAO chiTiet = new ChiTietSanPhamDAO();
		BaoCaoSanPhamBanRaDao baoCaoDao = new BaoCaoSanPhamBanRaDao();
		list = chiTiet.findSanPhamBanRaTrongNgay(nam, thang, ngay,
				Integer.parseInt(BaoCaoSanPhamBanRaTrongNgay.IDSanPham));
		lblMaSP.setText(BaoCaoSanPhamBanRaTrongNgay.IDSanPham);
		lblTenSanPham.setText(BaoCaoSanPhamBanRaTrongNgay.nameSP);
		for (ChiTietSanPhamModel x : list) {
			int soLuong = baoCaoDao.soLuongBanRaChiTiet(nam, thang, ngay, x.getId());
			modelBaoCaoSP.addRow(new Object[] { x.getId(), x.getSize(), x.getMauSac(), soLuong, x.getSoLuong(),
					x.getGiaBan(), x.getGiaGiam() });
		}
	}

}
