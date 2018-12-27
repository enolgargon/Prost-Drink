package com.cgi.sdm_project.util.loaders;

import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Cartas;

import java.util.LinkedList;
import java.util.List;

public class CartasLoader implements Loader<Cartas> {
    @Override
    public List<Cartas> load() {
        List<Cartas> lista = new LinkedList<>();
        lista.add(new Cartas(3));
        return lista;
    }
}
