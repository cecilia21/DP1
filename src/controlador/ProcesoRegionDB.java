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
    
    public ProcesoRegionDB(){
        
    }
    
    public void add(Region r)
    {
        daoRegion.add(r);
    }
    public void updateRegion(Region p)
    {
        daoRegion.update(p);
    }
    public void deleteRegion(int idRegion)
    {
        daoRegion.delete(idRegion);
    }
    public ArrayList<Region> queryAllRegions()
    {
        return daoRegion.queryAll();
    }
    
    public Region queryById(int id)
    {
        return daoRegion.queryById(id);
    }
    
    public ArrayList<Region> queryByName(String name)
    {
        return daoRegion.queryByName(name);
    }
}
