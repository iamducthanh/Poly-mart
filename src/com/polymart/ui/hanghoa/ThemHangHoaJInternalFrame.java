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
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.polymart.entity.*;
import com.polymart.model.*;
import com.polymart.service.IAnhSanPhamService;
import com.polymart.service.IChiTietSanPhamService;
import com.polymart.service.ILoaiSanPhamService;
import com.polymart.service.ISanPhamService;
import com.polymart.service.impl.AnhSanPhamService;
import com.polymart.service.impl.ChiTietSanPhamService;
import com.polymart.service.impl.LoaiSanPhamService;
import com.polymart.service.impl.SanPhamService;
import com.polymart.ui.common.uiCommon;

public class ThemHangHoaJInternalFrame extends JInternalFrame {

    private static final long serialVersionUID = -2914525596895096982L;

    private JPanel contentPane;
    private JComboBox<Object> cbcTenSanPham;
    private JComboBox<Object> cbcLoaiSanPham;
    private JTextField txtGiaBan;
    private JTextField txtMauSac;
    private JTextField txtSize;
    private JTextField txtSize_1;
    private JButton btnTaoHinhMoi;
    private JButton btnImportExcel;
    private JPanel panelImage = new JPanel();

    // list hình ảnh
    private List<LabelImageModel> listLabelImg = new ArrayList<LabelImageModel>();

    // list này để lúc lưu sẽ get link ra để lưu
    private JLabel[] arrImage = new JLabel[4];
    // nó éo reload lại form cho nên phải tạo sẵn, lúc lấy ảnh cứ load list lấy link
    // để lưu

    private JTable tableDSSanPhamThem;
    private DefaultTableModel modelDSSanPhamThem;

    // gọi service
    private ISanPhamService sanPhamService = new SanPhamService();
    private ILoaiSanPhamService loaiSanPhamService = new LoaiSanPhamService();
    private IChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamService();
    private IAnhSanPhamService anhSanPhamService = new AnhSanPhamService();

    // tạo list model
    private List<SanPhamModel> lstSanPhamModels;
    private List<LoaiSanPhamModel> lstLoaiSanPham = loaiSanPhamService.findAll();
    private List<ChiTietSanPhamModel> lstChiTietSanPhamThemMoi = new ArrayList<>();

    // list lưu lại hình ảnh tương ứng của sản phẩm
    private List<UpdatePhotoProduct> lstUpdatePhotoProduct = new ArrayList<>();
    private UpdatePhotoProduct updatePhotoProduct;
    private List<String> lstNameFiles = new ArrayList<>();
    private List<File> lstDstFiles = new ArrayList<>();
    private List<Path> lstPathFiles = new ArrayList<>();
    private Path pathForm;
    private File dstFile;
    private String nameFile;

    // tạo model    ;
    private LoaiSanPhamModel loaiSanPhamModel;
    private SanPhamModel sanPhamModel;
    private ChiTietSanPhamModel chiTietSanPhamModel;

