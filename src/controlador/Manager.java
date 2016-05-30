/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Distrito;
import model.Institucion;
import model.Local;
import model.Region;
import model.PartidoPolitico;
import model.TipoProcesoVotacion;

/**
 *
 * @author RAMON
 */
public class Manager {
    
    private static ProcesoRegionDB procesoRegionDB = new ProcesoRegionDB();
    private static TipoProcesoDB tipoprocesoDB = new TipoProcesoDB(); 
    private static PartidoPoliticoDB partidoDB = new PartidoPoliticoDB(); 
    private static ProcesoDistritoDB procesoDistritoDB = new ProcesoDistritoDB(); 
    private static ProcesosLocalDB procesoLocalDB = new ProcesosLocalDB();
    
    public static void addPartido(PartidoPolitico p){
        partidoDB.add(p);
    }
    
    public static ArrayList<PartidoPolitico> queryPartidoByNombTipoLug(String nombre, int ind1, int ind2){
        return partidoDB.queryByNombTipoLug(nombre, ind1, ind2);
    }
    
    public static ArrayList<PartidoPolitico> queryPartidoByNombTipo(String nombre, int ind1){
        return partidoDB.queryByNombTipo(nombre, ind1);
    }
    
    private static ProcesoInstitucionalDB procesoInstitucionalDB = new ProcesoInstitucionalDB();
    
    public static ArrayList<PartidoPolitico> queryPartidoByName(String nombre){
        return partidoDB.queryByName(nombre);
    }
    
    public static int[] queryTipoProcesoNombrePartido(String nombre){
        return partidoDB.queryTipoProcesoNombrePartido(nombre);
    }
    
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
        tipoprocesoDB.update(proceso);
//        System.out.println("se actualizo el proceso de votacion con id igual a "+proceso.getId()+" y los siguientes datos "+proceso.getFechaInicio1()+" "+proceso.getFechaFin1()+" "+proceso.getPorcentajeMinimo());
    }
    
    public static TipoProcesoVotacion queryProcesoById(int idProceso)
    {
//        TipoProcesoVotacion tipo=new TipoProcesoVotacion();        
//        return tipo;
        return tipoprocesoDB.queryById(idProceso);
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
//        ArrayList<Region> listaRegiones=new ArrayList<Region>();
//        listaRegiones.add(new Region(1,"Lima",15000));
//        listaRegiones.add(new Region(2,"Arequipa",10000));
//        listaRegiones.add(new Region(3,"Junin",12000));
//        return listaRegiones;
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
    
    public static ArrayList<TipoProcesoVotacion> queryAllTipoProceso(){
        return tipoprocesoDB.queryAll();
    }
    
    /////////FIN REGIONAL
    
    ///////DISTRITAL
    
    public static void addDistrito(Distrito i)
    {
//        procesoDistritoDB.add(i);
        System.out.println("Se registro la distrito con id igual a "+i.getId()+" y nombre "+i.getNombre());
    }
    public static void updateDistrito(Distrito i)
    {
//        procesoDistritoDB.updateDistrito(i);
        System.out.println("Se actualizo la distrito con id igual a "+i.getId()+" y nombre "+i.getNombre());
    }
    public static void deleteDistrito (int idDistrito)
    {
//        procesoDistritoDB.deleteDistrito(idDistrito);
        System.out.println("Se borro la distrito con id igual a "+idDistrito);
    }
    public static ArrayList<Distrito> queryAllDistrito()
    {
        return procesoDistritoDB.queryAllDistritos();
    }
    
    public static Distrito queryByIdDistrito(int id)
    {
        return procesoDistritoDB.queryById(id);
    }
    
    public static Distrito queryByNameDistrito(String name)
    {
        return procesoDistritoDB.queryByName(name);
    }
    
    /////FIN DISTRITAL
    
    ///LOCALES
    
      public static void addLocal(Local l)
     {
         procesoLocalDB.add(l);
       
    }
    public static void updateLocal(Local l)
    {
        procesoLocalDB.update(l);
    }
    public static void deleteLocal(int idLocal)
    {
        procesoLocalDB.delete(idLocal);
    }
    public static ArrayList<Local> queryAllLocales()
    {
        return    procesoLocalDB.queryAll();
    }
    public static Local queryLocalById(int localId) {
        
        return    procesoLocalDB.queryById(localId);
       
    }
    
    public static ArrayList<Local> queryLocalByName(String nombre){
    
        
        
        return procesoLocalDB.queryByName(nombre);        
    
    }
    
    
    //fIN LOCALES
    
    
    
}
