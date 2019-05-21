/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.holding.service;

import co.com.datacredito.services.schema.serviciolocalizacion.v1.ConsultarDatosLocalizacion;
import co.com.datacredito.services.schema.serviciolocalizacion.v1.ConsultarDatosLocalizacionResponse;

/**
 *
 * @author estudapp
 */
public interface ILocationService {
    
    public String getLocation(ConsultarDatosLocalizacion _consultarDatosLocalizacion_parameters);
    
}
