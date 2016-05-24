/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.dao.DAOFactory;
import controlador.dao.DAODistrito;
import controlador.dao.DBConnection;
import java.util.ArrayList;
import model.Distrito;

/**
 *
 * @author RAMON
 */
public class ProcesoDistritoDB {
    private ArrayList<Distrito> distritoList = new ArrayList<Distrito>();
    DAOFactory daoFactory = DAOFactory.getDAOFactory(DBConnection.dbType);
    DAODistrito daoDistrito = daoFactory.getDAODistrito();    
    
    public ProcesoDistritoDB(){
        
    }
    
    public void add(Distrito d)
    {
        daoDistrito.add(d);
    }
    public void updateDistrito(Distrito d)
    {
        daoDistrito.update(d);
    }
    public void deleteDistrito(int idDistrito)
    {
        daoDistrito.delete(idDistrito);
    }
    public ArrayList<Distrito> queryAllDistritos()
    {
        return daoDistrito.queryAll();
    }
    
    public Distrito queryById(int id)
    {
        return daoDistrito.queryById(id);
    }
    
    public Distrito queryByName(String name)
    {
        return daoDistrito.queryByName(name);
    }    
}
