/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.holding.service;

import java.util.Optional;

import com.dc.id.ws.v1.DatosValidacionRequest;
import com.dc.id.ws.v1.RespuestasRequest;
import com.dc.id.ws.v1.SolicitudCuestionarioRequest;

/**
 *
 * @author Nicolas Sierra
 */
public interface IIdentificacionService {
    /**
     * Metodo con el cual se valida la identidad del usuario por medio de los service del usuario
     * @return 
     */
    Optional<String> getValidateIdentificacion(DatosValidacionRequest _validar_datosValidacion);
    /**
     * Metodo con el cual solicito las preguntas de validacion 
     * @param solicitudCuestionarioRequest
     * @return 
     */
    Optional< String > getQuestions(SolicitudCuestionarioRequest solicitudCuestionarioRequest);
    /**
     * Metodo con el cual se debe verificar la autenticidad de las preguntas respondidas
     * @param respuestas
     * @return 
     */
    Optional< String > getVerify(RespuestasRequest respuestas);
    
}
