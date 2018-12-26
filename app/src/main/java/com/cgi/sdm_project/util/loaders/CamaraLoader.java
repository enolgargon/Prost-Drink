package com.cgi.sdm_project.util.loaders;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Camara;
import com.cgi.sdm_project.util.factories.FactoryParser;
import com.cgi.sdm_project.util.parsers.Parser;

public class CamaraLoader extends AbstractLoader<Camara> {
    @Override
    protected int getResXml() {
        return R.raw.camara;
    }

    @Override
    protected Parser<Camara> getParser() {
        return FactoryParser.getCamaraParser();
    }
}
