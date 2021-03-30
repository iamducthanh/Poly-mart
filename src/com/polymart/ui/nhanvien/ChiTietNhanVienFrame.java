package com.polymart.ui.nhanvien;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import com.toedter.calendar.JDateChooser;

public class ChiTietNhanVienFrame extends JFrame {

    private static final long serialVersionUID = 2409713466527766453L;

    private JPanel contentPane;
    private JTextField txtMaNV;
    private JTextField txtMaChamCong;
    private JTextField txtEmail;
    private JTextField txtTenNV;
    private JTextField txtSDT;
    private JTextField txtMatKhau;
    private JTextField txtQueQuan;
    private JTextField txtMucLuong;
    private JTextField txtChucVu;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ChiTietNhanVienFrame().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ChiTietNhanVienFrame() {
        setTitle("Chi tiết nhân viên");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 799, 607);
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
        panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chi ti\u1EBFt nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.desktop));
        panel.setBounds(10, 11, 766, 486);
        contentPane.add(panel);
        panel.setLayout(null);

        JButton btnNewButton = new JButton("Lưu");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton.setBounds(687, 508, 89, 23);
        contentPane.add(btnNewButton);

        JButton btnToMi = new JButton("Tạo mới");
        btnToMi.setBounds(588, 508, 89, 23);
        contentPane.add(btnToMi);

        JLabel lblGiVn = new JLabel("Mã nhân viên");
        lblGiVn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblGiVn.setBounds(34, 45, 112, 25);
        panel.add(lblGiVn);

        txtMaNV = new JTextField();
        txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtMaNV.setColumns(10);
        txtMaNV.setBorder(null);
        txtMaNV.setBounds(142, 45, 175, 25);
        panel.add(txtMaNV);

        JLabel lblTnNhnVin = new JLabel("Tên nhân viên");
        lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTnNhnVin.setBounds(34, 183, 112, 25);
        panel.add(lblTnNhnVin);

        JLabel lblNgySinh = new JLabel("Ngày sinh");
        lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNgySinh.setBounds(34, 91, 112, 25);
        panel.add(lblNgySinh);

        JLabel lblGiVn_3 = new JLabel("Quê quán");
        lblGiVn_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblGiVn_3.setBounds(34, 325, 112, 25);
        panel.add(lblGiVn_3);

        JLabel lblGiVn_4 = new JLabel("Số điện thoại");
        lblGiVn_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblGiVn_4.setBounds(546, 138, 112, 25);
        panel.add(lblGiVn_4);

        JLabel lblGiVn_5 = new JLabel("Chức vụ");
        lblGiVn_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblGiVn_5.setBounds(546, 204, 112, 25);
        panel.add(lblGiVn_5);

        JLabel lblGiVn_7 = new JLabel("Mật khẩu");
        lblGiVn_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblGiVn_7.setBounds(34, 230, 112, 25);
        panel.add(lblGiVn_7);

        JLabel lblGiVn_8 = new JLabel("Email");
        lblGiVn_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblGiVn_8.setBounds(34, 372, 112, 25);
        panel.add(lblGiVn_8);

        JLabel lblGiVn_9 = new JLabel("Giới tính");
        lblGiVn_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblGiVn_9.setBounds(34, 138, 112, 25);
        panel.add(lblGiVn_9);

        JDateChooser dateChooserNgaySinh = new JDateChooser();
        dateChooserNgaySinh.setBounds(142, 91, 175, 25);
        panel.add(dateChooserNgaySinh);

        txtMaChamCong = new JTextField();
        txtMaChamCong.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtMaChamCong.setColumns(10);
        txtMaChamCong.setBorder(null);
        txtMaChamCong.setBounds(546, 91, 175, 25);
        panel.add(txtMaChamCong);

        JLabel lblGiVn_9_1 = new JLabel("Mức lương");
        lblGiVn_9_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblGiVn_9_1.setBounds(34, 280, 112, 25);
        panel.add(lblGiVn_9_1);

        JLabel lblGiVn_9_1_1 = new JLabel("Mã chấm công");
        lblGiVn_9_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblGiVn_9_1_1.setBounds(546, 55, 112, 25);
        panel.add(lblGiVn_9_1_1);

        txtEmail = new JTextField();
        txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtEmail.setColumns(10);
        txtEmail.setBorder(null);
        txtEmail.setBounds(142, 372, 374, 25);
        panel.add(txtEmail);

        txtTenNV = new JTextField();
        txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtTenNV.setColumns(10);
        txtTenNV.setBorder(null);
        txtTenNV.setBounds(142, 183, 175, 25);
        panel.add(txtTenNV);

        txtSDT = new JTextField();
        txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtSDT.setColumns(10);
        txtSDT.setBorder(null);
        txtSDT.setBounds(546, 163, 175, 25);
        panel.add(txtSDT);

        txtMatKhau = new JTextField();
        txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtMatKhau.setColumns(10);
        txtMatKhau.setBorder(null);
        txtMatKhau.setBounds(142, 230, 175, 25);
        panel.add(txtMatKhau);

        txtQueQuan = new JTextField();
        txtQueQuan.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtQueQuan.setColumns(10);
        txtQueQuan.setBorder(null);
        txtQueQuan.setBounds(142, 325, 374, 25);
        panel.add(txtQueQuan);

        txtMucLuong = new JTextField();
        txtMucLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtMucLuong.setColumns(10);
        txtMucLuong.setBorder(null);
        txtMucLuong.setBounds(142, 280, 175, 25);
        panel.add(txtMucLuong);

        txtChucVu = new JTextField();
        txtChucVu.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtChucVu.setColumns(10);
        txtChucVu.setBorder(null);
        txtChucVu.setBounds(546, 230, 175, 25);
        panel.add(txtChucVu);

        JRadioButton rdoNam = new JRadioButton("Nam");
        rdoNam.setFont(new Font("Tahoma", Font.PLAIN, 13));
        rdoNam.setBackground(SystemColor.activeCaption);
        rdoNam.setBounds(142, 139, 84, 25);
        panel.add(rdoNam);

        JRadioButton rdoNu = new JRadioButton("Nữ");
        rdoNu.setFont(new Font("Tahoma", Font.PLAIN, 13));
        rdoNu.setBackground(SystemColor.activeCaption);
        rdoNu.setBounds(225, 139, 111, 25);
        panel.add(rdoNu);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("C:\\images\\login.jpg"));
        lblNewLabel.setBounds(350, 45, 166, 210);
        panel.add(lblNewLabel);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdoNam);
        buttonGroup.add(rdoNu);
    }
}
