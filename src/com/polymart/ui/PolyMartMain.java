package com.polymart.ui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;


public class PolyMartMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PolyMartMain frame = new PolyMartMain();
					frame.setVisible(true);
					frame.setTitle("Poly mart");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PolyMartMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(0, 0, 4500, 3000);
		
//		
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(new BorderLayout(0, 0));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		editMenu();
	}
	
	public void editMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnTongQuan = new JMenu("Tổng quan");
		menuBar.add(mnTongQuan);
		
		JMenu mnHangHoa = new JMenu("Hàng hóa");
		menuBar.add(mnHangHoa);
		
		JMenuItem mntmDanhMuc = new JMenuItem("Danh mục");
		mnHangHoa.add(mntmDanhMuc);
		
		JMenuItem mntmThietLapGia = new JMenuItem("Thiết lập giá");
		mnHangHoa.add(mntmThietLapGia);
		
		JMenuItem mntmKiemKho = new JMenuItem("Kiểm kho");
		mnHangHoa.add(mntmKiemKho);
		
		JMenu mnGiaoDich = new JMenu("Giao dịch");
		menuBar.add(mnGiaoDich);
		
		JMenu mnDoiTac = new JMenu("Đối tác");
		menuBar.add(mnDoiTac);
		
		JMenu mnNhanVien = new JMenu("Nhân viên");
		menuBar.add(mnNhanVien);
		
		JMenuItem mntmNhanVien = new JMenuItem("Nhân viên");
		mnNhanVien.add(mntmNhanVien);
		
		JMenuItem mntmChamCong = new JMenuItem("Chấm công");
		mnNhanVien.add(mntmChamCong);
		
		JMenuItem mntmBangTinhLuong = new JMenuItem("Bảng tính lương");
		mnNhanVien.add(mntmBangTinhLuong);
		
		JMenuItem mntmHoaHong = new JMenuItem("Thiết lập hoa hồng");
		mnNhanVien.add(mntmHoaHong);
		
		JMenu mnSoQuy = new JMenu("Sổ quỹ");
		menuBar.add(mnSoQuy);
		
		JMenu mnBaoCao = new JMenu("Báo cáo");
		menuBar.add(mnBaoCao);
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int wLine = width - 200;
		String path = " ";
		
		
		JLabel lblNewLabel = new JLabel(" ");
		menuBar.add(lblNewLabel);
		
		JMenu mnFacebook = new JMenu("Facebook");
		menuBar.add(mnFacebook);
		
		JMenu mnBanHang = new JMenu("Bán hàng");
	
		menuBar.add(mnBanHang);
	}

}
