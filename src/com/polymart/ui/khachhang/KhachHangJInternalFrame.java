package com.polymart.ui.khachhang;

import com.polymart.entity.EntityMessage;
import com.polymart.entity.EntityValidate;
import com.polymart.model.KhachHangModel;
import com.polymart.service.IKhachHangService;
import com.polymart.service.impl.KhachHangService;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.*;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class KhachHangJInternalFrame extends JInternalFrame {

    /**
     *
     */
    private static final long serialVersionUID = -1800520210551253741L;
    private JPanel contentPane;
    private JTextField txtDiaChi;
    private JTextField txtTenKhachHang;
    private JTextField txtSoDienThoai;
    private JTextField txtTim;
    private JTextField txtTichDiem;
    private JTable tbKhachHang;

    private DefaultTableModel modelKhachHang = new DefaultTableModel();
    private IKhachHangService iKhachHangService = new KhachHangService();


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    KhachHangJInternalFrame frame = new KhachHangJInternalFrame();
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
    public KhachHangJInternalFrame() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //	setBounds(100, 100, 1920, 639);
        setFocusable(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.NORTH);

        JLabel lblNewLabel = new JLabel("   Khách hàng         ");
        lblNewLabel.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 18));

        txtTim = new JTextField();
        txtTim.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 14));
        txtTim.setText(" Tìm theo tên, số điện thoại khách hàng");
        txtTim.setColumns(10);

        JButton btnTim = new JButton("Tìm");
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(5)
                                .addComponent(lblNewLabel)
                                .addGap(5)
                                .addComponent(txtTim, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                .addGap(459))
        );
        gl_panel_1.setVerticalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                .addGap(5)
                                                .addComponent(lblNewLabel))
                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                .addGap(6)
                                                .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(txtTim, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_1.setLayout(gl_panel_1);

        JPanel panel_2 = new JPanel();
        contentPane.add(panel_2, BorderLayout.EAST);

        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chi ti\u1EBFt kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

        JButton btnXoa = new JButton("Xóa");
        btnXoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        txtTim.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtTim.getText().equals(" Tìm theo tên, số điện thoại khách hàng")) {
                    txtTim.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtTim.getText().equals("")) {
                    txtTim.setText(" Tìm theo tên, số điện thoại khách hàng");
                }
            }
        });

        JButton btnCapNhat = new JButton("Cập nhật");

        JButton btnThem = new JButton("Thêm");

        JButton btnTaoMoi = new JButton("Tạo mới");
        GroupLayout gl_panel_2 = new GroupLayout(panel_2);
        gl_panel_2.setHorizontalGroup(
                gl_panel_2.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panel_2.createSequentialGroup()
                                .addContainerGap(73, Short.MAX_VALUE)
                                .addComponent(btnTaoMoi, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(11, Short.MAX_VALUE))
        );
        gl_panel_2.setVerticalGroup(
                gl_panel_2.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_2.createSequentialGroup()
                                .addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
                                .addGap(53)
                                .addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnTaoMoi, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(157, Short.MAX_VALUE))
        );

        JLabel lblNewLabel_2 = new JLabel("Tên khách hàng");
        lblNewLabel_2.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 16));

        txtTenKhachHang = new JTextField();
        txtTenKhachHang.setColumns(10);

        JLabel lblNewLabel_2_1 = new JLabel("Số điện thoại");
        lblNewLabel_2_1.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 16));

        txtSoDienThoai = new JTextField();
        txtSoDienThoai.setColumns(10);

        JLabel lblNewLabel_2_1_1 = new JLabel("Địa chỉ");
        lblNewLabel_2_1_1.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 16));

        txtDiaChi = new JTextField();
        txtDiaChi.setColumns(10);

        JLabel lblNewLabel_2_2 = new JLabel("Tích điểm");
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));

        txtTichDiem = new JTextField("0");
        txtTichDiem.setColumns(10);
        txtTichDiem.setEnabled(false);
        GroupLayout gl_panel_3 = new GroupLayout(panel_3);
        gl_panel_3.setHorizontalGroup(
                gl_panel_3.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_3.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTenKhachHang, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSoDienThoai, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTichDiem, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(23, Short.MAX_VALUE))
        );
        gl_panel_3.setVerticalGroup(
                gl_panel_3.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_3.createSequentialGroup()
                                .addGap(29)
                                .addComponent(lblNewLabel_2)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(txtTenKhachHang, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(txtSoDienThoai, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(txtTichDiem, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(15, Short.MAX_VALUE))
        );
        panel_3.setLayout(gl_panel_3);
        panel_2.setLayout(gl_panel_2);

        txtTim.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtTim.getText().equals(" Tìm theo tên, số điện thoại")) {
                    txtTim.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtTim.getText().equals("")) {
                    txtTim.setText(" Tìm theo tên, số điện thoại");
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        tbKhachHang = new JTable();
        scrollPane.setViewportView(tbKhachHang);
        modelKhachHang.addColumn("Tên khách hàng");
        modelKhachHang.addColumn("Số điện thoại");
        modelKhachHang.addColumn("Địa chỉ");
        modelKhachHang.addColumn("Tích điểm");
        tbKhachHang.setModel(modelKhachHang);

        showTableKhachHang();
        tbKhachHang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showTalbe();
            }
        });

        btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findKhachHangByNameOrPhoneNumber();
            }
        });

        btnTaoMoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evtTaoMoi();
            }
        });

        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evtThemKhachHang();
            }
        });
    }

    // hiển thị danh sách khach hàng lên table
    private void showTableKhachHang() {
        modelKhachHang.setRowCount(0);
        for (KhachHangModel x : iKhachHangService.findAll()) {
            modelKhachHang.addRow(new Object[]{
                    (x.getHoTen() == null) ? "" : x.getHoTen(),
                    x.getSdt(),
                    (x.getDiaChi() == null) ? "" : x.getDiaChi(),
                    x.getTichDiem()
            });
        }
    }

    // hiển thị thông tin khach hàng lên form khi được click vào bảng
    private void showTalbe() {
        int row = tbKhachHang.getSelectedRow();
        if (row > -1 && row < tbKhachHang.getRowCount()) {
            txtTenKhachHang.setText(modelKhachHang.getValueAt(row, 0).toString());
            txtSoDienThoai.setText(modelKhachHang.getValueAt(row, 1).toString());
            txtDiaChi.setText(modelKhachHang.getValueAt(row, 2).toString());
            txtTichDiem.setText(modelKhachHang.getValueAt(row, 3).toString());
        }
    }

    // chức năng tìm kiếm theo họ tên hoặc số điện thoại khách hàng
    private void findKhachHangByNameOrPhoneNumber() {
        String getInput = txtTim.getText();
        if (getInput.isBlank()) {
            EntityMessage.show(this, "Mời nhập dữ liệu cần tìm");
        } else {
            List<KhachHangModel> lstTimKiem = iKhachHangService.findByNameOrPhoneNumber(getInput);
            if (lstTimKiem != null && !lstTimKiem.isEmpty()) {
                modelKhachHang.setRowCount(0);
                for (KhachHangModel x : lstTimKiem) {
                    modelKhachHang.addRow(new Object[]{
                            (x.getHoTen() == null) ? "" : x.getHoTen(),
                            x.getSdt(),
                            (x.getDiaChi() == null) ? "" : x.getDiaChi(),
                            x.getTichDiem()
                    });
                }
            } else {
                showTalbe();
                EntityMessage.show(this, "Không có khách hàng nào cần tìm");
            }
        }
    }

    // sự kiện xóa trắng form nút "Tạo mới"
    private void evtTaoMoi() {
        txtTenKhachHang.setText("");
        txtTichDiem.setText("0");
        txtSoDienThoai.setText("");
        txtDiaChi.setText("");
    }

    // sự kiện thêm mới khách hàng nút "Thêm"
    private void evtThemKhachHang() {
        String getTen = txtTenKhachHang.getText();
        String getSoDienThoai = txtSoDienThoai.getText();
        String getDiaChi = txtDiaChi.getText();
        String getDiem = txtTichDiem.getText();
        if (EntityValidate.checkNameVisit(this, getTen) &&
                EntityValidate.checkPhoneNumber(this, getSoDienThoai) &&
                EntityValidate.checkIntDuong(this, getDiem)) {
            try {
                KhachHangModel khachHangModel = new KhachHangModel(getTen, getSoDienThoai, getDiaChi, Integer.parseInt(getDiem));
                if (iKhachHangService.save(khachHangModel) != null) {
                    EntityMessage.show(this, "Thêm khách hàng thành công");
                    modelKhachHang.addRow(new Object[]{
                            getTen, getSoDienThoai, getDiaChi, getDiaChi, getDiem
                    });
                } else {
                    EntityMessage.show(this, "Thêm thất bại");
                }
            } catch (Exception e) {
                EntityMessage.show(this, "Điểm phải là một số nguyên dương");
            }
        }
    }

}
