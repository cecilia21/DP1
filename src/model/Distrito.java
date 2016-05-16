/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author RAMON
 */
public class Distrito {
    private int id;
    private String nombre;
    private int CantidadVotantesRegistrados;

    public Distrito(int id,String nombre,int cantidad){
        this.id=id;
        this.nombre=nombre;
        this.CantidadVotantesRegistrados=cantidad;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }    

    /**
     * @return the CantidadVotantesRegistrados
     */
    public int getCantidadVotantesRegistrados() {
        return CantidadVotantesRegistrados;
    }

    /**
     * @param CantidadVotantesRegistrados the CantidadVotantesRegistrados to set
     */
    public void setCantidadVotantesRegistrados(int CantidadVotantesRegistrados) {
        this.CantidadVotantesRegistrados = CantidadVotantesRegistrados;
    }
        
}
