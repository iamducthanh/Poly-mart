package com.polymart.ui.thongke;

import java.awt.BorderLayout;
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
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.polymart.service.impl.ThongKeService;
import com.polymart.ui.common.uiCommon;

public class ThongKeDoanhSoJInternalFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8758462980711626613L;
	private JPanel contentPane;
	private JTable tableThongKe;
	JPanel panelContent = new JPanel();
	JScrollPane scrollPaneBang = new JScrollPane();
	ChartPanel chartPanel;

	//DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
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
		((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 848, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Thống kê doanh số");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addContainerGap(634, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("Lựa chọn hiển thị");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblNewLabel_1_1 = new JLabel("Năm");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(10)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(20, Short.MAX_VALUE)
					.addComponent(cbbNam, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbbNam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(293, Short.MAX_VALUE))
		);
		
		JRadioButton rdoTheoBang = new JRadioButton("Theo bảng");
		rdoTheoBang.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton rdoBieuDo = new JRadioButton("Biểu đồ");
		rdoBieuDo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(rdoBieuDo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
						.addComponent(rdoTheoBang, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(rdoTheoBang)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdoBieuDo)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		panel_1.setLayout(gl_panel_1);
		
		contentPane.add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(new BorderLayout(0, 0));
				
		tableThongKe = new JTable();
		scrollPaneBang.setViewportView(tableThongKe);
		
		ButtonGroup gr = new ButtonGroup();
		gr.add(rdoBieuDo);
		gr.add(rdoTheoBang);
		rdoTheoBang.setSelected(true);
		
		tableThongKe = new JTable();
		scrollPaneBang.setViewportView(tableThongKe);
		modelThongKe.addColumn("Tháng");
		modelThongKe.addColumn("Sản phẩm bán");
		modelThongKe.addColumn("Doanh thu");
		tableThongKe.setModel(modelThongKe);
		
	//	rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
	//	tableThongKe.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
	//	tableThongKe.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
	//	tableThongKe.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
		
		try {
			fillCbbYear();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadTableDoanhThu();		
		rdoBieuDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadBieuDoDoanhThu(modelThongKe);
				rdoTheoBang.setSelected(true);
			}
		});
		cbbNam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTableDoanhThu();		

			}
		});
	}
	
	public void loadTableDoanhThu() {
		modelThongKe.setRowCount(0);
		ThongKeService thongKeService = new ThongKeService();
		for(int i = 1; i< 13;i++) {
			ResultSet resultSet = thongKeService.loadTableThongKeDoanhThu((String) cbbNam.getSelectedItem(), String.valueOf(i));
			try {
				while(resultSet.next()) {

					if(resultSet.getString(1) == null) {
						modelThongKe.addRow(new Object[] {"Tháng "+i, 0,0});
					} else {
						modelThongKe.addRow(new Object[] {"Tháng "+i, resultSet.getString(2),fm.format(resultSet.getDouble(1))});
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		panelContent.add(scrollPaneBang, BorderLayout.CENTER);
		scrollPaneBang.setVisible(true);
	}
	
	public void loadBieuDoDoanhThu(DefaultTableModel model) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(int i=1;i<13;i++) {
			String so = String.valueOf(model.getValueAt(i-1, 2));
			Double soNguoi = Double.parseDouble(so);
			String month = "Tháng "+i;
			dataset.addValue(soNguoi, "Doanh thu", month);
		}
		JFreeChart barChart = ChartFactory.createBarChart("Biểu đồ thống kê doanh thu trong năm", "Tháng", "Doanh thu", dataset, PlotOrientation.VERTICAL, false, false, false);
        chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        JFrame frame = new JFrame();
        frame.getContentPane().add(chartPanel);
        frame.setTitle("Biểu đồ thống kê doanh thu trong năm");
        frame.setSize(new uiCommon().width / 100 *90, new uiCommon().height / 100 * 80);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
	}

	
	public void fillCbbYear() throws SQLException {
		ResultSet cbbYear = new ThongKeService().findYear();
		while(cbbYear.next()) {
			try {
				cbbNam.addItem(cbbYear.getString(1));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
