/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Binerisasi.OtsuBinarizationThreshold;
import Morphologi.LabelImage;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Syem
 */
public class DeteksiObjek {

//    public static void main(String[] args) throws IOException {
//        BufferedImage imageInput = ImageIO.read(new File("f:/ImagePercobaan/UntitledLabel.png"));
//        WritableRaster rasterInput = imageInput.getRaster();
//        BufferedImage biner = OtsuBinarizationThreshold.binarize(imageInput);
//        BufferedImage imageHasil = new BufferedImage(imageInput.getWidth(), imageInput.getHeight(), BufferedImage.TYPE_INT_RGB);
//        WritableRaster rasterHasil = imageHasil.getRaster();
//        int[][] arrayBiner = DeteksiObjek.bufferToArray(biner);
//        ArrayList list = LabelImage.labelImage(arrayBiner);
//        
//        // Tampung pixel yang sudah dilabel
//        int[][] imageLabeling = (int[][]) list.get(0);
//
//        ArrayList<int[]> arrayList = new ArrayList();
//        arrayList = (ArrayList<int[]>) list.get(1);
//        printArray(imageLabeling);
//        // Tampung nilai dari label
//        int[] array = listToArray(arrayList);
//        int c = 1;
//
//        // Tampung sementara pixel yang sudah dilabel satu persatu
//        int[][] tampLabel = new int[imageInput.getWidth()][imageInput.getHeight()];
//        // Tampung sementara pixel yang sudah diBounding Box satu persatu
//        int[][] boundingBox2 = new int[imageInput.getWidth()][imageInput.getHeight()];
//        // Tampung sementara semua pixel yang sudah diBounding Box
//        int[][] tampBoundingBox = new int[imageInput.getWidth()][imageInput.getHeight()];
//        System.out.println("Jumlah Objek dalam citra: "+array.length);
//        while (c <= array.length) {
//            for (int j = 0; j < imageLabeling.length; j++) {
//                for (int k = 0; k < imageLabeling[0].length; k++) {
//                    if (imageLabeling[j][k] == c) {
//                        tampLabel[j][k] = 100;
//                    }
//                }
//            }
//            // Tampung bounding box dari setaip label
//            boundingBox2 = DeteksiObjek.boundingBox(tampLabel);
//            //printArray(boundingBox2);
//
//            for (int j = 0; j < imageLabeling.length; j++) {
//                for (int k = 0; k < imageLabeling[0].length; k++) {
//                    if (boundingBox2[j][k] == 1) {
//                        // simpan nilai Bounding Box ke penampung sementara
//                        tampBoundingBox[j][k] = 1;
//                        // set nilai Bounding Box menjadi 0 untuk diolah kembali secara satu persatu
//                        boundingBox2[j][k] = 0;
//                    }
//                    if(tampLabel[j][k] == 100){
//                        // set nilai tampLabel menjadi 0 untuk diolah kembali secara satu persatu
//                        tampLabel[j][k] = 0;
//                    }
//                }
//            }
//            c++;
//        }
//        
//        // Proses memasukkan nilai pixel ke image hasil(filterisasi)
//        for (int i = 0; i < imageLabeling.length; i++) {
//            for (int j = 0; j < imageLabeling[0].length; j++) {
//                if (tampBoundingBox[i][j] == 1) {
//                    rasterHasil.setSample(i, j, 0, 0);
//                    rasterHasil.setSample(i, j, 1, 0);
//                    rasterHasil.setSample(i, j, 2, 255);
//                }else{
//                    rasterHasil.setSample(i, j, 0, rasterInput.getSample(i, j, 0));
//                    rasterHasil.setSample(i, j, 1, rasterInput.getSample(i, j, 1));
//                    rasterHasil.setSample(i, j, 2, rasterInput.getSample(i, j, 2)); 
//                }
//            }
//        }
//
//        ImageIO.write(imageHasil, "JPG", new File("f:/ImagePercobaan/UntitledLabelBoundingBox.jpg"));
//    }
    // Konversi dari tipe bufferedimage ke array
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
    // Konversi dari tipe list ke array
    public static int[] listToArray(ArrayList<int[]> arrayList) {
        int[] data = new int[arrayList.size()];

        for (int j = 0; j < data.length; j++) {
            Object b = arrayList.get(j);
            String c = b.toString();
            int d = Integer.parseInt(c);
            data[j] = d;
        }

        return data;
    }
    // cetak nilai array untuk analisis hasil
    public static void printArray(int[][] image) {

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
    // mendapatkan nilai bounding box[(minX, minY), (maxY, minY), (minX, maxY), (maxX, maxY)]
    public static int[][] boundingBox(int[][] statusLabeled) {
        int tepiMinX = statusLabeled[0].length;
        int tepiMaxX = 0;
        int tepiMinY = statusLabeled.length;
        int tepiMaxY = 0;
        //System.out.println("I   J   TepiMinX    TepiMaxX    TepiMinY    TepiMaxY");
        int[][] filter = new int[statusLabeled.length][statusLabeled[0].length];
        for (int i = 0; i < filter.length; i++) {
            for (int j = 0; j < filter[0].length; j++) {
                filter[i][j] = 0;
                if (statusLabeled[i][j] == 100) {
                    if (i > tepiMaxX) {
                        tepiMaxX = i;
                    } 
                    if (i < tepiMinX) {
                        tepiMinX = i;
                    } 
                    if (j > tepiMaxY) {
                        tepiMaxY = j;
                    } 
                    if (j < tepiMinY) {
                        tepiMinY = j;
                    }
                    //System.out.print(i+"    "+j+"    "+tepiMinX+"            "+tepiMaxX+"            "+tepiMinY+"            "+tepiMaxY+"\n"); 
                }
            }
        }
        for (int i = tepiMinX; i < tepiMaxX; i++) {
            filter[i][tepiMinY] = 1;
            filter[i][tepiMaxY] = 1;
        }
        for (int i = tepiMinY; i < tepiMaxY; i++) {
            filter[tepiMinX][i] = 1;
            filter[tepiMaxX][i] = 1;
        }

        return filter;
    }
}
