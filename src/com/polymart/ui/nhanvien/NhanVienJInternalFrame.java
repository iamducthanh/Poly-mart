package com.polymart.ui.nhanvien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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

import com.polymart.config.SecurityConfig;
import com.polymart.ui.common.uiCommon;

public class NhanVienJInternalFrame extends JInternalFrame {

	private static final long serialVersionUID = 7184061226380381253L;

	private JPanel contentPane;
	private JTextField txtTimKiem;
	private JTable tableNhanVien;
	private DefaultTableModel modelNhanVien = new DefaultTableModel();
	private Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	private int width = (int) dimension.getWidth();
	private int height = (int) dimension.getHeight();
	private JPanel nhanVienJPanel = new JPanel();
	private JPanel panelOption;
	private JPanel panel = new JPanel();
	private JComboBox<Object> cboChucDanh;

	private JFrame optionNhanVienFrame = new JFrame();
	private JCheckBox chkMaNV = new JCheckBox("Mã nhân viên");
	private JCheckBox chkTenNV = new JCheckBox("Tên nhân viên");
	private JCheckBox chkMaChamCong = new JCheckBox("Mã chấm công");
	private JCheckBox chkNgaySinh = new JCheckBox("Ngày sinh");
	private JCheckBox chkGioiTinh = new JCheckBox("Giới tính");
	private JCheckBox chkCMND = new JCheckBox("Số CMND");
	private JCheckBox chkPhongBan = new JCheckBox("Phòng ban");
	private JCheckBox chkChucDanh = new JCheckBox("Chức danh");
	private JCheckBox chkGhiChu = new JCheckBox("Ghi chú");
	private JCheckBox chkDiaChi = new JCheckBox("Địa chỉ");
	private JCheckBox chkChiNhanhLamVc = new JCheckBox("Chi nhánh làm việc");
	private JCheckBox chkChiNhanhTraLuong = new JCheckBox("Chi nhánh trả lương");
	private JCheckBox chkFb = new JCheckBox("Facebook");
	private JCheckBox chkEmail = new JCheckBox("Email");
	private JCheckBox chkSDT = new JCheckBox("Số điện thoại");
	private JCheckBox chkNoLuong = new JCheckBox("Nợ lương nhân viên");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new NhanVienJInternalFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public NhanVienJInternalFrame() {
		((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1062, 662);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		// setExtendedState(JFrame.MAXIMIZED_BOTH);


		initTopNhanVien();
		initCenterNhanVien();

		loadComboboxChucVu();
	}

	public void initTopNhanVien() {
		JLabel lblNhanVien = new JLabel("Nhân viên                       ");
		lblNhanVien.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNhanVien, BorderLayout.WEST);

		txtTimKiem = new JTextField();
		txtTimKiem.setText(" Tìm theo mã, tên nhân viên");
		panel.add(txtTimKiem, BorderLayout.CENTER);
		txtTimKiem.setColumns(10);
		txtTimKiem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTimKiem.getText().equals(" Tìm theo mã, tên nhân viên")) {
					txtTimKiem.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTimKiem.getText().equals("")) {
					txtTimKiem.setText(" Tìm theo mã, tên nhân viên");
				}
			}
		});

		JPanel panel1 = new JPanel();
		panel.add(panel1, BorderLayout.EAST);
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnTimKiemNhanVien = new JButton("Tìm kiếm");
		panel1.add(btnTimKiemNhanVien);

		JButton btnThemNV = new JButton("+ Thêm nhân viên");
		panel1.add(btnThemNV);
		JButton btnXoaNV = new JButton("- Xóa nhân viên");
		panel1.add(btnXoaNV);

		JComboBox<String> comboBox1 = new JComboBox<String>();
		comboBox1.addItem("≡");
		panel1.add(comboBox1);

		optionNhanVienFrame.setSize(319, 235);
		optionNhanVienFrame.setLocation(width - 325, height - (height / 100 * 86));
		panelOption = new JPanel();
		panelOption.setLayout(null);
		panelOption.setBackground(Color.white);
		panelOption.setBorder(new EmptyBorder(0, 0, 5, 5));
		optionNhanVienFrame.getContentPane().add(panelOption);
		optionNhanVienFrame.setUndecorated(true);
		uiCommon uiCommon = new uiCommon(panelOption);

		uiCommon.addCheckBox(chkMaNV, 10, 7, 129);
		uiCommon.addCheckBox(chkTenNV, 10, 33, 99);
		uiCommon.addCheckBox(chkMaChamCong, 10, 59, 129);
		uiCommon.addCheckBox(chkNgaySinh, 10, 85, 99);
		uiCommon.addCheckBox(chkGioiTinh, 10, 111, 99);
		uiCommon.addCheckBox(chkCMND, 10, 137, 99);
		uiCommon.addCheckBox(chkPhongBan, 10, 163, 133);
		uiCommon.addCheckBox(chkChucDanh, 10, 189, 99);
		uiCommon.addCheckBox(chkGhiChu, 141, 163, 178);
		uiCommon.addCheckBox(chkDiaChi, 141, 137, 178);
		uiCommon.addCheckBox(chkChiNhanhLamVc, 141, 111, 178);
		uiCommon.addCheckBox(chkChiNhanhTraLuong, 141, 85, 178);
		uiCommon.addCheckBox(chkFb, 141, 59, 99);
		uiCommon.addCheckBox(chkEmail, 141, 33, 99);
		uiCommon.addCheckBox(chkSDT, 141, 7, 144);
		uiCommon.addCheckBox(chkNoLuong, 141, 189, 144);

		comboBox1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				optionNhanVienFrame.setVisible(true);
			}
		});

		comboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				optionNhanVienFrame.setVisible(true);

			}
		});

		optionNhanVienFrame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				optionNhanVienFrame.setVisible(false);
			}
		});
		btnThemNV.addActionListener(chiTietNhanVien);
	}

	public void initCenterNhanVien() {
		nhanVienJPanel.setLayout(new BoxLayout(nhanVienJPanel, BoxLayout.Y_AXIS));
		JLabel lblNewLabel_2 = new JLabel("Nhân viên             ▼");
		lblNewLabel_2.setFont(new Font("Consolas", Font.BOLD, 14));
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		tableNhanVien = new JTable();
		scrollPane.setViewportView(tableNhanVien);
		modelNhanVien.addColumn("Mã nhân viên");
		modelNhanVien.addColumn("Tên nhân viên");
		modelNhanVien.addColumn("Mã chấm công");
		modelNhanVien.addColumn("Ngày sinh");
		modelNhanVien.addColumn("Quê quán");
		modelNhanVien.addColumn("Số điện thoại");
		modelNhanVien.addColumn("Chức vụ");
		modelNhanVien.addColumn("Chi nhánh");
		modelNhanVien.addColumn("Mật khẩu");
		modelNhanVien.addColumn("Email");
		modelNhanVien.addColumn("Giới tính");
		modelNhanVien.addColumn("Mức lương");

		tableNhanVien.setModel(modelNhanVien);

		JPanel panelLeft = new JPanel();
		contentPane.add(panelLeft, BorderLayout.WEST);
		tableNhanVien.getColumnModel().getColumn(0).setPreferredWidth(30);

		JLabel lblChcDanh = new JLabel("Chức vụ");
		lblChcDanh.setFont(new Font("Tahoma", Font.PLAIN, 15));

		cboChucDanh = new JComboBox<Object>();
		cboChucDanh.setModel(new DefaultComboBoxModel<Object>(new String[] { "Tất cả" }));
		GroupLayout gl_panelLeft = new GroupLayout(panelLeft);
		gl_panelLeft.setHorizontalGroup(
			gl_panelLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLeft.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING)
						.addComponent(cboChucDanh, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblChcDanh, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panelLeft.setVerticalGroup(
			gl_panelLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLeft.createSequentialGroup()
					.addGap(14)
					.addComponent(lblChcDanh, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cboChucDanh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(515, Short.MAX_VALUE))
		);
		panelLeft.setLayout(gl_panelLeft);

		// Click đúp vào 1 nhân viên sẽ show thông tin lên chitietnhanvien
		tableNhanVien.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				if (mouseEvent.getClickCount() == 2) {
					ChiTietNhanVienFrame chiTietNhanVien = new ChiTietNhanVienFrame();
					chiTietNhanVien.setVisible(true);
				}
			}
		});

	}

	ActionListener chiTietNhanVien = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			btnThemNhanVien();
		}
	};

	protected void btnThemNhanVien() {
		new ChiTietNhanVienFrame().setVisible(true);
	}

	private void loadComboboxChucVu() {
		cboChucDanh.addItem(SecurityConfig.VAITRO_QUANLY);
		cboChucDanh.addItem(SecurityConfig.VAITRO_BANHANG);
		cboChucDanh.addItem(SecurityConfig.VAITRO_THUNGAN);
	}
}
