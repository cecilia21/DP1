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
public class Adherente {
    private String dni;
    private String estado;
    private String jpg;
    private int idPartido;

    public Adherente(String dni){
        this.dni=dni;
        this.estado="NoInscrito";
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
     * @return the jpg
     */
    public String getJpg() {
        return jpg;
    }

    /**
     * @param jpg the jpg to set
     */
    public void setJpg(String jpg) {
        this.jpg = jpg;
    }

    /**
     * @return the idPartido
     */
    public int getIdPartido() {
        return idPartido;
    }

    /**
     * @param idPartido the idPartido to set
     */
    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }
    
}
