package com.cgi.sdm_project.util.loaders;

import com.cgi.sdm_project.logica.juego.reglas.Regla;
import com.cgi.sdm_project.util.parsers.Parser;
import com.cgi.sdm_project.util.singletons.AppSingleton;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Clase abstracta que facilita la labor de crear loaders. Carga un documento desde un xml para poder usar luego un parser
 *
 * @param <T> Tipo de regla que se carga
 * @author Samuel Cifuentes y Enol García González
 * @version 26-12-2018
 */
abstract class AbstractLoader<T extends Regla> implements Loader<T> {
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

    @Override
    public List<T> load() {
        return null;
    }

    protected abstract Parser<T> getParser();
}
