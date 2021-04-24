package com.polymart.ui.hanghoa;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.polymart.config.SecurityConfig;
import com.polymart.entity.EntityAuthorization;
import com.polymart.entity.EntityMessage;
import com.polymart.entity.EntityValidate;
import com.polymart.model.AnhSanPhamModel;
import com.polymart.model.ChiTietSanPhamModel;
import com.polymart.model.SanPhamModel;
import com.polymart.service.IAnhSanPhamService;
import com.polymart.service.IChiTietSanPhamService;
import com.polymart.service.ILoaiSanPhamService;
import com.polymart.service.ISanPhamService;
import com.polymart.service.impl.AnhSanPhamService;
import com.polymart.service.impl.ChiTietSanPhamService;
import com.polymart.service.impl.LoaiSanPhamService;
import com.polymart.service.impl.SanPhamService;
import com.polymart.ui.common.uiCommon;

public class ChiTietSanPhamFrame extends JFrame {

    private static final long serialVersionUID = -183259936805942123L;

    private JPanel contentPane;
    private JTextField txtMaSP;
    private JTextField txtTenSP;
    private JTextField txtGiaBan;
    private JTextField txtLoai;
    private JTextField txtGiaVon;
    private JTextField txtSoLuong;
    private JTextField txtGiaGiam;
    private JTextField txtMauSac;
    private JTextField txtSize;

    private ChiTietSanPhamModel chiTietSanPhamModel;
    private SanPhamModel sanPhamModel;
    private List<AnhSanPhamModel> lstAnhSanPhamModel;
    private ISanPhamService sanPhamService = new SanPhamService();
    private ILoaiSanPhamService loaiSanPhamService = new LoaiSanPhamService();
    private IAnhSanPhamService anhSanPhamService = new AnhSanPhamService();
    private IChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamService();
    private ImageIcon imageIcon;
    private Image image;
    private Image newimg;

