package com.cgi.sdm_project.util.loaders;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Pregunta;
import com.cgi.sdm_project.util.factories.FactoryParser;

import java.util.List;

public class PreguntasLoader extends AbstractLoader<Pregunta> {
    @Override
    public List<Pregunta> load() {
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
}
