/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.holding.dto;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Nicolas Sierra
 */
public class SolicitudCuestionarioRequestDto {
    
    private String tipoId;
    private String identificacion;
    private BigInteger regValidacion;

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public BigInteger getRegValidacion() {
        return regValidacion;
    }

    public void setRegValidacion(BigInteger regValidacion) {
        this.regValidacion = regValidacion;
    }
}
