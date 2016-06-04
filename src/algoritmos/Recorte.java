/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import static preprocessing.Utils.binarization;
import static preprocessing.Utils.cropper;

/**
 *
 * @author Cecilia
 */
public class Recorte {
    private static int registrosPorJpg = 8;
    private static int cantDni = 8;
    public static BufferedImage extraerCuadroData(BufferedImage test){
        BufferedImage cuadro;
        int width = test.getWidth();          
            int height = test.getHeight();
            int inicioX, inicioY, finX, finY;
            inicioX=inicioY=finX=finY=0;
            boolean done = false;
            inicioX = 0;
            inicioY= height;
            finX = width;
            finY=0;
            for(int i=0;i<(width/6);i++){
                for(int j=height-1;j>=height-(height/5);j--){
                    if(test.getRGB(i, j)== -16777216 && test.getRGB(i+1, j)==-16777216 &&
                           test.getRGB(i, j-1)== -16777216){
                        int pix=i+1;
                        while(pix<i+20){
                            int menor, mayor;
                            menor = j-1;
                            mayor = j+1;
                            if(j-1<0) menor = 0;
                            if(j+1==height)mayor = j;
                            if(test.getRGB(pix, j)!=-16777216 && test.getRGB(pix, menor)!=-16777216 &&
                                    test.getRGB(pix, mayor)!= -16777216) break;
                            pix++;
                            if(pix==i+20){
                                inicioX=i;
                                inicioY=j;
                                done = true;
                            }
                        }
                        if(done)
                            break;
                    }                        
                }
                if(done) break;
            }
            done = false;
            for(int i=width-1;i>=width-(width/4);i--){
                for(int j=0;j<(height/4);j++){
                    if(test.getRGB(i, j)==-16777216 && test.getRGB(i-1, j)==-16777216 &&
                            test.getRGB(i, j+1)==-16777216){
                        int pix=i-1;
                        while(pix>i-20){
                            int menor, mayor;
                            menor = j-1;
                            mayor = j+1;
                            if(j-1<0) menor = 0;
                            if(j+1==height)mayor = j;
                            if(test.getRGB(pix, j)!=-16777216 && test.getRGB(pix, menor)!=-16777216 &&
                                    test.getRGB(pix, mayor)!= -16777216) break;
                            pix--;
                            if(pix==i-20){
                                finX=i;
                                finY=j;
                                done = true;
                            }
                        }
                        if(done)
                            break;
                    }
                }
                if(done)break;
            }

            test = test.getSubimage(inicioX, finY, (finX-inicioX), (inicioY-finY));
            int nuevoHeight = Math.round(test.getHeight()*(float)0.965);
            int ini = Math.round(test.getHeight()*(float)0.035);
            cuadro = test.getSubimage(0, ini, test.getWidth(), nuevoHeight);
            return cuadro;
    }
    
    public static BufferedImage[] extraerRegistros(BufferedImage test){
        BufferedImage[] resultados = new BufferedImage[registrosPorJpg];
        int alto = test.getHeight()/registrosPorJpg;
        for(int i=0;i<registrosPorJpg;i++){
            BufferedImage registro = test.getSubimage(0, i*alto, test.getWidth(), alto);
            resultados[i] = registro;
        }
        return resultados;
    }
    
    public static BufferedImage[] extraerDni(BufferedImage registro){
        BufferedImage[] dni = new BufferedImage[cantDni];
        int nuevoX = Math.round(registro.getWidth()*(float)0.02);
        int ancho = Math.round(registro.getWidth()*(float)0.1);
        BufferedImage numero1 = registro.getSubimage(nuevoX, 0, ancho, registro.getHeight());
        numero1 = limpiarBordeImagen(numero1,16,2);
        int anchoNum = numero1.getWidth()/8;        
        for(int i=0;i<cantDni;i++){
            BufferedImage num = numero1.getSubimage(i*anchoNum+1, 5, anchoNum-2, numero1.getHeight()-10);
            num = limpiarBordeImagen(num,2,4);
            num = removeNoisePoints(num);
            num = cropper(num);
            dni[i] = num;
            /*
            try {
                ImageIO.write(dni[i], "jpg", new File("C:\\Users\\Cecilia\\Desktop\\numero"+i+".jpg"));
            } catch (IOException ex) {
                Logger.getLogger(Recorte.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        }
        return dni;
    }
    
    private static BufferedImage limpiarBordeImagen(BufferedImage numero1, int proporcionX, int proporcionY){
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
    
    private static BufferedImage removeNoisePoints(BufferedImage img){
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
    
    public static void ejecutar(File file){
        BufferedImage test;
        int inicioX, inicioY, finX, finY;
        try {
            test = ImageIO.read(file);
            test = binarization(test);
            //ImageIO.write(test, "jpg", new File("C:\\Users\\alulab14\\Downloads\\bin.jpg"));
            test = extraerCuadroData(test);
            BufferedImage[] registros = extraerRegistros(test);
            int ancho = Math.round(registros[0].getWidth()*(float)0.02);
            BufferedImage numero1 = test.getSubimage(0, 0, ancho, registros[0].getHeight());    
            BufferedImage[] dni = extraerDni(registros[0]);
            for(int i=0;i<cantDni;i++){
                int num = OcrNumeros.obtenerNumero(dni[i]);
                System.out.println("numero: "+num);
            }
        } catch (IOException ex) {
            Logger.getLogger(Recorte.class.getName()).log(Level.SEVERE, null, ex);
        }       
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        //File file = new File("D:\\Users\\Cecilia\\Downloads\\rayado_Modificados_v1.jpg");
        File file = new File("src/red/padron.rayas.firmado.jpg");
        BufferedImage test;
        int inicioX, inicioY, finX, finY;
        try {
            test = ImageIO.read(file);
            test = binarization(test);
            //ImageIO.write(test, "jpg", new File("C:\\Users\\alulab14\\Downloads\\bin.jpg"));
            test = extraerCuadroData(test);
            BufferedImage[] registros = extraerRegistros(test);
            int ancho = Math.round(registros[0].getWidth()*(float)0.02);
            BufferedImage numero1 = test.getSubimage(0, 0, ancho, registros[0].getHeight());    
            BufferedImage[] dni = extraerDni(registros[0]);
            for(int i=0;i<cantDni;i++){
                int num = OcrNumeros.obtenerNumero(dni[i]);
                System.out.println("numero: "+num);
            }
        } catch (IOException ex) {
            Logger.getLogger(Recorte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
