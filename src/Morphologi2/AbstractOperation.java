/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Morphologi2;

import java.awt.image.BufferedImage;

/**
 *
 * @author Syem
 */
public abstract class AbstractOperation implements MorphologicalOperation {

    protected int shapeSize;

    protected short[][] constructShape(STRUCTURING_ELEMENT_SHAPE shape, int shapeSize) {
        int size = 2 * shapeSize + 1;
        short[][] structElem = new short[size][size];
        switch (shape) {
            case SQUARE:
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        structElem[i][j] = 1;
                    }
                }
            case VERTICAL_LINE:
                for (int i = 0; i < size; i++) {
                    structElem[shapeSize][i] = 1;
                }
            case HORIZONTAL_LINE:
                for (int i = 0; i < size; i++) {
                    structElem[shapeSize][i] = 1;
                }
            default:
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        structElem[i][j] = 1;
                    }
                }
        }
        return structElem;
    }
    
    @Override
    public abstract BufferedImage execute(BufferedImage image);
    @Override
    public int getShapeSize(){
       return shapeSize;
    }
}
