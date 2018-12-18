package com.cgi.sdm_project.logica.juego.reglas;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.util.AppSingleton;

abstract class ReglaTragable implements Tragable {
    private final int tragos;

    ReglaTragable(int tragos) {
        this.tragos = tragos;
    }

    public int getTragos() {
        return tragos;
    }

    public String getResultado() {
        try {
            int resource = R.string.class.getField(nombreRespuesta()).getInt(R.string.class);
            return String.format(AppSingleton.getInstance().getContext().getString(resource), getTragos());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }

        return String.format(AppSingleton.getInstance().getContext().getString(R.string.resultado_generar), getTragos());
    }

    protected abstract String nombreRespuesta();
}
