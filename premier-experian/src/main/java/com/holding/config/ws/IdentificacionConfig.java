/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.holding.config.ws;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.datacredito.services.servicioidentificacion.v1.ServicioIdentificacion;

/**
 *
 * @author Nicolas Sierra
 */
@Configuration
public class IdentificacionConfig {

    @Bean("factoryProxyIdentification")
    public JaxWsProxyFactoryBean getFactory() {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setAddress("https://demo-servicesesb.datacredito.com.co/wss/idws2/services/ServicioIdentificacionPlus"); //Endpoint del servicio
        factory.setServiceClass(ServicioIdentificacion.class);
        return factory;
    }

    @Bean("clientIdentificacion")
    public Object getClient(@Qualifier("factoryProxyIdentification") JaxWsProxyFactoryBean factory) {
        Object client = factory.create();
        return client;
    }

    @Bean("portIdentificacion")
    public ServicioIdentificacion getPort(@Qualifier("clientIdentificacion") Object client, @Qualifier("wSS4JOutInterceptor") WSS4JOutInterceptor wss4jOut  ) {
        LoggingOutInterceptor loggingOutInterceptor;
        LoggingInInterceptor loggingInInterceptor;
        HTTPConduit httpConduit;
        TLSClientParameters tlsCP;
        ServicioIdentificacion port = null;
        loggingOutInterceptor = new LoggingOutInterceptor();
        loggingOutInterceptor.setPrettyLogging(true);
        ClientProxy.getClient(client).getOutInterceptors().add(loggingOutInterceptor);
        loggingInInterceptor = new LoggingInInterceptor();
        loggingInInterceptor.setPrettyLogging(true);
        ClientProxy.getClient(client).getInInterceptors().add(loggingInInterceptor);
        ClientProxy.getClient(client).getOutInterceptors().add(wss4jOut);
        httpConduit = (HTTPConduit) ClientProxy.getClient(client).getConduit();
        tlsCP = new TLSClientParameters();
        tlsCP.setDisableCNCheck(true);
        httpConduit.setTlsClientParameters(tlsCP);
        port = ((ServicioIdentificacion) client);
        return port;
    }
}
