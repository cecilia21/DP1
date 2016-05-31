/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.dao.DAOFactory;
import controlador.dao.DAORegion;
import controlador.dao.DAOTipoProcesoVotacion;
import controlador.dao.DBConnection;
import java.util.ArrayList;
import model.TipoProcesoVotacion;

/**
 *
 * @author RAMON
 */
public class TipoProcesoDB {
    
    private ArrayList<TipoProcesoVotacion> tipoProcesoList = new ArrayList<TipoProcesoVotacion>();
    DAOFactory daoFactory = DAOFactory.getDAOFactory(DBConnection.dbType);
    DAOTipoProcesoVotacion daoTipoProcesoVotacion = daoFactory.getDAOTipoProcesoVotacion();   
    
    public TipoProcesoDB(){
        
    }
    
    public void update(TipoProcesoVotacion p) {
        daoTipoProcesoVotacion.update(p);
//    	   System.out.println("base de datos");        
    }
    
    public TipoProcesoVotacion queryById(int id) {
        return daoTipoProcesoVotacion.queryById(id);
    }   
    
    public ArrayList<TipoProcesoVotacion> queryAll(){
        return daoTipoProcesoVotacion.queryAll();
    }
    
    public TipoProcesoVotacion queryByName(String nombre){
        return daoTipoProcesoVotacion.queryByName(nombre);
    }
    
}
