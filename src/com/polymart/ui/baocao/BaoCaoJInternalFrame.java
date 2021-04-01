package com.polymart.ui.baocao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;
import javax.swing.LayoutStyle.ComponentPlacement;

public class BaoCaoJInternalFrame extends JInternalFrame {

	private static final long serialVersionUID = 5684359871253902201L;

	private JPanel contentPane;
	DefaultTableModel modelChiTieu = new DefaultTableModel();
	JPanel nhanVienJPanel = new JPanel();
	private JTable tableChiTieu;
	JPanel panel = new JPanel();
	private JTextField txtTimKiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new BaoCaoJInternalFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BaoCaoJInternalFrame() {
		((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1062, 662);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		contentPane.add(panel, BorderLayout.NORTH);

		initTopChiTieu();
		initCenterChiTieu();
	}

	public void initTopChiTieu() {
		setTitle("Báo cáo - Chi tiêu");
		JLabel lblNhanVien = new JLabel("Chi tiêu                              ");
		lblNhanVien.setFont(new Font("Tahoma", Font.BOLD, 18));

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

		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_1 = new JLabel(String.format("%100s", " "));
		panel1.add(lblNewLabel_1);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNhanVien, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNhanVien, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnTimKiem)
							.addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);

	}

	public void initCenterChiTieu() {
		nhanVienJPanel.setLayout(new BoxLayout(nhanVienJPanel, BoxLayout.Y_AXIS));
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		tableChiTieu = new JTable();
		scrollPane.setViewportView(tableChiTieu);
		modelChiTieu.addColumn("Mã nhân viên");
		modelChiTieu.addColumn("Mục đích chi tiêu");
		modelChiTieu.addColumn("Ngày chi tiêu");
		modelChiTieu.addColumn("Số tiền");
		modelChiTieu.addColumn("Ghi chú");

		tableChiTieu.setModel(modelChiTieu);

		JPanel panelLeft = new JPanel();
		contentPane.add(panelLeft, BorderLayout.WEST);

		JCalendar dateChamCong = new JCalendar();

		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(dateChamCong.getDate());
			}
		});
		GroupLayout gl_panelLeft = new GroupLayout(panelLeft);
		gl_panelLeft.setHorizontalGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLeft.createSequentialGroup().addGap(5).addComponent(dateChamCong,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelLeft.createSequentialGroup().addContainerGap().addComponent(btnNewButton)
						.addContainerGap(149, Short.MAX_VALUE)));
		gl_panelLeft.setVerticalGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLeft.createSequentialGroup().addGap(5)
						.addComponent(dateChamCong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnNewButton).addContainerGap(424, Short.MAX_VALUE)));
		panelLeft.setLayout(gl_panelLeft);
	}

}
