/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import controlador.Manager;
import ij.IJ;
import ij.ImagePlus;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import model.Adherente;
import model.PartidoPolitico;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import preprocessing.Utils;
import static preprocessing.Utils.binarization;
import static preprocessing.Utils.cropper;
import static preprocessing.Utils.executeTesseract;
import static preprocessing.Utils.executeTesseractNumbers;
import static preprocessing.Utils.limpiarBordeImagen;
import static preprocessing.Utils.removeNoisePoints;

/**
 *
 * @author Cecilia
 */
public class Recorte {
    private static int registrosPorJpg = 8;
    private static int cantDni = 8;
    private static BufferedImage ImagenHuella=null;
    private static BufferedImage ImagenFirma=null;
    private static double umbral1_firma = 0.65;
    private static double umbral2_firma = 0.45;
    private static double umbral1_huella = 0.80;
    private static double umbral2_huella = 0.65;
    private static int registro_aprobado = 1;
    private static int registro_observado = 2;
    private static int registro_rechazado = 3;
    public static String rutaGeneral="/temp";
    public static String rutaHuella="/temp";
    public static String rutaFirma="/temp";
    
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
            if(i*anchoNum+1+anchoNum-2 > numero1.getWidth()) anchoNum=numero1.getWidth()-(i*anchoNum+1)+2;
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
    
    public static BufferedImage extraerHuella(BufferedImage registro){

        int nuevoX = Math.round(registro.getWidth()*(float)0.86);
        int ancho = registro.getWidth() - nuevoX;
        BufferedImage huella = registro.getSubimage(nuevoX, 2, ancho, registro.getHeight()-2);
        huella = limpiarBordeImagen(huella,16,2);
        huella = cropper(huella);
        /*
        try {
            ImageIO.write(numero1, "jpg", new File("C:\\Users\\Cecilia\\Desktop\\heulla.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Recorte.class.getName()).log(Level.SEVERE, null, ex);
        }
                */
        return huella;
    }
    
    public static BufferedImage extraerFirma(BufferedImage registro){

        int nuevoX = Math.round(registro.getWidth()*(float)0.71);
        int ancho = Math.round(registro.getWidth()*(float)0.15);
        BufferedImage firma = registro.getSubimage(nuevoX, 2, ancho, registro.getHeight()-2);
        firma = limpiarBordeImagen(firma,16,2);
        firma = cropper(firma);
        /*
        try {
            ImageIO.write(firma, "jpg", new File("C:\\Users\\Cecilia\\Desktop\\firma.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Recorte.class.getName()).log(Level.SEVERE, null, ex);
        }
              */ 
        return firma;
    }
    private static boolean esLineaNegra(int[] linea){
        double porcentaje = 0.7*linea.length;
        int negros=0;
        for(int i=0;i<linea.length;i++)
            if(linea[i]==-16777216) negros++;
        if(negros>=porcentaje) return true;
        return false;
    }
    private static BufferedImage extraerCuadritos(int iniCuadro, int cantCuadros, BufferedImage registro){
        int iniX=0;
        int ancho;
        int cuadrosRecorridos = 0;
        int cuadroInicio = 0;
        int ultimaColumnaRecorrida = iniX;
        for(int i=20;i<registro.getWidth();i++){
            int[] linea = new int[registro.getHeight()];
            for(int j=0;j<registro.getHeight();j++){
                linea[j]=registro.getRGB(i, j);
            }
              //  if(registro.getRGB(i, j)!=-16777216) break;
                if(esLineaNegra(linea)){
                    if(cuadroInicio==iniCuadro){
                        if(ultimaColumnaRecorrida+1!=i){
                            cuadrosRecorridos++;
                            if(cuadrosRecorridos==cantCuadros){
                                ancho = i - iniX;
                                return registro.getSubimage(iniX, 0, ancho, registro.getHeight());
                            }
                        }
                    } else{
                        if(iniX+1!=i)
                            cuadroInicio++;
                        iniX = i;

                    }
                    ultimaColumnaRecorrida=i;
                }
            //}
        }
        return null;
    }
    
    public static BufferedImage extraerDniUnaImagen(BufferedImage registro){
        BufferedImage dni = extraerCuadritos(1,8,registro);
        BufferedImage result = new BufferedImage(
                       dni.getWidth(), dni.getHeight(), //work these out
                       BufferedImage.TYPE_INT_RGB);
        for(int i=0;i<result.getHeight();i++) for(int j=0;j<result.getWidth();j++) result.setRGB(j, i, -1);
        Graphics g = result.getGraphics();
        int alto = result.getHeight();
        int cuadroAnt =-1;
        int iniX =0; int finX =0;
        for(int i=0;i<23;i++){            
            BufferedImage letra = extraerCuadritos(1+i,1,registro);
            letra = limpiarBordeImagen(letra,2,4);
            letra = removeNoisePoints(letra);
            letra = cropper(letra);
            g.drawImage(letra, i*dni.getWidth()/8, 20, null);
            if(i==1) alto = letra.getHeight();
        }       
        return result.getSubimage(0, 0, dni.getWidth(), alto+40);
    }
    
