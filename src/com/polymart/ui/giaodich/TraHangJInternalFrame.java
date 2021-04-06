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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
import com.polymart.entity.EntityMessage;
import com.polymart.entity.EntityValidate;
import com.polymart.model.*;
import com.polymart.service.*;
import com.polymart.service.impl.*;
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
    private IChiTietHoaDonThanhToanService chiTietHoaDonThanhToanService = new ChiTietHoaDonThanhToanService();
    private IChiTietHoaDonTraHangService chiTietHoaDonTraHangService = new ChiTietHoaDonTraHangService();
    private IChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamService();

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
        txtTimPhieuNhap.setText("TÌm theo hóa đơn trả hàng");
        panel.add(txtTimPhieuNhap, BorderLayout.CENTER);
        txtTimPhieuNhap.setColumns(10);
        txtTimPhieuNhap.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtTimPhieuNhap.getText().equals("TÌm theo hóa đơn trả hàng")) {
                    txtTimPhieuNhap.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtTimPhieuNhap.getText().equals("")) {
                    txtTimPhieuNhap.setText("TÌm theo hóa đơn trả hàng");
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

        // tìm kiếm
        btnTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evtBtnTim(txtTimPhieuNhap);
            }
        });

        // xóa
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evtBtnXoa(tableTraHang);
            }
        });
    }

    public void initCenterTraHang() {
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        JLabel lblNewLabel_9 = new JLabel("Thời gian");

        JDateChooser dateChooser = new JDateChooser(new Date());

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
                setOpenThemHoaDonTraHang(mouseEvent);
            }
        });

        // hiển thị danh sách hóa đơn trả
        showTable(lstHoaDonTraHangModels);

        // btn lọc theo ngày
        btnLocTheoNgay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evtBtnLoc(dateChooser);
            }
        });

    }

    private void setOpenThemHoaDonTraHang(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
            int row = tableTraHang.getSelectedRow();
            if (row > -1 && row < tableTraHang.getRowCount()) {
                String getMaHoaDon = tableTraHang.getValueAt(row, 0).toString();
                HoaDonTraHangModel hoaDonTraHangModel =
                        lstHoaDonTraHangModels.stream().filter(e -> e.getId().equals(Integer.parseInt(getMaHoaDon)))
                                .collect(Collectors.toList()).get(0);
                List<ChiTietHoaDonTraHangModel> lstChiTiet = chiTietHoaDonTraHangService.findByIdHoaDonTraHang(hoaDonTraHangModel.getId());
                if (!lstChiTiet.isEmpty()) {
                    ChiTietHoaDonTraHang chiTietHoaDonTraHang = new ChiTietHoaDonTraHang(lstChiTiet);
                    chiTietHoaDonTraHang.setVisible(true);
                } else {
                    EntityMessage.show(this, "Hóa đơn không có sản phẩm");
                }
            }
        }
        
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
                Object[] result = hoaDonTraHangService.getDataTableById(x.getId());
                if (result != null) {
                    modelTraHang.addRow(new Object[]{
                            result[0],
                            result[1],
                            new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(result[2]),
                            result[3],
                            result[4],
                            x.getGhiChu()
                    });
                }
            }
        }
    }

    // tìm theo hóa đơn trả hàng
    private void evtBtnTim(JTextField txtTimPhieuNhap) {
        String getTimKiem = txtTimPhieuNhap.getText();
        if (getTimKiem.equals("TÌm theo hóa đơn trả hàng")) {
            showTable(getData());
        } else {
            if (EntityValidate.checkIdNumber(this, getTimKiem)) {
                List<HoaDonTraHangModel> lstTim = hoaDonTraHangService.findById(Integer.parseInt(getTimKiem));
                if (lstTim.isEmpty()) {
                    EntityMessage.show(this, "Mã hóa đơn không tồn tại");
                } else {
                    lstHoaDonTraHangModels = lstTim;
                    showTable(lstHoaDonTraHangModels);
                }
            }
        }
    }

    // lọc theo ngày
    private void evtBtnLoc(JDateChooser dateChooser) {
        try {
            Timestamp timestamp = new Timestamp(dateChooser.getCalendar().getTimeInMillis());
            List<HoaDonTraHangModel> lstLoc = hoaDonTraHangService.filterByDate(timestamp);
            if (lstLoc.isEmpty()) {
                EntityMessage.show(this, "Không có hóa đơn nào trong ngày được chọn");
            } else {
                lstHoaDonTraHangModels = lstLoc;
                showTable(lstHoaDonTraHangModels);
            }
        } catch (Exception e) {
            EntityMessage.show(this, "Mời chọn ngày muốn tìm");
        }
    }

    // xóa một hàng trên table
    private void evtBtnXoa(JTable tbDanhSach) {
        int row = tbDanhSach.getSelectedRow();
        if (row > -1 && row < tbDanhSach.getRowCount()) {
            if (EntityMessage.confirm(this, "Thao tác này có thể sẽ bị mất dữ liệu\nĐồng ý xóa?")) {
                HoaDonTraHangModel hoaDonTraHangModel = lstHoaDonTraHangModels.get(row);
                if (hoaDonTraHangService.remove(hoaDonTraHangModel)) {
                    EntityMessage.show(this, "Xóa thành công");
                    modelTraHang.removeRow(row);
                    chiTietHoaDonTraHangService.reloadData();
                    chiTietSanPhamService.reloadData();
                    chiTietHoaDonThanhToanService.reloadData();
                } else {
                    EntityMessage.show(this, "Xóa thất bại");
                }
            }
        } else {
            EntityMessage.show(this, "Vui lòng chọn 1 hàng");
        }
    }

    // getDataList
    public List<HoaDonTraHangModel> getData() {
        return lstHoaDonTraHangModels = hoaDonTraHangService.findAll();
    }
}
