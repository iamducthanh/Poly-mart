package com.polymart.ui.hanghoa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.polymart.entity.EntityFrame;
import com.polymart.entity.EntityImage;
import com.polymart.model.LabelImageModel;

public class ThemHangHoaJInternalFrame extends JInternalFrame {

	private static final long serialVersionUID = -2914525596895096982L;

	private JPanel contentPane;
	private JTextField txtTenSP;
	private JTextField txtLoai;
	private JTextField txtGiaBan;
	private JTextField txtGiaGiam;
	private JTextField txtMauSac;
	JPanel panelImage = new JPanel();

	List<LabelImageModel> listLabelImg = new ArrayList<LabelImageModel>();
	// list này để lúc lưu sẽ get link ra để lưu

	JLabel Image1 = new JLabel();
	JLabel Image2 = new JLabel();
	JLabel Image3 = new JLabel();
	JLabel Image4 = new JLabel();
	JLabel Image5 = new JLabel();
	JLabel Image6 = new JLabel();
	JLabel Image7 = new JLabel();
	JLabel Image8 = new JLabel();
	JLabel Image9 = new JLabel();
	JLabel Image10 = new JLabel();
	JLabel Image11 = new JLabel();
	JLabel Image12 = new JLabel();
	// nó éo reload lại form cho nên phải tạo sẵn, lúc lấy ảnh cứ load list lấy link
	// để lưu
	
	private JTable tableDSSanPhamThem;
	DefaultTableModel modelDSSanPhamThem = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntityFrame.THEMHANGHOA.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ThemHangHoaJInternalFrame() {
		((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 639);

		setFocusable(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);

		JButton btnQuayLai = new JButton("<-   ");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnQuayLai.setContentAreaFilled(false);
		btnQuayLai.setBorder(null);
		btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 17));

