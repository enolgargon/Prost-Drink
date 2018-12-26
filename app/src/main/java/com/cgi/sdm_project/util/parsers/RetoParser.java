package com.cgi.sdm_project.util.parsers;

import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Reto;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class RetoParser implements Parser<List<Reto>>{
    @Override
    public List<Reto> execute(Document doc) {

        ArrayList<Reto> list = new ArrayList<>();
        Element raiz = doc.getDocumentElement();
        NodeList items = raiz.getElementsByTagName("item");

        for (int i = 0; i < items.getLength(); i++){
            Node node = items.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE){

                Element elemento = (Element) node;
                String valor = elemento.getAttribute("text");
                int numeroTragos = Integer.parseInt(elemento.getAttribute("tragos"));

                int hijosNodo = node.getChildNodes().getLength();
                Reto reto;

                if (hijosNodo > 0){
                    List<String> valores = new ArrayList<>();
                    for (int j = 0; j < node.getChildNodes().getLength(); j++) {
                        Node nodeAux = node.getChildNodes().item(j);

                        if (nodeAux.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementAux = (Element) nodeAux;
                            valores.add(elementAux.getAttribute("text"));
                        }
                    }
                    reto = new Reto(valor, numeroTragos, valores);
                }
                else
                    reto = new Reto(valor, numeroTragos);
                list.add(reto);
            }
        }
        return list;
    }
}
