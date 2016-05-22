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
public class InstitucionDB {
    private ArrayList<Institucion> customerList = new ArrayList<Institucion>();
    DAOFactory daoFactory = DAOFactory.getDAOFactory(DBConnection.dbType);
    DAOInstitucion daoInstitucion = daoFactory.getDAOInstitucion();
    
    
    
}
