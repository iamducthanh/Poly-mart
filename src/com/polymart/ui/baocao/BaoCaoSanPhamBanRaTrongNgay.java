package com.polymart.ui.baocao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

public class BaoCaoSanPhamBanRaTrongNgay extends JInternalFrame {

	private static final long serialVersionUID = 1619911861884761168L;

	private JPanel contentPane;
	private DefaultTableModel modelBaoCao = new DefaultTableModel();
	private JPanel panel = new JPanel();
	private JPanel nhanVienJPanel = new JPanel();
	private JTable tableBaoCao;
	JCalendar dateNgayBaoCao;
	private Calendar calendar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaoCaoSanPhamBanRaTrongNgay frame = new BaoCaoSanPhamBanRaTrongNgay();
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
	public BaoCaoSanPhamBanRaTrongNgay() {
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

		initTopChamCong();
		initCenterChamCong();

		tableBaoCao.setRowHeight(25);
	}

	public void initTopChamCong() {
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
		JLabel lblNhanVien = new JLabel("Báo cáo sản phẩm bán ra trong ngày");
		lblNhanVien.setForeground(new Color(255, 255, 255));
		lblNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNhanVien, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(839, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNhanVien, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
	}

	public void initCenterChamCong() {
		nhanVienJPanel.setLayout(new BoxLayout(nhanVienJPanel, BoxLayout.Y_AXIS));
		JLabel lblNewLabel_2 = new JLabel("Loại hàng             ▼");
		lblNewLabel_2.setFont(new Font("Consolas", Font.BOLD, 14));
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		tableBaoCao = new JTable();
		tableBaoCao.setBackground(Color.WHITE);
		scrollPane.setViewportView(tableBaoCao);
		modelBaoCao.addColumn("Mã sản phẩm");
		modelBaoCao.addColumn("Tên sản phẩm");
		modelBaoCao.addColumn("Số lượng");
		modelBaoCao.addColumn("S");
		modelBaoCao.addColumn("M");
		modelBaoCao.addColumn("L");
		modelBaoCao.addColumn("X");
		modelBaoCao.addColumn("XL");
		modelBaoCao.addColumn("XXL");
		modelBaoCao.addColumn("XXXL");
		modelBaoCao.addColumn("Tổng số lượng bán");
		tableBaoCao.setModel(modelBaoCao);


		tableBaoCao.getColumnModel().getColumn(3).setPreferredWidth(30);
		tableBaoCao.getColumnModel().getColumn(4).setPreferredWidth(30);
		tableBaoCao.getColumnModel().getColumn(5).setPreferredWidth(30);
		tableBaoCao.getColumnModel().getColumn(6).setPreferredWidth(30);
		tableBaoCao.getColumnModel().getColumn(7).setPreferredWidth(30);
		tableBaoCao.getColumnModel().getColumn(8).setPreferredWidth(30);
		tableBaoCao.getColumnModel().getColumn(9).setPreferredWidth(30);

		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(Color.WHITE);
		contentPane.add(panelLeft, BorderLayout.WEST);

		dateNgayBaoCao = new JCalendar();
		dateNgayBaoCao.getDayChooser().getDayPanel().setBackground(Color.WHITE);
		dateNgayBaoCao.getYearChooser().getSpinner().setFont(new Font("Tahoma", Font.PLAIN, 13));
		dateNgayBaoCao.getDayChooser().addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {

			}
		});
		dateNgayBaoCao.getMonthChooser().addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {

			}
		});

		GroupLayout gl_panelLeft = new GroupLayout(panelLeft);
		gl_panelLeft.setHorizontalGroup(
			gl_panelLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLeft.createSequentialGroup()
					.addContainerGap()
					.addComponent(dateNgayBaoCao, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelLeft.setVerticalGroup(
			gl_panelLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLeft.createSequentialGroup()
					.addContainerGap()
					.addComponent(dateNgayBaoCao, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(380, Short.MAX_VALUE))
		);
		panelLeft.setLayout(gl_panelLeft);

	}

    
}
