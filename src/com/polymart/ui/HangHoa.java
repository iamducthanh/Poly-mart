package com.polymart.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class HangHoa extends JInternalFrame {

	private static final long serialVersionUID = 7158581259856675232L;
	
	private JPanel contentPane;
	private JTextField txtTimKiem;
	JPanel panel = new JPanel();
	JPanel hangHoaJPanel = new JPanel();
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HangHoa frame = new HangHoa();
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
	public HangHoa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hàng hóa - Danh mục");
		setBounds(100, 100, 1041, 639);
		setFocusable(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setBounds(68, 120, 96, 20);
		panel.setLayout(new BorderLayout(0, 0));
		
		contentPane.add(hangHoaJPanel, BorderLayout.WEST);
	//	hangHoaJPanel.setLayout(null);
		

		
	//	setExtendedState(JFrame.MAXIMIZED_BOTH);
		
//		initTopDanhMuc();
//		initCenterDanhMuc();

	}
	
	public void initTopDanhMuc() {
		
		JLabel lblNewLabel = new JLabel("Hàng hóa                       ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNewLabel, BorderLayout.WEST);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setText(" TÌm theo mã, tên hàng");
		panel.add(txtTimKiem, BorderLayout.CENTER);
		txtTimKiem.setColumns(10);
		txtTimKiem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTimKiem.getText().equals(" TÌm theo mã, tên hàng")) {
					txtTimKiem.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTimKiem.getText().equals("")) {
					txtTimKiem.setText(" TÌm theo mã, tên hàng");
				}
			}
		});
		
		JPanel panel1 = new JPanel();
		panel.add(panel1, BorderLayout.EAST);
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("                                     ");
		panel1.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Thêm mới", "Thêm hàng hóa", "Thêm dịch vụ", "Thêm combo - đóng gói"}));
		panel1.add(comboBox);
		
		JButton btnImport = new JButton("Import");
		panel1.add(btnImport);
		
		JButton btnNewButton_1 = new JButton("Export");
		panel1.add(btnNewButton_1);
		
		JComboBox comboBox1 = new JComboBox();
		panel1.add(comboBox1);
	}

	public void initCenterDanhMuc() {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		hangHoaJPanel.setLayout(new BoxLayout(hangHoaJPanel, BoxLayout.Y_AXIS));
		JLabel lblNewLabel_2 = new JLabel("Loại hàng             ▼");
		lblNewLabel_2.setFont(new Font("Consolas", Font.BOLD, 14));
		lblNewLabel_2.setVisible(false);
		JLabel lblNewLabel_2t1 = new JLabel("Loại hàng             ▲");
		lblNewLabel_2t1.setFont(new Font("Consolas", Font.BOLD, 14));
		hangHoaJPanel.add(lblNewLabel_2);
		hangHoaJPanel.add(lblNewLabel_2t1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setVisible(false);
		hangHoaJPanel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		JCheckBox checkBox1 = new JCheckBox("Hàng hóa");
		panel_1.add(checkBox1);
		JCheckBox checkBox2 = new JCheckBox("Dịch vụ");
		panel_1.add(checkBox2);
		JCheckBox checkBox3 = new JCheckBox("Combo - đóng gói              ");
		panel_1.add(checkBox3);
		
		JLabel lblNewLabel_3 = new JLabel("Tồn kho               ▼");
		lblNewLabel_3.setFont(new Font("Consolas", Font.BOLD, 14));
		lblNewLabel_3.setVisible(false);
		JLabel lblNewLabel_3t1 = new JLabel("Tồn kho               ▲");
		lblNewLabel_3t1.setFont(new Font("Consolas", Font.BOLD, 14));
		hangHoaJPanel.add(lblNewLabel_3);
		hangHoaJPanel.add(lblNewLabel_3t1);
	
		JPanel panel_2 = new JPanel();
		panel_2.setVisible(false);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		hangHoaJPanel.add(panel_2);
		
		JRadioButton radio1 = new JRadioButton("Tất cả");
		JRadioButton radio2 = new JRadioButton("Dưới định mức tồn");
		JRadioButton radio3 = new JRadioButton("Vượi định mức tồn");
		JRadioButton radio4 = new JRadioButton("Còn hàng trong kho");
		JRadioButton radio5 = new JRadioButton("Hết hàng trong kho            ");
		panel_2.add(radio1);
		panel_2.add(radio2);
		panel_2.add(radio3);
		panel_2.add(radio4);
		panel_2.add(radio5);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(radio1);
		buttonGroup.add(radio2);
		buttonGroup.add(radio3);
		buttonGroup.add(radio4);
		buttonGroup.add(radio5);

		
		JLabel lblNewLabel_5 = new JLabel("Bán trực tiếp         ▼   ");
		lblNewLabel_5.setFont(new Font("Consolas", Font.BOLD, 14));
		lblNewLabel_5.setVisible(false);
		JLabel lblNewLabel_5t1 = new JLabel("Bán trực tiếp         ▲   ");
		lblNewLabel_5t1.setFont(new Font("Consolas", Font.BOLD, 14));
		hangHoaJPanel.add(lblNewLabel_5);
		hangHoaJPanel.add(lblNewLabel_5t1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setVisible(false);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		hangHoaJPanel.add(panel_3);
		
		JRadioButton radio6 = new JRadioButton("Tất cả");
		JRadioButton radio7 = new JRadioButton("Được bán trực tiếp");
		JRadioButton radio8 = new JRadioButton("Không được bán trực tiếp");
		panel_3.add(radio6);
		panel_3.add(radio7);
		panel_3.add(radio8);
		
		ButtonGroup buttonGroup2 = new ButtonGroup();
		buttonGroup2.add(radio6);
		buttonGroup2.add(radio7);
		buttonGroup2.add(radio8);
		
		JLabel lblNewLabel_6 = new JLabel("Ngày dự kiến hết hàng ▼");
		lblNewLabel_6.setFont(new Font("Consolas", Font.BOLD, 14));
		lblNewLabel_6.setVisible(false);
		JLabel lblNewLabel_6t1 = new JLabel("Ngày dự kiến hết hàng ▲");
		lblNewLabel_6t1.setFont(new Font("Consolas", Font.BOLD, 14));
		hangHoaJPanel.add(lblNewLabel_6);
		hangHoaJPanel.add(lblNewLabel_6t1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setVisible(false);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		hangHoaJPanel.add(panel_4);
		
		JRadioButton radio9 = new JRadioButton("Toàn thời gian                    ");
		JRadioButton radio10 = new JRadioButton("Lựa chọn khác");
		panel_4.add(radio9);
		panel_4.add(radio10);
		
		ButtonGroup buttonGroup3 = new ButtonGroup();
		buttonGroup3.add(radio1);
		buttonGroup3.add(radio2);
		
		JLabel lblNewLabel_7 = new JLabel("Liên kết kênh bán     ▼");
		lblNewLabel_7.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblNewLabel_7.setVisible(false);
		JLabel lblNewLabel_7t1 = new JLabel("Liên kết kênh bán     ▲");
		lblNewLabel_7t1.setFont(new Font("Consolas", Font.BOLD, 14));
		hangHoaJPanel.add(lblNewLabel_7t1);
		hangHoaJPanel.add(lblNewLabel_7t1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setVisible(false);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		hangHoaJPanel.add(panel_5);
		
		JRadioButton radio11 = new JRadioButton("Tất cả");
		JRadioButton radio12 = new JRadioButton("Có liên kết kênh bán");
		JRadioButton radio13 = new JRadioButton("Không liên kết kênh bán  ");
		panel_5.add(radio11);
		panel_5.add(radio12);
		panel_5.add(radio13);

		
		ButtonGroup buttonGroup4 = new ButtonGroup();
		buttonGroup4.add(radio11);
		buttonGroup4.add(radio12);
		buttonGroup4.add(radio13);

		
		JLabel lblNewLabel_8 = new JLabel("Lựa chọn hiển thị     ▼");
		lblNewLabel_8.setFont(new Font("Consolas", Font.BOLD, 14));
		lblNewLabel_8.setVisible(false);
		JLabel lblNewLabel_8t1 = new JLabel("Lựa chọn hiển thị     ▲");
		lblNewLabel_8t1.setFont(new Font("Consolas", Font.BOLD, 14));
		hangHoaJPanel.add(lblNewLabel_8);
		hangHoaJPanel.add(lblNewLabel_8t1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setVisible(false);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));
		hangHoaJPanel.add(panel_6);
		
		JRadioButton radio14 = new JRadioButton("Tất cả");
		JRadioButton radio15 = new JRadioButton("Hàng đang kinh doanh");
		JRadioButton radio16 = new JRadioButton("Hàng ngừng kinh doanh   ");
		panel_6.add(radio14);
		panel_6.add(radio15);
		panel_6.add(radio16);
		
		ButtonGroup buttonGroup5 = new ButtonGroup();
		buttonGroup5.add(radio14);
		buttonGroup5.add(radio15);
		buttonGroup5.add(radio16);

		lblNewLabel_2t1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_2t1.setVisible(false);
				lblNewLabel_2.setVisible(true);
				panel_1.setVisible(true);
			}
		});
		
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_2.setVisible(false);
				lblNewLabel_2t1.setVisible(true);
				panel_1.setVisible(false);
			}
		});
		
		lblNewLabel_3t1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_3t1.setVisible(false);
				lblNewLabel_3.setVisible(true);
				panel_2.setVisible(true);
				
			}
		});
		
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_3.setVisible(false);
				lblNewLabel_3t1.setVisible(true);
				panel_2.setVisible(false);
				
			}
		});
		
		lblNewLabel_5t1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_5t1.setVisible(false);
				lblNewLabel_5.setVisible(true);
				panel_3.setVisible(true);
				
			}
		});
		
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_5.setVisible(false);
				lblNewLabel_5t1.setVisible(true);
				panel_3.setVisible(false);
				
			}
		});
		
		lblNewLabel_6t1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_6t1.setVisible(false);
				lblNewLabel_6.setVisible(true);
				panel_4.setVisible(true);
				
			}
		});
		
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_6.setVisible(false);
				lblNewLabel_6t1.setVisible(true);
				panel_4.setVisible(false);
				
			}
		});
		
		lblNewLabel_7t1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_7t1.setVisible(false);
				lblNewLabel_7.setVisible(true);
				panel_5.setVisible(true);
				
			}
		});
		
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_7.setVisible(false);
				lblNewLabel_7t1.setVisible(true);
				panel_5.setVisible(false);
				
			}
		});
		
		lblNewLabel_8t1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_8t1.setVisible(false);
				lblNewLabel_8.setVisible(true);
				panel_6.setVisible(true);
				
			}
		});
		
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_8.setVisible(false);
				lblNewLabel_8t1.setVisible(true);
				panel_6.setVisible(false);
				
			}
		});

		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model.addColumn("☐");
		model.addColumn("Mã hàng");
		model.addColumn("Tên hàng");
		model.addColumn("GIá bán");
		model.addColumn("Giá vốn");
		model.addColumn("Tồn kho");
		model.addColumn("KH đặt hàng");
		model.addColumn("Dự kiếm hết hàng");
		table.setModel(model);
		
	//	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(350);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		table.getColumnModel().getColumn(5).setPreferredWidth(120);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(130);

		
	}
}
