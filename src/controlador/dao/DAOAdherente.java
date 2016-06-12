/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import java.util.ArrayList;
import model.Adherente;
import model.Distrito;

/**
 *
 * @author Raul
 */
public interface DAOAdherente {
    void add(Adherente a);
    void update(Adherente a);
    void delete (int idAdherente);
    ArrayList<Adherente> queryAll();   
    Adherente queryById(int idRegion);
    void addLista(ArrayList<Adherente> listaAdherente);
    ArrayList<Adherente> queryAllObservado(int idPartido);
}
