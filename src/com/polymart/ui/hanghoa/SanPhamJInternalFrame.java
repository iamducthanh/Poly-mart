package com.polymart.ui.hanghoa;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.polymart.config.SecurityConfig;
import com.polymart.dao.impl.LoaiSanPhamDAO;
import com.polymart.dao.impl.SanPhamDAO;
import com.polymart.entity.EntityAuthorization;
import com.polymart.entity.EntityMessage;
import com.polymart.service.ILoaiSanPhamService;
import com.polymart.service.ISanPhamService;
import com.polymart.service.impl.LoaiSanPhamService;
import com.polymart.service.impl.SanPhamService;

import com.polymart.model.LoaiSanPhamModel;
import com.polymart.model.SanPhamModel;
import com.polymart.ui.common.uiCommon;

public class SanPhamJInternalFrame extends JInternalFrame {

    /**
     *
     */
    private static final long serialVersionUID = 3314858072598500922L;
    private JPanel contentPane;

    private JTextField txtTim;
    private JTable tableNguonHang;
    private JTextField txtTenSanPham;
    private JComboBox cbbLoaiSP;
    private JTextArea txtMoTa;
    private JRadioButton rdoDangKinhDoanh;
    private JRadioButton rdoNgungKinhDoanh;
    private DefaultTableModel modelSanPham;
    private JButton btnCapNhat = new JButton("Cập nhật");
    private JButton btnThem = new JButton("Thêm");
    private JButton btnTaoMoi = new JButton("Tạo mới");

    private ISanPhamService sanPhamService = new SanPhamService();
    private ILoaiSanPhamService loaiSanPhamService = new LoaiSanPhamService();

    private List<SanPhamModel> lstSanPham = sanPhamService.findAll();
    private List<LoaiSanPhamModel> lstLoaiSanPham = loaiSanPhamService.findAll();

