package com.cgi.sdm_project.util;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.reglas.Camara;
import com.cgi.sdm_project.logica.juego.reglas.HastaQue;
import com.cgi.sdm_project.logica.juego.reglas.Pregunta;
import com.cgi.sdm_project.logica.juego.reglas.Reto;
import com.cgi.sdm_project.logica.juego.reglas.Trabalenguas;
import com.cgi.sdm_project.logica.juego.reglas.Votacion;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Loader {


    /**
     * Carga un xml desde la carpeta raw y devuelve un Document
     *
     * @param res de la carpeta raw
     * @return Document para enviar a los parsers
     */
    private static Document getXML(int res) {
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            return db.parse(AppSingleton.getInstance().getContext()
                    .getResources().openRawResource(res));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static List<Pregunta> loadPreguntas() {
        return FactoryParser.getPreguntaParser().execute(getXML(R.raw.preguntas));

        /*
        List<Pregunta> toRet = new ArrayList<>();
        toRet.add(new Pregunta("¿Te has o estás enamorado de un amigo/a?", 5));
        toRet.add(new Pregunta("¿Te liarías con alguien de la mesa?", 3));
        toRet.add(new Pregunta("¿Cuál ha sido el momento más caliente de tu vida?", 2));
        toRet.add(new Pregunta("¿Alguna vez te han atado o has atado a alguien a la cama?", 4));
        toRet.add(new Pregunta("¿Te has masturbado alguna vez delante de alguien? ¿De quién?", 3));
        return toRet;
        */
    }

    public static List<Reto> loadRetos() {
        return FactoryParser.getRetoParser().execute(getXML(R.raw.retos));
        /*
        List<Reto> toRet = new ArrayList<>();
        toRet.add(new Reto("Las tres personas que señales con el dedo beben", 3));
        toRet.add(new Reto("Quien tenga una prenda de color {0} bebe", 2,
                Arrays.asList("rojo", "verde", "azul", "negro", "blanco")));
        toRet.add(new Reto("Decir personajes de los Simpson. Quien repita pierde", 2));
        toRet.add(new Reto("Retuércete los pezones hasta que esten bien duritos", 4));
        toRet.add(new Reto("Los que hayan discutido en lo dos últimos días beben", 2));
        toRet.add(new Reto("Intenta poner caliente a la persona que más te guste de la mesa", 3));
        return toRet;
        */
    }

    public static List<Votacion> loadVotaciones() {

        return FactoryParser.getVotacionParser().execute(getXML(R.raw.votaciones));

        /*
        List<Votacion> toRet = new ArrayList<>();

        toRet.add(new Votacion(Arrays.asList("Ser invisible", "Leer la mente"),2));
        toRet.add(new Votacion(Arrays.asList("Morir congelado", "Morir quemado"),3));
        toRet.add(new Votacion(Arrays.asList("Beber un litro de orina cada día", "Una noche de sexo con tu madre"),3));
        toRet.add(new Votacion(Arrays.asList("Supositorio cada día", "Inyección cada día"),4));
        toRet.add(new Votacion(Arrays.asList("Saber que te han puesto los cuernos", "No enterarte nunca"),2));

        return toRet;
        */
    }

    public static List<HastaQue> loadHastaQues() {

        return FactoryParser.getHastaQueParser().execute(getXML(R.raw.hasta));

        /*
        List<HastaQue> toRet = new ArrayList<>();
        toRet.add(new HastaQue("Hasta que te vuelva a tocar tienes que hablar y moverte como un robot", 5));
        toRet.add(new HastaQue("Hasta que te vuelva a tocar te tienen que tratar de usted", 7));
        toRet.add(new HastaQue("Hasta que te vuelva a tocar tienes que estar sin camiseta", 3));
        toRet.add(new HastaQue("Hasta que te vuelva a tocar tienes que estar sentado/a encima de la persona que más te guste de la mesa", 4));
        return toRet;
        */
    }

    public static List<Trabalenguas> loadTrabalenguas(){

        return FactoryParser.getTrabalenguasParser().execute(getXML(R.raw.trabalenguas));

    }

    public static List<Camara> loadCamara() {
        List<Camara> toRet = new ArrayList<>();
        toRet.add(new Camara("Saca una foto al vaso después de acabartelo y compartela"));
        toRet.add(new Camara("Saca una foto a un amigo bebiendo y compartela"));
        return toRet;
    }
}
