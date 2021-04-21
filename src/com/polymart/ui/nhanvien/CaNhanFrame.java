package com.polymart.ui.nhanvien;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.polymart.entity.EntityAuthorization;
import com.polymart.entity.EntityImage;
import com.polymart.ui.common.uiCommon;
import com.polymart.ui.taikhoan.ChangePassFrame;


public class CaNhanFrame extends JFrame {

	private static final long serialVersionUID = -5253025473588692845L;
	
	private JPanel contentPane;
	private JTextField txtMaNhanVien;
	private JTextField txtHoTen;
	private JTextField txtNgaySInh;
	private JPasswordField txtMatKhau;
	private JTextField txtChucVu;
	private JTextField txtSoDT;
	private JTextField txtDiaChi;
	private JTextField txtEmail;
	JLabel lblHinhANh = new JLabel("");

	JRadioButton rdoNam = new JRadioButton("Nam");

	JRadioButton rdoNu = new JRadioButton("Nữ");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CaNhanFrame frame = new CaNhanFrame();
					frame.setLocationRelativeTo(null);
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
	public CaNhanFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\fpt.png"));
		setTitle("Thông tin cá nhân");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 594, 515);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTnNhnVin = new JLabel("Họ tên", JLabel.RIGHT);
		lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnNhnVin.setBounds(10, 66, 112, 25);
		contentPane.add(lblTnNhnVin);

		JLabel lblNgySinh = new JLabel("Ngày sinh", JLabel.RIGHT);
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgySinh.setBounds(10, 146, 112, 25);
		contentPane.add(lblNgySinh);

		JLabel lblGiVn_9 = new JLabel("Giới tính", JLabel.RIGHT);
		lblGiVn_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiVn_9.setBounds(10, 106, 112, 25);
		contentPane.add(lblGiVn_9);

		JLabel lblGiVn_5 = new JLabel("Chức vụ", JLabel.RIGHT);
		lblGiVn_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiVn_5.setBounds(10, 226, 112, 25);
		contentPane.add(lblGiVn_5);

		JLabel lblGiVn_7 = new JLabel("Mật khẩu", JLabel.RIGHT);
		lblGiVn_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiVn_7.setBounds(10, 186, 112, 25);
		contentPane.add(lblGiVn_7);

		JLabel lblGiVn_9_1 = new JLabel("Mã nhân viên", JLabel.RIGHT);
		lblGiVn_9_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiVn_9_1.setBounds(10, 26, 112, 25);
		contentPane.add(lblGiVn_9_1);

		JLabel lblGiVn_4 = new JLabel("Số điện thoại", JLabel.RIGHT);
		lblGiVn_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiVn_4.setBounds(10, 266, 112, 25);
		contentPane.add(lblGiVn_4);

		JLabel lblGiVn_8 = new JLabel("Email", JLabel.RIGHT);
		lblGiVn_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiVn_8.setBounds(10, 346, 112, 25);
		contentPane.add(lblGiVn_8);

		JLabel lblGiVn_3 = new JLabel("Địa chỉ", JLabel.RIGHT);
		lblGiVn_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiVn_3.setBounds(10, 306, 112, 25);
		contentPane.add(lblGiVn_3);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setBackground(Color.WHITE);
		txtMaNhanVien.setEditable(false);
		txtMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(146, 26, 163, 30);
		contentPane.add(txtMaNhanVien);

		txtHoTen = new JTextField();
		txtHoTen.setBackground(Color.WHITE);
		txtHoTen.setEditable(false);
		txtHoTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(146, 66, 235, 30);
		contentPane.add(txtHoTen);

		txtNgaySInh = new JTextField();
		txtNgaySInh.setBackground(Color.WHITE);
		txtNgaySInh.setEditable(false);
		txtNgaySInh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNgaySInh.setColumns(10);
		txtNgaySInh.setBounds(146, 146, 163, 30);
		contentPane.add(txtNgaySInh);

		txtMatKhau = new JPasswordField();
		txtMatKhau.setBackground(Color.WHITE);
		txtMatKhau.setEditable(false);
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(146, 186, 163, 30);
		contentPane.add(txtMatKhau);

		txtChucVu = new JTextField();
		txtChucVu.setBackground(Color.WHITE);
		txtChucVu.setEditable(false);
		txtChucVu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtChucVu.setColumns(10);
		txtChucVu.setBounds(146, 226, 235, 30);
		contentPane.add(txtChucVu);

		txtSoDT = new JTextField();
		txtSoDT.setBackground(Color.WHITE);
		txtSoDT.setEditable(false);
		txtSoDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSoDT.setColumns(10);
		txtSoDT.setBounds(146, 266, 163, 30);
		contentPane.add(txtSoDT);

		txtDiaChi = new JTextField();
		txtDiaChi.setBackground(Color.WHITE);
		txtDiaChi.setEditable(false);
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(146, 306, 416, 30);
		contentPane.add(txtDiaChi);

		txtEmail = new JTextField();
		txtEmail.setBackground(Color.WHITE);
		txtEmail.setEditable(false);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(146, 346, 416, 30);
		contentPane.add(txtEmail);

		rdoNam.setEnabled(false);
		rdoNam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdoNam.setBackground(Color.WHITE);
		rdoNam.setBounds(146, 109, 84, 25);
		contentPane.add(rdoNam);

		rdoNu.setEnabled(false);
		rdoNu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdoNu.setBackground(Color.WHITE);
		rdoNu.setBounds(232, 107, 111, 25);
		contentPane.add(rdoNu);

		lblHinhANh.setBounds(414, 33, 148, 200);
		contentPane.add(lblHinhANh);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnThoat.setBounds(473, 431, 89, 30);
		contentPane.add(btnThoat);

		JButton btnDoiMatKau = new JButton("Đổi mật khẩu");
		btnDoiMatKau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doiMatKhau();
			}
		});
		btnDoiMatKau.setBounds(342, 431, 121, 30);
		contentPane.add(btnDoiMatKau);
		uiCommon.editButtonCenter(btnDoiMatKau);
		uiCommon.editButtonCenter(btnThoat);

		loadInfor();
	}

	public void loadInfor() {
		txtMaNhanVien.setText(String.valueOf(EntityAuthorization.USER.getId()));
		txtHoTen.setText(String.valueOf(EntityAuthorization.USER.getHoTen()));
		txtDiaChi.setText(String.valueOf(EntityAuthorization.USER.getDiaChi()));
		txtChucVu.setText(String.valueOf(EntityAuthorization.USER.getChucVu()));
		txtEmail.setText(String.valueOf(EntityAuthorization.USER.getEmail()));
		txtMatKhau.setText(String.valueOf(EntityAuthorization.USER.getMatKhau()));
		txtNgaySInh.setText(String.valueOf(EntityAuthorization.USER.getNgaySinh()));
		txtSoDT.setText(String.valueOf(EntityAuthorization.USER.getSdt()));
		boolean gioiTinh = EntityAuthorization.USER.isGioiTinh();
		if (gioiTinh) {
			rdoNam.setSelected(true);
		} else {
			rdoNu.setSelected(true);
		}

		String url = "images\\" + EntityAuthorization.USER.getAnhDaiDien();
		ImageIcon imageIcon = new ImageIcon(url);
		Image image = EntityImage.resize(imageIcon.getImage(), 148, 200);
		lblHinhANh.setIcon(new ImageIcon(image));

	}

	public void doiMatKhau() {
			close();
			ChangePassFrame changePassFrame = new ChangePassFrame();
			changePassFrame.setLocationRelativeTo(null);
	}

	public void close() {
		this.dispose();
	}
}
