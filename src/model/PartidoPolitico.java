/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.Instant;
import java.util.Calendar;

/**
 *
 * @author RAMON
 */
public class PartidoPolitico {
    private int id;
    private String idUsuario;
    private String nombre;
    private int cantidadRegistrosValidos;
    private String nombreRepresentante;
    private String apellidoRepresentante;
    private String dniRepresentante;
    private String correoRepresentante;
    private String correoPartido;
    private Calendar fechaRegistro;
    private String estado;    
    private int idTipoProceso;
    private int idRegion;
    private int idLocal;
    private int idInstitucion;
    private int idDistrito;

    public PartidoPolitico(){};
    
    public PartidoPolitico(int id,String idU,String nombre,int cantidadR,String nombreR,String apellidoR,
            String dniR,String correoR,String correo){
        this.id=id;
        this.idUsuario=idU;
        this.nombre=nombre;
        this.nombreRepresentante=nombreR;
        this.apellidoRepresentante=apellidoR;
        this.cantidadRegistrosValidos=cantidadR;
        this.dniRepresentante=dniR;
        this.correoPartido=correoR;
        this.correoPartido=correo;
        this.estado="Activo";
        this.fechaRegistro= Calendar.getInstance();
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
     * @return the cantidadRegistrosValidos
     */
    public int getCantidadRegistrosValidos() {
        return cantidadRegistrosValidos;
    }

    /**
     * @param cantidadRegistrosValidos the cantidadRegistrosValidos to set
     */
    public void setCantidadRegistrosValidos(int cantidadRegistrosValidos) {
        this.cantidadRegistrosValidos = cantidadRegistrosValidos;
    }

    /**
     * @return the nombreRepresentante
     */
    public String getNombreRepresentante() {
        return nombreRepresentante;
    }

    /**
     * @param nombreRepresentante the nombreRepresentante to set
     */
    public void setNombreRepresentante(String nombreRepresentante) {
        this.nombreRepresentante = nombreRepresentante;
    }

    /**
     * @return the apellidoRepresentante
     */
    public String getApellidoRepresentante() {
        return apellidoRepresentante;
    }

    /**
     * @param apellidoRepresentante the apellidoRepresentante to set
     */
    public void setApellidoRepresentante(String apellidoRepresentante) {
        this.apellidoRepresentante = apellidoRepresentante;
    }

    /**
     * @return the dniRepresentante
     */
    public String getDniRepresentante() {
        return dniRepresentante;
    }

    /**
     * @param dniRepresentante the dniRepresentante to set
     */
    public void setDniRepresentante(String dniRepresentante) {
        this.dniRepresentante = dniRepresentante;
    }

    /**
     * @return the correoRepresentante
     */
    public String getCorreoRepresentante() {
        return correoRepresentante;
    }

    /**
     * @param correoRepresentante the correoRepresentante to set
     */
    public void setCorreoRepresentante(String correoRepresentante) {
        this.correoRepresentante = correoRepresentante;
    }

    /**
     * @return the correoPartido
     */
    public String getCorreoPartido() {
        return correoPartido;
    }

    /**
     * @param correoPartido the correoPartido to set
     */
    public void setCorreoPartido(String correoPartido) {
        this.correoPartido = correoPartido;
    }

    /**
     * @return the fechaRegistro
     */
    public Calendar getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * @param fechaRegistro the fechaRegistro to set
     */
    public void setFechaRegistro(Calendar fechaRegistro) {
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

    /**
     * @return the idUsuario
     */
    public String getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the idTipoProceso
     */
    public int getIdTipoProceso() {
        return idTipoProceso;
    }

    /**
     * @param idTipoProceso the idTipoProceso to set
     */
    public void setIdTipoProceso(int idTipoProceso) {
        this.idTipoProceso = idTipoProceso;
    }

    /**
     * @return the idLugar
     */
    public int getIdRegion() {
        return idRegion;
    }

    /**
     * @param idLugar the idLugar to set
     */
    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    /**
     * @return the idLocal
     */
    public int getIdLocal() {
        return idLocal;
    }

    /**
     * @param idLocal the idLocal to set
     */
    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    /**
     * @return the idInstitucion
     */
    public int getIdInstitucion() {
        return idInstitucion;
    }

    /**
     * @param idInstitucion the idInstitucion to set
     */
    public void setIdInstitucion(int idInstitucion) {
        this.idInstitucion = idInstitucion;
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
    
    
}
