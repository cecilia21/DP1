/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.Instant;
import java.util.Date;

/**
 *
 * @author RAMON
 */
public class Usuario {
        private String id;
        private String nombre;
        private String apellido;
        private String telefono;
        private String dni;
        private String correo;
        private String contraseña;
        private int numeroIntentosAcceso;
        private Date fechaRegistro;
        private String estado;

    public Usuario(String id,String nombre,String apellido,String telefono,String dni,String correo,String contraseña){
        this.id=id;
        this.nombre=nombre;
        this.apellido=apellido;
        this.telefono=telefono;
        this.dni=dni;
        this.correo=correo;
        this.contraseña=contraseña;
        this.numeroIntentosAcceso=0;
        this.fechaRegistro=Date.from(Instant.MIN);
        this.estado="Activo";
    }    
        
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
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
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the numeroIntentosAcceso
     */
    public int getNumeroIntentosAcceso() {
        return numeroIntentosAcceso;
    }

    /**
     * @param numeroIntentosAcceso the numeroIntentosAcceso to set
     */
    public void setNumeroIntentosAcceso(int numeroIntentosAcceso) {
        this.numeroIntentosAcceso = numeroIntentosAcceso;
    }

    /**
     * @return the fechaRegistro
     */
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * @param fechaRegistro the fechaRegistro to set
     */
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
