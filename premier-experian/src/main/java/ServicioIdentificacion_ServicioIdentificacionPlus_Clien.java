
import co.com.prueba.DatosValidacionRequest;
import co.com.prueba.FechaExpedicionRequest;
import co.com.prueba.IdentificacionRequest;
import co.com.prueba.Idws2Exception_Exception;
import co.com.prueba.ServicioIdentificacion;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author john
 */
public class ServicioIdentificacion_ServicioIdentificacionPlus_Clien {

    public static void main(String arg[]) throws Idws2Exception_Exception {
        System.setProperty("javax.net.ssl.trustStore", "C:\\certificados\\demo-servicesesb.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "experian");
        System.setProperty("javax.net.ssl.keyStore", "C:\\certificados\\demo-servicesesb.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "experian");
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setAddress("https://demo-servicesesb.datacredito.com.co/wss/idws2/services/ServicioIdentificacionPlus");
        factory.setServiceClass(ServicioIdentificacion.class);
        Object client = factory.create();
        LoggingOutInterceptor loggingOutInterceptor = new LoggingOutInterceptor();
        loggingOutInterceptor.setPrettyLogging(true);
        ClientProxy.getClient(client).getOutInterceptors().add(loggingOutInterceptor);
        LoggingInInterceptor loggingInInterceptor = new LoggingInInterceptor();
        loggingInInterceptor.setPrettyLogging(true);
        ClientProxy.getClient(client).getInInterceptors().add(loggingInInterceptor);
        //Propiedades de seguridad: UsernameToken +  Timestamp + Signature
        Map<String, Object> propsOut = new HashMap<String, Object>();
        propsOut.put(WSHandlerConstants.USER, "1-86074566");
        propsOut.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN + " " + WSHandlerConstants.TIMESTAMP + " " + WSHandlerConstants.SIGNATURE);
        propsOut.put(WSHandlerConstants.SIG_PROP_FILE, "crypto.properties");
        propsOut.put(WSHandlerConstants.SIGNATURE_USER, "experian.sign");
        propsOut.put(WSHandlerConstants.ADD_UT_ELEMENTS, WSConstants.NONCE_LN + " " + WSConstants.CREATED_LN);
        propsOut.put(WSHandlerConstants.MUST_UNDERSTAND, "false");
        propsOut.put(WSHandlerConstants.SIGNATURE_PARTS, "{Content}{http://schemas.xmlsoap.org/soap/envelope/}Body;{Element}{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecuritysecext-1.0.xsd}UsernameToken;{Element}{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd}Timestamp;");
        propsOut.put(WSHandlerConstants.SIG_KEY_ID, "DirectReference");
        propsOut.put(WSHandlerConstants.SIG_ALGO, "http://www.w3.org/2000/09/xmldsig#rsa-sha1");
        propsOut.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
        propsOut.put(WSHandlerConstants.PW_CALLBACK_CLASS, "SignaturePwdClientCallBackHandler");
        WSS4JOutInterceptor wss4jOut = new WSS4JOutInterceptor(propsOut);
        ClientProxy.getClient(client).getOutInterceptors().add(wss4jOut);
        ServicioIdentificacion port = ((ServicioIdentificacion) client);
        System.out.println("Invoking validar...");
        java.lang.String _validar_paramProducto = "2545";
        java.lang.String _validar_producto = "007";
        java.lang.String _validar_canal = "001";
        DatosValidacionRequest _validar_datosValidacion = new DatosValidacionRequest();
        IdentificacionRequest _validar_datosValidacionIdentificacion = new IdentificacionRequest();
        _validar_datosValidacionIdentificacion.setNumero("87215803");
        _validar_datosValidacionIdentificacion.setTipo("1");
        _validar_datosValidacion.setIdentificacion(_validar_datosValidacionIdentificacion);
        _validar_datosValidacion.setPrimerApellido("CORAL");
        _validar_datosValidacion.setNombres("GERMAN");
        FechaExpedicionRequest _validar_datosValidacionFechaExpedicion = new FechaExpedicionRequest();
        _validar_datosValidacionFechaExpedicion.setTimestamp("1103846400000");
        _validar_datosValidacion.setFechaExpedicion(_validar_datosValidacionFechaExpedicion);
        try {
            java.lang.String _validar__return = port.validar(null, _validar_paramProducto, _validar_producto, _validar_canal, _validar_datosValidacion);
            System.out.println("validar.result=" + _validar__return);

        } catch (Idws2Exception_Exception e) {
            System.out.println("Expected exception: Idws2Exception has occurred.");
            System.out.println(e.toString());
        }
    }
}