    private HangHoaJInternalFrame hangHoaJInternalFrame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    ChiTietSanPhamFrame frame = new ChiTietSanPhamFrame();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
    }

    /**
     * Create the frame.
     */
    // vãi :)
    public ChiTietSanPhamFrame(ChiTietSanPhamModel chiTietSanPhamModel, HangHoaJInternalFrame hangHoaJInternalFrame) {
        this.hangHoaJInternalFrame = hangHoaJInternalFrame;
        this.chiTietSanPhamModel = chiTietSanPhamModel;
        this.sanPhamModel = sanPhamService.findByID(chiTietSanPhamModel.getIdSanPham());
        this.lstAnhSanPhamModel = anhSanPhamService.getByIdCtsp(chiTietSanPhamModel.getId());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(this);
        setIconImage(Toolkit.getDefaultToolkit().getImage("images\\fpt.png"));
        setTitle("Chi tiết sản phẩm");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 799, 565);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(new TitledBorder(null, "Chi ti\u1EBFt s\u1EA3n ph\u1EA9m", TitledBorder.LEADING,
                TitledBorder.TOP, null, Color.BLACK));
        panel.setBounds(10, 11, 765, 470);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Mã sản phẩm:", JLabel.RIGHT);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(10, 32, 124, 25);
        panel.add(lblNewLabel);

        txtMaSP = new JTextField();
        txtMaSP.setBackground(Color.WHITE);
        txtMaSP.setEditable(false);
        txtMaSP.setBounds(174, 34, 152, 25);
        panel.add(txtMaSP);
        txtMaSP.setColumns(10);

        txtTenSP = new JTextField();
        txtTenSP.setBackground(Color.WHITE);
        txtTenSP.setEditable(false);
        txtTenSP.setColumns(10);
        txtTenSP.setBounds(174, 74, 240, 25);
        panel.add(txtTenSP);

        txtGiaBan = new JTextField();
        txtGiaBan.setBackground(Color.WHITE);
        txtGiaBan.setColumns(10);
        txtGiaBan.setBounds(174, 194, 152, 25);
        panel.add(txtGiaBan);

        txtLoai = new JTextField();
        txtLoai.setBackground(Color.WHITE);
        txtLoai.setEditable(false);
        txtLoai.setColumns(10);
        txtLoai.setBounds(174, 114, 240, 25);
        panel.add(txtLoai);

        txtGiaVon = new JTextField();
        txtGiaVon.setBackground(Color.WHITE);
        txtGiaVon.setEditable(false);
        txtGiaVon.setColumns(10);
        txtGiaVon.setBounds(174, 234, 152, 25);
        panel.add(txtGiaVon);

        txtSoLuong = new JTextField();
        txtSoLuong.setBackground(Color.WHITE);
        txtSoLuong.setEditable(false);
        txtSoLuong.setColumns(10);
        txtSoLuong.setBounds(174, 154, 152, 25);
        panel.add(txtSoLuong);

        txtGiaGiam = new JTextField();
        txtGiaGiam.setBackground(Color.WHITE);
        txtGiaGiam.setColumns(10);
        txtGiaGiam.setBounds(174, 274, 152, 25);
        panel.add(txtGiaGiam);

        txtMauSac = new JTextField();
        txtMauSac.setBackground(Color.WHITE);
        txtMauSac.setEditable(false);
        txtMauSac.setColumns(10);
        txtMauSac.setBounds(174, 354, 152, 25);
        panel.add(txtMauSac);

        txtSize = new JTextField();
        txtSize.setBackground(Color.WHITE);
        txtSize.setEditable(false);
        txtSize.setColumns(2);
        txtSize.setBounds(174, 314, 152, 25);
        panel.add(txtSize);

        JLabel lblTnSnPhm = new JLabel("Tên sản phẩm:", SwingConstants.RIGHT);
        lblTnSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTnSnPhm.setBounds(10, 74, 124, 25);
        panel.add(lblTnSnPhm);

        JLabel lblLoi = new JLabel("Loại:", SwingConstants.RIGHT);
        lblLoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblLoi.setBounds(10, 114, 124, 25);
        panel.add(lblLoi);

        JLabel lblSLng = new JLabel("Số lượng:", SwingConstants.RIGHT);
        lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblSLng.setBounds(10, 154, 124, 25);
        panel.add(lblSLng);

        JLabel lblGiBn = new JLabel("Giá bán:", SwingConstants.RIGHT);
        lblGiBn.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblGiBn.setBounds(10, 194, 124, 25);
        panel.add(lblGiBn);

        JLabel lblGiVn = new JLabel("Giá vốn:", SwingConstants.RIGHT);
        lblGiVn.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblGiVn.setBounds(10, 234, 124, 25);
        panel.add(lblGiVn);

        JLabel lblGiGim = new JLabel("Giá giảm:", SwingConstants.RIGHT);
        lblGiGim.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblGiGim.setBounds(10, 274, 124, 25);
        panel.add(lblGiGim);

        JLabel lblSize = new JLabel("Size:", SwingConstants.RIGHT);
        lblSize.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblSize.setBounds(10, 314, 124, 25);
        panel.add(lblSize);

        JLabel lblMuSc = new JLabel("Màu sắc:", SwingConstants.RIGHT);
        lblMuSc.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblMuSc.setBounds(10, 354, 124, 25);
        panel.add(lblMuSc);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.WHITE);
        panel_1.setBorder(
                new TitledBorder(null, "H\u00ECnh \u1EA3nh", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setBounds(424, 11, 327, 448);
        panel.add(panel_1);
        panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel[] arrImage = new JLabel[4];
        for (int i = 0; i < arrImage.length; i++) {
            arrImage[i] = new JLabel("");
            imageIcon = new ImageIcon("images\\imgThemAnh.jpg"); // load the image to a imageIcon
            image = imageIcon.getImage(); // transform it
            newimg = image.getScaledInstance(143, 200, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            imageIcon = new ImageIcon(newimg);  // transform it back
            arrImage[i].setIcon(imageIcon);
            panel_1.add(arrImage[i]);
        }

        JButton btnSua = new JButton("Sửa");
        btnSua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtGiaBan.setEditable(true);
                txtGiaGiam.setEditable(true);
                txtGiaVon.setEditable(true);
                txtLoai.setEditable(true);
                txtMaSP.setEditable(true);
                txtSoLuong.setEditable(true);
                txtTenSP.setEditable(true);
                txtMauSac.setEditable(true);
            }
        });
        btnSua.setBounds(471, 492, 89, 25);
        contentPane.add(btnSua);

        txtMaSP.setText(chiTietSanPhamModel.getId().toString());
        txtTenSP.setText(sanPhamModel.getTenSP());
        txtLoai.setText(loaiSanPhamService.findNameById(sanPhamModel.getIdLoaiSP()));
        txtSoLuong.setText(chiTietSanPhamModel.getSoLuong().toString());
        txtGiaBan.setText(chiTietSanPhamModel.getGiaBan().toString());
        txtGiaVon.setText(chiTietSanPhamModel.getGiaVon().toString());
        txtGiaGiam.setText(chiTietSanPhamModel.getGiaGiam().toString());
        txtSize.setText(chiTietSanPhamModel.getSize());
        txtMauSac.setText(chiTietSanPhamModel.getMauSac());

        for (int i = 0; i < lstAnhSanPhamModel.size() && i < arrImage.length; i++) {
            imageIcon = new ImageIcon("images\\anh-san-pham\\" + lstAnhSanPhamModel.get(i).getTenAnh()); // load the image to a imageIcon
            image = imageIcon.getImage(); // transform it
            newimg = image.getScaledInstance(143, 200, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            imageIcon = new ImageIcon(newimg);  // transform it back
            arrImage[i].setIcon(imageIcon);
        }

        // evt nút "Sửa"
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePrice(txtGiaBan, txtGiaGiam);
            }
        });

        uiCommon.editButtonCenter(btnSua);

        setChucVu(btnSua);
    }

    private void setChucVu(JButton btnSua) {
        if (EntityAuthorization.USER.getChucVu().equals(SecurityConfig.VAITRO_QUANLY)) {
            return;
        }
        btnSua.setVisible(false);
        if (EntityAuthorization.USER.getChucVu().equals(SecurityConfig.VAITRO_THUNGAN)) {
            btnSua.setVisible(true);
        }
    }

    // evt thay đổi giá bán
    private void updatePrice(JTextField txtGiaBan, JTextField txtGiaGiam) {
        String getGiaBan = txtGiaBan.getText();
        String getGiaGiam = txtGiaGiam.getText();
        if (EntityValidate.checkMoney(this, getGiaBan) && EntityValidate.checkMoney(this, getGiaGiam)) {
            if (!Long.valueOf(getGiaBan).equals(chiTietSanPhamModel.getGiaBan())
                    || !Long.valueOf(getGiaGiam).equals(chiTietSanPhamModel.getGiaGiam())) {
                if (chiTietSanPhamService.updatePrice(chiTietSanPhamModel.getId(), Long.valueOf(getGiaBan), Long.valueOf(getGiaGiam))) {
                    EntityMessage.show(this, "Sửa thành công");
                    chiTietSanPhamService.reloadData();
                    this.setVisible(false);
                    hangHoaJInternalFrame.showTable(hangHoaJInternalFrame.getList());
                } else {
                    EntityMessage.show(this, "Sửa sản phẩm thất bại");
                }
            } else {
                EntityMessage.show(this, "Chưa có thay đổi gì");
            }
        }
    }
}
