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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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

import com.polymart.entity.EntityFrame;
import com.polymart.entity.EntityImage;
import com.polymart.entity.EntityMessage;
import com.polymart.entity.EntityValidate;
import com.polymart.model.*;
import com.polymart.service.IAnhSanPhamService;
import com.polymart.service.IChiTietSanPhamService;
import com.polymart.service.ILoaiSanPhamService;
import com.polymart.service.ISanPhamService;
import com.polymart.service.impl.AnhSanPhamService;
import com.polymart.service.impl.ChiTietSanPhamService;
import com.polymart.service.impl.LoaiSanPhamService;
import com.polymart.service.impl.SanPhamService;

public class ThemHangHoaJInternalFrame extends JInternalFrame {

    private static final long serialVersionUID = -2914525596895096982L;

    private JPanel contentPane;
    private JComboBox cbcTenSanPham;
    private JComboBox cbcLoaiSanPham;
    private JTextField txtGiaBan;
    private JTextField txtMauSac;
    private JTextField txtSize;
    private JButton btnTaoHinhMoi;
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
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        setFocusable(true);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.WHITE);
        contentPane.add(panel_1, BorderLayout.NORTH);

        JButton btnQuayLai = new JButton("");
        btnQuayLai.setIcon(new ImageIcon("images\\back-6.png"));
        btnQuayLai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });
        btnQuayLai.setContentAreaFilled(false);
        btnQuayLai.setBorder(null);
        btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 17));

        JLabel lblNewLabel = new JLabel("  Thêm sản phẩm");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
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
        			.addGap(5)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnQuayLai, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        JButton btnXoa = new JButton("Xoá");

        JButton btnTaoMoi_1 = new JButton("Import");
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
                                        .addComponent(btnTaoMoi_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
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
                                                .addComponent(btnTaoMoi_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
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

        txtSize = new JTextField();
        txtSize.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JLabel lblLoai = new JLabel("Loại: ", JLabel.RIGHT);
        lblLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));

        JLabel lblGiaBan = new JLabel("Giá bán: ", JLabel.RIGHT);
        lblGiaBan.setFont(new Font("Tahoma", Font.PLAIN, 14));

        JLabel lblSize = new JLabel("Size: ", JLabel.RIGHT);
        lblSize.setFont(new Font("Tahoma", Font.PLAIN, 14));

        JLabel lblMauSac = new JLabel("Màu sắc: ", JLabel.RIGHT);
        lblMauSac.setFont(new Font("Tahoma", Font.PLAIN, 14));

        btnTaoHinhMoi = new JButton("Tạo mới hình");
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
                                        .addComponent(cbcLoaiSanPham, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                        .addComponent(cbcTenSanPham, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                        .addComponent(txtSize, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(ComponentPlacement.RELATED, 678, Short.MAX_VALUE)
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
                                                                .addComponent(txtSize, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
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
                                .addComponent(btnTaoHinhMoi)
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
            if (nameFile != null
                    && dstFile != null
                    && pathForm != null) {
                lstNameFiles.add(nameFile);
                lstDstFiles.add(dstFile);
                lstPathFiles.add(pathForm);
            }
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
        nameFile = null;
        dstFile = null;
        pathForm = null;
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG and PNG", new String[]{"JPG", "PNG"});
        chooser.setFileFilter(filter);
        int i = chooser.showOpenDialog(null);
        File srcFile = chooser.getSelectedFile();
        dstFile = new File("images", "anh-san-pham");
        if (!dstFile.getParentFile().exists()) {
            dstFile.getParentFile().mkdirs();
        }
        while (true) {
            nameFile = Math.random() * 10000000 + srcFile.getName();
            dstFile = new File("images\\anh-san-pham", nameFile);
            if (!dstFile.exists()) {
                break;
            }
        }
        pathForm = Paths.get(srcFile.getAbsolutePath());
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
        txtSize.setText("");
        txtGiaBan.setText("");
        txtMauSac.setText("");
        EntityImage.clearHinh(listLabelImg);
    }

    // lưu tạm thông tin sản phẩm
    private void btnLuuTam() {
        // validate
        String getMoney = txtGiaBan.getText();
        String getSize = txtSize.getText();
        String getColor = txtMauSac.getText();
        if (EntityValidate.checkMoney(this, getMoney)
                && EntityValidate.checkSize(this, getSize)
                && EntityValidate.checkColor(this, getColor)) {
            chiTietSanPhamModel = new ChiTietSanPhamModel();
            sanPhamModel = lstSanPhamModels.get(cbcTenSanPham.getSelectedIndex());
            chiTietSanPhamModel.setIdSanPham(sanPhamModel.getId());
            chiTietSanPhamModel.setGiaBan(Long.valueOf(getMoney));
            chiTietSanPhamModel.setMauSac(getColor);
            chiTietSanPhamModel.setSize(getSize);
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
            } else {
                EntityMessage.show(this, "Chi tiết sản phẩm đã tồn tại");
            }
        }
    }

    // show combobox tên sản phẩm
    private void showTenSanPham() {
        cbcTenSanPham.setModel(new DefaultComboBoxModel(lstSanPhamModels.stream().map(e -> e.getTenSP()).collect(Collectors.toList()).toArray()));
    }

    // show combobox loại sản phẩm
    private void showTenLoaiSanPham() {
        cbcLoaiSanPham.setModel(new DefaultComboBoxModel(lstLoaiSanPham.stream().map(e -> e.getTenLoaiSP()).collect(Collectors.toList()).toArray()));
    }

    private void close() {
        this.dispose();
    }
}