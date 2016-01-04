/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DeteksiWajah;

import java.awt.image.BufferedImage;

/**
 *
 * @author Syem
 */
public class RemoveNoise {
    public static int[][] removeNoise(int[][] image){
        int  counter;
        int[][] imageHasil = new int[image.length][image[0].length];
        for (int i = 1; i < image.length-1; i++) {
            for (int j = 1; j < image[0].length-1; j++) {
                counter = 0;
                counter = image[i-1][j-1] + image[i-1][j] +
                          image[i-1][j+1] + image[i][j-1]+
                          image[i][j] + image[i][j+1] +
                          image[i+1][j-1] + image[i+1][j]+
                          image[i+1][j+1];
                if(counter >=8){
                   imageHasil[i][j] = 1;
                }else{
                    imageHasil[i][j] = 0;
                }
                //System.out.println(counter);
            }
        }
        return imageHasil;
    }
}
