/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Morphologi;

/**
 *
 * @author Syem
 */
public class Closing {

    public int width;
    public int height;
    public int Pixel[][];

    public Closing(int[][] pixel) {
        this.width = pixel.length;
        this.height = pixel[0].length;
        this.Pixel = pixel;
    }

    public int[][] closingProses(Closing structureElement) {
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

    public void printResultClosing() {
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
}