    private static ArrayList<String> extraerNombre(BufferedImage registro) throws TesseractException{
//        ImagePlus imp=new ImagePlus("let",registro);
//             imp.show();
        String nom="";
        Tesseract instance2 = new Tesseract();
        instance2.setLanguage("spa");
        instance2.setConfigs(Arrays.asList("letters"));
        ArrayList <String> arrNomb=new ArrayList<String>();
        BufferedImage nombre = extraerCuadritos(9+25,23,registro);
        BufferedImage result = new BufferedImage(
                       nombre.getWidth(), nombre.getHeight(), //work these out
                       BufferedImage.TYPE_INT_RGB);
        for(int i=0;i<result.getHeight();i++) for(int j=0;j<result.getWidth();j++) result.setRGB(j, i, -1);
        Graphics g = result.getGraphics();
        int alto = result.getHeight();
        ArrayList<BufferedImage> nombres = new ArrayList<BufferedImage>();
        int cuadroAnt =-1;
        int iniX =0; int finX =0;
        for(int i=0;i<23;i++){
            BufferedImage letra = extraerCuadritos(9+25+i,1,registro);
            letra = limpiarBordeImagen(letra,2,4);
            letra = removeNoisePoints(letra);
            if(arrNomb.isEmpty() && i==0){                
                nom = instance2.doOCR(letra);
                nom=nom.trim();
                nom=nom.replaceAll("\nH","");
                nom=nom.replaceAll("\n","");
                nom=nom.replaceAll("\nIi","");
                if(nom.compareTo("Aji")==0){ 
                        nom="A";                            
                }
                if(nom.compareTo("A\nIi")==0){ 
                        nom="A";                            
                }
                if(nom.compareTo("A A")==0){ 
                        nom="A";                            
                }
                if(nom.compareTo("AH")==0){ 
                        nom="A";                            
                }
                if(nom.compareTo("rnLJ")==0){ 
                        nom="D";                            
                }
                if(nom.compareTo("Ix")==0){ 
                        nom="D";                            
                }
                if(nom.compareTo("n")==0){ 
                        nom="D";                            
                }                
                if(nom.compareTo("rxL J")==0){ 
                        nom="D";                            
                }  
                if(nom.compareTo("rnm")==0){ 
                        nom="D";                            
                } 
                if(nom.compareTo("rnw")==0){ 
                        nom="D";                            
                } 
                if(nom.compareTo("rxw")==0){ 
                        nom="D";                            
                } 
                if(nom.compareTo("yaLil")==0){ 
                        nom="D";                            
                }   
                if(nom.compareTo("C")==0){ 
                                     String no2="E";                                     
                                     arrNomb.add(no2);
                            }
                nom=nom.replaceAll("l","I");
                arrNomb.add(nom);
            }
            if(esCuadroBlanco(letra)==0){ //si no es cuadro blanco
                if(cuadroAnt+1==i){
                    iniX = i*nombre.getWidth()/25;
                    finX = 0;
                }
                finX +=nombre.getWidth()/25;
                letra = cropper(letra);   
                nom = instance2.doOCR(letra);
                int lon=arrNomb.size();
                if(i!=0){
                        for(int k=0;k<lon;k++){
                           String nom3=nom;
                           nom3=nom3.trim();
                           nom3=nom3.replaceAll("\n","");
                           nom3=nom3.trim();
                           nom3=nom3.replaceAll("\nH","");
                           nom3=nom3.replaceAll("\nln","");
                           nom3=nom3.replaceAll("Ii","");
                           nom3=nom3.replaceAll("li","");
                           nom3=nom3.replaceAll("ha","");
                           nom3=nom3.trim();
                            String no=arrNomb.get(k);
//                            if(nom3.compareTo("l")==0){ 
//                                     String no2=no+"I";                                     
//                                      arrNomb.add(no2);
//                            }
                            if(nom3.compareTo("il")==0){ 
                                     nom3="I";
                            } 
                            if(nom3.compareTo("IL")==0){ 
                                     nom3="L";
                            } 
                            if(nom3.compareTo("AId")==0){ 
                                     nom3="A";
                            }
                            if(nom3.compareTo("Aja")==0){ 
                                     nom3="A";
                            }
                            if(nom3.compareTo("Exi")==0){ 
                                     nom3="E";
                            }
                            if(nom3.compareTo("rx")==0){ 
                                     nom3="D";
                            }
                            if(nom3.compareTo("MU")==0){ 
                                     nom3="O";
                            }
                            if(nom3.compareTo("fx")==0){ 
                                     nom3="A";
                            }
                            if(nom3.compareTo("AU")==0){ 
                                     nom3="O";
                            }
                            nom3=nom3.replaceAll("l","I");
//                            if(nom3.compareTo("K")==0){ 
//                                     String no2=no+"I";                                     
//                                      arrNomb.add(no2);
//                            }
//                            if(nom3.compareTo("T")==0){ 
//                                     String no2=no+"I";                                     
//                                      arrNomb.add(no2);
//                            }
                            if(nom3.compareTo("P")==0){ 
                                     String no2=no+"D";                                     
                                      arrNomb.add(no2);
                            }
                            if(nom3.compareTo("EJ")==0){ 
                                     String no2=no+"S";                                     
                                      arrNomb.add(no2);
                            }
                            if(nom3.compareTo("")==0){ 
                                     String no2=no+"I";                                     
                                      arrNomb.add(no2);
                            }
                            if(nom3.compareTo("AH")==0){ 
                                     String no2=no+"A";                                     
                                      arrNomb.add(no2);
                            }
                            if(nom3.compareTo("Aji")==0){ 
                                    nom3="A";                            
                            }
                            if(nom3.compareTo("yw")==0){ 
                                    nom3="D";                            
                            }
                            nom3=nom3.replaceAll("Hu","O");
                            nom3=nom3.replaceAll("f","C");
                            nom3=nom3.replaceAll("a","I");
                            nom3=nom3.replaceAll("b","D");
                            nom3=nom3.replaceAll("u","A");
                            nom3=nom3.replaceAll("In","L");
                            nom3=nom3.trim();                            
                            no+=nom3;
                            arrNomb.set(k, no);   
                    }
                }
            }else{
                int lon2=arrNomb.size();
                for(int k=0;k<lon2;k++){
                    String no2=arrNomb.get(k);
                    no2+=" ";
                    arrNomb.set(k, no2);
                }
                if(i>1 && i!=cuadroAnt+1){
                    BufferedImage app = result.getSubimage(iniX, 0, finX, alto+40);
                    nombres.add(app);
                }
                cuadroAnt = i;
            }
            if(i==1) alto = letra.getHeight();
        }        
//        System.out.println(nom);
//        for(int k=0;k<arrNomb.size();k++){
//            System.out.println(""+arrNomb.get(k));
//        }
        return arrNomb;
    }
    
