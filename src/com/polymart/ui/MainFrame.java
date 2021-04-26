package com.polymart.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.polymart.config.SecurityConfig;
import com.polymart.entity.EntityAuthorization;
import com.polymart.entity.EntityImage;
import com.polymart.entity.EntityMessage;
import com.polymart.ui.baocao.BaoCaoChiTieuJInternalFrame;
import com.polymart.ui.baocao.BaoCaoSanPhamBanRaTrongNgay;
import com.polymart.ui.common.uiCommon;
import com.polymart.ui.giaodich.NhapHangJInternalFrame;
import com.polymart.ui.giaodich.ThanhToanJInternalFrame;
import com.polymart.ui.giaodich.TraHangJInternalFrame;
import com.polymart.ui.hanghoa.HangHoaJInternalFrame;
import com.polymart.ui.hanghoa.NguonHangJInternalFrame;
import com.polymart.ui.hanghoa.SanPhamJInternalFrame;
import com.polymart.ui.khachhang.KhachHangJInternalFrame;
import com.polymart.ui.nhanvien.BangLuongJIternalFrame;
import com.polymart.ui.nhanvien.CaNhanFrame;
import com.polymart.ui.nhanvien.ChamCongJInternalFrame;
import com.polymart.ui.nhanvien.NhanVienJInternalFrame;
import com.polymart.ui.taikhoan.LoginJFrame;
import com.polymart.ui.thongke.ThongKeDoanhSoJInternalFrame;
import com.polymart.ui.thongke.ThongKeDoanhThuJInternalFrame;

