package com.polymart.ui.hanghoa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.formula.ptg.TblPtg;

import com.polymart.dao.impl.LoaiSanPhamDAO;
import com.polymart.dao.impl.SanPhamDAO;
import com.polymart.entity.EntityMessage;
import com.polymart.entity.EntityValidate;
import com.polymart.model.LoaiSanPhamModel;
import com.polymart.model.NguonHangModel;
import com.polymart.model.SanPhamModel;
import com.polymart.service.INguonHangService;
import com.polymart.service.impl.NguonHangService;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class SanPhamJInternalFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3314858072598500922L;
	private JPanel contentPane;

	private JTextField txtTim;
	private JTable tableNguonHang;
	private JTextField txtTenSanPham;
	private JComboBox cbbLoaiSP;
	private JTextArea txtMoTa;
	private JRadioButton rdoDangKinhDoanh;
	private JRadioButton rdoNgungKinhDoanh;
	DefaultTableModel modelNguonHang = new DefaultTableModel();
	JButton btnCapNhat = new JButton("Cập nhật");
	JButton btnThem = new JButton("Thêm");
	JButton btnMoi = new JButton("Tạo mới");
	LoaiSanPhamDAO loaispDao = new LoaiSanPhamDAO();
	SanPhamDAO spDao = new SanPhamDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SanPhamJInternalFrame frame = new SanPhamJInternalFrame();
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
	public SanPhamJInternalFrame() {
		((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 1920, 639);
		setFocusable(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(75, 0, 130));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(75, 0, 130));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
					.addGap(22))
		);
		
				txtTim = new JTextField();
				txtTim.setBorder(null);
				txtTim.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 14));
				txtTim.setText(" Tìm theo mã, tên sản phẩm");
				txtTim.setColumns(10);
				txtTim.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
						findSanPham(modelNguonHang);
						tableNguonHang.setModel(modelNguonHang);
					}
				});
				txtTim.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						if (txtTim.getText().equals(" Tìm theo mã, tên sản phẩm")) {
							txtTim.setText("");
						}
					}

					@Override
					public void focusLost(FocusEvent e) {
						if (txtTim.getText().equals("")) {
							txtTim.setText(" Tìm theo mã, tên sản phẩm");
						}
					}
				});
		
				JLabel lblNewLabel = new JLabel("Sản phẩm");
				lblNewLabel.setForeground(new Color(255, 255, 255));
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtTim, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(308, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(14, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtTim, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		panel_1.setLayout(gl_panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2, BorderLayout.EAST);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chi ti\u1EBFt s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnMoi, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSP();
				loadTable(modelNguonHang);
			}
		});
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
				loadTable(modelNguonHang);
			}
		});
		btnMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMoi, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(155, Short.MAX_VALUE))
		);

		JLabel lblNewLabel_2 = new JLabel("Tên sản phẩm");
		lblNewLabel_2.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 16));

		txtTenSanPham = new JTextField();
		txtTenSanPham.setBackground(Color.WHITE);
		txtTenSanPham.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenSanPham.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Mô tả");
		lblNewLabel_2_1.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 16));

		JLabel lblNewLabel_2_1_1 = new JLabel("Trạng thái");
		lblNewLabel_2_1_1.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 16));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		rdoDangKinhDoanh = new JRadioButton("Đang kinh doanh");
		rdoDangKinhDoanh.setBackground(new Color(255, 255, 255));
		rdoDangKinhDoanh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		rdoNgungKinhDoanh = new JRadioButton("Ngừng kinh doanh");
		rdoNgungKinhDoanh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdoNgungKinhDoanh.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_2_2 = new JLabel("Loại sản phẩm");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		cbbLoaiSP = new JComboBox();
		fillCbxLoaiSp(cbbLoaiSP);
		JButton btnThemLoai = new JButton("Thêm loại");
		btnThemLoai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoaiSanPhamModel loaispModel = new LoaiSanPhamModel();
				String loaiSP = JOptionPane.showInputDialog("Nhập loại sản phẩm mới");
				for(LoaiSanPhamModel x:new LoaiSanPhamDAO().findAll()) {
					if(loaiSP.equalsIgnoreCase(x.getTenLoaiSP())) {
						JOptionPane.showMessageDialog(null, "Loại sản phẩm đã tồn tại");
						return;
					}
					else if(loaiSP.isBlank()) {
						JOptionPane.showMessageDialog(null, "Chưa nhập tên loại sản phẩm");
						return;
					}
					else {
						try {
							loaispModel.setTenLoaiSP(loaiSP);
							new LoaiSanPhamDAO().save(loaispModel);
							JOptionPane.showMessageDialog(null, "Thêm loại sản phẩm thành công");
							break;
						} catch (Exception e2) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(null, "Thêm loại sản phẩm thất bại");
						}
					}
				}
				fillCbxLoaiSp(cbbLoaiSP);
			}
		});
		
		ButtonGroup gr = new ButtonGroup();
		gr.add(rdoNgungKinhDoanh);
		gr.add(rdoDangKinhDoanh);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_3.createSequentialGroup()
									.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(rdoDangKinhDoanh, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2_1_1, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
									.addGap(5)
									.addComponent(rdoNgungKinhDoanh, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
									.addComponent(cbbLoaiSP, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnThemLoai, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
								.addComponent(txtTenSanPham, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
							.addContainerGap())))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbbLoaiSP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnThemLoai, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtTenSanPham, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(rdoNgungKinhDoanh, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdoDangKinhDoanh))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		
		txtMoTa = new JTextArea();
		scrollPane_1.setViewportView(txtMoTa);
		panel_3.setLayout(gl_panel_3);
		panel_2.setLayout(gl_panel_2);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		tableNguonHang = new JTable();
		scrollPane.setViewportView(tableNguonHang);
		modelNguonHang.addColumn("ID sản phẩm");
		modelNguonHang.addColumn("Tên sản phẩm");
		modelNguonHang.addColumn("Loại sản phẩm");
		modelNguonHang.addColumn("Mô tả");
		modelNguonHang.addColumn("Trạng thái");
		loadTable(modelNguonHang);
		tableNguonHang.setModel(modelNguonHang);
		tableNguonHang.setRowSelectionInterval(0, 0);
		loadInfo(0);
		tableNguonHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadInfo(tableNguonHang.getSelectedRow());
			}
		});
	}
	public void loadInfo(int row) {
		cbbLoaiSP.setSelectedItem(tableNguonHang.getValueAt(row, 2).toString());
		txtTenSanPham.setText(tableNguonHang.getValueAt(row, 1).toString());
		txtMoTa.setText(tableNguonHang.getValueAt(row, 3).toString());
		if(tableNguonHang.getValueAt(row, 4).toString().equals("Đang kinh doanh")) rdoDangKinhDoanh.setSelected(true);
		else rdoNgungKinhDoanh.setSelected(true);
	}
	public String getTenLoaiSpById(int id) {
		for(LoaiSanPhamModel x:new LoaiSanPhamDAO().findAll()) {
			if(x.getId()==id) return x.getTenLoaiSP();
		}
		return null;
	}
	public Integer getIdLoaispByName(String name) {
		for(LoaiSanPhamModel x:new LoaiSanPhamDAO().findAll()) {
			if(x.getTenLoaiSP().equalsIgnoreCase(name)) return x.getId();
		}
		return null;
	}
	public void loadTable(DefaultTableModel model) {
		model.setRowCount(0);
		for(SanPhamModel x: new SanPhamDAO().findAll()) {
			model.addRow(new Object[] {
					x.getId(),x.getTenSP(),getTenLoaiSpById(x.getIdLoaiSP()),x.getMoTa(),
					x.isStatusKinhDoanh()?"Đang kinh doanh":"Ngừng kinh doanh"
			});
		}
	}
	public void fillCbxLoaiSp(JComboBox cbx) {
		cbx.removeAllItems();
		List<LoaiSanPhamModel> lst = new LoaiSanPhamDAO().findAll(); 
		for(LoaiSanPhamModel x:lst) {
			cbx.addItem(x.getTenLoaiSP());
		}
	}
	public void addSP() {
		int i =0;
		SanPhamModel spmodel = new SanPhamModel();
		if(txtTenSanPham.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Chưa nhập tên sản phẩm");
			return;
		}
		for(SanPhamModel x:new SanPhamDAO().findAll()) {
			if(x.getTenSP().equalsIgnoreCase(txtTenSanPham.getText())&& getTenLoaiSpById(x.getIdLoaiSP()).equals(cbbLoaiSP.getSelectedItem().toString())) {
				i++;
			}
		}
		if(i>0) {
			JOptionPane.showMessageDialog(null, "Sản phẩm đã tồn tại");
			return;
		}
		else {
			spmodel.setTenSP(txtTenSanPham.getText());
			spmodel.setIdLoaiSP(getIdLoaispByName(cbbLoaiSP.getSelectedItem().toString()));
			spmodel.setMoTa(txtMoTa.getText());
			if(rdoDangKinhDoanh.isSelected()) spmodel.setStatusKinhDoanh(true);
			else spmodel.setStatusKinhDoanh(false);
			try {
				new SanPhamDAO().save(spmodel);
				JOptionPane.showMessageDialog(null, "Thêm sản phẩm thành công");
				return;
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Thêm sản phẩm thất bại");
			}
		}
		
	  }
	public void update() {
		int i=0;
		SanPhamModel spModel = new SanPhamModel();
		for(SanPhamModel x:new SanPhamDAO().findAll()) {
			if(x.getTenSP().equalsIgnoreCase(txtTenSanPham.getText())&& getTenLoaiSpById(x.getIdLoaiSP()).equals(cbbLoaiSP.getSelectedItem().toString())) {
				i++;
			}
		}
		if(i==0) {
			JOptionPane.showMessageDialog(null, "Sản phẩm không tồn tại");
			return;
		}
		else {
			try {
				spModel.setId(new SanPhamDAO().findByNameSPAndNameLoai(txtTenSanPham.getText(), cbbLoaiSP.getSelectedItem().toString()).get(0).getId());
				spModel.setMoTa(txtMoTa.getText());
				if(rdoDangKinhDoanh.isSelected()) spModel.setStatusKinhDoanh(true);
				else spModel.setStatusKinhDoanh(false);
				new SanPhamDAO().update(spModel);
				JOptionPane.showMessageDialog(null,"Cập nhật sản phẩm thành công");
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Cập nhật sản phẩm thất bại");
			}
		}
	}
	public void clear() {
		cbbLoaiSP.setSelectedIndex(0);
		txtTenSanPham.setText("");
		txtMoTa.setText("");
		rdoDangKinhDoanh.setSelected(true);
	}
	protected void findSanPham(DefaultTableModel model) {
		try {
			List<SanPhamModel> lstsp = new SanPhamDAO().fillter(txtTim.getText());
		model.setRowCount(0);
		for(SanPhamModel x: lstsp) {
			model.addRow(new Object[] {
					x.getId(),x.getTenSP(),getTenLoaiSpById(x.getIdLoaiSP()),x.getMoTa(),
					x.isStatusKinhDoanh()?"Đang kinh doanh":"Ngừng kinh doanh"
			});
		}
	}catch (Exception e) {
		e.printStackTrace();
	}
  }
}
