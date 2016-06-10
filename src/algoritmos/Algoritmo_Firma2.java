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
import java.awt.Color;
import preprocessing.ThinningService;

/**
 *
 * @author Raul
 */
public class Algoritmo_Firma2 {
 
    public static void validarFirma(BufferedImage originalImage1,BufferedImage originalImage2){
        

                        
            double [] vector1 = new double[5];
            double [] vector2 = new double[5];
            BufferedImage processedImage1,processedImage2;
            double acumulado, porcentaje;
            int contador;
                        
            //Image1
            processedImage1=preproceso(originalImage1);
            extractionCharacteristic(processedImage1,vector1);
            //Image2
            processedImage2=preproceso(originalImage2);
            extractionCharacteristic(processedImage2,vector2);         
                               
            acumulado=0.0;
            contador=0;

            if(vector1[3]<0 && vector2[3]<0){
                vector1[3]=vector1[3]*(-1);
                vector2[3]=vector2[3]*(-1);
            }
                  
            for(int i=0;i<5;i++){
                if(vector1[i]!=0 && vector2[i]!=0){                            
                    if(vector1[i]>vector2[i]){
                        porcentaje=vector2[i]/vector1[i];
                        if(porcentaje>0)
                            acumulado+=porcentaje;
        //                        System.out.println(vector2[i]/vector1[i]);
                    }
                    else if(vector1[i]==vector2[i]){
                        acumulado+=1;   
                    }
                    else{
                        porcentaje=(vector1[i]-(vector2[i]-vector1[i]))/vector1[i];
                        if(porcentaje>0 && ((vector1[i] * vector2[i] )>0))
                            acumulado+=porcentaje;     
//                        System.out.println((vector1[i]-(vector2[i]-vector1[i]))/vector1[i]);
                    }
                    contador++;                           
                }                   
            }
            acumulado=acumulado/contador;
//            System.out.println("Porcentaje de similitud: "+ acumulado*100 +"% \n" + contador);
//            System.out.print(acumulado*100 + ",");
            acumulado=acumulado*100;
            if(75<acumulado)
                System.out.println("Firma válida: " + acumulado);
            else if(65<acumulado)
                System.out.println("Firma en revisión: " + acumulado);
            else
                System.out.println("Firma no válida: " + acumulado);
//                System.out.println();               
                          
        
    }
    
    
    
