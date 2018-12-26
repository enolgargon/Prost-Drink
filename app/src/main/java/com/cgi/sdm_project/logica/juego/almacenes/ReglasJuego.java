package com.cgi.sdm_project.logica.juego.almacenes;

import com.cgi.sdm_project.logica.juego.reglas.Regla;
import com.cgi.sdm_project.logica.juego.reglas.Reglas;

import java.util.HashMap;
import java.util.Objects;

public class ReglasJuego {
    private static ReglasJuego instance;

    private HashMap<Reglas, AlmacenReglas> almacenes;

    private ReglasJuego() {
        cargarReglas();
    }

    public static ReglasJuego getInstance() {
        if (instance == null)
            instance = new ReglasJuego();
        return instance;
    }

    private void cargarReglas() {
        for (Reglas regla : Reglas.values())
            try {
                AlmacenReglas almacen = new AlmacenReglas();
                almacen.load(regla.loader().newInstance());
                almacenes.put(regla, new AlmacenReglas());
            } catch (IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
    }

    public Regla get(Reglas regla) {
        return (Regla) Objects.requireNonNull(almacenes.get(regla)).get();
    }
}
