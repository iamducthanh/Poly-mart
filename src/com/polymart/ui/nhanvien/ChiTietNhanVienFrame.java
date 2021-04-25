package com.polymart.ui.nhanvien;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.polymart.config.SecurityConfig;
import com.polymart.entity.EntityFrame;
import com.polymart.entity.EntityMessage;
import com.polymart.entity.EntityValidate;
import com.polymart.model.NhanVienModel;
import com.polymart.service.INhanVienService;
import com.polymart.service.impl.NhanVienService;
import com.polymart.ui.common.uiCommon;
import com.toedter.calendar.JDateChooser;

public class ChiTietNhanVienFrame extends JFrame {

	private static final long serialVersionUID = 2409713466527766453L;

	private JPanel contentPane;
	public JTextField txtDiaChi;
	public JTextField txtHoTen;
	public JTextField txtSDT;
	public JTextField txtMatKhau;
	public JTextField txtEmail;
	public JTextField txtMucLuong;
	public JComboBox<Object> comboBox;
	public JDateChooser txtNgaySinh;
	public JRadioButton rdoNam;
	public JRadioButton rdoNu;
	public JLabel lblAnhDaiDien;
	private JFileChooser fileChooser;
	static Integer maNhanVien;
	JButton btnSave;
	JButton btnEdit;
	ButtonGroup buttonGroup;
	static String matKhau;
	String img;
	Boolean check = true;

	private INhanVienService nhanVienService = new NhanVienService();
	
	private NhanVienJInternalFrame nhanVienJInternalFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntityFrame.CHITIETNHANVIEN.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChiTietNhanVienFrame(NhanVienJInternalFrame nhanVienJInternalFrame) {
		this.nhanVienJInternalFrame = nhanVienJInternalFrame;
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\fpt.png"));
		fileChooser = new JFileChooser();
		initialize();
		loadComboboxChucVu().forEach(e -> comboBox.addItem(e));
		matKhau = txtMatKhau.getText();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setVisible(true);
		setTitle("Chi tiết nhân viên");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 684, 682);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mnNewMenu = new JMenu("Thoát");
		menuBar.add(mnNewMenu);

		JMenu mnNewMenu_1 = new JMenu("Lưu");
		menuBar.add(mnNewMenu_1);

		JMenu mnNewMenu_2 = new JMenu("Trợ giúp");
		menuBar.add(mnNewMenu_2);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Chi ti\u1EBFt nh\u00E2n vi\u00EAn  ", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel.setBounds(10, 11, 647, 554);
		contentPane.add(panel);
		panel.setLayout(null);

