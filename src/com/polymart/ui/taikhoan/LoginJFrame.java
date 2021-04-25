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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.polymart.config.SecurityConfig;
import com.polymart.entity.EntityAuthorization;
import com.polymart.entity.EntityFrame;
import com.polymart.entity.EntityMessage;
import com.polymart.entity.EntityValidate;
import com.polymart.service.INhanVienService;
import com.polymart.service.impl.NhanVienService;
import com.polymart.ui.MainFrame;

public class LoginJFrame extends JFrame {

    private static final long serialVersionUID = 2723825969344724367L;

    private JPanel contentPane;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin = new JButton("Đăng nhập");
    private JButton btnCancel;

    private INhanVienService nhanVienService = new NhanVienService();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                 //   UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                    LoginJFrame loginJFrame = new LoginJFrame();
                    loginJFrame.setVisible(true);
                    loginJFrame.setTitle("Đăng nhập");
                    loginJFrame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public LoginJFrame() {
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

        txtUsername = new JTextField(" Username");
        txtUsername.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                loginKeyPressed(e);
            }
        });
        txtUsername.setForeground(Color.black);
        txtUsername.setBackground(Color.white);
        txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtUsername.setColumns(10);
        txtUsername.setBorder(new LineBorder(Color.WHITE));
        txtUsername.setBounds(342, 77, 257, 35);

        contentPane.add(txtUsername);

        txtPassword = new JPasswordField();
        txtPassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                loginKeyPressed(e);
            }
        });
        txtPassword.setForeground(Color.black);
        txtPassword.setBackground(Color.white);
        txtPassword.setText(" Password");
        txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtPassword.setColumns(10);
        txtPassword.setBorder(new LineBorder(Color.WHITE));
        txtPassword.setBounds(342, 138, 257, 35);
        contentPane.add(txtPassword);

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
        lblUser.setIcon(new ImageIcon("images\\logoLO.png"));
        lblUser.setBounds(20, 0, 279, 340);
        contentPane.add(lblUser);

        txtUsername.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtUsername.getText().equals(" Username")) {
                    txtUsername.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtUsername.getText().equals("")) {
                    txtUsername.setText(" Username");
                }
            }
        });

        txtPassword.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(txtPassword.getPassword()).equals(" Password")) {
                    txtPassword.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(txtPassword.getPassword()).equals("")) {
                    txtPassword.setText(" Password");
                }
            }
        });

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
        String username = txtUsername.getText();
        String password = String.valueOf(txtPassword.getPassword());
        if (EntityValidate.checkUsername(this, username) && EntityValidate.checkPassword(this, password)) {
            EntityAuthorization.USER = nhanVienService.findByIdAndPassword(Integer.valueOf(username), password);
            if (EntityAuthorization.USER != null) {
                if (EntityAuthorization.USER.getChucVu().equalsIgnoreCase("QUẢN LÝ")) {
                    EntityAuthorization.USER.setChucVu(SecurityConfig.VAITRO_QUANLY);
                } else if (EntityAuthorization.USER.getChucVu().equalsIgnoreCase("NHÂN VIÊN THU NGÂN")) {
                    EntityAuthorization.USER.setChucVu(SecurityConfig.VAITRO_THUNGAN);
                } else {
                    EntityAuthorization.USER.setChucVu(SecurityConfig.VAITRO_BANHANG);
                }
                setVisible(false);
                EntityFrame.MAINFRAME = new MainFrame();
                EntityFrame.MAINFRAME.setVisible(true);
            } else {
                EntityMessage.show(this, "Nhân viên không tồn tại!\nVui lòng kiểm tra lại mã đăng nhập và mật khẩu");
            }
        }
    }
}