    public static void main(String[] args) {

        try {
            //Lectura de Imagen
            File file1 = new File("C:/Users/Raul/Desktop/f025.jpg");           
            File file2 = new File("C:/Users/Raul/Desktop/firma.jpg");
                        
            double [] vector1 = new double[5];
            double [] vector2 = new double[5];
            BufferedImage originalImage1, processedImage1,originalImage2, processedImage2;
            double acumulado, porcentaje;
            int contador;
                        
            //Image1
            originalImage1 = ImageIO.read(file1);
            processedImage1=preproceso(originalImage1);
            extractionCharacteristic(processedImage1,vector1);
            //Image2
            originalImage2 = ImageIO.read(file2);
            processedImage2=preproceso(originalImage2);
            extractionCharacteristic(processedImage2,vector2);         
                               
            acumulado=0.0;
            contador=0;

            if(vector1[3]<0 && vector2[3]<0){
                vector1[3]=vector1[3]*(-1);
                vector2[3]=vector2[3]*(-1);
            }
                  
            for(int i=0;i<5;i++){
                if(vector1[i]!=0 && vector2[i]!=0){                            
                    if(vector1[i]>vector2[i]){
                        porcentaje=vector2[i]/vector1[i];
                        if(porcentaje>0)
                            acumulado+=porcentaje;
        //                        System.out.println(vector2[i]/vector1[i]);
                    }
                    else if(vector1[i]==vector2[i]){
                        acumulado+=1;   
                    }
                    else{
                        porcentaje=(vector1[i]-(vector2[i]-vector1[i]))/vector1[i];
                        if(porcentaje>0 && ((vector1[i] * vector2[i] )>0))
                            acumulado+=porcentaje;     
//                        System.out.println((vector1[i]-(vector2[i]-vector1[i]))/vector1[i]);
                    }
                    contador++;                           
                }                   
            }
            acumulado=acumulado/contador;
//            System.out.println("Porcentaje de similitud: "+ acumulado*100 +"% \n" + contador);
            System.out.print(acumulado*100 + ",");
            if(75<acumulado)
                System.out.print("Firma válida");
            else
                System.out.print("Firma no válida");
//                System.out.println();
                
                        
        } catch (IOException ex) {
            System.out.println("#FueLaVida");
            Logger.getLogger(Algoritmos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public static void imprimirV(double vector[]){
       for(int i=0;i<5;i++)
            System.out.print(vector[i] + ",");
       System.out.println();
    }
    
    
    public static void extractionCharacteristic(BufferedImage processedImage, double vector[]){
        double char4,char5,char7,char8,char10,char11;
        int char1_H,char2_W,char3_1,char3_2,char6_X,char6_Y,char9,contador;
        //Solo voy a utilizar char4,char5,char7,char8,char10

        //Caracteristica 1: Actual Height
        char1_H=processedImage.getHeight();
        
        //Caracteristica 2: Actual Width
        char2_W=processedImage.getWidth();
        
        //Caracteristica 3: Maximum horizontal and vertical histogram
        char3_1=0;char3_2=0;
        int pixelTotal=0;//Utilizado para el char4
        contador=0;
        for(int y=0;y<char1_H;y++){
            for(int x=0;x<char2_W;x++)
                if (processedImage.getRGB(x, y) == Color.black.getRGB())
                    contador++;
            if (contador>char3_1) char3_1=contador;
            pixelTotal+=contador;
            contador=0;
        }
        contador=0;
        for(int x=0;x<char2_W;x++){
            for(int y=0;y<char1_H;y++)
                if (processedImage.getRGB(x, y) == Color.black.getRGB())
                    contador++;
            if (contador>char3_2) char3_2=contador;
//            pixelTotal+=contador;
            contador=0;
        }
        //Caracteristica 4: Normalized Area of signature
        char4=(double)pixelTotal/(char1_H*char2_W);
        
        //Caracteristica 5: Aspect Ratio
        char5=(double)char2_W/char1_H;
        
        //Caracteristica 6: Centroid       
        int acumx=0,acumy=0;
        contador=0;
        for(int y=0;y<char1_H;y++){
            for(int x=0;x<char2_W;x++)
                if (processedImage.getRGB(x, y) == Color.WHITE.getRGB()){
                    acumx+=x;
                    acumy+=y;
                    contador+=1;
                }      
        }
        char6_X=(int) Math.round((double)acumx/contador);
        char6_Y=(int) Math.round((double)acumy/contador);
        
        //Caracteristica 7: Ratio of Signature Occupancy of each half
        int pixel_l=0,pixel_r=0;
        for(int y=0;y<char1_H;y++)
            for(int x=0;x<char2_W;x++)
                if (processedImage.getRGB(x, y) == Color.BLACK.getRGB())
                    if(x<(char2_W/2.0))
                        pixel_l+=1;
                    else
                        pixel_r+=1;
        char7=(double)pixel_l/pixel_r;
                    
        //Caracteristica 8 : Skew Angle
        
        int acumx_l=0,acumy_l=0,contador_l=0,acumx_r=0,acumy_r=0,contador_r=0;
        int point_x_l,point_y_l,point_x_r,point_y_r;
        for(int y=0;y<char1_H;y++){
            for(int x=0;x<char2_W;x++)
                if (processedImage.getRGB(x, y) == Color.WHITE.getRGB()){
                    if(x<(char2_W/2.0)){
                        acumx_l+=x;
                        acumy_l+=y;
                        contador_l+=1;
                    }
                    
                    else{
                        acumx_r+=x;
                        acumy_r+=y;
                        contador_r+=1;   
                    }  
                }      
        }
        
        point_x_l=(int) Math.round((double)acumx_l/contador_l);
        point_y_l=(int) Math.round((double)acumy_l/contador_l);
        point_x_r=(int) Math.round((double)acumx_r/contador_r);
        point_y_r=(int) Math.round((double)acumy_r/contador_r);
        
        char8=Math.toDegrees(Math.atan((double)(point_y_r-point_y_l)/(point_x_r-point_x_l)));
        
        //Caracteristica 9 : Orientation of signature
        char9=point_y_r-point_y_l;
        
        //Caracteristica 10: Ratio of distance between centroids
            
        int acumx_F=0,contador_F=0,acumx_M=0,contador_M=0,acumx_L=0,contador_L=0;
        int point_x_F,point_x_M,point_x_L;
        for(int y=0;y<char1_H;y++){
            for(int x=0;x<char2_W;x++)
                if (processedImage.getRGB(x, y) == Color.WHITE.getRGB()){
                    if(x<(char2_W/3.0)){
                        acumx_F+=x;
                        contador_F+=1;
                    }    
                    else if(x<2.0*(char2_W/3.0)){
                        acumx_M+=x;
                        contador_M+=1;                    
                    }
                    else{
                        acumx_L+=x;
                        contador_L+=1;   
                    }  
                }      
        }
        
        point_x_F=(int) Math.round((double)acumx_F/contador_F);
        point_x_M=(int) Math.round((double)acumx_M/contador_M);
        point_x_L=(int) Math.round((double)acumx_L/contador_L);
        
        char10=(((double)point_x_M-point_x_F)/(point_x_L-point_x_M));
        
        //Caracteristica 11: Ratio of Enclosed Area to the Bounding box area
              
        vector[0]=char4;
        vector[1]=char5;
        vector[2]=char7;
        vector[3]=char8;
        vector[4]=char10;        
        
//        System.out.println("char1_H "+char1_H+"\nchar2_W " + char2_W + "\nchar3_1 " + char3_1 + "\nchar3_2 " + 
//                char3_2 + "\nchar4 "+ char4 + "\nchar5 " + char5 + "\nchar6_X  " + char6_X + "\nchar6_Y " +
//                char6_Y + "\nchar7 " + char7 + "\nchar8 "+char8 + "\nchar9 " + char9 + "\nchar10 "+ char8 +
//                "\nchar11 "+ char8);

        
    }
    
    public static BufferedImage preproceso(BufferedImage originalImage){
        BufferedImage imageThinning=null;
        try {
            int imageHeight, imageWidth;
            //extraemos altura y ancho inicial
            imageHeight = originalImage.getHeight();
            imageWidth = originalImage.getWidth();
                    
            // Empezamos con la binarizacion
            BufferedImage blackAndWhiteImg = binarization(originalImage);
            
            // Empezamos con el croppeado
            BufferedImage cropped = cropper(blackAndWhiteImg, imageHeight, imageWidth);
//            ImageIO.write(cropped, "jpg", new File("C:/Users/Raul/Desktop/Firmas/firma1crop.jpg"));           
            
            // Empezamos con el thinning
            int[][] imgbin= new int[cropped.getWidth()][cropped.getHeight()];
            int pix;
            for(int i=0;i<cropped.getWidth();i++)
                for(int j=0;j<cropped.getHeight();j++){
                    pix=cropped.getRGB(i, j);
                    if(pix==-1)
                    imgbin[i][j]=0; 
                    else {
                        imgbin[i][j]=1;
                        //System.out.println(""+pix);
                    }
                }
            ThinningService ut = new ThinningService();
            ut.doZhangSuenThinning(imgbin, true);
                       
            imageThinning = new BufferedImage(cropped.getWidth(), cropped.getHeight(),
                          BufferedImage.TYPE_BYTE_BINARY);
            for (int x = 0; x < cropped.getWidth(); x++) {
                for (int y = 0; y < cropped.getHeight(); y++) {
                    if (imgbin[x][y] == 1) {
                        imageThinning.setRGB(x, y, Color.BLACK.getRGB());
                     } else {
                        imageThinning.setRGB(x, y, Color.WHITE.getRGB());
                    }
                }
            }
//            ImageIO.write(imageThinning, "jpg", new File("C:/Users/Raul/Desktop/Firmas/fimaThinning.jpg"));
            return imageThinning;
            
        } catch (IOException ex) {
            System.out.println("#FueLaVida");
            Logger.getLogger(Algoritmos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imageThinning;
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
//                if(pixel!=-1)
//                    img.setRGB(x,y,-1);
//                else
//                    img.setRGB(x, y, -16777216);

       
                //System.out.println("las +"+pixel);
            }
        }
        
        // create a cropped image from the original image
        BufferedImage croppedImage = img.getSubimage(startX, startY, endX-startX, endY-startY);
        
        return croppedImage;
    }
    
}
