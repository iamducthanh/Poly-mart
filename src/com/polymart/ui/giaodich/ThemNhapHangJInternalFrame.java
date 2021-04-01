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
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.polymart.entity.EntityValidate;
import com.polymart.model.ChiTietSanPhamModel;
import com.polymart.service.IChiTietSanPhamService;
import com.polymart.service.ISanPhamService;
import com.polymart.service.impl.ChiTietSanPhamService;
import com.polymart.service.impl.SanPhamService;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.polymart.model.NguonHangModel;
import com.polymart.service.INguonHangService;
import com.polymart.service.impl.NguonHangService;

import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class ThemNhapHangJInternalFrame extends JInternalFrame {

    private static final long serialVersionUID = -4001431086652454768L;

    private JPanel contentPane;
    DefaultTableModel modelDSSanPham = new DefaultTableModel();
    DefaultTableModel modelDSNhapHang = new DefaultTableModel();

    private INguonHangService iNguonHangService = new NguonHangService();
    private IChiTietSanPhamService iChiTietSanPhamService = new ChiTietSanPhamService();
    private ISanPhamService iSanPhamService = new SanPhamService();
    private JTextField txtTimKiem;
    private JTable tableDSSanPham;
    private JTextField txtSoLgNhap;
    private JTable tableDSNhapHang;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ThemNhapHangJInternalFrame frame = new ThemNhapHangJInternalFrame();
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
    public ThemNhapHangJInternalFrame() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1920, 639);

        setFocusable(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.NORTH);

        JButton btnQuayLai = new JButton("<-   ");
        btnQuayLai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });
        btnQuayLai.setContentAreaFilled(false);
        btnQuayLai.setBorder(null);
        btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 17));

        JLabel lblNewLabel = new JLabel("Nhập hàng           ");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
        
        txtTimKiem = new JTextField();
        txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtTimKiem.setText(" Tìm theo tên hoặc mã sản phẩm");
        txtTimKiem.setColumns(10);
        
        JButton btnTimKiem = new JButton("Tìm kiếm");
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(5)
        			.addComponent(btnQuayLai)
        			.addGap(5)
        			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
        			.addGap(5)
        			.addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
        			.addGap(557))
        );
        gl_panel_1.setVerticalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(5)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
        					.addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        					.addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        				.addComponent(btnQuayLai, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_1.setLayout(gl_panel_1);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_3 = new JPanel();
        panel.add(panel_3, BorderLayout.NORTH);
        
        JPanel panel_4 = new JPanel();
        panel.add(panel_4, BorderLayout.SOUTH);
        
        txtSoLgNhap = new JTextField();
        txtSoLgNhap.setColumns(10);
        
        JButton btnLuuTam = new JButton("Lưu tạm");
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Số lượng nhập: ");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        GroupLayout gl_panel_4 = new GroupLayout(panel_4);
        gl_panel_4.setHorizontalGroup(
        	gl_panel_4.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_4.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(txtSoLgNhap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(btnLuuTam, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
        			.addGap(952))
        );
        gl_panel_4.setVerticalGroup(
        	gl_panel_4.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtSoLgNhap, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnLuuTam, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        panel_4.setLayout(gl_panel_4);
        
        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), " Th\u00F4ng tin s\u1EA3n ph\u1EA9m ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.add(panel_5, BorderLayout.CENTER);
        panel_5.setLayout(new BorderLayout(0, 0));
        
        JScrollPane scrollPane = new JScrollPane();
        panel_5.add(scrollPane, BorderLayout.CENTER);
        
        tableDSSanPham = new JTable();
        scrollPane.setViewportView(tableDSSanPham);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), " Nh\u1EADp h\u00E0ng ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        contentPane.add(panel_2, BorderLayout.SOUTH);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        
                JComboBox<Object> cbbNguonHang = new JComboBox<Object>();
                cbbNguonHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
                cbbNguonHang.setModel(new DefaultComboBoxModel<Object>(new String[]{"Chọn nguồn hàng"}));
                
                        // đổ dữ liệu lên combobox nguồn hàng
                        setCbbNguonHang(iNguonHangService.findAll(), cbbNguonHang);
        
                JLabel lblNewLabel_1_1 = new JLabel("Ghi chú");
                lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        JScrollPane scrollPane_2 = new JScrollPane();
        
        JLabel lblNewLabel_1 = new JLabel("Thành tiền", JLabel.RIGHT);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        
        JLabel lblThanhTien = new JLabel("10 củ", SwingConstants.RIGHT);
        lblThanhTien.setFont(new Font("Tahoma", Font.BOLD, 20));
        
        JButton btnHoanThanh = new JButton("Hoàn thành");
        GroupLayout gl_panel_2 = new GroupLayout(panel_2);
        gl_panel_2.setHorizontalGroup(
        	gl_panel_2.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_2.createSequentialGroup()
        			.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
        			.addGap(18)
        			.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
        						.addComponent(cbbNguonHang, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
        					.addGap(81))
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addComponent(btnHoanThanh, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(lblThanhTien, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(scrollPane_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
        					.addContainerGap())))
        );
        gl_panel_2.setVerticalGroup(
        	gl_panel_2.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel_2.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addComponent(cbbNguonHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(lblNewLabel_1_1)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblNewLabel_1)
        					.addGap(18)
        					.addComponent(lblThanhTien, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(btnHoanThanh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())
        				.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)))
        );
        
        JTextArea txtGhiChu = new JTextArea();
        scrollPane_2.setViewportView(txtGhiChu);
        
        tableDSNhapHang = new JTable();
        scrollPane_1.setViewportView(tableDSNhapHang);
        panel_2.setLayout(gl_panel_2);
        modelDSSanPham.addColumn("Mã sản phẩm");
        modelDSSanPham.addColumn("Tên sản phẩm");
        modelDSSanPham.addColumn("Loại");
        modelDSSanPham.addColumn("Đơn giá");
        modelDSSanPham.addColumn("Size");
        modelDSSanPham.addColumn("Màu sắc");
        modelDSSanPham.addColumn("Số lượng tồn kho");
        tableDSSanPham.setModel(modelDSSanPham);
        
        modelDSNhapHang.addColumn("Mã sản phẩm");
        modelDSNhapHang.addColumn("Tên sản phẩm");
        modelDSNhapHang.addColumn("Loại");
        modelDSNhapHang.addColumn("Đơn giá");
        modelDSNhapHang.addColumn("Size");
        modelDSNhapHang.addColumn("Màu sắc");
        modelDSNhapHang.addColumn("Số lượng nhập");
        tableDSNhapHang.setModel(modelDSNhapHang);
        
		txtTimKiem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTimKiem.getText().equals(" Tìm theo tên hoặc mã sản phẩm")) {
					txtTimKiem.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTimKiem.getText().equals("")) {
					txtTimKiem.setText(" Tìm theo tên hoặc mã sản phẩm");
				}
			}
		});
    }

    public void close() {
        this.setVisible(false);
    }

    // hàm đổ dữ liệu tên nguồn hàng lên combobox
    private void setCbbNguonHang(List<NguonHangModel> lstNguonHang, JComboBox cbbNguonHang) {
        if (lstNguonHang != null && !lstNguonHang.isEmpty()) {
            // lstNguonHang.stream().map(e -> e.getTenNguonHang()).collect(Collectors.toList()
            // lấy một danh sách một thuộc tính nhanh
            cbbNguonHang.setModel(new DefaultComboBoxModel<>((lstNguonHang.stream()
                    .map(e -> e.getTenNguonHang()).collect(Collectors.toList())).toArray()));
        }
    }

    // hàm đổ dữ liệu tên sản phẩm lên combobox
    private void setCbbTimSanPham(List<ChiTietSanPhamModel> lstChiTietSanPhamModels,
                                  JComboBox cbbTimSanPham) {
        cbbTimSanPham.setModel(new DefaultComboBoxModel((lstChiTietSanPhamModels.stream()
                .map(e -> e.getId() + " - " + e.getIdSanPham()).collect(Collectors.toList()).toArray())));
    }

    // sự kiện khi bâm nút thêm sản phảm vào hóa đơn và show lên table
    private void themSanPham(JComboBox cbbChonSanPham, JTextField txtSoLuong) {
        String getSoLuong = txtSoLuong.getText();
        if (EntityValidate.checkIntDuong(this, getSoLuong)) {
            int getCbcIndexSanPham = cbbChonSanPham.getSelectedIndex();
            modelDSSanPham.addRow(new Object[]{

            });
        }
    }
}
