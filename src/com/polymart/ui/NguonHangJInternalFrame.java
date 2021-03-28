package com.polymart.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class NguonHangJInternalFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NguonHangJInternalFrame frame = new NguonHangJInternalFrame();
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
	public NguonHangJInternalFrame() {
		setBounds(100, 100, 450, 300);

	}

	public void initNguonHang() {
		
	}
	
}
