package com.cgi.sdm_project.util.loaders;

import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Cazatopos;

import java.util.LinkedList;
import java.util.List;

public class CazatoposLoader implements Loader<Cazatopos> {
    @Override
    public List<Cazatopos> load() {
        LinkedList<Cazatopos> lista = new LinkedList<>();
        lista.add(new Cazatopos());
        return lista;
    }
}
