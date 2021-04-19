package com.polymart.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.polymart.entity.EntityAuthorization;
import com.polymart.entity.EntityImage;
import com.polymart.entity.EntityMessage;
import com.polymart.ui.baocao.BaoCaoChiTieuJInternalFrame;
import com.polymart.ui.giaodich.NhapHangJInternalFrame;
import com.polymart.ui.giaodich.ThanhToanJInternalFrame;
import com.polymart.ui.giaodich.TraHangJInternalFrame;
import com.polymart.ui.hanghoa.HangHoaJInternalFrame;
import com.polymart.ui.hanghoa.KiemKhoJInternalFrame;
import com.polymart.ui.hanghoa.NguonHangJInternalFrame;
import com.polymart.ui.khachhang.KhachHangJInternalFrame;
import com.polymart.ui.nhanvien.BangLuongJIternalFrame;
import com.polymart.ui.nhanvien.CaNhanFrame;
import com.polymart.ui.nhanvien.ChamCongJInternalFrame;
import com.polymart.ui.nhanvien.NhanVienJInternalFrame;
import com.polymart.ui.taikhoan.LoginJFrame;
import com.polymart.ui.thongke.ThongKeDoanhSoJInternalFrame;
import com.polymart.ui.thongke.ThongKeDoanhThuJInternalFrame;

public class MainFrame extends JFrame {

	static int select = 0;
	static int openThongKe = 0;
	static int openHangHoa = 0;
	static int openGiaoDich = 0;
	static int openCaNhan = 0;
	static int openKhachHang = 0;
	static int openNhanVien = 0;

	class Toolbar {
		JPanel panelSelect;
		JPanel panelCha;
		JLabel labelClick;

		public Toolbar(JPanel panelSelect, JPanel panelCha, JLabel labelClick) {
			super();
			this.panelSelect = panelSelect;
			this.panelCha = panelCha;
			this.labelClick = labelClick;
		}

	}

	ArrayList<Toolbar> listToolBar = new ArrayList<Toolbar>();

	private JPanel contentPane;

	JLabel lblThongKe = new JLabel("       Thống kê");
	JLabel lblBanHang = new JLabel("       Bán hàng");
	JLabel lblCaNhan = new JLabel("       Cá nhân");
	JLabel lblKhachHang = new JLabel("       Khách hàng");
	JLabel lblNhanVien = new JLabel("       Nhân viên");
	JLabel lblGiaoDich = new JLabel("       Giao dịch");
	JLabel lblHangHoa = new JLabel("       Hàng hóa");

	JPanel panelSelectThongKe = new JPanel();
	JPanel panelSelectBanHang = new JPanel();
	JPanel panelSelectCaNhan = new JPanel();
	JPanel panelSelectKhachHang = new JPanel();
	JPanel panelSelectNhanVien = new JPanel();
	JPanel panelSelectGiaoDich = new JPanel();
	JPanel panelSelectHangHoa = new JPanel();

	JPanel panelThongKe = new JPanel();
	JPanel panelBanHang = new JPanel();
	JPanel panelCaNhan = new JPanel();
	JPanel panelKhachHang = new JPanel();
	JPanel panelNhanVien = new JPanel();
	JPanel panelGiaoDich = new JPanel();
	JPanel panelHangHoa = new JPanel();
	private JLabel lblDanhMuc = new JLabel("");

