/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.holding.testdatacredito;

import java.io.IOException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.ws.security.WSPasswordCallback;

/**
 *
 * @author GCOCOL0245
 */
public class SignaturePwdClientCallBackHandler implements CallbackHandler {
    
    public static String password;
    
    public static String certPassword;
    
    @Override
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {

		for (int i = 0; i < callbacks.length; i++) {
			if (callbacks[i] instanceof WSPasswordCallback) {
				WSPasswordCallback pc = (WSPasswordCallback) callbacks[i];
				
				if(pc.getUsage() == WSPasswordCallback.DECRYPT ||
	                    pc.getUsage() == WSPasswordCallback.SIGNATURE){
					pc.setPassword(certPassword);
				}else if (pc.getUsage() == WSPasswordCallback.USERNAME_TOKEN) {
					pc.setPassword(password); //Clave asignada al usuario dado por experian
				}
					
			} else {
				throw new UnsupportedCallbackException(callbacks[i],
						"Unrecognized Callback");
			}
		}
	}
    
}
