/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DeteksiWajah;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Syem
 */
public class RgbToYcbCr {

    public static ArrayList<int[][]> Rgb2YCbCr(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        int[][] yValue = new int[width][height];
        int[][] CbValue = new int[width][height];
        int[][] CrValue = new int[width][height];

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                int RGB = image.getRGB(i, j);
                int a = (RGB >> 24) & 0x000000ff;
                int r = (RGB >> 16) & 0x000000ff;
                int g = (RGB >> 8) & 0x000000ff;
                int b = RGB & 0x000000ff;
                yValue[i][j] = (int) (0.299 * r + 0.587 * g + 0.114 * b);
                CbValue[i][j] = (int) (-0.16874 * r - 0.33126 * g + 0.50000 * b) + 128;
                CrValue[i][j] = (int) (0.50000 * r - 0.41869 * g - 0.08131 * b) + 128;
            }
        }

        ArrayList<int[][]> Rgb2YCbCr = new ArrayList<int[][]>();
        Rgb2YCbCr.add(yValue);
        Rgb2YCbCr.add(CbValue);
        Rgb2YCbCr.add(CrValue);

        return Rgb2YCbCr;
    }
}
