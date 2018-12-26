package com.cgi.sdm_project.util.loaders;

import com.cgi.sdm_project.util.singletons.AppSingleton;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

abstract class AbstractLoader<T> implements Loader<T> {
    /**
     * Carga un xml desde la carpeta raw y devuelve un Document
     *
     * @param res de la carpeta raw
     * @return Document para enviar a los parsers
     */
    static Document getXML(int res) {
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            return db.parse(AppSingleton.getInstance().getContext()
                    .getResources().openRawResource(res));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            return null;

        }
    }
}
