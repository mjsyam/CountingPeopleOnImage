/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DeteksiWajah;

import Morphologi.Erosion;
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
/*
- pakai metode tinggi dan lebar untuk membandingakna antara objek wajah dan objek yang lain
- sample inputan pakai tari saman
- minimal 40 lembar untuk laporan
 * ==>
 */
public class Main {

//    public static void main(String[] args) throws IOException {
//        // Structure Element untuk proses dilatasi, erosi dan closing;
//        int[][] dataSE = {
//            {1, 1, 1},
//            {1, 1, 1},
//            {1, 1, 1}
//        };
//
//        BufferedImage imageInput = ImageIO.read(new File("f:/ImagePercobaan/Untitled_2.jpg"));
//        BufferedImage imageResult = new BufferedImage(imageInput.getWidth(), imageInput.getHeight(), BufferedImage.TYPE_INT_RGB);
//        WritableRaster rasterInput = imageInput.getRaster();
//        WritableRaster rasterResult = imageResult.getRaster();
//
//        // proses deteksi kulit
//        int[][] kulit = DeteksiKulit.deteksiKulit(imageInput);
//        // proses menghilangkan noise area pada citra
//        int[][] kulit2 = RemoveNoise.removeNoise(kulit);
//        //proses erosion
//        Erosion imageErosion = new Erosion(kulit2);
//        Erosion seErosion = new Erosion(dataSE);
//        Erosion resultImageErosion = new Erosion(imageErosion.erosionProses(seErosion));
//        int[][] resultIE = resultImageErosion.Pixel;
//        // tampung image yang sudah di-Label dan status labelnya
//        ArrayList list = LabelImage.labelImage(resultIE);
//
//        //perhitungan area setiap wilayah label
//        ArrayList listArea = area(list);
//        ArrayList<int[]> arrayListArea = (ArrayList<int[]>) listArea.get(1);
//        int[] arrayArea = listToArray(arrayListArea);
//
//        //Mendapatkan lebar dan tinggi setiap wilayah label
//        ArrayList lebarTinggiList = lebarTinggiRegion(list);
//        ArrayList<int[]> arrayListIndexLebel = (ArrayList<int[]>) lebarTinggiList.get(0);
//        ArrayList<int[]> arrayListValueLebar = (ArrayList<int[]>) lebarTinggiList.get(1);
//        ArrayList<int[]> arrayListValueTinggi = (ArrayList<int[]>) lebarTinggiList.get(2);
//        int[] arrayIndexLabel = listToArray(arrayListIndexLebel);
//        int[] arrayLebar = listToArray(arrayListValueLebar);
//        int[] arrayTiggi = listToArray(arrayListValueTinggi);
//        System.out.println("Label   Luas   Lebar   Tinggi");
//        System.out.println(arrayIndexLabel.length);
//        for (int i = 0; i < arrayIndexLabel.length; i++) {
//            System.out.println(arrayIndexLabel[i] + ".       " + arrayArea[i] + "       " + arrayLebar[i] + "       " + arrayTiggi[i]);
//        }
//        System.out.println();        
//        
//// Perhitungan/proses secara ke-seluruhan 
//        //Tampung pixel yang sudah dilabel
//        int[][] imageLabeling = (int[][]) list.get(0);
//
//        ArrayList<int[]> arrayList = new ArrayList();
//        arrayList = (ArrayList<int[]>) list.get(1);
//        //printArray(imageLabeling);
//        // Tampung nilai dari label
//        int[] array = listToArray(arrayList);
//        int label = 1;
//
//        // Tampung sementara pixel yang sudah dilabel satu persatu
//        int[][] tampLabel = new int[imageInput.getWidth()][imageInput.getHeight()];
//        // Tampung sementara pixel yang sudah diBounding Box satu persatu
//        int[][] boundingBox2 = new int[imageInput.getWidth()][imageInput.getHeight()];
//        // Tampung sementara semua pixel yang sudah diBounding Box
//        int[][] tampBoundingBox = new int[imageInput.getWidth()][imageInput.getHeight()];
//        int jumlahWajah = 0;
//        int indexLabel = 0;
//        while (label <= array.length) {
//            if ((arrayArea[indexLabel] > 350)&&(arrayArea[indexLabel] < 2000)) {
//                float lebar = arrayLebar[indexLabel];
//                float tinggi = arrayTiggi[indexLabel];
//                float perbandinganLebarTinggi = lebar / tinggi;
//                //System.out.println(label + ". " + perbandinganLebarTinggi);
//                if ((perbandinganLebarTinggi > 0.4) && (perbandinganLebarTinggi < 1)) {
//                    System.out.println(label +"    "+arrayArea[indexLabel]+"       "+lebar+"     "+ tinggi+"    " + perbandinganLebarTinggi);
//                    jumlahWajah++;
//                    for (int j = 0; j < imageLabeling.length; j++) {
//                        for (int k = 0; k < imageLabeling[0].length; k++) {
//                            if (imageLabeling[j][k] == label) {
//                                tampLabel[j][k] = 100;
//                            }
//                        }
//                    }
//                    // Tampung bounding box dari setaip label
//                    boundingBox2 = boundingBox(tampLabel);
//                    //printArray(boundingBox2);
//
//                    for (int j = 0; j < imageLabeling.length; j++) {
//                        for (int k = 0; k < imageLabeling[0].length; k++) {
//                            if (boundingBox2[j][k] == 1) {
//                                // simpan nilai Bounding Box ke penampung sementara
//                                tampBoundingBox[j][k] = 1;
//                                // set nilai Bounding Box menjadi 0 untuk diolah kembali secara satu persatu
//                                boundingBox2[j][k] = 0;
//                            }
//                            if (tampLabel[j][k] == 100) {
//                                // set nilai tampLabel menjadi 0 untuk diolah kembali secara satu persatu
//                                tampLabel[j][k] = 0;
//                            }
//                        }
//                    }
//                }
//            }
//
//            label++;
//            indexLabel++;
//        }
//        System.out.println("Jumlah Objek dalam citra: " + jumlahWajah);
//
//        // Proses memasukktan nilai pixel ke image hasil(filterisasi)
//        for (int i = 0; i < imageLabeling.length; i++) {
//            for (int j = 0; j < imageLabeling[0].length; j++) {
//                if (tampBoundingBox[i][j] == 1) {
//                    rasterResult.setSample(i, j, 0, 255);
//                    rasterResult.setSample(i, j, 1, 0);
//                    rasterResult.setSample(i, j, 2, 0);
//                } else {
//                    rasterResult.setSample(i, j, 0, rasterInput.getSample(i, j, 0));
//                    rasterResult.setSample(i, j, 1, rasterInput.getSample(i, j, 1));
//                    rasterResult.setSample(i, j, 2, rasterInput.getSample(i, j, 2));
//                }
//            }
//        }
//        ImageIO.write(imageResult, "JPG", new File("f:/ImagePercobaan/Untitled_222.jpg"));
//    }
    
