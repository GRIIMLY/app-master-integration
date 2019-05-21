/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.holding.reconocerxsd;

import co.com.datacredito.services.schema.serviciolocalizacion.v1.ConsultarDatosLocalizacion;
import co.com.datacredito.services.v1.serviciolocalizacion.ServicioLocalizacion;
import com.holding.util.GetOutputTagXML;
import java.util.HashMap;
import java.util.Map;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.ws.security.WSConstants;
import org.apache.ws.security.handler.WSHandlerConstants;
import org.json.JSONObject;
import org.json.XML;

/**
 *
 * @author john
 */
public class TestReconocer {

    private JaxWsProxyFactoryBean factory;

    public static void main(String args[]) {
        System.out.println(new TestReconocer().getLocalizacion());
    }

    public String getLocalizacion() {
        Map<String, Object> propsOut;
        Object client;
        LoggingOutInterceptor loggingOutInterceptor;
        LoggingInInterceptor loggingInInterceptor;
        WSS4JOutInterceptor wss4jOut;
        HTTPConduit httpConduit;
        ServicioLocalizacion port = null;
        TLSClientParameters tlsCP;
        try {
            System.setProperty("javax.net.debug", "ssl,handshake");
            System.setProperty("javax.net.ssl.trustStore", "C:\\certificados\\demo-servicesesb.jks");
            System.setProperty("javax.net.ssl.trustStorePassword", "experian");
            System.setProperty("javax.net.ssl.keyStore", "C:\\certificados\\demo-servicesesb.jks");
            System.setProperty("javax.net.ssl.keyStorePassword", "experian");

            System.setProperty("org.apache.cxf.stax.allowInsecureParser", "1");
            SignaturePwdClientCallBackHandler.certPassword = "Punt0R3d";
            SignaturePwdClientCallBackHandler.password = "Puntored2019";
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

            factory = new JaxWsProxyFactoryBean();
            factory.setAddress("https://demo-servicesesb.datacredito.com.co/wss/localizacion/services/ServicioLocalizacion"); //Endpoint del servicio
            factory.setServiceClass(ServicioLocalizacion.class);
            client = factory.create();
            CustomLoggingInterceptor customLoggingInterceptor = new CustomLoggingInterceptor();
            loggingOutInterceptor = new LoggingOutInterceptor();
            loggingOutInterceptor.setPrettyLogging(true);
            ClientProxy.getClient(client).getOutInterceptors().add(loggingOutInterceptor);
            loggingInInterceptor = new LoggingInInterceptor();
            loggingInInterceptor.setPrettyLogging(true);
            ClientProxy.getClient(client).getInInterceptors().add(loggingInInterceptor);
            ClientProxy.getClient(client).getInInterceptors().add(customLoggingInterceptor);
            wss4jOut = new WSS4JOutInterceptor(propsOut);
            ClientProxy.getClient(client).getOutInterceptors().add(wss4jOut);
            httpConduit = (HTTPConduit) ClientProxy.getClient(client).getConduit();
            tlsCP = new TLSClientParameters();
            tlsCP.setDisableCNCheck(true);
            httpConduit.setTlsClientParameters(tlsCP);
            port = ((ServicioLocalizacion) client);
            System.out.println("Invoking consultarDatosLocalizacion...");
            ConsultarDatosLocalizacion _consultarDatosLocalizacion_parameters = null;
            _consultarDatosLocalizacion_parameters = new ConsultarDatosLocalizacion();
            ConsultarDatosLocalizacion.Solicitud solicitud = new ConsultarDatosLocalizacion.Solicitud();
            ConsultarDatosLocalizacion.Solicitud.SolicitudDatosLocalizacion solicitudLoca = new ConsultarDatosLocalizacion.Solicitud.SolicitudDatosLocalizacion();
            solicitudLoca.setClave("45NOV");
            solicitudLoca.setFullName("?");
            solicitudLoca.setIdentificacion("2555");
            solicitudLoca.setIssuedate("?");
            solicitudLoca.setName("?");
            solicitudLoca.setPrimerApellido("Gaitan");
            solicitudLoca.setTipoIdentificacion("1");
            solicitudLoca.setUsuario("80089230");
            solicitud.setSolicitudDatosLocalizacion(solicitudLoca);
            _consultarDatosLocalizacion_parameters.setSolicitud(solicitud);
            co.com.datacredito.services.schema.serviciolocalizacion.v1.ConsultarDatosLocalizacionResponse _consultarDatosLocalizacion__return = port.consultarDatosLocalizacion(_consultarDatosLocalizacion_parameters);
            JSONObject xmlJSONObj = XML.toJSONObject(GetOutputTagXML.extractText(customLoggingInterceptor.responseXml, "v1:ConsultarDatosLocalizacionReturn"));
            String jsonPrettyPrintString = xmlJSONObj.toString(4);
            System.out.println("consultarDatosLocalizacion.result=" +jsonPrettyPrintString );

            return _consultarDatosLocalizacion__return.getConsultarDatosLocalizacionReturn().toString();
        } catch (Exception e) {
            System.out.println("Expected exception: ServicioLocalizacionException has occurred.");
            System.out.println(e.toString());
            return "error";
        }
    }
}
