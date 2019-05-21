/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.holding.service.impl;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dc.id.ws.v1.DatosValidacionRequest;
import com.dc.id.ws.v1.RespuestasRequest;
import com.dc.id.ws.v1.SolicitudCuestionarioRequest;
import com.holding.service.IIdentificacionService;
import com.holding.testdatacredito.SignaturePwdClientCallBackHandler;

import co.com.datacredito.services.servicioidentificacion.v1.ServicioIdentificacion;

/**
 *
 * @author Nicolas Sierra
 */
@Service
public class IdentificacionService implements IIdentificacionService {

    @Autowired
    @Qualifier("portIdentificacion")
    private ServicioIdentificacion port;
    @Value("${validar.paramProducto}")
    private String _validar_paramProducto;
    @Value("${validar.producto}")
    private String _validar_producto;
    @Value("${validar.canal}")
    private String _validar_canal;

    @PostConstruct
    public void init() {
        System.setProperty("javax.net.debug", "ssl,handshake");
        System.setProperty("javax.net.ssl.trustStore", "C:\\certificados\\demo-servicesesb.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "experian");
        System.setProperty("javax.net.ssl.keyStore", "C:\\certificados\\demo-servicesesb.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "experian");

        System.setProperty("org.apache.cxf.stax.allowInsecureParser", "1");

        SignaturePwdClientCallBackHandler.certPassword = "Punt0R3d";
        SignaturePwdClientCallBackHandler.password = "Puntored2019";
    }

    @Override
    public Optional< String > getValidateIdentificacion(DatosValidacionRequest _validar_datosValidacion) {
        try {
            System.out.println("Invoking validar...");
            String _validar__return = port.validar("ODAwODkyMzA=", _validar_paramProducto, _validar_producto, _validar_canal, _validar_datosValidacion);
            return Optional.of(_validar__return) ;
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
    @Override
    public Optional< String > getQuestions(SolicitudCuestionarioRequest solicitudCuestionarioRequest){
        try {
            String _preguntas_return = port.preguntas("ODAwODkyMzA=",_validar_paramProducto, _validar_producto, _validar_canal, solicitudCuestionarioRequest);
            return Optional.of(_preguntas_return);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
    
    @Override
    public Optional< String > getVerify(RespuestasRequest respuestas){
        try {
            String _preguntas_return = port.verificar(_validar_canal, _validar_producto, _validar_producto, respuestas);
            return Optional.of(_preguntas_return);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
    
    
  
}