    // Konversi dari tipe buffer ke array
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
    // Konversi dari tipe array ke buffer

    public static BufferedImage arrayToBuffer(int[][] image) {
        BufferedImage image1 = new BufferedImage(image.length, image[0].length, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster = image1.getRaster();
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                raster.setSample(i, j, 0, image[i][j]);
            }
        }
        return image1;
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

    // mendapatkan lebar dan tiggi tiap-tiap wilayah label 
    public static ArrayList lebarTinggiRegion(ArrayList imageLabel) {
        ArrayList tinggiValue = new ArrayList();
        ArrayList lebarValue = new ArrayList();
        ArrayList labelIndex = new ArrayList();

        // Tampung pixel yang sudah dilabel
        int[][] imageLabeling = (int[][]) imageLabel.get(0);

        ArrayList<int[]> arrayList = (ArrayList<int[]>) imageLabel.get(1);

        // Tampung nilai dari label
        int[] array = listToArray(arrayList);
        int c = 1;

        // Tampung sementara pixel yang sudah dilabel satu persatu
        int[][] statusLabeled = new int[imageLabeling.length][imageLabeling[0].length];
        // Tiggi dari masing-masing region


        while (c <= array.length) {
            for (int j = 0; j < imageLabeling.length; j++) {
                for (int k = 0; k < imageLabeling[0].length; k++) {
                    if (imageLabeling[j][k] == c) {
                        statusLabeled[j][k] = 100;
                    }
                }
            }

            int tepiMinX = statusLabeled[0].length;
            int tepiMaxX = 0;
            int tepiMinY = statusLabeled.length;
            int tepiMaxY = 0;
            for (int i = 0; i < statusLabeled.length; i++) {
                for (int j = 0; j < statusLabeled[0].length; j++) {
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
                    }
                }
            }

            for (int i = 0; i < statusLabeled.length; i++) {
                for (int j = 0; j < statusLabeled[0].length; j++) {
                    if (statusLabeled[i][j] == 100) {
                        statusLabeled[i][j] = 0;
                    }
                }
            }

            int lebarRegion = (int) Math.sqrt((Math.pow((tepiMaxX - tepiMinX), 2)) + (Math.pow((tepiMinY - tepiMinY), 2)));
            int tinggiRegion = (int) Math.sqrt((Math.pow((tepiMinX - tepiMinX), 2)) + (Math.pow((tepiMaxY - tepiMinY), 2)));

            labelIndex.add(c);
            lebarValue.add(lebarRegion);
            tinggiValue.add(tinggiRegion);
            c++;
        }
        ArrayList listLebarTinggi = new ArrayList();
        listLebarTinggi.add(labelIndex);
        listLebarTinggi.add(lebarValue);
        listLebarTinggi.add(tinggiValue);

        return listLebarTinggi;

    }    
    
    // Luas Masing2 wilayah label
    public static ArrayList area(ArrayList imageLabel) {

        ArrayList areaValue = new ArrayList();
        ArrayList labelIndex = new ArrayList();

        // Tampung pixel yang sudah dilabel
        int[][] imageLabeling = (int[][]) imageLabel.get(0);

        ArrayList<int[]> arrayList = (ArrayList<int[]>) imageLabel.get(1);

        // Tampung nilai dari label
        int[] array = listToArray(arrayList);
        int c = 1;

        // Tampung sementara pixel yang sudah dilabel satu persatu
        int[][] tampLabel = new int[imageLabeling.length][imageLabeling[0].length];

        int area = 1;
        while (c <= array.length) {
            for (int j = 0; j < imageLabeling.length; j++) {
                for (int k = 0; k < imageLabeling[0].length; k++) {
                    if (imageLabeling[j][k] == c) {
                        area++;
                    }
                }
            }
            // Tampung area dari setaip label
            areaValue.add(area);
            labelIndex.add(c);
            area = 0;
            c++;
        }
        ArrayList listArea = new ArrayList();
        listArea.add(labelIndex);
        listArea.add(areaValue);
        return listArea;
    }
}
