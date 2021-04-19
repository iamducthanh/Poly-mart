package com.polymart.ui.nhanvien;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.polymart.dao.impl.ChamCongDAO;
import com.polymart.dao.impl.ChiTieuDao;
import com.polymart.dao.impl.NhanVienDAO;
import com.polymart.entity.EntityAuthorization;
import com.polymart.entity.EntityMessage;
import com.polymart.model.BangLuongModel;
import com.polymart.model.ChamCongModel;
import com.polymart.model.ChiTieuModel;
import com.polymart.model.NhanVienModel;
import com.polymart.service.impl.NhanVienService;
import java.awt.Color;

public class BangLuongJIternalFrame extends JInternalFrame {

	private static final long serialVersionUID = 6467611389997317862L;

	private JPanel contentPane;
	JPanel panel = new JPanel();
	private JTable tableBangLuong;
	DefaultTableModel modelBangLuong = new DefaultTableModel();
	private List<ChamCongModel> listChamCong = new ArrayList<ChamCongModel>();
	private List<NhanVienModel> listNhanVien = new ArrayList<NhanVienModel>();
	private List<BangLuongModel> listBangLuong = new ArrayList<BangLuongModel>();
	JComboBox<Object> cboThang = new JComboBox<Object>();
	JComboBox<String> cboNam = new JComboBox<String>();
	JLabel lblBangLuong = new JLabel("  Bảng lương            ");
	JButton btnAdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BangLuongJIternalFrame frame = new BangLuongJIternalFrame();
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
	public BangLuongJIternalFrame() {
		((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1062, 662);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		panel.setBackground(Color.WHITE);

		contentPane.add(panel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.WEST);

		lblBangLuong.setFont(new Font("Tahoma", Font.BOLD, 18));

		btnAdd = new JButton("Thanh Toán");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				thanhToanLuongChoNhanVien();
				btnAdd.setEnabled(false);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblBangLuong, GroupLayout.PREFERRED_SIZE, 455, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 482, Short.MAX_VALUE)
					.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBangLuong, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);

