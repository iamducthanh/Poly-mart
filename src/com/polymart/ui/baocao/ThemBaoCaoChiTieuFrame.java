package com.polymart.ui.baocao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.polymart.dao.impl.ChiTieuDao;
import com.polymart.entity.EntityAuthorization;
import com.polymart.entity.EntityFrame;
import com.polymart.entity.EntityMessage;
import com.polymart.entity.EntityValidate;
import com.polymart.model.ChiTieuModel;
import com.polymart.ui.common.uiCommon;

import java.awt.Color;

public class ThemBaoCaoChiTieuFrame extends JFrame {

    private static final long serialVersionUID = -8420199500518475018L;

    private JPanel contentPane;
    private JTextField txtMaNV;
    private JTextField txtSoTien;
    JTextArea txtMucDichCT = new JTextArea();
    JTextArea txtGhiChu = new JTextArea();
    private BaoCaoChiTieuJInternalFrame baoCao;

    public ThemBaoCaoChiTieuFrame() throws HeadlessException {
        getContentPane().setBackground(Color.WHITE);

    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    EntityFrame.themBaoCaoChiTieu.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ThemBaoCaoChiTieuFrame(BaoCaoChiTieuJInternalFrame baoCao) throws HeadlessException {
        this.baoCao = baoCao;
        setIconImage(Toolkit.getDefaultToolkit().getImage("images\\fpt.png"));
        setTitle("Thêm báo cáo chi tiêu");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 505, 539);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Mã nhân viên: ", JLabel.RIGHT);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(10, 30, 128, 25);
        contentPane.add(lblNewLabel);

        txtMaNV = new JTextField();
        txtMaNV.setEditable(false);
        txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtMaNV.setBounds(174, 30, 216, 25);
        contentPane.add(txtMaNV);
        txtMaNV.setColumns(10);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(174, 127, 284, 93);
        contentPane.add(scrollPane);

        scrollPane.setViewportView(txtMucDichCT);
        txtMucDichCT.setFont(new Font("Monospaced", Font.PLAIN, 15));

        txtSoTien = new JTextField();
        txtSoTien.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtSoTien.setColumns(10);
        txtSoTien.setBounds(174, 239, 216, 25);
        contentPane.add(txtSoTien);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(174, 287, 284, 105);
        contentPane.add(scrollPane_1);


        scrollPane_1.setViewportView(txtGhiChu);
        txtGhiChu.setFont(new Font("Monospaced", Font.PLAIN, 15));

        JLabel lblMcchChi = new JLabel("Mục đích chi tiêu: ", SwingConstants.RIGHT);
        lblMcchChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblMcchChi.setBounds(10, 127, 128, 25);
        contentPane.add(lblMcchChi);

        JLabel lblSTin = new JLabel("Số tiền: ", SwingConstants.RIGHT);
        lblSTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblSTin.setBounds(10, 239, 128, 25);
        contentPane.add(lblSTin);

        JLabel lblGhiCh = new JLabel("Ghi chú: ", SwingConstants.RIGHT);
        lblGhiCh.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblGhiCh.setBounds(10, 287, 128, 25);
        contentPane.add(lblGhiCh);

        JButton btnLuu = new JButton("Lưu");
        btnLuu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                luuPhieuChiTieu();
            }
        });
        btnLuu.setBounds(369, 468, 89, 23);
        contentPane.add(btnLuu);
        loadMaNhanVien();

        uiCommon.editButtonCenter(btnLuu);

        
    }


    protected void luuPhieuChiTieu() {
        if (txtMucDichCT.getText().isBlank()) {
            EntityMessage.show(null, "Mục Đích Chi tiêu Không Được Để Trống");
            return;
        }
        if (!EntityValidate.checkMoney(null, txtSoTien.getText())) {
            return;
        }
        ChiTieuModel chiTieu = new ChiTieuModel();
        chiTieu.setMucDichChiTieu(txtMucDichCT.getText());
        chiTieu.setSoTien(Long.parseLong(txtSoTien.getText()));
        chiTieu.setIdNhanVien(Integer.parseInt(txtMaNV.getText()));
        chiTieu.setGhiChu(txtGhiChu.getText());
        ChiTieuDao chiTieuDao = new ChiTieuDao();
        if (EntityMessage.confirm(null, "Việc Lưu Liên Quan Đến Tiền! Bạn Có Chắc Muốn Lưu Phiếu Không?")) {
            chiTieuDao.save(chiTieu);
            EntityMessage.show(null, "Lưu Thành Công");
            baoCao.loadList();
            baoCao.fillTable();
        }
        this.dispose();
    }

    public void loadMaNhanVien() {
        txtMaNV.setText(String.valueOf(EntityAuthorization.USER.getId()));
    }
}
