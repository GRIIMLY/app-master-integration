/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.holding.config.ws;

import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.ws.security.WSConstants;
import org.apache.ws.security.handler.WSHandlerConstants;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.holding.testdatacredito.SignaturePwdClientCallBackHandler;

/**
 *
 * @author Nicolas Sierra
 */
@Configuration
@PropertySources({ @PropertySource("classpath:propiedades_param.properties") })
public class WsConfig {
	@Value("${holding.param.user}")
	String user;
	@Value("${holding.param.sig_prop_file}")
	String sig_prop_file;
	@Value("${holding.param.signature_user}")
	String signature_user;
	@Value("${holding.param.signature_parts}")
	String signature_parts;

    @Bean("generalProps")
    public Map getGeneralProps() {
        Map<String, Object> propsOut = new HashMap<>();
        propsOut.put(WSHandlerConstants.USER, user); //Usuario dado por Experian
        propsOut.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN + " " + WSHandlerConstants.TIMESTAMP + " " + WSHandlerConstants.SIGNATURE);
        propsOut.put(WSHandlerConstants.SIG_PROP_FILE, sig_prop_file );
        propsOut.put(WSHandlerConstants.SIGNATURE_USER, signature_user);
        propsOut.put(WSHandlerConstants.ADD_UT_ELEMENTS, WSConstants.NONCE_LN + " " + WSConstants.CREATED_LN);
        propsOut.put(WSHandlerConstants.MUST_UNDERSTAND, "false");
        propsOut.put(WSHandlerConstants.SIGNATURE_PARTS, signature_parts);

        propsOut.put(WSHandlerConstants.SIG_KEY_ID, "DirectReference");
        propsOut.put(WSHandlerConstants.SIG_ALGO, "http://www.w3.org/2000/09/xmldsig#rsa-sha1");
        propsOut.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
        propsOut.put(WSHandlerConstants.PW_CALLBACK_CLASS, SignaturePwdClientCallBackHandler.class.getName());
        return propsOut;
    }
    
    @Bean("wSS4JOutInterceptor")
    public WSS4JOutInterceptor getWSS4JOutInterceptor(@Qualifier("generalProps")Map propsOut){
        WSS4JOutInterceptor wss4jOut;
        wss4jOut = new WSS4JOutInterceptor(propsOut);
        return wss4jOut;
    }

}
