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

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.border.LineBorder;

public class ThietLapGiaJInternalFrame extends JInternalFrame {

	private static final long serialVersionUID = -1811994452109007906L;

	private JPanel contentPane;
	private JTable tableThietLapGia;
	private DefaultTableModel modelThietLapGia = new DefaultTableModel();
	private JPanel panel = new JPanel();
	private JPanel panel1 = new JPanel();
	private JPanel hangHoaJPanel = new JPanel();
	private JFrame optionSetGiaFrame = new JFrame();
	private JPanel panelOption;
	private JPanel setGiaPanel = new JPanel();
	private JTextField txtTimNhomHang;

	// combobox thiết lập giá
	private JCheckBox chkSetGiaMaHang = new JCheckBox("Mã hàng");
	private JCheckBox chkSetGiaTenHang = new JCheckBox("Tên hàng");
	private JCheckBox chkSetGiaGiaVon = new JCheckBox("Giá vốn");
	private JCheckBox chkSetGiaGiaNhapCuoi = new JCheckBox("Giá nhập cuối");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThietLapGiaJInternalFrame frame = new ThietLapGiaJInternalFrame();
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
	public ThietLapGiaJInternalFrame() {
		((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setBounds(68, 120, 96, 20);
		panel.setLayout(new BorderLayout(0, 0));
		hangHoaJPanel.setBackground(Color.WHITE);

		contentPane.add(hangHoaJPanel, BorderLayout.WEST);
		panel1.setBackground(Color.WHITE);
		panel.add(panel1, BorderLayout.EAST);
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		initTopThietLapGia();
		initCenterThietLapGia();
	}

	public void initTopThietLapGia() {
		setTitle("Hàng hóa - Thiết lập giá");

		JLabel lblNewLabel = new JLabel("Bảng giá chung                       ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNewLabel, BorderLayout.WEST);

		JButton btnImport = new JButton("Xuất file ");
		btnImport.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\export.png", 20, 20)));
		panel1.add(btnImport);

		JComboBox<String> cbbOptionSetGia = new JComboBox<String>();
		cbbOptionSetGia.addItem("≡");
		panel1.add(cbbOptionSetGia);

		optionSetGiaFrame.setSize(150, 140);
		optionSetGiaFrame.setLocation(uiCommon.width - 160, uiCommon.height - (uiCommon.height / 100 * 86));
		panelOption = new JPanel();
		panelOption.setLayout(null);
		panelOption.setBackground(Color.white);
		panelOption.setBorder(new EmptyBorder(0, 0, 5, 5));
		optionSetGiaFrame.getContentPane().add(panelOption);
		optionSetGiaFrame.setUndecorated(true);
		uiCommon uiCommon = new uiCommon(panelOption);

		uiCommon.addCheckBox(chkSetGiaMaHang, 15, 12, 99);
		uiCommon.addCheckBox(chkSetGiaTenHang, 15, 43, 99);
		uiCommon.addCheckBox(chkSetGiaGiaVon, 15, 69, 99);
		uiCommon.addCheckBox(chkSetGiaGiaNhapCuoi, 15, 95, 140);

		cbbOptionSetGia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				optionSetGiaFrame.setVisible(true);
			}
		});

		cbbOptionSetGia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				optionSetGiaFrame.setVisible(true);

			}
		});

		optionSetGiaFrame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				optionSetGiaFrame.setVisible(false);

			}
		});
	}

	public void initCenterThietLapGia() {
		setGiaPanel.setLayout(new BoxLayout(setGiaPanel, BoxLayout.Y_AXIS));
		JLabel lblNewLabel_2 = new JLabel("Loại hàng             ▼");
		lblNewLabel_2.setFont(new Font("Consolas", Font.BOLD, 14));

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		JLabel lblNewLabel_4 = new JLabel("Bảng giá");

		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] { "Bảng giá chung" }));

		JLabel lblNewLabel_4_1 = new JLabel("Nhóm hàng");

		txtTimNhomHang = new JTextField();
		txtTimNhomHang.setText(" Tìm kiếm nhóm hàng");
		txtTimNhomHang.setColumns(10);
		GroupLayout gl_hangHoaJPanel = new GroupLayout(hangHoaJPanel);
		gl_hangHoaJPanel.setHorizontalGroup(
			gl_hangHoaJPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_hangHoaJPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_hangHoaJPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTimNhomHang)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_hangHoaJPanel.setVerticalGroup(
			gl_hangHoaJPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_hangHoaJPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_4_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtTimNhomHang, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(121, Short.MAX_VALUE))
		);
		hangHoaJPanel.setLayout(gl_hangHoaJPanel);
		panel.add(panel1, BorderLayout.EAST);
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		txtTimNhomHang.setBorder(new LineBorder(new Color(0, 0, 0)));

		tableThietLapGia = new JTable();
		scrollPane.setViewportView(tableThietLapGia);
		modelThietLapGia.addColumn("Mã hàng");
		modelThietLapGia.addColumn("Tên hàng");
		modelThietLapGia.addColumn("Giá vốn");
		modelThietLapGia.addColumn("Giá nhập cuối");
		modelThietLapGia.addColumn("Giá chung");
		tableThietLapGia.setModel(modelThietLapGia);

		txtTimNhomHang.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTimNhomHang.getText().equals(" Tìm kiếm nhóm hàng")) {
					txtTimNhomHang.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTimNhomHang.getText().equals("")) {
					txtTimNhomHang.setText(" Tìm kiếm nhóm hàng");
				}
			}
		});
		
		tableThietLapGia.setRowHeight(25);
	}

}
