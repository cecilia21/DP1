/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import java.util.ArrayList;
import model.Institucion;

/**
 *
 * @author Raul
 */
public interface DAOInstitucion {
    void add(Institucion i);
    void update(Institucion i);
    void delete (int idInstitucion);
    ArrayList<Institucion> queryAll();
    Institucion queryById(int idInstitucion);
    ArrayList<Institucion> queryByName(String nombre);
}
