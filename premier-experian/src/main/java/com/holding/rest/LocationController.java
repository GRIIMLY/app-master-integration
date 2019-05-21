/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.holding.rest;

import co.com.datacredito.services.schema.serviciolocalizacion.v1.ConsultarDatosLocalizacion;
import com.holding.dto.ConsultarDatosLocalizacionDto;
import com.holding.service.ILocationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author estudapp
 */
@RestController
@RequestMapping("/v.1/location")
public class LocationController {
    @Autowired
    ILocationService locationService;
    @Autowired
    ModelMapper mapper;
    
    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> getLocation(@RequestBody(required = true)ConsultarDatosLocalizacionDto consultarDatosLocalizacionDto ){
        return new ResponseEntity<>(locationService.getLocation(mapper.map(consultarDatosLocalizacionDto, ConsultarDatosLocalizacion.class)) , HttpStatus.OK);
    }
}
