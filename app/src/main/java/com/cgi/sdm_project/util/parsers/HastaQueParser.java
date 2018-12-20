package com.cgi.sdm_project.util.parsers;

import com.cgi.sdm_project.logica.juego.reglas.HastaQue;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class HastaQueParser implements Parser<List<HastaQue>>{

    @Override
    public List<HastaQue> execute(Document doc) {

        ArrayList<HastaQue> list = new ArrayList<>();

        Element raiz = doc.getDocumentElement();
        NodeList items = raiz.getElementsByTagName("item");

        for (int i = 0; i < items.getLength(); i++){
            Node node = items.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE){

                Element elemento = (Element) node;
                String valor = elemento.getAttribute("text");
                int numeroTurnos = Integer.parseInt(elemento.getAttribute("turnos"));
                HastaQue hasta = new HastaQue(valor, numeroTurnos);
                list.add(hasta);

            }
        }

        return list;
    }
}
