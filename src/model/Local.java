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
public class Local {
    private int idLocal;
    private int idDistrito;
    private String nombre;
    private int tipoProceso;
    private int CantidadVotantesRegistrados;

    public Local(int id,int idD,int idTipo,String nombre,int cantidad){
        this.idLocal=id;
        this.idDistrito=idD;
        this.tipoProceso=idTipo;
        this.nombre=nombre;
        this.CantidadVotantesRegistrados=cantidad;
    }
    
    /**
     * @return the id
     */
    public Local(){
    
    }
    
    public int getId() {
        return idLocal;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.idLocal = id;
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

    /**
     * @return the idDistrito
     */
    public int getIdDistrito() {
        return idDistrito;
    }

    /**
     * @param idDistrito the idDistrito to set
     */
    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    /**
     * @return the idRegion
     */
    public int getIdProceso() {
        return tipoProceso;
    }

    /**
     * @param idRegion the idRegion to set
     */
    public void setIdProceso(int idTipo) {
        this.tipoProceso = idTipo;
    }
        
}
