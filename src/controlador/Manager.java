/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import model.TipoProcesoVotacion;

/**
 *
 * @author RAMON
 */
public class Manager {
    
    private static ProcesoRegionDB procesoRegionDB = new ProcesoRegionDB();
    private static ProcesoNacionalDB procesoNacionalDB = new ProcesoNacionalDB(); 
    
    public static void addProcesoNacional(TipoProcesoVotacion proceso)
    {
        procesoNacionalDB.add(proceso);
        System.out.println(proceso.getFechaInicio1()+" "+proceso.getFechaInicio2()+" "+proceso.getPorcentajeMinimo());
    }
    
    public static void addProcesoTableRegions()
    {
        
    }
    
}
