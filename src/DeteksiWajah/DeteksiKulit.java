/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DeteksiWajah;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Syem
 */
public class DeteksiKulit {

    static int[][] statusKulit;

    public static int[][] deteksiKulit(BufferedImage image) {
        statusKulit = new int[image.getWidth()][image.getHeight()];
        int ymid = (int) (image.getHeight() - (image.getHeight() / 1.8));

        ArrayList<float[][]> hsv = HSV.hsv(image);
        ArrayList<int[][]> yCbCr = RgbToYcbCr.Rgb2YCbCr(image);
        int[][] tepi = DeteksiTepi.deteksiTepi(image);

//        for (int i = 0; i < image.getWidth(); i++) {
//            for (int j = 0; j < image.getHeight(); j++) {
//                if ((yCbCr.get(1)[i][j] >= 90) && (yCbCr.get(1)[i][j] <= 120)) {
//                    if ((yCbCr.get(2)[i][j] >= 140) && (yCbCr.get(2)[i][j] <= 165.00)) {
//                        statusKulit[i][j] = 1;
//                    } else {
//                        statusKulit[i][j] = 0;
//                    }
//                } else {
//                    statusKulit[i][j] = 0;
//                }
//
//            }
//        }

//        for (int i = 0; i < image.getWidth(); i++) {
//            for (int j = 0; j < image.getHeight(); j++) {
//                if ((hsv.get(3)[i][j] > 6.0) && (hsv.get(3)[i][j] < 38.0)) {
//                        statusKulit[i][j] = 1;
//                    } 
//                 else {
//                    statusKulit[i][j] = 0;
//                }
//
//            }
//        }

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                if ((hsv.get(0)[i][j] > 0.0) && (hsv.get(0)[i][j] < 0.25)) {
                    if ((hsv.get(1)[i][j] > 0.15) && (hsv.get(1)[i][j] < 0.9)) {
                        if ((hsv.get(2)[i][j] > 0.2) && (hsv.get(2)[i][j] < 0.95)) {
                            statusKulit[i][j] = 1;
                        } else {
                            statusKulit[i][j] = 0;
                        }
                    } else {
                        statusKulit[i][j] = 0;
                    }
                } else {
                    statusKulit[i][j] = 0;
                }
            }
        }


//
//        for (int i = 0; i < image.getWidth(); i++) {
//            for (int j = 0; j < image.getHeight(); j++) {
//                if ((hsv.get(0)[i][j] > 0.0) && (hsv.get(0)[i][j] < 0.25)) {
//                    if ((hsv.get(1)[i][j] > 0.15) && (hsv.get(1)[i][j] < 0.9)) {
//                        if ((hsv.get(2)[i][j] > 0.2) && (hsv.get(2)[i][j] < 0.95)) {
//                            if (tepi[i][j] < 255) {
//                                statusKulit[i][j] = 1;
//                            }else{
//                                statusKulit[i][j] = 0;
//                            }
//                        } else {
//                            statusKulit[i][j] = 0;
//                        }
//                    } else {
//                        statusKulit[i][j] = 0;
//                    }
//                } else {
//                    statusKulit[i][j] = 0;
//                }
//            }
//        }


//        for (int i = 0; i < image.getWidth(); i++) {
//            for (int j = 0; j < image.getHeight(); j++) {
//                if (j > ymid) {
//                    statusKulit[i][j] = 0;
//                }
//            }
//        }

        return statusKulit;
    }
}
