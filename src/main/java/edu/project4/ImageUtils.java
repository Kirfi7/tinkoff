package edu.project4;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageUtils {
    private ImageUtils() {
    }

    public static void save(Image img, File file) {
        BufferedImage bi = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < img.getWidth(); w++) {
            for (int h = 0; h < img.getHeight(); h++) {
                bi.setRGB(w, h, img.get(w, h).getColor().getRGB());
            }
        }

        try {
            ImageIO.write(bi, "png", file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
