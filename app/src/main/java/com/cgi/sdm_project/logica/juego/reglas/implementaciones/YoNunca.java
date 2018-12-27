package com.cgi.sdm_project.logica.juego.reglas.implementaciones;

import com.cgi.sdm_project.logica.juego.reglas.ReglaTragable;

public class YoNunca extends ReglaTragable {

    private String texto;

    public YoNunca(String texto, int tragos) {
        super(tragos);
        this.texto = texto;
    }

    public String getTexto(){ return texto; }

    @Override
    protected String nombreRespuesta() {
        //TODO Crear strings diferentes para que el texto no sea siempre el mismo
        return "yo_nunca" + ((int) (Math.random() * 3) + 1);
    }
}