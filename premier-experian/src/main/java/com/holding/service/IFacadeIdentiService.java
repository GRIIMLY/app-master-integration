/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.holding.service;

import com.holding.dto.DatosValidacionRequestDto;
import com.holding.dto.RespuestasRequestDto;
import com.holding.dto.SolicitudCuestionarioRequestDto;
import java.util.Optional;

/**
 *
 * @author Nicolas Sierra
 */
public interface IFacadeIdentiService {
    /**
     * Metodo con el cual se valida la identidad de un cliente
     * @param datosValidacion
     * @return 
     */
    Optional<String> getValidateIdentity(DatosValidacionRequestDto datosValidacion);
    /**
     * Metodo con el cual solicito un custionario
     * @param solicitudCuestionarioRequest
     * @return 
     */
    Optional< String > getQuestions(SolicitudCuestionarioRequestDto solicitudCuestionarioRequest);
    
    /**
     * Metodo con el cual se debe verificar la autenticidad de las preguntas respondidas
     * @param respuestas
     * @return 
     */
    Optional< String > getVerify(RespuestasRequestDto respuestas);
    
}
