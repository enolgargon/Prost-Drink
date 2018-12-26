package com.cgi.sdm_project.util.loaders;

import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Equilibrio;

import java.util.LinkedList;
import java.util.List;

public class EquilibrioLoader implements Loader<Equilibrio> {
    @Override
    public List<Equilibrio> load() {
        LinkedList<Equilibrio> lista = new LinkedList<>();
        lista.add(new Equilibrio());
        return lista;
    }
}
