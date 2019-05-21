/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.holding.reconocerxsd;

import java.io.IOException;
import java.io.InputStream;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.io.CachedOutputStreamCallback;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

/**
 *
 * @author john
 */
public class CustomLoggingInterceptor extends AbstractPhaseInterceptor<Message> {

    public static String responseXml = "";

    public CustomLoggingInterceptor() {
        super(Phase.RECEIVE);
    }

    public void handleMessage(Message message) throws Fault {
        try {
            InputStream is = message.getContent(InputStream.class);
            CachedOutputStream bos = new CachedOutputStream();
            IOUtils.copy(is, bos);
            bos.flush();
            message.setContent(InputStream.class, bos.getInputStream());
            is.close();
            bos.registerCallback(new LoggingCallback());
            bos.close();
        } catch (IOException e) {
            System.out.println("ResponseInterceptor: handleMessage(): " + e.getMessage());
        }
    }

    private class LoggingCallback implements CachedOutputStreamCallback {

        public void onFlush(CachedOutputStream cos) {
        }

        public void onClose(CachedOutputStream cos) {
            try {
                StringBuilder builder = new StringBuilder();
                cos.writeCacheTo(builder);
                responseXml = builder.toString();
            } catch (Exception e) {
            }
        }
    }
}
