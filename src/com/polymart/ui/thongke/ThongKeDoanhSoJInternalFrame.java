package com.polymart.ui.thongke;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.polymart.config.SecurityConfig;
import com.polymart.entity.EntityAuthorization;
import com.polymart.service.impl.ThongKeService;
import com.polymart.ui.common.uiCommon;

public class ThongKeDoanhSoJInternalFrame extends JInternalFrame {

	private static final long serialVersionUID = 8758462980711626613L;
	
	private JPanel contentPane;
	private JTable tableThongKe;
	private JTable tableThongKe_1;
	JPanel panelContent = new JPanel();
	JScrollPane scrollPaneBang = new JScrollPane();
	ChartPanel chartPanel;
	JComboBox<String> cbbThang = new JComboBox<String>();
	JComboBox<String> cbbNam = new JComboBox<String>();

	private DefaultTableModel modelThongKe = new DefaultTableModel();
	DecimalFormat fm = new DecimalFormat("#.###");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKeDoanhSoJInternalFrame frame = new ThongKeDoanhSoJInternalFrame();
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
	public ThongKeDoanhSoJInternalFrame() {
		setBackground(new Color(75, 0, 130));
		((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 848, 556);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(75, 0, 130));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(75, 0, 130));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
					.addGap(22))
		);
		
				JLabel lblNewLabel = new JLabel("Thống kê doanh số");
				lblNewLabel.setBackground(new Color(255, 255, 255));
				lblNewLabel.setForeground(new Color(255, 255, 255));
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
				GroupLayout gl_panel_3 = new GroupLayout(panel_3);
				gl_panel_3.setHorizontalGroup(
					gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(21)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(613, Short.MAX_VALUE))
				);
				gl_panel_3.setVerticalGroup(
					gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel)
							.addContainerGap(22, Short.MAX_VALUE))
				);
				panel_3.setLayout(gl_panel_3);
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_1, BorderLayout.WEST);

		JLabel lblNewLabel_1 = new JLabel("Lựa chọn hiển thị");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblNewLabel_1_1 = new JLabel("Năm");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_1_1_1 = new JLabel("Tháng");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(cbbNam, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbbThang, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbbNam, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbbThang, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(197, Short.MAX_VALUE))
		);
		cbbNam.setBackground(new Color(255, 255, 255));

		JRadioButton rdoTheoBang = new JRadioButton("Theo bảng");
		rdoTheoBang.setBackground(new Color(255, 255, 255));
		rdoTheoBang.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JRadioButton rdoBieuDo = new JRadioButton("Biểu đồ");
		rdoBieuDo.setBackground(new Color(255, 255, 255));
		rdoBieuDo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_2.createSequentialGroup().addGap(14)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
								.addComponent(rdoBieuDo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 144,
										Short.MAX_VALUE)
								.addComponent(rdoTheoBang, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 144,
										Short.MAX_VALUE))
						.addContainerGap()));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap().addComponent(rdoTheoBang)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(rdoBieuDo)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);
		panel_1.setLayout(gl_panel_1);
		panelContent.setBackground(new Color(255, 255, 255));

		contentPane.add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(new BorderLayout(0, 0));

		tableThongKe = new JTable();
		tableThongKe.setBackground(Color.WHITE);
		scrollPaneBang.setViewportView(tableThongKe);

		ButtonGroup gr = new ButtonGroup();
		gr.add(rdoBieuDo);
		gr.add(rdoTheoBang);
		rdoTheoBang.setSelected(true);

		tableThongKe_1 = new JTable();
		tableThongKe_1.setBackground(Color.WHITE);
		scrollPaneBang.setViewportView(tableThongKe_1);
		modelThongKe.addColumn("Mã sản phẩm");
		modelThongKe.addColumn("Tên sản phẩm");
		modelThongKe.addColumn("Số lượng bán");
		tableThongKe_1.setModel(modelThongKe);

		// rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		// tableThongKe.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
		// tableThongKe.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
		// tableThongKe.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);

		try {
			fillCbbYear();
			fillCbbMonth();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadTableDoanhSo();
		if(EntityAuthorization.USER.getChucVu().equals(SecurityConfig.VAITRO_BANHANG)) {
			rdoTheoBang.setVisible(false);
			scrollPaneBang.setVisible(true);
			panelContent.removeAll();
		}
		rdoBieuDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadBieuDoDoanhThu(modelThongKe);
				rdoTheoBang.setSelected(true);
			}
		});
		cbbNam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTableDoanhSo();
			}
		});
		
		cbbThang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTableDoanhSo();

			}
		});
		tableThongKe_1.setRowHeight(25);
	}

	public void loadTableDoanhSo() {
		modelThongKe.setRowCount(0);
		ThongKeService thongKeService = new ThongKeService();
		ResultSet tbThongKeDoanhSo = thongKeService.loadTableThongKeDoanhSo((String) cbbNam.getSelectedItem(),
				(String) cbbThang.getSelectedItem());
		try {
			while (tbThongKeDoanhSo.next()) {
				modelThongKe.addRow(new Object[] { tbThongKeDoanhSo.getString(1), tbThongKeDoanhSo.getString(2),
						tbThongKeDoanhSo.getString(3) });
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panelContent.add(scrollPaneBang, BorderLayout.CENTER);
		scrollPaneBang.setVisible(true);
	}

	public void loadBieuDoDoanhThu(DefaultTableModel model) {
		int size = modelThongKe.getRowCount();
		if (size > 10) {
			size = 10;
		}
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = 0; i < size; i++) {
			Double soNguoi = Double.parseDouble(String.valueOf(model.getValueAt(i, 2)));
			dataset.addValue(soNguoi, "Số lượng bán", (Comparable<?>) modelThongKe.getValueAt(i, 1));
		}
		JFreeChart barChart = ChartFactory.createBarChart("Biểu đồ thống kê top 10 sản phẩm bán chạy nhất trong tháng",
				"Sản phẩm", "Số lượng bán ra", dataset, PlotOrientation.VERTICAL, false, false, false);
		chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		JFrame frame = new JFrame();
		frame.getContentPane().add(chartPanel);
		frame.setTitle("Biểu đồ thống kê doanh thu trong năm");
		frame.setSize(new uiCommon().width / 100 * 90, new uiCommon().height / 100 * 80);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public void fillCbbYear() throws SQLException {
		ResultSet cbbYear = new ThongKeService().findYear();
		while (cbbYear.next()) {
			try {
				cbbNam.addItem(cbbYear.getString(1));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void fillCbbMonth() throws SQLException {
		ResultSet cbbMonth = new ThongKeService().findMonth();
		while (cbbMonth.next()) {
			try {
				cbbThang.addItem(cbbMonth.getString(1));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
