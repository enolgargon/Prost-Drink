package com.cgi.sdm_project.logica.juego.juego.selectores;

import com.cgi.sdm_project.logica.juego.juego.ISelectorRegla;
import com.cgi.sdm_project.logica.juego.reglas.Reglas;

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
    private List<Reglas> reglasValidas;

    public FilteredSelector(ISelectorRegla selectorRegla) {
        if (selectorRegla == null)
            throw new IllegalArgumentException("No se puede filtrar si no hay un selector para filtrar");
        this.selectorRegla = selectorRegla;
        this.reglasValidas = new LinkedList<>();
    }

    public boolean isValidConfiguration() {
        return reglasValidas.size() > 0;
    }

    public void active(Reglas regla) {
        if (regla == null)
            throw new IllegalArgumentException();
        reglasValidas.add(regla);
    }

    public void desactive(Reglas regla) {
        if (regla == null)
            throw new IllegalArgumentException();
        reglasValidas.remove(regla);
    }

    @Override
    public Reglas getSiguienteJuego() {
        Reglas regla = selectorRegla.getSiguienteJuego();
        return reglasValidas.contains(regla) ? regla : null;
    }
}
