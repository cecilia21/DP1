/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.dao.DAOFactory;
import controlador.dao.DAOLocal;
import controlador.dao.DBConnection;
import java.util.ArrayList;

import model.Local;

/**
 *
 * @author Franz
 */
public class ProcesosLocalDB {
    
    
     private ArrayList<Local> localList = new ArrayList<Local>();
    DAOFactory daoFactory = DAOFactory.getDAOFactory(DBConnection.dbType);
    DAOLocal daoLocal = daoFactory.getDAOLocal();
    
    public void add(Local i) {
        daoLocal.add(i);

//.add(i);

    }
    public void update(Local i) {
        daoLocal.update(i);
    	

    }
    public void delete(int idLocal) {
    	daoLocal.delete(idLocal);

    }
    public ArrayList<Local> queryAll()
    {
    	localList = daoLocal.queryAll();
        return localList;
    }
    public Local queryById(int idLocal) {
        return daoLocal.queryById(idLocal);
    }
    
    
}