    private HangHoaJInternalFrame hangHoaJInternalFrame;

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
        init();
    }

    public ThemHangHoaJInternalFrame(HangHoaJInternalFrame hangHoaJInternalFrame) {
        this.hangHoaJInternalFrame = hangHoaJInternalFrame;
        init();
    }

    private void init() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1920, 639);
        modelDSSanPhamThem = new DefaultTableModel() {

            private static final long serialVersionUID = 1171051584049337518L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        setFocusable(true);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(75, 0, 130));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(75, 0, 130));
        contentPane.add(panel_1, BorderLayout.NORTH);

        JButton btnQuayLai = new JButton("");
        btnQuayLai.setIcon(new ImageIcon("images\\back-61.png"));
        btnQuayLai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });
        btnQuayLai.setContentAreaFilled(false);
        btnQuayLai.setBorder(null);
        btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 17));

        JLabel lblNewLabel = new JLabel("  Thêm sản phẩm");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(5)
                                .addComponent(btnQuayLai)
                                .addGap(5)
                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                                .addGap(1011))
        );
        gl_panel_1.setVerticalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(7)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnQuayLai, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(7, Short.MAX_VALUE))
        );
        panel_1.setLayout(gl_panel_1);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        contentPane.add(panel, BorderLayout.CENTER);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.WHITE);
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
        btnHoanThanh.setFont(new Font("Tahoma", Font.PLAIN, 10));

        JButton btnXoa = new JButton("Xoá");

        btnImportExcel = new JButton("Import");
        uiCommon.editButtonCenter(btnImportExcel);
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
                                        .addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnImportExcel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
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
                                        .addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addComponent(btnImportExcel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                                                .addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(btnHoanThanh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
        );
        panel_3.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        panel_3.add(scrollPane, BorderLayout.CENTER);

        tableDSSanPhamThem = new JTable();
        tableDSSanPhamThem.setBackground(Color.WHITE);
        scrollPane.setViewportView(tableDSSanPhamThem);

        JLabel lblTenSanPham = new JLabel("Tên sản phẩm: ", JLabel.RIGHT);
        lblTenSanPham.setFont(new Font("Tahoma", Font.PLAIN, 14));

        cbcTenSanPham = new JComboBox<>();

        cbcLoaiSanPham = new JComboBox<>();

        txtGiaBan = new JTextField();
        txtGiaBan.setColumns(10);

        txtMauSac = new JTextField();
        txtMauSac.setColumns(10);

        txtSize = new JTextField();
        txtSize.setColumns(10);

        txtSize_1 = new JTextField();
        txtSize_1.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JLabel lblLoai = new JLabel("Loại: ", JLabel.RIGHT);
        lblLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));

        JLabel lblGiaBan = new JLabel("Giá bán: ", JLabel.RIGHT);
        lblGiaBan.setFont(new Font("Tahoma", Font.PLAIN, 14));

        JLabel lblSize = new JLabel("Size: ", JLabel.RIGHT);
        lblSize.setFont(new Font("Tahoma", Font.PLAIN, 14));

        JLabel lblMauSac = new JLabel("Màu sắc: ", JLabel.RIGHT);
        lblMauSac.setFont(new Font("Tahoma", Font.PLAIN, 14));

        btnTaoHinhMoi = new JButton("Tạo mới hình");
        uiCommon.editButtonCenter(btnTaoHinhMoi);
        panelImage.setBackground(Color.WHITE);

        panelImage.setBorder(
                new TitledBorder(null, "  H\u00ECnh \u1EA3nh  ", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        GroupLayout gl_panel_2 = new GroupLayout(panel_2);
        gl_panel_2.setHorizontalGroup(
        	gl_panel_2.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_2.createSequentialGroup()
        			.addGap(23)
        			.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblLoai, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblGiaBan, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblSize, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblMauSac, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblTenSanPham, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
        			.addGap(40)
        			.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(txtMauSac, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
        				.addComponent(txtGiaBan, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
        				.addComponent(cbcLoaiSanPham, Alignment.LEADING, 0, 228, Short.MAX_VALUE)
        				.addComponent(cbcTenSanPham, Alignment.LEADING, 0, 228, Short.MAX_VALUE)
        				.addComponent(txtSize_1, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
        			.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
        				.addComponent(panelImage, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 665, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnTaoHinhMoi, Alignment.TRAILING))
        			.addContainerGap())
        );
        gl_panel_2.setVerticalGroup(
        	gl_panel_2.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_2.createSequentialGroup()
        			.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblTenSanPham, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        						.addComponent(cbcTenSanPham, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_panel_2.createSequentialGroup()
        							.addComponent(cbcLoaiSanPham, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(txtGiaBan, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        							.addGap(50)
        							.addComponent(txtSize_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        							.addGap(17)
        							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
        								.addComponent(txtMauSac, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        								.addComponent(lblMauSac, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
        						.addGroup(gl_panel_2.createSequentialGroup()
        							.addComponent(lblLoai, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(lblGiaBan, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        							.addGap(50)
        							.addComponent(lblSize, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))))
        				.addComponent(panelImage, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnTaoHinhMoi, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        			.addGap(12))
        );
        panelImage.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        modelDSSanPhamThem.addColumn("Tên sản phẩm");
        modelDSSanPhamThem.addColumn("Loại");
        modelDSSanPhamThem.addColumn("Giá bán");
        modelDSSanPhamThem.addColumn("Size");
        modelDSSanPhamThem.addColumn("Màu sắc");
        modelDSSanPhamThem.addColumn("Hình ảnh");
        tableDSSanPhamThem.setModel(modelDSSanPhamThem);
        panel_2.setLayout(gl_panel_2);
        panel.setLayout(gl_panel);
        tableDSSanPhamThem.setRowHeight(25);

        // set thuọc tính thêm hình ảnh
        evtAddImage();

        // không thể đảo lộn từ dòng này ---- >
        // hiển thị tên loại sản phẩm
        showTenLoaiSanPham();
        // click chọn loại sản phẩm
        cbcLoaiSanPham.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loaiSanPhamModel = lstLoaiSanPham.get(cbcLoaiSanPham.getSelectedIndex());
                lstSanPhamModels = sanPhamService.findByIdLoai(loaiSanPhamModel.getId());
                showTenSanPham();
            }
        });
        // << -- tới dòng này

        // reset form
        resetForm();

        // tạo mới form
        btnTaoMoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetForm();
            }
        });

        // xoá 1 hàng
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeProduct();
            }
        });

        // lưu sản phẩm
        btnHoanThanh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveProduct();
            }
        });

        // đọc file excel
        btnImportExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (modelDSSanPhamThem.getRowCount() > 0) {
                    if (!EntityMessage.confirm(null, "Hành động này có thể làm mất hết dữ liệu trên form đang có")) {
                        return;
                    }
                }
                importExcel();
            }
        });

        uiCommon.editButtonCenter(btnXoa);
        uiCommon.editButtonCenter(btnHoanThanh);
        uiCommon.editButtonCenter(btnLuuTam);
        uiCommon.editButtonCenter(btnTaoMoi);
    }

    // đọc dữ liệu từ file excel
    private void importExcel() {
        try {
            EntityExcel.importExcel(modelDSSanPhamThem);
            String getTenSanPham, getTenLoaiSanPham, getGiaBan, getSize, getMauSac, getHinhAnh;
            List<Integer> lstLoiDuLieu = new ArrayList<>();
            List<Integer> lstDaTonTai = new ArrayList<>();
            List<Integer> lstLoiAnh = new ArrayList<>();
            lstUpdatePhotoProduct = new ArrayList<>();
            lstChiTietSanPhamThemMoi = new ArrayList<>();
            for (int i = 0; i < modelDSSanPhamThem.getRowCount(); i++) {
                getTenSanPham = modelDSSanPhamThem.getValueAt(i, 0).toString();
                getTenLoaiSanPham = modelDSSanPhamThem.getValueAt(i, 1).toString();
                getGiaBan = modelDSSanPhamThem.getValueAt(i, 2).toString();
                getSize = modelDSSanPhamThem.getValueAt(i, 3).toString();
                getMauSac = modelDSSanPhamThem.getValueAt(i, 4).toString();
                getHinhAnh = modelDSSanPhamThem.getValueAt(i, 5).toString();
                // kiểm tra dữ liệu bản ghi có hợp lệ không
                sanPhamModel = sanPhamService.findByNameSPAndNameLoai(getTenSanPham, getTenLoaiSanPham);
                if (sanPhamModel == null
                        || !EntityValidate.checkMoney2(this, getGiaBan)
                        || !EntityValidate.checkSize2(this, getSize)
                        || !EntityValidate.checkColor2(this, getMauSac)) {
                    lstLoiDuLieu.add(i);
                    continue;
                }
                // set thuộc tính mới vào đối tượng chiTietSanPham
                setThuocTinhChiTietSanPham(getGiaBan, getSize, getMauSac);
                // kiểm tra đã được lưu tạm chưa?
                boolean flag = lstChiTietSanPhamThemMoi.stream().filter(e ->
                        e.getIdSanPham().equals(chiTietSanPhamModel.getIdSanPham())
                                && e.getMauSac().equalsIgnoreCase(chiTietSanPhamModel.getMauSac())
                                && e.getSize().equalsIgnoreCase(chiTietSanPhamModel.getSize()))
                        .collect(Collectors.toList()).isEmpty();
                // kiểm tra bản ghi đã tồn tại trên db chưa
                if (chiTietSanPhamService.checkThemMoiSanPham(chiTietSanPhamModel) && flag) {
                    // set thuộc tính vào list lưu dữ liệu hình ảnh
                    File srcFile = new File(getHinhAnh);
                    if (srcFile.exists()) {
                        setDuLieuFileAnh(srcFile);
                        // lưu thông tin ảnh
                        saveInfoPhoto();
                    } else {
                        lstLoiAnh.add(i);
                        modelDSSanPhamThem.setValueAt("", i, 5);
                    }
                    setThuocTinhPhoTo();
                    lstChiTietSanPhamThemMoi.add(chiTietSanPhamModel);
                } else {
                    lstDaTonTai.add(i);
                }
            }
            StringBuilder sp = new StringBuilder();
            sp.append("Tổng số bản ghi excel có: ");
            sp.append(modelDSSanPhamThem.getRowCount());
            if (!lstLoiDuLieu.isEmpty()) {
                sp.append("\nCác bản ghi không thể đọc (Lỗi dữ liệu): ");
                lstLoiDuLieu.forEach(e -> sp.append((e + 2)).append(", "));
            }
            if (!lstDaTonTai.isEmpty()) {
                sp.append("\nCác bản ghi không thể đọc (Đã tồn tại): ");
                lstDaTonTai.forEach(e -> sp.append((e + 2)).append(", "));
            }
            if (!lstLoiAnh.isEmpty()) {
                sp.append("\nCác bản ghi lỗi hình ảnh (Không bị xoá trên form): ");
                lstLoiAnh.forEach(e -> sp.append((e + 2)).append(", "));
            }
            lstLoiDuLieu.addAll(lstDaTonTai);
            for (int i = lstLoiDuLieu.size() - 1; i >= 0; i--) {
                modelDSSanPhamThem.removeRow(lstLoiDuLieu.get(i));
            }
            if (!lstLoiDuLieu.isEmpty()
                    || !lstDaTonTai.isEmpty()
                    || !lstLoiAnh.isEmpty()) {
                sp.append("\nSố thứ dự được đánh theo thứ tự trên file excel");
            }
            sp.append("\nĐọc file excel thành công ");
            sp.append(modelDSSanPhamThem.getRowCount());
            sp.append(" bản ghi.");
            EntityMessage.show(this, sp.toString());
        } catch (IOException e) {
            e.printStackTrace();
            EntityMessage.show(this, "Đọc file excel thất bại");
        }
    }

    private void saveInfoPhoto() {
        if (nameFile != null
                && dstFile != null
                && pathForm != null) {
            lstNameFiles.add(nameFile);
            lstDstFiles.add(dstFile);
            lstPathFiles.add(pathForm);
        }
    }

    // sety thuộc tính vào list lưu trữ thông tin hình ảnh
    private void setThuocTinhPhoTo() {
        // cập nhật đối tương lưu trữ thông tin hình ảnh
        updatePhotoProduct = new UpdatePhotoProduct();
        updatePhotoProduct.setNameFiles(lstNameFiles);
        updatePhotoProduct.setDstFiles(lstDstFiles);
        updatePhotoProduct.setPathFromsFile(lstPathFiles);
        // thêm đối tượng lưuu trữ hình ảnh vào  list
        lstUpdatePhotoProduct.add(updatePhotoProduct);
        // reset lại list lưu trữ thông tin hình ảnh
        lstNameFiles = new ArrayList<>();
        lstDstFiles = new ArrayList<>();
        lstPathFiles = new ArrayList<>();
        System.out.println("size ảnh: " + lstUpdatePhotoProduct.size());
    }

    // set dữ liệu file ảnh vào dstFile, nameFile, pathFile
    private void setDuLieuFileAnh(File srcFile) {
        nameFile = null;
        dstFile = null;
        pathForm = null;
        dstFile = new File("images", "anh-san-pham");
        if (!dstFile.getParentFile().exists()) {
            dstFile.getParentFile().mkdirs();
        }
        while (true) {
            nameFile = (new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss.SSS").format(new Date())) + "." + srcFile.getName();
            dstFile = new File("images\\anh-san-pham", nameFile);
            if (!dstFile.exists()) {
                break;
            }
        }
        pathForm = Paths.get(srcFile.getAbsolutePath());
    }

    private void setThuocTinhChiTietSanPham(String getGiaBan, String getSize, String getMauSac) {
        chiTietSanPhamModel = new ChiTietSanPhamModel();
        chiTietSanPhamModel.setIdSanPham(sanPhamModel.getId());
        chiTietSanPhamModel.setGiaBan(Long.valueOf(getGiaBan));
        chiTietSanPhamModel.setMauSac(getMauSac);
        chiTietSanPhamModel.setSize(getSize);
    }

    private void evtAddImage() {
        // set label hình ảnh
        for (int i = 0; i < arrImage.length; i++) {
            arrImage[i] = new JLabel();
            panelImage.add(arrImage[i]);
            listLabelImg.add(new LabelImageModel(arrImage[i], "imgThemAnh.jpg"));
        }
        EntityImage.closeLabelImage(listLabelImg);
        // reset lại label hình ảnh
        btnTaoHinhMoi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EntityImage.clearHinh(listLabelImg);
            }
        });
        // sự kiện click thêm hình ảnh
        listLabelImg.forEach(e -> {
            e.getLblImage().setIcon(new ImageIcon("images\\imgThemAnh.jpg"));
            e.getLblImage().addMouseListener(chonHinh);
        });
    }

    // khi click thêm hình ảnh
    private MouseListener chonHinh = new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent e) {
            chonHinh((JLabel) e.getComponent());
            // khi thay đổi hình ảnh mà list lưuu thông tin hfinh ảnh đã có ảnh cũ thì sẽ xoá
            for (int i = 0; i < listLabelImg.size(); i++) {
                if (listLabelImg.get(i).getLblImage() == (JLabel) e.getComponent()) {
                    if (!listLabelImg.get(i).getName().equalsIgnoreCase("imgThemAnh.jpg")) {
                        if (lstNameFiles.size() > i) {
                            lstNameFiles.remove(i);
                            lstDstFiles.remove(i);
                            lstPathFiles.remove(i);
                            break;
                        }
                    }
                }
            }
            // và thay thế bằng thông tin ảnh mới
            saveInfoPhoto();
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }
    };

    // chọn hình ảnh
    private void chonHinh(JLabel label) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG and PNG", new String[]{"JPG", "PNG"});
        chooser.setFileFilter(filter);
        int i = chooser.showOpenDialog(null);
        File srcFile = chooser.getSelectedFile();
        setDuLieuFileAnh(srcFile);
        if (i == 0) {
            String path = srcFile.getPath();
            EntityImage.setNameToListImage(listLabelImg, nameFile, path, label);
        }
    }

    // lưu thông tin sản phẩm
    private void saveProduct() {
        if (lstChiTietSanPhamThemMoi.isEmpty()) {
            EntityMessage.show(this, "Chưa thêm sản phẩm nào");
            return;
        }
        int rowCountSave = chiTietSanPhamService.saveProduct(lstChiTietSanPhamThemMoi, lstUpdatePhotoProduct);
        if (rowCountSave == 0) {
            EntityMessage.show(this, "Lưu thất bại");
            return;
        }
        EntityMessage.show(this, "Lưu thành công " + rowCountSave + " sản phẩm");
        anhSanPhamService.reloadDta();
        hangHoaJInternalFrame.showTable(hangHoaJInternalFrame.getList());
        close();
    }

    // xoá 1 hàng trong bảng
    private void removeProduct() {
        int row = tableDSSanPhamThem.getSelectedRow();
        if (row > -1 && row < tableDSSanPhamThem.getRowCount()) {
            lstChiTietSanPhamThemMoi.remove(row);
            lstUpdatePhotoProduct.remove(row);
            modelDSSanPhamThem.removeRow(row);
            EntityMessage.show(this, "Đã xoá 1 hàng");
        } else {
            EntityMessage.show(this, "Mời chọn 1 hàng");
        }
    }

    // reset form nút tạo mới
    private void resetForm() {
        if (cbcLoaiSanPham.getItemCount() > 0) {
            cbcLoaiSanPham.setSelectedIndex(0);
        }
        txtSize_1.setText("");
        txtGiaBan.setText("");
        txtMauSac.setText("");
        EntityImage.clearHinh(listLabelImg);
    }

    // lưu tạm thông tin sản phẩm
    private void btnLuuTam() {
        // validate
        String getMoney = txtGiaBan.getText();
        String getSize = txtSize_1.getText();
        String getColor = txtMauSac.getText();
        if (EntityValidate.checkMoney(this, getMoney)
                && EntityValidate.checkSize(this, getSize)
                && EntityValidate.checkColor(this, getColor)) {
            sanPhamModel = lstSanPhamModels.get(cbcTenSanPham.getSelectedIndex());
            setThuocTinhChiTietSanPham(getMoney, getSize, getColor);
            // kiểm tra đã được lưu tạm chưa?
            boolean flag = lstChiTietSanPhamThemMoi.stream().filter(e ->
                    e.getIdSanPham().equals(chiTietSanPhamModel.getIdSanPham())
                            && e.getMauSac().equalsIgnoreCase(chiTietSanPhamModel.getMauSac())
                            && e.getSize().equalsIgnoreCase(chiTietSanPhamModel.getSize()))
                    .collect(Collectors.toList()).isEmpty();
            if (chiTietSanPhamService.checkThemMoiSanPham(chiTietSanPhamModel) && flag) {
                lstChiTietSanPhamThemMoi.add(chiTietSanPhamModel);
                StringBuilder listName = new StringBuilder();
                listLabelImg.forEach((Image) -> {
                    if (!Image.getName().equals("imgThemAnh.jpg")) {
                        listName.append(Image.getName() + ", ");
                    }
                });
                String namePhoto = listName.toString();
                if (namePhoto.contains(",")) {
                    namePhoto = namePhoto.trim().substring(0, namePhoto.lastIndexOf(","));
                }
                modelDSSanPhamThem.addRow(new Object[]{
                        sanPhamModel.getTenSP(),
                        loaiSanPhamModel.getTenLoaiSP(),
                        getMoney,
                        getSize,
                        getColor,
                        namePhoto
                });
                // clear hfinh ảnh
                EntityImage.clearHinh(listLabelImg);
                // cập nhật đối tương lưu trữ thông tin hình ảnh
                setThuocTinhPhoTo();
            } else {
                EntityMessage.show(this, "Chi tiết sản phẩm đã tồn tại");
            }
        }
    }

    // show combobox tên sản phẩm
    private void showTenSanPham() {
        cbcTenSanPham.setModel(new DefaultComboBoxModel<Object>(lstSanPhamModels.stream().map(e -> e.getTenSP()).collect(Collectors.toList()).toArray()));
    }

    // show combobox loại sản phẩm
    private void showTenLoaiSanPham() {
        cbcLoaiSanPham.setModel(new DefaultComboBoxModel<Object>(lstLoaiSanPham.stream().map(e -> e.getTenLoaiSP()).collect(Collectors.toList()).toArray()));
    }

    private void close() {
        this.dispose();
    }
}