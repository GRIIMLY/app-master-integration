/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.holding.dto;

/**
 *
 * @author Nicolas Sierra
 */
public class DatosValidacionRequestDto {
    
    private IdentificacionRequestDto identificacion;
    private String primerApellido;
    private String nombres;
    private FechaExpedicionRequestDto fechaExpedicion;

    public IdentificacionRequestDto getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(IdentificacionRequestDto identificacion) {
        this.identificacion = identificacion;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public FechaExpedicionRequestDto getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(FechaExpedicionRequestDto fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }
    
    
    
}
