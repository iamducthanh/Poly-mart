package com.polymart.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.polymart.entity.EntityFrame;
import com.toedter.calendar.JDateChooser;

public class NhapHangJInternalFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7230782299903914961L;
	private JPanel contentPane;
	JPanel panel = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel hangHoaJPanel = new JPanel();
	
	private JTextField txtTimPhieuNhap;
	JFrame optionKiemKhoFrame = new JFrame();
	private JPanel panelOption;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	
	//component nhap hanh chi tiet
	private JTextField txtSoLuong;
	private JTextField txtMaSP;
	private JTextField txtNguoiNhap;
	private JTextField txtMaPhieu;
	private JLabel lblSLng;
	private JLabel lblMSnPhm;
	private JLabel lblNgiNhp;
	private JLabel lblNgunHng;
	private JLabel lblGhiCh;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhapHangJInternalFrame frame = new NhapHangJInternalFrame();
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
	public NhapHangJInternalFrame() {
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	setBounds(100, 100, 1920, 639);
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
		
	//	initTopNhapHang();
	//	initCenterNhapHang();
		//initFrameThem();
	}
	
	public void initTopNhapHang() {
		setTitle("Hàng hóa - Kiểm kho");

		JLabel lblNewLabel = new JLabel("Hóa đơn nhập hàng                       ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNewLabel, BorderLayout.WEST);
		
		txtTimPhieuNhap = new JTextField();
		txtTimPhieuNhap.setText(" TÌm theo mã phiếu nhập");
		panel.add(txtTimPhieuNhap, BorderLayout.CENTER);
		txtTimPhieuNhap.setColumns(10);
		txtTimPhieuNhap.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTimPhieuNhap.getText().equals(" TÌm theo mã phiếu nhập")) {
					txtTimPhieuNhap.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTimPhieuNhap.getText().equals("")) {
					txtTimPhieuNhap.setText(" TÌm theo mã phiếu nhập");
				}
			}
		});
		JLabel lblNewLabel_1 = new JLabel(String.format("%60s", " "));
		panel1.add(lblNewLabel_1);
		
		JButton btnThemPhieuNhap = new JButton("+ Thêm mới ");
		panel1.add(btnThemPhieuNhap);
		JButton btnExport = new JButton("→ Xuất file ");
		panel1.add(btnExport);

		optionKiemKhoFrame.setSize(344, 234);
		optionKiemKhoFrame.setLocation(uiCommon.width - 360, uiCommon.height - (uiCommon.height/100*86));
		panelOption = new JPanel();
		panelOption.setLayout(null);
		panelOption.setBackground(Color.white) ;
		panelOption.setBorder(new EmptyBorder(0, 0, 5, 5));
		
		optionKiemKhoFrame.getContentPane().add(panelOption);
		optionKiemKhoFrame.setUndecorated(true);

		JComboBox<String> cbbOptionKiemKho = new JComboBox<String>();
		cbbOptionKiemKho.addItem("≡");
		panel1.add(cbbOptionKiemKho);

		btnThemPhieuNhap.addActionListener(openThemPhieuNhapHang);
		
	}
	
	public void initCenterNhapHang() {
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		JLabel lblNewLabel_9 = new JLabel("Thời gian");
		
		JDateChooser dateChooser = new JDateChooser();
		
		JButton btnLocTheoNgay = new JButton("Lọc");
		GroupLayout gl_hangHoaJPanel = new GroupLayout(hangHoaJPanel);
		gl_hangHoaJPanel.setHorizontalGroup(
			gl_hangHoaJPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_hangHoaJPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_hangHoaJPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLocTheoNgay)
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_hangHoaJPanel.setVerticalGroup(
			gl_hangHoaJPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_hangHoaJPanel.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_9)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnLocTheoNgay)
					.addContainerGap(141, Short.MAX_VALUE))
		);
		
		hangHoaJPanel.setLayout(gl_hangHoaJPanel);
		panel.add(panel1, BorderLayout.EAST);
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		table = new JTable();
		scrollPane.setViewportView(table);
		model.addColumn("Mã phiếu");
		model.addColumn("Ngày");
		model.addColumn("Giá");
		model.addColumn("Số lượng");
		model.addColumn("Mã sản phẩm");
		model.addColumn("Người nhập");
		model.addColumn("Nguồn hàng");
		model.addColumn("Ghi chú");
		table.setModel(model);

		// table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		table.getColumnModel().getColumn(0).setPreferredWidth(50);
//		table.getColumnModel().getColumn(1).setPreferredWidth(120);
//		table.getColumnModel().getColumn(2).setPreferredWidth(150);
//		table.getColumnModel().getColumn(3).setPreferredWidth(120);
//		table.getColumnModel().getColumn(4).setPreferredWidth(120);
//		table.getColumnModel().getColumn(5).setPreferredWidth(120);
//		table.getColumnModel().getColumn(6).setPreferredWidth(100);
//		table.getColumnModel().getColumn(7).setPreferredWidth(130);
//		table.getColumnModel().getColumn(8).setPreferredWidth(130);
//		table.getColumnModel().getColumn(9).setPreferredWidth(130);
		
		
	}

	ActionListener openThemPhieuNhapHang = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ThemNhapHangJInternalFrame themNhapHangJInternalFrame = new ThemNhapHangJInternalFrame();
			EntityFrame.POLYMARTMAIN.desktopPane.add(themNhapHangJInternalFrame);
			themNhapHangJInternalFrame.setVisible(true);
			
		}
	};
}
