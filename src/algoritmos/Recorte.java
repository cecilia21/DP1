/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import controlador.Manager;
import ij.ImagePlus;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import model.Adherente;
import model.PartidoPolitico;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
    
    private static BufferedImage extraerCuadritos(int iniCuadro, int cantCuadros, BufferedImage registro){
        int iniX=0;
        int ancho;
        int cuadrosRecorridos = 0;
        int cuadroInicio = 0;
        int ultimaColumnaRecorrida = iniX;
        for(int i=20;i<registro.getWidth();i++){
            for(int j=0;j<registro.getHeight();j++){
                if(registro.getRGB(i, j)!=-16777216) break;
                if(j+1==registro.getHeight()){
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
            }
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
    
    private static ArrayList<BufferedImage> extraerNombre(BufferedImage registro){
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
            if(esCuadroBlanco(letra)==0){ //si no es cuadro blanco
                if(cuadroAnt+1==i){
                    iniX = i*nombre.getWidth()/25;
                    finX = 0;
                }
                finX +=nombre.getWidth()/25;
                letra = cropper(letra);
                g.drawImage(letra, i*nombre.getWidth()/25, 20, null);
            }else{
                if(i>1 && i!=cuadroAnt+1){
                    BufferedImage app = result.getSubimage(iniX, 0, finX, alto+40);
                    nombres.add(app);
                }
                cuadroAnt = i;
            }
            if(i==1) alto = letra.getHeight();
        }        
        return nombres;
    }
    
    private static ArrayList<BufferedImage> extraerApellidos(BufferedImage registro){
        BufferedImage nombre = extraerCuadritos(9,25,registro);
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
            letra = limpiarBordeImagen(letra,2,4);
            letra = removeNoisePoints(letra);
            if(esCuadroBlanco(letra)==0){ //si no es cuadro blanco
                if(cuadroAnt+1==i){
                    iniX = i*nombre.getWidth()/25;
                    finX = 0;
                }
                finX +=nombre.getWidth()/25;
                letra = cropper(letra);
                g.drawImage(letra, i*nombre.getWidth()/25, 20, null);
            }else{
                if(i>1 && i!=cuadroAnt+1){
                    BufferedImage app = result.getSubimage(iniX, 0, finX, alto+40);
                    apellidos.add(app);
                }
                cuadroAnt = i;
            }
            if(i==1) alto = letra.getHeight();
        }
        return apellidos;
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
 
   public static void ejecutarProceso(File file, PartidoPolitico p){
        BufferedImage test;
        int inicioX, inicioY, finX, finY;
        try {
            test = ImageIO.read(file);
            test = binarization(test);
            //ImageIO.write(test, "jpg", new File("C:\\Users\\alulab14\\Downloads\\bin.jpg"));
            test = extraerCuadroData(test);
            BufferedImage[] registros = extraerRegistros(test);
            //lista de prueba
            ArrayList<String> listNumS=new ArrayList<String>();
            listNumS.add("34576713");listNumS.add("62346721");listNumS.add("34577732");listNumS.add("54322314");
            listNumS.add("23443281");listNumS.add("55443322");listNumS.add("78901234");listNumS.add("69384231");
            int ubigeo=0;
                if(p.getIdTipoProceso()==1)ubigeo=-1;
                if(p.getIdTipoProceso()==2)ubigeo=Manager.queryByIdRegion(p.getIdRegion()).getUbigeo();
                if(p.getIdTipoProceso()==3)ubigeo=Manager.queryByIdDistrito(p.getIdDistrito()).getUbigeo();
                if(p.getIdTipoProceso()==4)ubigeo=Manager.queryLocalById(p.getIdLocal()).getUbigeo();
                if(p.getIdTipoProceso()==5)ubigeo=Manager.queryInstitucionById(p.getIdInstitucion()).getUbigeo();
            for(int i=0;i<registros.length;i++){
                int ancho = Math.round(registros[i].getWidth()*(float)0.02);
                BufferedImage numero1 = test.getSubimage(0, 0, ancho, registros[i].getHeight());    
                BufferedImage[] dni = extraerDni(registros[i]);
//                BufferedImage huella = extraerHuella(registros[i]);              
                String numS=new String();
//                for(int j=0;j<cantDni;j++){
//                    int num = OcrNumeros.obtenerNumero(dni[j]);
//                    numS+=num;
//                }
//                numS="34576713";
                numS=listNumS.get(i);
                System.out.println("DNI: " + numS);                
                
                
                
                int ubigeoPadron=buscarUbigeo(numS);
                if(ubigeo==-1 || ubigeo==ubigeoPadron){
                    System.out.println("  Ubigeo Correcto");
                BufferedImage ImagenPadronHuella=extraerHuella(registros[i]);
                BufferedImage ImagenPadronFirma=extraerFirma(registros[i]);
                //Imagenes del repositorio
                ImagenHuella=null;
                ImagenFirma=null;
                buscarImagenes(numS);//modifica la imagen huella y imagen firma
                double porcentaje_firma, porcentaje_huella;
                if(ImagenHuella!=null && ImagenFirma!=null){
                    porcentaje_firma = Algoritmo_Firma2.validarFirma(ImagenFirma, ImagenPadronFirma);
                    porcentaje_huella = Algoritmo_Huellas.VerificaHuella(ImagenHuella, ImagenPadronHuella);//No se para que ramon utiliza esta variable
                    int criterio = validarAprobacion(porcentaje_firma, porcentaje_huella);
                    System.out.println("");
                }
                else
                    System.out.println("No se encontro a las personas con DNI: " + numS);            
            }System.out.println("-------Ubigeo incorrecto---");
            }
        } catch (IOException ex) {
            Logger.getLogger(Recorte.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }    
    
    public static void ejecutar(File file,ArrayList<Adherente> listaAdherente, PartidoPolitico partido){
        BufferedImage test;
        int inicioX, inicioY, finX, finY;
        try {
            test = ImageIO.read(file);
            test = binarization(test);
            
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
                       
              
          
                
                
                         
                ArrayList<BufferedImage> nombres = extraerNombre(registros[i]);
                //Configuracion del OCR de Letras
                Tesseract instance2 = new Tesseract();
                instance2.setLanguage("spa");
                String nombre = "";
                 for(int k=0;k<nombres.size();k++){
  
                        try {
                            nombre += instance2.doOCR(nombres.get(k));
                         
                        } catch (TesseractException ex) {
                            Logger.getLogger(Recorte.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                }
                 
                 System.out.println(nombre);
                

                
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
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        //File file = new File("D:\\Users\\Cecilia\\Downloads\\rayado_Modificados_v1.jpg");
        File file = new File("src/red/padron.rayas.firmado.jpg");
        BufferedImage test;
        int inicioX, inicioY, finX, finY;
        
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
                ArrayList<BufferedImage> nombres = extraerNombre(registros[k]);
                String nombre = ""; String identidad ="";
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
           
                
                for(int i=0;i<nombres.size();i++){
                    try {                        
                      
                        nombre += instance2.doOCR(nombres.get(i));
                    } catch (Exception ex) {
                        Logger.getLogger(Recorte.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
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




