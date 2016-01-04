/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Morphologi2;

import Binerisasi.OtsuBinarizationThreshold;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Syem
 */
public class DeteksiBoundary {

    public int width;
    public int height;
    public int[][] Pixels;

    public DeteksiBoundary(int width, int height) {
        this.width = width;
        this.height = height;
        Pixels = new int[width][height];
    }

    public DeteksiBoundary(int[][] pixels) {
        Pixels = pixels;
        this.width = pixels.length;
        this.height = pixels[0].length;
    }

    public int[][] eroded(DeteksiBoundary structurElement) {
        int[][] ret = new int[width][height];
        int min_index_width = structurElement.width / 2;
        int min_index_height = structurElement.height / 2;
        int max_index_width = Pixels.length - min_index_width;
        int max_index_height = Pixels[0].length - min_index_height;
        int status_dilasi;
        for (int i = min_index_width; i < max_index_width; i++) {
            for (int j = min_index_height; j < max_index_height; j++) {
                boolean keep = true;
                for (int m = 0; m < structurElement.width; m++) {
                    for (int n = 0; n < structurElement.height; n++) {
                        if (Pixels[(i - min_index_width) + m][(j - min_index_height) + n] != 2) {
                            if (Pixels[(i - min_index_width) + m][(j - min_index_height) + n] != structurElement.Pixels[m][n]) {
                                keep = false;
                                break;
                            }
                        }
                    }
                }
                ret[i][j] = keep ? 1 : 0;
            }
        }
        return ret;
    }

    public int[][] boundary(DeteksiBoundary structureElement) {
        int[][] result = eroded(structureElement);
        return minus(new DeteksiBoundary(result));
    }

    public int[][] minus(DeteksiBoundary image) {
        int[][] minus = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                minus[i][j] = Pixels[i][j] - image.Pixels[i][j];
            }
        }

        return minus;
    }

    public void print() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (Pixels[i][j] == 1) {
                    System.out.print("1");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

//    public static void main(String[] args) throws IOException {
//        BufferedImage image = ImageIO.read(new File("f:/ImagePercobaan/ContohChainCode.jpg"));
//        BufferedImage biner;
//
//        if (image.getType() == 0) {
//            biner = OtsuBinarizationThreshold.binarize(image);
//        } else {
//            biner = image;
//        }
//
//        WritableRaster raster = biner.getRaster();
//
//        int[][] dataImage = new int[biner.getWidth()][biner.getHeight()];
//
//        for (int i = 0; i < biner.getWidth(); i++) {
//            for (int j = 0; j < biner.getHeight(); j++) {
//                dataImage[i][j] = raster.getSample(i, j, 0);
//            }
//        }
//
//        int[][] dataSE = {
//            {1, 1, 1},
//            {1, 1, 1},
//            {1, 1, 1}
//        };
//
//        DeteksiBoundary tesImage = new DeteksiBoundary(dataImage);
//        DeteksiBoundary structureElement = new DeteksiBoundary(dataSE);
//        DeteksiBoundary resultImage = new DeteksiBoundary(tesImage.boundary(structureElement));
//        //tesImage.print();
//        //resultImage.print();
//
//        int[][] resultIB = resultImage.Pixels;
//        BufferedImage result = new BufferedImage(biner.getWidth(), biner.getHeight(), BufferedImage.TYPE_INT_RGB);
//        WritableRaster rasterR = result.getRaster();
//
//        for (int i = 0; i < biner.getWidth(); i++) {
//            for (int j = 0; j < biner.getHeight(); j++) {
//                if (resultIB[i][j] == 1) {
//                    rasterR.setSample(i, j, 0, 255);
//                } else {
//                    rasterR.setSample(i, j, 0, 255);
//                    rasterR.setSample(i, j, 1, 255);
//                    rasterR.setSample(i, j, 2, 255);
//                }
//            }
//        }
//        ImageIO.write(result, "jpg", new File("f:/ImagePercobaan/ContohChainerosionDataTraining5.png"));
//    }
}
