/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DeteksiWajah;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.ArrayList;

/**
 *
 * @author Syem
 */
public class HSV {

    public static ArrayList<float[][]> hsv(BufferedImage image) {
        float delta, nRed, nGreen, nBlue;
        float H = 0, S = 0, V;
        float max, min;
        float[][] h = new float[image.getWidth()][image.getHeight()];
        float[][] s = new float[image.getWidth()][image.getHeight()];
        float[][] v = new float[image.getWidth()][image.getHeight()];
    
        
        WritableRaster raster = image.getRaster();

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                int r = raster.getSample(i, j, 0);
                int g = raster.getSample(i, j, 1);
                int b = raster.getSample(i, j, 2);
                
                delta = r + g + b;
                nRed = r / delta;
                nGreen = g / delta;
                nBlue = b / delta;
                
                max = Math.max(nRed, Math.max(nGreen, nBlue));
                min = Math.min(nRed, Math.min(nGreen, nBlue));
                
                V = max;
                if (V == 0) {
                    S = 0;
                } else if (V > 0) {
                    S = (V - min) / V;
                }

                if (S == 0) {
                    H = 0;
                } else if (V == nRed) {
                    H = (nGreen - nBlue) / (S * V);
                } else if (V == nGreen) {
                    H = 2 + ((nBlue - nRed) / (S * V));
                } else if (V == nBlue) {
                    H = 4 + ((nRed - nGreen) / (S * V));
                }

                H *= 60;
                
                if(H < 0){
                    H += 360;
                }
                H = H / 360;

                h[i][j] = H;
                s[i][j] = S;
                v[i][j] = V;
            }
        }

        ArrayList<float[][]> hsvValue = new ArrayList<float[][]>();
        hsvValue.add(h);
        hsvValue.add(s);
        hsvValue.add(v);
        
        return hsvValue;
    }
}
