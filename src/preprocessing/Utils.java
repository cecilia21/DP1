/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preprocessing;

import algoritmos.Recorte;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author USUARIO
 */


public class Utils {
    private static String tesseract = "src\\red\\Tesseract-OCR";
    private static String carpeta_temp = "src\\red\\";
    /*
    public static void main(String args[]){
        validarRutaGeneral("C:\\Users\\Cecilia\\Desktop\\Libro1.xlsx");
        //cumpleFormatoExcelRNV("C:\\Users\\Cecilia\\Desktop\\Libro1.xlsx");
        //cumpleFormatoExcelRNV("D:\\Users\\Cecilia\\Downloads\\registro.nacional.v.1.xlsx");
        BufferedImage img;
        try {
            img = ImageIO.read(new File("D:\\Users\\Cecilia\\Documents\\cecilia\\DP1\\pruebas/todo.jpg"));
            int num = validarPlanillon(img);
            System.out.println(""+num);
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   */
    public static boolean validarRutaGeneral(String ruta){
        if(new File(ruta)==null) return false;
        if(!new File(ruta).exists()) return false;
        File[] files = new File(ruta).listFiles();
        if(new File(ruta).isDirectory()||files!=null){
            if(files.length>3) return false;
            for(int i=0;i<files.length;i++){
                String ext = FilenameUtils.getExtension(files[i].getName());
                if(ext.compareTo("xlsx")==0) return true;
            }
            return false;
        } else{
            String ext = FilenameUtils.getExtension(new File(ruta).getName());
            if(ext.compareTo("xlsx")==0) return true;
            return false;
        }
    }
    public static boolean validarRutaImagenHuella(String imagen, int cantRegistros){
        if(new File(imagen)==null) return false;
        if(!new File(imagen).exists()) return false;
        if(new File(imagen).isDirectory()){
            File[] files = new File(imagen).listFiles();
            if(files.length<cantRegistros) return false;
            int cantJPgs = 0;
            for(int i=0;i<files.length;i++){
                String ext = FilenameUtils.getExtension(files[i].getName());
                if(ext.compareTo("jpg")==0) cantJPgs++;
            }
            if(cantJPgs<cantRegistros) return false;
            return true;
        }
        return false;
    }
    
