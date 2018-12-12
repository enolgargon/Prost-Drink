package com.cgi.sdm_project.util.parsers;

import com.cgi.sdm_project.logica.juego.reglas.Juego;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class JuegosParser implements Parser<List<Juego>> {
    @Override
    public List<Juego> execute(Document doc) {

        ArrayList<Juego> list = new ArrayList<Juego>();

        Element raiz = doc.getDocumentElement();
        NodeList items = raiz.getElementsByTagName("item");

        for (int i = 0; i < items.getLength(); i++) {
            Node node = items.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE){

                Element elemento = (Element) node;
                String valor = elemento.getAttribute("text");
                int numeroTragos = Integer.parseInt(elemento.getAttribute("tragos"));

                Juego juego = new Juego(valor, numeroTragos);
                list.add(juego);
            }
        }
        return list;
    }
}
