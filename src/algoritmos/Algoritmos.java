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
import preprocessing.ThinningService;
import preprocessing.Utils;

/**
 *
 * @author USUARIO
 */
public class Algoritmos {
    private final static int IMG_WIDTH=130;
    private final static int IMG_HEIGHT=80;
    private final static int F_IMG_WIDTH=160;
    private final static int F_IMG_HEIGHT=98;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int imageHeight, imageWidth;
        // TODO code application logic here
        //lectura de imagen
        File file = new File("C:\\Users\\USUARIO\\Pictures\\firma7_3f.jpg");
        File file1 = new File("C:\\Users\\USUARIO\\Pictures\\firma1_1o.jpg");
        File file2 = new File("C:\\Users\\USUARIO\\Pictures\\firma1_2o.jpg");
        File file3 = new File("C:\\Users\\USUARIO\\Pictures\\firma1_3f.jpg");
        File file4 = new File("C:\\Users\\USUARIO\\Pictures\\firma2_1o.jpg");
        File file5 = new File("C:\\Users\\USUARIO\\Pictures\\firma2_2o.jpg");
        File file6 = new File("C:\\Users\\USUARIO\\Pictures\\firma2_3f.jpg");
        File file7 = new File("C:\\Users\\USUARIO\\Pictures\\firma3_1o.jpg");
        File file8 = new File("C:\\Users\\USUARIO\\Pictures\\firma3_2o.jpg");
        File file9 = new File("C:\\Users\\USUARIO\\Pictures\\firma3_3f.jpg");
        File file10 = new File("C:\\Users\\USUARIO\\Pictures\\firma4_1o.jpg");
        File file11 = new File("C:\\Users\\USUARIO\\Pictures\\firma4_2o.jpg");
        File file12 = new File("C:\\Users\\USUARIO\\Pictures\\firma4_3f.jpg");
        File file13 = new File("C:\\Users\\USUARIO\\Pictures\\firma5_1o.jpg");
        File file14 = new File("C:\\Users\\USUARIO\\Pictures\\firma5_2o.jpg");
        File file15 = new File("C:\\Users\\USUARIO\\Pictures\\firma5_3f.jpg");
        File file16 = new File("C:\\Users\\USUARIO\\Pictures\\firma6_1o.jpg");
        File file17 = new File("C:\\Users\\USUARIO\\Pictures\\firma6_2o.jpg");
        File file18 = new File("C:\\Users\\USUARIO\\Pictures\\firma6_3f.jpg");
        File file19 = new File("C:\\Users\\USUARIO\\Pictures\\firma7_1o.jpg");
        File file20 = new File("C:\\Users\\USUARIO\\Pictures\\firma7_2o.jpg");
        File file21 = new File("C:\\Users\\USUARIO\\Pictures\\firma7_3f.jpg");
        File[] archs = new File[21];
        archs[0]=file1;archs[1]=file2;archs[2]=file3;archs[3]=file4;archs[4]=file5;archs[5]=file6;archs[6]=file7;
        archs[7]=file8;archs[8]=file9;archs[9]=file10;archs[10]=file11;archs[11]=file12;archs[12]=file13;archs[13]=file14;
        archs[14]=file15;archs[15]=file16;archs[16]=file17;archs[17]=file18;archs[18]=file19;archs[19]=file20;archs[20]=file21;
        double[] por1 = new double[21];
        double[] por2 = new double[21];
        for(int a=0;a<21;a++){
        
            BufferedImage compImg,original,test;
            try {
                original = ImageIO.read(archs[a]);
                compImg = ImageIO.read(file);
                //extraemos altura y ancho inicial
                imageHeight = original.getHeight();
                imageWidth = original.getWidth();

                // empezamos con la binarizacion
                //BufferedImage blackAndWhiteImg = binarization(original);
                original = binarization(original);
                compImg = binarization(compImg);
                //empezamos con el croppeado
                original = Utils.cropper(original);
                compImg = Utils.cropper(compImg);
                //ImageIO.write(cropped, "jpg", new File("C:/Users/USUARIO/Documents/dp1/firma1crop.jpg"));
                double p1 = (double)IMG_WIDTH/original.getWidth();
                if(original.getHeight()*p1<=IMG_HEIGHT){
                    original = Utils.resize(original, IMG_WIDTH, (int)Math.round(original.getHeight()*p1));
                    compImg = Utils.resize(compImg, IMG_WIDTH, (int)Math.round(original.getHeight()*p1));
                } else {
                    original = Utils.resize(original, original.getWidth()*IMG_HEIGHT/original.getHeight(), IMG_HEIGHT);
                    compImg = Utils.resize(compImg, original.getWidth()*IMG_HEIGHT/original.getHeight(), IMG_HEIGHT);
                }
                    
                
                //skeletonization y thinning
                /*
                MyImage img = new MyImage();
                img.readImage("C:/Users/USUARIO/Documents/dp1/firma1crop.jpg");
                Skeletonization.binaryImage(img);
                img.writeImage("C:/Users/USUARIO/Documents/dp1/firma1skeleton.jpg");
                */
                

                int[][] imgbin, imgbin2;
                imgbin = getPixArray(original);
                imgbin2 = getPixArray(compImg);
                
                int[][] fimgbin = new int[F_IMG_WIDTH][F_IMG_HEIGHT];
                int[][] fimgbin2= new int[F_IMG_WIDTH][F_IMG_HEIGHT];
                int arriba, abajo, derecha, izquierda;
                if(imgbin.length == IMG_WIDTH){
                    arriba = F_IMG_HEIGHT-imgbin[0].length;
                    arriba /=2;
                    abajo = F_IMG_HEIGHT-imgbin[0].length-arriba;
                    derecha = (F_IMG_WIDTH-IMG_WIDTH)/2;
                    izquierda = (F_IMG_WIDTH-IMG_WIDTH)/2;
                
                } else {
                    arriba = (F_IMG_HEIGHT-IMG_HEIGHT)/2;
                    abajo = (F_IMG_HEIGHT-IMG_HEIGHT)/2;
                    izquierda = F_IMG_WIDTH-imgbin[0].length;
                    izquierda /=2;
                    derecha = F_IMG_WIDTH-imgbin[0].length-izquierda;
                }
                for(int i=0;i<F_IMG_WIDTH;i++)
                    for(int j=0;j<F_IMG_HEIGHT;j++){
                        if(j<arriba || i<izquierda || i>=(F_IMG_WIDTH-derecha)||
                                j>=(F_IMG_HEIGHT-abajo)){
                            fimgbin[i][j]=1;
                            fimgbin2[i][j]=1;
                        }else{
                            fimgbin[i][j]=imgbin[i-izquierda][j-arriba];
                            fimgbin2[i][j]=imgbin2[i-izquierda][j-arriba];
                        }
                    }
                
                ThinningService ut = new ThinningService();
                ut.doZhangSuenThinning(fimgbin, true);
                ut.doZhangSuenThinning(fimgbin2, true);
                /*
                for(int i=0;i<imgbin.length;i++)
                    for(int j=0;j<imgbin[0].length)
                //metodo de pixeles
                /*
                File or_file = new File("C:/Users/USUARIO/Documents/dp1/firma1.jpg");
                original = ImageIO.read(or_file);
                File test_file = new File("C:/Users/USUARIO/Documents/dp1/firma1.jpg");
                test = ImageIO.read(test_file);
                */
                double percentage = pixel_comparison(fimgbin,fimgbin2);
                //System.out.println("resultado: "+percentage);
                por1[a]=percentage;
                percentage = pixel_comparison2(fimgbin,fimgbin2);
                //System.out.println("resultado: "+percentage);
                por2[a]=percentage;
            } catch (IOException ex) {
                 System.out.println("fuelavida");
                Logger.getLogger(Algoritmos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
            for(int j=0;j<21;j++){
                System.out.println(""+por1[j]);
            }
            for(int j=0;j<21;j++){
                System.out.println(""+por2[j]);
            }
    }
    
    public static int[][] getPixArray(BufferedImage img){
        int x,y;
        x=img.getWidth();
        y=img.getHeight();
        int[][] imgbin= new int[x][y];
            int pix;
            for(int i=0;i<x;i++)
                for(int j=0;j<y;j++){
                    pix=img.getRGB(i, j);
                    if(pix==-1)
                    imgbin[i][j]=0; 
                    else {
                        imgbin[i][j]=1;
                        //System.out.println(""+pix);
                    }
                }
        return imgbin;
    }
    
    public static double pixel_comparison(int[][] original, int[][] test){
        int m,n,p = 0;
        double porc;
        int width = original.length;
        int height = original[0].length;
        int t_pixel, o_pixel;
        m=n=p=0;
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                t_pixel = test[x][y];
                o_pixel = original[x][y];
                if(t_pixel==0){//si es blanco el color del pixel (como lo invertimos, el fondo es negro)
                    if(t_pixel==o_pixel) m++;
                    else n++;
                    p++;
                }
            }
        }
        porc = (double)m/(n+p);
        return porc;
    }
    
    public static double pixel_comparison2(int[][] original, int[][] test){
        int m,n,p = 0;
        double porc;
        int width = original.length;
        int height = original[0].length;
        int t_pixel, o_pixel;
        m=n=p=0;
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                t_pixel = test[x][y];
                o_pixel = original[x][y];
                if(t_pixel==1){//si es blanco el color del pixel (como lo invertimos, el fondo es negro)
                    if(t_pixel==o_pixel) m++;
                    else n++;
                    p++;
                }
            }
        }
        porc = (double)m/(n+p);
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
    
}
