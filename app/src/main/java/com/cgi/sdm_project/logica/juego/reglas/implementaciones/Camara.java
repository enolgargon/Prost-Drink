package com.cgi.sdm_project.logica.juego.reglas.implementaciones;

import com.cgi.sdm_project.logica.juego.reglas.ReglaTragable;

public class Camara extends ReglaTragable {
    private String texto;

    public Camara(String texto, int tragos) {
        super(tragos);
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    @Override
    protected String nombreRespuesta() {
        return "camara_resultado";
    }
}
