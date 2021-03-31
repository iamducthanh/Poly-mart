package com.polymart.ui;

import com.polymart.entity.EntityAuthorization;
import com.polymart.entity.EntityValidate;
import com.polymart.service.INhanVien;
import com.polymart.service.impl.NhanVienImpl;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


@SuppressWarnings("serial")
public class ChangePassFrame extends JFrame {
    static JTextField textUsername;
    private JTextField textPassword;
    static ChangePassFrame frame = new ChangePassFrame();
    String change = "Change password";
    JButton btnLogin = new JButton("Đổi mật khẩu");
    StringBuilder error = new StringBuilder();
    boolean check = false;

    private INhanVien iNhanVien = new NhanVienImpl();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame.setVisible(true);
                    frame.setTitle("Đổi mật khẩu");
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    private JButton btnCancel;
    private JTextField textComfirm;

    public ChangePassFrame() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 682, 420);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setFocusable(true);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textUsername = new JTextField(" Username");
        textUsername.setEditable(false);
        textUsername.setForeground(Color.black);
        textUsername.setBackground(Color.white);
        textUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textUsername.setColumns(10);
        textUsername.setBorder(new LineBorder(Color.WHITE));
        textUsername.setBounds(360, 76, 268, 27);

        contentPane.add(textUsername);

        textPassword = new JTextField();
        textPassword.setForeground(Color.black);
        textPassword.setBackground(Color.white);
        textPassword.setText(" New Password");
        textPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textPassword.setColumns(10);
        textPassword.setBorder(new LineBorder(Color.WHITE));
        textPassword.setBounds(360, 136, 257, 27);
        contentPane.add(textPassword);

        JLabel lblLogin = new JLabel("ĐỔI MẬT KHẨU");
        lblLogin.setForeground(Color.BLUE);
        lblLogin.setFont(new Font("Tahoma", Font.BOLD, 19));
        lblLogin.setBounds(417, 11, 187, 40);
        contentPane.add(lblLogin);

        btnLogin.setForeground(Color.WHITE);
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                change();
            }
        });
        btnLogin.setBorder(null);
        btnLogin.setBackground(Color.BLACK);
        btnLogin.setBounds(360, 264, 268, 40);
        contentPane.add(btnLogin);

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
                if (textPassword.getText().equals(" New Password")) {
                    textPassword.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textPassword.getText().equals("")) {
                    textPassword.setText(" New Password");
                }
            }
        });

        textUsername.addActionListener(loginAction);
        textPassword.addActionListener(loginAction);


        btnLogin.setContentAreaFilled(false);

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

        textComfirm = new JTextField(" Comfirm password");
        textComfirm.setForeground(Color.BLACK);
        textComfirm.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textComfirm.setColumns(10);
        textComfirm.setBorder(new LineBorder(Color.WHITE));
        textComfirm.setBackground(Color.WHITE);
        textComfirm.setBounds(360, 196, 268, 27);
        contentPane.add(textComfirm);

        textComfirm.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textComfirm.getText().equals(" Comfirm password")) {
                    textComfirm.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textComfirm.getText().equals("")) {
                    textComfirm.setText(" Comfirm password");
                }
            }
        });

        JLabel lblUser = new JLabel("");
        lblUser.setIcon(new ImageIcon("C:\\images\\ong.png"));
        lblUser.setBounds(38, 43, 237, 340);
        contentPane.add(lblUser);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\images\\changepass.jpg"));
        lblNewLabel.setBounds(0, -20, 650, 420);
        lblNewLabel.setBackground(Color.black);
        contentPane.add(lblNewLabel);


    }

    Action loginAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };

    public void change(String oldPassword, String newPassword, String confirmNewPassword) {
        if (EntityValidate.checkOldPasswordChange(oldPassword)
                && EntityValidate.checkNewPasswordChange(newPassword)
                && EntityValidate.checkConfirmNewPasswordChange(confirmNewPassword)) {
            if (iNhanVien.changePassword(Long.valueOf(EntityAuthorization.USER.getId()), newPassword)) {
                EntityAuthorization.USER.setMatKhau(newPassword);
                this.setVisible(false);
            }
        }
    }
}