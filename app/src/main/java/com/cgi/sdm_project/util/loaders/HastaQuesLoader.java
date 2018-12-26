package com.cgi.sdm_project.util.loaders;

import com.cgi.sdm_project.logica.juego.reglas.implementaciones.HastaQue;
import com.cgi.sdm_project.util.factories.FactoryParser;
import com.cgi.sdm_project.util.parsers.Parser;

public class HastaQuesLoader extends AbstractLoader<HastaQue> {
    @Override
    protected Parser<HastaQue> getParser() {
        return FactoryParser.getHastaQueParser();
    }
}
