/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.holding.service.impl;

import java.util.Optional;

import org.json.JSONObject;
import org.json.XML;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dc.id.ws.v1.DatosValidacionRequest;
import com.dc.id.ws.v1.RespuestasRequest;
import com.dc.id.ws.v1.SolicitudCuestionarioRequest;
import com.holding.dto.DatosValidacionRequestDto;
import com.holding.dto.RespuestasRequestDto;
import com.holding.dto.SolicitudCuestionarioRequestDto;
import com.holding.service.IFacadeIdentiService;
import com.holding.service.IIdentificacionService;

/**
 *
 * @author Nicolas Sierra
 */
@Service
public class FacadeIdentiService implements IFacadeIdentiService {

    @Autowired
    IIdentificacionService identificacionService;
    @Autowired
    ModelMapper mapper;

    @Override
    public Optional<String> getValidateIdentity(DatosValidacionRequestDto datosValidacion) {
        String json = null;
        //Mapeamos el objeto necesario para llamar el web service y llamamos el mismo
        Optional<String> xmlResponse = identificacionService.getValidateIdentificacion(mapper.map(datosValidacion, DatosValidacionRequest.class));
        if (!xmlResponse.isPresent()) {
            return Optional.empty();
        }
        //Remplazamos los caracteres invalidos
        String xmlAux = replaceXml(xmlResponse.get());
        return Optional.of(xmlToJson(xmlAux));
    }

    /**
     * Metodo con el cual elimino caracteres incorrectos del xml
     *
     * @param xml
     * @return
     */
    public String replaceXml(String xml) {
        return xml.replaceAll("&lt;", "<");
    }

    /**
     * Metodo con el cual convierto un xml a un objeto Json
     *
     * @param xml
     * @return
     */
    public String xmlToJson(String xml) {
        String json = null;
        try {
            JSONObject xmlJSONObj = XML.toJSONObject(xml);
            json = xmlJSONObj.toString(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    @Override
    public Optional<String> getQuestions(SolicitudCuestionarioRequestDto solicitudCuestionarioRequestDto) {
        String json = null;
        //Mapeamos el objeto necesario para llamar el web service y llamamos el mismo
        Optional<String> xmlResponse = identificacionService.getQuestions(mapper.map(solicitudCuestionarioRequestDto, SolicitudCuestionarioRequest.class));
        if (!xmlResponse.isPresent()) {
            return Optional.empty();
        }
        //Remplazamos los caracteres invalidos
        String xmlAux = replaceXml(xmlResponse.get());
        return Optional.of(xmlToJson(xmlAux));
    }

    @Override
    public Optional<String> getVerify(RespuestasRequestDto respuestas) {
        String json = null;
        //Mapeamos el objeto necesario para llamar el web service y llamamos el mismo
        Optional<String> xmlResponse = identificacionService.getVerify(mapper.map(respuestas, RespuestasRequest.class));
        if (!xmlResponse.isPresent()) {
            return Optional.empty();
        }
        //Remplazamos los caracteres invalidos
        String xmlAux = replaceXml(xmlResponse.get());
        return Optional.of(xmlToJson(xmlAux));
    }
}
