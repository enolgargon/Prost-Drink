package com.cgi.sdm_project.util.loaders;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Trabalenguas;
import com.cgi.sdm_project.util.factories.FactoryParser;

import java.util.List;

public class TrabalenguasLoader extends AbstractLoader<Trabalenguas> {

    @Override
    public List<Trabalenguas> load() {
        return FactoryParser.getTrabalenguasParser().execute(getXML(R.raw.trabalenguas));
    }
}
