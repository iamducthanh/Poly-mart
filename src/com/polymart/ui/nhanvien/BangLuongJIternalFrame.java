package com.polymart.ui.nhanvien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.polymart.dao.impl.ChamCongDAO;
import com.polymart.model.BangLuongModel;
import com.polymart.model.ChamCongModel;
import com.polymart.model.NhanVienModel;
import com.toedter.calendar.JMonthChooser;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BangLuongJIternalFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6467611389997317862L;
	private JPanel contentPane;
	JPanel panel = new JPanel();
	private JTable tableBangLuong;
	DefaultTableModel modelBangLuong = new DefaultTableModel();
	private List<ChamCongModel> listChamCong = new ArrayList();
	private List<NhanVienModel> listNhanVien = new ArrayList();
	private List<BangLuongModel> listBangLuong = new ArrayList();

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		contentPane.add(panel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);

		JLabel lblNhanVien = new JLabel("  Bảng lương            ");
		lblNhanVien.setFont(new Font("Tahoma", Font.BOLD, 18));

		JButton btnNewButton = new JButton("Lưu");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addComponent(lblNhanVien)
						.addPreferredGap(ComponentPlacement.RELATED, 755, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNhanVien, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		panel.setLayout(gl_panel);

		JLabel lblNewLabel = new JLabel("Năm");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JComboBox cbbNam = new JComboBox();

		JLabel lblThng = new JLabel("Tháng");
		lblThng.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JComboBox cbbNam_1 = new JComboBox();

		JButton btnNewButton_1 = new JButton("Xem lương");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap(28, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup().addGap(10)
										.addComponent(cbbNam, GroupLayout.PREFERRED_SIZE, 159,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(Alignment.TRAILING,
										gl_panel_1.createSequentialGroup()
												.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 183,
														GroupLayout.PREFERRED_SIZE)
												.addContainerGap())))
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap(28, Short.MAX_VALUE).addGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING,
								gl_panel_1.createSequentialGroup()
										.addComponent(lblThng, GroupLayout.PREFERRED_SIZE, 183,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
						.addGroup(gl_panel_1.createSequentialGroup().addGap(10)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnNewButton_1).addComponent(cbbNam_1, GroupLayout.PREFERRED_SIZE,
												158, GroupLayout.PREFERRED_SIZE))
								.addContainerGap()))));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(14).addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cbbNam, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(lblThng, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cbbNam_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE).addGap(61)
						.addComponent(btnNewButton_1).addContainerGap(352, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		tableBangLuong = new JTable();
		scrollPane.setViewportView(tableBangLuong);
		modelBangLuong.addColumn("Mã nhân viên");
		modelBangLuong.addColumn("Tên nhân viên");
		modelBangLuong.addColumn("Số ngày làm việc");
		modelBangLuong.addColumn("Số ngày Đi Làm Muộn");
		modelBangLuong.addColumn("Tổng lương");
		modelBangLuong.addColumn("Thanh Toán");
		tableBangLuong.setModel(modelBangLuong);
		loadListChamCongThang();

		// cbb Năm load từ dữ liệu ở bảng chấm công lên
		// cbb Tháng load theo cbb Năm cũng trong bảng chấm công
	}

	private void loadListChamCong(String nam, String thang) {
		listChamCong.clear();
		ChamCongDAO chamCongDao = new ChamCongDAO();
		listChamCong = chamCongDao.filterMonth(nam, thang);
	}

	private void loadListChamCongThang() {
		listChamCong.clear();
		Calendar c = Calendar.getInstance();
		String nam = String.valueOf(c.get(Calendar.YEAR));
		String thang = String.valueOf(c.get(Calendar.MONTH));
		loadListChamCong(nam, thang);
	}

	private void loadListNhanVien() {
		listNhanVien.clear();
		for (ChamCongModel chamCongModel : listChamCong) {
			NhanVienModel nhanVien = new NhanVienModel();
			nhanVien.setId(chamCongModel.getIdNhanVien());
			nhanVien.setHoTen(chamCongModel.getHoTen());
			for (NhanVienModel x : listNhanVien) {
				if (nhanVien.getId() == x.getId()) {
					break;
				} else {
					listNhanVien.add(nhanVien);
				}
			}
		}
	}

	private void loadListBangLuong() {
		listBangLuong.clear();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
		for (NhanVienModel nhanVien : listNhanVien) {
			int soNgayDilam = 0;
			int soNgayDiMuon = 0;
			for (ChamCongModel chamCong : listChamCong) {
				if (nhanVien.getId() == chamCong.getIdNhanVien()) {
					int i = 0;
					try {
						i = chamCong.getNgayChamCong().compareTo(sdf.parse("8:00:00"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					if (i == 1) {
						soNgayDiMuon++;
					}
					soNgayDilam++;
				}
			}
			BangLuongModel bangLuong = new BangLuongModel();
			bangLuong.setHoTen(nhanVien.getHoTen());
			bangLuong.setMaNhanVien(nhanVien.getId());
			bangLuong.setSoNgayDiLam(soNgayDilam);
			bangLuong.setSoNgayDiMuon(soNgayDiMuon);
			listBangLuong.add(bangLuong);
		}
	}

	public void loadTbaleLuong() {
		modelBangLuong.setRowCount(0);
		for(BangLuongModel x : listBangLuong) {
			modelBangLuong.addRow(new Object[] {x.getMaNhanVien(),x.getHoTen(),x.getSoNgayDiLam(),x.getSoNgayDiMuon()});
		}
	}
}