		JLabel lblNewLabel = new JLabel("Năm");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblThng = new JLabel("Tháng");
		lblThng.setFont(new Font("Tahoma", Font.PLAIN, 15));

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_1
				.createSequentialGroup().addContainerGap(28, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(cboNam, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblThng, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
								.addComponent(cboThang, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(14).addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cboNam, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(lblThng, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cboThang, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(445, Short.MAX_VALUE)));
		cboThang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timKiemLuongTheoThang();
			}
		});
		cboThang.setModel(new DefaultComboBoxModel<Object>(new String[] { "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4",
				"Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12" }));
		panel_1.setLayout(gl_panel_1);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		tableBangLuong = new JTable();
		tableBangLuong.setBackground(Color.WHITE);
		scrollPane.setViewportView(tableBangLuong);
		modelBangLuong.addColumn("Mã nhân viên");
		modelBangLuong.addColumn("Tên nhân viên");
		modelBangLuong.addColumn("Số ngày làm việc");
		modelBangLuong.addColumn("Số ngày Đi Làm Muộn");
		modelBangLuong.addColumn("Số Ngày Về Sớm");
		modelBangLuong.addColumn("Tổng lương");
		tableBangLuong.setModel(modelBangLuong);
		loadComboboxNam();
		moBangLuongThangGanNhat();
		kiemTraLuu();
		tableBangLuong.setRowHeight(25);

		// cbb Năm load từ dữ liệu ở bảng chấm công lên
		// cbb Tháng load theo cbb Năm cũng trong bảng chấm công
	}

	// lưu Thanh Toán Lương Vào Bảng Chi Tiêu
	protected void thanhToanLuongChoNhanVien() {
//		if(kiemTraLuu()) {
//			EntityMessage.show(null, "Bạn Đã Hoàn Thành Thanh Toán Rồi Hãy Kiểm Tra Ở Bảng Chi Tiêu");
//			return;
//		}
		List<ChiTieuModel> listChiTieuModel = new ArrayList<ChiTieuModel>();
		for (int i = 0; i < tableBangLuong.getRowCount(); i++) {
			ChiTieuModel chiTieu = new ChiTieuModel();
			chiTieu.setMucDichChiTieu("Thanh Toán Lương ");
			chiTieu.setIdNhanVien(EntityAuthorization.USER.getId());
			chiTieu.setSoTien(Long.parseLong(String.valueOf(tableBangLuong.getValueAt(i, 5))));
			chiTieu.setGhiChu("Thanh Toán Lương Cho Nhân Viên " + String.valueOf(tableBangLuong.getValueAt(i, 1)));
			listChiTieuModel.add(chiTieu);
		}
		if (!EntityMessage.confirm(null, "Bạn Chắc Chắn Muốn Thanh Toán Lương Cho Nhân Viên")) {
			return;
		}
		ChiTieuDao chiTieuDao = new ChiTieuDao();
		for (ChiTieuModel x : listChiTieuModel) {
			chiTieuDao.save(x);
		}
		EntityMessage.show(null, "Đã Lưu Vào Mục Chi Tiêu");
	}

	public void kiemTraLuu() {
		ChiTieuDao chiTieuDao = new ChiTieuDao();
		List<ChiTieuModel> listChiTieuModel = new ArrayList<ChiTieuModel>();
		Calendar c = Calendar.getInstance();
		int nam = c.get(Calendar.YEAR);
		int thang = c.get(Calendar.MONTH) + 1;
		listChiTieuModel = chiTieuDao.findTraLuong(nam, thang);
		if (listChiTieuModel.size() > 0) {
			btnAdd.setEnabled(false);
		}

	}

	// Tìm Kiếm Lương Theo Tháng
	protected void timKiemLuongTheoThang() {
		String nam = cboNam.getSelectedItem().toString();
		String thang = cboThang.getSelectedItem().toString().replace("Tháng ", "");
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int moth = c.get(Calendar.MONTH);
		if (Integer.parseInt(thang) > moth && Integer.parseInt(nam) >= year) {
			EntityMessage.show(null, "Chưa Đến Tháng Tính Lương");
			return;
		}
		lblBangLuong.setText("Bảng Lương Tháng " + thang + " Năm " + nam);
		loadListChamCong(nam, thang);
		loadTbaleLuong();

	}

	// lấy năm trong sql luu vào combobox
	private void loadComboboxNam() {
		ChamCongDAO chamCongDao = new ChamCongDAO();
		List<String> listNam = new ArrayList<String>();
		listNam = chamCongDao.findNam();
		Vector<String> vector = new Vector<String>();
		for (String string : listNam) {
			vector.add(string);
		}
		cboNam.setModel(new DefaultComboBoxModel<String>(vector));
	}

	// mở Bảng Lương Tháng gần nhất
	private void moBangLuongThangGanNhat() {
		Calendar c = Calendar.getInstance();
		int nam = c.get(Calendar.YEAR);
		int thang = c.get(Calendar.MONTH);
		loadListChamCong(String.valueOf(nam), String.valueOf(thang));
		loadTbaleLuong();

		lblBangLuong.setText("Bảng Lương Tháng " + thang + " Năm " + nam);
		cboThang.setSelectedIndex(thang - 1);
		cboNam.setSelectedItem(String.valueOf(nam));

	}

	// load list Chấm Công
	private void loadListChamCong(String nam, String thang) {
		listChamCong.clear();
		ChamCongDAO chamCongDao = new ChamCongDAO();
		listChamCong = chamCongDao.filterMonth(nam, thang);
	}

	// load list Nhân Viên Của Tháng Chấm Công
	private void loadListNhanVien() {
		listNhanVien.clear();
		List<NhanVienModel> list = new ArrayList<NhanVienModel>();
		NhanVienDAO nhanVienService = new NhanVienDAO();
		try {
			list = nhanVienService.findAllNhanVien();
		} catch (Exception e) {
		}
		for (NhanVienModel x : list) {
			boolean check = true;
			for (ChamCongModel chamCongModel : listChamCong) {
				if (String.valueOf(chamCongModel.getIdNhanVien()).equals(String.valueOf(x.getId()))) {
					check = false;
					break;
				}
			}
			if (check == false) {
				listNhanVien.add(x);
			}
		}

	}

	// load list của bảng lương
	private void loadListBangLuong() {
		listBangLuong.clear();
		loadListNhanVien();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
		for (NhanVienModel nhanVien : listNhanVien) {
			int soNgayDilam = 0;
			int soNgayDiMuon = 0;
			int soNgayVeSom = 0;
			for (ChamCongModel chamCong : listChamCong) {
				if (String.valueOf(nhanVien.getId()).equals(String.valueOf(chamCong.getIdNhanVien()))
						&& chamCong.getGioRa() != null) {
					int i = 0;
					int j = 0;
					try {
						i = sdf.parse(sdf.format(chamCong.getNgayChamCong())).compareTo(sdf.parse("8:00:00 AM"));
						j = sdf.parse(sdf.format(chamCong.getGioRa())).compareTo(sdf.parse("9:00:00 PM"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					if (i == 1) {
						soNgayDiMuon++;
					}
					if(j==-1) {
						soNgayVeSom++;
					}
					soNgayDilam++;
				}
			}
			BangLuongModel bangLuong = new BangLuongModel();
			bangLuong.setHoTen(nhanVien.getHoTen());
			bangLuong.setMaNhanVien(nhanVien.getId());
			bangLuong.setLuong(nhanVien.getLuong());
			bangLuong.setSoNgayDiLam(soNgayDilam);
			bangLuong.setSoNgayDiMuon(soNgayDiMuon);
			bangLuong.setSoNgayVeSom(soNgayVeSom);
			listBangLuong.add(bangLuong);
		}
	}

	// hiện thị table bảng lương
	public void loadTbaleLuong() {
		modelBangLuong.setRowCount(0);
		if (listChamCong.size() == 0) {
			return;
		}
		loadListBangLuong();
		for (BangLuongModel x : listBangLuong) {
			Long tongLuong;
			if (x.getSoNgayDiLam() >= 28) {
				tongLuong = x.getLuong();
			} else {
				tongLuong = x.getLuong() - ((28 - x.getSoNgayDiLam()) * 200000);
			}
			if (x.getSoNgayDiMuon() > 0) {
				tongLuong = tongLuong - x.getSoNgayDiMuon() * 100000;
			}
			if(x.getSoNgayVeSom()>0) {
				tongLuong = tongLuong - x.getSoNgayVeSom()*100000;
			}
			modelBangLuong.addRow(new Object[] { x.getMaNhanVien(), x.getHoTen(), x.getSoNgayDiLam(),
					x.getSoNgayDiMuon(),x.getSoNgayVeSom(), tongLuong });
		}
	}
}
