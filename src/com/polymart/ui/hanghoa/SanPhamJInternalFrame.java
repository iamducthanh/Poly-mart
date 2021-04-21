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

import com.polymart.model.NguonHangModel;
import com.polymart.service.INguonHangService;
import com.polymart.service.impl.NguonHangService;
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
	DefaultTableModel modelNguonHang = new DefaultTableModel();
	private INguonHangService nguonHangService = new NguonHangService();
	private List<NguonHangModel> listNguonHang;
	JButton btnCapNhat = new JButton("Cập nhật");
	JButton btnThem = new JButton("Thêm");
	JButton btnMoi = new JButton("Tạo mới");

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
					.addComponent(btnMoi, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
					.addGap(72)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMoi, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		btnMoi.setBackground(new Color(255, 255, 255));

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
		
		JRadioButton rdoDangKinhDoanh = new JRadioButton("Đang kinh doanh");
		rdoDangKinhDoanh.setBackground(new Color(255, 255, 255));
		rdoDangKinhDoanh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JRadioButton rdoNgungKinhDoanh = new JRadioButton("Ngừng kinh doanh");
		rdoNgungKinhDoanh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdoNgungKinhDoanh.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_2_2 = new JLabel("Loại sản phẩm");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JComboBox<Object> cbbLoaiSP = new JComboBox<Object>();
		
		JButton btnThemLoai = new JButton("Thêm loại");
		btnThemLoai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String loaiSP = JOptionPane.showInputDialog("Nhập loại sản phẩm mới");
			}
		});
		
		ButtonGroup gr = new ButtonGroup();
		gr.add(rdoNgungKinhDoanh);
		gr.add(rdoDangKinhDoanh);
		
		JButton btnSua = new JButton("Sửa");
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
		
		JTextArea txtMoTa = new JTextArea();
		scrollPane_1.setViewportView(txtMoTa);
		panel_3.setLayout(gl_panel_3);
		panel_2.setLayout(gl_panel_2);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		tableNguonHang = new JTable();
		scrollPane.setViewportView(tableNguonHang);
		modelNguonHang.addColumn("ID sản phẩm");
		modelNguonHang.addColumn("Tên sản phẩm");
		modelNguonHang.addColumn("Mô tả");
		modelNguonHang.addColumn("Trạng thái");
		tableNguonHang.setModel(modelNguonHang);
		
		uiCommon.editButtonCenter(btnThem);
		uiCommon.editButtonCenter(btnThemLoai);
		uiCommon.editButtonCenter(btnCapNhat);
		uiCommon.editButtonCenter(btnMoi);

	}
}
