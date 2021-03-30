package com.polymart.ui.taikhoan;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.polymart.entity.EntityAuthorization;
import com.polymart.entity.EntityMessage;
import com.polymart.entity.EntityValidate;
import com.polymart.service.INhanVienService;
import com.polymart.service.impl.NhanVienService;
import com.polymart.ui.PolyMartMain;

public class LoginJFrame extends JFrame {

	private static final long serialVersionUID = 2723825969344724367L;

	private JPanel contentPane;
	private JTextField textUsername;
	private JPasswordField textPassword;
	JButton btnLogin = new JButton("Đăng nhập");

	private INhanVienService nhanVienService = new NhanVienService();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new LoginJFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Action loginAction = new AbstractAction() {

		private static final long serialVersionUID = 1251236672384365634L;

		@Override
		public void actionPerformed(ActionEvent e) {

		}
	};
	private JButton btnCancel;

	public LoginJFrame() {
		setTitle("Đăng nhập");
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\fpt.png"));
		setTitle("Đăng nhập");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 682, 384);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setFocusable(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		textUsername = new JTextField(" Username");
		textUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				loginKeyPressed(e);
			}
		});
		textUsername.setForeground(Color.black);
		textUsername.setBackground(Color.white);
		textUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textUsername.setColumns(10);
		textUsername.setBorder(new LineBorder(Color.WHITE));
		textUsername.setBounds(342, 77, 257, 35);

		contentPane.add(textUsername);

		textPassword = new JPasswordField();
		textPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				loginKeyPressed(e);
			}
		});
		textPassword.setForeground(Color.black);
		textPassword.setBackground(Color.white);
		textPassword.setText(" Password");
		textPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPassword.setColumns(10);
		textPassword.setBorder(new LineBorder(Color.WHITE));
		textPassword.setBounds(342, 138, 257, 35);
		contentPane.add(textPassword);

		JLabel lblLogin = new JLabel("XIN CHÀO!");
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setFont(new Font("Ink Free", Font.BOLD, 22));
		lblLogin.setBounds(413, 26, 203, 40);
		contentPane.add(lblLogin);
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		btnLogin.setIcon(null);

		btnLogin.setForeground(Color.WHITE);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnLogin.setBorder(new LineBorder(Color.WHITE));
		btnLogin.setBackground(Color.BLACK);
		btnLogin.setBounds(328, 208, 288, 45);
		contentPane.add(btnLogin);

		JLabel lblUser = new JLabel("");
		lblUser.setIcon(new ImageIcon("images\\ong.png"));
		lblUser.setBounds(34, 0, 237, 340);
		contentPane.add(lblUser);

		textUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textUsername.getText().equals(" Username")) {
					textUsername.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textUsername.getText().equals("")) {
					textUsername.setText(" Username");
				}
			}
		});

		textPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (String.valueOf(textPassword.getPassword()).equals(" Password")) {
					textPassword.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (String.valueOf(textPassword.getPassword()).equals("")) {
					textPassword.setText(" Password");
				}
			}
		});

		textUsername.addActionListener(loginAction);
		textPassword.addActionListener(loginAction);

		btnLogin.setContentAreaFilled(false);

		btnCancel = new JButton("Kết thúc");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		btnCancel.setForeground(Color.WHITE);
		btnCancel.setContentAreaFilled(false);
		btnCancel.setBorder(new LineBorder(Color.WHITE));
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setBounds(328, 269, 288, 45);
		contentPane.add(btnCancel);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("images\\login.jpg"));
		lblNewLabel.setBounds(-20, -20, 650, 350);
		lblNewLabel.setBackground(Color.black);
		contentPane.add(lblNewLabel);

	}

	protected void loginKeyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			login();
		}
	}

	public void login() {
		String username = textUsername.getText();
		String password = String.valueOf(textPassword.getPassword());
		if (EntityValidate.checkUsername(username, this) && EntityValidate.checkPassword(password, this)) {
			EntityAuthorization.USER = nhanVienService.findNhanVienByIdAndPassword(Integer.valueOf(username), password);
			if (EntityAuthorization.USER != null) {
				this.setVisible(false);
				new PolyMartMain().setVisible(true);
			} else {
				EntityMessage.show(this, "Nhân viên không tồn tại!\nVui lòng kiểm tra lại mã đăng nhập và mật khẩu");
				textUsername.requestFocus();
			}
		} else {
			textUsername.requestFocus();
		}
	}
}
