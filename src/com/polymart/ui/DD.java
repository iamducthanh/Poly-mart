package com.polymart.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.polymart.entity.EntityFrame;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;

public class DD extends JFrame {

	private static final long serialVersionUID = 7385962312915868189L;
	
	JPanel contentNhaPanel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntityFrame.DD.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DD() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Thêm phiếu thanh toán");
		setBounds(100, 100, 633, 626);
		setFocusable(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Tìm kiếm theo mã sản phẩm", "JAVA", "C", "C++", "PHP", "RUBY", "JAVASCRIPT", "ONION", "PYTHON", "SQL"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBounds(77, 133, 474, 36);
		getContentPane().add(comboBox);
		
		AutoCompleteDecorator.decorate(comboBox);
		
	}
}
