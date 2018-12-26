package com.cgi.sdm_project.util.loaders;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Votacion;
import com.cgi.sdm_project.util.factories.FactoryParser;

import java.util.List;

public class VotacionesLoader extends AbstractLoader<Votacion> {
    @Override
    public List<Votacion> load() {
        return FactoryParser.getVotacionParser().execute(getXML(R.raw.votaciones));

        /*
        List<Votacion> toRet = new ArrayList<>();

        toRet.add(new Votacion(Arrays.asList("Ser invisible", "Leer la mente"),2));
        toRet.add(new Votacion(Arrays.asList("Morir congelado", "Morir quemado"),3));
        toRet.add(new Votacion(Arrays.asList("Beber un litro de orina cada día", "Una noche de sexo con tu madre"),3));
        toRet.add(new Votacion(Arrays.asList("Supositorio cada día", "Inyección cada día"),4));
        toRet.add(new Votacion(Arrays.asList("Saber que te han puesto los cuernos", "No enterarte nunca"),2));

        return toRet;
        */
    }
}
