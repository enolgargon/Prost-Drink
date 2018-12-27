package com.cgi.sdm_project.util.parsers;

import com.cgi.sdm_project.logica.juego.reglas.implementaciones.YoNunca;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class YoNuncaParser implements Parser<YoNunca> {


    @Override
    public List<YoNunca> execute(Document doc) {

        ArrayList<YoNunca> list = new ArrayList<>();

        Element raiz = doc.getDocumentElement();
        NodeList items = raiz.getElementsByTagName("item");

        for (int i = 0; i < items.getLength(); i++) {
            Node node = items.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element elemento = (Element) node;
                String valor = elemento.getAttribute("text");
                int numeroTragos = Integer.parseInt(elemento.getAttribute("tragos"));
                YoNunca yoNunca = new YoNunca(valor, numeroTragos);
                list.add(yoNunca);
            }
        }
        return list;
    }
}
