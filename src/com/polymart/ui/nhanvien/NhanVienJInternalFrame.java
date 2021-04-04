package com.polymart.ui.nhanvien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.polymart.config.SecurityConfig;
import com.polymart.entity.EntityFrame;
import com.polymart.model.NhanVienModel;
import com.polymart.service.INhanVienService;
import com.polymart.service.impl.NhanVienService;
import com.polymart.ui.common.uiCommon;

public class NhanVienJInternalFrame extends JInternalFrame {

	private static final long serialVersionUID = 7184061226380381253L;

	private JPanel contentPane;
	private JTextField txtTimKiem;
	private JTable tblNhanVien;
	private DefaultTableModel model = new DefaultTableModel();
	private Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	private int width = (int) dimension.getWidth();
	private int height = (int) dimension.getHeight();
	private JPanel nhanVienJPanel = new JPanel();
	private JPanel panelOption;
	private JPanel panel = new JPanel();
	private JComboBox<Object> cboChucDanh;
	private List<NhanVienModel> list;
	private int index;
	private JButton btnXoaNV;

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

	private INhanVienService nhanVienService = new NhanVienService();

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
		try {
			index = 0;
			list = nhanVienService.findAll();
			loadToTable();
			btnXoaNV.setEnabled(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initTopNhanVien() {
		JLabel lblNhanVien = new JLabel("Nhân viên                       ");
		lblNhanVien.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNhanVien, BorderLayout.WEST);

		txtTimKiem = new JTextField();
		txtTimKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				findNhanVien();
			}
		});
		txtTimKiem.setText(" Tìm theo mã, tên nhân viên");
		panel.add(txtTimKiem, BorderLayout.CENTER);
		txtTimKiem.setColumns(10);
		txtTimKiem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				cboChucDanh.setSelectedIndex(0);
				tblNhanVien.clearSelection();
				btnXoaNV.setEnabled(false);
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

		JPanel pnlFunction = new JPanel();
		panel.add(pnlFunction, BorderLayout.EAST);
		pnlFunction.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Component horizontalStrut = Box.createHorizontalStrut(200);
		pnlFunction.add(horizontalStrut);

		JButton btnThemNV = new JButton("+ Thêm nhân viên");
		pnlFunction.add(btnThemNV);
		btnXoaNV = new JButton("- Xóa nhân viên");
		btnXoaNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDelete();
			}
		});
		pnlFunction.add(btnXoaNV);

		JButton btnMore = new JButton();
		btnMore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				optionNhanVienFrame.setVisible(true);
			}
		});
		btnMore.setText("≡");
		pnlFunction.add(btnMore);

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

		optionNhanVienFrame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				optionNhanVienFrame.setVisible(false);
			}
		});
		btnThemNV.addActionListener(chiTietNhanVien);
	}

	protected void btnDelete() {
		if (JOptionPane.showConfirmDialog(this,
				"Bạn có chắc muốn xoá ra khỏi hệ thống?\nNhân viên: " + list.get(index).getHoTen() + "\nID: "
						+ list.get(index).getId(),
				"Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {
			nhanVienService.delete(new Integer[] { list.get(index).getId() });

			loadToTable();
		}
	}

	protected void findNhanVien() {
		try {
			list = nhanVienService.filter(txtTimKiem.getText());
			reloadTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initCenterNhanVien() {
		nhanVienJPanel.setLayout(new BoxLayout(nhanVienJPanel, BoxLayout.Y_AXIS));
		JLabel lblNewLabel_2 = new JLabel("Nhân viên             ▼");
		lblNewLabel_2.setFont(new Font("Consolas", Font.BOLD, 14));
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		tblNhanVien = new JTable();
		scrollPane.setViewportView(tblNhanVien);
		model.addColumn("Mã nhân viên");
		model.addColumn("Mật khẩu");
		model.addColumn("Tên nhân viên");
		model.addColumn("Chức vụ");
		model.addColumn("Mức lương");
		model.addColumn("Giới tính");
		model.addColumn("Ngày sinh");
		model.addColumn("Địa chỉ");
		model.addColumn("Số điện thoại");
		model.addColumn("Email");
		tblNhanVien.setModel(model);
		tblNhanVien.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				tblClicked(mouseEvent);
			}
		});

		JPanel panelLeft = new JPanel();
		contentPane.add(panelLeft, BorderLayout.WEST);

		JLabel lblChcDanh = new JLabel("Chức vụ");
		lblChcDanh.setFont(new Font("Tahoma", Font.PLAIN, 15));

		cboChucDanh = new JComboBox<Object>();
		cboChucDanh.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				comboBoxSelected();
			}
		});
		cboChucDanh.setModel(new DefaultComboBoxModel<Object>(new String[] { "Tất cả" }));
		GroupLayout gl_panelLeft = new GroupLayout(panelLeft);
		gl_panelLeft.setHorizontalGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLeft.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING)
								.addComponent(cboChucDanh, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblChcDanh, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		gl_panelLeft.setVerticalGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLeft.createSequentialGroup().addGap(14)
						.addComponent(lblChcDanh, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(cboChucDanh,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(515, Short.MAX_VALUE)));
		panelLeft.setLayout(gl_panelLeft);
	}

	protected void comboBoxSelected() {
		if (cboChucDanh.getSelectedIndex() != 0) {
			list = nhanVienService.filterByChucVu(cboChucDanh.getSelectedItem().toString());
			reloadTable();
		} else {
			loadToTable();
		}
	}

	protected void tblClicked(MouseEvent mouseEvent) {
		index = tblNhanVien.getSelectedRow();
		btnXoaNV.setEnabled(true);
		if (mouseEvent.getClickCount() == 2) {
			EntityFrame.CHITIETNHANVIEN = new ChiTietNhanVienFrame();
			EntityFrame.CHITIETNHANVIEN.setVisible(true);
			showDetail();
		}
	}

	private void showDetail() {
		EntityFrame.CHITIETNHANVIEN.txtHoTen.setText(list.get(index).getHoTen());
		EntityFrame.CHITIETNHANVIEN.txtNgaySinh.setDate(list.get(index).getNgaySinh());
		if (list.get(index).isGioiTinh()) {
			EntityFrame.CHITIETNHANVIEN.rdoNam.setSelected(true);
		} else {
			EntityFrame.CHITIETNHANVIEN.rdoNu.setSelected(true);
		}
		EntityFrame.CHITIETNHANVIEN.comboBox.setSelectedItem(list.get(index).getChucVu());
		EntityFrame.CHITIETNHANVIEN.txtMatKhau.setText(list.get(index).getMatKhau());
		EntityFrame.CHITIETNHANVIEN.txtMucLuong.setText(list.get(index).getLuong().toString());
		EntityFrame.CHITIETNHANVIEN.txtSDT.setText(list.get(index).getSdt());
		EntityFrame.CHITIETNHANVIEN.txtEmail.setText(list.get(index).getEmail());
		EntityFrame.CHITIETNHANVIEN.txtDiaChi.setText(list.get(index).getDiaChi());

		ImageIcon imageIcon = new ImageIcon(list.get(index).getAnhDaiDien());
		Image image = imageIcon.getImage().getScaledInstance(164, 177, Image.SCALE_SMOOTH);
		EntityFrame.CHITIETNHANVIEN.lblAnhDaiDien.setIcon(new ImageIcon(image));
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

	public void loadToTable() {
		try {
			list = nhanVienService.findAll();
			reloadTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void reloadTable() {
		model.setRowCount(0);
		for (NhanVienModel i : list) {
			model.addRow(new Object[] { i.getId(), i.getMatKhau(), i.getHoTen(), i.getChucVu(), i.getLuong(),
					i.isGioiTinh() ? "Nam" : "Nữ", new SimpleDateFormat("dd/MM/yyyy").format(i.getNgaySinh()),
					i.getDiaChi(), i.getSdt(), i.getEmail() });
		}
	}
}
