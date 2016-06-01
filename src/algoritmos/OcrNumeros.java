/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.encog.neural.networks.BasicNetwork;
import org.encog.persist.EncogDirectoryPersistence;
import static preprocessing.Utils.binarization;

/**
 *
 * @author Cecilia
 */
public class OcrNumeros {
    public final static int width = 28;
    public final static int height = 28;
    public final static int widthMin = 20;//altura y ancho del numero en sí, sin bordes
    public final static int heightMin = 20;    
    
    public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
    
    public static int[][] preprocesar(BufferedImage imagen){
        if(imagen.getHeight() > imagen.getWidth()){
            imagen = resize(imagen, imagen.getWidth()*heightMin/imagen.getHeight(),heightMin);            
        } else imagen = resize(imagen, widthMin, imagen.getHeight()*widthMin/imagen.getWidth());
        imagen = binarization(imagen);
        
        int centroideX=0; int centroideY=0; int cantPuntos=0;
        for(int i=0;i<imagen.getWidth();i++){
            for(int j=0;j<imagen.getHeight();j++){
                if(imagen.getRGB(i, j)!=-1){
                    centroideX +=i;
                    centroideY +=j;
                    cantPuntos++;
                }
            }
        }
        centroideX /=cantPuntos; centroideY /= cantPuntos;
        int[][] imgFinal = new int[width][height];
        for(int i=0;i<width;i++) for(int j=0;j<height;j++) imgFinal[i][j]=0;
        int inicioX, inicioY;
        inicioX = (width/2)-centroideX+1;
        inicioY = (height/2)-centroideY+1;
        for(int i=0;i<imagen.getWidth()&& i+inicioX<width;i++){ 
            for(int j=0;j<imagen.getHeight() && j+inicioY<height;j++){

                if(imagen.getRGB(i, j)!=-1){
                    imgFinal[inicioX+i][inicioY+j]=255;
                }
            }
        }
        imagen = resize(imagen,28,28);
        for(int i =0;i<imagen.getWidth();i++) for(int j=0;j<imagen.getHeight();j++) 
            if(imgFinal[i][j]==0) imagen.setRGB(i, j, -1);
            else imagen.setRGB(i, j, -16777216);
        /*
        try {
                ImageIO.write(imagen, "jpg", new File("C:\\Users\\Cecilia\\Desktop\\numero.jpg"));
            } catch (IOException ex) {
                Logger.getLogger(OcrNumeros.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        return imgFinal;
    }
    
    public static int obtenerNumero(BufferedImage img){
            File networkFile = new File("src/red/network-binary-train-mnist.eg");
            BasicNetwork network = (BasicNetwork)(EncogDirectoryPersistence.loadObject(networkFile));
            /*File file = new File(archivo);
            BufferedImage img = ImageIO.read(file);*/
            int[][] imgbin = preprocesar(img);
            double[] output = new double[10];
            double[] input = new double[width*height];
            for(int i=0;i<width;i++)
                for(int j=0;j<height;j++)
                    input[j+(i)*height]=imgbin[j][i];
            network.compute(input, output);
            int numMax=0; double maxPor=0; 
            for(int i=0;i<10;i++){
                //System.out.println("numero "+(i)+": "+output[i]);
                if(output[i]>maxPor){
                    maxPor=output[i];
                    numMax = i;
                }
            }
            return numMax;
    }
    
}
