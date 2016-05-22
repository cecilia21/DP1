/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import java.util.ArrayList;
import model.PartidoPolitico;

/**
 *
 * @author USUARIO
 */
public interface DAOPartidoPolitico {
    void add(PartidoPolitico p);
    void update(PartidoPolitico p);
    void delete (int idPartido);
    ArrayList<PartidoPolitico> queryAll();
    PartidoPolitico queryById(int idProduct);
}