	public static JDesktopPane pnlMain = new JDesktopPane();
	private JLabel lblDanhMucOpen = new JLabel("");
	JPanel panel = new JPanel();
	private JPanel panelDoanhThu = new JPanel();
	private JLabel lblDoanhThu = new JLabel("      Thống kê doanh thu");
	private JPanel panelDoanhso = new JPanel();
	private JLabel lblDoanhSo = new JLabel("      Thống kê doanh số");
	JPanel panelHangHoaCon = new JPanel();
	private JLabel lblHangHoaCon = new JLabel("      Hàng hóa");
	private JPanel panelKiemKho = new JPanel();
	private JLabel lblKiemKho = new JLabel("      Kiểm kho");
	private JPanel panelNguonHang = new JPanel();
	private JLabel lblNguonHang = new JLabel("      Nguồn hàng");
	private JPanel panelNhapHang = new JPanel();
	private JLabel lblNhapHang = new JLabel("      Nhập hàng");
	private JPanel panelBanHangCon = new JPanel();
	private JLabel lblBanHangCon = new JLabel("      Bán hàng");
	private JPanel panelTraHang = new JPanel();
	private JLabel lblTraHang = new JLabel("      Trả hàng");
	private JPanel panelChiTieu = new JPanel();
	private JLabel lblChiTieu = new JLabel("      Chi tiêu");
	private JPanel panelNhanVien1 = new JPanel();
	private JPanel panelDangXuat = new JPanel();
	private JLabel lblDangXuat = new JLabel("      Đăng xuất");
	JLabel lblCaNhan1 = new JLabel("      Cá nhân");
	JPanel panelCaNhan1 = new JPanel();
	private JPanel panelKhachHang1 = new JPanel();
	private JLabel lblKhachHang1 = new JLabel("      Khách hàng");
	private JPanel panelChamCong = new JPanel();
	private JPanel panelBangLuong = new JPanel();
	private JLabel lblNhanVien1 = new JLabel("      Nhân viên");
	private JLabel lblChamCong = new JLabel("      Chấm công");
	private JLabel lblBangLuong = new JLabel("      Bảng tính lương");
	private JLabel lblAvatar = new JLabel("");
	private JLabel lblTenUser = new JLabel("N");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\fpt.png"));
		setTitle("Quản lý cửa hàng");
		lblTenUser.setForeground(Color.WHITE);
		lblTenUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		if (EntityAuthorization.USER != null) {
			String urlAnh = "images\\" + EntityAuthorization.USER.getAnhDaiDien();
			lblAvatar.setIcon(new ImageIcon(EntityImage.resizeTheoUrl(urlAnh, 50, 50)));

			lblTenUser.setText(EntityAuthorization.USER.getHoTen());
		}
		lblBangLuong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadChild(new BangLuongJIternalFrame());
			}
		});
		lblBangLuong.setForeground(Color.WHITE);
		lblBangLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChamCong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadChild(new ChamCongJInternalFrame());
			}
		});
		lblChamCong.setForeground(Color.WHITE);
		lblChamCong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNhanVien1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadChild(new NhanVienJInternalFrame());
			}
		});
		lblNhanVien1.setForeground(Color.WHITE);
		lblNhanVien1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelBangLuong.setBackground(new Color(102, 51, 153));
		panelChamCong.setBackground(new Color(102, 51, 153));
		lblKhachHang1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadChild(new KhachHangJInternalFrame());
			}
		});
		lblKhachHang1.setForeground(Color.WHITE);
		lblKhachHang1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelKhachHang1.setBackground(new Color(102, 51, 153));
		lblDangXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logout();
			}
		});
		lblDangXuat.setForeground(Color.WHITE);
		lblDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelDangXuat.setBackground(new Color(102, 51, 153));
		GroupLayout gl_panelDangXuat = new GroupLayout(panelDangXuat);
		gl_panelDangXuat.setHorizontalGroup(gl_panelDangXuat.createParallelGroup(Alignment.LEADING)
				.addGap(0, 272, Short.MAX_VALUE).addGroup(Alignment.TRAILING,
						gl_panelDangXuat.createSequentialGroup().addContainerGap(20, Short.MAX_VALUE).addComponent(
								lblDangXuat, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)));
		gl_panelDangXuat
				.setVerticalGroup(gl_panelDangXuat.createParallelGroup(Alignment.LEADING).addGap(0,
						40, Short.MAX_VALUE)
						.addGroup(gl_panelDangXuat.createSequentialGroup()
								.addComponent(lblDangXuat, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelDangXuat.setLayout(gl_panelDangXuat);
		lblDanhMucOpen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.setVisible(true);
				lblDanhMucOpen.setVisible(false);
			}
		});

		lblDanhMucOpen.setVisible(false);
		setBackground(new Color(75, 0, 130));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1295, 741);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		panel.setBackground(new Color(51, 0, 102));

		pnlMain.setBackground(new Color(102, 0, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblDanhMucOpen, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(pnlMain, GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
					.addGap(1))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDanhMucOpen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 777, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlMain, GroupLayout.PREFERRED_SIZE, 670, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		panelThongKe.setBackground(new Color(153, 51, 255));

		panelHangHoa.setBackground(new Color(102, 0, 204));

		panelSelectHangHoa.setBackground(new Color(102, 0, 204));

		lblHangHoa.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\hanghoa.png", 20, 20)));

		lblHangHoa.setForeground(Color.WHITE);
		lblHangHoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_panelHangHoa = new GroupLayout(panelHangHoa);
		gl_panelHangHoa.setHorizontalGroup(gl_panelHangHoa.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelHangHoa.createSequentialGroup()
						.addComponent(panelSelectHangHoa, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblHangHoa, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panelHangHoa.setVerticalGroup(gl_panelHangHoa.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelHangHoa.createSequentialGroup()
						.addGroup(gl_panelHangHoa.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panelSelectHangHoa, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblHangHoa, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 57,
										Short.MAX_VALUE))
						.addContainerGap()));
		panelHangHoa.setLayout(gl_panelHangHoa);

		panelGiaoDich.setBackground(new Color(102, 0, 204));

		panelSelectGiaoDich.setBackground(new Color(102, 0, 204));

		lblGiaoDich.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\giaodich.png", 20, 20)));
		lblGiaoDich.setForeground(Color.WHITE);
		lblGiaoDich.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_panelGiaoDich = new GroupLayout(panelGiaoDich);
		gl_panelGiaoDich.setHorizontalGroup(gl_panelGiaoDich.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelGiaoDich.createSequentialGroup()
						.addComponent(panelSelectGiaoDich, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblGiaoDich, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panelGiaoDich.setVerticalGroup(gl_panelGiaoDich.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelGiaoDich.createSequentialGroup()
						.addGroup(gl_panelGiaoDich.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panelSelectGiaoDich, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblGiaoDich, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 57,
										Short.MAX_VALUE))
						.addContainerGap()));
		panelGiaoDich.setLayout(gl_panelGiaoDich);

		panelNhanVien.setBackground(new Color(102, 0, 204));

		panelSelectNhanVien.setBackground(new Color(102, 0, 204));

		lblNhanVien.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\nhanvien.png", 20, 20)));
		lblNhanVien.setForeground(Color.WHITE);
		lblNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_panelNhanVien = new GroupLayout(panelNhanVien);
		gl_panelNhanVien.setHorizontalGroup(gl_panelNhanVien.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNhanVien.createSequentialGroup()
						.addComponent(panelSelectNhanVien, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblNhanVien, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panelNhanVien.setVerticalGroup(gl_panelNhanVien.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNhanVien.createSequentialGroup()
						.addGroup(gl_panelNhanVien.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panelSelectNhanVien, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNhanVien, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 57,
										Short.MAX_VALUE))
						.addContainerGap()));
		panelNhanVien.setLayout(gl_panelNhanVien);

		panelKhachHang.setBackground(new Color(102, 0, 204));

		panelSelectKhachHang.setBackground(new Color(102, 0, 204));

		lblKhachHang.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\khachhang.png", 20, 20)));

		lblKhachHang.setForeground(Color.WHITE);
		lblKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_panelKhachHang = new GroupLayout(panelKhachHang);
		gl_panelKhachHang.setHorizontalGroup(gl_panelKhachHang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelKhachHang.createSequentialGroup()
						.addComponent(panelSelectKhachHang, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblKhachHang, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panelKhachHang.setVerticalGroup(gl_panelKhachHang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelKhachHang.createSequentialGroup()
						.addGroup(gl_panelKhachHang.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panelSelectKhachHang, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblKhachHang, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 57,
										Short.MAX_VALUE))
						.addContainerGap()));
		panelKhachHang.setLayout(gl_panelKhachHang);

		panelCaNhan.setBackground(new Color(102, 0, 204));

		panelSelectCaNhan.setBackground(new Color(102, 0, 204));

		lblCaNhan.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\canhan.png", 20, 20)));
		lblCaNhan.setForeground(Color.WHITE);
		lblCaNhan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_panelCaNhan = new GroupLayout(panelCaNhan);
		gl_panelCaNhan.setHorizontalGroup(gl_panelCaNhan.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCaNhan.createSequentialGroup()
						.addComponent(panelSelectCaNhan, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblCaNhan, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panelCaNhan.setVerticalGroup(gl_panelCaNhan.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCaNhan.createSequentialGroup()
						.addGroup(gl_panelCaNhan.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panelSelectCaNhan, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblCaNhan, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 57,
										Short.MAX_VALUE))
						.addContainerGap()));
		panelCaNhan.setLayout(gl_panelCaNhan);

		panelBanHang.setBackground(new Color(102, 0, 204));

		panelSelectBanHang.setBackground(new Color(102, 0, 204));

		lblBanHang.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\banhang.png", 20, 20)));
		lblBanHang.setForeground(Color.WHITE);
		lblBanHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_panelBanHang = new GroupLayout(panelBanHang);
		gl_panelBanHang.setHorizontalGroup(gl_panelBanHang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBanHang.createSequentialGroup()
						.addComponent(panelSelectBanHang, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblBanHang, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panelBanHang.setVerticalGroup(gl_panelBanHang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBanHang.createSequentialGroup()
						.addGroup(gl_panelBanHang.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panelSelectBanHang, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblBanHang, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 57,
										Short.MAX_VALUE))
						.addContainerGap()));
		panelBanHang.setLayout(gl_panelBanHang);

		panelCaNhan1.setBackground(new Color(102, 51, 153));
		lblNhapHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadChild(new NhapHangJInternalFrame());
			}
		});
		lblNhapHang.setForeground(Color.WHITE);
		lblNhapHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNhapHang.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\nhaphang.png", 20, 20)));
		panelNhapHang.setBackground(new Color(102, 51, 153));
		GroupLayout gl_panelNhapHang = new GroupLayout(panelNhapHang);
		gl_panelNhapHang.setHorizontalGroup(gl_panelNhapHang.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING, gl_panelNhapHang.createSequentialGroup().addContainerGap(20, Short.MAX_VALUE)
						.addComponent(lblNhapHang, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)));
		gl_panelNhapHang.setVerticalGroup(gl_panelNhapHang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNhapHang.createSequentialGroup()
						.addComponent(lblNhapHang, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelNhapHang.setLayout(gl_panelNhapHang);
		panelNhapHang.setVisible(false);
		lblBanHangCon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadChild(new ThanhToanJInternalFrame());
			}
		});
		lblBanHangCon.setForeground(Color.WHITE);
		lblBanHangCon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelBanHangCon.setBackground(new Color(102, 51, 153));
		GroupLayout gl_panelBanHangCon = new GroupLayout(panelBanHangCon);
		gl_panelBanHangCon.setHorizontalGroup(gl_panelBanHangCon.createParallelGroup(Alignment.LEADING)
				.addGap(0, 272, Short.MAX_VALUE).addGroup(Alignment.TRAILING,
						gl_panelBanHangCon.createSequentialGroup().addContainerGap(20, Short.MAX_VALUE).addComponent(
								lblBanHangCon, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)));
		gl_panelBanHangCon.setVerticalGroup(
				gl_panelBanHangCon.createParallelGroup(Alignment.LEADING).addGap(0, 40, Short.MAX_VALUE)
						.addGroup(gl_panelBanHangCon.createSequentialGroup()
								.addComponent(lblBanHangCon, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelBanHangCon.setLayout(gl_panelBanHangCon);

		lblBanHangCon.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\banhang.png", 20, 20)));

		panelBanHangCon.setVisible(false);
		lblTraHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadChild(new TraHangJInternalFrame());
			}
		});
		lblTraHang.setForeground(Color.WHITE);
		lblTraHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelTraHang.setBackground(new Color(102, 51, 153));
		GroupLayout gl_panelTraHang = new GroupLayout(panelTraHang);
		gl_panelTraHang.setHorizontalGroup(gl_panelTraHang.createParallelGroup(Alignment.LEADING)
				.addGap(0, 272, Short.MAX_VALUE).addGroup(Alignment.TRAILING,
						gl_panelTraHang.createSequentialGroup().addContainerGap(20, Short.MAX_VALUE).addComponent(
								lblTraHang, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)));
		gl_panelTraHang
				.setVerticalGroup(gl_panelTraHang.createParallelGroup(Alignment.LEADING).addGap(0, 40, Short.MAX_VALUE)
						.addGroup(gl_panelTraHang.createSequentialGroup()
								.addComponent(lblTraHang, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelTraHang.setLayout(gl_panelTraHang);
		lblTraHang.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\trahang.png", 20, 20)));
		panelTraHang.setVisible(false);
		lblChiTieu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadChild(new BaoCaoChiTieuJInternalFrame());
			}
		});
		lblChiTieu.setForeground(Color.WHITE);
		lblChiTieu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelChiTieu.setBackground(new Color(102, 51, 153));
		GroupLayout gl_panelChiTieu = new GroupLayout(panelChiTieu);
		gl_panelChiTieu.setHorizontalGroup(gl_panelChiTieu.createParallelGroup(Alignment.LEADING)
				.addGap(0, 272, Short.MAX_VALUE).addGroup(Alignment.TRAILING,
						gl_panelChiTieu.createSequentialGroup().addContainerGap(20, Short.MAX_VALUE).addComponent(
								lblChiTieu, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)));
		gl_panelChiTieu
				.setVerticalGroup(gl_panelChiTieu.createParallelGroup(Alignment.LEADING).addGap(0, 40, Short.MAX_VALUE)
						.addGroup(gl_panelChiTieu.createSequentialGroup()
								.addComponent(lblChiTieu, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelChiTieu.setLayout(gl_panelChiTieu);
		lblChiTieu.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\chitieu.png", 20, 20)));
		panelChiTieu.setVisible(false);
		lblHangHoaCon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadChild(new HangHoaJInternalFrame());
			}
		});
		lblHangHoaCon.setForeground(Color.WHITE);
		lblHangHoaCon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelHangHoaCon.setBackground(new Color(102, 51, 153));
		lblHangHoaCon.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\hanghoa.png", 20, 20)));
		GroupLayout gl_panelHangHoaCon = new GroupLayout(panelHangHoaCon);
		gl_panelHangHoaCon.setHorizontalGroup(gl_panelHangHoaCon.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING, gl_panelHangHoaCon.createSequentialGroup().addContainerGap(20, Short.MAX_VALUE)
						.addComponent(lblHangHoaCon, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)));
		gl_panelHangHoaCon.setVerticalGroup(gl_panelHangHoaCon.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelHangHoaCon.createSequentialGroup()
						.addComponent(lblHangHoaCon, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelHangHoaCon.setLayout(gl_panelHangHoaCon);

		panelHangHoaCon.setVisible(false);
		lblKiemKho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadChild(new KiemKhoJInternalFrame());
			}
		});
		lblKiemKho.setForeground(Color.WHITE);
		lblKiemKho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelKiemKho.setBackground(new Color(102, 51, 153));
		GroupLayout gl_panelKiemKho = new GroupLayout(panelKiemKho);
		gl_panelKiemKho.setHorizontalGroup(gl_panelKiemKho.createParallelGroup(Alignment.LEADING)
				.addGap(0, 272, Short.MAX_VALUE).addGroup(Alignment.TRAILING,
						gl_panelKiemKho.createSequentialGroup().addContainerGap(20, Short.MAX_VALUE).addComponent(
								lblKiemKho, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)));
		gl_panelKiemKho
				.setVerticalGroup(gl_panelKiemKho.createParallelGroup(Alignment.LEADING).addGap(0, 40, Short.MAX_VALUE)
						.addGroup(gl_panelKiemKho.createSequentialGroup()
								.addComponent(lblKiemKho, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelKiemKho.setLayout(gl_panelKiemKho);
		lblKiemKho.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\kiemkho.png", 20, 20)));
		panelKiemKho.setVisible(false);
		lblNguonHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadChild(new NguonHangJInternalFrame());
			}
		});
		lblNguonHang.setForeground(Color.WHITE);
		lblNguonHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelNguonHang.setBackground(new Color(102, 51, 153));
		GroupLayout gl_panelNguonHang = new GroupLayout(panelNguonHang);
		gl_panelNguonHang.setHorizontalGroup(
				gl_panelNguonHang.createParallelGroup(Alignment.TRAILING).addGap(0, 272, Short.MAX_VALUE)
						.addGroup(gl_panelNguonHang.createSequentialGroup().addContainerGap(20, Short.MAX_VALUE)
								.addComponent(lblNguonHang, GroupLayout.PREFERRED_SIZE, 252,
										GroupLayout.PREFERRED_SIZE)));
		gl_panelNguonHang.setVerticalGroup(
				gl_panelNguonHang.createParallelGroup(Alignment.LEADING).addGap(0, 40, Short.MAX_VALUE)
						.addGroup(gl_panelNguonHang.createSequentialGroup()
								.addComponent(lblNguonHang, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelNguonHang.setLayout(gl_panelNguonHang);
		lblNguonHang.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\nguonhang.png", 20, 20)));
		panelNguonHang.setVisible(false);
		lblDoanhThu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadChild(new ThongKeDoanhThuJInternalFrame());
			}
		});
		lblDoanhThu.setForeground(Color.WHITE);
		lblDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelDoanhThu.setBackground(new Color(102, 51, 153));
		lblDoanhThu.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\doanhthu.png", 20, 20)));
		GroupLayout gl_panelDoanhThu = new GroupLayout(panelDoanhThu);
		gl_panelDoanhThu.setHorizontalGroup(gl_panelDoanhThu.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING, gl_panelDoanhThu.createSequentialGroup().addContainerGap(18, Short.MAX_VALUE)
						.addComponent(lblDoanhThu, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)));
		gl_panelDoanhThu.setVerticalGroup(gl_panelDoanhThu.createParallelGroup(Alignment.LEADING)
				.addComponent(lblDoanhThu, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE));
		panelDoanhThu.setLayout(gl_panelDoanhThu);
		panelDoanhThu.setVisible(false);
		lblDoanhSo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadChild(new ThongKeDoanhSoJInternalFrame());
			}
		});
		lblDoanhSo.setForeground(Color.WHITE);
		lblDoanhSo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelDoanhso.setBackground(new Color(102, 51, 153));
		GroupLayout gl_panelDoanhso = new GroupLayout(panelDoanhso);
		gl_panelDoanhso.setHorizontalGroup(
				gl_panelDoanhso.createParallelGroup(Alignment.TRAILING).addGap(0, 272, Short.MAX_VALUE)
						.addGroup(gl_panelDoanhso.createSequentialGroup().addContainerGap(20, Short.MAX_VALUE)
								.addComponent(lblDoanhSo, GroupLayout.PREFERRED_SIZE, 252,
										GroupLayout.PREFERRED_SIZE)));
		gl_panelDoanhso
				.setVerticalGroup(gl_panelDoanhso.createParallelGroup(Alignment.LEADING).addGap(0, 40, Short.MAX_VALUE)
						.addComponent(lblDoanhSo, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE));
		panelDoanhso.setLayout(gl_panelDoanhso);
		lblDoanhSo.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\doanhso.png", 20, 20)));

		panelDoanhso.setVisible(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelDoanhso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel.createSequentialGroup()
								.addContainerGap()
								.addComponent(panelDoanhThu, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addContainerGap()
									.addComponent(panelNguonHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panel.createSequentialGroup()
										.addContainerGap()
										.addComponent(panelKiemKho, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel.createSequentialGroup()
											.addContainerGap()
											.addComponent(panelHangHoaCon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_panel.createSequentialGroup()
												.addContainerGap()
												.addComponent(panelChiTieu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_panel.createSequentialGroup()
													.addContainerGap()
													.addComponent(panelTraHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
													.addGroup(gl_panel.createSequentialGroup()
														.addContainerGap()
														.addComponent(panelBanHangCon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
													.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_panel.createSequentialGroup()
															.addContainerGap()
															.addComponent(panelNhapHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
															.addGroup(gl_panel.createSequentialGroup()
																.addContainerGap()
																.addComponent(panelBangLuong, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
															.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
																.addGroup(gl_panel.createSequentialGroup()
																	.addGap(18)
																	.addComponent(panelChamCong, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
																.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
																	.addGroup(gl_panel.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(panelKhachHang1, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
																	.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
																		.addGroup(gl_panel.createSequentialGroup()
																			.addContainerGap()
																			.addComponent(panelDangXuat, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
																		.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
																			.addGroup(gl_panel.createSequentialGroup()
																				.addContainerGap()
																				.addComponent(panelCaNhan1, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
																			.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
																				.addGroup(gl_panel.createSequentialGroup()
																					.addContainerGap()
																					.addComponent(lblAvatar, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																					.addPreferredGap(ComponentPlacement.UNRELATED)
																					.addComponent(lblTenUser, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
																					.addGap(18)
																					.addComponent(lblDanhMuc, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
																				.addComponent(panelNhanVien, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 290, Short.MAX_VALUE)
																				.addComponent(panelKhachHang, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 290, Short.MAX_VALUE)
																				.addComponent(panelCaNhan, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 290, Short.MAX_VALUE)
																				.addComponent(panelBanHang, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 290, Short.MAX_VALUE)
																				.addComponent(panelHangHoa, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
																				.addComponent(panelGiaoDich, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 290, Short.MAX_VALUE)
																				.addComponent(panelThongKe, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
																				.addGroup(gl_panel.createSequentialGroup()
																					.addContainerGap()
																					.addComponent(panelNhanVien1, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)))))))))))))))))
					.addGap(0))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAvatar, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDanhMuc, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTenUser, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addComponent(panelThongKe, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(panelDoanhThu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(panelDoanhso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(panelHangHoa, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(panelHangHoaCon, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(panelKiemKho, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(panelNguonHang, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(panelGiaoDich, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(panelNhapHang, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(panelBanHangCon, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(panelTraHang, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(panelChiTieu, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(panelNhanVien, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(panelNhanVien1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(panelChamCong, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(panelBangLuong, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(panelKhachHang, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(panelKhachHang1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(panelCaNhan, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(panelCaNhan1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(panelDangXuat, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(panelBanHang, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		GroupLayout gl_panelBangLuong = new GroupLayout(panelBangLuong);
		gl_panelBangLuong.setHorizontalGroup(gl_panelBangLuong.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING, gl_panelBangLuong.createSequentialGroup().addContainerGap(20, Short.MAX_VALUE)
						.addComponent(lblBangLuong, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)));
		gl_panelBangLuong.setVerticalGroup(gl_panelBangLuong.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBangLuong.createSequentialGroup()
						.addComponent(lblBangLuong, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelBangLuong.setLayout(gl_panelBangLuong);
		GroupLayout gl_panelChamCong = new GroupLayout(panelChamCong);
		gl_panelChamCong.setHorizontalGroup(gl_panelChamCong.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING, gl_panelChamCong.createSequentialGroup().addContainerGap(20, Short.MAX_VALUE)
						.addComponent(lblChamCong, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)));
		gl_panelChamCong.setVerticalGroup(gl_panelChamCong.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelChamCong.createSequentialGroup()
						.addComponent(lblChamCong, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelChamCong.setLayout(gl_panelChamCong);
		GroupLayout gl_panelChamCong1 = new GroupLayout(panelKhachHang1);
		gl_panelChamCong1.setHorizontalGroup(gl_panelChamCong1.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING, gl_panelChamCong1.createSequentialGroup().addContainerGap(20, Short.MAX_VALUE)
						.addComponent(lblKhachHang1, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)));
		gl_panelChamCong1.setVerticalGroup(gl_panelChamCong1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelChamCong1.createSequentialGroup()
						.addComponent(lblKhachHang1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelKhachHang1.setLayout(gl_panelChamCong1);
		lblCaNhan1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CaNhanFrame caNhanFrame = new CaNhanFrame();
				caNhanFrame.setLocationRelativeTo(null);
				caNhanFrame.setVisible(true);
			}
		});

		lblCaNhan1.setForeground(Color.WHITE);
		lblCaNhan1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panelCaNhan1 = new GroupLayout(panelCaNhan1);
		gl_panelCaNhan1.setHorizontalGroup(gl_panelCaNhan1.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING, gl_panelCaNhan1.createSequentialGroup().addContainerGap(20, Short.MAX_VALUE)
						.addComponent(lblCaNhan1, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)));
		gl_panelCaNhan1.setVerticalGroup(gl_panelCaNhan1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCaNhan1.createSequentialGroup()
						.addComponent(lblCaNhan1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelCaNhan1.setLayout(gl_panelCaNhan1);
		panelNhanVien1.setBackground(new Color(102, 51, 153));
		GroupLayout gl_panelNhanVien1 = new GroupLayout(panelNhanVien1);
		gl_panelNhanVien1.setHorizontalGroup(gl_panelNhanVien1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelNhanVien1.createSequentialGroup().addContainerGap(20, Short.MAX_VALUE)
						.addComponent(lblNhanVien1, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)));
		gl_panelNhanVien1.setVerticalGroup(gl_panelNhanVien1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNhanVien1.createSequentialGroup()
						.addComponent(lblNhanVien1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(1, Short.MAX_VALUE)));
		panelNhanVien1.setLayout(gl_panelNhanVien1);
		lblDanhMuc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.setVisible(false);
				lblDanhMucOpen.setVisible(true);
			}
		});

		panelSelectThongKe.setBackground(Color.BLACK);

		lblThongKe.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\thongke.png", 20, 20)));
		lblDanhMuc.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\danhmuc.png", 20, 20)));
		lblDanhMucOpen.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\danhmuc.png", 20, 20)));

		lblNhanVien1.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\nhanvien.png", 20, 20)));
		lblBangLuong.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\bangluong.png", 20, 20)));
		lblChamCong.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\chamcong.png", 20, 20)));

		lblThongKe.setForeground(Color.WHITE);
		lblThongKe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_panelThongKe = new GroupLayout(panelThongKe);
		gl_panelThongKe.setHorizontalGroup(gl_panelThongKe.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelThongKe.createSequentialGroup()
						.addComponent(panelSelectThongKe, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblThongKe, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)));
		gl_panelThongKe.setVerticalGroup(gl_panelThongKe.createParallelGroup(Alignment.LEADING)
				.addComponent(panelSelectThongKe, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
				.addComponent(lblThongKe, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE));
		panelThongKe.setLayout(gl_panelThongKe);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

		lblCaNhan1.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\canhan.png", 20, 20)));
		lblDangXuat.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\logout1.png", 20, 20)));
		lblKhachHang1.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\khachhang.png", 20, 20)));

		panelCaNhan1.setVisible(false);
		panelDangXuat.setVisible(false);
		panelKhachHang1.setVisible(false);

		panelNhanVien1.setVisible(false);
		panelChamCong.setVisible(false);
		panelBangLuong.setVisible(false);

		listToolBar.add(new Toolbar(panelSelectThongKe, panelThongKe, lblThongKe));
		listToolBar.add(new Toolbar(panelSelectHangHoa, panelHangHoa, lblHangHoa));
		listToolBar.add(new Toolbar(panelSelectGiaoDich, panelGiaoDich, lblGiaoDich));
		listToolBar.add(new Toolbar(panelSelectNhanVien, panelNhanVien, lblNhanVien));
		listToolBar.add(new Toolbar(panelSelectKhachHang, panelKhachHang, lblKhachHang));
		listToolBar.add(new Toolbar(panelSelectCaNhan, panelCaNhan, lblCaNhan));
		listToolBar.add(new Toolbar(panelSelectBanHang, panelBanHang, lblBanHang));
		pnlMain.setLayout(new CardLayout(0, 0));

		addMouseEnter();
	}

	public void addMouseEnter() {
		lblThongKe.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				resetColor();
				panelSelectThongKe.setBackground(Color.BLACK);
				panelThongKe.setBackground(new Color(153, 51, 255));
			}

			public void mouseClicked(MouseEvent e) {
				select = 0;
				if (openThongKe == 0) {
					openThongKe = 1;
					panelDoanhso.setVisible(true);
					panelDoanhThu.setVisible(true);
				} else {
					openThongKe = 0;
					panelDoanhso.setVisible(false);
					panelDoanhThu.setVisible(false);
				}
				resetColor();
			}

			public void mouseExited(MouseEvent e) {
				resetColor();
			}
		});

		lblBanHang.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				resetColor();
				panelSelectBanHang.setBackground(Color.BLACK);
				panelBanHang.setBackground(new Color(153, 51, 255));
			}

			public void mouseClicked(MouseEvent e) {
				select = 6;
				resetColor();
			}

			public void mouseExited(MouseEvent e) {
				resetColor();
			}
		});

		lblCaNhan.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				resetColor();
				panelSelectCaNhan.setBackground(Color.BLACK);
				panelCaNhan.setBackground(new Color(153, 51, 255));
			}

			public void mouseClicked(MouseEvent e) {
				select = 5;
				if (openCaNhan == 0) {
					openCaNhan = 1;
					panelCaNhan1.setVisible(true);
					panelDangXuat.setVisible(true);
				} else {
					openCaNhan = 0;
					panelCaNhan1.setVisible(false);
					panelDangXuat.setVisible(false);
				}
				resetColor();

			}

			public void mouseExited(MouseEvent e) {
				resetColor();
			}
		});

		lblGiaoDich.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				resetColor();
				panelSelectGiaoDich.setBackground(Color.BLACK);
				panelGiaoDich.setBackground(new Color(153, 51, 255));
			}

			public void mouseClicked(MouseEvent e) {
				select = 2;
				if (openGiaoDich == 0) {
					openGiaoDich = 1;
					panelBanHangCon.setVisible(true);
					panelNhapHang.setVisible(true);
					panelChiTieu.setVisible(true);
					panelTraHang.setVisible(true);
				} else {
					openGiaoDich = 0;
					panelBanHangCon.setVisible(false);
					panelNhapHang.setVisible(false);
					panelChiTieu.setVisible(false);
					panelTraHang.setVisible(false);
				}
				resetColor();

			}

			public void mouseExited(MouseEvent e) {
				resetColor();
			}
		});

		lblHangHoa.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				resetColor();
				panelSelectHangHoa.setBackground(Color.BLACK);
				panelHangHoa.setBackground(new Color(153, 51, 255));
			}

			public void mouseClicked(MouseEvent e) {
				select = 1;
				if (openHangHoa == 0) {
					openHangHoa = 1;
					panelHangHoaCon.setVisible(true);
					panelNguonHang.setVisible(true);
					panelKiemKho.setVisible(true);
				} else {
					openHangHoa = 0;
					panelHangHoaCon.setVisible(false);
					panelNguonHang.setVisible(false);
					panelKiemKho.setVisible(false);
				}
				resetColor();

			}

			public void mouseExited(MouseEvent e) {
				resetColor();
			}
		});

		lblKhachHang.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				resetColor();
				panelSelectKhachHang.setBackground(Color.BLACK);
				panelKhachHang.setBackground(new Color(153, 51, 255));
			}

			public void mouseClicked(MouseEvent e) {
				select = 4;
				if (openKhachHang == 0) {
					openKhachHang = 1;
					panelKhachHang1.setVisible(true);
				} else {
					openKhachHang = 0;
					panelKhachHang1.setVisible(false);
				}
				resetColor();

			}

			public void mouseExited(MouseEvent e) {
				resetColor();
			}
		});

		lblNhanVien.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				resetColor();
				panelSelectNhanVien.setBackground(Color.BLACK);
				panelNhanVien.setBackground(new Color(153, 51, 255));
			}

			public void mouseClicked(MouseEvent e) {
				select = 3;
				if (openNhanVien == 0) {
					openNhanVien = 1;
					panelNhanVien1.setVisible(true);
					panelChamCong.setVisible(true);
					panelBangLuong.setVisible(true);
				} else {
					openNhanVien = 0;
					panelNhanVien1.setVisible(false);
					panelChamCong.setVisible(false);
					panelBangLuong.setVisible(false);
				}
				resetColor();
			}

			public void mouseExited(MouseEvent e) {
				resetColor();
			}
		});
	}

	public void resetColor() {
		for (int i = 0; i < listToolBar.size(); i++) {
			if (i == select) {
				continue;
			}
			listToolBar.get(i).panelCha.setBackground(new Color(102, 0, 204));
			listToolBar.get(i).panelSelect.setBackground(new Color(102, 0, 204));
		}
	}
	
	public void logout() {
		if (EntityMessage.confirm(this, "Đồng ý đăng xuất tài khoản?")) {
			EntityAuthorization.USER = null;
			new LoginJFrame().setVisible(true);
			this.setVisible(false);
		}
	}

	public void loadChild(JInternalFrame frame) {
		pnlMain.removeAll();
		frame.setSize(pnlMain.getSize());
		try {
			frame.setMaximum(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		pnlMain.add(frame);
		pnlMain.repaint();
	}
}
