package com.polymart.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class ThietLapGiaJInternalFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThietLapGiaJInternalFrame frame = new ThietLapGiaJInternalFrame();
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
	public ThietLapGiaJInternalFrame() {
		setBounds(100, 100, 450, 300);

	}
	
	public void initTopThietLapGia() {
		
	}
	
	public void initCenterThietLapGia() {
		
	}

}
