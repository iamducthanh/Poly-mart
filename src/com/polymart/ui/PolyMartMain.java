package com.polymart.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Toolkit;
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

import com.polymart.entity.*;
import com.polymart.ui.baocao.BaoCaoJInternalFrame;
import com.polymart.ui.giaodich.NhapHangJInternalFrame;
import com.polymart.ui.giaodich.ThanhToanJInternalFrame;
import com.polymart.ui.giaodich.TraHangJInternalFrame;
import com.polymart.ui.hanghoa.HangHoaJInternalFrame;
import com.polymart.ui.hanghoa.KiemKhoJInternalFrame;
import com.polymart.ui.hanghoa.NguonHangJInternalFrame;
import com.polymart.ui.hanghoa.ThietLapGiaJInternalFrame;
import com.polymart.ui.khachhang.KhachHangJInternalFrame;
import com.polymart.ui.nhanvien.ChamCongJInternalFrame;
import com.polymart.ui.nhanvien.NhanVienJInternalFrame;
import com.polymart.ui.taikhoan.ChangePassFrame;
import com.polymart.ui.taikhoan.LoginJFrame;

public class PolyMartMain extends JFrame {

	private static final long serialVersionUID = 6825346390245174222L;

	public JDesktopPane desktopPane = new JDesktopPane();
	URI uri;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new PolyMartMain().setVisible(true);
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ADMIN\\eclipse-workspace\\Poly-mart\\images\\fpt.png"));
		setTitle("Poly Mart          " + EntityAuthorization.USER.getHoTen() + "          "
				+ EntityAuthorization.USER.getChucVu()); // Tiêu đề theo tên người dùng
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		editMenu();
	}

	public void editMenu() {
		JMenuBar menuBar = new JMenuBar();
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) dimension.getWidth();
		setJMenuBar(menuBar);

		JMenu mnTongQuan = new JMenu("Thống kê");
		mnTongQuan.setIcon(new ImageIcon("images\\tongquan.png"));
		mnTongQuan.setBackground(new Color(0, 191, 255));
		menuBar.add(mnTongQuan);

		JMenu mnHangHoa = new JMenu("Hàng hóa");
		mnHangHoa.setIcon(new ImageIcon("C:\\images\\hanghoa.png"));
		menuBar.add(mnHangHoa);

		JMenuItem mntmHangHoa = new JMenuItem("Hàng hóa");
		mntmHangHoa.setIcon(new ImageIcon("images\\danhmuc.png"));
		mnHangHoa.add(mntmHangHoa);

		JMenuItem mntmThietLapGia = new JMenuItem("Thiết lập giá");
		mntmThietLapGia.setIcon(new ImageIcon("images\\setgia.png"));
		mnHangHoa.add(mntmThietLapGia);

		JMenuItem mntmKiemKho = new JMenuItem("Kiểm kho");
		mntmKiemKho.setIcon(new ImageIcon("images\\kiemkho.png"));
		mnHangHoa.add(mntmKiemKho);

		JMenuItem mntmNguonHang = new JMenuItem("Nguồn hàng");
		mntmNguonHang.setIcon(new ImageIcon("images\\nguonhang.png"));
		mnHangHoa.add(mntmNguonHang);

		JMenu mnGiaoDich = new JMenu("Giao dịch");
		mnGiaoDich.setIcon(new ImageIcon("images\\giaodich.png"));
		menuBar.add(mnGiaoDich);

		JMenuItem mntmHoaDonNhap = new JMenuItem("Hóa đơn nhập");
		mntmHoaDonNhap.setIcon(new ImageIcon("images\\hdnhap.png"));
		mnGiaoDich.add(mntmHoaDonNhap);

		JMenuItem mntmHoaDonThanhToan = new JMenuItem("Hóa đơn thanh toán");
		mntmHoaDonThanhToan.setIcon(new ImageIcon("images\\hdxuat.png"));
		mnGiaoDich.add(mntmHoaDonThanhToan);

		JMenuItem mntmHoaDonTraHang = new JMenuItem("Hóa đơn trả hàng");
		mntmHoaDonTraHang.setIcon(new ImageIcon("images\\hdtrahang.png"));
		mnGiaoDich.add(mntmHoaDonTraHang);

		JMenu mnDoiTac = new JMenu("Báo cáo");
		mnDoiTac.setIcon(new ImageIcon("images\\baocao.png"));
		menuBar.add(mnDoiTac);

		JMenuItem mntmChiTieu = new JMenuItem("Chi tiêu");
		mntmChiTieu.setIcon(new ImageIcon("images\\chitieu.png"));
		mnDoiTac.add(mntmChiTieu);

		JMenu mnNhanVien = new JMenu("Nhân viên");
		mnNhanVien.setIcon(new ImageIcon("images\\nhanvien1.png"));
		menuBar.add(mnNhanVien);

		JMenuItem mntmNhanVien = new JMenuItem("Nhân viên");
		mntmNhanVien.setIcon(new ImageIcon("images\\nhanvien.png"));
		mnNhanVien.add(mntmNhanVien);

		JMenuItem mntmChamCong = new JMenuItem("Chấm công");
		mntmChamCong.setIcon(new ImageIcon("images\\chamcong.png"));
		mnNhanVien.add(mntmChamCong);

		JMenuItem mntmBangTinhLuong = new JMenuItem("Bảng tính lương");
		mntmBangTinhLuong.setIcon(new ImageIcon("images\\tinhluong.png"));
		mnNhanVien.add(mntmBangTinhLuong);

		JMenuItem mntmHoaHong = new JMenuItem("Thiết lập hoa hồng");
		mntmHoaHong.setIcon(new ImageIcon("images\\laixuat.png"));
		mnNhanVien.add(mntmHoaHong);

		JMenu mnKhachHang = new JMenu("Khách hàng");
		mnKhachHang.setIcon(new ImageIcon("images\\doitac.png"));
		menuBar.add(mnKhachHang);

		JMenuItem mntmKhachHang = new JMenuItem("Khách hàng");
		mntmKhachHang.setIcon(new ImageIcon("images\\khachhang.png"));
		mnKhachHang.add(mntmKhachHang);

		JMenu mnCaNhan = new JMenu("Cá nhân");
		mnCaNhan.setIcon(new ImageIcon("images\\user.png"));
		menuBar.add(mnCaNhan);

		JMenuItem mntmCaNhan = new JMenuItem("Cá nhân");
		mntmCaNhan.setIcon(new ImageIcon("images\\user.png"));
		mnCaNhan.add(mntmCaNhan);

		JMenuItem mntmDangXuat = new JMenuItem("Đăng xuất");
		mntmDangXuat.setIcon(new ImageIcon("images\\logout.png"));
		mnCaNhan.add(mntmDangXuat);

		JMenuItem mntmDoiMK = new JMenuItem("Đổi mật khẩu");
		mntmDoiMK.setIcon(new ImageIcon("images\\changepassicon.png"));
		mnCaNhan.add(mntmDoiMK);

		int wLine = (int) (width - (width / 100 * (100 - 42)));
		this.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Font f = this.getFont();
		FontMetrics fm = this.getFontMetrics(f);

		int y = fm.stringWidth(" ");
		int widthChuoi = wLine / y;
		String pad = " ";

		JLabel lblNewLabel = new JLabel(String.format("%" + widthChuoi + "s", pad));
		menuBar.add(lblNewLabel);

		JMenu mnFacebook = new JMenu("Facebook");
		mnFacebook.setIcon(new ImageIcon("images\\facebook.png"));
		mnFacebook.setBackground(new Color(30, 144, 255));
		menuBar.add(mnFacebook);

		JMenu mnBanHang = new JMenu("Bán hàng");
		mnBanHang.setIcon(new ImageIcon("images\\banhang.png"));
		mnBanHang.setBackground(new Color(30, 144, 255));

		menuBar.add(mnBanHang);

		getContentPane().add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(new CardLayout(0, 0));
		try {
			uri = new URI("http://facebook.com/iamducthanh");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		mnFacebook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(uri);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		mntmHangHoa.addActionListener(openDanhMuc);
		mntmNhanVien.addActionListener(openNhanVien);
		mntmThietLapGia.addActionListener(openThietLapGia);
		mntmKiemKho.addActionListener(openKiemKho);
		mntmNguonHang.addActionListener(openNguonHang);
		mntmChamCong.addActionListener(openChamCong);
		mntmChiTieu.addActionListener(openChiTieu);
		mntmHoaDonNhap.addActionListener(openNhapHang);
		mntmDangXuat.addActionListener(logoutAccount);
		mntmDoiMK.addActionListener(doiMatKhau);
		mntmKhachHang.addActionListener(openKhachHang);
		mntmHoaDonThanhToan.addActionListener(openThanhToan);
		mntmHoaDonTraHang.addActionListener(openTraHang);
	}

	ActionListener openTraHang = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			openTraHang();
		}
	};

	public void openTraHang() {
		close();
		TraHangJInternalFrame traHangJInternalFrame = new TraHangJInternalFrame();
		desktopPane.add(traHangJInternalFrame);
		traHangJInternalFrame.initTopTraHang();
		traHangJInternalFrame.initCenterTraHang();
		traHangJInternalFrame.setVisible(true);
	}

	ActionListener openKhachHang = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			openKhachHang();
		}
	};

	public void openKhachHang() {
		close();
		KhachHangJInternalFrame khachHangJInternalFrame = new KhachHangJInternalFrame();
		desktopPane.add(khachHangJInternalFrame);
		khachHangJInternalFrame.setVisible(true);
	}

	ActionListener doiMatKhau = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			doiMatKhau();
		}
	};

	public void doiMatKhau() {
		ChangePassFrame changePassFrame = new ChangePassFrame();
		changePassFrame.setVisible(true);
		changePassFrame.setLocationRelativeTo(null);
	}

	ActionListener openThietLapGia = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			openThietLapGia();
		}
	};

	public void openThietLapGia() {
		close();
		ThietLapGiaJInternalFrame thietLapGia = new ThietLapGiaJInternalFrame();
		desktopPane.add(thietLapGia);
		thietLapGia.initTopThietLapGia();
		thietLapGia.initCenterThietLapGia();
		thietLapGia.setVisible(true);
		setTitle("Thiếp lập giá sản phẩm");
	}

	ActionListener openDanhMuc = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			openDanhMuc();
		}
	};

	public void openDanhMuc() {
		close();
		HangHoaJInternalFrame hangHoa = new HangHoaJInternalFrame();
		desktopPane.add(hangHoa);
		hangHoa.initTopHangHoa();
		hangHoa.initCenterHangHoa();
		hangHoa.setVisible(true);
		setTitle("Danh mục hàng hóa");
	}

	ActionListener openKiemKho = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			openKiemKho();
		}
	};

	public void openKiemKho() {
		close();
		KiemKhoJInternalFrame kiemKho = new KiemKhoJInternalFrame();
		desktopPane.add(kiemKho);
		kiemKho.initTopKiemKho();
		kiemKho.initCenterKiemKho();
		kiemKho.setVisible(true);
		setTitle("Kiểm kho");
	}

	ActionListener openNhanVien = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			openNhanVien();
		}
	};

	public void openNhanVien() {
		close();
		NhanVienJInternalFrame nhanVien = new NhanVienJInternalFrame();
		desktopPane.add(nhanVien);
		nhanVien.initTopNhanVien();
		nhanVien.initCenterNhanVien();
		nhanVien.setVisible(true);
		setTitle("Quản lý nhân viên");
	}

	ActionListener openNguonHang = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			openNguonHang();
		}
	};

	public void openNguonHang() {
		close();
		NguonHangJInternalFrame nguonHang = new NguonHangJInternalFrame();
		desktopPane.add(nguonHang);
		nguonHang.setVisible(true);
		setTitle("Quản lý nguồn hàng");
	}

	ActionListener openChamCong = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			openChamCong();
		}
	};

	public void openChamCong() {
		close();
		ChamCongJInternalFrame chamCong = new ChamCongJInternalFrame();
		desktopPane.add(chamCong);
		chamCong.initTopChamCong();
		chamCong.initCenterChamCong();
		chamCong.setVisible(true);
		setTitle("Kiểm tra chấm công");
	}

	ActionListener openChiTieu = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			openChiTieu();
		}
	};

	public void openChiTieu() {
		close();
		BaoCaoJInternalFrame baoCao = new BaoCaoJInternalFrame();
		desktopPane.add(baoCao);
		baoCao.initTopChiTieu();
		baoCao.initCenterChiTieu();
		baoCao.setVisible(true);
		setTitle("Báo cáo - Chi tiêu");
	}

	ActionListener openNhapHang = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			openNhapHang();
		}
	};

	public void openNhapHang() {
		close();
		NhapHangJInternalFrame nhapHang = new NhapHangJInternalFrame();
		desktopPane.add(nhapHang);
		nhapHang.initTopNhapHang();
		nhapHang.initCenterNhapHang();
		nhapHang.setVisible(true);
		setTitle("Quản lý nhập hàng");
	}

	ActionListener openThanhToan = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			openHangHoa();
		}
	};

	public void openHangHoa() {
		close();
		ThanhToanJInternalFrame thanhToan = new ThanhToanJInternalFrame();
		desktopPane.add(thanhToan);
		thanhToan.initTopThanhToan();
		thanhToan.initCenterThanhToan();
		thanhToan.setVisible(true);
	}

	ActionListener logoutAccount = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			loginClicked();
		}
	};

	public void loginClicked() {
		if (EntityMessage.confirm(this, "Đồng ý đăng xuất tài khoản?")) {
			EntityAuthorization.USER = null;
			new LoginJFrame().setVisible(true);
			setVisible(false);
		}
	}

	public void close() {

		try {
			desktopPane.removeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
