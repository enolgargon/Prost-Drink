package com.cgi.sdm_project.logica.juego.juego.selectores;

import com.cgi.sdm_project.logica.juego.juego.ISelectorRegla;

import java.util.LinkedList;
import java.util.List;

/**
 * Selector de reglas que aplica un filtro sobre las reglas.
 *
 * @author Enol García González
 * @version 16-12-2018
 */
public class FilteredSelector implements ISelectorRegla {
    private ISelectorRegla selectorRegla;
    private List<String> nombresValidos;

    public FilteredSelector(ISelectorRegla selectorRegla, List<String> nombresValidos) {
        if (selectorRegla == null)
            throw new IllegalArgumentException("No se puede filtrar si no hay un selector para filtrar");
        this.selectorRegla = selectorRegla;
        if (nombresValidos == null)
            this.nombresValidos = new LinkedList<>();
        else
            this.nombresValidos = new LinkedList<>(nombresValidos);
    }

    public boolean isValidConfiguration() {
        return nombresValidos.size() > 0;
    }

    public void active(String nombre) {
        if (nombre == null)
            throw new IllegalArgumentException();
        nombresValidos.add(nombre);
    }

    public void desactive(String nombre) {
        if (nombre == null)
            throw new IllegalArgumentException();
        nombresValidos.remove(nombre);
    }

    @Override
    public String getNombreSiguienteJuego() {
        String nombre = selectorRegla.getNombreSiguienteJuego();
        return nombresValidos.contains(nombre) ? nombre : null;
    }
}
