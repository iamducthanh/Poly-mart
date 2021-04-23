package com.polymart.ui.baocao;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ChiTietBaoCaoFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5719522712034557393L;
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel modelBaoCaoSP = new DefaultTableModel();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiTietBaoCaoFrame frame = new ChiTietBaoCaoFrame();
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
	public ChiTietBaoCaoFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chi tiết báo cáo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 243, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblMSnPhm = new JLabel("Mã sản phẩm: ");
		lblMSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMSnPhm.setBounds(10, 44, 129, 25);
		contentPane.add(lblMSnPhm);
		
		JLabel lblMaSP = new JLabel("label mã sản phẩm");
		lblMaSP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMaSP.setBounds(140, 44, 243, 25);
		contentPane.add(lblMaSP);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 97, 783, 359);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		modelBaoCaoSP.addColumn("Tên sản phẩm");
		modelBaoCaoSP.addColumn("Size");
		modelBaoCaoSP.addColumn("Màu sắc");
		modelBaoCaoSP.addColumn("Số lượng bán");
		modelBaoCaoSP.addColumn("Tổng giá bán");
		table.setModel(modelBaoCaoSP);
	}
}
