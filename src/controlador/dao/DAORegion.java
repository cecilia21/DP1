/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import java.util.ArrayList;
import model.Region;

/**
 *
 * @author RAMON
 */
public interface DAORegion {
    void add(Region p);
    void update(Region p);
    void delete (int idRegion);
    ArrayList<Region> queryAll();   
    Region queryById(int idRegion);
    ArrayList<Region> queryByName(String name);
}
