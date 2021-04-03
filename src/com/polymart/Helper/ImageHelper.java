package com.polymart.Helper;

import java.awt.Image;

public class ImageHelper {
	public static Image resize(Image image, int width, int height) {
		Image reImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return reImage;
	}
}
// sao cái này của t lại k lỗi nhỉ
// k bik nữa pull về thấy lun