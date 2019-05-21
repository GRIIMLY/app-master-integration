/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.holding.config.ws;

import com.holding.reconocerxsd.SignaturePwdClientCallBackHandler;
import java.util.HashMap;
import java.util.Map;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.ws.security.WSConstants;
import org.apache.ws.security.handler.WSHandlerConstants;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author estudapp
 */
@Configuration
public class ConfigWs {

    @Bean(name = "generalProp")
    public Map generalProp() {
        Map<String, Object> propsOut = new HashMap<>();

        propsOut = new HashMap<>();
        propsOut.put(WSHandlerConstants.USER, "2-830513238"); //Usuario dado por Experian
        propsOut.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN + " " + WSHandlerConstants.TIMESTAMP + " " + WSHandlerConstants.SIGNATURE);
        propsOut.put(WSHandlerConstants.SIG_PROP_FILE, "META-INF/crypto.properties");
        propsOut.put(WSHandlerConstants.SIGNATURE_USER, "datacredito.puntored.co");
        propsOut.put(WSHandlerConstants.ADD_UT_ELEMENTS, WSConstants.NONCE_LN + " " + WSConstants.CREATED_LN);
        propsOut.put(WSHandlerConstants.MUST_UNDERSTAND, "false");
        propsOut.put(WSHandlerConstants.SIGNATURE_PARTS, "{Content}{http://schemas.xmlsoap.org/soap/envelope/}Body;{Element}{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd}UsernameToken;{Element}{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd}Timestamp;");

        propsOut.put(WSHandlerConstants.SIG_KEY_ID, "DirectReference");
        propsOut.put(WSHandlerConstants.SIG_ALGO, "http://www.w3.org/2000/09/xmldsig#rsa-sha1");
        propsOut.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
        propsOut.put(WSHandlerConstants.PW_CALLBACK_CLASS, SignaturePwdClientCallBackHandler.class.getName());

        return propsOut;
    }

    @Bean("WSS4OutInterceptor")
    public WSS4JOutInterceptor getWSS4OutInterceptor(@Qualifier("generalProp") Map propsOut) {
        return new WSS4JOutInterceptor(propsOut);
    }

    @Bean("tLSClientParameters")
    public TLSClientParameters getTLSClientParameters() {
        TLSClientParameters tlsCP = new TLSClientParameters();
        tlsCP.setDisableCNCheck(true);
        return tlsCP;
    }

}
