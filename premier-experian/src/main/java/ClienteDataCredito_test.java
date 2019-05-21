
import co.com.prueba.DatosValidacionRequest;
import co.com.prueba.FechaExpedicionRequest;
import co.com.prueba.IdentificacionRequest;
import co.com.prueba.Idws2Exception_Exception;
import co.com.prueba.RespuestasRequest;
import co.com.prueba.ServicioIdentificacion;
import co.com.prueba.SolicitudCuestionarioRequest;
import com.holding.testdatacredito.SignaturePwdClientCallBackHandler;
import java.math.BigInteger;
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
public class ClienteDataCredito_test {

    private JaxWsProxyFactoryBean factory;

    public static void main(String args[]) {
        System.out.println(new ClienteDataCredito_test().getServiceIdentification());
    }

    public String getServiceIdentification() {
        Map<String, Object> propsOut;
        Object client;
        LoggingOutInterceptor loggingOutInterceptor;
        LoggingInInterceptor loggingInInterceptor;
        WSS4JOutInterceptor wss4jOut;
        HTTPConduit httpConduit;
        ServicioIdentificacion port = null;
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
            factory.setAddress("https://demo-servicesesb.datacredito.com.co/wss/idws2/services/ServicioIdentificacionPlus"); //Endpoint del servicio
            factory.setServiceClass(ServicioIdentificacion.class);
            client = factory.create();

            loggingOutInterceptor = new LoggingOutInterceptor();
            loggingOutInterceptor.setPrettyLogging(true);
            ClientProxy.getClient(client).getOutInterceptors().add(loggingOutInterceptor);
            loggingInInterceptor = new LoggingInInterceptor();
            loggingInInterceptor.setPrettyLogging(true);
            ClientProxy.getClient(client).getInInterceptors().add(loggingInInterceptor);
            wss4jOut = new WSS4JOutInterceptor(propsOut);
            ClientProxy.getClient(client).getOutInterceptors().add(wss4jOut);
            httpConduit = (HTTPConduit) ClientProxy.getClient(client).getConduit();
            tlsCP = new TLSClientParameters();
            tlsCP.setDisableCNCheck(true);
            httpConduit.setTlsClientParameters(tlsCP);
            port = ((ServicioIdentificacion) client);
            System.out.println("Invoking validar...");
            java.lang.String _validar_paramProducto = "3136";
            java.lang.String _validar_producto = "010";
            java.lang.String _validar_canal = "001";
            DatosValidacionRequest _validar_datosValidacion = new DatosValidacionRequest();
            IdentificacionRequest _validar_datosValidacionIdentificacion = new IdentificacionRequest();
            _validar_datosValidacionIdentificacion.setNumero("1020744259");
            _validar_datosValidacionIdentificacion.setTipo("1");
            _validar_datosValidacion.setIdentificacion(_validar_datosValidacionIdentificacion);
            _validar_datosValidacion.setPrimerApellido("Rey");
            _validar_datosValidacion.setNombres("Juan");
            FechaExpedicionRequest _validar_datosValidacionFechaExpedicion = new FechaExpedicionRequest();
            _validar_datosValidacionFechaExpedicion.setTimestamp("1187049600000");
            _validar_datosValidacion.setFechaExpedicion(_validar_datosValidacionFechaExpedicion);
            java.lang.String _validar__return = port.validar("ODAwODkyMzA=", _validar_paramProducto, _validar_producto, _validar_canal, _validar_datosValidacion);
            return _validar__return;
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

    }

