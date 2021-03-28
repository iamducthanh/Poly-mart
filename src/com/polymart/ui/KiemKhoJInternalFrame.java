package com.polymart.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class KiemKhoJInternalFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KiemKhoJInternalFrame frame = new KiemKhoJInternalFrame();
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
	public KiemKhoJInternalFrame() {
		setBounds(100, 100, 450, 300);

	}

	public void initTopKiemKho() {
		
	}
	
	public void initCenterKiemKho() {
		
	}
	
}
