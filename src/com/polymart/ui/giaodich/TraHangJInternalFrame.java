package com.polymart.ui.giaodich;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.polymart.entity.EntityFrame;
import com.polymart.model.HoaDonTraHangModel;
import com.polymart.service.IHoaDonTraHangService;
import com.polymart.service.impl.HoaDonTraHangService;
import com.polymart.ui.common.uiCommon;
import com.toedter.calendar.JDateChooser;

public class TraHangJInternalFrame extends JInternalFrame {

    private static final long serialVersionUID = -4824323272953818563L;

    private JPanel contentPane;
    private JPanel panel = new JPanel();
    private JPanel panel1 = new JPanel();
    private JPanel hangHoaJPanel = new JPanel();

    private JTextField txtTimPhieuNhap;
    private JFrame optionKiemKhoFrame = new JFrame();
    private JPanel panelOption;
    private JTable tableTraHang;
    private DefaultTableModel modelTraHang;

    private IHoaDonTraHangService hoaDonTraHangService = new HoaDonTraHangService();

    private List<HoaDonTraHangModel> lstHoaDonTraHangModels = hoaDonTraHangService.findAll();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TraHangJInternalFrame frame = new TraHangJInternalFrame();
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
    public TraHangJInternalFrame() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        modelTraHang = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setBounds(100, 100, 1920, 639);
        setFocusable(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setBounds(68, 120, 96, 20);
        panel.setLayout(new BorderLayout(0, 0));

        contentPane.add(hangHoaJPanel, BorderLayout.WEST);
        panel.add(panel1, BorderLayout.EAST);
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        initTopTraHang();
        initCenterTraHang();
    }

    public void initTopTraHang() {
        JLabel lblNewLabel = new JLabel("Hóa đơn trả hàng            ");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(lblNewLabel, BorderLayout.WEST);

        txtTimPhieuNhap = new JTextField();
        txtTimPhieuNhap.setText("TÌm theo hóa đơn trả hàng hoặc hóa đơn thanh toán");
        panel.add(txtTimPhieuNhap, BorderLayout.CENTER);
        txtTimPhieuNhap.setColumns(10);
        txtTimPhieuNhap.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtTimPhieuNhap.getText().equals("TÌm theo hóa đơn trả hàng hoặc hóa đơn thanh toán")) {
                    txtTimPhieuNhap.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtTimPhieuNhap.getText().equals("")) {
                    txtTimPhieuNhap.setText("TÌm theo hóa đơn trả hàng hoặc hóa đơn thanh toán");
                }
            }
        });

        JButton btnTimKiem = new JButton("Tìm kiếm");
        panel1.add(btnTimKiem);
        JLabel lblNewLabel_1 = new JLabel(String.format("%60s", " "));
        panel1.add(lblNewLabel_1);

        JButton btnThemPhieuNhap = new JButton("+ Thêm mới ");
        panel1.add(btnThemPhieuNhap);
        JButton btnXoa = new JButton("- Xoá ");
        panel1.add(btnXoa);
        JButton btnExport = new JButton("→ Xuất file ");
        panel1.add(btnExport);

        optionKiemKhoFrame.setSize(344, 234);
        optionKiemKhoFrame.setLocation(uiCommon.width - 360, uiCommon.height - (uiCommon.height / 100 * 86));
        panelOption = new JPanel();
        panelOption.setLayout(null);
        panelOption.setBackground(Color.white);
        panelOption.setBorder(new EmptyBorder(0, 0, 5, 5));

        optionKiemKhoFrame.getContentPane().add(panelOption);
        optionKiemKhoFrame.setUndecorated(true);

        JComboBox<String> cbbOptionKiemKho = new JComboBox<String>();
        cbbOptionKiemKho.addItem("≡");
        panel1.add(cbbOptionKiemKho);

        btnThemPhieuNhap.addActionListener(openThemHoaDonTraHang);
    }

    public void initCenterTraHang() {
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        JLabel lblNewLabel_9 = new JLabel("Thời gian");

        JDateChooser dateChooser = new JDateChooser();

        JButton btnLocTheoNgay = new JButton("Lọc");
        GroupLayout gl_hangHoaJPanel = new GroupLayout(hangHoaJPanel);
        gl_hangHoaJPanel.setHorizontalGroup(gl_hangHoaJPanel.createParallelGroup(Alignment.TRAILING)
                .addGroup(gl_hangHoaJPanel.createSequentialGroup().addContainerGap()
                        .addGroup(gl_hangHoaJPanel.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLocTheoNgay)
                                .addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        gl_hangHoaJPanel.setVerticalGroup(gl_hangHoaJPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_hangHoaJPanel.createSequentialGroup().addGap(5).addComponent(lblNewLabel_9)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnLocTheoNgay)
                        .addContainerGap(141, Short.MAX_VALUE)));

        hangHoaJPanel.setLayout(gl_hangHoaJPanel);
        panel.add(panel1, BorderLayout.EAST);
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        tableTraHang = new JTable();
        scrollPane.setViewportView(tableTraHang);
        modelTraHang.addColumn("Mã trả hàng");
        modelTraHang.addColumn("Mã thanh toán");
        modelTraHang.addColumn("Thời gian");
        modelTraHang.addColumn("Khách hàng");
        modelTraHang.addColumn("Tổng tiền hoàn trả");
        modelTraHang.addColumn("Ghi chú");
        tableTraHang.setModel(modelTraHang);

        // Click đúp vào 1 hóa đơn sẽ show thông tin lên chiTietHoaDonTraHang
        tableTraHang.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    ChiTietHoaDonTraHang chiTietHoaDonTraHang = new ChiTietHoaDonTraHang();
                    chiTietHoaDonTraHang.setVisible(true);
                }
            }
        });
    }

    ActionListener openThemHoaDonTraHang = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setOpenThemHoaDonTraHang();
        }
    };

    // set sự kiện mở form thêm hóa đơn trả
    private void setOpenThemHoaDonTraHang() {
        ThemTraHangJInternalFrame themHoaDonTraHang = new ThemTraHangJInternalFrame(this);
        EntityFrame.POLYMARTMAIN.pnlMain.add(themHoaDonTraHang);
        themHoaDonTraHang.setVisible(true);
    }

    // hiển thị danh sách hóa đơn trả hàng
    public void showTable(List<HoaDonTraHangModel> lst) {
        if (!lst.isEmpty()) {
            modelTraHang.setRowCount(0);
            for (HoaDonTraHangModel x : lst) {
                return;
            }
        }
    }

    // getDataList
    public List<HoaDonTraHangModel> getData() {
        return lstHoaDonTraHangModels = hoaDonTraHangService.findAll();
    }
}