public class MainFrame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 8757117687802845785L;
    static int select = 0;
    static int openThongKe = 0;
    static int openHangHoa = 0;
    static int openGiaoDich = 0;
    static int openCaNhan = 0;
    static int openKhachHang = 0;
    static int openNhanVien = 0;
    static int openBaoCao = 0;

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
    JLabel lblBaoCaoTo = new JLabel("       Báo cáo");

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
    JPanel panelBaoCao1 = new JPanel();
    JPanel panelLeft = new JPanel();
    private JLabel lblDanhMuc = new JLabel("");

    public static JDesktopPane pnlMain = new JDesktopPane();
    JPanel panel = new JPanel();
    private JPanel panelDoanhThu = new JPanel();
    private JLabel lblDoanhThu = new JLabel("      Thống kê doanh thu");
    private JPanel panelDoanhso = new JPanel();
    private JLabel lblDoanhSo = new JLabel("      Thống kê doanh số");
    JPanel panelHangHoaCon = new JPanel();
    private JLabel lblHangHoaCon = new JLabel("      Hàng hóa");
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
    JLabel lblBaoCao = new JLabel("      Báo cáo trong ngày");
    private JLabel lblAvatar = new JLabel("");
    private JLabel lblTenUser = new JLabel("N");
    private JPanel panelBaoBao = new JPanel();
    private JPanel panelSelectBaoCao = new JPanel();
    private final JPanel panelSanPham = new JPanel();
    private final JLabel lblSanPham = new JLabel("      Sản phẩm");

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    //    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
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

    private void phanQuyen() {
        if (EntityAuthorization.USER.getChucVu().equals(SecurityConfig.VAITRO_QUANLY)) {
        	quyenQuanLy();
        } else if (EntityAuthorization.USER.getChucVu().equals(SecurityConfig.VAITRO_THUNGAN)) {
        	quyenThuNgan();
        } else if (EntityAuthorization.USER.getChucVu().equals(SecurityConfig.VAITRO_BANHANG)) {
        	quyenNhanVien();
        }
    }

    public MainFrame() {
        lblSanPham.setForeground(Color.WHITE);
        lblSanPham.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panelSanPham.setBackground(new Color(102, 51, 153));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 867, 591);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(51, 0, 102));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        setIconImage(Toolkit.getDefaultToolkit().getImage("images\\fpt.png"));
        setTitle("Quản lý cửa hàng");
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        panel.setBackground(new Color(51, 0, 102));
        contentPane.add(panel, BorderLayout.WEST);

        if (EntityAuthorization.USER != null) {
            String urlAnh = "images\\" + EntityAuthorization.USER.getAnhDaiDien();
            lblAvatar.setIcon(new ImageIcon(EntityImage.resizeTheoUrl(urlAnh, 50, 50)));

            lblTenUser.setText(EntityAuthorization.USER.getHoTen());
        }

        panelThongKe.setBackground(new Color(153, 51, 255));

        panelSelectThongKe.setBackground(Color.BLACK);
        lblThongKe.setForeground(Color.WHITE);
        lblThongKe.setFont(new Font("Tahoma", Font.PLAIN, 15));
        GroupLayout gl_panelThongKe = new GroupLayout(panelThongKe);
        gl_panelThongKe.setHorizontalGroup(
                gl_panelThongKe.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 293, Short.MAX_VALUE)
                        .addGroup(gl_panelThongKe.createSequentialGroup()
                                .addComponent(panelSelectThongKe, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(lblThongKe, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
        );
        gl_panelThongKe.setVerticalGroup(
                gl_panelThongKe.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
                        .addComponent(panelSelectThongKe, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(lblThongKe, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        panelThongKe.setLayout(gl_panelThongKe);


        lblTenUser.setForeground(Color.WHITE);
        lblTenUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
        panelBanHang.setBackground(new Color(102, 0, 204));
        panelSelectBanHang.setBackground(new Color(102, 0, 204));

        lblBanHang.setForeground(Color.WHITE);
        lblBanHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
        GroupLayout gl_panelBanHang = new GroupLayout(panelBanHang);
        gl_panelBanHang.setHorizontalGroup(
                gl_panelBanHang.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 293, Short.MAX_VALUE)
                        .addGroup(gl_panelBanHang.createSequentialGroup()
                                .addComponent(panelSelectBanHang, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(lblBanHang, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_panelBanHang.setVerticalGroup(
                gl_panelBanHang.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
                        .addGroup(gl_panelBanHang.createSequentialGroup()
                                .addGroup(gl_panelBanHang.createParallelGroup(Alignment.TRAILING, false)
                                        .addComponent(panelSelectBanHang, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblBanHang, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                                .addContainerGap())
        );
        panelBanHang.setLayout(gl_panelBanHang);

        panelDangXuat.setBackground(new Color(102, 51, 153));

        panelCaNhan1.setBackground(new Color(102, 51, 153));

        lblCaNhan1.setForeground(Color.WHITE);
        lblCaNhan1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GroupLayout gl_panelCaNhan1 = new GroupLayout(panelCaNhan1);
        gl_panelCaNhan1.setHorizontalGroup(
                gl_panelCaNhan1.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGroup(Alignment.TRAILING, gl_panelCaNhan1.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addComponent(lblCaNhan1, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
        );
        gl_panelCaNhan1.setVerticalGroup(
                gl_panelCaNhan1.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGroup(gl_panelCaNhan1.createSequentialGroup()
                                .addComponent(lblCaNhan1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCaNhan1.setLayout(gl_panelCaNhan1);

        panelCaNhan.setBackground(new Color(102, 0, 204));

        panelSelectCaNhan.setBackground(new Color(102, 0, 204));

        lblCaNhan.setForeground(Color.WHITE);
        lblCaNhan.setFont(new Font("Tahoma", Font.PLAIN, 15));
        GroupLayout gl_panelCaNhan = new GroupLayout(panelCaNhan);
        gl_panelCaNhan.setHorizontalGroup(
                gl_panelCaNhan.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 293, Short.MAX_VALUE)
                        .addGroup(gl_panelCaNhan.createSequentialGroup()
                                .addComponent(panelSelectCaNhan, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(lblCaNhan, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_panelCaNhan.setVerticalGroup(
                gl_panelCaNhan.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
                        .addGroup(gl_panelCaNhan.createSequentialGroup()
                                .addGroup(gl_panelCaNhan.createParallelGroup(Alignment.TRAILING, false)
                                        .addComponent(panelSelectCaNhan, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblCaNhan, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                                .addContainerGap())
        );
        panelCaNhan.setLayout(gl_panelCaNhan);

        panelKhachHang1.setBackground(new Color(102, 51, 153));

        lblKhachHang1.setForeground(Color.WHITE);
        lblKhachHang1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GroupLayout gl_panelKhachHang1 = new GroupLayout(panelKhachHang1);
        gl_panelKhachHang1.setHorizontalGroup(
                gl_panelKhachHang1.createParallelGroup(Alignment.TRAILING)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGroup(gl_panelKhachHang1.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addComponent(lblKhachHang1, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
        );
        gl_panelKhachHang1.setVerticalGroup(
                gl_panelKhachHang1.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGroup(gl_panelKhachHang1.createSequentialGroup()
                                .addComponent(lblKhachHang1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelKhachHang1.setLayout(gl_panelKhachHang1);

        panelKhachHang.setBackground(new Color(102, 0, 204));

        panelSelectKhachHang.setBackground(new Color(102, 0, 204));

        lblKhachHang.setForeground(Color.WHITE);
        lblKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
        GroupLayout gl_panelKhachHang = new GroupLayout(panelKhachHang);
        gl_panelKhachHang.setHorizontalGroup(
                gl_panelKhachHang.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 293, Short.MAX_VALUE)
                        .addGroup(gl_panelKhachHang.createSequentialGroup()
                                .addComponent(panelSelectKhachHang, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(lblKhachHang, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_panelKhachHang.setVerticalGroup(
                gl_panelKhachHang.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
                        .addGroup(gl_panelKhachHang.createSequentialGroup()
                                .addGroup(gl_panelKhachHang.createParallelGroup(Alignment.TRAILING, false)
                                        .addComponent(panelSelectKhachHang, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblKhachHang, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                                .addContainerGap())
        );
        panelKhachHang.setLayout(gl_panelKhachHang);

        panelBangLuong.setBackground(new Color(102, 51, 153));

        lblBangLuong.setForeground(Color.WHITE);
        lblBangLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GroupLayout gl_panelBangLuong = new GroupLayout(panelBangLuong);
        gl_panelBangLuong.setHorizontalGroup(
                gl_panelBangLuong.createParallelGroup(Alignment.TRAILING)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGroup(gl_panelBangLuong.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addComponent(lblBangLuong, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
        );
        gl_panelBangLuong.setVerticalGroup(
                gl_panelBangLuong.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGroup(gl_panelBangLuong.createSequentialGroup()
                                .addComponent(lblBangLuong, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBangLuong.setLayout(gl_panelBangLuong);

        panelChamCong.setBackground(new Color(102, 51, 153));

        lblChamCong.setForeground(Color.WHITE);
        lblChamCong.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GroupLayout gl_panelChamCong = new GroupLayout(panelChamCong);
        gl_panelChamCong.setHorizontalGroup(
                gl_panelChamCong.createParallelGroup(Alignment.TRAILING)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGroup(gl_panelChamCong.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addComponent(lblChamCong, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
        );
        gl_panelChamCong.setVerticalGroup(
                gl_panelChamCong.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGroup(gl_panelChamCong.createSequentialGroup()
                                .addComponent(lblChamCong, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelChamCong.setLayout(gl_panelChamCong);

        panelNhanVien1.setBackground(new Color(102, 51, 153));

        lblNhanVien1.setForeground(Color.WHITE);
        lblNhanVien1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GroupLayout gl_panelNhanVien1 = new GroupLayout(panelNhanVien1);
        gl_panelNhanVien1.setHorizontalGroup(
                gl_panelNhanVien1.createParallelGroup(Alignment.TRAILING)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGroup(gl_panelNhanVien1.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addComponent(lblNhanVien1, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
        );
        gl_panelNhanVien1.setVerticalGroup(
                gl_panelNhanVien1.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGroup(gl_panelNhanVien1.createSequentialGroup()
                                .addComponent(lblNhanVien1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelNhanVien1.setLayout(gl_panelNhanVien1);

        panelNhanVien.setBackground(new Color(102, 0, 204));

        panelSelectNhanVien.setBackground(new Color(102, 0, 204));

        lblNhanVien.setForeground(Color.WHITE);
        lblNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
        GroupLayout gl_panelNhanVien = new GroupLayout(panelNhanVien);
        gl_panelNhanVien.setHorizontalGroup(
                gl_panelNhanVien.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 293, Short.MAX_VALUE)
                        .addGroup(gl_panelNhanVien.createSequentialGroup()
                                .addComponent(panelSelectNhanVien, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(lblNhanVien, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_panelNhanVien.setVerticalGroup(
                gl_panelNhanVien.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
                        .addGroup(gl_panelNhanVien.createSequentialGroup()
                                .addGroup(gl_panelNhanVien.createParallelGroup(Alignment.TRAILING, false)
                                        .addComponent(panelSelectNhanVien, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblNhanVien, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                                .addContainerGap())
        );
        panelNhanVien.setLayout(gl_panelNhanVien);

        panelTraHang.setBackground(new Color(102, 51, 153));

        lblTraHang.setForeground(Color.WHITE);
        lblTraHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GroupLayout gl_panelTraHang = new GroupLayout(panelTraHang);
        gl_panelTraHang.setHorizontalGroup(
                gl_panelTraHang.createParallelGroup(Alignment.TRAILING)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGroup(gl_panelTraHang.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addComponent(lblTraHang, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
        );
        gl_panelTraHang.setVerticalGroup(
                gl_panelTraHang.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGroup(gl_panelTraHang.createSequentialGroup()
                                .addComponent(lblTraHang, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTraHang.setLayout(gl_panelTraHang);

        panelBanHangCon.setBackground(new Color(102, 51, 153));

        lblBanHangCon.setForeground(Color.WHITE);
        lblBanHangCon.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GroupLayout gl_panelBanHangCon = new GroupLayout(panelBanHangCon);
        gl_panelBanHangCon.setHorizontalGroup(
                gl_panelBanHangCon.createParallelGroup(Alignment.TRAILING)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGroup(gl_panelBanHangCon.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addComponent(lblBanHangCon, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
        );
        gl_panelBanHangCon.setVerticalGroup(
                gl_panelBanHangCon.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGroup(gl_panelBanHangCon.createSequentialGroup()
                                .addComponent(lblBanHangCon, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBanHangCon.setLayout(gl_panelBanHangCon);

        panelNhapHang.setBackground(new Color(102, 51, 153));

        lblNhapHang.setForeground(Color.WHITE);
        lblNhapHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GroupLayout gl_panelNhapHang = new GroupLayout(panelNhapHang);
        gl_panelNhapHang.setHorizontalGroup(
                gl_panelNhapHang.createParallelGroup(Alignment.TRAILING)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGroup(gl_panelNhapHang.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addComponent(lblNhapHang, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
        );
        gl_panelNhapHang.setVerticalGroup(
                gl_panelNhapHang.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGroup(gl_panelNhapHang.createSequentialGroup()
                                .addComponent(lblNhapHang, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelNhapHang.setLayout(gl_panelNhapHang);

        panelChiTieu.setBackground(new Color(102, 51, 153));

        lblChiTieu.setForeground(Color.WHITE);
        lblChiTieu.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GroupLayout gl_panelChiTieu = new GroupLayout(panelChiTieu);
        gl_panelChiTieu.setHorizontalGroup(
                gl_panelChiTieu.createParallelGroup(Alignment.TRAILING)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGroup(gl_panelChiTieu.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addComponent(lblChiTieu, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
        );
        gl_panelChiTieu.setVerticalGroup(
                gl_panelChiTieu.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGroup(gl_panelChiTieu.createSequentialGroup()
                                .addComponent(lblChiTieu, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelChiTieu.setLayout(gl_panelChiTieu);

        panelGiaoDich.setBackground(new Color(102, 0, 204));

        panelSelectGiaoDich.setBackground(new Color(102, 0, 204));

        lblGiaoDich.setForeground(Color.WHITE);
        lblGiaoDich.setFont(new Font("Tahoma", Font.PLAIN, 15));
        GroupLayout gl_panelGiaoDich = new GroupLayout(panelGiaoDich);
        gl_panelGiaoDich.setHorizontalGroup(
                gl_panelGiaoDich.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 293, Short.MAX_VALUE)
                        .addGroup(gl_panelGiaoDich.createSequentialGroup()
                                .addComponent(panelSelectGiaoDich, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(lblGiaoDich, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_panelGiaoDich.setVerticalGroup(
                gl_panelGiaoDich.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
                        .addGroup(gl_panelGiaoDich.createSequentialGroup()
                                .addGroup(gl_panelGiaoDich.createParallelGroup(Alignment.TRAILING, false)
                                        .addComponent(panelSelectGiaoDich, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblGiaoDich, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                                .addContainerGap())
        );
        panelGiaoDich.setLayout(gl_panelGiaoDich);

        panelBaoBao.setBackground(new Color(102, 51, 153));
        lblBaoCao.setForeground(Color.WHITE);
        lblBaoCao.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GroupLayout gl_panelBaoBao = new GroupLayout(panelBaoBao);
        gl_panelBaoBao.setHorizontalGroup(
                gl_panelBaoBao.createParallelGroup(Alignment.TRAILING)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGroup(gl_panelBaoBao.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addComponent(lblBaoCao, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
        );
        gl_panelBaoBao.setVerticalGroup(
                gl_panelBaoBao.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGroup(gl_panelBaoBao.createSequentialGroup()
                                .addComponent(lblBaoCao, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBaoBao.setLayout(gl_panelBaoBao);

        panelBaoCao1.setBackground(new Color(102, 0, 204));

        panelSelectBaoCao.setBackground(new Color(102, 0, 204));

        lblBaoCaoTo.setForeground(Color.WHITE);
        lblBaoCaoTo.setFont(new Font("Tahoma", Font.PLAIN, 15));
        GroupLayout gl_panelBaoCao1 = new GroupLayout(panelBaoCao1);
        gl_panelBaoCao1.setHorizontalGroup(
                gl_panelBaoCao1.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 293, Short.MAX_VALUE)
                        .addGroup(gl_panelBaoCao1.createSequentialGroup()
                                .addComponent(panelSelectBaoCao, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(lblBaoCaoTo, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_panelBaoCao1.setVerticalGroup(
                gl_panelBaoCao1.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
                        .addGroup(gl_panelBaoCao1.createSequentialGroup()
                                .addGroup(gl_panelBaoCao1.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblBaoCaoTo, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(panelSelectBaoCao, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        panelBaoCao1.setLayout(gl_panelBaoCao1);

        panelNguonHang.setBackground(new Color(102, 51, 153));

        lblNguonHang.setForeground(Color.WHITE);
        lblNguonHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GroupLayout gl_panelNguonHang = new GroupLayout(panelNguonHang);
        gl_panelNguonHang.setHorizontalGroup(
                gl_panelNguonHang.createParallelGroup(Alignment.TRAILING)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGroup(gl_panelNguonHang.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addComponent(lblNguonHang, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
        );
        gl_panelNguonHang.setVerticalGroup(
                gl_panelNguonHang.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGroup(gl_panelNguonHang.createSequentialGroup()
                                .addComponent(lblNguonHang, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelNguonHang.setLayout(gl_panelNguonHang);

        panelHangHoaCon.setBackground(new Color(102, 51, 153));

        lblHangHoaCon.setForeground(Color.WHITE);
        lblHangHoaCon.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GroupLayout gl_panelHangHoaCon = new GroupLayout(panelHangHoaCon);
        gl_panelHangHoaCon.setHorizontalGroup(
                gl_panelHangHoaCon.createParallelGroup(Alignment.TRAILING)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGroup(gl_panelHangHoaCon.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addComponent(lblHangHoaCon, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
        );
        gl_panelHangHoaCon.setVerticalGroup(
                gl_panelHangHoaCon.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGroup(gl_panelHangHoaCon.createSequentialGroup()
                                .addComponent(lblHangHoaCon, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelHangHoaCon.setLayout(gl_panelHangHoaCon);

        panelHangHoa.setBackground(new Color(102, 0, 204));

        panelSelectHangHoa.setBackground(new Color(102, 0, 204));

        lblHangHoa.setForeground(Color.WHITE);
        lblHangHoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
        GroupLayout gl_panelHangHoa = new GroupLayout(panelHangHoa);
        gl_panelHangHoa.setHorizontalGroup(
                gl_panelHangHoa.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 293, Short.MAX_VALUE)
                        .addGroup(gl_panelHangHoa.createSequentialGroup()
                                .addComponent(panelSelectHangHoa, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(lblHangHoa, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_panelHangHoa.setVerticalGroup(
                gl_panelHangHoa.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
                        .addGroup(gl_panelHangHoa.createSequentialGroup()
                                .addGroup(gl_panelHangHoa.createParallelGroup(Alignment.TRAILING, false)
                                        .addComponent(panelSelectHangHoa, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblHangHoa, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                                .addContainerGap())
        );
        panelHangHoa.setLayout(gl_panelHangHoa);

        panelDoanhThu.setBackground(new Color(102, 51, 153));

        lblDoanhThu.setForeground(Color.WHITE);
        lblDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GroupLayout gl_panelDoanhThu = new GroupLayout(panelDoanhThu);
        gl_panelDoanhThu.setHorizontalGroup(
                gl_panelDoanhThu.createParallelGroup(Alignment.TRAILING)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGroup(gl_panelDoanhThu.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addComponent(lblDoanhThu, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
        );
        gl_panelDoanhThu.setVerticalGroup(
                gl_panelDoanhThu.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGroup(gl_panelDoanhThu.createSequentialGroup()
                                .addComponent(lblDoanhThu, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDoanhThu.setLayout(gl_panelDoanhThu);

        panelDoanhso.setBackground(new Color(102, 51, 153));

        lblDoanhSo.setForeground(Color.WHITE);
        lblDoanhSo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GroupLayout gl_panelDoanhso = new GroupLayout(panelDoanhso);
        gl_panelDoanhso.setHorizontalGroup(
                gl_panelDoanhso.createParallelGroup(Alignment.TRAILING)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGroup(gl_panelDoanhso.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addComponent(lblDoanhSo, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
        );
        gl_panelDoanhso.setVerticalGroup(
                gl_panelDoanhso.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGroup(gl_panelDoanhso.createSequentialGroup()
                                .addComponent(lblDoanhSo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDoanhso.setLayout(gl_panelDoanhso);
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(panelKhachHang1, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                                .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
                                                        .addGroup(gl_panel.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(panelCaNhan1, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
                                                                .addGroup(gl_panel.createSequentialGroup()
                                                                        .addContainerGap()
                                                                        .addComponent(panelDangXuat, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                                                        .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                                                                .addGroup(gl_panel.createSequentialGroup()
                                                                                        .addContainerGap()
                                                                                        .addComponent(lblAvatar, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(ComponentPlacement.RELATED)
                                                                                        .addComponent(lblTenUser, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                                                                        .addComponent(lblDanhMuc, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(ComponentPlacement.RELATED))
                                                                                .addComponent(panelThongKe, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
                                                                        .addComponent(panelBanHang, GroupLayout.PREFERRED_SIZE, 293, Short.MAX_VALUE))))
                                                .addComponent(panelCaNhan, GroupLayout.PREFERRED_SIZE, 293, Short.MAX_VALUE)))
                                .addGap(1))
                        .addGroup(gl_panel.createSequentialGroup()
                                .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(panelBangLuong, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(panelKhachHang, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE))
                                .addGap(1))
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap(22, Short.MAX_VALUE)
                                .addComponent(panelChamCong, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelNhanVien1, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_panel.createSequentialGroup()
                                .addComponent(panelNhanVien, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
                                .addGap(1))
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap(22, Short.MAX_VALUE)
                                .addComponent(panelTraHang, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelBanHangCon, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelNhapHang, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelChiTieu, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_panel.createSequentialGroup()
                                .addComponent(panelGiaoDich, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
                                .addGap(1))
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap(22, Short.MAX_VALUE)
                                .addComponent(panelBaoBao, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_panel.createSequentialGroup()
                                .addComponent(panelBaoCao1, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
                                .addGap(1))
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap(22, Short.MAX_VALUE)
                                .addComponent(panelNguonHang, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelHangHoaCon, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap(22, Short.MAX_VALUE)
                                .addComponent(panelDoanhThu, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelDoanhso, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_panel.createSequentialGroup()
                                .addComponent(panelHangHoa, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
                                .addGap(1))
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelSanPham, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
        );
        lblAvatar.setBackground(new Color(75, 0, 130));
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblTenUser, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblAvatar, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblDanhMuc, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                .addGap(50)
                                .addComponent(panelThongKe, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(1)
                                .addComponent(panelDoanhThu, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(1)
                                .addComponent(panelDoanhso, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(3)
                                .addComponent(panelHangHoa, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(1)
                                .addComponent(panelSanPham, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(1)
                                .addComponent(panelHangHoaCon, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(1)
                                .addComponent(panelNguonHang, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(1)
                                .addComponent(panelBaoCao1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(1)
                                .addComponent(panelBaoBao, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(3)
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
        GroupLayout gl_panelSanPham = new GroupLayout(panelSanPham);
        gl_panelSanPham.setHorizontalGroup(
                gl_panelSanPham.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, gl_panelSanPham.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addComponent(lblSanPham, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
        );
        gl_panelSanPham.setVerticalGroup(
                gl_panelSanPham.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panelSanPham.createSequentialGroup()
                                .addComponent(lblSanPham, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSanPham.setLayout(gl_panelSanPham);
        lblDangXuat.setForeground(Color.WHITE);
        lblDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GroupLayout gl_panelDangXuat = new GroupLayout(panelDangXuat);
        gl_panelDangXuat.setHorizontalGroup(
                gl_panelDangXuat.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, gl_panelDangXuat.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addComponent(lblDangXuat, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
        );
        gl_panelDangXuat.setVerticalGroup(
                gl_panelDangXuat.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panelDangXuat.createSequentialGroup()
                                .addComponent(lblDangXuat, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDangXuat.setLayout(gl_panelDangXuat);
        panel.setLayout(gl_panel);

        lblCaNhan1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CaNhanFrame caNhanFrame = new CaNhanFrame();
                caNhanFrame.setLocationRelativeTo(null);
                caNhanFrame.setVisible(true);
            }
        });
        lblAvatar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CaNhanFrame caNhanFrame = new CaNhanFrame();
                caNhanFrame.setLocationRelativeTo(null);
                caNhanFrame.setVisible(true);
            }
        });
        lblTenUser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CaNhanFrame caNhanFrame = new CaNhanFrame();
                caNhanFrame.setLocationRelativeTo(null);
                caNhanFrame.setVisible(true);
            }
        });
        lblBaoCao.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadChild(new BaoCaoSanPhamBanRaTrongNgay());
            }
        });
        lblChamCong.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadChild(new ChamCongJInternalFrame());
            }
        });
        lblTraHang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadChild(new TraHangJInternalFrame());
            }
        });
        lblBanHangCon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadChild(new ThanhToanJInternalFrame());
            }
        });
        lblNhapHang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadChild(new NhapHangJInternalFrame());
            }
        });
        lblHangHoaCon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadChild(new HangHoaJInternalFrame());
            }
        });
        lblDangXuat.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                logout();
            }
        });
        lblKhachHang1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadChild(new KhachHangJInternalFrame());
            }
        });

        lblDanhMuc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panel.setVisible(false);
                contentPane.add(panelLeft, BorderLayout.WEST);
                panelLeft.setVisible(true);
            }
        });
        lblHangHoaCon.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\hanghoa.png", 20, 20)));
        lblNguonHang.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\nguonhang.png", 20, 20)));
        lblBaoCao.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\baocao.png", 20, 20)));
        lblNhapHang.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\nhaphang.png", 20, 20)));
        lblBanHangCon.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\banhang.png", 20, 20)));
        lblChiTieu.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\chitieu.png", 20, 20)));
        lblNhanVien1.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\nhanvien.png", 20, 20)));
        lblGiaoDich.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\giaodich.png", 20, 20)));
        lblHangHoa.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\hanghoa.png", 20, 20)));
        lblDoanhSo.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\doanhso.png", 20, 20)));
        lblDoanhThu.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\doanhthu.png", 20, 20)));
        lblBangLuong.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\bangluong.png", 20, 20)));
        lblChamCong.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\chamcong.png", 20, 20)));
        lblSanPham.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\sanpham.png", 20, 20)));
        pnlMain.setBackground(new Color(51, 0, 153));
        contentPane.add(pnlMain, BorderLayout.CENTER);
        lblCaNhan.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\canhan.png", 20, 20)));
        lblNhanVien.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\nhanvien.png", 20, 20)));
        lblKhachHang.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\khachhang.png", 20, 20)));
        lblThongKe.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\thongke.png", 20, 20)));
        lblDanhMuc.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\danhmuc.png", 20, 20)));
        lblCaNhan1.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\canhan.png", 20, 20)));
        lblDangXuat.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\logout1.png", 20, 20)));
        lblKhachHang1.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\khachhang.png", 20, 20)));
        lblBaoCaoTo.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\baocao.png", 20, 20)));
        lblBanHang.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\banhang.png", 20, 20)));
        lblTraHang.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\trahang.png", 20, 20)));

        panelCaNhan1.setVisible(false);
        panelDangXuat.setVisible(false);
        panelKhachHang1.setVisible(false);

        listToolBar.add(new Toolbar(panelSelectThongKe, panelThongKe, lblThongKe));
        listToolBar.add(new Toolbar(panelSelectHangHoa, panelHangHoa, lblHangHoa));
        listToolBar.add(new Toolbar(panelSelectBaoCao, panelBaoCao1, lblBaoCaoTo));
        listToolBar.add(new Toolbar(panelSelectGiaoDich, panelGiaoDich, lblGiaoDich));
        listToolBar.add(new Toolbar(panelSelectNhanVien, panelNhanVien, lblNhanVien));
        listToolBar.add(new Toolbar(panelSelectKhachHang, panelKhachHang, lblKhachHang));
        listToolBar.add(new Toolbar(panelSelectCaNhan, panelCaNhan, lblCaNhan));
        listToolBar.add(new Toolbar(panelSelectBanHang, panelBanHang, lblBanHang));
        pnlMain.setLayout(new CardLayout(0, 0));
        JLabel back = new JLabel("");
        ImageIcon imageIcon = new ImageIcon("images\\bkg.jpg");
        Image image = EntityImage.resize(imageIcon.getImage(), uiCommon.width, uiCommon.height);
        back.setIcon(new ImageIcon(image));
        pnlMain.add(back);

        closeAllPanel();
        addMouseEnter();
        initPanelLeft();

        phanQuyen();
    }

    public void initPanelLeft() {
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        panelLeft.setBackground(new Color(75, 0, 130));

        JLabel lbl25 = new JLabel(" ");
        panelLeft.add(lbl25);
        JButton lblDanhMucOpen = new JButton("");
        lblDanhMucOpen.setContentAreaFilled(false);
        lblDanhMucOpen.setBorder(new LineBorder(new Color(75, 0, 130), 10));
        panelLeft.add(lblDanhMucOpen);

        JButton lblThongKel = new JButton("");
        lblThongKel.setContentAreaFilled(false);
        lblThongKel.setBorder(new LineBorder(new Color(75, 0, 130), 10));
        panelLeft.add(lblThongKel);

        JButton lblHangHoal = new JButton("");
        lblHangHoal.setContentAreaFilled(false);
        lblHangHoal.setBorder(new LineBorder(new Color(75, 0, 130), 10));
        panelLeft.add(lblHangHoal);

        JButton lblBaoCaol = new JButton("");
        lblBaoCaol.setContentAreaFilled(false);
        lblBaoCaol.setBorder(new LineBorder(new Color(75, 0, 130), 10));
        panelLeft.add(lblBaoCaol);

        JButton lblGiaoDichl = new JButton("");
        lblGiaoDichl.setContentAreaFilled(false);
        lblGiaoDichl.setBorder(new LineBorder(new Color(75, 0, 130), 10));
        panelLeft.add(lblGiaoDichl);

        JButton lblNhanVienl = new JButton("");
        lblNhanVienl.setContentAreaFilled(false);
        lblNhanVienl.setBorder(new LineBorder(new Color(75, 0, 130), 10));
        panelLeft.add(lblNhanVienl);

        JButton lblKhachHangl = new JButton("");
        lblKhachHangl.setContentAreaFilled(false);
        lblKhachHangl.setBorder(new LineBorder(new Color(75, 0, 130), 10));
        panelLeft.add(lblKhachHangl);

        JButton lblCaNhanl = new JButton("");
        lblCaNhanl.setContentAreaFilled(false);
        lblCaNhanl.setBorder(new LineBorder(new Color(75, 0, 130), 10));
        panelLeft.add(lblCaNhanl);

        JButton lblBanHangl = new JButton("");
        lblBanHangl.setContentAreaFilled(false);
        lblBanHangl.setBorder(new LineBorder(new Color(75, 0, 130), 10));
        panelLeft.add(lblBanHangl);

        lblDanhMucOpen.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\danhmuc.png", 20, 20)));
        lblThongKel.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\thongke.png", 20, 20)));
        lblHangHoal.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\hanghoa.png", 20, 20)));
        lblBaoCaol.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\baocao.png", 20, 20)));
        lblGiaoDichl.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\giaodich.png", 20, 20)));
        lblNhanVienl.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\nhanvien.png", 20, 20)));
        lblKhachHangl.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\khachhang.png", 20, 20)));
        lblCaNhanl.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\canhan.png", 20, 20)));
        lblBanHangl.setIcon(new ImageIcon(EntityImage.resizeTheoUrl("images\\banhang.png", 20, 20)));

        lblDanhMucOpen.addMouseListener(openDanhMuc);
        lblThongKel.addMouseListener(openDanhMuc);
        lblBanHangl.addMouseListener(openDanhMuc);
        lblBaoCaol.addMouseListener(openDanhMuc);
        lblCaNhanl.addMouseListener(openDanhMuc);
        lblGiaoDichl.addMouseListener(openDanhMuc);
        lblHangHoal.addMouseListener(openDanhMuc);
        lblKhachHangl.addMouseListener(openDanhMuc);
        lblNhanVienl.addMouseListener(openDanhMuc);
        
    }

    MouseListener openDanhMuc = new MouseListener() {
        public void mouseReleased(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
            panelLeft.setVisible(false);
            contentPane.add(panel, BorderLayout.WEST);
            panel.setVisible(true);
        }

        public void mouseClicked(MouseEvent e) {
        }
    };

    public void addMouseEnter() {
        lblBaoCaoTo.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                resetColor();
                panelSelectBaoCao.setBackground(Color.BLACK);
                panelBaoCao1.setBackground(new Color(153, 51, 255));
            }

            public void mouseClicked(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
                resetColor();
            }
        });
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
                    closeAllPanel();
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
                select = 7;
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
                select = 6;
                if (openCaNhan == 0) {
                    openCaNhan = 1;
                    closeAllPanel();
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

        lblBanHang.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Runtime runtime = Runtime.getRuntime();
                String url = "http://polymart.tk/";
                try {
                    runtime.exec("rundll32 url.dll, FileProtocolHandler " + url);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
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
                    closeAllPanel();
                    panelSanPham.setVisible(true);
                    panelHangHoaCon.setVisible(true);
                    panelNguonHang.setVisible(true);
                } else {
                    openHangHoa = 0;
                    panelHangHoaCon.setVisible(false);
                    panelNguonHang.setVisible(false);
                    panelSanPham.setVisible(false);
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
                select = 5;
                if (openKhachHang == 0) {
                    openKhachHang = 1;
                    closeAllPanel();
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
                select = 4;
                if (openNhanVien == 0) {
                    openNhanVien = 1;
                    closeAllPanel();
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

    public void closeAllPanel() {
        panelDoanhso.setVisible(false);
        panelDoanhThu.setVisible(false);
        panelHangHoaCon.setVisible(false);
        panelNguonHang.setVisible(false);
        panelNhapHang.setVisible(false);
        panelBanHangCon.setVisible(false);
        panelTraHang.setVisible(false);
        panelChiTieu.setVisible(false);
        panelNhanVien1.setVisible(false);
        panelChamCong.setVisible(false);
        panelBangLuong.setVisible(false);
        panelKhachHang1.setVisible(false);
        panelCaNhan1.setVisible(false);
        panelDangXuat.setVisible(false);
        panelBaoBao.setVisible(false);
        panelSanPham.setVisible(false);
    }
    
    private void quyenQuanLy() {
        lblSanPham.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadChild(new SanPhamJInternalFrame());
            }
        });
        lblNguonHang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadChild(new NguonHangJInternalFrame());
            }
        });
        lblGiaoDich.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                resetColor();
                panelSelectGiaoDich.setBackground(Color.BLACK);
                panelGiaoDich.setBackground(new Color(153, 51, 255));
            }

            public void mouseClicked(MouseEvent e) {
                select = 3;
                if (openGiaoDich == 0) {
                    openGiaoDich = 1;
                    closeAllPanel();
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
        lblDoanhSo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadChild(new ThongKeDoanhSoJInternalFrame());
            }
        });
        lblDoanhThu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadChild(new ThongKeDoanhThuJInternalFrame());
            }
        });
        lblChiTieu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                loadChild(new BaoCaoChiTieuJInternalFrame());
            }
        });
        lblBaoCaoTo.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {}
            public void mouseClicked(MouseEvent e) {
                select = 2;
                if (openBaoCao == 0) {
                    openBaoCao = 1;
                    closeAllPanel();
                    panelBaoBao.setVisible(true);
                } else {
                    openBaoCao = 0;
                    panelBaoBao.setVisible(false);
                }
                resetColor();
            }
            public void mouseExited(MouseEvent e) {}
        });
        lblNhanVien1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                loadChild(new NhanVienJInternalFrame());
            }
        });
        lblBangLuong.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                loadChild(new BangLuongJIternalFrame());
            }
        });
    }
    private void quyenThuNgan() {
        lblSanPham.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadChild(new SanPhamJInternalFrame());
            }
        });
        lblNguonHang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadChild(new NguonHangJInternalFrame());
            }
        });
        lblGiaoDich.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                resetColor();
                panelSelectGiaoDich.setBackground(Color.BLACK);
                panelGiaoDich.setBackground(new Color(153, 51, 255));
            }

            public void mouseClicked(MouseEvent e) {
                select = 3;
                if (openGiaoDich == 0) {
                    openGiaoDich = 1;
                    closeAllPanel();
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
        lblDoanhSo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadChild(new ThongKeDoanhSoJInternalFrame());
            }
        });
        lblDoanhThu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadChild(new ThongKeDoanhThuJInternalFrame());
            }
        });
        lblChiTieu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                loadChild(new BaoCaoChiTieuJInternalFrame());
            }
        });
        lblBaoCaoTo.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {}
            public void mouseClicked(MouseEvent e) {
                select = 2;
                if (openBaoCao == 0) {
                    openBaoCao = 1;
                    closeAllPanel();
                    panelBaoBao.setVisible(true);
                } else {
                    openBaoCao = 0;
                    panelBaoBao.setVisible(false);
                }
                resetColor();
            }
            public void mouseExited(MouseEvent e) {}
        });
        lblNhanVien1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	EntityMessage.showWarring();
            }
        });
        lblBangLuong.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	EntityMessage.showWarring();
            }
        });
    }
    private void quyenNhanVien() {
        lblSanPham.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	EntityMessage.showWarring();
            }
        });
        lblNguonHang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	EntityMessage.showWarring();
            }
        });
        lblGiaoDich.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                resetColor();
                panelSelectGiaoDich.setBackground(Color.BLACK);
                panelGiaoDich.setBackground(new Color(153, 51, 255));
            }

            public void mouseClicked(MouseEvent e) {
            	EntityMessage.showWarring();
            }

            public void mouseExited(MouseEvent e) {
                resetColor();
            }
        });
        lblDoanhSo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadChild(new ThongKeDoanhSoJInternalFrame());
            }
        });
        lblDoanhThu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	EntityMessage.showWarring();
            }
        });
        lblChiTieu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                EntityMessage.showWarring();
            }
        });
        lblBaoCaoTo.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {}
            public void mouseClicked(MouseEvent e) {
            	EntityMessage.showWarring();
            }
            public void mouseExited(MouseEvent e) {}
        });
        lblNhanVien1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	EntityMessage.showWarring();
            }
        });
        lblBangLuong.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	EntityMessage.showWarring();
            }
        });
    }
    

}
