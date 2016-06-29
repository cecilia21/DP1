/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author franz
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Configuration {
    @XmlElement
    private String rutaGeneral;
    @XmlElement
    private String rutaHuellas;
    @XmlElement
    private String rutaFirmas;

    /**
     * @return the rutaGeneral
     */
    
    
    public String getRutaGeneral() {
        return rutaGeneral;
    }

    /**
     * @param rutaGeneral the rutaGeneral to set
     */
    
    
    public void setRutaGeneral(String rutaGeneral) {
        this.rutaGeneral = rutaGeneral;
    }

    /**
     * @return the rutaHuellas
     */
    public String getRutaHuellas() {
        return rutaHuellas;
    }

    /**
     * @param rutaHuellas the rutaHuellas to set
     */
    public void setRutaHuellas(String rutaHuellas) {
        this.rutaHuellas = rutaHuellas;
    }

    /**
     * @return the rutaFirmas
     */
    public String getRutaFirmas() {
        return rutaFirmas;
    }

    /**
     * @param rutaFirmas the rutaFirmas to set
     */
    public void setRutaFirmas(String rutaFirmas) {
        this.rutaFirmas = rutaFirmas;
    }
    
    
    
    
    
}
