/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import model.Institucion;
import model.Region;
import model.PartidoPolitico;
import model.TipoProcesoVotacion;

/**
 *
 * @author RAMON
 */
public class Manager {
    
    private static ProcesoRegionDB procesoRegionDB = new ProcesoRegionDB();
    private static ProcesoNacionalDB procesoNacionalDB = new ProcesoNacionalDB(); 
    private static PartidoPoliticoDB partidoDB = new PartidoPoliticoDB(); 
    
    public static void addPartido(PartidoPolitico p){
        partidoDB.add(p);
    }
    private static ProcesoInstitucionalDB procesoInstitucionalDB = new ProcesoInstitucionalDB();
    
    /////////INSTITUCIONAL
    
     public static void addInstitucion(Institucion i)
    {
        procesoInstitucionalDB.add(i);
    }
    public static void updateInstitucion(Institucion i)
    {
        procesoInstitucionalDB.update(i);
    }
    public static void deleteInstitucion(int idProduct)
    {
        procesoInstitucionalDB.delete(idProduct);
    }
    public static ArrayList<Institucion> queryAllInstitucion()
    {
        return procesoInstitucionalDB.queryAll();
    }
    public static Institucion queryInstitucionById(int institucionId) {
        return procesoInstitucionalDB.queryById(institucionId);
    }
    
    /////////FIN INSTITUCIONAL
   
    public static void updateProceso(TipoProcesoVotacion proceso)
    {        
        procesoNacionalDB.update(proceso);
//        System.out.println(proceso.getFechaInicio1()+" "+proceso.getFechaInicio2()+" "+proceso.getPorcentajeMinimo());
    }
    
    public static TipoProcesoVotacion queryProcesoById(int idProceso)
    {        
        return procesoNacionalDB.queryById(idProceso);
    }
    
    /////////REGIONAL
    
     public static void addRegion(Region i)
    {
        procesoRegionDB.add(i);
    }
    public static void updateRegion(Region i)
    {
        procesoRegionDB.updateRegion(i);
    }
    public static void deleteRegion (int idRegion)
    {
        procesoRegionDB.deleteRegion(idRegion);
    }
    public static ArrayList<Region> queryAllRegion()
    {
        return procesoRegionDB.queryAllRegions();
    }
    
    public static Region queryByIdRegion(int id)
    {
        return procesoRegionDB.queryById(id);
    }
    
    public static Region queryByNameRegion(String name)
    {
        return procesoRegionDB.queryByName(name);
    }
    
    /////////FIN REGIONAL
    
}
