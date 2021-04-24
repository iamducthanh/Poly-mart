package com.polymart.ui.khachhang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.polymart.config.SecurityConfig;
import com.polymart.entity.EntityAuthorization;
import com.polymart.entity.EntityMessage;
import com.polymart.entity.EntityValidate;
import com.polymart.model.KhachHangModel;
import com.polymart.service.IKhachHangService;
import com.polymart.service.impl.KhachHangService;
import com.polymart.ui.common.uiCommon;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KhachHangJInternalFrame extends JInternalFrame {

    private static final long serialVersionUID = -1800520210551253741L;

    private JPanel contentPane;
    private JTextField txtDiaChi;
    private JTextField txtTenKhachHang;
    private JTextField txtSoDienThoai;
    private JTextField txtFind;
    private JTextField txtTichDiem;
    private JTable tblKhachHang;
    private Integer index;
    private JButton btnXacNhan;
    private JButton btnXoa;

    private DefaultTableModel modelKhachHang = new DefaultTableModel();
    private IKhachHangService khachHangService = new KhachHangService();
    private List<KhachHangModel> list;
    private static Integer point = 0;

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
        try {
            index = -1;
            list = khachHangService.findAll();

            initialize();
            loadToTable();
            disableFuntion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initialize() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setBounds(100, 100, 1920, 639);
        setFocusable(true);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(75, 0, 130));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.WHITE);
        contentPane.add(panel_1, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(75, 0, 130));
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 977, Short.MAX_VALUE)
        );
        gl_panel_1.setVerticalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtFind = new JTextField();
        txtFind.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                findByNameOrPhone();
            }
        });
        txtFind.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtFind.setText(" Tìm theo tên, số điện thoại khách hàng");
        txtFind.setColumns(10);

        txtFind.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focusGainedTextFind();
            }

            @Override
            public void focusLost(FocusEvent e) {
                focusLostTextFind();
            }
        });

        JLabel lblNewLabel = new JLabel(" Khách hàng         ");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(txtFind, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(467, Short.MAX_VALUE))
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtFind, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(14, Short.MAX_VALUE))
        );
        panel.setLayout(gl_panel);
        panel_1.setLayout(gl_panel_1);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.WHITE);
        contentPane.add(panel_2, BorderLayout.EAST);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(Color.WHITE);
        panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(160, 160, 160)), " Chi ti\u1EBFt kh\u00E1ch h\u00E0ng  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

        btnXoa = new JButton("Xóa");
        btnXoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnDelete();
            }
        });

        btnXacNhan = new JButton("Xác nhận");

        JButton btnThemMoi = new JButton("Thêm mới");
        GroupLayout gl_panel_2 = new GroupLayout(panel_2);
        gl_panel_2.setHorizontalGroup(
                gl_panel_2.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_2.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_panel_2.createSequentialGroup()
                                                .addComponent(btnThemMoi, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(btnXacNhan, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(11, Short.MAX_VALUE))
        );
        gl_panel_2.setVerticalGroup(
                gl_panel_2.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_2.createSequentialGroup()
                                .addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
                                .addGap(53)
                                .addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnXacNhan, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnThemMoi, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(45, Short.MAX_VALUE))
        );

        JLabel lblNewLabel_2 = new JLabel("Tên khách hàng");
        lblNewLabel_2.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 16));

        txtTenKhachHang = new JTextField();
        txtTenKhachHang.setBackground(Color.WHITE);
        txtTenKhachHang.setFont(new Font("Dialog", Font.PLAIN, 16));
        txtTenKhachHang.setColumns(10);

        JLabel lblNewLabel_2_1 = new JLabel("Số điện thoại");
        lblNewLabel_2_1.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 16));

        txtSoDienThoai = new JTextField();
        txtSoDienThoai.setBackground(Color.WHITE);
        txtSoDienThoai.setFont(new Font("Dialog", Font.PLAIN, 16));
        txtSoDienThoai.setColumns(10);

        JLabel lblNewLabel_2_1_1 = new JLabel("Địa chỉ");
        lblNewLabel_2_1_1.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 16));

        txtDiaChi = new JTextField();
        txtDiaChi.setBackground(Color.WHITE);
        txtDiaChi.setFont(new Font("Dialog", Font.PLAIN, 16));
        txtDiaChi.setColumns(10);

        JLabel lblNewLabel_2_2 = new JLabel("Tích điểm");
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));

        txtTichDiem = new JTextField("0");
        txtTichDiem.setBackground(Color.WHITE);
        txtTichDiem.setFont(new Font("Dialog", Font.PLAIN, 16));
        txtTichDiem.setColumns(10);
        txtTichDiem.setEnabled(false);
        GroupLayout gl_panel_3 = new GroupLayout(panel_3);
        gl_panel_3.setHorizontalGroup(
                gl_panel_3.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_3.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
                                        .addComponent(txtTichDiem, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSoDienThoai, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTenKhachHang, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(23, Short.MAX_VALUE))
        );
        gl_panel_3.setVerticalGroup(
                gl_panel_3.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_3.createSequentialGroup()
                                .addGap(29)
                                .addComponent(lblNewLabel_2)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(txtTenKhachHang, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(txtSoDienThoai, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(txtTichDiem, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(30, Short.MAX_VALUE))
        );
        panel_3.setLayout(gl_panel_3);
        panel_2.setLayout(gl_panel_2);

//		txtFind.addFocusListener(new FocusAdapter() {
//			@Override
//			public void focusGained(FocusEvent e) {
//				if (txtFind.getText().equals(" Tìm theo tên, số điện thoại")) {
//					txtFind.setText("");
//				}
//			}
//
//			@Override
//			public void focusLost(FocusEvent e) {
//				if (txtFind.getText().equals("")) {
//					txtFind.setText(" Tìm theo tên, số điện thoại");
//				}
//			}
//		});

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        tblKhachHang = new JTable();
        tblKhachHang.setBackground(Color.WHITE);
        scrollPane.setViewportView(tblKhachHang);
        modelKhachHang.addColumn("Tên khách hàng");
        modelKhachHang.addColumn("Số điện thoại");
        modelKhachHang.addColumn("Địa chỉ");
        modelKhachHang.addColumn("Tích điểm");
        tblKhachHang.setModel(modelKhachHang);

        tblKhachHang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableClicked();
            }
        });

        btnThemMoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNew();
            }
        });

        btnXacNhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnConfirm();
            }
        });
        tblKhachHang.setRowHeight(25);
        uiCommon.editButtonCenter(btnThemMoi);
        uiCommon.editButtonCenter(btnXacNhan);
        uiCommon.editButtonCenter(btnXoa);

        setPhanQuyen(btnThemMoi);
    }

    private void setPhanQuyen(JButton btnThemMoi) {
        if (EntityAuthorization.USER.getChucVu().equals(SecurityConfig.VAITRO_QUANLY)) return;
        btnThemMoi.setVisible(false);
        btnXacNhan.setVisible(false);
        btnXoa.setVisible(false);
        if (EntityAuthorization.USER.getChucVu().equals(SecurityConfig.VAITRO_THUNGAN)) {
            btnThemMoi.setVisible(true);
            btnXacNhan.setVisible(true);
        }
    }

    protected void focusLostTextFind() {
        if (txtFind.getText().equals("")) {
            txtFind.setText(" Tìm theo tên, số điện thoại khách hàng");
        }
    }

    protected void focusGainedTextFind() {
        disableFuntion();
        clear();
        tblKhachHang.clearSelection();
        index = -1;
        if (!txtFind.getText().isBlank()) {
            txtFind.setText(null);
        }
    }

    protected void findByNameOrPhone() {
        try {
            list = khachHangService.filter(txtFind.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        clear();
        reloadTable();
    }

    protected void btnDelete() {
        if (JOptionPane.showConfirmDialog(this,
                "Xác nhận xoá khách hàng có tên:  " + list.get(tblKhachHang.getSelectedRow()).getHoTen(), "Xoá",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {
            khachHangService.delete(new Integer[]{list.get(tblKhachHang.getSelectedRow()).getId()});
            clear();
            loadToTable();
        }
    }

    /**
     * show
     */
    private void tableClicked() {
        index = tblKhachHang.getSelectedRow();
        showDetail();
        enableFuntion();
    }

    private void showDetail() {
        txtTenKhachHang.setText(list.get(index).getHoTen());
        txtSoDienThoai.setText(list.get(index).getSdt());
        txtDiaChi.setText(list.get(index).getDiaChi());
        txtTichDiem.setText(list.get(index).getTichDiem().toString());
    }

    /**
     * Xác nhận thêm mới nhân viên hoặc sửa nhân viên
     */
    private void btnConfirm() {
        if (validated()) {
            KhachHangModel khachHangModel = new KhachHangModel();
            khachHangModel.setHoTen(txtTenKhachHang.getText());
            khachHangModel.setSdt(txtSoDienThoai.getText());
            khachHangModel.setDiaChi(txtDiaChi.getText());
            khachHangModel.setTichDiem(point);
            if (index < 0) {
                if (khachHangService.save(khachHangModel) != null) {
                    EntityMessage.show(this, "Thêm thành công");
                    disableFuntion();
                } else {
                    EntityMessage.show(this, "Thêm thất bại");
                }
            } else {
                khachHangModel.setId(list.get(index).getId());
                if (khachHangService.update(khachHangModel) != null) {
                    EntityMessage.show(this, "Cập nhật thành công");
                    disableFuntion();
                } else {
                    EntityMessage.show(this, "Cập nhật thất bại");
                }
            }

            clear();
            loadToTable();
        }
    }

    private boolean validated() {
        if (!EntityValidate.checkName(this, txtTenKhachHang.getText())) {
            txtTenKhachHang.requestFocus();
            return false;
        } else if (!EntityValidate.checkPhoneNumber(this, txtSoDienThoai.getText())) {
            txtSoDienThoai.requestFocus();
            return false;
        } else if (txtDiaChi.getText().isBlank()) {
            EntityMessage.show(this, "Địa chỉ trống");
            txtDiaChi.requestFocus();
            return false;
        }
        return true;
    }

    /**
     * show info to table
     */
    private void loadToTable() {
        try {
            list = khachHangService.findAll();
            reloadTable();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * reload Table
     */
    private void reloadTable() {
        modelKhachHang.setRowCount(0);
        for (KhachHangModel i : list) {
            modelKhachHang.addRow(new Object[]{i.getHoTen(), i.getSdt(), (i.getDiaChi() == null) ? "" : i.getDiaChi(),
                    i.getTichDiem()});
        }
    }

    /**
     * Disable funtion
     */
    private void disableFuntion() {
        txtDiaChi.setEnabled(false);
        txtTenKhachHang.setEnabled(false);
        txtSoDienThoai.setEnabled(false);
        btnXacNhan.setEnabled(false);
        btnXoa.setEnabled(false);
    }

    /**
     * Enable function
     */
    private void enableFuntion() {
        txtDiaChi.setEnabled(true);
        txtTenKhachHang.setEnabled(true);
        txtSoDienThoai.setEnabled(true);
        btnXacNhan.setEnabled(true);
        btnXoa.setEnabled(true);
    }

    /**
     * clear form
     */
    private void clear() {
        txtDiaChi.setText(null);
        txtTenKhachHang.setText(null);
        txtSoDienThoai.setText(null);
    }

    private void createNew() {
        clear();
        txtFind.setText(" Tìm theo tên, số điện thoại khách hàng");
        tblKhachHang.clearSelection();
        index = -1;
        enableFuntion();
        btnXoa.setEnabled(false);

        loadToTable();
        reloadTable();
    }
}
