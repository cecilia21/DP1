/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.dao.DAOFactory;
import controlador.dao.DAORegion;
import controlador.dao.DBConnection;
import java.util.ArrayList;
import model.Region;

/**
 *
 * @author RAMON
 */
public class ProcesoRegionDB {
    private ArrayList<Region> regionList = new ArrayList<Region>();
    DAOFactory daoFactory = DAOFactory.getDAOFactory(DBConnection.dbType);
    DAORegion daoRegion = daoFactory.getDAORegion();    
    
    
}
