/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preprocessing;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author USUARIO
 */
public class Utils {
    private static String tesseract = "src\\red\\Tesseract-OCR";
    private static String carpeta_temp = "src\\red\\";
    
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
        //startX = startY = 1000000;
        startX= img.getWidth();
        startY = img.getHeight();
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
        if(endX<=startX) return img;
        if(endY<=startY) return img;
        // create a cropped image from the original image
        BufferedImage croppedImage = img.getSubimage(startX, startY, endX-startX, endY-startY);
        
        return croppedImage;
    }
    
    public static String executeTesseract(String file) throws IOException{
        Runtime rt = Runtime.getRuntime();
        //rt.exec("cd "+tesseract);
        String[] commands = {tesseract+"\\tesseract",carpeta_temp+""+file, "stdout", "letters"};
        Process proc = rt.exec(commands);

        BufferedReader stdInput = new BufferedReader(new 
             InputStreamReader(proc.getInputStream()));

        // read the output from the command
        //System.out.println("Here is the standard output of the command:\n");
        String s = null;
        String total = "";
        while ((s = stdInput.readLine()) != null) {
            //System.out.println(s);
            total += " "+s;
        }
        return total;
    }
    
    public static String executeTesseractNumbers(String file) throws IOException{
        Runtime rt = Runtime.getRuntime();
        //rt.exec("cd "+tesseract);
        String[] commands = {tesseract+"\\tesseract",carpeta_temp+""+file, "stdout", "digits"};
        Process proc = rt.exec(commands);

        BufferedReader stdInput = new BufferedReader(new 
             InputStreamReader(proc.getInputStream()));

        // read the output from the command
        //System.out.println("Here is the standard output of the command:\n");
        String s = null;
        String total = "";
        while ((s = stdInput.readLine()) != null) {
            //System.out.println(s);
            total += " "+s;
        }
        return total;
    }
    
    public static BufferedImage removeNoisePoints(BufferedImage img){
        for(int i=0;i<img.getWidth();i++){
            for(int j=0;j<img.getHeight();j++){
                int negros=0;
                if(i+1<img.getWidth() && img.getRGB(i+1, j)==-16777216) negros++;
                if(i+1<img.getWidth() && j-1>=0 && img.getRGB(i+1, j-1)== -16777216) negros++;
                if(j-1>=0 && img.getRGB(i, j-1)== -16777216) negros++;
                if(i-1>=0 && j-1>=0 && img.getRGB(i-1, j-1)== -16777216) negros++;
                if(i-1>=0 && img.getRGB(i-1, j)== -16777216)negros++;
                if(i-1>=0 && j+1<img.getHeight() && img.getRGB(i-1, j+1)==-16777216)negros++;
                if(j+1<img.getHeight() && img.getRGB(i, j+1)==-16777216)negros++;
                if(i+1<img.getWidth() && j+1<img.getHeight() && img.getRGB(i+1, j+1)==-16777216)negros++;
                if(negros<=2) img.setRGB(i, j, -1);
            }
        }
        return img;
    }
    
    public static BufferedImage limpiarBordeImagen(BufferedImage numero1, int proporcionX, int proporcionY){
        if(proporcionX ==-1) proporcionX = 1;
        if(proporcionY ==-1) proporcionY = 1;
        int inicioY, inicioX, finY, finX;
        inicioY = 0;
        for(int i=0;i<numero1.getHeight()/proporcionY;i++){
            for(int j=0;j<numero1.getWidth();j++){
                if(numero1.getRGB(j, i)!=-16777216) break;
                if(j==numero1.getWidth()-1) inicioY = i+1;
            }
        }

        finY = numero1.getHeight()-1;
        for(int i=numero1.getHeight()-1;i>(numero1.getHeight()-(numero1.getHeight()/proporcionY));i--){
            for(int j=0;j<numero1.getWidth();j++){
                if(numero1.getRGB(j, i)!=-16777216) break;
                if(j==numero1.getWidth()-1) finY = i-1;
            }
        }

        inicioX = 0;
        for(int i=0;i<numero1.getWidth()/proporcionX;i++){
            int blancos = 0;
            for(int j=0;j<numero1.getHeight();j++){
                if(numero1.getRGB(i, j)!=-16777216){
                    blancos++;
                    if(blancos > 0.5*numero1.getHeight())
                        break;
                }
                if(j+1==numero1.getHeight()) inicioX = i+1;
            }
        }

        finX = numero1.getWidth()-1;
        for(int i=numero1.getWidth()-1;i>(numero1.getWidth()-(numero1.getWidth()/proporcionX));i--){
            for(int j=0;j<numero1.getHeight();j++){
                if(numero1.getRGB(i, j)!=-16777216) break;
                if(j==numero1.getHeight()-1) finX = i-1;
            }
        }
        return numero1.getSubimage(inicioX, inicioY, (finX-inicioX), (finY-inicioY));
    }
}
