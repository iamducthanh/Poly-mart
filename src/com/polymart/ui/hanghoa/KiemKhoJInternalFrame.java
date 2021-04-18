package com.polymart.ui.hanghoa;

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

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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

import com.polymart.entity.EntityImage;
import com.polymart.ui.common.uiCommon;
import com.toedter.calendar.JDateChooser;

public class KiemKhoJInternalFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6162070307493626902L;
	private JPanel contentPane;
	private JTextField txtTimKiemKho;
	JPanel panel = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel hangHoaJPanel = new JPanel();
	JFrame optionKiemKhoFrame = new JFrame();
	private JPanel panelOption;
	private JTable tableKiemKho;
	DefaultTableModel model = new DefaultTableModel();

	JCheckBox chkPhieuTam = new JCheckBox("Phiếu tạm");
	JCheckBox chkCanBangKho = new JCheckBox("Đã cân bằng kho");
	JCheckBox chkDaHuy = new JCheckBox("Đã hủy");

	JCheckBox chkMaKiemKho = new JCheckBox("Mã kiểm kho");
	JCheckBox chkThoiGian = new JCheckBox("Thời gian");
	JCheckBox chkNguoiTao = new JCheckBox("Người tạo");
	JCheckBox chkNguoiCanBang = new JCheckBox("Nguời cân bằng");
	JCheckBox chkNgayCanBang = new JCheckBox("Ngày cân bằng");
	JCheckBox chkSLThucTe = new JCheckBox("Số lượng thực tế");
	JCheckBox chkTongThucTe = new JCheckBox("Tổng thực tế");
	JCheckBox chkTongChenhLech = new JCheckBox("Tổng chênh lệch");
	JCheckBox chkTongGiaTriLech = new JCheckBox("Tổng giá trị lệch");
	JCheckBox chkSLLechTang = new JCheckBox("Số lượng lệch tăng");
	JCheckBox chkTongGiaTriTang = new JCheckBox("Tổng giá trị tăng");
	JCheckBox chkSLLechGiam = new JCheckBox("Số lượng lệch giảm");
	JCheckBox chkTongGiaTriGiam = new JCheckBox("Tổng giá trị giảm");
	JCheckBox chkGhiChu = new JCheckBox("Ghi chú");
	JCheckBox chkTrangThaiKK = new JCheckBox("Trạng thái");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KiemKhoJInternalFrame frame = new KiemKhoJInternalFrame();
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
	public KiemKhoJInternalFrame() {
		((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
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
		initTopKiemKho();
		initCenterKiemKho();
		tableKiemKho.setRowHeight(25);

	}

	public void initTopKiemKho() {
		setTitle("Hàng hóa - Kiểm kho");

		JLabel lblNewLabel = new JLabel("Phiếu kiểm kho          ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNewLabel, BorderLayout.WEST);

		txtTimKiemKho = new JTextField();
		txtTimKiemKho.setText(" TÌm theo mã phiếu kiểm");
		panel.add(txtTimKiemKho, BorderLayout.CENTER);
		txtTimKiemKho.setColumns(10);
		txtTimKiemKho.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTimKiemKho.getText().equals(" TÌm theo mã phiếu kiểm")) {
					txtTimKiemKho.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTimKiemKho.getText().equals("")) {
					txtTimKiemKho.setText(" TÌm theo mã phiếu kiểm");
				}
			}
		});

		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\search.png", 20, 20)));
		panel1.add(btnNewButton);
		JLabel lblNewLabel_1 = new JLabel(String.format("%60s", " "));
		panel1.add(lblNewLabel_1);

		JButton btnKiemKho = new JButton("Kiểm kho ");
		btnKiemKho.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\themoi.png", 20, 20)));

		panel1.add(btnKiemKho);
		JButton btnExport = new JButton("Xuất file ");
		btnExport.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\export.png", 20, 20)));
		panel1.add(btnExport);

		optionKiemKhoFrame.setSize(344, 234);
		optionKiemKhoFrame.setLocation(uiCommon.width - 360, uiCommon.height - (uiCommon.height / 100 * 86));
		panelOption = new JPanel();
		panelOption.setLayout(null);
		panelOption.setBackground(Color.white);
		panelOption.setBorder(new EmptyBorder(0, 0, 5, 5));
		uiCommon uiCommon = new uiCommon(panelOption);

		uiCommon.addCheckBox(chkMaKiemKho, 10, 7, 150);
		uiCommon.addCheckBox(chkThoiGian, 10, 33, 150);
		uiCommon.addCheckBox(chkNguoiTao, 10, 59, 150);
		uiCommon.addCheckBox(chkNguoiCanBang, 10, 85, 150);
		uiCommon.addCheckBox(chkNgayCanBang, 10, 111, 150);

		uiCommon.addCheckBox(chkSLThucTe, 10, 137, 150);
		uiCommon.addCheckBox(chkTongThucTe, 10, 163, 150);
		uiCommon.addCheckBox(chkTongChenhLech, 10, 189, 150);

		uiCommon.addCheckBox(chkTongGiaTriLech, 160, 7, 178);
		uiCommon.addCheckBox(chkSLLechTang, 160, 163, 178);
		uiCommon.addCheckBox(chkTongGiaTriTang, 160, 137, 178);
		uiCommon.addCheckBox(chkSLLechGiam, 160, 111, 178);
		uiCommon.addCheckBox(chkTongGiaTriGiam, 160, 85, 178);
		uiCommon.addCheckBox(chkGhiChu, 160, 59, 99);
		uiCommon.addCheckBox(chkTrangThaiKK, 160, 33, 99);

		optionKiemKhoFrame.getContentPane().add(panelOption);
		optionKiemKhoFrame.setUndecorated(true);

		JComboBox<String> cbbOptionKiemKho = new JComboBox<String>();
		cbbOptionKiemKho.addItem("≡");
		panel1.add(cbbOptionKiemKho);
		cbbOptionKiemKho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				optionKiemKhoFrame.setVisible(true);
			}
		});

		cbbOptionKiemKho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				optionKiemKhoFrame.setVisible(true);

			}
		});

		optionKiemKhoFrame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				optionKiemKhoFrame.setVisible(false);

			}
		});

	}

	public void initCenterKiemKho() {
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		JLabel lblNewLabel_9 = new JLabel("Thời gian");

		JDateChooser dateChooser = new JDateChooser();

		JLabel lblNewLabel_10 = new JLabel("Trạng thái                                   ▼");
		JPanel left = new JPanel();
		GroupLayout gl_hangHoaJPanel = new GroupLayout(hangHoaJPanel);
		gl_hangHoaJPanel.setHorizontalGroup(gl_hangHoaJPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_hangHoaJPanel.createSequentialGroup().addContainerGap()
						.addGroup(gl_hangHoaJPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(left, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
								.addComponent(dateChooser, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 167,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_9, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 84,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_10, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 177,
										Short.MAX_VALUE))
						.addContainerGap()));
		gl_hangHoaJPanel.setVerticalGroup(gl_hangHoaJPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_hangHoaJPanel.createSequentialGroup().addGap(5).addComponent(lblNewLabel_9)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(lblNewLabel_10).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(left, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(39, Short.MAX_VALUE)));
		left.setLayout(null);

		chkPhieuTam.setBounds(6, 7, 99, 23);
		left.add(chkPhieuTam);

		chkCanBangKho.setBounds(6, 33, 139, 23);
		left.add(chkCanBangKho);

		chkDaHuy.setBounds(6, 59, 99, 23);
		left.add(chkDaHuy);
		hangHoaJPanel.setLayout(gl_hangHoaJPanel);
		panel.add(panel1, BorderLayout.EAST);
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		tableKiemKho = new JTable();
		scrollPane.setViewportView(tableKiemKho);
		model.addColumn("Mã kiểm kho");
		model.addColumn("Thời gian");
		model.addColumn("Ngày cân bằng");
		model.addColumn("SL thực tế");
		model.addColumn("Tổng thực tế");
		model.addColumn("Tổng chênh lệch");
		model.addColumn("Số lượng lệch tăng");
		model.addColumn("Số lượng lệch giảm");
		model.addColumn("Ghi chú");
		tableKiemKho.setModel(model);

		// table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableKiemKho.getColumnModel().getColumn(0).setPreferredWidth(120);
		tableKiemKho.getColumnModel().getColumn(1).setPreferredWidth(150);
		tableKiemKho.getColumnModel().getColumn(2).setPreferredWidth(120);
		tableKiemKho.getColumnModel().getColumn(3).setPreferredWidth(120);
		tableKiemKho.getColumnModel().getColumn(4).setPreferredWidth(120);
		tableKiemKho.getColumnModel().getColumn(5).setPreferredWidth(100);
		tableKiemKho.getColumnModel().getColumn(6).setPreferredWidth(130);
		tableKiemKho.getColumnModel().getColumn(7).setPreferredWidth(130);
		tableKiemKho.getColumnModel().getColumn(8).setPreferredWidth(130);
	}

}
