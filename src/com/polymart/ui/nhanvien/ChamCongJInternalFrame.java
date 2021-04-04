package com.polymart.ui.nhanvien;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

import com.polymart.dao.impl.ChamCongDAO;
import com.polymart.entity.EntityMessage;
import com.polymart.model.ChamCongModel;
import com.polymart.model.NhanVienModel;
import com.polymart.service.INhanVienService;
import com.polymart.service.impl.NhanVienService;
import com.toedter.calendar.JCalendar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChamCongJInternalFrame extends JInternalFrame {

	private static final long serialVersionUID = 1619911861884761168L;

	private JPanel contentPane;
	private DefaultTableModel modelChamCong = new DefaultTableModel();
	private DefaultTableModel modelNhanVienChamCong = new DefaultTableModel();
	private JTextField txtTimKiem;
	private JPanel panel = new JPanel();
	private JPanel nhanVienJPanel = new JPanel();
	private JTable tableChamCong;
	private JTable tableNhanVienChamCong;
	JButton btnChamCong = new JButton("Chấm công");
	JButton btnAdd = new JButton("Lưu chấm công");
	JButton btnXoa = new JButton("    -  Xóa     ");
	private int maNhanVien;
	private String hoTen;
	JCalendar dateChamCong;
	private Calendar calendar;

	private List<NhanVienModel> listNhanVien;
	private List<ChamCongModel> listChamCong = new ArrayList<ChamCongModel>();
	List<ChamCongModel> listLuuChamCong = new ArrayList<ChamCongModel>();
	private INhanVienService nhanVienService = new NhanVienService();
	private JPanel panel1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChamCongJInternalFrame frame = new ChamCongJInternalFrame();
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
	public ChamCongJInternalFrame() {
		calendar = Calendar.getInstance();
		((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1169, 801);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		initTopChamCong();
		initCenterChamCong();
		loadToTable();
		loadListChamCongNgay();
		loadTableChamCong();
	}

	public void initTopChamCong() {
		setTitle("Nhân viên - Chấm công");
		JLabel lblNhanVien = new JLabel("Chấm công                        ");
		lblNhanVien.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNhanVien, BorderLayout.WEST);

		panel1 = new JPanel();
		panel.add(panel1, BorderLayout.EAST);
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_1 = new JLabel(String.format("%100s", " "));
		panel1.add(lblNewLabel_1);

	}

	public void initCenterChamCong() {
		nhanVienJPanel.setLayout(new BoxLayout(nhanVienJPanel, BoxLayout.Y_AXIS));
		JLabel lblNewLabel_2 = new JLabel("Loại hàng             ▼");
		lblNewLabel_2.setFont(new Font("Consolas", Font.BOLD, 14));
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		tableChamCong = new JTable();
		scrollPane.setViewportView(tableChamCong);
		modelChamCong.addColumn("Mã nhân viên");
		modelChamCong.addColumn("Tên nhân viên");
		modelChamCong.addColumn("Ngày");
		modelChamCong.addColumn("Thứ");
		modelChamCong.addColumn("Thời gian làm");
		modelChamCong.addColumn("Trạng Thái");

		tableChamCong.setModel(modelChamCong);

		JPanel panelLeft = new JPanel();
		contentPane.add(panelLeft, BorderLayout.WEST);

		dateChamCong = new JCalendar();
		dateChamCong.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				loadListChamCongNgay();
				loadTableChamCong();
				txtTimKiem.setEnabled(false);
				;
			}
		});

		JScrollPane scrollPane_1 = new JScrollPane();

		txtTimKiem = new JTextField();
		txtTimKiem.setEnabled(false);
		txtTimKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				timKiemNhanVien();
			}
		});
		txtTimKiem.setText(" TÌm theo mã nhân viên");
		txtTimKiem.setColumns(10);
		txtTimKiem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTimKiem.getText().equals(" TÌm theo mã nhân viên")) {
					txtTimKiem.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTimKiem.getText().equals("")) {
					txtTimKiem.setText(" TÌm theo mã nhân viên");
				}
			}
		});
		panel1.add(btnXoa);

		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaNhanVienChamCong();
			}
		});
		panel1.add(btnAdd);

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				luuChamCong();
			}
		});

		JButton btnTimTheoThang = new JButton("Tìm Theo Tháng");
		btnTimTheoThang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadListChamCongThang();
				loadTableChamCong();
				txtTimKiem.setEnabled(true);
			}
		});

		JButton btnMoChamCong = new JButton("Mở Chấm Công");
		btnMoChamCong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moChamCong();
				txtTimKiem.setEnabled(false);
				btnXoa.setEnabled(true);
				btnAdd.setEnabled(true);
				btnChamCong.setEnabled(true);
			}
		});

		GroupLayout gl_panelLeft = new GroupLayout(panelLeft);
		gl_panelLeft.setHorizontalGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLeft.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
								.addComponent(dateChamCong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelLeft.createSequentialGroup().addGap(10).addComponent(btnTimTheoThang)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnMoChamCong))
								.addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnChamCong, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		gl_panelLeft.setVerticalGroup(gl_panelLeft.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelLeft.createSequentialGroup().addContainerGap()
						.addComponent(dateChamCong, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelLeft.createParallelGroup(Alignment.BASELINE).addComponent(btnTimTheoThang)
								.addComponent(btnMoChamCong))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnChamCong).addGap(19)));

		tableNhanVienChamCong = new JTable();
		scrollPane_1.setViewportView(tableNhanVienChamCong);
		panelLeft.setLayout(gl_panelLeft);
		modelNhanVienChamCong.addColumn("Mã nhân viên");
		modelNhanVienChamCong.addColumn("Tên nhân viên");
		tableNhanVienChamCong.setModel(modelNhanVienChamCong);
		tableNhanVienChamCong.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				int index = tableNhanVienChamCong.getSelectedRow();
				maNhanVien = Integer.parseInt(String.valueOf(tableNhanVienChamCong.getValueAt(index, 0)));
				hoTen = String.valueOf(tableNhanVienChamCong.getValueAt(index, 1));
			}
		});
		btnChamCong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				chamCong();

			}
		});
	}

	// xóa nhân viên chấm công
	protected void xoaNhanVienChamCong() {
		boolean i = EntityMessage.confirm(null, "Bạn Chắc Chắn Muốn Xóa Không");
		if (i == false) {
			return;
		}
		int select = tableChamCong.getSelectedRow();
		int idNhanVien = Integer.parseInt(String.valueOf(tableChamCong.getValueAt(select, 0)));
		for (ChamCongModel chamCongModel : listLuuChamCong) {
			if (idNhanVien == chamCongModel.getIdNhanVien()) {
				modelChamCong.removeRow(select);
				modelChamCong.fireTableStructureChanged();
				listLuuChamCong.remove(chamCongModel);
				return;
			}
		}
		Calendar c = Calendar.getInstance();
		String nam = String.valueOf(c.get(Calendar.YEAR));
		String thang = String.valueOf(c.get(Calendar.MONTH) + 1);
		String ngay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		ChamCongDAO chamCongDao = new ChamCongDAO();
		chamCongDao.delete(idNhanVien, nam, thang, ngay);
		modelChamCong.removeRow(select);
		modelChamCong.fireTableStructureChanged();
		EntityMessage.show(null, "Delete Thành Công");
	}

	// mở bảng nhân viên chấm công hiện tại
	protected void moChamCong() {
		listChamCong.clear();
		Calendar c = Calendar.getInstance();
		String nam = String.valueOf(c.get(Calendar.YEAR));
		String thang = String.valueOf(c.get(Calendar.MONTH) + 1);
		String ngay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		ChamCongDAO chamCongDao = new ChamCongDAO();
		listChamCong = chamCongDao.filterDay(nam, thang, ngay);
		loadTableChamCong();
		btnChamCong.setEnabled(true);
		btnXoa.setEnabled(true);
		btnAdd.setEnabled(true);
	}

	// tìm kiếm nhân viên chấm công trong tháng
	protected void timKiemNhanVien() {
		listChamCong.clear();
		List<ChamCongModel> listTimKiemChamCong = new ArrayList<ChamCongModel>();
		Calendar c = dateChamCong.getCalendar();
		String nam = String.valueOf(c.get(Calendar.YEAR));
		String thang = String.valueOf(c.get(Calendar.MONTH) + 1);
		ChamCongDAO chamCongDao = new ChamCongDAO();
		listTimKiemChamCong = chamCongDao.filterMonth(nam, thang);
		for (ChamCongModel chamCongModel : listTimKiemChamCong) {
			if (txtTimKiem.getText().equals(String.valueOf(chamCongModel.getIdNhanVien()))) {
				listChamCong.add(chamCongModel);
			}
		}
		loadTableChamCong();

	}

	// lưu chấm công
	protected void luuChamCong() {
		boolean i = EntityMessage.confirm(null, "Bạn Chắc Chắn Muốn Lưu ?");
		if (i) {
			for (ChamCongModel chamCongModel : listLuuChamCong) {
				ChamCongDAO chamCong = new ChamCongDAO();
				chamCong.save(chamCongModel);
			}
			EntityMessage.show(null, "Lưu Thành Công");
			listLuuChamCong.clear();
		}
		btnChamCong.setEnabled(false);
		btnAdd.setEnabled(false);
		btnXoa.setEnabled(false);
	}

	// chấm công cho nhân viên
	protected void chamCong() {
		Date now = new Date();
		int day = now.getDay();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");

		for (int i = 0; i < tableChamCong.getRowCount(); i++) {
			if (maNhanVien == Integer.parseInt(String.valueOf(tableChamCong.getValueAt(i, 0)))) {
				EntityMessage.show(null, "Nhân Viên Đã Được Chấm Công");
				return;
			}
		}
		int i = 0;
		try {
			i = sdf.parse(sdf.format(now)).compareTo(sdf.parse("8:00:00 AM"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		modelChamCong.addRow(new Object[] { maNhanVien, hoTen, new SimpleDateFormat("yyyy-MM-dd").format(now),
				day == 0 ? "Chủ Nhật" : day + 1, sdf.format(now), i == -1 ? "Đúng Giờ" : "Đi Muộn" });
		ChamCongModel chamCong = new ChamCongModel();
		chamCong.setHoTen(hoTen);
		chamCong.setIdNhanVien(maNhanVien);
		chamCong.setNgayChamCong(new Timestamp(now.getTime()));
		listLuuChamCong.add(chamCong);
	}

	// load list nhân viên
	public void loadToTable() {
		try {
			listNhanVien = nhanVienService.findAll();
			reloadTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// load bảng nhân viên chấm công
	private void reloadTable() {
		modelNhanVienChamCong.setRowCount(0);
		for (NhanVienModel i : listNhanVien) {
			modelNhanVienChamCong.addRow(new Object[] { i.getId(), i.getHoTen() });
		}
	}

	// load bảng chấm công nhân viên
	private void loadListChamCongNgay() {
		listChamCong.clear();
		Calendar c = dateChamCong.getCalendar();
		String nam = String.valueOf(c.get(Calendar.YEAR));
		String thang = String.valueOf(c.get(Calendar.MONTH) + 1);
		String ngay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		ChamCongDAO chamCongDao = new ChamCongDAO();
		listChamCong = chamCongDao.filterDay(nam, thang, ngay);
	}

	// danh sách chấm công nhân viên tháng
	private void loadListChamCongThang() {
		listChamCong.clear();
		Calendar c = dateChamCong.getCalendar();
		String nam = String.valueOf(c.get(Calendar.YEAR));
		String thang = String.valueOf(c.get(Calendar.MONTH) + 1);
		ChamCongDAO chamCongDao = new ChamCongDAO();
		listChamCong = chamCongDao.filterMonth(nam, thang);
	}

	// load bảng chấm công
	private void loadTableChamCong() {
		modelChamCong.setRowCount(0);
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
		for (ChamCongModel chamCongModel : listChamCong) {
			calendar.setTime(chamCongModel.getNgayChamCong());
			int day = chamCongModel.getNgayChamCong().getDay();
			int i = 0;
			String gioChamCong = sdf.format(chamCongModel.getNgayChamCong());
			try {
				i = sdf.parse(gioChamCong).compareTo(sdf.parse("8:00:00 AM"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			modelChamCong.addRow(new Object[] { chamCongModel.getIdNhanVien(), chamCongModel.getHoTen(),
					new SimpleDateFormat("dd-MM-yyyy").format(chamCongModel.getNgayChamCong()),
					day == 0 ? "Chủ Nhật" : day + 1, sdf.format(chamCongModel.getNgayChamCong()),
					i == -1 ? "Đúng Giờ" : "Đi Muộn" });
		}
		btnXoa.setEnabled(false);
		btnAdd.setEnabled(false);
		btnChamCong.setEnabled(false);
	}
}
