/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Calendar;

/**
 *
 * @author RAMON
 */
public class TipoProcesoVotacion {
    
    private int id;
    private String nombre;
    private Calendar fechaInicio1;
    private Calendar fechaFin1;
    private Calendar fechaInicio2;
    private Calendar fechaFin2;
    private float porcentaje;

    public TipoProcesoVotacion(){
        
    }
    
    public TipoProcesoVotacion(int id, String nombre,Calendar fechaInicio1,
            Calendar fechaFin1,Calendar fechaInicio2,Calendar fechaFin2,
            float porcentajeMinimo){
        this.id=id;
        this.nombre=nombre;
        this.fechaInicio1=fechaInicio1;
        this.fechaFin1=fechaFin1;
        this.fechaInicio2=fechaInicio2;
        this.fechaFin2=fechaFin2;
        this.porcentaje=porcentajeMinimo;
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
    public Calendar getFechaInicio1() {
        return fechaInicio1;
    }

    /**
     * @param fechaIni1 the fechaInicio1 to set
     */
    public void setFechaInicio1(Calendar fechaIni1) {
        this.fechaInicio1 = fechaIni1;
    }

    /**
     * @return the fechaFin
     */
    public Calendar getFechaFin1() {
        return fechaFin1;
    }

    /**
     * @param fechaFin1 the fechaFin to set
     */
    public void setFechaFin1(Calendar fechaFin1) {
        this.fechaFin1 = fechaFin1;
    }

    /**
     * @return the porcentajeMinimo
     */
    public float getPorcentajeMinimo() {
        return porcentaje;
    }

    /**
     * @param porcentajeMinimo the porcentajeMinimo to set
     */
    public void setPorcentajeMinimo(float porcentajeMinimo) {
        this.porcentaje = porcentajeMinimo;
    }

    /**
     * @return the idPartido
     */
    
    /**
     * @return the fechaInicio2
     */
    public Calendar getFechaInicio2() {
        return fechaInicio2;
    }

    /**
     * @param fechaInicio2 the fechaInicio2 to set
     */
    public void setFechaInicio2(Calendar fechaInicio2) {
        this.fechaInicio2 = fechaInicio2;
    }

    /**
     * @return the fechaFin2
     */
    public Calendar getFechaFin2() {
        return fechaFin2;
    }

    /**
     * @param fechaFin2 the fechaFin2 to set
     */
    public void setFechaFin2(Calendar fechaFin2) {
        this.fechaFin2 = fechaFin2;
    }

    
    
    
}