		JLabel lblNewLabel = new JLabel("Thêm sản phẩm");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(5).addComponent(btnQuayLai).addGap(5)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
						.addGap(1011)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(5)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnQuayLai, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"  Chi ti\u1EBFt s\u1EA3n ph\u1EA9m  ", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));

		JButton btnLuuTam = new JButton("Lưu tạm");
		btnLuuTam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLuuTam();
			}
		});

		JButton btnTaoMoi = new JButton("Tạo mới");
		
		JPanel panel_3 = new JPanel();
		
		JButton btnHoanThanh = new JButton("Hoàn thành");
		
		JButton btnXoa = new JButton("Xoá");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1134, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 1134, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnLuuTam, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnTaoMoi, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
						.addComponent(btnHoanThanh, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
					.addGap(20))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnLuuTam, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnTaoMoi, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnHoanThanh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane, BorderLayout.CENTER);
		
		tableDSSanPhamThem = new JTable();
		scrollPane.setViewportView(tableDSSanPhamThem);

		JLabel lblNewLabel_1 = new JLabel("Tên sản phẩm: ", JLabel.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtTenSP = new JTextField();
		txtTenSP.setColumns(10);

		txtLoai = new JTextField();
		txtLoai.setColumns(10);

		txtGiaBan = new JTextField();
		txtGiaBan.setColumns(10);

		txtGiaGiam = new JTextField();
		txtGiaGiam.setColumns(10);

		txtMauSac = new JTextField();
		txtMauSac.setColumns(10);

		JComboBox<Object> cbbSize = new JComboBox<Object>();
		cbbSize.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbbSize.setModel(
				new DefaultComboBoxModel<Object>(new String[] { "S", "M", "L", "XL", "XXL", "XXXL", "FREE SIZE" }));

		JLabel lblNewLabel_1_1 = new JLabel("Loại: ", JLabel.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_1_2 = new JLabel("Giá bán: ", JLabel.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_1_3 = new JLabel("Giá giảm: ", JLabel.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_1_4 = new JLabel("Size: ", JLabel.RIGHT);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_1_5 = new JLabel("Màu sắc: ", JLabel.RIGHT);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 14));

		panelImage.setBorder(
				new TitledBorder(null, "  H\u00ECnh \u1EA3nh  ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnNewButton_1 = new JButton("Tạo mới hình");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntityImage.clearHinh(listLabelImg);
				EntityImage.closeLabelImage(listLabelImg);
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(23)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_5, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
							.addGap(40)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtMauSac, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
								.addComponent(txtGiaGiam, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
								.addComponent(txtGiaBan, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
								.addComponent(txtLoai, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
								.addComponent(txtTenSP, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
								.addComponent(cbbSize, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
							.addComponent(panelImage, GroupLayout.PREFERRED_SIZE, 665, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addContainerGap(1015, Short.MAX_VALUE)
							.addComponent(btnNewButton_1)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTenSP, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(txtLoai, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtGiaBan, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtGiaGiam, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(cbbSize, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(17)
									.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtMauSac, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_5, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))))
						.addComponent(panelImage, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1)
					.addGap(12))
		);
		panelImage.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		addListImage();

		listLabelImg.forEach((anh) -> {
			anh.getLblImage().setIcon(new ImageIcon("images\\\\imgThemAnh.jpg"));
			anh.getLblImage().addMouseListener(chonHinh);
		});

	
		panelImage.add(Image1);
        panelImage.add(Image2);
        panelImage.add(Image3);
        panelImage.add(Image4);
        panelImage.add(Image5);
        panelImage.add(Image6);
        panelImage.add(Image7);
        panelImage.add(Image8);
        panelImage.add(Image9);
        panelImage.add(Image10);
        panelImage.add(Image11);
        panelImage.add(Image12);
        
        modelDSSanPhamThem.addColumn("Tên sản phẩm");
        modelDSSanPhamThem.addColumn("Loại");
        modelDSSanPhamThem.addColumn("Giá bán");
        modelDSSanPhamThem.addColumn("Giảm giá");
        modelDSSanPhamThem.addColumn("Size");
        modelDSSanPhamThem.addColumn("Màu sách");
        modelDSSanPhamThem.addColumn("Hình ảnh");
        tableDSSanPhamThem.setModel(modelDSSanPhamThem);
		panel_2.setLayout(gl_panel_2);
		panel.setLayout(gl_panel);

	}
	
	MouseListener chonHinh = new MouseListener() {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			chonHinh((JLabel)e.getComponent());
		}

		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {}

		public void mouseEntered(MouseEvent e) {}

		public void mouseExited(MouseEvent e) {}
	};
	
	public void btnLuuTam() {
		StringBuilder listName = new StringBuilder();
		listLabelImg.forEach((Image) -> {
			if(!Image.getName().equals("imgThemAnh.jpg")) {
				listName.append(Image.getName() + ", ");
			}
		});
		
		modelDSSanPhamThem.addRow(new Object[] {"","","","","","",listName.toString()});
		tableDSSanPhamThem.setModel(modelDSSanPhamThem);
	}

	public void addListImage() {
		listLabelImg.add(new LabelImageModel(Image1, "imgThemAnh.jpg"));
		listLabelImg.add(new LabelImageModel(Image2, "imgThemAnh.jpg"));
		listLabelImg.add(new LabelImageModel(Image3, "imgThemAnh.jpg"));
		listLabelImg.add(new LabelImageModel(Image4, "imgThemAnh.jpg"));
		listLabelImg.add(new LabelImageModel(Image5, "imgThemAnh.jpg"));
		listLabelImg.add(new LabelImageModel(Image6, "imgThemAnh.jpg"));
		listLabelImg.add(new LabelImageModel(Image7, "imgThemAnh.jpg"));
		listLabelImg.add(new LabelImageModel(Image8, "imgThemAnh.jpg"));
		listLabelImg.add(new LabelImageModel(Image9, "imgThemAnh.jpg"));
		listLabelImg.add(new LabelImageModel(Image10, "imgThemAnh.jpg"));
		listLabelImg.add(new LabelImageModel(Image11, "imgThemAnh.jpg"));
		listLabelImg.add(new LabelImageModel(Image12, "imgThemAnh.jpg"));
		
		EntityImage.closeLabelImage(listLabelImg);
	}

	public void chonHinh(JLabel label) {
		JFileChooser file = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG and PNG", new String[] { "JPG", "PNG" });
		file.setFileFilter(filter);

		int i = file.showOpenDialog(null);
		if (i == 0) {
			String path = file.getSelectedFile().getPath();
			String name = file.getSelectedFile().getName();
			EntityImage.setNameToListImage(listLabelImg, name, path, label);
		}

	}

	public void close() {
		this.dispose();
	}
}
