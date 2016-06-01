/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preprocessing;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *
 * @author USUARIO
 */
public class Utils {
    
    public static BufferedImage binarization(BufferedImage originalImage){
        BufferedImage blackAndWhiteImg = new BufferedImage(
        originalImage.getWidth(), originalImage.getHeight(),
        BufferedImage.TYPE_BYTE_BINARY);

        Graphics2D graphics = blackAndWhiteImg.createGraphics();
        graphics.drawImage(originalImage, 0, 0, null);
        return blackAndWhiteImg;
    }
    
    public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
    
    public static BufferedImage cropper(BufferedImage img){
        int height = img.getHeight();
        int width = img.getWidth();
        int pixel;
        int startX, endX, startY, endY;
        startX = startY = 1000000;
        endX = endY = 0;
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                pixel = img.getRGB(x, y);
            //determine whether the pixel is black or red. if red and firstred == null, assign to firstred. same with black. each red or black pixel read can be assigned to lastred or lastblack as when it's done looping you'll automatically have the last black or red. Also, assign the x and y values to a variable.
                if(pixel!=-1){
                    if(x<startX) startX = x;
                    if(x>endX) endX = x;
                    if(y<startY) startY = y;
                    if(y>endY) endY = y;
                }
                
                //invertir colores
                /*
                if(pixel!=-1)
                    img.setRGB(x,y,-1);
                else
                    img.setRGB(x, y, -16777216);
*/
                //System.out.println("las +"+pixel);
            }
        }
        
        // create a cropped image from the original image
        BufferedImage croppedImage = img.getSubimage(startX, startY, endX-startX, endY-startY);
        
        return croppedImage;
    }
    
}
