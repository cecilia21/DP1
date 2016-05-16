/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author RAMON
 */
public class TipoProcesoVotacion {
    
    private int id;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private double porcentajeMinimo;

    public TipoProcesoVotacion(int id,String nombre,Date fechaInicio,Date fechaFin,double porcentajeMinimo){
        this.id=id;
        this.nombre=nombre;
        this.fechaInicio=fechaInicio;
        this.fechaFin=fechaFin;
        this.porcentajeMinimo=porcentajeMinimo;
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
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the porcentajeMinimo
     */
    public double getPorcentajeMinimo() {
        return porcentajeMinimo;
    }

    /**
     * @param porcentajeMinimo the porcentajeMinimo to set
     */
    public void setPorcentajeMinimo(double porcentajeMinimo) {
        this.porcentajeMinimo = porcentajeMinimo;
    }
    
    
    
}
