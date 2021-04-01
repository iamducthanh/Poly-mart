package com.polymart.ui.nhanvien;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import com.polymart.model.NhanVienModel;
import com.polymart.service.INhanVienService;
import com.polymart.service.impl.NhanVienService;
import com.toedter.calendar.JDateChooser;

public class ChiTietNhanVienFrame extends JFrame {

	private static final long serialVersionUID = 2409713466527766453L;

	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtTenNV;
	private JTextField txtSDT;
	private JTextField txtMatKhau;
	private JTextField txtDiaChi;
	private JTextField txtMucLuong;
	private JComboBox<Object> comboBox;
	private JDateChooser txtNgaySinh;
	private JRadioButton rdoNam;
	private JRadioButton rdoNu;
	private JLabel lblAnhDaiDien;

	private INhanVienService nhanVienService = new NhanVienService();

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
	public ChiTietNhanVienFrame() {
		initialize();
		loadComboboxChucVu().forEach(e -> comboBox.addItem(e));
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
		contentPane.setBackground(SystemColor.activeCaption);
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
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Chi ti\u1EBFt nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null,
				SystemColor.desktop));
		panel.setBounds(10, 11, 647, 554);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Lưu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNhanVien();
			}
		});
		btnNewButton.setBounds(531, 589, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnToMi = new JButton("Tạo mới");
		btnToMi.setBounds(432, 589, 89, 23);
		contentPane.add(btnToMi);

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
		txtNgaySinh.setDateFormatString("dd/MM/yyyy");
		txtNgaySinh.setBounds(142, 91, 235, 25);
		panel.add(txtNgaySinh);

		JLabel lblGiVn_9_1 = new JLabel("Mức lương");
		lblGiVn_9_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiVn_9_1.setBounds(34, 280, 112, 25);
		panel.add(lblGiVn_9_1);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBounds(142, 413, 467, 25);
		panel.add(txtEmail);

		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenNV.setColumns(10);
		txtTenNV.setBorder(null);
		txtTenNV.setBounds(142, 45, 235, 25);
		panel.add(txtTenNV);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSDT.setColumns(10);
		txtSDT.setBorder(null);
		txtSDT.setBounds(142, 327, 235, 25);
		panel.add(txtSDT);

		txtMatKhau = new JTextField();
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMatKhau.setColumns(10);
		txtMatKhau.setBorder(null);
		txtMatKhau.setBounds(142, 230, 235, 25);
		panel.add(txtMatKhau);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBorder(null);
		txtDiaChi.setBounds(142, 373, 467, 25);
		panel.add(txtDiaChi);

		txtMucLuong = new JTextField();
		txtMucLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMucLuong.setColumns(10);
		txtMucLuong.setBorder(null);
		txtMucLuong.setBounds(142, 280, 235, 25);
		panel.add(txtMucLuong);

		rdoNam = new JRadioButton("Nam");
		rdoNam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdoNam.setBackground(SystemColor.activeCaption);
		rdoNam.setBounds(142, 139, 84, 25);
		panel.add(rdoNam);

		rdoNu = new JRadioButton("Nữ");
		rdoNu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdoNu.setBackground(SystemColor.activeCaption);
		rdoNu.setBounds(225, 139, 111, 25);
		panel.add(rdoNu);

		lblAnhDaiDien = new JLabel("Ảnh đại diện");
		lblAnhDaiDien.setIcon(new ImageIcon("C:\\images\\login.jpg"));
		lblAnhDaiDien.setBounds(443, 45, 166, 210);
		panel.add(lblAnhDaiDien);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdoNam);
		buttonGroup.add(rdoNu);

		comboBox = new JComboBox<Object>();
		comboBox.setBounds(142, 174, 175, 25);
		panel.add(comboBox);
	}

	private List<String> loadComboboxChucVu() {
		List<String> list = new ArrayList<String>();
		list.add(SecurityConfig.VAITRO_QUANLY);
		list.add(SecurityConfig.VAITRO_BANHANG);
		list.add(SecurityConfig.VAITRO_THUNGAN);
		return list;
	}

	protected void addNhanVien() {
		try {
			NhanVienModel nhanVienModel = new NhanVienModel();
			nhanVienModel.setNgaySinh(new SimpleDateFormat("dd/MM/yyyy")
					.parse(new SimpleDateFormat("dd/MM/yyyy").format(txtNgaySinh.getDate())));
			nhanVienModel.setGioiTinh((rdoNam.isSelected()) ? true : false);
			nhanVienModel.setHoTen(txtTenNV.getText());
			nhanVienModel.setMatKhau(txtMatKhau.getText());
			nhanVienModel.setLuong(Long.parseLong(txtMucLuong.getText()));
			nhanVienModel.setSdt(txtSDT.getText());
			nhanVienModel.setChucVu(comboBox.getSelectedItem().toString());
			nhanVienModel.setDiaChi(txtDiaChi.getText());
			nhanVienModel.setEmail(txtEmail.getText());
			nhanVienModel.setAnhDaiDien(lblAnhDaiDien.getText());
			System.out.println(nhanVienModel.toString());
			if (nhanVienService.save(nhanVienModel) != null) {
				EntityMessage.show(this, "Thêm mới nhân viên thành công");
			} else {
				EntityMessage.show(this, "Thất bại");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
