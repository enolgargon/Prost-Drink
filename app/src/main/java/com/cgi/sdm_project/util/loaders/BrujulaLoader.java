package com.cgi.sdm_project.util.loaders;

import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Brujula;

import java.util.LinkedList;
import java.util.List;

public class BrujulaLoader implements Loader<Brujula> {
    @Override
    public List<Brujula> load() {
        LinkedList<Brujula> lista = new LinkedList<>();
        lista.add(new Brujula());
        return lista;
    }
}
