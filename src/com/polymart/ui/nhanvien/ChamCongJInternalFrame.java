package com.polymart.ui.nhanvien;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

public class ChamCongJInternalFrame extends JInternalFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1619911861884761168L;
    private JPanel contentPane;
    private DefaultTableModel model = new DefaultTableModel();
    private JTextField txtTimKiem;
    private JPanel panel = new JPanel();
    private JPanel nhanVienJPanel = new JPanel();
    private JTable table;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChamCongJInternalFrame frame = new ChamCongJInternalFrame();
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
    public ChamCongJInternalFrame() {
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

        //	initTopChamCong();
        //	initCenterChamCong();
    }

    public void initTopChamCong() {
        setTitle("Nhân viên - Chấm công");
        JLabel lblNhanVien = new JLabel("Chấm công                        ");
        lblNhanVien.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(lblNhanVien, BorderLayout.WEST);

        txtTimKiem = new JTextField();
        txtTimKiem.setText(" TÌm theo mã nhân viên");
        panel.add(txtTimKiem, BorderLayout.CENTER);
        txtTimKiem.setColumns(10);
        txtTimKiem.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtTimKiem.getText().equals(" TÌm theo mã nhân viên")) {
                    txtTimKiem.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtTimKiem.getText().equals("")) {
                    txtTimKiem.setText(" TÌm theo mã nhân viên");
                }
            }
        });

        JPanel panel1 = new JPanel();
        panel.add(panel1, BorderLayout.EAST);
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel_1 = new JLabel(String.format("%100s", " "));
        panel1.add(lblNewLabel_1);


    }

    public void initCenterChamCong() {
        nhanVienJPanel.setLayout(new BoxLayout(nhanVienJPanel, BoxLayout.Y_AXIS));
        JLabel lblNewLabel_2 = new JLabel("Loại hàng             ▼");
        lblNewLabel_2.setFont(new Font("Consolas", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        scrollPane.setViewportView(table);
        model.addColumn("Mã nhân viên");
        model.addColumn("Tên nhân viên");
        model.addColumn("Ngày");
        model.addColumn("Thứ");
        model.addColumn("Thời gian làm");


        table.setModel(model);

        JPanel panelLeft = new JPanel();
        contentPane.add(panelLeft, BorderLayout.WEST);

        JCalendar dateChamCong = new JCalendar();

        JButton btnNewButton = new JButton("Tìm");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(dateChamCong.getDate());
            }
        });
        GroupLayout gl_panelLeft = new GroupLayout(panelLeft);
        gl_panelLeft.setHorizontalGroup(
                gl_panelLeft.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panelLeft.createSequentialGroup()
                                .addGap(5)
                                .addComponent(dateChamCong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_panelLeft.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnNewButton)
                                .addContainerGap(149, Short.MAX_VALUE))
        );
        gl_panelLeft.setVerticalGroup(
                gl_panelLeft.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panelLeft.createSequentialGroup()
                                .addGap(5)
                                .addComponent(dateChamCong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(btnNewButton)
                                .addContainerGap(424, Short.MAX_VALUE))
        );
        panelLeft.setLayout(gl_panelLeft);

        JComboBox<Object> cbbPhongBan = new JComboBox<Object>();
        cbbPhongBan.setModel(new DefaultComboBoxModel<Object>(new String[]{"Tất cả"}));
    }

}