    public static int cumpleFormatoExcelRNV(String ruta){
        InputStream ExcelFileToRead = null;
        try {
            //regresa -1 si NO cumpel formato
            // de lo contrario regresa la cantidad de registros que tiene
            ExcelFileToRead = new FileInputStream(ruta);
            XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
            XSSFSheet sheet = wb.getSheetAt(0);
            XSSFRow row;
            XSSFCell cell;
            Iterator rows = sheet.rowIterator();
            row=(XSSFRow) rows.next();
            Iterator cells = row.cellIterator();
            cell=(XSSFCell) cells.next();
            if(cell.getCellType() != XSSFCell.CELL_TYPE_STRING) return -1;
            String dh=cell.getStringCellValue();
            dh=dh.toUpperCase();
            if(dh.compareTo("NOMBRE")!=0) return -1;
            cell=(XSSFCell) cells.next();
            if(cell.getCellType() != XSSFCell.CELL_TYPE_STRING) return -1;
            dh=cell.getStringCellValue();
            dh=dh.toUpperCase();
            if(dh.compareTo("APELLIDOS")!=0) return -1;
            cell=(XSSFCell) cells.next();
            if(cell.getCellType() != XSSFCell.CELL_TYPE_STRING) return -1;
            dh=cell.getStringCellValue();
            dh=dh.toUpperCase();
            if(dh.compareTo("DNI")!=0) return -1;
            cell=(XSSFCell) cells.next();
            if(cell.getCellType() != XSSFCell.CELL_TYPE_STRING) return -1;
            dh=cell.getStringCellValue();
            dh=dh.toUpperCase();
            if(dh.compareTo("UBIGEO")!=0) return -1;
            cell=(XSSFCell) cells.next();
            if(cell.getCellType() != XSSFCell.CELL_TYPE_STRING) return -1;
            dh=cell.getStringCellValue();
            dh=dh.toUpperCase();
            if(!dh.matches("HUELLA.*")) return -1;
            cell=(XSSFCell) cells.next();
            if(cell.getCellType() != XSSFCell.CELL_TYPE_STRING) return -1;
            dh=cell.getStringCellValue();
            dh=dh.toUpperCase();
            if(!dh.matches("FIRMA.*")) return -1;
            int cant = 0;
            while(rows.hasNext()){
                row = (XSSFRow) rows.next();
                cells = row.cellIterator();
                cell=(XSSFCell) cells.next();
                if(cell.getCellType() != XSSFCell.CELL_TYPE_STRING) break;
                cant++;
            }
            return cant;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ExcelFileToRead.close();
            } catch (IOException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return -1;
    }
    
    private static boolean esLineaNegra(int[] linea){
        double porcentaje = 0.7*linea.length;
        int negros=0;
        for(int i=0;i<linea.length;i++)
            if(linea[i]==-16777216) negros++;
            //if(linea[i]!=-1) negros++;
        if(negros>=porcentaje) return true;
        return false;
    }
    
    public static int validarPlanillon(BufferedImage test){
        if(test.getWidth()<1200 || test.getHeight()<500) return -1;
        int inicioY = 0;
        int inicioX = 0;
        int finY = test.getHeight()-1;
        int finX = test.getWidth() -1;
        for(int i=5;i<test.getHeight()/4;i++){
            int[] linea = new int[test.getWidth()];
            for(int j=0;j<test.getWidth();j++)
                linea[j]=test.getRGB(j, i);
            if(esLineaNegra(linea)){
                inicioY = i+1;
                break;
            }
        }
        for(int i=5;i<test.getWidth()/4;i++){
            int[] linea=new int[test.getHeight()];
            for(int j=0;j<test.getHeight();j++)
                linea[j] = test.getRGB(i, j);
            if(esLineaNegra(linea)){
                inicioX = i+1;
                break;
            }
        }
        for(int i=test.getWidth()-7;i>test.getWidth()/2;i--){
            int[] linea = new int[test.getHeight()];
            for(int j=0;j<test.getHeight();j++)
                linea[j]=test.getRGB(i, j);
            if(esLineaNegra(linea)){
                finX = i-1;
                break;
            }
        }
        for(int i=test.getHeight()-5;i>test.getHeight()/2;i--){
            int[] linea= new int[test.getWidth()];
            for(int j=0;j<test.getWidth();j++)
                linea[j]=test.getRGB(j, i);
            if(esLineaNegra(linea)){
                finY = i-1;
                break;
            }
        }
        if(finY<inicioY || finX<inicioX) return -1;
        if((finY-inicioY)<400 || (finX-inicioX)<1200) return -1;
        return 1;
    }
    
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
        String[] commands = {tesseract+"\\tesseract",carpeta_temp+""+file, 
            "stdout", "-psm 8", "letters"};
        Process proc = rt.exec(tesseract+"\\tesseract "+carpeta_temp+""+file+" stdout -psm 8 nodict letters");

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
        BufferedImage nuevo = numero1;
        if(proporcionX ==-1) proporcionX = 1;
        if(proporcionY ==-1) proporcionY = 1;
        int inicioY, inicioX, finY, finX;
        inicioY = 0;
        for(int i=0;i<numero1.getHeight()/proporcionY;i++){
            int[] linea = new int[numero1.getWidth()];
            for(int j=0;j<numero1.getWidth();j++)
                linea[j]=numero1.getRGB(j, i);
            if(esLineaNegra(linea)){
                 inicioY = i+1;   
            }
        }

        finY = numero1.getHeight()-1;
        for(int i=numero1.getHeight()-1;i>(numero1.getHeight()-(numero1.getHeight()/proporcionY));i--){
            int[] linea= new int[numero1.getWidth()];
            for(int j=0;j<numero1.getWidth();j++)
                linea[j]=numero1.getRGB(j, i);
            if(esLineaNegra(linea)){
                finY = i-1;
            }
        }

        inicioX = 0;
        for(int i=0;i<numero1.getWidth()/proporcionX;i++){
            int[] linea=new int[numero1.getHeight()];
            for(int j=0;j<numero1.getHeight();j++)
                linea[j] = numero1.getRGB(i, j);
            if(esLineaNegra(linea)){
                inicioX =i+1;
            }
        }

        finX = numero1.getWidth()-1;
        for(int i=numero1.getWidth()-1;i>(numero1.getWidth()-(numero1.getWidth()/proporcionX));i--){
            int[] linea = new int[numero1.getHeight()];
            for(int j=0;j<numero1.getHeight();j++)
                linea[j]=numero1.getRGB(i, j);
            if(esLineaNegra(linea)){
                finX=i-1;
            }
        }        
        return numero1.getSubimage(inicioX, inicioY, (finX-inicioX),(finY-inicioY));
    }
}
