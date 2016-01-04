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
public class BoundaryDetectionAsli {

    public static void main(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(new File("f:/ImagePercobaan/Untitled_2.jpg"));
        WritableRaster rasterI = image.getRaster();
        BufferedImage biner = OtsuBinarizationThreshold.binarize(image);
        System.out.println(image.getType());
        int[][] dataImage2 = BoundaryDetectionAsli.bufferToArray(biner);

        int[][] dataSE = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };

        BinaryImageBoundary tesImage = new BinaryImageBoundary(dataImage2);
        BinaryImageBoundary structureElement = new BinaryImageBoundary(dataSE);
        BinaryImageBoundary resultImage = new BinaryImageBoundary(tesImage.boundary(structureElement));
        
        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);        
        WritableRaster rasterR = result.getRaster();

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                if (resultImage.Pixels[i][j] == 1) {
                    rasterR.setSample(i, j, 0, 255);
                } else {
                    rasterR.setSample(i, j, 0, rasterI.getSample(i, j, 1));
                    rasterR.setSample(i, j, 1, rasterI.getSample(i, j, 1));
                    rasterR.setSample(i, j, 2, rasterI.getSample(i, j, 2));
                }
            }
        }
        ImageIO.write(result, "jpg", new File("f:/ImagePercobaan/ContohChainerosionDataTraining510.png"));
        
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
    

}
class BinaryImageBoundary {

    public int width;
    public int height;
    public int[][] Pixels;

    public BinaryImageBoundary(int width, int height) {
        this.width = width;
        this.height = height;
        Pixels = new int[width][height];
    }

    public BinaryImageBoundary(int[][] pixels) {
        Pixels = pixels;
        this.width = pixels.length;
        this.height = pixels[0].length;
    }

    public int[][] eroded(BinaryImageBoundary structurElement) {
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

    public int[][] boundary(BinaryImageBoundary structureElement) {
        int[][] result = eroded(structureElement);
        return minus(new BinaryImageBoundary(result));
    }

    public int[][] minus(BinaryImageBoundary image) {
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
