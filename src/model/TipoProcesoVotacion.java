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
    private Date fechaInicio1;
    private Date fechaFin1;
    private Date fechaInicio2;
    private Date fechaFin2;
    private double porcentajeMinimo;

    public TipoProcesoVotacion(){
        
    }
    
    public TipoProcesoVotacion(int id
            ,String nombre,Date fechaInicio1,Date fechaFin1,Date fechaInicio2,Date fechaFin2,double porcentajeMinimo){
        this.id=id;
        this.nombre=nombre;
        this.fechaInicio1=fechaInicio1;
        this.fechaFin1=fechaFin1;
        this.fechaInicio2=fechaInicio2;
        this.fechaFin2=fechaFin2;
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
    public Date getFechaInicio1() {
        return fechaInicio1;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio1(Date fechaInicio1) {
        this.fechaInicio1 = fechaInicio1;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin1() {
        return fechaFin1;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin1(Date fechaFin1) {
        this.fechaFin1 = fechaFin1;
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
    
    /**
     * @return the fechaInicio2
     */
    public Date getFechaInicio2() {
        return fechaInicio2;
    }

    /**
     * @param fechaInicio2 the fechaInicio2 to set
     */
    public void setFechaInicio2(Date fechaInicio2) {
        this.fechaInicio2 = fechaInicio2;
    }

    /**
     * @return the fechaFin2
     */
    public Date getFechaFin2() {
        return fechaFin2;
    }

    /**
     * @param fechaFin2 the fechaFin2 to set
     */
    public void setFechaFin2(Date fechaFin2) {
        this.fechaFin2 = fechaFin2;
    }

    
    
    
}
