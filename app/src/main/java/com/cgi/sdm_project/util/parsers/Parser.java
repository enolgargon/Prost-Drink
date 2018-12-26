package com.cgi.sdm_project.util.parsers;

import org.w3c.dom.Document;

import java.util.List;

/**
 * Interfaz que ofrecen los parsers a los clientes. La labor principal del parser es recibir un documento y convertirlo en una lista de objeteos
 *
 * @param <T> Tipo de objetos que se parsean y devuelven
 * @author Jorge Iturrioz y Enol García González
 * @version 26-12-2018
 */
public interface Parser<T> {

    /**
     * Método que ejecuta la acción fundamental del parser. Hace lo necesario para que a partir del documento que recibe se cree la lista que devuelve
     *
     * @param doc Documento con los datos a parsear
     * @return Lista de objetos obtenidos del documento
     */
    List<T> execute(Document doc);

}