    public String getPreguntas() {
        Map<String, Object> propsOut;
        Object client;
        LoggingOutInterceptor loggingOutInterceptor;
        LoggingInInterceptor loggingInInterceptor;
        WSS4JOutInterceptor wss4jOut;
        HTTPConduit httpConduit;
        ServicioIdentificacion port = null;
        TLSClientParameters tlsCP;
        try {
            System.setProperty("javax.net.ssl.trustStore", "C:\\certificados\\demo-servicesesb.jks");
            System.setProperty("javax.net.ssl.trustStorePassword", "experian");
            System.setProperty("javax.net.ssl.keyStore", "C:\\certificados\\demo-servicesesb.jks");
            System.setProperty("javax.net.ssl.keyStorePassword", "experian");

            System.setProperty("org.apache.cxf.stax.allowInsecureParser", "1");
            SignaturePwdClientCallBackHandler.certPassword = "experian";
            SignaturePwdClientCallBackHandler.password = "Puntored2019";
            propsOut = new HashMap<>();
            propsOut.put(WSHandlerConstants.USER, " 2-830513238"); //Usuario dado por Experian
            propsOut.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN + " " + WSHandlerConstants.TIMESTAMP + " " + WSHandlerConstants.SIGNATURE);
            propsOut.put(WSHandlerConstants.SIG_PROP_FILE, "META-INF/crypto.properties");
            propsOut.put(WSHandlerConstants.SIGNATURE_USER, "experian.sign");
            propsOut.put(WSHandlerConstants.ADD_UT_ELEMENTS, WSConstants.NONCE_LN + " " + WSConstants.CREATED_LN);
            propsOut.put(WSHandlerConstants.MUST_UNDERSTAND, "false");
            propsOut.put(WSHandlerConstants.SIGNATURE_PARTS, "{Content}{http://schemas.xmlsoap.org/soap/envelope/}Body;{Element}{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd}UsernameToken;{Element}{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd}Timestamp;");

            propsOut.put(WSHandlerConstants.SIG_KEY_ID, "DirectReference");
            propsOut.put(WSHandlerConstants.SIG_ALGO, "http://www.w3.org/2000/09/xmldsig#rsa-sha1");
            propsOut.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
            propsOut.put(WSHandlerConstants.PW_CALLBACK_CLASS, SignaturePwdClientCallBackHandler.class.getName());

            factory = new JaxWsProxyFactoryBean();
            factory.setAddress("https://demo-servicesesb.datacredito.com.co/wss/idws2/services/ServicioIdentificacionPlus"); //Endpoint del servicio
            factory.setServiceClass(ServicioIdentificacion.class);
            client = factory.create();

            loggingOutInterceptor = new LoggingOutInterceptor();
            loggingOutInterceptor.setPrettyLogging(true);
            ClientProxy.getClient(client).getOutInterceptors().add(loggingOutInterceptor);
            loggingInInterceptor = new LoggingInInterceptor();
            loggingInInterceptor.setPrettyLogging(true);
            ClientProxy.getClient(client).getInInterceptors().add(loggingInInterceptor);
            wss4jOut = new WSS4JOutInterceptor(propsOut);
            ClientProxy.getClient(client).getOutInterceptors().add(wss4jOut);
            httpConduit = (HTTPConduit) ClientProxy.getClient(client).getConduit();
            tlsCP = new TLSClientParameters();
            tlsCP.setDisableCNCheck(true);
            httpConduit.setTlsClientParameters(tlsCP);
            port = ((ServicioIdentificacion) client);
            System.out.println("Invoking preguntas...");
            java.lang.String _preguntas_idUsuarioEntidad = "ODAwODkyMzA=";
            java.lang.String _preguntas_paramProducto = "3136";
            java.lang.String _preguntas_producto = "010";
            java.lang.String _preguntas_canal = "001";
            SolicitudCuestionarioRequest _preguntas_solicitudCuestionario = new SolicitudCuestionarioRequest();
            _preguntas_solicitudCuestionario.setIdentificacion("1020744259");
            _preguntas_solicitudCuestionario.setTipoId("1");
            _preguntas_solicitudCuestionario.setRegValidacion(new BigInteger("5805928"));
            java.lang.String _preguntas__return = port.preguntas(_preguntas_idUsuarioEntidad, _preguntas_paramProducto, _preguntas_producto, _preguntas_canal, _preguntas_solicitudCuestionario);
            System.out.println("preguntas.result=" + _preguntas__return);
            return _preguntas__return;

        } catch (Idws2Exception_Exception e) {
            System.out.println("Expected exception: Idws2Exception has occurred.");
            System.out.println(e.toString());
            return "error";
        }

    }

    public String validarPreguntas() {
        Map<String, Object> propsOut;
        Object client;
        LoggingOutInterceptor loggingOutInterceptor;
        LoggingInInterceptor loggingInInterceptor;
        WSS4JOutInterceptor wss4jOut;
        HTTPConduit httpConduit;
        ServicioIdentificacion port = null;
        TLSClientParameters tlsCP;
        try {
            System.setProperty("javax.net.ssl.trustStore", "C:\\certificados\\demo-servicesesb.jks");
            System.setProperty("javax.net.ssl.trustStorePassword", "experian");
            System.setProperty("javax.net.ssl.keyStore", "C:\\certificados\\demo-servicesesb.jks");
            System.setProperty("javax.net.ssl.keyStorePassword", "experian");

            System.setProperty("org.apache.cxf.stax.allowInsecureParser", "1");
            SignaturePwdClientCallBackHandler.certPassword = "experian";
            SignaturePwdClientCallBackHandler.password = "Puntored2019";
            propsOut = new HashMap<>();
            propsOut.put(WSHandlerConstants.USER, " 2-830513238"); //Usuario dado por Experian
            propsOut.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN + " " + WSHandlerConstants.TIMESTAMP + " " + WSHandlerConstants.SIGNATURE);
            propsOut.put(WSHandlerConstants.SIG_PROP_FILE, "META-INF/crypto.properties");
            propsOut.put(WSHandlerConstants.SIGNATURE_USER, "experian.sign");
            propsOut.put(WSHandlerConstants.ADD_UT_ELEMENTS, WSConstants.NONCE_LN + " " + WSConstants.CREATED_LN);
            propsOut.put(WSHandlerConstants.MUST_UNDERSTAND, "false");
            propsOut.put(WSHandlerConstants.SIGNATURE_PARTS, "{Content}{http://schemas.xmlsoap.org/soap/envelope/}Body;{Element}{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd}UsernameToken;{Element}{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd}Timestamp;");

            propsOut.put(WSHandlerConstants.SIG_KEY_ID, "DirectReference");
            propsOut.put(WSHandlerConstants.SIG_ALGO, "http://www.w3.org/2000/09/xmldsig#rsa-sha1");
            propsOut.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
            propsOut.put(WSHandlerConstants.PW_CALLBACK_CLASS, SignaturePwdClientCallBackHandler.class.getName());

            factory = new JaxWsProxyFactoryBean();
            factory.setAddress("https://demo-servicesesb.datacredito.com.co/wss/idws2/services/ServicioIdentificacionPlus"); //Endpoint del servicio
            factory.setServiceClass(ServicioIdentificacion.class);
            client = factory.create();

            loggingOutInterceptor = new LoggingOutInterceptor();
            loggingOutInterceptor.setPrettyLogging(true);
            ClientProxy.getClient(client).getOutInterceptors().add(loggingOutInterceptor);
            loggingInInterceptor = new LoggingInInterceptor();
            loggingInInterceptor.setPrettyLogging(true);
            ClientProxy.getClient(client).getInInterceptors().add(loggingInInterceptor);
            wss4jOut = new WSS4JOutInterceptor(propsOut);
            ClientProxy.getClient(client).getOutInterceptors().add(wss4jOut);
            httpConduit = (HTTPConduit) ClientProxy.getClient(client).getConduit();
            tlsCP = new TLSClientParameters();
            tlsCP.setDisableCNCheck(true);
            httpConduit.setTlsClientParameters(tlsCP);
            port = ((ServicioIdentificacion) client);
            java.lang.String _verificar_idUsuarioEntidad = "";
            java.lang.String _verificar_producto = "";
            java.lang.String _verificar_paramProducto = "";
            RespuestasRequest _verificar_respuestas = new RespuestasRequest();
            _verificar_respuestas.setIdCuestionario("?");
            IdentificacionRequest identificacion = new IdentificacionRequest();
            identificacion.setTipo("1");
            identificacion.setNumero("1020744259");
            _verificar_respuestas.setIdentificacion(identificacion);
            _verificar_respuestas.setIdCuestionario("");
            _verificar_respuestas.setRegCuestionario("");
            java.lang.String _verificar__return = port.verificar(_verificar_idUsuarioEntidad, _verificar_producto, _verificar_paramProducto, _verificar_respuestas);
            System.out.println("verificar.result=" + _verificar__return);
            return _verificar__return;
        } catch (Idws2Exception_Exception e) {
            System.out.println("Expected exception: Idws2Exception has occurred.");
            System.out.println(e.toString());
            return "error";
        }

    }
}
