package Morphologi;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Syem
 */
public class Erosion {

    public int width;
    public int height;
    public int Pixel[][];

    public Erosion(int[][] pixel) {
        this.width = pixel.length;
        this.height = pixel[0].length;
        this.Pixel = pixel;
    }

    public int[][] erosionProses(Erosion structureElement) {
        int[][] result = new int[width][height];
        int minIndexWidht = structureElement.width / 2;
        int minIndexHeight = structureElement.height / 2;
        int maxIndexWidth = Pixel.length - minIndexWidht;
        int maxIndexHeigth = Pixel[0].length - minIndexHeight;

        for (int i = minIndexWidht; i < maxIndexWidth; i++) {
            for (int j = minIndexHeight; j < maxIndexHeigth; j++) {
                boolean status = true;
                for (int k = 0; k < structureElement.width; k++) {
                    for (int l = 0; l < structureElement.height; l++) {
                        if (Pixel[(i - minIndexWidht) + k][(j - minIndexHeight) + l] != 2) {
                            if (Pixel[(i - minIndexWidht) + k][(j - minIndexHeight) + l] != structureElement.Pixel[k][l]) {
                                status = false;
                                break;
                            }
                        }
                    }
                }
                result[i][j] = status ? 1 : 0;
            }
        }
        return result;
    }

    public void printResultErosion() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (Pixel[i][j] != 0) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

//    public static void main(String[] args) {
////        int[][] dataImage = {
////            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
////            {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
////            {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
////            {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
////            {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
////            {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
////            {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
////            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
////            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
////            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
////            {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
////            {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
////            {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
////            {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
////            {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
////            {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
////            {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
////            {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
////            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
////            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}};
//        int[][] dataImage ={{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
//                              {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
//                              {0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0},
//                              {0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0},
//                              {0,0,1,1,1,1,1,0,0,0,0,1,1,1,0,0},
//                              {0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,0},
//                              {0,0,0,1,1,0,0,0,0,1,1,1,1,1,0,0},
//                              {0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0},
//                              {0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0},
//                              {0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0},
//                              {0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0},
//                              {0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0},
//                              {0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0},
//                              {0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0},
//                              {0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0},
//                              {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
//        
//        
//        int[][] citra_input = {
//            {0, 0, 0, 0, 0, 0, 0, 0},
//            {0, 1, 1, 1, 1, 1, 1, 0},
//            {0, 0, 0, 1, 1, 1, 1, 0},
//            {0, 0, 0, 1, 1, 1, 1, 0},
//            {0, 0, 1, 1, 1, 1, 1, 0},
//            {0, 0, 0, 1, 1, 1, 1, 0},
//            {0, 0, 1, 1, 0, 0, 0, 0},
//            {0, 0, 0, 0, 0, 0, 0, 0}};
//        int[][] dataSE = {
//            {1, 1, 1},
//            {1, 1, 1},
//            {1, 1, 1}
//        };
//
//        Erosion tesImage = new Erosion(citra_input);
//        Erosion structureElement = new Erosion(dataSE);
//        Erosion resultImage = new Erosion(tesImage.erosionProses(structureElement));
//        tesImage.printResultErosion();
//        System.out.println("");
//        resultImage.printResultErosion();
//    }
}
