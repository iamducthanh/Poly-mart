package com.polymart.ui.nhanvien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Timestamp;
import java.text.ParseException;
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
import com.polymart.dao.impl.ChamCongDAO;
import com.polymart.entity.EntityAuthorization;
import com.polymart.entity.EntityMessage;
import com.polymart.model.ChamCongModel;
import com.toedter.calendar.JCalendar;

public class ChamCongJInternalFrame extends JInternalFrame {

    private static final long serialVersionUID = 1619911861884761168L;

    private JPanel contentPane;
    private DefaultTableModel modelChamCong = new DefaultTableModel();
    private DefaultTableModel modelNhanVienChamCong = new DefaultTableModel();
    private JTextField txtTimKiem;
    private JPanel panel = new JPanel();
    private JPanel nhanVienJPanel = new JPanel();
    private JTable tableChamCong;
    JButton btnChamCong = new JButton("Chấm công");
    JButton btnCheckOut = new JButton("Check Out");
    JCalendar dateChamCong;
    private Calendar calendar;

    private List<ChamCongModel> listChamCong = new ArrayList<ChamCongModel>();

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
        calendar = Calendar.getInstance();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setFocusable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1169, 801);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(75, 0, 130));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        panel.setBackground(Color.WHITE);

        contentPane.add(panel, BorderLayout.NORTH);

        setTitle("Nhân viên - Chấm công");

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(75, 0, 130));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1149, Short.MAX_VALUE)
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtTimKiem = new JTextField();
        txtTimKiem.setEnabled(false);
        txtTimKiem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                timKiemNhanVien();
            }
        });
        txtTimKiem.setText(" TÌm theo mã nhân viên");
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
        JLabel lblNhanVien = new JLabel("Chấm công                        ");
        lblNhanVien.setForeground(new Color(255, 255, 255));
        lblNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 18));
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblNhanVien, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(396, Short.MAX_VALUE))
        );
        gl_panel_1.setVerticalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblNhanVien, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(14, Short.MAX_VALUE))
        );
        panel_1.setLayout(gl_panel_1);
        panel.setLayout(gl_panel);

        nhanVienJPanel.setLayout(new BoxLayout(nhanVienJPanel, BoxLayout.Y_AXIS));
        JLabel lblNewLabel_2 = new JLabel("Loại hàng             ▼");
        lblNewLabel_2.setFont(new Font("Consolas", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        tableChamCong = new JTable();
        tableChamCong.setBackground(Color.WHITE);
        scrollPane.setViewportView(tableChamCong);
        modelChamCong.addColumn("Mã nhân viên");
        modelChamCong.addColumn("Tên nhân viên");
        modelChamCong.addColumn("Ngày");
        modelChamCong.addColumn("Thứ");
        modelChamCong.addColumn("Thời Gian Vào Làm");
        modelChamCong.addColumn("Thời gian Về");
        modelChamCong.addColumn("Trạng Thái");

        tableChamCong.setModel(modelChamCong);

        JPanel panelLeft = new JPanel();
        panelLeft.setBackground(Color.WHITE);
        contentPane.add(panelLeft, BorderLayout.WEST);

        dateChamCong = new JCalendar();
        dateChamCong.getDayChooser().getDayPanel().setBackground(Color.WHITE);
        dateChamCong.getYearChooser().getSpinner().setFont(new Font("Tahoma", Font.PLAIN, 13));
        dateChamCong.getDayChooser().addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("day")) {
                    loadListChamCongNgay();
                    loadTableChamCong();
                    txtTimKiem.setEnabled(false);
                }
            }
        });
        dateChamCong.getMonthChooser().addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("month")) {
                    loadListChamCongThang();
                    loadTableChamCong();
                    txtTimKiem.setEnabled(true);
                }
            }
        });

        JButton btnHomNay = new JButton("Hôm Nay");
        btnHomNay.setForeground(new Color(255, 255, 255));
        btnHomNay.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnHomNay.setBackground(new Color(75, 0, 130));
        btnHomNay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fillTableChamCongHienTai();
                loadTableChamCong();
                txtTimKiem.setEnabled(false);
            }
        });
        btnCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnCheckOut.setBackground(new Color(75, 0, 130));

        btnCheckOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                checkInGioRa();
            }
        });

        GroupLayout gl_panelLeft = new GroupLayout(panelLeft);
        gl_panelLeft.setHorizontalGroup(
                gl_panelLeft.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panelLeft.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panelLeft.createParallelGroup(Alignment.TRAILING, false)
                                        .addComponent(btnHomNay, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dateChamCong, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnChamCong, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCheckOut, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        gl_panelLeft.setVerticalGroup(
                gl_panelLeft.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panelLeft.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(dateChamCong, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnHomNay, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(btnChamCong, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addGap(11)
                                .addComponent(btnCheckOut, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(202, Short.MAX_VALUE))
        );
        btnChamCong.setForeground(new Color(255, 255, 255));
        btnChamCong.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnChamCong.setBackground(new Color(75, 0, 130));
        panelLeft.setLayout(gl_panelLeft);
        modelNhanVienChamCong.addColumn("Mã nhân viên");
        modelNhanVienChamCong.addColumn("Tên nhân viên");
        btnChamCong.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                chamCong();
                btnChamCong.setEnabled(false);
            }
        });

        btnCheckOut.setForeground(new Color(255, 255, 255));

        setPhanQuyen(btnHomNay);

        loadListChamCongNgay();
        loadTableChamCong();
        moNutChamCong();
        moNutCheckUot();

        tableChamCong.setRowHeight(25);
    }

    private void setPhanQuyen(JButton btnHomNay) {
        if (EntityAuthorization.USER.getChucVu().equals(SecurityConfig.VAITRO_BANHANG)) {
            txtTimKiem.setVisible(false);
            dateChamCong.setVisible(false);
            btnHomNay.setVisible(false);
        }
    }

    protected void checkInGioRa() {
        loadListChamCongNgay();
        ChamCongDAO chamCongDao = new ChamCongDAO();
        Date now = new Date();
        int maNhanVien = EntityAuthorization.USER.getId();
        for (ChamCongModel chamCongModel : listChamCong) {
            if (maNhanVien == chamCongModel.getIdNhanVien() && chamCongModel.getGioRa() == null) {
                chamCongModel.setGioRa(new Timestamp(now.getTime()));
                chamCongDao.updateGioRa(chamCongModel);
                loadListChamCongNgay();
                loadTableChamCong();
                return;
            }
        }
    }

    // tìm kiếm nhân viên chấm công trong tháng
    protected void timKiemNhanVien() {
        listChamCong.clear();
        List<ChamCongModel> listTimKiemChamCong = new ArrayList<ChamCongModel>();
        Calendar c = dateChamCong.getCalendar();
        String nam = String.valueOf(c.get(Calendar.YEAR));
        String thang = String.valueOf(c.get(Calendar.MONTH) + 1);
        ChamCongDAO chamCongDao = new ChamCongDAO();
        listTimKiemChamCong = chamCongDao.filterMonth(nam, thang);
        for (ChamCongModel chamCongModel : listTimKiemChamCong) {
            if (String.valueOf(chamCongModel.getIdNhanVien()).toLowerCase().contains(txtTimKiem.getText().toLowerCase())
                    || chamCongModel.getHoTen().toLowerCase().contains(txtTimKiem.getText().toLowerCase())) {
                listChamCong.add(chamCongModel);
            }
        }
        loadTableChamCong();
    }

    // Mở Nút Chấm Công Tự Động
    public void moNutChamCong() {
        Thread th = new Thread() {
            @Override
            public void run() {
                while (true) {
                    Date now = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
                    int i = 0;
                    int j = 0;
                    try {
                        if (calendar.get(Calendar.AM_PM) == Calendar.AM) {
                            i = sdf.parse(sdf.format(now)).compareTo(
                                    sdf.parse("7:30:00 " + new SimpleDateFormat("aa").format(calendar.getTime())));
                            j = sdf.parse(sdf.format(now)).compareTo(
                                    sdf.parse("9:00:00 " + new SimpleDateFormat("aa").format(calendar.getTime())));
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    boolean check = true;
                    for (int k = 0; k < tableChamCong.getRowCount(); k++) {
                        if (EntityAuthorization.USER.getId() == Integer
                                .parseInt(String.valueOf(tableChamCong.getValueAt(k, 0)))) {
                            check = false;
                            break;
                        }
                    }
   
                    if (i == 1 && j == -1 && check == true) {
                        btnChamCong.setEnabled(true);
                    } else {
                    	btnChamCong.setEnabled(false);
                    }
                    if (j == 1) {
                        return;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {

                    }
                }
            }
        };
        th.start();
    }

    // Mở Nút Check out
    public void moNutCheckUot() {
        Thread th = new Thread() {
            @Override
            public void run() {
                while (true) {
                    Date now = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
                    int i = 0;
                    int j = 0;
                    try {
                        if (calendar.get(Calendar.AM_PM) == Calendar.PM) {
                            i = sdf.parse(sdf.format(now)).compareTo(
                                    sdf.parse("2:30:00 " + new SimpleDateFormat("aa").format(calendar.getTime())));
                            j = sdf.parse(sdf.format(now)).compareTo(
                                    sdf.parse("9:30:00 " + new SimpleDateFormat("aa").format(calendar.getTime())));
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    boolean check = true;
                    for (int k = 0; k < tableChamCong.getRowCount(); k++) {
                        if (EntityAuthorization.USER.getId() == Integer
                                .parseInt(String.valueOf(tableChamCong.getValueAt(k, 0)))
                                && String.valueOf(tableChamCong.getValueAt(k, 5)).equals("")) {
                            check = false;
                            break;
                        }
                    }
                    if (i == 1 && j == -1 && check == false) {
                        btnCheckOut.setEnabled(true);
                    } else {
                        btnCheckOut.setEnabled(false);

                    }
                    if (j == 1) {
                        return;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
        };
        th.start();

    }

    // chấm công cho nhân viên
    protected void chamCong() {
        calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
//		int day = calendar.get(Calendar.DATE);
//		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
        int maNhanVien = EntityAuthorization.USER.getId();
        String hoTen = EntityAuthorization.USER.getHoTen();
        for (int i = 0; i < tableChamCong.getRowCount(); i++) {
            if (maNhanVien == Integer.parseInt(String.valueOf(tableChamCong.getValueAt(i, 0)))) {
                EntityMessage.show(null, "Bạn Đã Được Chấm Công ");
                return;
            }
        }
//		int i = 0;
//		try {
//			if (calendar.get(Calendar.AM_PM) == Calendar.AM) {
//				i = sdf.parse(sdf.format(now))
//						.compareTo(sdf.parse("8:00:00 " + new SimpleDateFormat("aa").format(calendar.getTime())));
//			}
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		modelChamCong.addRow(new Object[] { maNhanVien, hoTen, new SimpleDateFormat("yyyy-MM-dd").format(now),
//				day == 0 ? "Chủ Nhật" : day + 1, sdf.format(now), i == -1 ? "Đúng Giờ" : "Đi Muộn" });
        ChamCongModel chamCong = new ChamCongModel();
        chamCong.setHoTen(hoTen);
        chamCong.setIdNhanVien(maNhanVien);
        chamCong.setNgayChamCong(new Timestamp(now.getTime()));
        ChamCongDAO chamCongDao = new ChamCongDAO();
        chamCongDao.save(chamCong);
        loadListChamCongNgay();
        loadTableChamCong();
    }

    // load bảng chấm công nhân viên theo ngày trên lịch
    private void loadListChamCongNgay() {
        listChamCong.clear();
        Calendar c = dateChamCong.getCalendar();
        String nam = String.valueOf(c.get(Calendar.YEAR));
        String thang = String.valueOf(c.get(Calendar.MONTH) + 1);
        String ngay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
        ChamCongDAO chamCongDao = new ChamCongDAO();
        listChamCong = chamCongDao.filterDay(nam, thang, ngay);
    }

    // load bảng chấm công của ngày hiện tại
    public void fillTableChamCongHienTai() {
        listChamCong.clear();
        Calendar c = Calendar.getInstance();
        String nam = String.valueOf(c.get(Calendar.YEAR));
        String thang = String.valueOf(c.get(Calendar.MONTH) + 1);
        String ngay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
        ChamCongDAO chamCongDao = new ChamCongDAO();
        listChamCong = chamCongDao.filterDay(nam, thang, ngay);
    }

    // danh sách chấm công nhân viên tháng
    private void loadListChamCongThang() {
        listChamCong.clear();
        Calendar c = dateChamCong.getCalendar();
        String nam = String.valueOf(c.get(Calendar.YEAR));
        String thang = String.valueOf(c.get(Calendar.MONTH) + 1);
        ChamCongDAO chamCongDao = new ChamCongDAO();
        listChamCong = chamCongDao.filterMonth(nam, thang);
    }


    // load bảng chấm công
    private void loadTableChamCong() {
        Calendar c = Calendar.getInstance();
        modelChamCong.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
        for (ChamCongModel chamCongModel : listChamCong) {
            c.setTime(chamCongModel.getNgayChamCong());
            int day = c.get(Calendar.DAY_OF_WEEK);
            int i = 0;
            String gioChamCong = sdf.format(chamCongModel.getNgayChamCong());
            try {
                i = sdf.parse(gioChamCong)
                        .compareTo(sdf.parse("8:00:00 " + new SimpleDateFormat("aa").format(c.getTime())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            int j = -1;
            if (chamCongModel.getGioRa() != null) {
                String gioRa = sdf.format(chamCongModel.getGioRa());
                try {
                    j = sdf.parse(gioRa).compareTo(
                            sdf.parse("9:00:00 " + new SimpleDateFormat("aa").format(calendar.getTime())));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            String trangThai;
            String gioRa = "";
            try {
                gioRa = sdf.format(chamCongModel.getGioRa());
            } catch (Exception e) {
            }
            if (i == 1) {
                trangThai = "Đi Muộn";
            } else {
                trangThai = "Đúng Giờ";
            }
            if (gioRa.length() > 0) {
                if (j == 1 || j == 0) {
                    trangThai = trangThai + ", Về Đúng Giờ";
                } else {
                    trangThai = trangThai + ", Về Sớm";
                }
            }
            modelChamCong.addRow(new Object[]{chamCongModel.getIdNhanVien(), chamCongModel.getHoTen(),
                    new SimpleDateFormat("dd-MM-yyyy").format(chamCongModel.getNgayChamCong()),
                    day == 1 ? "Chủ Nhật" : day, sdf.format(chamCongModel.getNgayChamCong()), gioRa, trangThai});
        }
    }
}
