package com.polymart.ui.taikhoan;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.polymart.entity.EntityAuthorization;
import com.polymart.entity.EntityMessage;
import com.polymart.entity.EntityValidate;
import com.polymart.service.INhanVienService;
import com.polymart.service.impl.NhanVienService;
import java.awt.Toolkit;

public class ChangePassFrame extends JFrame {

	private static final long serialVersionUID = -4390616054863560883L;

	private JButton btnCancel;
	private JButton btnChangePassword = new JButton("Đổi mật khẩu");
	private JLabel txtUsername;
	private JPasswordField txtComfirmNewPassword;
	private JPasswordField txtNewPassword;

	private INhanVienService nhanVienService = new NhanVienService();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ChangePassFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChangePassFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\fpt.png"));
		setTitle("Đổi mật khẩu");
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 682, 420);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setFocusable(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtUsername = new JLabel(EntityAuthorization.USER.getId().toString());
		txtUsername.setForeground(Color.black);
		txtUsername.setBackground(Color.white);
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUsername.setBorder(new LineBorder(Color.WHITE));
		txtUsername.setBounds(360, 76, 268, 27);

		contentPane.add(txtUsername);

		txtNewPassword = new JPasswordField();
		txtNewPassword.setForeground(Color.black);
		txtNewPassword.setBackground(Color.white);
		txtNewPassword.setText("password");
		txtNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNewPassword.setColumns(10);
		txtNewPassword.setBorder(new LineBorder(Color.WHITE));
		txtNewPassword.setBounds(360, 136, 257, 27);
		contentPane.add(txtNewPassword);

		JLabel lblLogin = new JLabel("ĐỔI MẬT KHẨU");
		lblLogin.setForeground(Color.BLUE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblLogin.setBounds(417, 11, 187, 40);
		contentPane.add(lblLogin);

		btnChangePassword.setForeground(Color.WHITE);
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePasswordClicked();
			}
		});
		btnChangePassword.setBorder(null);
		btnChangePassword.setBackground(Color.BLACK);
		btnChangePassword.setBounds(360, 264, 268, 40);
		contentPane.add(btnChangePassword);

		txtNewPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (String.valueOf(txtNewPassword.getPassword()).equals("password")) {
					txtNewPassword.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (String.valueOf(txtNewPassword.getPassword()).equals("")) {
					txtNewPassword.setText("password");
				}
			}
		});

		btnChangePassword.setContentAreaFilled(false);

		btnCancel = new JButton("Hủy");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassFrame.this.dispose();
			}
		});

		btnCancel.setForeground(Color.WHITE);
		btnCancel.setContentAreaFilled(false);
		btnCancel.setBorder(null);
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setBounds(360, 325, 268, 40);
		contentPane.add(btnCancel);

		txtComfirmNewPassword = new JPasswordField("password");
		txtComfirmNewPassword.setForeground(Color.BLACK);
		txtComfirmNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtComfirmNewPassword.setColumns(10);
		txtComfirmNewPassword.setBorder(new LineBorder(Color.WHITE));
		txtComfirmNewPassword.setBackground(Color.WHITE);
		txtComfirmNewPassword.setBounds(360, 196, 268, 27);
		contentPane.add(txtComfirmNewPassword);

		txtComfirmNewPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (String.valueOf(txtComfirmNewPassword.getPassword()).equals("password")) {
					txtComfirmNewPassword.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (String.valueOf(txtComfirmNewPassword.getPassword()).equals("")) {
					txtComfirmNewPassword.setText("password");
				}
			}
		});

		JLabel lblUser = new JLabel("");
		lblUser.setIcon(new ImageIcon("images\\logoLO.png"));
		lblUser.setBounds(38, 32, 268, 340);
		contentPane.add(lblUser);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("images\\changepass.jpg"));
		lblNewLabel.setBounds(0, -20, 650, 420);
		lblNewLabel.setBackground(Color.black);
		contentPane.add(lblNewLabel);
	}

	protected void changePasswordClicked() {
		String getNewPassword = String.valueOf(txtNewPassword.getPassword());
		String getConfirmNewPassword = String.valueOf(txtComfirmNewPassword.getPassword());
		changePassword(getNewPassword, getConfirmNewPassword);
	}

	public void changePassword(String newPassword, String confirmNewPassword) {
		if (EntityValidate.checkNewPasswordChange(this, newPassword)
				&& EntityValidate.checkConfirmNewPasswordChange(this, confirmNewPassword)) {
			String oldPassword = EntityMessage.porm(this, "Nhập mật khẩu cũ:");
			if (EntityValidate.checkOldPasswordChange(this, oldPassword)) {
				EntityAuthorization.USER.setMatKhau(newPassword);
				if ((nhanVienService.update(EntityAuthorization.USER)) != null) {
					EntityMessage.show(this, "Đổi mật khẩu thành công");
					this.setVisible(false);
				}
			}
		}
	}
}