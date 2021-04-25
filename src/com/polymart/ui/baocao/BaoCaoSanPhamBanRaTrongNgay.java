package com.polymart.ui.baocao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.polymart.dao.impl.BaoCaoSanPhamBanRaDao;
import com.polymart.dao.impl.SanPhamDAO;
import com.polymart.model.BaoCaoNgayModel;
import com.polymart.model.SanPhamModel;
import com.polymart.service.ISanPhamService;
import com.polymart.service.impl.SanPhamService;
import com.toedter.calendar.JCalendar;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BaoCaoSanPhamBanRaTrongNgay extends JInternalFrame {

	private static final long serialVersionUID = 1619911861884761168L;

	private JPanel contentPane;
	private DefaultTableModel modelBaoCao = new DefaultTableModel();
	private JPanel panel = new JPanel();
	private JPanel nhanVienJPanel = new JPanel();
	private JTable tableBaoCao;
	JCalendar dateNgayBaoCao;
	private Calendar calendar;
	JLabel lblTongThu = new JLabel("0");
	JLabel lblTongChi = new JLabel("0");
	JLabel lblTong = new JLabel("0");
	List<BaoCaoNgayModel> list = new ArrayList<BaoCaoNgayModel>();
	private ISanPhamService sanPhamService = new SanPhamService();
	BaoCaoSanPhamBanRaDao baoCaoDao= new BaoCaoSanPhamBanRaDao();
	static String IDSanPham;
	static String nameSP;
	static Calendar ngayBaoCao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaoCaoSanPhamBanRaTrongNgay frame = new BaoCaoSanPhamBanRaTrongNgay();
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
	public BaoCaoSanPhamBanRaTrongNgay() {
		calendar = Calendar.getInstance();
		((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1169, 801);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(75, 0, 130));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		panel.setBackground(Color.WHITE);

		contentPane.add(panel, BorderLayout.NORTH);

		initTopChamCong();
		initCenterChamCong();
		 ThuChiHienTai();

		tableBaoCao.setRowHeight(25);
	}

	public void initTopChamCong() {
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(75, 0, 130));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1149, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		JLabel lblNhanVien = new JLabel("Báo cáo sản phẩm bán ra trong ngày");
		lblNhanVien.setForeground(new Color(255, 255, 255));
		lblNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNhanVien, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(839, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNhanVien, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
	}

	public void initCenterChamCong() {
		nhanVienJPanel.setLayout(new BoxLayout(nhanVienJPanel, BoxLayout.Y_AXIS));
		JLabel lblNewLabel_2 = new JLabel("Loại hàng             ▼");
		lblNewLabel_2.setFont(new Font("Consolas", Font.BOLD, 14));
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		tableBaoCao = new JTable();
		tableBaoCao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int select = tableBaoCao.getSelectedRow();
				IDSanPham = String.valueOf(tableBaoCao.getValueAt(select, 0));
				nameSP = String.valueOf(tableBaoCao.getValueAt(select, 1));
				ChiTietBaoCaoFrame chiTietBaoCaoFrame = new ChiTietBaoCaoFrame();
				chiTietBaoCaoFrame.setVisible(true);
				chiTietBaoCaoFrame.setLocationRelativeTo(null);
			}
		});
		tableBaoCao.setBackground(Color.WHITE);
		scrollPane.setViewportView(tableBaoCao);
		modelBaoCao.addColumn("Mã sản phẩm");
		modelBaoCao.addColumn("Tên sản phẩm");
		modelBaoCao.addColumn("Tổng số lượng bán");
		modelBaoCao.addColumn("Tổng số Hiện Tại Còn Trong kho");
		modelBaoCao.addColumn("Số Lượng Bán Ra Trong Tháng");
		modelBaoCao.addColumn("Số Lượng Trung Bình");
		
		
		tableBaoCao.setModel(modelBaoCao);


