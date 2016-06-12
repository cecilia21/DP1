/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import com.sun.rowset.internal.Row;
import ij.IJ;
import ij.ImagePlus;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.io.*; 
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;



/**
 *
 * @author RAMON
 */
public class Algoritmo_Huellas {
    
    //  Binarizacion... 
   private static BufferedImage binarizarHuella(BufferedImage huella) { 
        ImagePlus imp; 
        imp = new ImagePlus("huellaOriginal", huella);         
        IJ.run(imp,"Make Binary","");        
        BufferedImage bf = (BufferedImage) imp.getImage(); 
        return bf; 
    } 
   //Esquelitazacion
    private static BufferedImage skeletonHuella(BufferedImage huella) { 
        ImagePlus imp; 
        imp = new ImagePlus("huellaOriginal", huella); 
        IJ.run(imp,"Skeletonize","");
        BufferedImage bf = (BufferedImage) imp.getImage(); 
        return bf; 
    }     
    //Normalizacion
    private static BufferedImage normalizarHuella(BufferedImage huella) { 
        ImagePlus imp; 
        imp = new ImagePlus("huellaOriginal", huella); 
        IJ.run(imp, "Subtract Background...", "rolling=" + 100 + " light");
        imp.getProcessor().setAutoThreshold("Default");
        imp.getProcessor().setThreshold(-1,8,0);  
        IJ.run(imp, "Convert to Mask", ""); 
        BufferedImage bf = (BufferedImage) imp.getImage(); 
        return bf; 
    }      
    //Cropp
    private static BufferedImage cropper(BufferedImage img) throws IOException{
        int height = img.getHeight();
        int width = img.getWidth();
        int pixel,p2,p3,p4,p5,p6;
        int startX, endX, startY, endY;
        startX = startY = 1000000;
        endX = endY = 0;
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                pixel = img.getRGB(x, y);            
                if(pixel!=-1){
                    if(x<startX) startX = x;
                    if(x>endX) endX = x;
                    if(y<startY) startY = y;
                    if(y>endY) endY = y;
                }
                
            }
        }        
        BufferedImage croppedImage = img.getSubimage(startX, startY, endX-startX, endY-startY);        
        return croppedImage;
    }

    private static BufferedImage EscalarHuella(BufferedImage huellaO,int tamH,int tamW){
        Image or = huellaO.getScaledInstance(tamW, tamH, Image.SCALE_FAST);
        BufferedImage buffered1 = new BufferedImage(tamW, tamH, BufferedImage.TYPE_INT_ARGB);
        buffered1.getGraphics().drawImage(or, 0, 0 , null);
        return buffered1;
    }
    
    private static double CompareMinize(BufferedImage ori,BufferedImage tes){  
        double por=0,pc,pp;
        int cbo=0,cbt=0,cto=0,ctt=0,to=0,tt=0;
        int height = ori.getHeight();
        int width = ori.getWidth();
        int maxmo=height*width;        
        int [][] arro=new int[3][maxmo]; 
        int height2 = tes.getHeight();
        int width2 = tes.getWidth();
        int maxmt=height2*width2;  
        int [][] arrt=new int[3][maxmt]; 
        
        int a=0,b=0,c=0,d=0,e=0,f=0,g=0,h=0;      
        for(int y = 0; y < height; y++) {                
            for(int x = 0; x < width; x++) {                    
                if(-1!=ori.getRGB(x, y)){
                    int cn=0;                           
                    if(x>=1&&y>=1)if(ori.getRGB(x-1,y-1)!=-1)a=1;                            
                    else a=0;                            
                    if(x>=1)if(ori.getRGB(x-1,y)!=-1)b=1;                            
                    else b=0;                             
                    if(x>=1 && y<height-1)if(ori.getRGB(x-1,y+1)!=-1)c=1;                            
                    else c=0;                             
                    if(y>=1)if(ori.getRGB(x,y-1)!=-1)d=1;                            
                    else d=0;  
                    if(y<height-1)if(ori.getRGB(x,y+1)!=-1)e=1;                            
                    else e=0;  
                    if(x<width-1 && y>=1)if(ori.getRGB(x+1,y-1)!=-1)f=1;                            
                    else f=0;  
                    if(x<width-1)if(ori.getRGB(x+1,y)!=-1)g=1;                            
                    else g=0;  
                    if(x<width-1 && y<height-1)if(ori.getRGB(x+1,y+1)!=-1)h=1;                            
                    else h=0; 
                    cn=a+b+c+d+e+f+g+h;    
                    if(cn==1){
                        arro[0][to]=y;
                        arro[1][to]=x;
                        arro[2][to]=0;
                        to++;
                        cto++;
                    }
                    if(cn==3){
                        arro[0][to]=y;
                        arro[1][to]=x;
                        arro[2][to]=1;
                        to++;
                        cbo++;
                    }
                }                 
            }
        }
        
        a=0;b=0;c=0;d=0;e=0;f=0;g=0;h=0;      
        for(int y = 0; y < height2; y++) {                
            for(int x = 0; x < width2; x++) {                    
                if(-1!=tes.getRGB(x, y)){
                    int cn=0;                           
                    if(x>=1&&y>=1)if(tes.getRGB(x-1,y-1)!=-1)a=1;                            
                    else a=0;                            
                    if(x>=1)if(tes.getRGB(x-1,y)!=-1)b=1;                            
                    else b=0;                             
                    if(x>=1 && y<height2-1)if(tes.getRGB(x-1,y+1)!=-1)c=1;                            
                    else c=0;                             
                    if(y>=1)if(tes.getRGB(x,y-1)!=-1)d=1;                            
                    else d=0;  
                    if(y<height2-1)if(tes.getRGB(x,y+1)!=-1)e=1;                            
                    else e=0;  
                    if(x<width2-1 && y>=1)if(tes.getRGB(x+1,y-1)!=-1)f=1;                            
                    else f=0;  
                    if(x<width2-1)if(tes.getRGB(x+1,y)!=-1)g=1;                            
                    else g=0;  
                    if(x<width2-1 && y<height2-1)if(tes.getRGB(x+1,y+1)!=-1)h=1;                            
                    else h=0; 
                    cn=a+b+c+d+e+f+g+h;    
                    if(cn==1){
                        arrt[0][tt]=y;
                        arrt[1][tt]=x;
                        arrt[2][tt]=0;
                        tt++;
                        ctt++;
                    }
                    if(cn==3){
                        arrt[0][tt]=y;
                        arrt[1][tt]=x;
                        arrt[2][tt]=1;
                        tt++;
                        cbt++;
                    }
                }                 
            }
        }
        double p1=0,p2=0,p3=0;
        if(cbt>cbo){
            p1=(double)(cbt-cbo)/cbt;
        }
        else p1=(double)(cbo-cbt)/cbo;
        if(ctt>cto)p2=(double)(ctt-cto)/ctt;
        else p2=(double)(cto-ctt)/cto;
        int n1=0;
        for(int i=0;i<to;i++){
            for(int j=0;j<tt;j++){
                if((arro[0][i]==arrt[0][j])||(arro[0][i]==(arrt[0][j]+1))||
                        (arro[0][i]==(arrt[0][j]-1))||(arro[0][i]==(arrt[0][j]+2))||
                        (arro[0][i]==(arrt[0][j]-2))){
                    if(((arro[1][i]==arrt[1][j])||(arro[1][i]==(arrt[1][j]+1))||
                        (arro[1][i]==(arrt[1][j]-1))||(arro[1][i]==(arrt[1][j]+2))||
                        (arro[1][i]==(arrt[1][j]-2)))&&(arro[2][i]==arrt[2][j])){
                        n1++;
                        break;
                    }
                }
            }
        }
        p3=(double)(to-n1)/to;
        
        por=(2*p1+2*p2+6*(p3))/10;
        
        return (1-por);
    }
    
