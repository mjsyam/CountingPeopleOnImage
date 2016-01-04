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
public class GrayScale {    
    public static int[][] grayScale(BufferedImage image){
        int[][] gray = new int[image.getWidth()][image.getHeight()];
        WritableRaster raster = image.getRaster();
        
        for (int i = 0; i < gray.length; i++) {
            for (int j = 0; j < gray[0].length; j++) {
                int r = raster.getSample(i, j, 0);
                int g = raster.getSample(i, j, 1);
                int b = raster.getSample(i, j, 2);
                
                float grayValue = (float) (0.3 * r + 0.59 * g + 0.11 * b);
                gray[i][j] = (int) grayValue;                
            }            
        }
        return gray;
        
    }
}
