/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.dao.DAOAdherente;
import controlador.dao.DAOFactory;
import controlador.dao.DBConnection;
import java.util.ArrayList;
import model.Adherente;

/**
 *
 * @author Raul
 */
public class ProcesoAdherenteDB {
    private ArrayList<Adherente> adherenteList = new ArrayList<Adherente>();
    DAOFactory daoFactory = DAOFactory.getDAOFactory(DBConnection.dbType);
    DAOAdherente daoAdherente = daoFactory.getDAOAdherente();
    
    public void add(Adherente a) {
    	daoAdherente.add(a);

    }
    public void update(Adherente a) {
    	daoAdherente.update(a);

    }
    public void delete(int idAdherente) {
    	daoAdherente.delete(idAdherente);

    }
    public ArrayList<Adherente> queryAll()
    {
    	adherenteList = daoAdherente.queryAll();
        return adherenteList;
    }
    public Adherente queryById(int idAdherente) {
        return daoAdherente.queryById(idAdherente);
    }   
    
    public void addLista(ArrayList<Adherente> listaAdherente){
        daoAdherente.addLista(listaAdherente);
    }

    public ArrayList<Adherente> queryAllObservado(int idPartido){
        return daoAdherente.queryAllObservado(idPartido);
    }
}
