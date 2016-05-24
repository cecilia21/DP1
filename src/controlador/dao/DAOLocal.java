/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import java.util.ArrayList;
import model.Local;


/**
 *
 * @author Franz
 */
public interface DAOLocal {
    
    void add(Local i);
    void update(Local i);
    void delete (int idLocal);
    ArrayList<Local> queryAll();
    Local queryById(int idLocal);
    
    
    
}
