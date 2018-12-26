package com.cgi.sdm_project.util.loaders;

import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Camara;

import java.util.ArrayList;
import java.util.List;

public class CamaraLoader extends AbstractLoader<Camara> {
    @Override
    public List<Camara> load() {
        List<Camara> toRet = new ArrayList<>();
        toRet.add(new Camara("Saca una foto al vaso después de acabartelo y compartela"));
        toRet.add(new Camara("Saca una foto a un amigo bebiendo y compartela"));
        return toRet;
    }
}