    private static ArrayList<String> extraerApellidos(BufferedImage registro) throws TesseractException{
//        ImagePlus imp=new ImagePlus("let",registro);
//             imp.show();
        BufferedImage nombre = extraerCuadritos(9,25,registro);
        String nom="";
        Tesseract instance2 = new Tesseract();
        instance2.setLanguage("spa");
        instance2.setConfigs(Arrays.asList("letters"));
        ArrayList <String> arrNomb=new ArrayList<String>();
        BufferedImage result = new BufferedImage(
                       nombre.getWidth(), nombre.getHeight(), //work these out
                       BufferedImage.TYPE_INT_RGB);
        for(int i=0;i<result.getHeight();i++) for(int j=0;j<result.getWidth();j++) result.setRGB(j, i, -1);
        Graphics g = result.getGraphics();
        int alto = result.getHeight();
        ArrayList<BufferedImage> apellidos = new ArrayList<BufferedImage>();
        int cuadroAnt =-1;
        int iniX =0; int finX =0;
        for(int i=0;i<25;i++){            
            BufferedImage letra = extraerCuadritos(9+i,1,registro);
//            ImagePlus imp=new ImagePlus("let",letra);
//             imp.show();
            letra = limpiarBordeImagen(letra,2,4);
            letra = removeNoisePoints(letra);
            if(arrNomb.isEmpty() && i==0){                
                nom = instance2.doOCR(letra);
                nom=nom.trim();
                nom=nom.replaceAll("\nH","");
                nom=nom.replaceAll("\n","");
                nom=nom.replaceAll("Ii","");
//                nom=nom.replaceAll("\nH","");
//                nom=nom.replaceAll("\n","");
                nom=nom.replaceAll("If","J");  
                if(nom.compareTo("IY")==0){ 
                                     String no2="J";                                     
                                     arrNomb.add(no2);
                            }
                if(nom.compareTo("U")==0){ 
                                     String no2="J";                                     
                                     arrNomb.add(no2);
                            }
                if(nom.compareTo("FNL l")==0){ 
                                     nom="D";  
                            }
                if(nom.compareTo("rxu")==0){ 
                                     nom="D";  
                            } 
                if(nom.compareTo("r")==0){ 
                                     nom="D";  
                            }
                arrNomb.add(nom);
            }
            if(esCuadroBlanco(letra)==0){ //si no es cuadro blanco
                if(cuadroAnt+1==i){
                    iniX = i*nombre.getWidth()/25;
                    finX = 0;
                }
                finX +=nombre.getWidth()/25;
//                ImagePlus imp3=new ImagePlus("let",letra);
//                imp3.show();
                letra = cropper(letra);                
//                g.drawImage(letra, i*nombre.getWidth()/25, 20, null);
//                ImagePlus imp2=new ImagePlus("let",letra);
//                imp2.show();
                int lon=arrNomb.size();
                nom = instance2.doOCR(letra);
                if(i!=0){
                        for(int k=0;k<lon;k++){
                           String nom3=nom;
//                           nom3 = instance2.doOCR(letra);
                           nom3=nom3.trim();
                           if(nom3.compareTo("C\nI")==0){ 
                                     nom3="P";
                            }  
                           if(nom3.compareTo("A\nla")==0){ 
                                     nom3="A";
                            } 
                           if(nom3.compareTo("H\nLI")==0){ 
                                     nom3="O";
                            } 
                           if(nom3.compareTo("h\nxx")==0){ 
                                     nom3="D";
                            }
                           if(nom3.compareTo("P\nU")==0){ 
                                     nom3="O";
                            } 
                           if(nom3.compareTo("Av")==0){ 
                                     nom3="O";
                            }
                           if(nom3.compareTo("R\nv")==0){ 
                                     nom3="O";
                            }
                           if(nom3.compareTo("Hu")==0){ 
                                     nom3="O";
                            }
                           if(nom3.compareTo("fx")==0){ 
                                     nom3="D";
                            }
                           if(nom3.compareTo("IQ")==0){ 
                                     nom3="R";
                            }
                           if(nom3.compareTo("d")==0){ 
                                     nom3="J";
                            }
                           nom3=nom3.replaceAll("iEZ","E");
                           nom3=nom3.replaceAll("\nH","");                           
                           nom3=nom3.replaceAll("Ii","");
                           nom3=nom3.replaceAll("Id","");
                           nom3=nom3.replaceAll("nu","");
                           nom3=nom3.replaceAll("na","");
                           nom3=nom3.replaceAll("ll","I");
                           nom3=nom3.replaceAll("il","I");
                            nom3=nom3.replaceAll("ll","L");
                            nom3=nom3.replaceAll("If","J");
                            nom3=nom3.replaceAll("yN","D");
                           nom3=nom3.replaceAll("\n","");
                           nom3=nom3.trim();
                            String no=arrNomb.get(k);
                            if(nom3.compareTo("")==0){ 
                                     String no2=no+"I";                                     
                                      arrNomb.add(no2);
                                     String no3=no+"L";                                     
                                      arrNomb.add(no3);
                            }
                           if(nom3.compareTo("FU")==0){ 
                                     nom3="O";
                            }
                           if(nom3.compareTo("KL")==0){ 
                                     nom3="L";
                            }
                           if(nom3.compareTo("IL")==0){ 
                                     nom3="L";
                            }
                           if(nom3.compareTo("rwU")==0){ 
                                     nom3="D";
                            }
                           if(nom3.compareTo("rw")==0){ 
                                     nom3="D";
                            }
                           if(nom3.compareTo("r")==0){ 
                                     nom3="D";
                            }
                           if(nom3.compareTo("xL")==0){ 
                                     nom3="L";
                            }
                            if(nom3.compareTo("yxLJ")==0){ 
                                     nom3="D";
                            }    
                            if(nom3.compareTo("I")==0){ 
                                     String no2=no+"L";                                     
                                      arrNomb.add(no2);
                            }
                            if(nom3.compareTo("AU")==0){ 
                                     String no2=no+"O";                                     
                                      arrNomb.add(no2);
                            }
                            nom3=nom3.replaceAll("l","I");                 
                            nom3=nom3.replaceAll("i","S");
                            if(nom3.compareTo("IY")==0){ 
                                     String no2=no+"J";                                     
                                     arrNomb.add(no2);
                            }
                            if(nom3.compareTo("E")==0){ 
                                     String no2=no+"R";                                     
                                      arrNomb.add(no2);
                            }
                            if(nom3.compareTo("K")==0){ 
                                     String no2=no+"I";                                     
                                      arrNomb.add(no2);
                            }
                            if(nom3.compareTo("Q")==0){ 
                                     String no2=no+"R";                                     
                                      arrNomb.add(no2);
                            }                            
                            if(nom3.compareTo("G")==0){ 
                                     String no2=no+"O";                                     
                                      arrNomb.add(no2);
                            }
                            if(nom3.compareTo("U")==0){ 
                                     String no2=no+"O";                                     
                                      arrNomb.add(no2);
                            }
                            if(nom.compareTo("II")==0){ 
                                     String no2=no+"L";                                     
                                      arrNomb.add(no2);
                            }
                            if(nom.compareTo("k")==0){ 
                                     String no2=no+"R";                                     
                                      arrNomb.add(no2);
                            }  
                            nom3=nom3.replaceAll("k","K");
                            nom3=nom3.replaceAll("r","D");
                            nom3=nom3.trim();                            
                            no+=nom3;
                            arrNomb.set(k, no);
//                            }                            
                            
                    }
                }
            }else{
                int lon2=arrNomb.size();
                for(int k=0;k<lon2;k++){
                    String no2=arrNomb.get(k);
                    no2+=" ";
                    arrNomb.set(k, no2);
                }
                if(i>1 && i!=cuadroAnt+1){
                    BufferedImage app = result.getSubimage(iniX, 0, finX, alto+40);
                    apellidos.add(app);
                }
                cuadroAnt = i;
            }
            if(i==1) alto = letra.getHeight();
        }
//        for(int k=0;k<arrNomb.size();k++){
//            System.out.println(""+arrNomb.get(k));
//        }
        return arrNomb;
    }
     
