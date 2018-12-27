package com.cgi.sdm_project.util.loaders;

import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Memoria;

import java.util.LinkedList;
import java.util.List;

public class MemoriaLoader implements Loader<Memoria> {

    @Override
    public List<Memoria> load() {
        List<Memoria> list = new LinkedList<>();
        list.add(new Memoria(3));
        return list;
    }
}
