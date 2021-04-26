package com.polymart.ui.baocao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.polymart.dao.impl.BaoCaoSanPhamBanRaDao;
import com.polymart.dao.impl.SanPhamDAO;
import com.polymart.model.BaoCaoNgayModel;
import com.polymart.model.SanPhamModel;
import com.polymart.service.ISanPhamService;
import com.polymart.service.impl.SanPhamService;
import com.toedter.calendar.JCalendar;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.polymart.entity.EntityExcel;
public class BaoCaoSanPhamBanRaTrongNgay extends JInternalFrame {

	private static final long serialVersionUID = 1619911861884761168L;

	private JPanel contentPane;
	private DefaultTableModel modelBaoCao = new DefaultTableModel();
	private JPanel panel = new JPanel();
	private JPanel nhanVienJPanel = new JPanel();
	private JTable tableBaoCao;
	JCalendar dateNgayBaoCao;
	private Calendar calendar;
	JLabel lblTongThu = new JLabel("0", JLabel.RIGHT);
	JLabel lblTongChi = new JLabel("0", JLabel.RIGHT);
	JLabel lblTong = new JLabel("0", JLabel.RIGHT);
	List<BaoCaoNgayModel> list = new ArrayList<BaoCaoNgayModel>();
	private ISanPhamService sanPhamService = new SanPhamService();
	BaoCaoSanPhamBanRaDao baoCaoDao= new BaoCaoSanPhamBanRaDao();
	static String IDSanPham;
	static String nameSP;
	static Calendar ngayBaoCao;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaoCaoSanPhamBanRaTrongNgay frame = new BaoCaoSanPhamBanRaTrongNgay();
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
	public BaoCaoSanPhamBanRaTrongNgay() {
		calendar = Calendar.getInstance();
		((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1169, 801);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(75, 0, 130));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		panel.setBackground(Color.WHITE);

		contentPane.add(panel, BorderLayout.NORTH);

		initTopChamCong();
		initCenterChamCong();
		 ThuChiHienTai();

		tableBaoCao.setRowHeight(25);
	}

	public void initTopChamCong() {
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(75, 0, 130));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1149, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		JLabel lblNhanVien = new JLabel("Báo cáo sản phẩm bán ra trong ngày");
		lblNhanVien.setForeground(new Color(255, 255, 255));
		lblNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnExport = new JButton("Xuất File");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				export(ngayBaoCao, tableBaoCao, lblTongChi, lblTongThu, lblTong);
			}
		});
		btnExport.setIcon(null);
		btnExport.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExport.setForeground(Color.BLACK);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNhanVien, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 719, Short.MAX_VALUE)
					.addComponent(btnExport)
					.addGap(33))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNhanVien, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExport))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
	}

	public void initCenterChamCong() {
		nhanVienJPanel.setLayout(new BoxLayout(nhanVienJPanel, BoxLayout.Y_AXIS));
		JLabel lblNewLabel_2 = new JLabel("Loại hàng             ▼");
		lblNewLabel_2.setFont(new Font("Consolas", Font.BOLD, 14));
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		tableBaoCao = new JTable();
		tableBaoCao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int select = tableBaoCao.getSelectedRow();
				IDSanPham = String.valueOf(tableBaoCao.getValueAt(select, 0));
				nameSP = String.valueOf(tableBaoCao.getValueAt(select, 1));
				ChiTietBaoCaoFrame chiTietBaoCaoFrame = new ChiTietBaoCaoFrame();
				chiTietBaoCaoFrame.setVisible(true);
				chiTietBaoCaoFrame.setLocationRelativeTo(null);
			}
		});
		tableBaoCao.setBackground(Color.WHITE);
		scrollPane.setViewportView(tableBaoCao);
		modelBaoCao.addColumn("Mã sản phẩm");
		modelBaoCao.addColumn("Tên sản phẩm");
		modelBaoCao.addColumn("Tổng số lượng bán");
		modelBaoCao.addColumn("Tổng số Hiện Tại Còn Trong kho");
		modelBaoCao.addColumn("Số Lượng Bán Ra Trong Tháng");
		modelBaoCao.addColumn("Số Lượng Trung Bình");
		
		
		tableBaoCao.setModel(modelBaoCao);


