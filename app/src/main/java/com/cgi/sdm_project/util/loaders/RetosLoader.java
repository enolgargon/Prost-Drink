package com.cgi.sdm_project.util.loaders;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Reto;
import com.cgi.sdm_project.util.factories.FactoryParser;
import com.cgi.sdm_project.util.parsers.Parser;

public class RetosLoader extends AbstractLoader<Reto> {
    @Override
    protected int getResXml() {
        return R.raw.retos;
    }

    @Override
    protected Parser<Reto> getParser() {
        return FactoryParser.getRetoParser();
    }
}
