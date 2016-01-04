/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Morphologi2;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

/**
 *
 * @author Syem
 */
public class ErosionBufferInput extends AbstractOperation{
    private short[][] structElem;
    private STRUCTURING_ELEMENT_SHAPE shape;
    
    public ErosionBufferInput(){
        shapeSize = 2;
        shape = STRUCTURING_ELEMENT_SHAPE.SQUARE;
        this.structElem = constructShape(shape, shapeSize);        
    }
    
    public ErosionBufferInput(STRUCTURING_ELEMENT_SHAPE shape, int shapeSize){
        this.shape = shape;
        super.shapeSize = shapeSize;
        this.structElem = constructShape(shape, shapeSize);
    }
    
    @Override
    public BufferedImage execute(BufferedImage image) {
        if(image.getType() != BufferedImage.TYPE_BYTE_GRAY)
            throw new IllegalArgumentException("the image bust be of type TYPE_BYTE_GRAY");
        
        BufferedImage erodedImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        
        int sSize = 2 * shapeSize + 1;
        byte[] window = null;
        int newValue = 0;
        
        int imgWidth = image.getWidth();
        int imgHeight = image.getHeight();
        int filterWidth = imgWidth - sSize;
        int filterHeight = imgHeight - sSize;
        int lowerSide = imgHeight - shapeSize;
        int rightSide = imgWidth - shapeSize;
        Raster oldData = image.copyData(null);
        WritableRaster newData = erodedImage.getRaster();
        
        // Tengah
        for (int x = 0; x <= filterWidth; x++) {
            for (int y = 0; y <= filterHeight; y++) {
                window = (byte[]) oldData.getDataElements(x, y, sSize, sSize, null);
                newValue = min(window);
                newData.setSample(x + shapeSize, y + shapeSize, 0, newValue);                              
            }            
        }
        
        // Kiri
        for (int x = 0; x < shapeSize; x++) {
            for (int y = 0; y <= filterHeight; y++) {
                window = (byte[]) oldData.getDataElements(x, y, sSize, sSize, null);
                newValue = min(window);
                newData.setSample(x, y + shapeSize, 0, newValue);                              
            }            
        }
        
        newData.setSamples(0, lowerSide, shapeSize, shapeSize, 0, fillArray(shapeSize * shapeSize, newValue));
        window = (byte[]) oldData.getDataElements(0, 0, sSize, sSize, null);
        newValue = min(window);
        newData.setSamples(0, 0, shapeSize, shapeSize, 0, fillArray(shapeSize * shapeSize, newValue));
        
        // Kanan
        for (int x = rightSide; x < imgWidth; x++) {
            for (int y = 0; y <= filterHeight; y++) {
                window = (byte[]) oldData.getDataElements(filterWidth, y, sSize, sSize, null);
                newValue = min(window);
                newData.setSample(x, y + shapeSize, 0, newValue);                              
            }            
        }
        newData.setSamples(rightSide, lowerSide, shapeSize, shapeSize, 0, fillArray(shapeSize * shapeSize, newValue));
        
        // Dibawah
        for (int y = lowerSide - 1; y < imgHeight; y++) {
            for (int x = 0; x <= filterWidth; x++) {
                window = (byte[]) oldData.getDataElements(x, filterHeight, sSize, sSize, null);
                newValue = min(window);
                newData.setSample(x + shapeSize, y, 0, newValue);                              
            }            
        }
        
        // Diatas
        for (int y = 0; y < shapeSize; y++) {
            for (int x = 0; x <= filterWidth; x++) {
                window = (byte[]) oldData.getDataElements(x, 0, sSize, sSize, null);
                newValue = min(window);
                newData.setSample(x + shapeSize, y, 0, newValue);                              
            }            
        }
        
        newData.setSamples(rightSide, 0, shapeSize, shapeSize, 0, fillArray(shapeSize * shapeSize, newValue));
        return erodedImage;
    }
    
    final public int min(byte[] val){
        int min = 256;
        int end = val.length;
        int v = 0;
        
        for (int i = 0; i < end; i++) {
            if(val[i] < 0)   
                v = 256 + val[i];
            else
                v = val[i];
            if(v < min)
                min = v;            
        }
        return min;
    }
    
    final private int[] fillArray(int length, int value){
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = value;             
        }
        return arr;
    }
    
}
