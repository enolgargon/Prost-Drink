package com.cgi.sdm_project.logica.juego.almacenes;

import com.cgi.sdm_project.util.loaders.Loader;

import java.util.List;

class AlmacenReglas<T> {
    private List<T> elementos;

    void load(Loader<T> loader) {
        elementos = loader.load();
    }

    T get() {
        return elementos.get((int) (Math.random() * (elementos.size())));
    }
}
