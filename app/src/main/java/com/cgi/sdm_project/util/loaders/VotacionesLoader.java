package com.cgi.sdm_project.util.loaders;

import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Votacion;
import com.cgi.sdm_project.util.factories.FactoryParser;
import com.cgi.sdm_project.util.parsers.Parser;

public class VotacionesLoader extends AbstractLoader<Votacion> {
    @Override
    protected Parser<Votacion> getParser() {
        return FactoryParser.getVotacionParser();
    }
}
