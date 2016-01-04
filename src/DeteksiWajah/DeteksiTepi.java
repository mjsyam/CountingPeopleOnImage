/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DeteksiWajah;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

/**
 *
 * @author Syem
 */
public class DeteksiTepi {

    public static int[][] deteksiTepi(BufferedImage image) {
        int[][] tepi = new int[image.getWidth()][image.getHeight()];
        int[][] gray = GrayScale.grayScale(image);
        WritableRaster raster = image.getRaster();

        int[][] gX = {{-1, -2, -1},
            {0, 0, 0},
            {1, 2, 1}};
        int[][] gY = {{-1, 0, 1},
            {-2, 0, 2},
            {-1, 0, 1}};
        int[][] tamp = new int[3][3];
        int sumGX, sumGY, hasil;


        for (int x = 1; x < image.getWidth()-1; x++) {
            for (int y = 1; y < image.getHeight()-1; y++) {
                tamp[0][0] = gray[x - 1][ y - 1];
                tamp[0][1] = gray[x][y - 1];
                tamp[0][2] = gray[x + 1][y - 1];
                tamp[1][0] = gray[x - 1][y];
                tamp[1][1] = gray[x][y];
                tamp[1][2] = gray[x + 1][y];
                tamp[2][0] = gray[x - 1][y + 1];
                tamp[2][1] = gray[x][y + 1];
                tamp[2][2] = gray[x + 1][y + 1];

                sumGX = 0;
                sumGY = 0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        sumGX += gX[k][l] * tamp[k][l];
                        sumGY += gY[k][l] * tamp[k][l];
                    }
                }
                hasil = Math.abs(sumGX) + Math.abs(sumGY);
                if (hasil > 255) {
                    hasil = 255;
                }
                tepi[x][y] = hasil;
            }
        }

        return tepi;
    }
}
