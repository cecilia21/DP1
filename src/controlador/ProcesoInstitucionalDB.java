/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.dao.DAOFactory;
import controlador.dao.DAOInstitucion;
import controlador.dao.DBConnection;
import java.util.ArrayList;
import model.Institucion;

/**
 *
 * @author Raul
 */
public class ProcesoInstitucionalDB {
    private ArrayList<Institucion> institucionList = new ArrayList<Institucion>();
    DAOFactory daoFactory = DAOFactory.getDAOFactory(DBConnection.dbType);
    DAOInstitucion daoInstitucion = daoFactory.getDAOInstitucion();
    
    public void add(Institucion i) {
    	daoInstitucion.add(i);

    }
    public void update(Institucion i) {
    	daoInstitucion.update(i);

    }
    public void delete(int idInstitucion) {
    	daoInstitucion.delete(idInstitucion);

    }
    public ArrayList<Institucion> queryAll()
    {
    	institucionList = daoInstitucion.queryAll();
        return institucionList;
    }
    public Institucion queryById(int idInstitucion) {
        return daoInstitucion.queryById(idInstitucion);
    }
    public ArrayList<Institucion> queryByName(String nombre)
    {
    	institucionList = daoInstitucion.queryByName(nombre);
        return institucionList;
    }
    
}
