/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Morphologi;

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
public class CariPerimeter {

    public static void main(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(new File("f:/ImagePercobaan/ContohChainCode.jpg"));
        BufferedImage biner = OtsuBinarizationThreshold.binarize(image);
        
        int[][] dataImage2 = bufferToArray(biner);

        int[][] dataSE = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };

        BinaryImage tesImage = new BinaryImage(dataImage2);
        BinaryImage structureElement = new BinaryImage(dataSE);
        BinaryImage resultImage = new BinaryImage(tesImage.boundary(structureElement));
        
        int a = 1;
        for (int i = 0; i < resultImage.Pixels.length; i++) {
            for (int j = 0; j < resultImage.Pixels[0].length; j++) {
                if(resultImage.Pixels[i][j]==1){
                    a++;
                }
            }
        }
        System.out.println(a);
        double perimeter = getPerimeter(resultImage.Pixels);
        System.out.println(perimeter);
    }

    public static int[][] bufferToArray(BufferedImage image) {
        int[][] data = new int[image.getWidth()][image.getHeight()];
        WritableRaster raster = image.getRaster();

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                data[i][j] = raster.getSample(i, j, 0);
            }
        }
        return data;
    }
    
    public static double getPerimeter(int[][] resultImage){
        int[][] convolution = {
            {10, 2, 10},
            {2, 1, 2},
            {10, 2, 10}
        };

        int[][] tamp = new int[resultImage.length][resultImage[0].length];
        int[][] hasil = new int[resultImage.length][resultImage[0].length];
        int sum;
        for (int i = 1; i < resultImage.length - 1; i++) {
            for (int j = 1; j < resultImage[0].length - 1; j++) {
                tamp[0][0] = resultImage[i - 1][j - 1];
                tamp[0][1] = resultImage[i - 1][j];
                tamp[0][2] = resultImage[i - 1][j + 1];
                tamp[1][0] = resultImage[i][j - 1];
                tamp[1][1] = resultImage[i][j];
                tamp[1][2] = resultImage[i][j + 1];
                tamp[2][0] = resultImage[i + 1][j - 1];
                tamp[2][1] = resultImage[i + 1][j];
                tamp[2][2] = resultImage[i + 1][j + 1];
                sum = 0;
                for (int k = 0; k < convolution.length; k++) {
                    for (int l = 0; l < convolution[0].length; l++) {
                        sum += tamp[k][l] * convolution[k][l];
                    }
                }
                hasil[i][j] = sum;
            }
        }
        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 0; i < hasil.length; i++) {
            for (int j = 0; j < hasil[0].length; j++) {
                if ((hasil[i][j] == 5) || (hasil[i][j] == 15)
                        || (hasil[i][j] == 7) || (hasil[i][j] == 25)
                        || (hasil[i][j] == 27) || (hasil[i][j] == 17)) {
                    a++;
                }
                if ((hasil[i][j] == 13) || (hasil[i][j] == 23)) {
                    b++;
                }
                if ((hasil[i][j] == 21) || (hasil[i][j] == 33)) {
                    c++;
                }
            }
        }
        double perimeter = (a * 1) + (b * 1.01101) + (c * 1.00110);
        return perimeter;
    }
}
class BinaryImage {

    public int width;
    public int height;
    public int[][] Pixels;

    public BinaryImage(int width, int height) {
        this.width = width;
        this.height = height;
        Pixels = new int[width][height];
    }

    public BinaryImage(int[][] pixels) {
        Pixels = pixels;
        this.width = pixels.length;
        this.height = pixels[0].length;
    }

    public int[][] eroded(BinaryImage structurElement) {
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

    public int[][] boundary(BinaryImage structureElement) {
        int[][] result = eroded(structureElement);
        return minus(new BinaryImage(result));
    }

    public int[][] minus(BinaryImage image) {
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
                if (Pixels[i][j] != 0) {
                    System.out.print("1");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
