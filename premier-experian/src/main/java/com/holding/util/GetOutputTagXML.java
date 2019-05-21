/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.holding.util;

import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author john
 */
public class GetOutputTagXML {

    public static String extractText(String textToExtract, final String tag) throws ParserConfigurationException, SAXException, IOException {
        final StringBuilder buf = new StringBuilder();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(new InputSource(new StringReader(textToExtract)), new DefaultHandler() {
            private boolean captureText;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                this.captureText = qName.equals(tag);
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                this.captureText = false;
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if (this.captureText) {
                    buf.append(ch, start, length);
                }
            }
        });
        return buf.toString();
    }
}
