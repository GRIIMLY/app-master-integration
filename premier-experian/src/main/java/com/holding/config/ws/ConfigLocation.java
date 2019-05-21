/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.holding.config.ws;

import co.com.datacredito.services.v1.serviciolocalizacion.ServicioLocalizacion;
import com.holding.reconocerxsd.CustomLoggingInterceptor;
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

/**
 *
 * @author estudapp
 */
@Configuration
public class ConfigLocation {

    @Bean("factoryProxyLocation")
    public JaxWsProxyFactoryBean getFactoryProxy() {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setAddress("https://demo-servicesesb.datacredito.com.co/wss/localizacion/services/ServicioLocalizacion"); //Endpoint del servicio
        factory.setServiceClass(ServicioLocalizacion.class);
        return factory;
    }

    @Bean("clientLocation")
    public Object getClient(@Qualifier("factoryProxyLocation") JaxWsProxyFactoryBean jaxWsProxyfactory) {
        return jaxWsProxyfactory.create();
    }

    @Bean("servicioLocalizacionPort")
    public ServicioLocalizacion getHttpConduit(@Qualifier("tLSClientParameters") TLSClientParameters tlsCP, @Qualifier(value = "clientLocation") Object client, @Qualifier(value = "WSS4OutInterceptor") WSS4JOutInterceptor wss4jOut) {
        LoggingOutInterceptor loggingOutInterceptor;
        LoggingInInterceptor loggingInInterceptor;
        //interceptor para capturar el response del servicio 
        CustomLoggingInterceptor customLoggingInterceptor = new CustomLoggingInterceptor();
        loggingOutInterceptor = new LoggingOutInterceptor();
        loggingOutInterceptor.setPrettyLogging(true);
        ClientProxy.getClient(client).getOutInterceptors().add(loggingOutInterceptor);
        loggingInInterceptor = new LoggingInInterceptor();
        loggingInInterceptor.setPrettyLogging(true);
        ClientProxy.getClient(client).getInInterceptors().add(loggingInInterceptor);
        //se añade el interceptor creado
        ClientProxy.getClient(client).getInInterceptors().add(customLoggingInterceptor);
        ClientProxy.getClient(client).getOutInterceptors().add(wss4jOut);

        HTTPConduit httpConduit = (HTTPConduit) ClientProxy.getClient(client).getConduit();
        httpConduit.setTlsClientParameters(tlsCP);

        return ((ServicioLocalizacion) client);
    }

}
