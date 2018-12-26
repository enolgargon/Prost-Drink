package com.cgi.sdm_project.util.loaders;

import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Trabalenguas;
import com.cgi.sdm_project.util.factories.FactoryParser;
import com.cgi.sdm_project.util.parsers.Parser;

public class TrabalenguasLoader extends AbstractLoader<Trabalenguas> {
    @Override
    protected Parser<Trabalenguas> getParser() {
        return FactoryParser.getTrabalenguasParser();
    }
}
