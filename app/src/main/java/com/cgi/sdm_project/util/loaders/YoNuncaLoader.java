package com.cgi.sdm_project.util.loaders;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.YoNunca;
import com.cgi.sdm_project.util.factories.FactoryParser;
import com.cgi.sdm_project.util.parsers.Parser;

public class YoNuncaLoader extends AbstractLoader<YoNunca> {

    @Override
    protected int getResXml() {
        return R.raw.yonunca;
    }

    @Override
    protected Parser<YoNunca> getParser() {
        return FactoryParser.getYoNuncaParser();
    }
}
