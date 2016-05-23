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
}
