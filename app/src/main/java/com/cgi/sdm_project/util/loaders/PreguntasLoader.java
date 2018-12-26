package com.cgi.sdm_project.util.loaders;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Pregunta;
import com.cgi.sdm_project.util.factories.FactoryParser;
import com.cgi.sdm_project.util.parsers.Parser;

public class PreguntasLoader extends AbstractLoader<Pregunta> {
    @Override
    protected int getResXml() {
        return R.raw.preguntas;
    }

    @Override
    protected Parser<Pregunta> getParser() {
        return FactoryParser.getPreguntaParser();
    }
}
