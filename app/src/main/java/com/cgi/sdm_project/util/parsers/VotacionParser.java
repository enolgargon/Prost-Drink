package com.cgi.sdm_project.util.parsers;

import com.cgi.sdm_project.logica.juego.reglas.Votacion;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class VotacionParser implements Parser<List<Votacion>>{
    @Override
    public List<Votacion> execute(Document doc) {


        ArrayList<Votacion> list = new ArrayList<>();

        Element raiz = doc.getDocumentElement();
        NodeList items = raiz.getElementsByTagName("item");

        for (int i = 0; i < items.getLength(); i++) {
            Node node = items.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE){
                Element elemento = (Element) node;
                int numeroTragos = Integer.parseInt(elemento.getAttribute("tragos"));
                String texto = elemento.getAttribute("text");


                List<String> valores = new ArrayList<>();
                for (int j = 0; j < node.getChildNodes().getLength(); j++){

                    Node nodeAux = node.getChildNodes().item(j);
                    if (nodeAux.getNodeType() == Node.ELEMENT_NODE) {
                        Element elementAux = (Element) nodeAux;
                        valores.add(elementAux.getAttribute("text"));
                    }
                }
                Votacion votacion = new Votacion(valores, numeroTragos, texto);
                list.add(votacion);
            }
        }
        return list;
    }
}
