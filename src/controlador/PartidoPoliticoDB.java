/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author USUARIO
 */
import controlador.dao.DAOFactory;
import controlador.dao.DAOPartidoPolitico;
import controlador.dao.DBConnection;
import java.util.ArrayList;
import model.PartidoPolitico;
public class PartidoPoliticoDB {
    DAOFactory daoFactory = DAOFactory.getDAOFactory(DBConnection.dbType);
    DAOPartidoPolitico daoPartidos = daoFactory.getDAOPartidoPolitico(); // POLIMORFISMO
    public void add(PartidoPolitico p) {
    	daoPartidos.add(p);
    }
    public void update(PartidoPolitico p) {
    	daoPartidos.update(p);
    }
    public void delete(int p) {
    	daoPartidos.delete(p);
    }
    
    public void queryAll(){
        daoPartidos.queryAll();
    }
    
    public ArrayList<PartidoPolitico> queryByNombTipoLug(String nombre, int ind1, int ind2){
        return daoPartidos.queryByNombTipoLug(nombre, ind1, ind2);
    }
}
