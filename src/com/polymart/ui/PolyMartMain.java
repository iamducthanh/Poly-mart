package com.polymart.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class PolyMartMain extends JFrame {

	private JPanel contentPane;
	JDesktopPane desktopPane = new JDesktopPane();
	URI uri;

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
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		menuBar.setPreferredSize(new Dimension(width,40));
		//menuBar.setBackground(new Color(0, 191, 255));
		setJMenuBar(menuBar);
		
		JMenu mnTongQuan = new JMenu("Tổng quan");
		mnTongQuan.setIcon(new ImageIcon("C:\\PolySmart\\tongquan.png"));
		mnTongQuan.setBackground(new Color(0, 191, 255));
		menuBar.add(mnTongQuan);
		
		JMenu mnHangHoa = new JMenu("Hàng hóa");
		mnHangHoa.setIcon(new ImageIcon("C:\\PolySmart\\hanghoa.png"));
		menuBar.add(mnHangHoa);
		
		JMenuItem mntmDanhMuc = new JMenuItem("Danh mục");
		mntmDanhMuc.setIcon(new ImageIcon("C:\\PolySmart\\danhmuc.png"));
		mnHangHoa.add(mntmDanhMuc);
		
		JMenuItem mntmThietLapGia = new JMenuItem("Thiết lập giá");
		mntmThietLapGia.setIcon(new ImageIcon("C:\\PolySmart\\setgia.png"));
		mnHangHoa.add(mntmThietLapGia);
		
		JMenuItem mntmKiemKho = new JMenuItem("Kiểm kho");
		mntmKiemKho.setIcon(new ImageIcon("C:\\PolySmart\\kiemkho.png"));
		mnHangHoa.add(mntmKiemKho);
		
		JMenu mnGiaoDich = new JMenu("Giao dịch");
		mnGiaoDich.setIcon(new ImageIcon("C:\\PolySmart\\giaodich.png"));
		menuBar.add(mnGiaoDich);
		
		JMenu mnDoiTac = new JMenu("Đối tác");
		mnDoiTac.setIcon(new ImageIcon("C:\\PolySmart\\doitac.png"));
		menuBar.add(mnDoiTac);
		
		JMenu mnNhanVien = new JMenu("Nhân viên");
		mnNhanVien.setIcon(new ImageIcon("C:\\PolySmart\\nhanvien.png"));
		menuBar.add(mnNhanVien);
		
		JMenuItem mntmNhanVien = new JMenuItem("Nhân viên");
		mntmNhanVien.setIcon(new ImageIcon("C:\\PolySmart\\nhanvien.png"));
		mnNhanVien.add(mntmNhanVien);
		
		JMenuItem mntmChamCong = new JMenuItem("Chấm công");
		mntmChamCong.setIcon(new ImageIcon("C:\\PolySmart\\chamcong.png"));
		mnNhanVien.add(mntmChamCong);
		
		JMenuItem mntmBangTinhLuong = new JMenuItem("Bảng tính lương");
		mntmBangTinhLuong.setIcon(new ImageIcon("C:\\PolySmart\\tinhluong.png"));
		mnNhanVien.add(mntmBangTinhLuong);
		
		JMenuItem mntmHoaHong = new JMenuItem("Thiết lập hoa hồng");
		mntmHoaHong.setIcon(new ImageIcon("C:\\PolySmart\\laixuat.png"));
		mnNhanVien.add(mntmHoaHong);
		
		JMenu mnSoQuy = new JMenu("Sổ quỹ");
		mnSoQuy.setIcon(new ImageIcon("C:\\PolySmart\\soquy.png"));
		menuBar.add(mnSoQuy);
		
		JMenu mnBaoCao = new JMenu("Báo cáo");
		mnBaoCao.setIcon(new ImageIcon("C:\\PolySmart\\baocao.png"));
		menuBar.add(mnBaoCao);
		
		int wLine = width - 700 - 100;
		this.setFont(new Font("Consolas", Font.PLAIN, 14));
		Font f = this.getFont();
		FontMetrics fm = this.getFontMetrics(f);

		int y = fm.stringWidth(" ");
		int widthChuoi = wLine / y;
		String pad = " ";
		
		JLabel lblNewLabel = new JLabel(String.format("%"+widthChuoi+"s", pad));
		menuBar.add(lblNewLabel);
		
		JMenu mnFacebook = new JMenu("Facebook");
		mnFacebook.setIcon(new ImageIcon("C:\\PolySmart\\facebook.png"));
		mnFacebook.setBackground(new Color(30, 144, 255));
		menuBar.add(mnFacebook);
		
		JMenu mnBanHang = new JMenu("Bán hàng");
		mnBanHang.setIcon(new ImageIcon("C:\\PolySmart\\banhang.png"));
		mnBanHang.setBackground(new Color(30, 144, 255));
		
		menuBar.add(mnBanHang);
		
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(new CardLayout(0, 0));
		try {
			uri = new URI("http://facebook.com/iamducthanh");
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		mnFacebook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(uri);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		mntmDanhMuc.addActionListener(openDanhMuc);
	}
	
	
	ActionListener openDanhMuc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			close();
			HangHoa hangHoa = new HangHoa();
			desktopPane.add(hangHoa);
			hangHoa.initTopDanhMuc();
			hangHoa.initCenterDanhMuc();
			hangHoa.setVisible(true);
		}
	};
	

	
	public void close() {
		try {
			desktopPane.getAllFrames()[0].setVisible(false);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