//		tableBaoCao.getColumnModel().getColumn(3).setPreferredWidth(30);
//		tableBaoCao.getColumnModel().getColumn(4).setPreferredWidth(30);
//		tableBaoCao.getColumnModel().getColumn(5).setPreferredWidth(30);
//		tableBaoCao.getColumnModel().getColumn(6).setPreferredWidth(30);
//		tableBaoCao.getColumnModel().getColumn(7).setPreferredWidth(30);
//		tableBaoCao.getColumnModel().getColumn(8).setPreferredWidth(30);
//		tableBaoCao.getColumnModel().getColumn(9).setPreferredWidth(30);

		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(Color.WHITE);
		contentPane.add(panelLeft, BorderLayout.WEST);

		dateNgayBaoCao = new JCalendar();
		dateNgayBaoCao.getDayChooser().getDayPanel().setBackground(Color.WHITE);
		dateNgayBaoCao.getYearChooser().getSpinner().setFont(new Font("Tahoma", Font.PLAIN, 13));
		dateNgayBaoCao.getDayChooser().addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName().equals("day")) {
					timKiemTheoNgay();
					ngayBaoCao=dateNgayBaoCao.getCalendar();
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Tổng Thu");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		JLabel lblNewLabel_3 = new JLabel("Tổng Chi");
		
		lblTongThu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTongThu.setForeground(Color.RED);
		
		
		lblNewLabel_3.setForeground(Color.GREEN);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		
		lblTongChi.setForeground(Color.RED);
		
		JLabel lblNewLabel_7 = new JLabel("Tổng ");
		lblNewLabel_7.setForeground(Color.GREEN);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
	
		lblTong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTong.setForeground(Color.RED);

		GroupLayout gl_panelLeft = new GroupLayout(panelLeft);
		gl_panelLeft.setHorizontalGroup(
			gl_panelLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLeft.createSequentialGroup()
					.addGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelLeft.createSequentialGroup()
							.addContainerGap()
							.addComponent(dateNgayBaoCao, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
						.addGroup(gl_panelLeft.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
								.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
							.addGap(39)
							.addGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTong, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTongChi, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTongThu, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panelLeft.setVerticalGroup(
			gl_panelLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLeft.createSequentialGroup()
					.addContainerGap()
					.addComponent(dateNgayBaoCao, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addGap(73)
					.addGroup(gl_panelLeft.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTongThu, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblTongChi, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
					.addGap(103)
					.addGroup(gl_panelLeft.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTong, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(174, Short.MAX_VALUE))
		);
		panelLeft.setLayout(gl_panelLeft);

	}
	protected void timKiemTheoNgay() {
		Calendar c = dateNgayBaoCao.getCalendar();
		String nam = String.valueOf(c.get(Calendar.YEAR));
		String thang = String.valueOf(c.get(Calendar.MONDAY)+1);
		String ngay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		loadList(nam, thang, ngay);
		loabtable(nam, thang, Integer.parseInt(ngay));
		ThuChi(nam, thang, ngay);
		
	}

	public void loadList(String nam , String thang, String ngay) {
		list.clear();
//		Calendar c = Calendar.getInstance();
//		String nam = String.valueOf(c.get(Calendar.YEAR));
//		String thang = String.valueOf(c.get(Calendar.MONDAY)+1);
//		String ngay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		list = baoCaoDao.finAll(nam,thang,ngay);
		
	}
	public void loabtable(String nam ,String thang, int day)  {
		modelBaoCao.setRowCount(0);
//		Calendar c = Calendar.getInstance();
//		String nam = String.valueOf(c.get(Calendar.YEAR));
//		String thang = String.valueOf(c.get(Calendar.MONDAY)+1);
//		int day = c.get(Calendar.DAY_OF_MONTH);
		float d = day;
		for (BaoCaoNgayModel baoCaoNgayModel : list) {
			SanPhamModel sanPhamModel = sanPhamService.findByID(baoCaoNgayModel.getIdSanPham());
			int soLuongBanRaTrongThang = baoCaoDao.tbSoLuongBanRa(nam,thang,baoCaoNgayModel.getIdSanPham());
			float a =soLuongBanRaTrongThang/d;
			float tb = Math.round(a*100);
			modelBaoCao.addRow(new Object[] {baoCaoNgayModel.getIdSanPham(),sanPhamModel.getTenSP(),baoCaoNgayModel.getSoLuongBanRa(),
					baoCaoDao.soLuongTrongKho(baoCaoNgayModel.getIdSanPham())
					,soLuongBanRaTrongThang,tb/100});
		}
	}
	public void ThuChi(String nam , String thang, String ngay) {
//		Calendar c = Calendar.getInstance();
//		String nam = String.valueOf(c.get(Calendar.YEAR));
//		String thang = String.valueOf(c.get(Calendar.MONDAY)+1);
//		String ngay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		lblTongThu.setText(dinhDangMonney(baoCaoDao.tongThu(nam, thang,ngay)));
		lblTongChi.setText(dinhDangMonney(baoCaoDao.tongChi(nam, thang,ngay)));
		lblTong.setText(dinhDangMonney(baoCaoDao.tongThu(nam, thang,ngay)-baoCaoDao.tongChi(nam, thang,ngay)));
		
	}
	public void ThuChiHienTai() {
		Calendar c = Calendar.getInstance();
		String nam = String.valueOf(c.get(Calendar.YEAR));
		String thang = String.valueOf(c.get(Calendar.MONDAY)+1);
		String ngay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		loadList(nam, thang, ngay);
		loabtable(nam, thang, Integer.parseInt(ngay));
		ThuChi(nam, thang, ngay);
	}
	public String dinhDangMonney(long l) {
		Locale locale = new Locale("vi","VN");
		NumberFormat format = NumberFormat.getCurrencyInstance(locale);
		return format.format(l);
	}
}
