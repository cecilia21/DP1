/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import dyimagefx.*;
import dyimagefx.morph.Skeletonization;

/**
 *
 * @author USUARIO
 */
public class Algoritmos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int imageHeight, imageWidth;
        // TODO code application logic here
        //lectura de imagen
        File file = new File("C:/Users/USUARIO/Documents/dp1/firma1.jpg");
        BufferedImage originalImage,original,test;
        try {
            originalImage = ImageIO.read(file);
            //extraemos altura y ancho inicial
            imageHeight = originalImage.getHeight();
            imageWidth = originalImage.getWidth();
                    
            // empezamos con la binarizacion
            BufferedImage blackAndWhiteImg = binarization(originalImage);
            
            //empezamos con el croppeado
            BufferedImage cropped = cropper(blackAndWhiteImg, imageHeight, imageWidth);
            ImageIO.write(cropped, "jpg", new File("C:/Users/USUARIO/Documents/dp1/firma1crop.jpg"));
            
            //skeletonization y thinning
            MyImage img = new MyImage();
            img.readImage("C:/Users/USUARIO/Documents/dp1/firma1crop.jpg");
            Skeletonization.binaryImage(img);
            img.writeImage("C:/Users/USUARIO/Documents/dp1/firma1skeleton.jpg");
            
            /*
            
            int[][] imgbin= new int[50][50];
            int pix;
            for(int i=0;i<50;i++)
                for(int j=0;j<50;j++){
                    pix=originalImage.getRGB(i, j);
                    if(pix==-1)
                    imgbin[i][j]=0; 
                    else {
                        imgbin[i][j]=1;
                        //System.out.println(""+pix);
                    }
                }
            ThinningService ut = new ThinningService();
            ut.doZhangSuenThinning(imgbin, true);
            */
            
            //metodo de pixeles
            File or_file = new File("C:/Users/USUARIO/Documents/dp1/firma1.jpg");
            original = ImageIO.read(or_file);
            File test_file = new File("C:/Users/USUARIO/Documents/dp1/firma1.jpg");
            test = ImageIO.read(test_file);
            int percentage = pixel_comparison(original,test);
            
        } catch (IOException ex) {
             System.out.println("fuelavida");
            Logger.getLogger(Algoritmos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int pixel_comparison(BufferedImage original, BufferedImage test){
        int m,n,p,porc = 0;
        int height = original.getHeight();
        int width = original.getWidth();
        int t_pixel, o_pixel;
        m=n=p=0;
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                t_pixel = test.getRGB(x, y);
                o_pixel = original.getRGB(x,y);
                if(t_pixel==-1){//si es blanco el color del pixel (como lo invertimos, el fondo es negro)
                    if(t_pixel==o_pixel) m++;
                    else n++;
                    p++;
                }
            }
        }
        porc = m/(n+p);
        return porc;
    }
    
    public static BufferedImage binarization(BufferedImage originalImage){
        BufferedImage blackAndWhiteImg = new BufferedImage(
        originalImage.getWidth(), originalImage.getHeight(),
        BufferedImage.TYPE_BYTE_BINARY);

        Graphics2D graphics = blackAndWhiteImg.createGraphics();
        graphics.drawImage(originalImage, 0, 0, null);
        return blackAndWhiteImg;
        /*
        try { 
            //ImageIO.write(blackAndWhiteImg, "jpg", new File("C:/Users/USUARIO/Documents/dp1/firma1byn.jpg"));
            
        } catch (IOException ex) {
            return null;
            //Logger.getLogger(Algoritmos.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    public static BufferedImage cropper(BufferedImage img, int height, int width) throws IOException{
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
                if(pixel!=-1)
                    img.setRGB(x,y,-1);
                else
                    img.setRGB(x, y, -16777216);

                //System.out.println("las +"+pixel);
            }
        }
        
        // create a cropped image from the original image
        BufferedImage croppedImage = img.getSubimage(startX, startY, endX-startX, endY-startY);
        
        return croppedImage;
    }
}
