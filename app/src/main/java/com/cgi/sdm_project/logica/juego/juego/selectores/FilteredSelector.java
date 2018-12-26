package com.cgi.sdm_project.logica.juego.juego.selectores;

import com.cgi.sdm_project.logica.juego.juego.ISelectorRegla;
import com.cgi.sdm_project.logica.juego.reglas.Reglas;
import com.cgi.sdm_project.util.Conf;

/**
 * Selector de reglas que aplica un filtro sobre las reglas.
 *
 * @author Enol García González
 * @version 16-12-2018
 */
public class FilteredSelector implements ISelectorRegla {
    private ISelectorRegla selectorRegla;

    public FilteredSelector(ISelectorRegla selectorRegla) {
        if (selectorRegla == null)
            throw new IllegalArgumentException("No se puede filtrar si no hay un selector para filtrar");
        this.selectorRegla = selectorRegla;
    }

    public boolean isValidConfiguration() {
        for (Reglas regla : Reglas.values())
            if (Conf.getInstancia().getTipo(regla))
                return true;
        return false;
    }

    @Override
    public Reglas getSiguienteJuego() {
        Reglas regla = selectorRegla.getSiguienteJuego();
        return Conf.getInstancia().getTipo(regla) ? regla : null;
    }
}
