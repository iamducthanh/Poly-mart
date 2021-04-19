package com.polymart.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import com.polymart.entity.EntityAuthorization;
import com.polymart.entity.EntityFrame;
import com.polymart.entity.EntityImage;
import com.polymart.entity.EntityMessage;
import com.polymart.ui.baocao.BaoCaoChiTieuJInternalFrame;
import com.polymart.ui.common.uiCommon;
import com.polymart.ui.giaodich.NhapHangJInternalFrame;
import com.polymart.ui.giaodich.ThanhToanJInternalFrame;
import com.polymart.ui.giaodich.TraHangJInternalFrame;
import com.polymart.ui.hanghoa.HangHoaJInternalFrame;
import com.polymart.ui.hanghoa.KiemKhoJInternalFrame;
import com.polymart.ui.hanghoa.NguonHangJInternalFrame;
import com.polymart.ui.hanghoa.ThietLapGiaJInternalFrame;
import com.polymart.ui.khachhang.KhachHangJInternalFrame;
import com.polymart.ui.nhanvien.BangLuongJIternalFrame;
import com.polymart.ui.nhanvien.CaNhanFrame;
import com.polymart.ui.nhanvien.ChamCongJInternalFrame;
import com.polymart.ui.nhanvien.NhanVienJInternalFrame;
import com.polymart.ui.taikhoan.LoginJFrame;
import com.polymart.ui.thongke.ThongKeDoanhSoJInternalFrame;
import com.polymart.ui.thongke.ThongKeDoanhThuJInternalFrame;

public class PolyMartMain extends JFrame {
    private static final long serialVersionUID = 6825346390245174222L;

    public JDesktopPane pnlMain = new JDesktopPane();
    URI uri;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                    EntityFrame.POLYMARTMAIN = new MainFrame();
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
        setVisible(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage("images\\fpt.png"));
        setTitle(EntityMessage.TITLE);
        if (EntityAuthorization.USER != null) {
            setTitle("Poly Mart          " + EntityAuthorization.USER.getHoTen() + "          "
                    + EntityAuthorization.USER.getChucVu()); // Tiêu đề theo tên người dùng
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        editMenu();
    }

    public void editMenu() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnTongQuan = new JMenu("Thống kê");
        mnTongQuan.setIcon(new ImageIcon("images\\tongquan.png"));
        mnTongQuan.setBackground(new Color(0, 191, 255));
        menuBar.add(mnTongQuan);

        JMenuItem mntmDoanhThu = new JMenuItem("Thống kê doanh thu");
        mntmDoanhThu.setIcon(new ImageIcon("images\\doanhthu.png"));
        mnTongQuan.add(mntmDoanhThu);

        JMenuItem mntnDoanhSo = new JMenuItem("Thống kê doanh số bán ra");
        mntnDoanhSo.setIcon(new ImageIcon("images\\doanhso.png"));
        mnTongQuan.add(mntnDoanhSo);

        JMenu mnHangHoa = new JMenu("Hàng hóa");
        mnHangHoa.setIcon(new ImageIcon("images\\hanghoa.png"));
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

        JMenuItem mntmHoaDonNhap = new JMenuItem("Nhập hàng");
        mntmHoaDonNhap.setIcon(new ImageIcon("images\\hdnhap.png"));
        mnGiaoDich.add(mntmHoaDonNhap);

        JMenuItem mntmHoaDonThanhToan = new JMenuItem("Thanh toán bán hàng");
        mntmHoaDonThanhToan.setIcon(new ImageIcon("images\\hdxuat.png"));
        mnGiaoDich.add(mntmHoaDonThanhToan);

        JMenuItem mntmHoaDonTraHang = new JMenuItem("Trả hàng");
        mntmHoaDonTraHang.setIcon(new ImageIcon("images\\hdtrahang.png"));
        mnGiaoDich.add(mntmHoaDonTraHang);

        JMenuItem mntmChiTieu = new JMenuItem("Chi tiêu");
        mnGiaoDich.add(mntmChiTieu);
        mntmChiTieu.setIcon(new ImageIcon("images\\chitieu.png"));
        mntmChiTieu.addActionListener(openChiTieu);

        JMenu mnDoiTac = new JMenu("Báo cáo");
        mnDoiTac.setIcon(new ImageIcon("images\\baocao.png"));
        menuBar.add(mnDoiTac);

        JMenuItem mntmNewMenuItem = new JMenuItem("Báo cáo chi tiêu trong ngày");
        mnDoiTac.add(mntmNewMenuItem);

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

        JMenu mnKhachHang = new JMenu("Khách hàng");
        mnKhachHang.setIcon(new ImageIcon("images\\doitac.png"));
        menuBar.add(mnKhachHang);

        JMenuItem mntmKhachHang = new JMenuItem("Khách hàng");
        mntmKhachHang.setIcon(new ImageIcon("images\\khachhang.png"));
        mnKhachHang.add(mntmKhachHang);

        JMenu mnCaNhan = new JMenu("Cá nhân");
        mnCaNhan.setIcon(new ImageIcon("images\\user.png"));
        menuBar.add(mnCaNhan);

