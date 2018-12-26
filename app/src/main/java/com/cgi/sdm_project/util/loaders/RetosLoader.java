package com.cgi.sdm_project.util.loaders;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Reto;
import com.cgi.sdm_project.util.factories.FactoryParser;

import java.util.List;

public class RetosLoader extends AbstractLoader<Reto> {

    @Override
    public List<Reto> load() {
        return FactoryParser.getRetoParser().execute(getXML(R.raw.retos));
        /*
        List<Reto> toRet = new ArrayList<>();
        toRet.add(new Reto("Las tres personas que señales con el dedo beben", 3));
        toRet.add(new Reto("Quien tenga una prenda de color {0} bebe", 2,
                Arrays.asList("rojo", "verde", "azul", "negro", "blanco")));
        toRet.add(new Reto("Decir personajes de los Simpson. Quien repita pierde", 2));
        toRet.add(new Reto("Retuércete los pezones hasta que esten bien duritos", 4));
        toRet.add(new Reto("Los que hayan discutido en lo dos últimos días beben", 2));
        toRet.add(new Reto("Intenta poner caliente a la persona que más te guste de la mesa", 3));
        return toRet;
        */
    }
}
