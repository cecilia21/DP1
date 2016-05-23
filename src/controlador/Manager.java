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
//        procesoNacionalDB.update(proceso);
        System.out.println("se actualizo el proceso de votacion con id igual a "+proceso.getId()+" y los siguientes datos "+proceso.getFechaInicio1()+" "+proceso.getFechaFin1()+" "+proceso.getPorcentajeMinimo());
    }
    
    public static TipoProcesoVotacion queryProcesoById(int idProceso)
    {        
        return procesoNacionalDB.queryById(idProceso);
    }
    
    /////////REGIONAL
    
     public static void addRegion(Region i)
    {
//        procesoRegionDB.add(i);
        System.out.println("Se registro la region con id igual a "+i.getId()+" y nombre "+i.getNombre());
    }
    public static void updateRegion(Region i)
    {
//        procesoRegionDB.updateRegion(i);
        System.out.println("Se actualizo la region con id igual a "+i.getId()+" y nombre "+i.getNombre());
    }
    public static void deleteRegion (int idRegion)
    {
//        procesoRegionDB.deleteRegion(idRegion);
        System.out.println("Se borro la region con id igual a "+idRegion);
    }
    public static ArrayList<Region> queryAllRegion()
    {
        ArrayList<Region> listaRegiones=new ArrayList<Region>();
        listaRegiones.add(new Region(1,"Lima",15000));
        listaRegiones.add(new Region(2,"Arequipa",10000));
        listaRegiones.add(new Region(3,"Junin",12000));
        return listaRegiones;
//        return procesoRegionDB.queryAllRegions();
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