//		tableBaoCao.getColumnModel().getColumn(3).setPreferredWidth(30);
//		tableBaoCao.getColumnModel().getColumn(4).setPreferredWidth(30);
//		tableBaoCao.getColumnModel().getColumn(5).setPreferredWidth(30);
//		tableBaoCao.getColumnModel().getColumn(6).setPreferredWidth(30);
//		tableBaoCao.getColumnModel().getColumn(7).setPreferredWidth(30);
//		tableBaoCao.getColumnModel().getColumn(8).setPreferredWidth(30);
//		tableBaoCao.getColumnModel().getColumn(9).setPreferredWidth(30);

		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(Color.WHITE);
		contentPane.add(panelLeft, BorderLayout.WEST);

		dateNgayBaoCao = new JCalendar();
		dateNgayBaoCao.getDayChooser().getDayPanel().setBackground(Color.WHITE);
		dateNgayBaoCao.getYearChooser().getSpinner().setFont(new Font("Tahoma", Font.PLAIN, 13));
		dateNgayBaoCao.getDayChooser().addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName().equals("day")) {
					timKiemTheoNgay();
					ngayBaoCao=dateNgayBaoCao.getCalendar();
				}
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(160, 160, 160)), "K\u1EBFt qu\u1EA3", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		GroupLayout gl_panelLeft = new GroupLayout(panelLeft);
		gl_panelLeft.setHorizontalGroup(
			gl_panelLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLeft.createSequentialGroup()
					.addGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelLeft.createSequentialGroup()
							.addContainerGap()
							.addComponent(dateNgayBaoCao, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
						.addGroup(gl_panelLeft.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(10)))
					.addGap(0))
		);
		gl_panelLeft.setVerticalGroup(
			gl_panelLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLeft.createSequentialGroup()
					.addContainerGap()
					.addComponent(dateNgayBaoCao, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(217, Short.MAX_VALUE))
		);
		
		
		JLabel lblNewLabel_3 = new JLabel("Tổng Chi");
		
		
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel = new JLabel("Tổng Thu");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTongChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		lblTongChi.setForeground(Color.BLACK);
		
		lblTongThu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTongThu.setForeground(Color.RED);
		
		JLabel lblNewLabel_7 = new JLabel("Tổng ");
		lblNewLabel_7.setForeground(Color.BLACK);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		
	
		lblTong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTong.setForeground(Color.BLACK);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblTongChi, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTong, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
								.addComponent(lblTongThu, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTongChi, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTongThu, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTong, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		panelLeft.setLayout(gl_panelLeft);

	}
	protected void timKiemTheoNgay() {
		Calendar c = dateNgayBaoCao.getCalendar();
		String nam = String.valueOf(c.get(Calendar.YEAR));
		String thang = String.valueOf(c.get(Calendar.MONDAY)+1);
		String ngay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		loadList(nam, thang, ngay);
		loabtable(nam, thang, Integer.parseInt(ngay));
		ThuChi(nam, thang, ngay);
		
	}

	public void loadList(String nam , String thang, String ngay) {
		list.clear();
//		Calendar c = Calendar.getInstance();
//		String nam = String.valueOf(c.get(Calendar.YEAR));
//		String thang = String.valueOf(c.get(Calendar.MONDAY)+1);
//		String ngay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		list = baoCaoDao.finAll(nam,thang,ngay);
		
	}
	public void loabtable(String nam ,String thang, int day)  {
		modelBaoCao.setRowCount(0);
//		Calendar c = Calendar.getInstance();
//		String nam = String.valueOf(c.get(Calendar.YEAR));
//		String thang = String.valueOf(c.get(Calendar.MONDAY)+1);
//		int day = c.get(Calendar.DAY_OF_MONTH);
		float d = day;
		for (BaoCaoNgayModel baoCaoNgayModel : list) {
			SanPhamModel sanPhamModel = sanPhamService.findByID(baoCaoNgayModel.getIdSanPham());
			int soLuongBanRaTrongThang = baoCaoDao.tbSoLuongBanRa(nam,thang,baoCaoNgayModel.getIdSanPham());
			float a =soLuongBanRaTrongThang/d;
			float tb = Math.round(a*100);
			modelBaoCao.addRow(new Object[] {baoCaoNgayModel.getIdSanPham(),sanPhamModel.getTenSP(),baoCaoNgayModel.getSoLuongBanRa(),
					baoCaoDao.soLuongTrongKho(baoCaoNgayModel.getIdSanPham())
					,soLuongBanRaTrongThang,tb/100});
		}
	}
	public void ThuChi(String nam , String thang, String ngay) {
//		Calendar c = Calendar.getInstance();
//		String nam = String.valueOf(c.get(Calendar.YEAR));
//		String thang = String.valueOf(c.get(Calendar.MONDAY)+1);
//		String ngay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		lblTongThu.setText(dinhDangMonney(baoCaoDao.tongThu(nam, thang,ngay)));
		lblTongChi.setText(dinhDangMonney(baoCaoDao.tongChi(nam, thang,ngay)));
		lblTong.setText(dinhDangMonney(baoCaoDao.tongThu(nam, thang,ngay)-baoCaoDao.tongChi(nam, thang,ngay)));
		
	}
	public void ThuChiHienTai() {
		Calendar c = Calendar.getInstance();
		String nam = String.valueOf(c.get(Calendar.YEAR));
		String thang = String.valueOf(c.get(Calendar.MONDAY)+1);
		String ngay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		loadList(nam, thang, ngay);
		loabtable(nam, thang, Integer.parseInt(ngay));
		ThuChi(nam, thang, ngay);
	}
	public String dinhDangMonney(long l) {
		Locale locale = new Locale("vi","VN");
		NumberFormat format = NumberFormat.getCurrencyInstance(locale);
		return format.format(l);
	}
	public void export(Calendar calendar,JTable table,JLabel chi,JLabel thu,JLabel tong ) {
		if(tableBaoCao.getRowCount()==0) {
			JOptionPane.showMessageDialog(this, "Không có dữ liệu");
			return;
		}
		else {
			Workbook newExcel = new XSSFWorkbook();
	        Sheet sheet = newExcel.createSheet();
	        Row rowHeader = sheet.createRow(0);
	        for (int i = 0; i < table.getColumnCount(); i++) {
	            Cell cellHeader = rowHeader.createCell(i);
	            cellHeader.setCellValue(table.getColumnName(i));
	        } 
	        for (int i = 0; i < table.getRowCount(); i++) {
	            Row row = sheet.createRow(i + 1);
	            for (int j = 0; j < table.getColumnCount(); j++) {
	                Cell cell = row.createCell(j);
	                cell.setCellValue(table.getValueAt(i, j).toString());
	            }
	        }
	        Row rowChi = sheet.createRow(table.getRowCount()+2);
	        rowChi.createCell(0).setCellValue("Tổng chi");
	        rowChi.createCell(1).setCellValue(chi.getText());
	        
	        Row rowThu = sheet.createRow(table.getRowCount()+3);
	        rowThu.createCell(0).setCellValue("Tổng thu");
	        rowThu.createCell(1).setCellValue(thu.getText());
	        
	        Row rowTong = sheet.createRow(table.getRowCount()+4);
	        rowTong.createCell(0).setCellValue("Tổng");
	        rowTong.createCell(1).setCellValue(tong.getText());
	        
	        Row rowDate = sheet.createRow(table.getRowCount()+5);
	        rowDate.createCell(0).setCellValue(calendar.getTime().toString());
	        for (int columnIndex = 0; columnIndex < table.getColumnCount(); columnIndex++) {
	            sheet.autoSizeColumn(columnIndex);
	        }
	       try {
	    	   OutputStream os = new FileOutputStream(ChooseFileSave());
	           newExcel.write(os);
	           newExcel.close();
	           os.close();
	           JOptionPane.showMessageDialog(null, "Đã xuất báo cáo");
		} catch (Exception e) {
			// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Xuất file thất bại");
			}
		}
	}
	private String ChooseFileSave() {
        String path = null;
        JFileChooser chooser = new JFileChooser();
        int rVal = chooser.showSaveDialog(null);
        if (rVal == JFileChooser.APPROVE_OPTION) {
            String filename = chooser.getSelectedFile().getName();
            String dir = chooser.getCurrentDirectory().toString();
            if (filename.endsWith(".xlsx")) {
                path = dir + "\\" + filename;
            } else {
                path = dir + "\\" + filename + getCurrenDate() + ".xlsx";
            }
            return path;
        } else {
            return null;
        }
    }
	private String getCurrenDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("_dd_MM_yyyy");
        Date date = new Date();
        return formatter.format(date);
    }
}
