package com.polymart.ui.baocao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.BoxLayout;
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
import javax.swing.table.DefaultTableModel;

import com.polymart.config.SecurityConfig;
import com.polymart.dao.impl.ChiTieuDao;
import com.polymart.entity.EntityAuthorization;
import com.polymart.entity.EntityMessage;
import com.polymart.entity.EntityValidate;
import com.polymart.model.ChiTieuModel;
import com.polymart.ui.common.uiCommon;
import com.toedter.calendar.JCalendar;

import java.awt.Color;

public class BaoCaoChiTieuJInternalFrame extends JInternalFrame {

    private static final long serialVersionUID = 5684359871253902201L;

    private JPanel contentPane;
    DefaultTableModel modelChiTieu = new DefaultTableModel();
    JPanel nhanVienJPanel = new JPanel();
    private JTable tableChiTieu;
    JPanel panel = new JPanel();
    private JTextField txtTimKiem;
    static List<ChiTieuModel> list = new ArrayList<ChiTieuModel>();
    JCalendar dateChamCong = new JCalendar();
    ChiTieuDao chiTieu = new ChiTieuDao();
    JButton btnXoa = new JButton("- Xóa");

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new BaoCaoChiTieuJInternalFrame().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public BaoCaoChiTieuJInternalFrame() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setFocusable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1062, 662);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(75, 0, 130));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        panel.setBackground(Color.WHITE);

        contentPane.add(panel, BorderLayout.NORTH);

        setTitle("Báo cáo - Chi tiêu");

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(75, 0, 130));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(Alignment.TRAILING)
                        .addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE)
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(Alignment.TRAILING)
                        .addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
                                .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnXoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                xoaPhieuChi();
                btnXoa.setEnabled(false);
            }
        });

        JButton btnThem = new JButton("+ Thêm");
        btnThem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                themMoi();
            }
        });

        txtTimKiem = new JTextField();
        txtTimKiem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                timKiemChiTieu();
            }
        });
        txtTimKiem.setText(" TÌm theo mã , Mục Đích Chi Tiêu");
        txtTimKiem.setColumns(10);
        txtTimKiem.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtTimKiem.getText().equals(" TÌm theo mã , Mục Đích Chi Tiêu")) {
                    txtTimKiem.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtTimKiem.getText().equals("")) {
                    txtTimKiem.setText(" TÌm theo mã , Mục Đích Chi Tiêu");
                }
            }
        });
        JLabel lblNhanVien = new JLabel("Chi tiêu              ");
        lblNhanVien.setForeground(new Color(255, 255, 255));
        lblNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 18));
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblNhanVien, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED, 540, Short.MAX_VALUE)
                                .addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
        );
        gl_panel_1.setVerticalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
                                .addContainerGap(14, Short.MAX_VALUE)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNhanVien, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        panel_1.setLayout(gl_panel_1);
        panel.setLayout(gl_panel);

        uiCommon.editButtonTop(btnThem);
        uiCommon.editButtonTop(btnXoa);

        nhanVienJPanel.setLayout(new BoxLayout(nhanVienJPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        tableChiTieu = new JTable();
        tableChiTieu.setBackground(Color.WHITE);
        tableChiTieu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnXoa.setEnabled(true);
            }
        });
        scrollPane.setViewportView(tableChiTieu);

        modelChiTieu.addColumn("Mã Chi Tiêu");
        modelChiTieu.addColumn("Người Xuất Phiếu");
        modelChiTieu.addColumn("Mục đích chi tiêu");
        modelChiTieu.addColumn("Ngày chi tiêu");
        modelChiTieu.addColumn("Số tiền");
        modelChiTieu.addColumn("Ghi chú");

        tableChiTieu.setModel(modelChiTieu);

        JPanel panelLeft = new JPanel();
        panelLeft.setBackground(Color.WHITE);
        contentPane.add(panelLeft, BorderLayout.WEST);
        dateChamCong.getDayChooser().addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("day")) {
                    timKiemTheoNgay();
                }
            }
        });

        JButton btnNewButton = new JButton("Hôm Nay");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(138, 43, 226));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timChiTieuHomNay();
            }
        });

        JButton btnAll = new JButton("Tất Cả");
        btnAll.setForeground(new Color(255, 255, 255));
        btnAll.setBackground(new Color(138, 43, 226));
        btnAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                xemTatCa();
            }
        });

        JButton btnXemLaiLichSu = new JButton("Lịch Sử Phiếu Đã Xóa");
        btnXemLaiLichSu.setForeground(new Color(255, 255, 255));
        btnXemLaiLichSu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                xemLichSuXoaPhieu();
            }
        });
        btnXemLaiLichSu.setBackground(new Color(138, 43, 226));
        GroupLayout gl_panelLeft = new GroupLayout(panelLeft);
        gl_panelLeft.setHorizontalGroup(
                gl_panelLeft.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panelLeft.createSequentialGroup()
                                .addGap(5)
                                .addGroup(gl_panelLeft.createParallelGroup(Alignment.TRAILING, false)
                                        .addComponent(btnXemLaiLichSu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAll, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(dateChamCong, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                                .addGap(5))
        );
        gl_panelLeft.setVerticalGroup(
                gl_panelLeft.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panelLeft.createSequentialGroup()
                                .addGap(5)
                                .addComponent(dateChamCong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnAll, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnXemLaiLichSu, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(262, Short.MAX_VALUE))
        );
        dateChamCong.getDayChooser().getDayPanel().setBackground(Color.WHITE);
        dateChamCong.getMonthChooser().addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("month")) {
                    timChiTieuThang();
                }
            }
        });
        panelLeft.setLayout(gl_panelLeft);
        tableChiTieu.setRowHeight(25);

        loadList();
        fillTable();

        setPhanQuyen(btnThem, btnXemLaiLichSu);
    }

    private void setPhanQuyen(JButton btnThem, JButton btnXemLaiLichSu) {
        if (EntityAuthorization.USER.getChucVu().equals(SecurityConfig.VAITRO_QUANLY)) return;
        btnXemLaiLichSu.setVisible(false);
        btnThem.setVisible(false);
        btnXoa.setVisible(false);
        if (EntityAuthorization.USER.getChucVu().equals(SecurityConfig.VAITRO_QUANLY)) {
            btnXemLaiLichSu.setVisible(true);
            btnThem.setVisible(true);
            btnXoa.setVisible(true);
        }
    }

    // Xóa Phiếu Chi Tiêu
    protected void xoaPhieuChi() {
        if (!EntityMessage.confirm(null, "Bạn Có Chắc Chắn Muốn Xóa Không")) {
            return;
        }
        int select = tableChiTieu.getSelectedRow();
        String maCT = String.valueOf(tableChiTieu.getValueAt(select, 0));
        int id = Integer.parseInt(maCT.replace("PC", ""));
        Date now = new Date();
        String ghiChu = EntityAuthorization.USER.getHoTen() + " Đã Xóa Vào " + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a").format(now);
        chiTieu.delete(id, ghiChu);
        loadList();
        fillTable();
    }

    // tìm kiếm phiếu chi tiêu theo mã chi tiêu hoặc theo mục đích
    protected void timKiemChiTieu() {
        if (txtTimKiem.getText().isBlank()) {
//			modelChiTieu.setRowCount(0);
            return;
        }
        list.clear();
        List<ChiTieuModel> listAll = new ArrayList<ChiTieuModel>();
        listAll = chiTieu.findAll();
        for (ChiTieuModel chiTieuModel : listAll) {
            String mucDichChiTieu = chiTieuModel.getMucDichChiTieu().toLowerCase();
            String timKiem = txtTimKiem.getText().toLowerCase();
            String maCT = "PC" + String.valueOf(chiTieuModel.getMaCT());
            if (maCT.toLowerCase().contains(timKiem) || mucDichChiTieu.contains(timKiem)) {
                list.add(chiTieuModel);
            }
        }
        fillTable();
    }

    protected void themMoi() {
        ThemBaoCaoChiTieuFrame themBaoCaoChiTieuFrame = new ThemBaoCaoChiTieuFrame(this);
        themBaoCaoChiTieuFrame.setVisible(true);
        themBaoCaoChiTieuFrame.setLocationRelativeTo(null);
    }

    protected void xemLichSuXoaPhieu() {
        list.clear();
        ChiTieuDao chiTieuDao = new ChiTieuDao();
        list = chiTieuDao.findAllLichSuXoa();
        fillTable();

    }

    // Xem Tất Cả Phiếu Chi
    protected void xemTatCa() {
        loadList();
        fillTable();
    }

    // Tìm Phiếu Chi Ngày Hiện Tại
    protected void timChiTieuHomNay() {
        list.clear();
        Calendar calendar = Calendar.getInstance();
        int nam = calendar.get(Calendar.YEAR);
        int thang = calendar.get(Calendar.MONTH) + 1;
        int ngay = calendar.get(Calendar.DAY_OF_MONTH);
        list = chiTieu.findTheoNgay(nam, thang, ngay);
        fillTable();

    }

    // Tìm Tất Cả Phiếu Chi Của Tháng Đã Chọn
    protected void timChiTieuThang() {
        list.clear();
        Calendar calendar = dateChamCong.getCalendar();
        int nam = calendar.get(Calendar.YEAR);
        int thang = calendar.get(Calendar.MONTH) + 1;
        list = chiTieu.findTheoThang(nam, thang);
        fillTable();

    }

    // Tìm Tất Cả Phiếu Chi Theo NGày Đc Chọn
    protected void timKiemTheoNgay() {
        list.clear();
        Calendar calendar = dateChamCong.getCalendar();
        int nam = calendar.get(Calendar.YEAR);
        int thang = calendar.get(Calendar.MONTH) + 1;
        int ngay = calendar.get(Calendar.DAY_OF_MONTH);
        list = chiTieu.findTheoNgay(nam, thang, ngay);
        fillTable();
    }

    // load list chi tiêu
    public void loadList() {
        list.clear();
        list = chiTieu.findAll();
    }

    // load table Chi Tiêu
    public void fillTable() {
        modelChiTieu.setRowCount(0);
        if (list.size() > 0) {
            for (ChiTieuModel x : list) {
                modelChiTieu.addRow(new Object[]{"PC" + x.getMaCT(), x.getHoTen(), x.getMucDichChiTieu(),
                        x.getNgayChiTieu(), EntityValidate.dinhDangMonney(x.getSoTien()), x.getGhiChu()});
            }
            btnXoa.setEnabled(false);
        }
    }
}
