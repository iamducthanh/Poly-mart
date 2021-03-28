package com.polymart.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class NhapHangJInternalFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhapHangJInternalFrame frame = new NhapHangJInternalFrame();
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
	public NhapHangJInternalFrame() {
		setBounds(100, 100, 450, 300);

	}

	public void initTopNhapHang() {
		
	}
	
	public void initCenterNhapHang() {
		
	}
	
}
