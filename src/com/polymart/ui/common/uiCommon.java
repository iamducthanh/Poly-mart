package com.polymart.ui.common;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class uiCommon {
    private JPanel panelOption;
    static Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    public static int width = (int) dimension.getWidth();
    public static int height = (int) dimension.getHeight();

    public uiCommon(JPanel panelOption) {
        super();
        this.panelOption = panelOption;
    }

    public uiCommon() {

    }

    public void addCheckBox(JCheckBox checkBox, int x, int y, int w) {
        checkBox.setBackground(Color.WHITE);
        checkBox.setBounds(x, y, w, 23);
        panelOption.add(checkBox);
    }

    public static void editButtonTop(JButton button) {
        button.setBorder(new RoundedBorder(10));
        button.setForeground(new Color(255, 255, 255));
        button.setBackground(new Color(75, 0, 130));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(153, 50, 204));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(75, 0, 130));
            }
        });
    }

    public static void editButtonCenter(JButton button) {
        button.setBorder(new RoundedBorder(10));
        button.setForeground(Color.black);
        button.setBackground(Color.white);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBorder(new RoundedBorder(10));
                button.setBackground(new Color(153, 50, 204));
                button.setForeground(new Color(255, 255, 255));
//				button.setBorder(new LineBorder(new Color(153, 50, 204), 2));
//				button.setForeground(new Color(153, 50, 204));
//				button.setContentAreaFilled(false);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBorder(new RoundedBorder(10));
                button.setForeground(Color.black);
                button.setBackground(Color.white);
            }
        });
    }

}
