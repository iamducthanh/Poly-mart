package com.polymart.entity;

import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.polymart.model.LabelImageModel;

public class EntityImage {
    static int a;

	public static Image resize(Image image, int width, int height) {
		Image reImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return reImage;
	}
	
	public static Image resizeTheoUrl(String url, int width, int height) {
		ImageIcon imageIcon = new ImageIcon(url);
		Image reImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return reImage;
	}

    public static void closeLabelImage(List<LabelImageModel> listLabelImg) {
        for (int i = 1; i < listLabelImg.size(); i++) {
            if (listLabelImg.get(i).getName().equals("imgThemAnh.jpg")) {
                listLabelImg.get(i).getLblImage().setVisible(false);
            }
        }
    }

    public static void clearHinh(List<LabelImageModel> listLabelImg) {
        for (int i = 0; i < listLabelImg.size(); i++) {
            listLabelImg.get(i).setName("imgThemAnh.jpg");
            listLabelImg.get(i).getLblImage().setIcon(new ImageIcon("images\\imgThemAnh.jpg"));
        }
        closeLabelImage(listLabelImg);
    }

    public static void setNameToListImage(List<LabelImageModel> listLabelImg, String name, String path, JLabel label) {
        for (int i = 0; i < listLabelImg.size(); i++) {
            if (listLabelImg.get(i).getLblImage() == label) {
                listLabelImg.get(i).setName(name);
                ImageIcon imageIcon = new ImageIcon(path);
                Image image = resize(imageIcon.getImage(), 100, 100);
                listLabelImg.get(i).getLblImage().setIcon(new ImageIcon(image));
                if (i + 1 != listLabelImg.size() && !listLabelImg.get(i + 1).getLblImage().isVisible()) {
                    listLabelImg.get(i + 1).getLblImage().setVisible(true);
                }
                return;
            }
        }
    }
}
