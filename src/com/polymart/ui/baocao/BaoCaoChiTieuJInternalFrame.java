package com.polymart.ui.baocao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
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

import com.polymart.dao.impl.ChiTieuDao;
import com.polymart.entity.EntityAuthorization;
import com.polymart.entity.EntityMessage;
import com.polymart.model.ChiTieuModel;
import com.toedter.calendar.JCalendar;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BaoCaoChiTieuJInternalFrame extends JInternalFrame {

	private static final long serialVersionUID = 5684359871253902201L;

	private JPanel contentPane;
	DefaultTableModel modelChiTieu = new DefaultTableModel();
	JPanel nhanVienJPanel = new JPanel();
	private JTable tableChiTieu;
	JPanel panel = new JPanel();
	private JTextField txtTimKiem;
	static List<ChiTieuModel> list = new ArrayList<ChiTieuModel>();
	JCalendar dateChamCong = new JCalendar();
	ChiTieuDao chiTieu = new ChiTieuDao();
	JButton btnXoa = new JButton("- Xóa");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new BaoCaoChiTieuJInternalFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BaoCaoChiTieuJInternalFrame() {
		((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1062, 662);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		contentPane.add(panel, BorderLayout.NORTH);

		initTopChiTieu();
		initCenterChiTieu();
		loadList();
		fillTable();
	}

	public void initTopChiTieu() {
		setTitle("Báo cáo - Chi tiêu");
		JLabel lblNhanVien = new JLabel("Chi tiêu              ");
		lblNhanVien.setFont(new Font("Tahoma", Font.BOLD, 18));

		txtTimKiem = new JTextField();
		txtTimKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				timKiemChiTieu();
			}
		});
		txtTimKiem.setText(" TÌm theo mã , Mục Đích Chi Tiêu");
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

		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				xoaPhieuChi();
				btnXoa.setEnabled(false);
			}
		});

		JButton btnThmMi_2 = new JButton("+ Thêm mới");
		btnThmMi_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themMoi();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNhanVien, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
					.addGap(266)
					.addComponent(btnThmMi_2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(0))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnThmMi_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNhanVien, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

	}
	// Xóa Phiếu Chi Tiêu
	protected void xoaPhieuChi() {
		if(!EntityMessage.confirm(null, "Bạn Có Chắc Chắn Muốn Xóa Không")) {
			return;
		}
		int select = tableChiTieu.getSelectedRow();
		String maCT = String.valueOf(tableChiTieu.getValueAt(select, 0));
		int id = Integer.parseInt(maCT.replace("PC", ""));
//		String nguoiXoa ="Người Xóa : " +EntityAuthorization.USER.getHoTen()+"("+EntityAuthorization.USER.getId() +")";
		chiTieu.delete(id);
		loadList();
		fillTable();
	}

	// tìm kiếm phiếu chi tiêu theo mã chi tiêu hoặc theo mục đích
	protected void timKiemChiTieu() {
		if(txtTimKiem.getText().isBlank()) {
//			modelChiTieu.setRowCount(0);
			return;
		}
		list.clear();
		List<ChiTieuModel> listAll = new ArrayList<ChiTieuModel>();
		listAll=chiTieu.findAll();
		for (ChiTieuModel chiTieuModel : listAll) {
			String mucDichChiTieu = chiTieuModel.getMucDichChiTieu().toLowerCase();
			String timKiem = txtTimKiem.getText().toLowerCase();
			String maCT ="PC"+ String.valueOf(chiTieuModel.getMaCT());
			if(maCT.toLowerCase().contains(timKiem)||mucDichChiTieu.contains(timKiem)){
				list.add(chiTieuModel);
			}
		}
		fillTable();
	}

	protected void themMoi() {
		ThemBaoCaoChiTieuFrame themBaoCaoChiTieuFrame = new ThemBaoCaoChiTieuFrame(this);
		themBaoCaoChiTieuFrame.setVisible(true);
		themBaoCaoChiTieuFrame.setLocationRelativeTo(null);
	}

	public void initCenterChiTieu() {
		nhanVienJPanel.setLayout(new BoxLayout(nhanVienJPanel, BoxLayout.Y_AXIS));
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		tableChiTieu = new JTable();
		tableChiTieu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnXoa.setEnabled(true);
			}
		});
		scrollPane.setViewportView(tableChiTieu);

		modelChiTieu.addColumn("Mã Chi Tiêu");
		modelChiTieu.addColumn("Người Xuất Phiếu");
		modelChiTieu.addColumn("Mục đích chi tiêu");
		modelChiTieu.addColumn("Ngày chi tiêu");
		modelChiTieu.addColumn("Số tiền");
		modelChiTieu.addColumn("Ghi chú");

		tableChiTieu.setModel(modelChiTieu);

		JPanel panelLeft = new JPanel();
		contentPane.add(panelLeft, BorderLayout.WEST);
		dateChamCong.getDayChooser().addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName().equals("day")) {
					timKiemTheoNgay();
				}
			}
		});

		JButton btnNewButton = new JButton("Hôm Nay");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timChiTieuHomNay();
			}
		});
		
		JButton btnAll = new JButton("Tất Cả");
		btnAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				xemTatCa();
			}
		});
		
		JButton btnXemLaiLichSu = new JButton("Lịch Sử Phiếu Đã Xóa");
		GroupLayout gl_panelLeft = new GroupLayout(panelLeft);
		gl_panelLeft.setHorizontalGroup(
			gl_panelLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLeft.createSequentialGroup()
					.addGap(5)
					.addComponent(dateChamCong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelLeft.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAll))
				.addGroup(gl_panelLeft.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnXemLaiLichSu))
		);
		gl_panelLeft.setVerticalGroup(
			gl_panelLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLeft.createSequentialGroup()
					.addGap(5)
					.addComponent(dateChamCong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelLeft.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnAll))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnXemLaiLichSu)
					.addContainerGap(365, Short.MAX_VALUE))
		);
		dateChamCong.getMonthChooser().addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName().equals("month")) {
					timChiTieuThang();
				}
			}
		});
		panelLeft.setLayout(gl_panelLeft);
	}
	// Xem Tất Cả Phiếu Chi
	protected void xemTatCa() {
		loadList();
		fillTable();
	}
	// Tìm Phiếu Chi Ngày Hiện Tại
	protected void timChiTieuHomNay() {
		list.clear();
		Calendar calendar = Calendar.getInstance();
		int nam = calendar.get(Calendar.YEAR);
		int thang = calendar.get(Calendar.MONTH) + 1;
		int ngay = calendar.get(Calendar.DAY_OF_MONTH);
		list = chiTieu.findTheoNgay(nam, thang,ngay);
		fillTable();
		
	}
	// Tìm Tất Cả Phiếu Chi Của Tháng Đã Chọn
	protected void timChiTieuThang() {
		list.clear();
		Calendar calendar = dateChamCong.getCalendar();
		int nam = calendar.get(Calendar.YEAR);
		int thang = calendar.get(Calendar.MONTH) + 1;
		list = chiTieu.findTheoThang(nam, thang);
		fillTable();
		
	}
	// Tìm Tất Cả Phiếu Chi Theo NGày Đc Chọn
	protected void timKiemTheoNgay() {
		list.clear();
		Calendar calendar = dateChamCong.getCalendar();
		int nam = calendar.get(Calendar.YEAR);
		int thang = calendar.get(Calendar.MONTH) + 1;
		int ngay = calendar.get(Calendar.DAY_OF_MONTH);
		list = chiTieu.findTheoNgay(nam, thang, ngay);
		fillTable();
	}

	// load list chi tiêu
	public void loadList() {
		list.clear();
		list = chiTieu.findAll();
	}

	// load table Chi Tiêu
	public void fillTable() {
		modelChiTieu.setRowCount(0);
		for (ChiTieuModel x : list) {
			modelChiTieu.addRow(new Object[] { "PC" + x.getMaCT(), x.getHoTen(), x.getMucDichChiTieu(),
					x.getNgayChiTieu(), x.getSoTien(), x.getGhiChu() });
		}
		btnXoa.setEnabled(false);
	}
}
