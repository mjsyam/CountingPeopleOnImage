/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Morphologi;


import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Syem
 */
public class LabelImage {

    static int[][] label;
    static Stack stack;

    public LabelImage() {
    }
    
    // Data Inputan(img) berupa citra/bilangan biner [0 1] 
    public static ArrayList labelingPixel(int[][] img) {
        int nrow = img.length;
        int ncol = img[0].length;
        int lab = 1;
        int[] pos;
        ArrayList listJmlhLabel = new ArrayList();
        stack = new Stack();
        label = new int[nrow][ncol];
        for (int r = 1; r < nrow - 1; r++) {
            for (int c = 1; c < ncol - 1; c++) {
                if (img[r][c] == 0) {
                    continue;
                }
                if (label[r][c] > 0) {
                    continue;
                }

                stack.push(new int[]{r, c});
                label[r][c] = lab;

                while (!stack.isEmpty()) {
                    pos = (int[]) stack.pop();
                    int i = pos[0];
                    int j = pos[1];

                    if (img[i - 1][j - 1] == 1 && label[i - 1][j - 1] == 0) {
                        stack.push(new int[]{i - 1, j - 1});
                        label[i - 1][j - 1] = lab;
                    }
                    if (img[i - 1][j] == 1 && label[i - 1][j] == 0) {
                        stack.push(new int[]{i - 1, j});
                        label[i - 1][j] = lab;
                    }
                    if (img[i - 1][j + 1] == 1 && label[i - 1][j + 1] == 0) {
                        stack.push(new int[]{i - 1, j + 1});
                        label[i - 1][j + 1] = lab;
                    }
                    if (img[i][j - 1] == 1 && label[i][j - 1] == 0) {
                        stack.push(new int[]{i, j - 1});
                        label[i][j - 1] = lab;
                    }
                    if (img[i][j + 1] == 1 && label[i][j + 1] == 0) {
                        stack.push(new int[]{i, j + 1});
                        label[i][j + 1] = lab;
                    }
                    if (img[i + 1][j - 1] == 1 && label[i + 1][j - 1] == 0) {
                        stack.push(new int[]{i + 1, j - 1});
                        label[i + 1][j - 1] = lab;
                    }
                    if (img[i + 1][j] == 1 && label[i + 1][j] == 0) {
                        stack.push(new int[]{i + 1, j});
                        label[i + 1][j] = lab;
                    }
                    if (img[i + 1][j + 1] == 1 && label[i + 1][j + 1] == 0) {
                        stack.push(new int[]{i + 1, j + 1});
                        label[i + 1][j + 1] = lab;
                    }
                }
                listJmlhLabel.add(lab);
                lab++;
            }
        }
        ArrayList list = new ArrayList();
        list.add(label);
        list.add(listJmlhLabel);
        return list;
    }
}
