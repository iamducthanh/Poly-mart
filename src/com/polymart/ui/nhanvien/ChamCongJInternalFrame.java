package com.polymart.ui.nhanvien;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BoxLayout;
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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

public class ChamCongJInternalFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1619911861884761168L;
	private JPanel contentPane;
	private DefaultTableModel modelChamCong = new DefaultTableModel();
	private DefaultTableModel modelNhanVienChamCong = new DefaultTableModel();
	private JTextField txtTimKiem;
	private JPanel panel = new JPanel();
	private JPanel nhanVienJPanel = new JPanel();
	private JTable tableChamCong;
	private JTable tableNhanVienChamCong;





	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChamCongJInternalFrame frame = new ChamCongJInternalFrame();
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
	public ChamCongJInternalFrame() {
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1062, 662);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		initTopChamCong();
		initCenterChamCong();
	}
	
	public void initTopChamCong() {
		setTitle("Nhân viên - Chấm công");
		JLabel lblNhanVien = new JLabel("Chấm công                        ");
		lblNhanVien.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNhanVien, BorderLayout.WEST);
		
		JPanel panel1 = new JPanel();
		panel.add(panel1, BorderLayout.EAST);
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel(String.format("%100s", " "));
		panel1.add(lblNewLabel_1);
		
		
	}

	public void initCenterChamCong() {
		nhanVienJPanel.setLayout(new BoxLayout(nhanVienJPanel, BoxLayout.Y_AXIS));
		JLabel lblNewLabel_2 = new JLabel("Loại hàng             ▼");
		lblNewLabel_2.setFont(new Font("Consolas", Font.BOLD, 14));
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		tableChamCong = new JTable();
		scrollPane.setViewportView(tableChamCong);
		modelChamCong.addColumn("Mã nhân viên");
		modelChamCong.addColumn("Tên nhân viên");
		modelChamCong.addColumn("Ngày");
		modelChamCong.addColumn("Thứ");
		modelChamCong.addColumn("Thời gian làm");
		
		
		tableChamCong.setModel(modelChamCong);
		
		JPanel panelLeft = new JPanel();
		contentPane.add(panelLeft, BorderLayout.WEST);
		
		JCalendar dateChamCong = new JCalendar();
		
		JButton btnTimTheoNgay = new JButton("Tìm");
		btnTimTheoNgay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(dateChamCong.getDate());
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		txtTimKiem = new JTextField();
		txtTimKiem.setText(" TÌm theo mã nhân viên");
		txtTimKiem.setColumns(10);
		txtTimKiem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTimKiem.getText().equals(" TÌm theo mã nhân viên")) {
					txtTimKiem.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTimKiem.getText().equals("")) {
					txtTimKiem.setText(" TÌm theo mã nhân viên");
				}
			}
		});
		
		JButton btnTimMaNV = new JButton("TÌm kiếm");
		
		JButton btnChamCong = new JButton("Chấm công");
		GroupLayout gl_panelLeft = new GroupLayout(panelLeft);
		gl_panelLeft.setHorizontalGroup(
			gl_panelLeft.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelLeft.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING)
						.addComponent(dateChamCong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
						.addGroup(gl_panelLeft.createSequentialGroup()
							.addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnTimMaNV))
						.addComponent(btnChamCong, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTimTheoNgay, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panelLeft.setVerticalGroup(
			gl_panelLeft.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelLeft.createSequentialGroup()
					.addContainerGap()
					.addComponent(dateChamCong, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnTimTheoNgay)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelLeft.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTimMaNV, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnChamCong)
					.addGap(39))
		);
		
		tableNhanVienChamCong = new JTable();
		scrollPane_1.setViewportView(tableNhanVienChamCong);
		panelLeft.setLayout(gl_panelLeft);
		modelNhanVienChamCong.addColumn("Mã nhân viên");
		modelNhanVienChamCong.addColumn("Tên nhân viên");
		tableNhanVienChamCong.setModel(modelNhanVienChamCong);
		
		JComboBox<Object> cbbPhongBan = new JComboBox<Object>();
		cbbPhongBan.setModel(new DefaultComboBoxModel<Object>(new String[] {"Tất cả"}));
	}
}