    private LoaiSanPhamModel loaiSanPhamModel;
    private SanPhamModel sanPhamModel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SanPhamJInternalFrame frame = new SanPhamJInternalFrame();
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
    public SanPhamJInternalFrame() {
        modelSanPham = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
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
                        .addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE)
        );
        gl_panel_1.setVerticalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addComponent(panel, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                .addGap(22))
        );

        txtTim = new JTextField();
        txtTim.setBorder(null);
        txtTim.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 14));
        txtTim.setText(" Tìm theo mã, tên sản phẩm");
        txtTim.setColumns(10);
        txtTim.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                findSanPham(modelSanPham);
            }
        });
        txtTim.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtTim.getText().equals(" Tìm theo mã, tên sản phẩm")) {
                    txtTim.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtTim.getText().equals("")) {
                    txtTim.setText(" Tìm theo mã, tên sản phẩm");
                }
            }
        });

        JLabel lblNewLabel = new JLabel("Sản phẩm");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(txtTim, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(308, Short.MAX_VALUE))
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
                                .addContainerGap(14, Short.MAX_VALUE)
                                .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel)
                                        .addComponent(txtTim, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        panel.setLayout(gl_panel);
        panel_1.setLayout(gl_panel_1);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.WHITE);
        contentPane.add(panel_2, BorderLayout.EAST);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(Color.WHITE);
        panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chi ti\u1EBFt s\u1EA3n ph\u1EA9m ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

        GroupLayout gl_panel_2 = new GroupLayout(panel_2);
        gl_panel_2.setHorizontalGroup(
                gl_panel_2.createParallelGroup(Alignment.TRAILING)
                        .addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(11, Short.MAX_VALUE))
                        .addGroup(gl_panel_2.createSequentialGroup()
                                .addContainerGap(184, Short.MAX_VALUE)
                                .addComponent(btnTaoMoi, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        btnThem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addSP();
            }
        });
        btnCapNhat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                update();
            }
        });
        btnTaoMoi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });
        gl_panel_2.setVerticalGroup(
                gl_panel_2.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_2.createSequentialGroup()
                                .addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
                                .addGap(72)
                                .addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnTaoMoi, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(56, Short.MAX_VALUE))
        );
        btnTaoMoi.setBackground(new Color(255, 255, 255));

        JLabel lblNewLabel_2 = new JLabel("Tên sản phẩm");
        lblNewLabel_2.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 16));

        txtTenSanPham = new JTextField();
        txtTenSanPham.setBackground(Color.WHITE);
        txtTenSanPham.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtTenSanPham.setColumns(10);

        JLabel lblNewLabel_2_1 = new JLabel("Mô tả");
        lblNewLabel_2_1.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 16));

        JLabel lblNewLabel_2_1_1 = new JLabel("Trạng thái");
        lblNewLabel_2_1_1.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 16));

        JScrollPane scrollPane_1 = new JScrollPane();

        rdoDangKinhDoanh = new JRadioButton("Đang kinh doanh");
        rdoDangKinhDoanh.setBackground(new Color(255, 255, 255));
        rdoDangKinhDoanh.setFont(new Font("Tahoma", Font.PLAIN, 14));

        rdoNgungKinhDoanh = new JRadioButton("Ngừng kinh doanh");
        rdoNgungKinhDoanh.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rdoNgungKinhDoanh.setBackground(Color.WHITE);

        JLabel lblNewLabel_2_2 = new JLabel("Loại sản phẩm");
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));

        cbbLoaiSP = new JComboBox();
        fillCbxLoaiSp(cbbLoaiSP);
        JButton btnThemLoai = new JButton("Thêm loại");
        btnThemLoai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveLoaiSanPham();
            }
        });

        ButtonGroup gr = new ButtonGroup();
        gr.add(rdoNgungKinhDoanh);
        gr.add(rdoDangKinhDoanh);

        JButton btnSua = new JButton("Sửa");
        btnSua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateLoaiSP();
            }
        });
        uiCommon.editButtonCenter(btnSua);
        GroupLayout gl_panel_3 = new GroupLayout(panel_3);
        gl_panel_3.setHorizontalGroup(
                gl_panel_3.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_3.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_3.createSequentialGroup()
                                                .addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_panel_3.createSequentialGroup()
                                                                .addGap(10)
                                                                .addComponent(rdoDangKinhDoanh)
                                                                .addGap(18)
                                                                .addComponent(rdoNgungKinhDoanh, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                                                        .addComponent(txtTenSanPham, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                                                        .addGroup(gl_panel_3.createSequentialGroup()
                                                                .addComponent(btnThemLoai, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(cbbLoaiSP, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap())
                                        .addGroup(gl_panel_3.createSequentialGroup()
                                                .addComponent(lblNewLabel_2_1_1, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                                .addGap(263))))
        );
        gl_panel_3.setVerticalGroup(
                gl_panel_3.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_3.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(cbbLoaiSP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
                                        .addComponent(btnThemLoai, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                                .addGap(28)
                                .addComponent(lblNewLabel_2)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(txtTenSanPham, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addGap(7)
                                .addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(rdoDangKinhDoanh)
                                        .addComponent(rdoNgungKinhDoanh, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(102, Short.MAX_VALUE))
        );

        txtMoTa = new JTextArea();
        scrollPane_1.setViewportView(txtMoTa);
        panel_3.setLayout(gl_panel_3);
        panel_2.setLayout(gl_panel_2);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        tableNguonHang = new JTable();
        scrollPane.setViewportView(tableNguonHang);
        modelSanPham.addColumn("ID sản phẩm");
        modelSanPham.addColumn("Tên sản phẩm");
        modelSanPham.addColumn("Loại sản phẩm");
        modelSanPham.addColumn("Mô tả");
        modelSanPham.addColumn("Trạng thái");
        loadTable(modelSanPham);
        tableNguonHang.setModel(modelSanPham);
        tableNguonHang.setRowSelectionInterval(0, 0);
        loadInfo(0);
        tableNguonHang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadInfo(tableNguonHang.getSelectedRow());
            }
        });
        uiCommon.editButtonCenter(btnThem);
        uiCommon.editButtonCenter(btnThemLoai);
        uiCommon.editButtonCenter(btnCapNhat);
        uiCommon.editButtonCenter(btnTaoMoi);

        setChucVu(btnThemLoai, btnSua);

    }

    private void setChucVu(JButton btnThemLoai, JButton btnSua) {
        if (EntityAuthorization.USER.getChucVu().equals(SecurityConfig.VAITRO_QUANLY)) {
            return;
        }
        btnThemLoai.setVisible(false);
        btnSua.setVisible(false);
        btnThem.setVisible(false);
        btnCapNhat.setVisible(false);
        btnTaoMoi.setVisible(false);
        if (EntityAuthorization.USER.getChucVu().equals(SecurityConfig.VAITRO_THUNGAN)) {
            btnThemLoai.setVisible(true);
            btnThem.setVisible(true);
            btnTaoMoi.setVisible(true);
        }
    }

    private void saveLoaiSanPham() {
        try {
            String nameLoaiSanPham = JOptionPane.showInputDialog("Nhập tên loại sản phẩm mới");
            if (nameLoaiSanPham.isBlank()) {
                JOptionPane.showMessageDialog(null, "Chưa nhập tên loại sản phẩm");
            } else {
                if (loaiSanPhamService.findByName(nameLoaiSanPham)) {
                    JOptionPane.showMessageDialog(null, "Loại sản phẩm đã tồn tại");
                } else {
                    loaiSanPhamModel = new LoaiSanPhamModel();
                    loaiSanPhamModel.setTenLoaiSP(nameLoaiSanPham);
                    if (loaiSanPhamService.saveLoaiSanPham(loaiSanPhamModel)) {
                        JOptionPane.showMessageDialog(null, "Thêm loại sản phẩm thành công");
                        fillCbxLoaiSp(cbbLoaiSP);
                    } else {
                        EntityMessage.show(this, "Thêm loại sản phẩm thất bại");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            EntityMessage.show(this, "Thao tác thất bại");
        }
    }

    public void loadInfo(int row) {
        cbbLoaiSP.setSelectedItem(String.valueOf( tableNguonHang.getValueAt(row, 2)));
        txtTenSanPham.setText(String.valueOf( tableNguonHang.getValueAt(row, 1)));
        txtMoTa.setText(String.valueOf( tableNguonHang.getValueAt(row, 3)));
        if (tableNguonHang.getValueAt(row, 4).toString().equals("Đang kinh doanh")) rdoDangKinhDoanh.setSelected(true);
        else rdoNgungKinhDoanh.setSelected(true);
    }

    public String getTenLoaiSpById(int id) {
        for (LoaiSanPhamModel x : new LoaiSanPhamDAO().findAll()) {
            if (x.getId() == id) return x.getTenLoaiSP();
        }
        return null;
    }

    public void loadTable(DefaultTableModel model) {
        model.setRowCount(0);
        for (SanPhamModel x : new SanPhamDAO().findAll()) {
            model.addRow(new Object[]{
                    x.getId(), x.getTenSP(), getTenLoaiSpById(x.getIdLoaiSP()), x.getMoTa(),
                    x.isStatusKinhDoanh() ? "Đang kinh doanh" : "Ngừng kinh doanh"
            });
        }
    }

    public void fillCbxLoaiSp(JComboBox cbx) {
        cbx.removeAllItems();
        for (LoaiSanPhamModel x : new LoaiSanPhamDAO().findAll()) {
            cbx.addItem(x.getTenLoaiSP());
        }
    }

    public void addSP() {
        try {
            String getNameSanPham = txtTenSanPham.getText();
            String getNameLoaiSanPham = cbbLoaiSP.getSelectedItem().toString();
            if (getNameSanPham.isBlank()) {
                JOptionPane.showMessageDialog(null, "Chưa nhập tên sản phẩm");
            } else {
                sanPhamModel = sanPhamService.findByNameSPAndNameLoai(getNameSanPham, getNameLoaiSanPham);
                if (sanPhamModel != null) {
                    JOptionPane.showMessageDialog(null, "Sản phẩm bị trùng lặp");
                } else {
                    sanPhamModel = new SanPhamModel();
                    sanPhamModel.setTenSP(getNameSanPham);
                    sanPhamModel.setIdLoaiSP(lstLoaiSanPham.get(cbbLoaiSP.getSelectedIndex()).getId());
                    sanPhamModel.setStatusKinhDoanh(rdoDangKinhDoanh.isSelected());
                    sanPhamModel.setMoTa(txtMoTa.getText());
                    if (sanPhamService.saveSanPham(sanPhamModel)) {
                        EntityMessage.show(this, "Thêm sản phẩm thành công");
                        loadTable(modelSanPham);
                    } else {
                        EntityMessage.show(this, "Thêm sản phẩm thất bại");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            EntityMessage.show(this, "Thao tác thất bại");
        }
    }


    public void update() {
        try {
            int row = tableNguonHang.getSelectedRow();
            if (row > -1 && row < tableNguonHang.getRowCount()) {
                sanPhamModel = lstSanPham.get(row);
                String getNameSanPham = txtTenSanPham.getText();
                if (getNameSanPham.isBlank()) {
                    EntityMessage.show(this, "Tên sản phẩm không được để trống");
                    return;
                }
                sanPhamModel.setTenSP(txtTenSanPham.getText());
                sanPhamModel.setIdLoaiSP(lstLoaiSanPham.get(cbbLoaiSP.getSelectedIndex()).getId());
                sanPhamModel.setStatusKinhDoanh(rdoDangKinhDoanh.isSelected());
                sanPhamModel.setMoTa(txtMoTa.getText());
                if (sanPhamService.updateSanPham(sanPhamModel)) {
                    EntityMessage.show(this, "Sửa sản phẩm thành công");
                    loadTable(modelSanPham);
                } else {
                    EntityMessage.show(this, "Sửa sản phẩm thất bại");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            EntityMessage.show(this, "Thao tác thất bại");
        }
    }

    public void clear() {
        cbbLoaiSP.setSelectedIndex(0);
        txtTenSanPham.setText("");
        txtMoTa.setText("");
        rdoDangKinhDoanh.setSelected(true);
    }

    List<SanPhamModel> lstSearch = new ArrayList<SanPhamModel>();

    protected void findSanPham(DefaultTableModel model) {
        lstSearch.removeAll(lstSearch);
        try {
            try {
                int id = Integer.parseInt(txtTim.getText());
                lstSearch = sanPhamService.searchByID(id);
            } catch (Exception e) {
                lstSearch = sanPhamService.findByName(txtTim.getText());
            }
            model.setRowCount(0);
            if (lstSearch.size() > 0) {
                for (SanPhamModel x : lstSearch) {
                    model.addRow(new Object[]{
                            x.getId(), x.getTenSP(), getTenLoaiSpById(x.getIdLoaiSP()), x.getMoTa(),
                            x.isStatusKinhDoanh() ? "Đang kinh doanh" : "Ngừng kinh doanh"
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateLoaiSP() { //đây afuk kiem tra lai cho tìm by name sao ko đc

        int i = 0;
        LoaiSanPhamModel loaispModel = new LoaiSanPhamModel();
        String tenloai = JOptionPane.showInputDialog("Sửa tên loại sản phẩm", cbbLoaiSP.getSelectedItem().toString());
        for (LoaiSanPhamModel x : lstLoaiSanPham) {
            if (x.getTenLoaiSP().trim().equalsIgnoreCase(tenloai.trim())) i++;
        }
        if (i > 0) {
            JOptionPane.showMessageDialog(null, "Loại sản phẩm đã tồn tại");
            return;
        } else {
            try {
                if (tenloai.isBlank()) {
                    JOptionPane.showMessageDialog(null, "Chưa nhập loại sản phẩm");
                    return;
                } else {
                    loaispModel.setTenLoaiSP(tenloai);
                    loaispModel.setId(lstLoaiSanPham.get(cbbLoaiSP.getSelectedIndex()).getId());
                    new LoaiSanPhamDAO().update(loaispModel);
                    JOptionPane.showMessageDialog(null, "Sửa thành công sản phẩm: " + cbbLoaiSP.getSelectedItem().toString() + " thành: " + tenloai);
                }
            } catch (Exception e2) {
                // TODO: handle exception
                JOptionPane.showMessageDialog(null, "Thao tác thất bại");
            }
        }
        fillCbxLoaiSp(cbbLoaiSP);
        loadTable(modelSanPham);
    }
}