        JMenu mnBanHang = new JMenu("Bán hàng");
        mnBanHang.setIcon(new ImageIcon("images\\banhang.png"));
        menuBar.add(mnBanHang);
        mnBanHang.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Runtime runtime = Runtime.getRuntime();
                String url = "http://polymart.tk/";
                try {
                    runtime.exec("rundll32 url.dll, FileProtocolHandler " + url);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        JMenuItem mntmCaNhan = new JMenuItem("Cá nhân");
        mntmCaNhan.setIcon(new ImageIcon("images\\user.png"));
        mnCaNhan.add(mntmCaNhan);

        JMenuItem mntmDangXuat = new JMenuItem("Đăng xuất");
        mntmDangXuat.setIcon(new ImageIcon("images\\logout.png"));
        mnCaNhan.add(mntmDangXuat);

        getContentPane().add(pnlMain, BorderLayout.CENTER);
        pnlMain.setLayout(new CardLayout(0, 0));

        mntmHangHoa.addActionListener(openDanhMuc);
        mntmNhanVien.addActionListener(openNhanVien);
        mntmThietLapGia.addActionListener(openThietLapGia);
        mntmKiemKho.addActionListener(openKiemKho);
        mntmNguonHang.addActionListener(openNguonHang);
        mntmChamCong.addActionListener(openChamCong);
        mntmHoaDonNhap.addActionListener(openNhapHang);
        mntmDangXuat.addActionListener(logoutAccount);
        mntmKhachHang.addActionListener(openKhachHang);
        mntmHoaDonThanhToan.addActionListener(openThanhToan);
        mntmHoaDonTraHang.addActionListener(openTraHang);
        mntmBangTinhLuong.addActionListener(openBangLuong);
        mntmCaNhan.addActionListener(openCaNhan);
        mntmDoanhThu.addActionListener(openDoanhThu);
        mntnDoanhSo.addActionListener(openDoanhSo);

        JLabel back = new JLabel("");
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\ADMIN\\AppData\\Roaming\\Microsoft\\Windows\\Themes\\TranscodedWallpaper");
        Image image = EntityImage.resize(imageIcon.getImage(), uiCommon.width, uiCommon.height);
        back.setIcon(new ImageIcon(image));
        pnlMain.add(back);
    }

    ActionListener openTraHang = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            openTraHang();
        }
    };

    public void openTraHang() {
        loadChild(new TraHangJInternalFrame());
    }

    ActionListener openKhachHang = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            openKhachHang();
        }
    };

    public void openKhachHang() {
        loadChild(new KhachHangJInternalFrame());
    }

    ActionListener openThietLapGia = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            openThietLapGia();
        }
    };

    public void openThietLapGia() {
        loadChild(new ThietLapGiaJInternalFrame());
        setTitle("Thiếp lập giá sản phẩm");
    }

    ActionListener openDanhMuc = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            openDanhMuc();
        }
    };

    public void openDanhMuc() {
        loadChild(new HangHoaJInternalFrame());
        setTitle("Danh mục hàng hóa");
    }

    ActionListener openKiemKho = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            openKiemKho();
        }
    };

    public void openKiemKho() {
        loadChild(new KiemKhoJInternalFrame());
        setTitle("Kiểm kho");
    }

    ActionListener openDoanhThu = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            openDoanhThu();
        }
    };

    public void openDoanhThu() {
        loadChild(new ThongKeDoanhThuJInternalFrame());
        setTitle("Thống kê doanh thu");
    }

    ActionListener openDoanhSo = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            openDoanhSo();
        }
    };

    public void openDoanhSo() {
        loadChild(new ThongKeDoanhSoJInternalFrame());
        setTitle("Thống kê doanh số");
    }

    ActionListener openNhanVien = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            openNhanVien();
        }
    };

    public void openNhanVien() {
        EntityFrame.NHANVIENJINTERNAL = new NhanVienJInternalFrame();
        loadChild(EntityFrame.NHANVIENJINTERNAL);
        setTitle("Quản lý nhân viên");
    }

    ActionListener openNguonHang = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            openNguonHang();
        }
    };

    public void openNguonHang() {
        loadChild(new NguonHangJInternalFrame());
        setTitle("Quản lý nguồn hàng");
    }

    ActionListener openChamCong = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            openChamCong();
        }
    };

    public void openCaNhan() {
        CaNhanFrame caNhanFrame = new CaNhanFrame();
        caNhanFrame.setLocationRelativeTo(null);
        caNhanFrame.setVisible(true);
    }

    ActionListener openCaNhan = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            openCaNhan();
        }
    };

    public void openChamCong() {
        loadChild(new ChamCongJInternalFrame());
        setTitle("Kiểm tra chấm công");
    }

    ActionListener openChiTieu = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            openChiTieu();
        }
    };

    public void openChiTieu() {
        loadChild(new BaoCaoChiTieuJInternalFrame());
        setTitle("Giao dịch - Chi tiêu");
    }

    ActionListener openNhapHang = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            openNhapHang();
        }
    };

    public void openNhapHang() {
        loadChild(new NhapHangJInternalFrame());
        setTitle("Quản lý nhập hàng");
    }

    ActionListener openThanhToan = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            openHangHoa();
        }
    };

    public void openHangHoa() {
        loadChild(new ThanhToanJInternalFrame());
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
            this.setVisible(false);
        }
    }

    ActionListener openBangLuong = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            openBangLuong();
        }
    };

    public void openBangLuong() {
        loadChild(new BangLuongJIternalFrame());
    }

    // load JInternalFrame to Mainboard
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