//    private static BufferedImage readImage(File file) throws IOException
//    {
//        return readImage(new FileInputStream(file));
//    }
//
//    
//    private static BufferedImage readImage(InputStream stream) throws IOException
//    {
//        Iterator<ImageReader> imageReaders = 
//            ImageIO.getImageReadersBySuffix("jpg");
//        ImageReader imageReader = imageReaders.next();
//        ImageInputStream iis = 
//            ImageIO.createImageInputStream(stream);
//        imageReader.setInput(iis, true, true);
//        Raster raster = imageReader.readRaster(0, null);
//        int w = raster.getWidth();
//        int h = raster.getHeight();
//
//        BufferedImage result = 
//            new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
//        int rgb[] = new int[3];
//        int pixel[] = new int[3];
//        for (int x=0; x<w; x++)
//        {
//            for (int y=0; y<h; y++)
//            {
//                raster.getPixel(x, y, pixel);
//                int Y = pixel[0];
//                int CR = pixel[1];
//                int CB = pixel[2];
//                toRGB(Y, CB, CR, rgb);
//                int r = rgb[0];
//                int g = rgb[1];
//                int b = rgb[2];
//                int bgr = 
//                    ((b & 0xFF) << 16) | 
//                    ((g & 0xFF) <<  8) | 
//                     (r & 0xFF);
//                result.setRGB(x, y, bgr);
//            }
//        }
//        return result;
//    }
//
//    private static void toRGB(int y, int cb, int cr, int rgb[])
//    {
//        float Y = y / 255.0f;
//        float Cb = (cb-128) / 255.0f;
//        float Cr = (cr-128) / 255.0f;
//
//        float R = Y + 1.4f * Cr;
//        float G = Y -0.343f * Cb - 0.711f * Cr;
//        float B = Y + 1.765f * Cb;
//
//        R = Math.min(1.0f, Math.max(0.0f, R));
//        G = Math.min(1.0f, Math.max(0.0f, G));
//        B = Math.min(1.0f, Math.max(0.0f, B));
//
//        int r = (int)(R * 255);
//        int g = (int)(G * 255);
//        int b = (int)(B * 255);
//
//        rgb[0] = r;
//        rgb[1] = g;
//        rgb[2] = b;
//    }
    
    public static double VerificaHuella(BufferedImage huellaO,BufferedImage huellaC){
        double por=-1;

//        huellaO=ot;
        if(huellaO!=null){
//            huellaO=ot;
//            huellaC=tt;
            int heightO=huellaO.getHeight();
            int heightC=huellaC.getHeight();
            int widthO=huellaO.getWidth();
            int widthC=huellaC.getWidth();
            int t2=heightO-heightC;
            double p=(double)heightO/(double)t2;
            double p2=widthO/p;
            BufferedImage huellaOE=EscalarHuella(huellaO,heightO-t2,widthO-(int)p2);
            BufferedImage huellaCE=EscalarHuella(huellaC,heightC,widthC);
            try {
                huellaOE=cropper(huellaOE);
                huellaCE=cropper(huellaCE);
                huellaOE=binarizarHuella(huellaOE);
                huellaCE=binarizarHuella(huellaCE);
                huellaOE=cropper(huellaOE);
                huellaCE=cropper(huellaCE);
                huellaOE=skeletonHuella(huellaOE);
                huellaCE=skeletonHuella(huellaCE);
                huellaOE=cropper(huellaOE);
                huellaCE=cropper(huellaCE); 
                por=CompareMinize(huellaOE,huellaCE);
            } catch (IOException ex) {
                Logger.getLogger(Algoritmo_Huellas.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }  
//        System.out.println(""+por);
        por=por*100;
        if(65<por)
                System.out.println("Huella válida: " + por);
        if(45<por)
                System.out.println("Huella revisión: " + por);
        else
                System.out.println("Huella no válida: " + por);
        return por/100;
    }

    
}
