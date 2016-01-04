/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Binerisasi;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Syem
 */
public class OtsuBinarizationThreshold {

    public static int[] imageHistogram(BufferedImage image) {
        int[] histogram = new int[256];
        for (int i = 0; i < histogram.length; i++) {
            histogram[i] = 0;
        }

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                int RGB = image.getRGB(i, j);
                int red = (RGB >> 16) & 0x000000ff;
                histogram[red]++;
            }
        }
        return histogram;
    }

    public static BufferedImage toGray(BufferedImage image) {
        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster rasterCI = image.getRaster();
        WritableRaster rasterCR = result.getRaster();
        
        float[][] grayTamp = new float[image.getWidth()][image.getHeight()];
        
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                int red = rasterCI.getSample(i, j, 0);
                int green = rasterCI.getSample(i, j, 1);
                int blue = rasterCI.getSample(i, j, 2);                
                float g = (float) (0.3 * red + 0.59 * green + 0.11 * blue);
                grayTamp[i][j] = g;                
                int gray =  (int) Math.round(0.3 * red + 0.59 * green + 0.11 * blue);
                
                rasterCR.setSample(i, j, 0, gray);
            }
        }
        return result;
    }
    
    public static int otsuTreshold(BufferedImage image) {
        int[] histogram = imageHistogram(image);
        int total = image.getWidth() * image.getHeight();

        float sum = 0;
        for (int i = 0; i < 256; i++) {
            sum += i * histogram[i];
        }

        float sumB = 0;
        int wB = 0;
        int wF = 0;

        float varMax = 0;
        int threshold = 0;

        for (int i = 0; i < 256; i++) {
            // Weight Backround
            wB += histogram[i];
            if (wB == 0) {
                continue;
            }

            // Weight Foreground
            wF = total - wB;
            if (wF == 0) {
                break;
            }

            sumB += (float) (i * histogram[i]);

            // Mean Backround
            float mB = sumB / wB;

            // Mean Foreground
            float mF = (sum - sumB) / wF;
            float varBetween = (float) wB * (float) wF * (mB - mF) * (mB - mF);
            if (varBetween > varMax) {
                varMax = varBetween;
                threshold = i;
            }
        }

        return threshold;
    }

    public static BufferedImage binarize(BufferedImage original) {

        int red;
        int newPixel;
        
        BufferedImage toGray = toGray(original);
        int threshold = otsuTreshold(original);
        
        BufferedImage binarized = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
        WritableRaster rasterCI = toGray.getRaster();
        WritableRaster rasterCR = binarized.getRaster();
        for (int i = 0; i < original.getWidth(); i++) {
            for (int j = 0; j < original.getHeight(); j++) {

                // Ambil Pixel
                red = rasterCI.getSample(i, j, 0);
                
                if (red > threshold) {
                    newPixel = 0;
                } else {
                    newPixel = 255;
                }
                rasterCR.setSample(i, j, 0, newPixel);

            }
        }

        return binarized;

    }

//    public static void main(String[] args) throws IOException {
//        BufferedImage image = ImageIO.read(new File("f:/ImagePercobaan/Object.png"));
//        BufferedImage biner = binarize(image);
//        ImageIO.write(biner, "jpg", new File("f:/ImagePercobaan/Hasil/Biner/Untitled4.jpg"));
//    }
}