		btnSave = new JButton("Lưu");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNhanVien();
			}
		});

		btnSave.setBounds(496, 576, 73, 28);
		contentPane.add(btnSave);

		JButton btnClear = new JButton("Làm mới");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnClear.setBounds(408, 576, 78, 28);
		contentPane.add(btnClear);

		JLabel lblTnNhnVin = new JLabel("Tên nhân viên");
		lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnNhnVin.setBounds(34, 45, 112, 25);
		panel.add(lblTnNhnVin);

		JLabel lblNgySinh = new JLabel("Ngày sinh");
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgySinh.setBounds(34, 91, 112, 25);
		panel.add(lblNgySinh);

		JLabel lblGiVn_3 = new JLabel("Địa chỉ");
		lblGiVn_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiVn_3.setBounds(34, 413, 112, 25);
		panel.add(lblGiVn_3);

		JLabel lblGiVn_4 = new JLabel("Số điện thoại");
		lblGiVn_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiVn_4.setBounds(34, 327, 112, 25);
		panel.add(lblGiVn_4);

		JLabel lblGiVn_5 = new JLabel("Chức vụ");
		lblGiVn_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiVn_5.setBounds(34, 174, 112, 25);
		panel.add(lblGiVn_5);

		JLabel lblGiVn_7 = new JLabel("Mật khẩu");
		lblGiVn_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiVn_7.setBounds(34, 230, 112, 25);
		panel.add(lblGiVn_7);

		JLabel lblGiVn_8 = new JLabel("Email");
		lblGiVn_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiVn_8.setBounds(34, 373, 112, 25);
		panel.add(lblGiVn_8);

		JLabel lblGiVn_9 = new JLabel("Giới tính");
		lblGiVn_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiVn_9.setBounds(34, 138, 112, 25);
		panel.add(lblGiVn_9);

		txtNgaySinh = new JDateChooser();
		txtNgaySinh.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName().equals("date")) {
					if (!EntityValidate.checkNgaySinh(EntityFrame.CHITIETNHANVIEN, txtNgaySinh.getDate(), false)) {
						txtNgaySinh.getCalendarButton().requestFocus();
					}
				}
			}
		});
		txtNgaySinh.setDateFormatString("dd/MM/yyyy");
		txtNgaySinh.setBounds(142, 91, 235, 25);
		panel.add(txtNgaySinh);

		JLabel lblGiVn_9_1 = new JLabel("Mức lương");
		lblGiVn_9_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiVn_9_1.setBounds(34, 280, 112, 25);
		panel.add(lblGiVn_9_1);

		txtDiaChi = new JTextField();
		txtDiaChi.setBackground(Color.WHITE);
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(142, 413, 467, 25);
		panel.add(txtDiaChi);

		txtHoTen = new JTextField();
		txtHoTen.setBackground(Color.WHITE);
		txtHoTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(142, 45, 235, 25);
		panel.add(txtHoTen);

		txtSDT = new JTextField();
		txtSDT.setBackground(Color.WHITE);
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSDT.setColumns(10);
		txtSDT.setBounds(142, 327, 235, 25);
		panel.add(txtSDT);

		txtMatKhau = new JTextField();
		txtMatKhau.setBackground(Color.WHITE);
		txtMatKhau.setEditable(false);
		txtMatKhau.setText("12345678");
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(142, 230, 235, 25);
		panel.add(txtMatKhau);

		txtEmail = new JTextField();
		txtEmail.setBackground(Color.WHITE);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(142, 373, 467, 25);
		panel.add(txtEmail);

		txtMucLuong = new JTextField();
		txtMucLuong.setBackground(Color.WHITE);
		txtMucLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMucLuong.setColumns(10);
		txtMucLuong.setBounds(142, 280, 235, 25);
		panel.add(txtMucLuong);

		rdoNam = new JRadioButton("Nam");
		rdoNam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdoNam.setBackground(Color.WHITE);
		rdoNam.setBounds(142, 139, 84, 25);
		panel.add(rdoNam);

		rdoNu = new JRadioButton("Nữ");
		rdoNu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdoNu.setBackground(Color.WHITE);
		rdoNu.setBounds(225, 139, 111, 25);
		panel.add(rdoNu);

		lblAnhDaiDien = new JLabel("");
		ImageIcon imageIcon = new ImageIcon("images\\question.png");
		Image image = imageIcon.getImage().getScaledInstance(164, 177, Image.SCALE_SMOOTH);
		lblAnhDaiDien.setIcon(new ImageIcon(image));
		lblAnhDaiDien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logoClicked();
			}
		});
		lblAnhDaiDien.setBounds(443, 45, 166, 210);
		panel.add(lblAnhDaiDien);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdoNam);
		buttonGroup.add(rdoNu);

		comboBox = new JComboBox<Object>();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(142, 174, 175, 25);
		panel.add(comboBox);

		btnEdit = new JButton("Sửa");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditNhanVien();
			}
		});
		btnEdit.setBounds(579, 575, 78, 28);
		contentPane.add(btnEdit);

		uiCommon.editButtonCenter(btnClear);
		uiCommon.editButtonCenter(btnEdit);
		uiCommon.editButtonCenter(btnSave);
	}

	protected void EditNhanVien() {
		if (validated()&& validateTrung(nhanVienJInternalFrame.ID)) {
			check= false;
			NhanVienModel nhanVien = new NhanVienModel();
			nhanVien = addThongTinNhanVien();
			nhanVien.setId(maNhanVien);
			if (nhanVienService.update(nhanVien) != null) {
				EntityMessage.show(this, "Sửa thành công");
				nhanVienJInternalFrame.loadToTable();
				this.dispose();
			} else {
				EntityMessage.show(this, "Thất bại");
			}

		}
	}

	protected void logoClicked() {
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			ImageIcon imageIcon = new ImageIcon(fileChooser.getSelectedFile().getAbsolutePath());
			Image image = imageIcon.getImage().getScaledInstance(164, 177, Image.SCALE_SMOOTH);
			lblAnhDaiDien.setIcon(new ImageIcon(image));
		}
	}

	/**
	 * Làm mới form thông tin nhân viên
	 */
	protected void clear() {
		txtHoTen.setText(null);
		txtNgaySinh.setCalendar(null);
		buttonGroup.clearSelection();
		comboBox.setSelectedIndex(0);
		txtMucLuong.setText(null);
		txtSDT.setText(null);
		txtEmail.setText(null);
		txtDiaChi.setText(null);

		ImageIcon imageIcon = new ImageIcon("images/question.png");
		Image image = imageIcon.getImage().getScaledInstance(164, 177, Image.SCALE_SMOOTH);
		lblAnhDaiDien.setIcon(new ImageIcon(image));
	}

	/**
	 * Tải dữ liệu chức vụ lên combobox
	 */
	private List<String> loadComboboxChucVu() {
		List<String> list = new ArrayList<String>();
		list.add(SecurityConfig.VAITRO_QUANLY);
		list.add(SecurityConfig.VAITRO_BANHANG);
		list.add(SecurityConfig.VAITRO_THUNGAN);
		return list;
	}

	public NhanVienModel addThongTinNhanVien() {
		NhanVienModel nhanVienModel = new NhanVienModel();
		try {
			nhanVienModel.setNgaySinh(new SimpleDateFormat("dd/MM/yyyy")
					.parse(new SimpleDateFormat("dd/MM/yyyy").format(txtNgaySinh.getDate())));
			nhanVienModel.setGioiTinh((rdoNam.isSelected()) ? true : false);
			nhanVienModel.setHoTen(txtHoTen.getText());
			nhanVienModel.setMatKhau(matKhau);
			nhanVienModel.setLuong(Long.parseLong(txtMucLuong.getText()));
			nhanVienModel.setSdt(txtSDT.getText());
			nhanVienModel.setChucVu(comboBox.getSelectedItem().toString());
			nhanVienModel.setEmail(txtEmail.getText());
			nhanVienModel.setDiaChi(txtDiaChi.getText());

			BufferedImage i = null;
			File f = null;
			if (fileChooser.getSelectedFile() != null) {
				img = fileChooser.getSelectedFile().getPath();
				File file = new File(img);
				try {
					f = new File(img);
					i = ImageIO.read(f);
					img = file.getName();
					if (img.contains("png")) {
						f = new File("images\\" + img);
						ImageIO.write(i, "png", f);
					}
					if (img.contains("jpg")) {
						f = new File("images\\" + img);
						ImageIO.write(i, "jpg", f);
					}
				} catch (Exception e) {
				}
				nhanVienModel.setAnhDaiDien(img);
			} else if(check ==true) {
				nhanVienModel.setAnhDaiDien("images\\question.png");
			}else {
				nhanVienModel.setAnhDaiDien(nhanVienJInternalFrame.path);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nhanVienModel;
	}

	/**
	 * Thêm mới nhân viên
	 */
	protected void addNhanVien() {
		if (validated()&&validateTrung(1)) {
			check=true;
			NhanVienModel nhanVienModel = new NhanVienModel();
			nhanVienModel = addThongTinNhanVien();

			// truyền dữ liệu lên database
			if (nhanVienService.save(nhanVienModel) != null) {
				EntityMessage.show(this, "Thêm mới thành công");
				nhanVienJInternalFrame.loadToTable();
				this.dispose();
			} else {
				EntityMessage.show(this, "Thất bại");
			}
		}
	}
	public boolean validateTrung(Integer id) {
		if(!EntityValidate.checkTrungSDT_Email(this, txtEmail.getText(), txtSDT.getText(), id)) {
			return false;
		}
		return true;
	}
	/**
	 * Kiểm tra nhập thông tin nhân viên
	 */
	private boolean validated() {

		// Họ Tên
		if (!EntityValidate.checkName(this, txtHoTen.getText())) {
			txtHoTen.requestFocus();
			return false;
		}

		// Ngày sinh
		if (!EntityValidate.checkNgaySinh(this, txtNgaySinh.getDate(), true)) {
			txtNgaySinh.requestFocus();
			return false;
		}

		// Giới tính
		if (!rdoNam.isSelected() && !rdoNu.isSelected()) {
			EntityMessage.show(this, "Chọn giới tính");
			rdoNam.requestFocus();
			return false;
		}

		// Mật khẩu
		if (!EntityValidate.checkPassword(this, txtMatKhau.getText())) {
			txtMatKhau.requestFocus();
			return false;
		}

		// Lương
		if (!EntityValidate.checkPositiveNumber(this, txtMucLuong.getText())) {
			txtMucLuong.requestFocus();
			return false;
		}

		// Số điện thoại
		if (!EntityValidate.checkPhoneNumber(this, txtSDT.getText())) {
			txtSDT.requestFocus();
			return false;
		}

		// Email
		if (!EntityValidate.checkEmail(this, txtEmail.getText())) {
			txtEmail.requestFocus();
			return false;
		}

		// Địa chỉ
		if (txtDiaChi.getText().isBlank()) {
			EntityMessage.show(this, "Địa chỉ trống");
			txtDiaChi.requestFocus();
			return false;
		}
		return true;
	}
}
