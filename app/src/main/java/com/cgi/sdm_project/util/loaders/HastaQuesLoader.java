package com.cgi.sdm_project.util.loaders;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.HastaQue;
import com.cgi.sdm_project.util.factories.FactoryParser;

import java.util.List;

public class HastaQuesLoader extends AbstractLoader<HastaQue> {
    @Override
    public List<HastaQue> load() {
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
}
