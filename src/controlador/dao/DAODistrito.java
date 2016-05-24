/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import java.util.ArrayList;
import model.Distrito;

/**
 *
 * @author RAMON
 */
public interface DAODistrito {
    void add(Distrito p);
    void update(Distrito p);
    void delete (int idDistrito);
    ArrayList<Distrito> queryAll();   
    Distrito queryById(int idRegion);
    Distrito queryByName(String name);
}
