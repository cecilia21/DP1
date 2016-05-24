/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import java.util.ArrayList;
import model.TipoProcesoVotacion;

/**
 *
 * @author RAMON
 */
public interface DAOTipoProcesoVotacion {
    void update(TipoProcesoVotacion p);
    TipoProcesoVotacion queryById(int idTipoProcesoVotacion);
    ArrayList<TipoProcesoVotacion> queryAll();
}