    private static int esCuadroBlanco(BufferedImage cuadro){
        cuadro = limpiarBordeImagen(cuadro,2,4);
        cuadro = removeNoisePoints(cuadro);
        for(int i=0;i<cuadro.getWidth();i++)
            for(int j=0;j<cuadro.getHeight();j++){
                if(cuadro.getRGB(i, j)==-16777216) return 0;
            }
        return 1;
    }              
    
    private static int validarAprobacion(double p_firma, double p_huella){
        // 1 = aprobado, 2= observado, 3=rechazado
        boolean nombre_coincide=true;
        boolean firma_valida = p_firma>=umbral1_firma;
        boolean firma_observada = p_firma<umbral1_firma && p_firma>=umbral2_firma;
        boolean firma_rechazada =  p_firma<umbral2_firma;
        boolean huella_valida = p_huella >= umbral1_huella;
        boolean huella_observada = p_huella<umbral1_huella && p_huella >=umbral2_huella;
        boolean huella_rechazada = p_huella<umbral2_huella;
        if(firma_valida && huella_valida) return registro_aprobado;
        
        if (firma_valida && huella_observada) return registro_observado;
        if (firma_observada && huella_valida) return registro_observado;
        if (nombre_coincide && firma_rechazada && huella_valida) return registro_observado;
        if (nombre_coincide && firma_valida && huella_rechazada) return registro_observado;
        else return registro_rechazado;        
        
    }
 
    
    public static int ejecutar(File file,ArrayList<Adherente> listaAdherente, PartidoPolitico partido) throws TesseractException{
        //validar que exista excel rnv
        if(!Utils.validarRutaGeneral(""+rutaGeneral)){
            JOptionPane.showMessageDialog(null, "No se encontró archivo excel del RNV. Configurar ruta.");
            return -1;
        }
        int cant = Utils.cumpleFormatoExcelRNV(rutaGeneral);
        if(cant==-1){
            JOptionPane.showMessageDialog(null, "Error: El archivo Excel no cumple con el formato deseado.");
            return -1;
        }
        //validar que existan huellas jpg
        //validar que existan firmas jpg
        if(!Utils.validarRutaImagenHuella(rutaHuella, cant)){
            JOptionPane.showMessageDialog(null, "Error en el directorio de huellas. Revisar configuración.");
            return -1;
        }
        if(!Utils.validarRutaImagenHuella(rutaFirma, cant)){
            JOptionPane.showMessageDialog(null, "Error en el directorio de firmas. Revisar configuración.");
            return -1;
        }
        //validar formato del jpg
        BufferedImage test;
        int inicioX, inicioY, finX, finY;
        try {
            test = ImageIO.read(file);
            //validar formato imagen
//            test = binarization(test);
            ImagePlus imp=new ImagePlus("Nuevo",test);
            IJ.run(imp,"Make Binary","");  
            test= (BufferedImage) imp.getImage(); 
       //Configuracion del Algoritmo OCR digitos
            ITesseract instance  = new Tesseract();
         ArrayList<String> p = new ArrayList<>();
        p.add("digits");
        instance.setConfigs(p);
        instance.setLanguage("dit"); 
            
            
            test = extraerCuadroData(test);
            BufferedImage[] registros = extraerRegistros(test);
            //lista de prueba
       
         String numero;
            for(int i=0;i<registros.length;i++){
                int ancho = Math.round(registros[i].getWidth()*(float)0.02);
                
                       
                     BufferedImage[] dni = extraerDni(registros[i]);
                   numero = "";
                   for(int k = 0;   k < dni.length ; k++){
                       
                try {
                   
                    String  dig  =  instance.doOCR(dni[k]);
                    dig = dig.trim();
                    if(!dig.isEmpty())
                        numero += dig.charAt(0);
                    else 
                        numero += "0";  // Los digitos no identificados  le coloca cero por defecto
                    
                
                } catch (TesseractException ex) {
                    Logger.getLogger(Recorte.class.getName()).log(Level.SEVERE, null, ex);
                }
                       
                   
                   }
                       System.out.println(numero);
                       
                ArrayList<String> nombres2 = extraerNombre(registros[i]);
//                ImagePlus imp=new ImagePlus("let",nombres.get(0));
//                imp.show();        
                ArrayList<String> apellidos2 = extraerApellidos(registros[i]);
                //Configuracion del OCR de Letras
                Tesseract instance2 = new Tesseract();
                instance2.setLanguage("spa");
                String nombre = "";
                String apell = "";
                String ap;
                
                ArrayList<String> nombresE=null;
                nombresE=RevisaNombre(nombres2);
//                for(int k=0;k<nombresE.size();k++){
//                    System.out.println("N: "+nombresE.get(k));
//                }      
//                System.out.println("");
                ArrayList<String> apellidosE=null;
                apellidosE=RevisaApellido(apellidos2);
//                for(int k=0;k<apellidosE.size();k++){
//                    System.out.println("A: "+apellidosE.get(k));
//                }
                ArrayList<String> lDniOcrL=new ArrayList<String>();
                lDniOcrL=nombresE;
                for(int k=0;k<apellidosE.size();k++){
                    if(!lDniOcrL.contains(apellidosE.get(k))){
                        lDniOcrL.add(apellidosE.get(k));
                    }
                }
                for(int k=0;k<lDniOcrL.size();k++){
                    System.out.println(lDniOcrL.get(k));
                }

                
                int ubigeo = 0;
                if(partido.getIdTipoProceso() == 1) ubigeo  = -1;
                if(partido.getIdTipoProceso() == 2) ubigeo  = Manager.queryByIdRegion(partido.getIdRegion()).getUbigeo();
                if(partido.getIdTipoProceso() == 3) ubigeo  = Manager.queryByIdDistrito(partido.getIdDistrito()).getUbigeo();
                if(partido.getIdTipoProceso() == 4) ubigeo  = Manager.queryLocalById(partido.getIdLocal()).getUbigeo();
                if(partido.getIdTipoProceso() == 5) ubigeo  = Manager.queryInstitucionById(partido.getIdInstitucion()).getUbigeo();
                
                
                
                 int ubigeoPadron=buscarUbigeo(numero);
                if(ubigeo==-1 || ubigeo==ubigeoPadron){
                    System.out.println("  Ubigeo Correcto");
                BufferedImage ImagenPadronHuella=extraerHuella(registros[i]);
                BufferedImage ImagenPadronFirma=extraerFirma(registros[i]);
                //Imagenes del repositorio
                ImagenHuella=null;
                ImagenFirma=null;
                buscarImagenes(numero);//modifica la imagen huella y imagen firma
               
                double porcentaje_firma, porcentaje_huella;
                int esta=0;
                if(ImagenHuella!=null && ImagenFirma!=null){
                    porcentaje_firma = Algoritmo_Firma2.validarFirma(ImagenFirma, ImagenPadronFirma);
                    porcentaje_huella = Algoritmo_Huellas.VerificaHuella(ImagenHuella, ImagenPadronHuella);//No se para que ramon utiliza esta variable
                    int criterio = validarAprobacion(porcentaje_firma, porcentaje_huella);
                    System.out.println("");
                    
                    if(criterio!=registro_rechazado){
                        Adherente adherente= new Adherente();
                        adherente.setDni(numero);
                        if(criterio==registro_aprobado)
                            adherente.setEstado("Aprobado");
                        if(criterio==registro_observado)
                            adherente.setEstado("Observado");
                        
                        for(int w=0;w<listaAdherente.size();w++){
                            if(listaAdherente.get(w).getDni().equals(numero)){
                                esta=1;
                                break;
                            }
                        }
                        if(esta==0)
                            listaAdherente.add(adherente);
                    }                   
                    
                }
                else
                    System.out.println("No se encontro a las personas con DNI: " + numero);            
                }
            
            }
//            
//            int ancho = Math.round(registros[0].getWidth()*(float)0.02);
//            BufferedImage numero1 = test.getSubimage(0, 0, ancho, registros[0].getHeight());    
//            BufferedImage[] dni = extraerDni(registros[0]);
//            BufferedImage huella = extraerHuella(registros[0]);
//            String numS=new String();
//            for(int i=0;i<cantDni;i++){
//                int num = OcrNumeros.obtenerNumero(dni[i]);
//                numS+=num;
//                //System.out.println("numero: "+num);
//            }            
//            numS="34576713";//Solo para probar q funcione
//            System.out.println("DNI: " + numS);
//            //Imagenes de los padrones, ceci en esta parte pones lo que extraes del padron
//            BufferedImage ImagenPadronHuella=extraerHuella(registros[0]);
//            BufferedImage ImagenPadronFirma=extraerFirma(registros[0]);
//            //Imagenes del repositorio
//            ImagenHuella=null;
//            ImagenFirma=null;
//            buscarImagenes(numS);//modifica la imagen huella y imagen firma
//            if(ImagenHuella!=null && ImagenFirma!=null){
//                Algoritmo_Firma2.validarFirma(ImagenFirma, ImagenPadronFirma);
//                Algoritmo_Huellas.VerificaHuella(ImagenHuella, ImagenPadronHuella);//No se para que ramon utiliza esta variable
//            }
//            else
//                System.out.println("No se encontro a las personas con DNI: " + numS);
            
            
        } catch (IOException ex) {
            Logger.getLogger(Recorte.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return 1;
    }
    
    public static void main(String[] args) throws TesseractException {
        // TODO code application logic here
        //File file = new File("C:\\Users\\alulab14.INF\\Downloads\\alternado_ok_rayado_v1.jpg");
        File file = new File("D:\\Base Datos/Padron_PlantillaN1.jpg");
        BufferedImage test;
        int inicioX, inicioY, finX, finY;
        String nombre2 = "";
        ITesseract instance  = new Tesseract();
         ArrayList<String> p = new ArrayList<>();
        p.add("digits");
        instance.setConfigs(p);
        instance.setLanguage("dit");
        
        try {
            test = ImageIO.read(file);
            test = binarization(test);
            //ImageIO.write(test, "jpg", new File("C:\\Users\\alulab14\\Downloads\\bin.jpg"));
            test = extraerCuadroData(test);
            BufferedImage[] registros = extraerRegistros(test);
            int ancho = Math.round(registros[0].getWidth()*(float)0.02);
            BufferedImage numero1 = test.getSubimage(0, 0, ancho, registros[0].getHeight());    
  //          BufferedImage[] dni = extraerDni(registros[0]);
     //       extraerFirma(registros[0]);
     String numero ;
            for(int k=0;k<registros.length;k++){
                BufferedImage dniComp = extraerDniUnaImagen(registros[k]);                
//                ArrayList<BufferedImage> nombres = extraerNombre(registros[k]);
                String nombre = ""; String identidad ="";
                nombre2="";
                BufferedImage[] dni = extraerDni(registros[k]);
               // ImageIO.write(dniComp, "png", new File("src\\red\\dni.png"));
                
               // for(int i = 0 ; i < dni.length ; i++){
                
            
                  
                numero = "";
                        for(int i = 0;   i < dni.length ; i++){
                       
                try {
                    String  dig  =  instance.doOCR(dni[i]);
                    dig = dig.trim();
                    if(!dig.isEmpty())
                        numero += dig.charAt(0);
                    else 
                        numero += "*";
                    
                
                } catch (TesseractException ex) {
                    Logger.getLogger(Recorte.class.getName()).log(Level.SEVERE, null, ex);
                }
                       
                   
                   }
                       System.out.println(numero);
                    
                
                
            
            int valo = 0;
      
            
              Tesseract instance2 = new Tesseract();
                instance2.setLanguage("spa");
           
                
//                for(int i=0;i<nombres.size();i++){
//                    try {                        
//                      
//                        nombre2 += instance2.doOCR(nombres.get(i));
//                    } catch (Exception ex) {
//                        Logger.getLogger(Recorte.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
            }
            System.out.println(nombre2);
            
                /*
                 BufferedImage[] dnixx = extraerDni(registros[k]);
                //BufferedImage huella = extraerHuella(registros[i]);
                String numS=new String();//DNI en string
                
                for(int j=0;j<cantDni;j++){
                    int num = OcrNumeros.obtenerNumero(dnixx[j]);
                     
                    numS+=num;
                }
                
                
                
                identidad = executeTesseractNumbers("dni.png");
                
                
                identidad  = identidad.trim();
                identidad  = identidad.substring(0, 7);
                
                char[] mmm = identidad.toCharArray();
                char[] nnn = numS.toCharArray();
                for(int i = 0 ;  i < identidad.length(); i++){
                    
                    if (mmm[i] != nnn[i]) mmm[i] = nnn[i];
                
                    
                
                }
                
               identidad = String.valueOf(mmm);
                
                System.out.println("el dni es:" + identidad +" y el nombre es: "+nombre+" con cantidad i: "+nombres.size());
        */  //  }
          /*
            for(int i=0;i<cantDni;i++){
                int num = OcrNumeros.obtenerNumero(dni[i]);
                //System.out.println("numero: "+num);
            }*/
        } catch (IOException ex) {
            Logger.getLogger(Recorte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   // }
    
    private static int buscarUbigeo(String dni){    
        String dn = null;
        double d=-1;
        int nd=Integer.parseInt(dni);
        int ubigeo=0;
       try {           
//                InputStream ExcelFileToRead = new FileInputStream("C:/Users/Raul/Desktop/inf226.2016.1._06.proyecto/registro.nacional.v.1.xlsx");
                InputStream ExcelFileToRead = new FileInputStream(Recorte.rutaGeneral);
                XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell;
		Iterator rows = sheet.rowIterator();
                row=(XSSFRow) rows.next();
                while (rows.hasNext())
		{
			row=(XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
                        int i=0;
			while (cells.hasNext())
			{
				cell=(XSSFCell) cells.next();
                                if(i==2)
                                {
                                    d=cell.getNumericCellValue();
                                    int num=(int) d;
                                    dn=num+"";
                                }
                                if(dn!=null){
                                    if(d==nd){
                                        if(i==3){
                                            double dh=cell.getNumericCellValue();
                                            ubigeo=(int) dh;
                                            return ubigeo;
                                        }
                                    }
                                }
                                i++;
			}                       
                        i=0;
		}
       } catch (FileNotFoundException ex) {
           Logger.getLogger(Recorte.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(Recorte.class.getName()).log(Level.SEVERE, null, ex);
       }    
       return ubigeo;
    }

    
    private static ArrayList<String> RevisaNombre(ArrayList<String> arrNomb){
        ArrayList<String> nombresE=new ArrayList<String>();
        ArrayList<String> dniE=new ArrayList<String>();
        int gd=0;
        try {           
//                InputStream ExcelFileToRead = new FileInputStream("D:/repositorio/GRUPO02/b.rnv.xlsx");
                InputStream ExcelFileToRead = new FileInputStream(Recorte.rutaGeneral);
                XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell;
		Iterator rows = sheet.rowIterator();
                row=(XSSFRow) rows.next();
                while (rows.hasNext())
		{
                        gd=0;
			row=(XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
                        int i=0;
			while (cells.hasNext())
			{
				cell=(XSSFCell) cells.next();
                                if(i==0)
                                {
                                    String dh=cell.getStringCellValue();
                                    dh=dh.toUpperCase();
                                    for(int j=0;j<arrNomb.size();j++){
                                        String nom=arrNomb.get(j).toUpperCase().trim();
                                        if(nom.compareTo(dh)==0){
                                            nombresE.add(dh);
                                            gd=1;
                                        }
                                    }
                                    if(gd!=1)break;
                                }
                                if(i==2 && gd==1){
                                    double d2=cell.getNumericCellValue();
                                    int num=(int) d2;
                                    String dn=num+"";
                                    dniE.add(dn);
                                    break;
                                }
                                i++;
			}                       
                        i=0;
		}
       } catch (FileNotFoundException ex) {
           Logger.getLogger(Recorte.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(Recorte.class.getName()).log(Level.SEVERE, null, ex);
       }        
        return dniE;
    }
 
     private static ArrayList<String> RevisaApellido(ArrayList<String> arrNomb){
        ArrayList<String> nombresE=new ArrayList<String>();
        ArrayList<String> dniE=new ArrayList<String>();
        int gd=0;
        try {           
//                InputStream ExcelFileToRead = new FileInputStream("D:/repositorio/GRUPO02/b.rnv.xlsx");
                InputStream ExcelFileToRead = new FileInputStream(Recorte.rutaGeneral);
                XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell;
		Iterator rows = sheet.rowIterator();
                row=(XSSFRow) rows.next();
                while (rows.hasNext())
		{
                        gd=0;
			row=(XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
                        int i=0;
			while (cells.hasNext())
			{
				cell=(XSSFCell) cells.next();
                                if(i==1)
                                {
                                    String dh=cell.getStringCellValue();
                                    dh=dh.toUpperCase();
                                    for(int j=0;j<arrNomb.size();j++){
                                        String nom=arrNomb.get(j).toUpperCase().trim();
                                        if(nom.compareTo(dh)==0){
                                            nombresE.add(dh);
                                            gd=1;
                                        }
                                    }
                                    if(gd!=1)break;
                                }
                                if(i==2 && gd==1){
                                    double d2=cell.getNumericCellValue();
                                    int num=(int) d2;
                                    String dn=num+"";
                                    dniE.add(dn);
                                    break;
                                }
                                i++;
			}                       
                        i=0;
		}
       } catch (FileNotFoundException ex) {
           Logger.getLogger(Recorte.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(Recorte.class.getName()).log(Level.SEVERE, null, ex);
       }        
        return dniE;
    }
    
    
    private static void buscarImagenes(String dni){        
        ImagenHuella=null;
        ImagenFirma=null;
        String dn = null;
        double d=-1;
        int nd=Integer.parseInt(dni);
       try {
//                InputStream ExcelFileToRead = new FileInputStream("C:/Users/Raul/Desktop/inf226.2016.1._06.proyecto/registro.nacional.v.1.xlsx");
                InputStream ExcelFileToRead = new FileInputStream(Recorte.rutaGeneral);
                XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell;
		Iterator rows = sheet.rowIterator();
                row=(XSSFRow) rows.next();
                int salir=0;
                
                while (rows.hasNext())
		{
			row=(XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
                        int i=0;
			while (cells.hasNext())
			{
				cell=(XSSFCell) cells.next();
                                if(i==2)
                                {
                                    d=cell.getNumericCellValue();
                                    int num=(int) d;
                                    dn=num+"";
//                                    System.out.print("dni: "+num+" ");
                                }
                                if(dn!=null){
                                    if(d==nd){
                                        
                                        if(i==4){
                                            String dh=cell.getStringCellValue();
                                            String dr=null;
                                            dr=Recorte.rutaHuella+"/"+dh+".jpg";
                                            File file = new File(dr);
                                            ImagenHuella= ImageIO.read(file);
                                            salir=1;  
                                        }
                                        
                                        /*
                                        if(i==4){
                                            double dh=cell.getNumericCellValue();
                                            int num=(int) dh;
                                            String dr=null;
                                            if(num<10){
//                                                dr="C:/Users/Raul/Desktop/inf226.2016.1._06.proyecto/huellas.jpg/00"+num+".jpg";
                                                dr=Recorte.rutaHuella+"/00"+num+".jpg";
                                            } 
                                            else
                                            if(num>9 && num<100){
//                                                dr="C:/Users/Raul/Desktop/inf226.2016.1._06.proyecto/huellas.jpg/0"+num+".jpg";
                                                dr=Recorte.rutaHuella+"/0"+num+".jpg";
                                            }
                                            else{
                                                System.out.println("c");
//                                                dr="C:/Users/Raul/Desktop/inf226.2016.1._06.proyecto/huellas.jpg/"+num+".jpg";
                                                dr=Recorte.rutaHuella+"/"+num+".jpg";
                                            }
                                            File file = new File(dr);
                                            ImagenHuella= ImageIO.read(file);
                                            
//                                            cell=(XSSFCell) cells.next();
//                                            i++;
                                        }*/
                                        if(i==5){
                                            String dh=cell.getStringCellValue();
                                            String dr=null;
//                                            dr="C:/Users/Raul/Desktop/inf226.2016.1._06.proyecto/firmas.jpg/"+dh+".jpg";
                                            dr=Recorte.rutaFirma+"/"+dh+".jpg";
                                            File file = new File(dr);
                                            ImagenFirma= ImageIO.read(file);
                                            salir=1;
                                            
                                            
                                        }
                                    }
                                }
                                i++;
			}                       
                        i=0;
                        if(salir==1)
                                    break;
		}
       } catch (FileNotFoundException ex) {
           Logger.getLogger(Recorte.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(Recorte.class.getName()).log(Level.SEVERE, null, ex);
       }    
       
    }
}




