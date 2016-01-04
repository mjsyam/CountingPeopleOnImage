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
public interface MorphologicalOperation {
    public enum STRUCTURING_ELEMENT_SHAPE{
        SQUARE, 
        VERTICAL_LINE, 
        HORIZONTAL_LINE, 
        CIRCLE
    }
    
    public BufferedImage execute(BufferedImage image);
    public int getShapeSize();
}
