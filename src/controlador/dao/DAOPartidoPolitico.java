/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import java.util.ArrayList;
import model.Adherente;
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
    ArrayList<PartidoPolitico> queryByNombTipoLug(String nombre, int tipo, int lugar);
    ArrayList<PartidoPolitico> queryByNombTipoLugFull(String nombre, int tipo, int lugar);
    ArrayList<PartidoPolitico> queryByNombTipo(String nombre, int tipo);
    PartidoPolitico queryById(int idProduct);
    ArrayList<PartidoPolitico> queryByName(String nombre);
    int[] queryTipoProcesoNombrePartido(String nombre);
    ArrayList<Adherente> queryAdherentesById(int id);
    void deleteAdherenteById(int id);
}
